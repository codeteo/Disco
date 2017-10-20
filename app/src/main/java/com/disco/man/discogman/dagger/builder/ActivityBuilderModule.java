package com.disco.man.discogman.dagger.builder;

import android.app.Activity;

import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.dagger.components.MainActivitySubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainActivitySubComponent.class)
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

}