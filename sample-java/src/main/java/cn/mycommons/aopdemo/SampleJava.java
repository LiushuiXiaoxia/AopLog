package cn.mycommons.aopdemo;

import cn.mycommons.aoplog.AopLog;

/**
 * SampleJava <br/>
 * Created by xiaqiulei on 2016-12-26.
 */
public class SampleJava {

    public static void main(String[] args) {
        AopLog.setLogCallback(new AopLog.OnLogCallback() {
            @Override
            public void log(Class clazz, String msg) {
                System.out.println(clazz.getSimpleName() + "-->" + msg);
            }
        });

        new JavaLib().function();
    }
}