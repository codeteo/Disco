package com.disco.man.discogman.dagger.components;

import com.disco.man.discogman.MyApplication;
import com.disco.man.discogman.dagger.builder.ActivityBuilderModule;
import com.disco.man.discogman.dagger.modules.ApplicationModule;
import com.disco.man.discogman.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Dagger Component builds all dependencies with application scope.
 */

@Singleton
@Component( modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class,
        NetworkModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();
    }

}