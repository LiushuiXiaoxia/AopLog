package cn.mycommons.aopdemo;

import android.os.Bundle;

import com.example.JavaLib;

import java.util.Random;

import cn.mycommons.aoplog.LogTraceMethod;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        testAnnotatedMethod(1, "a");
        testAnnotatedMethod2();

        new JavaLib().function();
    }

    @LogTraceMethod
    private boolean testAnnotatedMethod(int i, String s) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextBoolean();
    }

    @LogTraceMethod
    private void testAnnotatedMethod2() {
        boolean b = new Random().nextBoolean();
        if (b) {
//            throw new RuntimeException("test exception.");
        }
    }
}