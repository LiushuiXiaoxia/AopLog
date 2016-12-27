# AopLog

---

仿[Hugo](https://github.com/JakeWharton/hugo)写了一个AopLog，自己使用。


# Usage

[![](https://jitpack.io/v/LiushuiXiaoxia/AopLog.svg)](https://jitpack.io/#LiushuiXiaoxia/AopLog)


**Step 1. Add the dependency**

```sh
buildscript {
    repositories {
        jcenter()
        mavenCentral()
        //        mavenLocal()
        // NO.1
        maven { url 'https://jitpack.io' }
    }
    dependencies {
        // NO.2
        classpath "com.github.LiushuiXiaoxia.AopLog:aoplog-plugin:${lastversion}"
    }
}

repositories {
    // NO.3
    maven { url 'https://jitpack.io' }
}

dependencies {
    // NO.4
    compile "com.github.LiushuiXiaoxia.AopLog:aoplog-lib:${lastversion}"
}

// NO.5
apply plugin: 'cn.mycommons.aoplog'
aoplog {
    enabled = true // default is true
}
```

**Step 2. Set up**

Set up AopLogCallback, just implements `AopLog.OnLogCallback` and handle log yourself.

```java
public class AppContext extends Application {

    private static final String TAG = "AopDemo";

    static {
        AopLog.setLogCallback(new AopLog.OnLogCallback() {
            @Override
            public void log(Class clazz, String msg) {
                Log.e(TAG, msg);
            }
        });
    }

    @LogTraceMethod
    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @LogTraceMethod
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @LogTraceMethod
            @Override
            public void onActivityStarted(Activity activity) {

            }

            @LogTraceMethod
            @Override
            public void onActivityResumed(Activity activity) {

            }

            @LogTraceMethod
            @Override
            public void onActivityPaused(Activity activity) {

            }

            @LogTraceMethod
            @Override
            public void onActivityStopped(Activity activity) {

            }

            @LogTraceMethod
            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @LogTraceMethod
            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
```

# Other

`@LogTraceMethod` support simple attribute，default is true, it is simple log, otherwise is detail log.

```java
    @LogTraceMethod(simple = false)
    void method(){

    }

    @LogTraceMethod(simple = true)
    void method(){

    }
```