package com.disco.man.discogman.features.login.dagger.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.features.login.LoginActivity;
import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.features.login.LoginViewModel;
import com.disco.man.discogman.utils.ViewModelProviderFactory;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module providing dependencies for {@link LoginActivity}'s ViewModel.
 */

@Module
public class LoginActivityModule {

    @Provides
    @ActivityScope
    LoginViewModel providesLoginViewModel(LoginService service, BaseSchedulerProvider schedulerProvider) {
        return new LoginViewModel(service, schedulerProvider);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesLoginViewModelProvider(LoginViewModel loginViewModel) {
        return new ViewModelProviderFactory<>(loginViewModel);
    }

}