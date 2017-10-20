package com.disco.man.discogman.features.login.dagger.components;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.dagger.modules.LoginActivityModule;
import com.disco.man.discogman.features.login.dagger.modules.LoginActivityServiceModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Dagger SubComponent for {@link LoginActivity}
 */

@ActivityScope
@Subcomponent(modules = {LoginActivityModule.class, LoginActivityServiceModule.class})
public interface LoginActivitySubComponent extends AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<LoginActivity> {
    }

}
