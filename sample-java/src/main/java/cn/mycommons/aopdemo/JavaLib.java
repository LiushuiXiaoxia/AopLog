package cn.mycommons.aopdemo;

import cn.mycommons.aoplog.LogTraceMethod;

public class JavaLib {

    @LogTraceMethod
    public void function() {
        System.out.println("function....");
    }

    public void test() {
        System.out.println("test....");
    }
}