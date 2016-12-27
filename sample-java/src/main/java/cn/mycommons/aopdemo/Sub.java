package cn.mycommons.aopdemo;

import cn.mycommons.aoplog.LogTraceMethod;

public class Sub extends Base {

    @LogTraceMethod(simple = false)
    @Override
    public void function(int param) {
        super.function(param);
        System.out.println("sub.function.....");
    }

    @LogTraceMethod
    public void sub() {
        System.out.println("sub....");
    }
}