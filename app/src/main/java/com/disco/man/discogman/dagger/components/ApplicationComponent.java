package com.disco.man.discogman.dagger.components;

import com.disco.man.discogman.MyApplication;
import com.disco.man.discogman.dagger.builder.ActivityBuilderModule;
import com.disco.man.discogman.dagger.modules.ApplicationModule;
import com.disco.man.discogman.dagger.modules.NetworkModule;
import com.disco.man.discogman.features.main.dagger.modules.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Dagger Component builds all dependencies with application scope.
 */

@Singleton
@Component( modules = {
        AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        MainActivityModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();
    }

}