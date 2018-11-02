package bwie.example.com.day03test;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import bwie.example.com.day03test.utils.SqlLiteUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
