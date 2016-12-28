package cn.mycommons.aoplog.library;


/**
 * AopLog <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
public class AopLog {

    public interface OnLogCallback {

        void log(LogTraceEntry entry);
    }

    private static final OnLogCallback EMPTY = new OnLogCallback() {

        @Override
        public void log(LogTraceEntry entry) {

        }
    };

    private static OnLogCallback logCallback = EMPTY;
    private static boolean enable = false;

    public static void setEnable(boolean enable) {
        AopLog.enable = enable;
    }

    public static void setLogCallback(OnLogCallback logCallback) {
        AopLog.logCallback = logCallback;
    }

    static OnLogCallback getLogCallback() {
        return logCallback == null ? EMPTY : logCallback;
    }

    public static boolean isEnable() {
        return enable;
    }
}