package cn.mycommons.aoplog.library;

import java.util.concurrent.TimeUnit;

/**
 * Watch <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
class Watch {

    private long startTime;
    private long endTime;
    private long elapsedTime;

    private void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }

    void start() {
        reset();
        startTime = System.currentTimeMillis();
    }

    void stop() {
        if (startTime != 0) {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
        } else {
            reset();
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    long getTotalTime() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toMillis(endTime - startTime) : 0;
    }
}