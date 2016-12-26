package cn.mycommons.aopdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import cn.mycommons.aoplog.AopLog;
import cn.mycommons.aoplog.LogTraceMethod;

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
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