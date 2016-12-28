package cn.mycommons.aoplog.library;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;

/**
 * ProcessImpl <br/>
 * Created by xiaqiulei on 2016-12-28.
 */
class ProcessImpl implements IProcess {

    private final Class<? extends Annotation> annotationClass;

    ProcessImpl(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @Override
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        final LogTraceEntry entry = new LogTraceEntry(annotationClass);
        entry.object = joinPoint.getThis();
        entry.methodName = methodSignature.getName();
        entry.parameterNames = methodSignature.getParameterNames();
        entry.args = joinPoint.getArgs();
        entry.declaringTypeName = methodSignature.getDeclaringType().getSimpleName();

        entry.fileName = joinPoint.getSourceLocation().getFileName();
        entry.lineNum = joinPoint.getSourceLocation().getLine();

        final Watch watch = new Watch();
        watch.start();
        try {
            Object obj = joinPoint.proceed();
            entry.result = obj;
            return obj;
        } catch (Exception e) {
            watch.stop();
            entry.throwable = e;
            throw e;
        } finally {
            watch.stop();
            entry.beginTime = watch.getStartTime();
            entry.endTime = watch.getEndTime();
            entry.totalTime = watch.getTotalTime();
            AopLog.getLogCallback().log(entry);
        }
    }
}