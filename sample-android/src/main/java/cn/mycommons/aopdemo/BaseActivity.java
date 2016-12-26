package cn.mycommons.aopdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.mycommons.aoplog.LogTraceMethod;

/**
 * BaseActivity <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
public class BaseActivity extends AppCompatActivity {

    @LogTraceMethod(simple = false)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @LogTraceMethod(simple = false)
    @Override
    protected void onStart() {
        super.onStart();
    }

    @LogTraceMethod(simple = false)
    @Override
    protected void onResume() {
        super.onResume();
    }

    @LogTraceMethod(simple = false)
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @LogTraceMethod(simple = false)
    @Override
    protected void onPause() {
        super.onPause();
    }

    @LogTraceMethod(simple = false)
    @Override
    protected void onStop() {
        super.onStop();
    }


    @LogTraceMethod(simple = false)
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}