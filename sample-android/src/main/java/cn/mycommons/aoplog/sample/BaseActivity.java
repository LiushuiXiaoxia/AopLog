package cn.mycommons.aoplog.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.mycommons.aoplog.library.LogTraceMethod;

/**
 * BaseActivity <br/>
 * Created by xiaqiulei on 2016-12-19.
 */
public class BaseActivity extends AppCompatActivity {

    @LogTraceMethod
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @LogTraceMethod
    @Override
    protected void onStart() {
        super.onStart();
    }

    @LogTraceMethod
    @Override
    protected void onResume() {
        super.onResume();
    }

    @LogTraceMethod
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @LogTraceMethod
    @Override
    protected void onPause() {
        super.onPause();
    }

    @LogTraceMethod
    @Override
    protected void onStop() {
        super.onStop();
    }


    @LogTraceMethod
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}