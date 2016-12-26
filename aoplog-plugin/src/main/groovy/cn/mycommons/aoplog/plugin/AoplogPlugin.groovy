package cn.mycommons.aoplog.plugin

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.aspectj.bridge.IMessage
import org.aspectj.bridge.MessageHandler
import org.aspectj.tools.ajc.Main
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.tasks.compile.JavaCompile

class AoplogPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        final def log = project.logger

        def hasJava = project.plugins.withType(JavaPlugin)
        def hasApp = project.plugins.withType(AppPlugin)
        def hasLib = project.plugins.withType(LibraryPlugin)

        if (!hasJava && !hasApp && !hasLib) {
            throw new IllegalStateException("'java' or 'android' or 'android-library' plugin required.")
        }

        project.extensions.create('aoplog', AoplogExtension)

        if (hasApp || hasLib) {
            final def variants
            if (hasApp) {
                variants = project.android.applicationVariants
            } else {
                variants = project.android.libraryVariants
            }
            variants.all { variant ->
                if (!variant.buildType.isDebuggable()) {
                    log.info("Skipping non-debuggable build type '${variant.buildType.name}'.")
                } else if (!project.aoplog.enabled) {
                    log.info("Aoplog is not disabled.")
                } else {
                    JavaCompile javaCompile = variant.javaCompile
                    ajcRun(project, javaCompile, true)
                }
            }
        } else if (hasJava) {
            if (project.aoplog.enabled) {
                ajcRun(project, project.compileJava, false)
            } else {
                log.info("Aoplog is not disabled.")
            }
        }
    }

    static void ajcRun(project, compileJava, isAndroid) {
        final def log = project.logger
        compileJava.doLast {
            def argsList = new ArrayList();
            argsList.add("-showWeaveInfo")
            argsList.add("-1.5")
            argsList.add("-inpath")
            argsList.add(compileJava.destinationDir.toString())
            argsList.add("-aspectpath")
            argsList.add(compileJava.classpath.asPath)
            argsList.add("-d")
            argsList.add(compileJava.destinationDir.toString())
            argsList.add("-classpath")
            argsList.add(compileJava.classpath.asPath)
            if (isAndroid) {
                argsList.add("-bootclasspath")
                argsList.add(project.android.bootClasspath.join(File.pathSeparator))
            }

            String[] args = argsList.toArray(new String[argsList.size()])

            log.error ":aoplog:ajc args: " + Arrays.toString(args)

            def handler = new MessageHandler(true);
            new Main().run(args, handler)

            for (message in handler.getMessages(null, true)) {
                switch (message.getKind()) {
                    case IMessage.WARNING:
                    case IMessage.INFO:
                    case IMessage.DEBUG:
                        log.debug ":aoplog:aspectj:" + message.message, message.thrown
                        break;
                    case IMessage.ABORT:
                    case IMessage.ERROR:
                    case IMessage.FAIL:
                        log.error ":aoplog:aspectj:" + message.message, message.thrown
                        break;
                }
            }
        }
    }
}