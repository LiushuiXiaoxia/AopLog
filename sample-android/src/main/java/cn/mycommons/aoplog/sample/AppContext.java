package cn.mycommons.aoplog.sample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import cn.mycommons.aopdemo.BuildConfig;
import cn.mycommons.aoplog.library.AopLog;
import cn.mycommons.aoplog.library.LogTraceEntry;
import cn.mycommons.aoplog.library.LogTraceMethod;


/**
 * AppContext <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
public class AppContext extends Application {

    private static final String TAG = "AopDemo";

    static {
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