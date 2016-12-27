package cn.mycommons.aopdemo;

import cn.mycommons.aoplog.LogTraceMethod;

/**
 * Base <br/>
 * Created by xiaqiulei on 2016-12-27.
 */
public class Base {

    @LogTraceMethod
    public void base(String param) {
        System.out.println("base.....");
    }

    @LogTraceMethod
    public void function(int param) {
        System.out.println("base.function.....");
    }
}