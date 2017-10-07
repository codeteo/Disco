package com.disco.man.discogman;

import android.app.Application;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Main entry point of the app.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }
}
