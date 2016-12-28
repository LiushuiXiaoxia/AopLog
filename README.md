# AopLog

---

仿[Hugo](https://github.com/JakeWharton/hugo)写了一个AopLog，自己使用。


# Usage

[![](https://jitpack.io/v/LiushuiXiaoxia/AopLog.svg)](https://jitpack.io/#LiushuiXiaoxia/AopLog)


**Step 1. Add the dependency**

Add [gradle_plugin_android_aspectjx](https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx)

```sh
buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        // NO.1
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:1.0.8'
    }
}

apply plugin: 'com.android.application'
// NO.2
apply plugin: 'com.hujiang.android-aspectjx'

dependencies {
    // NO.3
    compile 'com.github.LiushuiXiaoxia:AopLog:${lastversion}'
}
```

**Step 2. Set up**

Set up AopLogCallback, just implements `AopLog.OnLogCallback` and handle log yourself.

```java
public class AppContext extends Application {

    private static final String TAG = "AopDemo";

    static {
        // defalut is false
        AopLog.setEnable(BuildConfig.DEBUG);
        AopLog.setLogCallback(new AopLog.OnLogCallback() {
            @Override
            public void log(LogTraceEntry entry) {
                if (entry != null) {
                    Log.e(TAG, entry.getLogTraceMessage());
                }
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

result log:

```
cn.mycommons.aoplog.AppContext$2@33395f2--->onActivityPaused()
activity = cn.mycommons.aoplog.MainActivity@6ec84a7
return = null
totalTime = 0
cn.mycommons.aoplog.MainActivity@6ec84a7--->BaseActivity.onPause()
return = null
totalTime = 0
cn.mycommons.aoplog.AppContext$2@33395f2--->onActivityResumed()
activity = cn.mycommons.aoplog.MainActivity@6ec84a7
return = null
totalTime = 0
cn.mycommons.aoplog.MainActivity@6ec84a7--->BaseActivity.onResume()
return = null
totalTime = 0
cn.mycommons.aoplog.AppContext$2@33395f2--->onActivityPaused()
activity = cn.mycommons.aoplog.MainActivity@6ec84a7
return = null
totalTime = 0
cn.mycommons.aoplog.MainActivity@6ec84a7--->BaseActivity.onPause()
return = null
totalTime = 0
cn.mycommons.aoplog.AppContext$2@33395f2--->onActivitySaveInstanceState()
activity = cn.mycommons.aoplog.MainActivity@6ec84a7
bundle = Bundle[{android:viewHierarchyState=Bundle[{android:views={16908290=android.view.AbsSavedState$1@c5e45b4, 2131427395=android.view.AbsSavedState$1@c5e45b4, 2131427396=android.view.AbsSavedState$1@c5e45b4, 2131427397=android.support.v7.widget.Toolbar$SavedState@a98b5dd, 2131427398=android.view.AbsSavedState$1@c5e45b4, 2131427412=android.view.AbsSavedState$1@c5e45b4}}]}]
return = null
totalTime = 0
cn.mycommons.aoplog.AppContext$2@33395f2--->onActivityStopped()
activity = cn.mycommons.aoplog.MainActivity@6ec84a7
return = null
totalTime = 0
cn.mycommons.aoplog.MainActivity@6ec84a7--->BaseActivity.onStop()
return = null
totalTime = 0
```

# Other

`@LogTraceEntry` support some runtime info, you can also handle log message.