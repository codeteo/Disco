package com.disco.man.discogman.dagger.builder;

import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.dagger.modules.GetAccessTokenUseCaseModule;
import com.disco.man.discogman.features.login.dagger.modules.GetRequestTokenUseCaseModule;
import com.disco.man.discogman.features.login.dagger.modules.LoginActivityModule;
import com.disco.man.discogman.features.login.dagger.modules.LoginServiceModule;
import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.dagger.MainActivityModule;
import com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules.WantlistFragmentBuilder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, WantlistFragmentBuilder.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {
            LoginActivityModule.class,
            LoginServiceModule.class,
            GetAccessTokenUseCaseModule.class,
            GetRequestTokenUseCaseModule.class})
    abstract LoginActivity providesLoginActivity();

}