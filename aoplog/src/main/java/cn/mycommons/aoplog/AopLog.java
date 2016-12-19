package cn.mycommons.aoplog;

import android.support.annotation.NonNull;

/**
 * AopLog <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
public class AopLog {

    public interface OnLogCallback {

        void log(Class clazz, String msg);
    }

    private static final OnLogCallback EMPTY = new OnLogCallback() {

        @Override
        public void log(Class clazz, String msg) {

        }
    };

    private static OnLogCallback logCallback = EMPTY;

    public static void setLogCallback(OnLogCallback logCallback) {
        AopLog.logCallback = logCallback;
    }

    @NonNull
    static OnLogCallback getLogCallback() {
        return logCallback == null ? EMPTY : logCallback;
    }
}