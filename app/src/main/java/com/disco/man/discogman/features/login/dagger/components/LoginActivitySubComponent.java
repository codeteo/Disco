package com.disco.man.discogman.features.login.dagger.components;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.dagger.modules.GetAccessTokenUseCaseModule;
import com.disco.man.discogman.features.login.dagger.modules.GetRequestTokenUseCaseModule;
import com.disco.man.discogman.features.login.dagger.modules.LoginActivityModule;
import com.disco.man.discogman.features.login.dagger.modules.LoginServiceModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Dagger SubComponent for {@link LoginActivity}
 */

@ActivityScope
@Subcomponent(modules = {
        LoginActivityModule.class,
        LoginServiceModule.class,
        GetAccessTokenUseCaseModule.class,
        GetRequestTokenUseCaseModule.class
})
public interface LoginActivitySubComponent extends AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LoginActivity> {
    }

}
