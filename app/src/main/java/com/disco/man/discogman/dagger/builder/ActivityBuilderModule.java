package com.disco.man.discogman.dagger.builder;

import android.app.Activity;

import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.dagger.components.LoginActivitySubComponent;
import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.dagger.components.MainActivitySubComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LoginActivitySubComponent.class, MainActivitySubComponent.class})
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(LoginActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindLoginActivityInjectorFactory(LoginActivitySubComponent.Builder builder);

}