package com.disco.man.discogman.features.login.dagger.modules;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.domain.login.GetAccessTokenUseCase;
import com.disco.man.discogman.domain.login.GetAccessTokenUseCaseImpl;
import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.features.login.LoginViewModel;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module to provide {@link GetAccessTokenUseCase} to {@link LoginViewModel}.
 */

@Module
public class GetAccessTokenUseCaseModule {

    @ActivityScope
    @Provides
    GetAccessTokenUseCase providesAccessTokenUseCase(LoginService loginService,
                         BaseSchedulerProvider schedulerProvider, SharedPreferencesManager sharedPreferencesManager) {
        return new GetAccessTokenUseCaseImpl(loginService, schedulerProvider, sharedPreferencesManager);
    }

}

