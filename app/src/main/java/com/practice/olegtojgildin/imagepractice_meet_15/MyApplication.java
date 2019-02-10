package com.practice.olegtojgildin.imagepractice_meet_15;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by olegtojgildin on 10/02/2019.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
