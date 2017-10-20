package com.disco.man.discogman;

import android.app.Activity;
import android.app.Application;

import com.disco.man.discogman.dagger.components.ApplicationComponent;
import com.disco.man.discogman.dagger.components.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Main entry point of the app.
 */

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }

        initDagger();
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();

        applicationComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
