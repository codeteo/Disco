package com.disco.man.discogman.features.login.dagger.modules;

import com.disco.man.discogman.domain.login.GetRequestTokenUseCase;
import com.disco.man.discogman.domain.login.GetRequestTokenUseCaseImpl;
import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.features.login.LoginViewModel;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module to provide {@link LoginService} to {@link LoginViewModel}.
 */

@Module
public class GetRequestTokenUseCaseModule {

    @Provides
    GetRequestTokenUseCase providesRequestTokenUseCase(LoginService loginService, BaseSchedulerProvider schedulerProvider) {
        return new GetRequestTokenUseCaseImpl(loginService, schedulerProvider);
    }

}
