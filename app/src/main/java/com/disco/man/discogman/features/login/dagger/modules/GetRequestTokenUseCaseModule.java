package com.disco.man.discogman.features.login.dagger.modules;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.domain.login.GetRequestTokenUseCase;
import com.disco.man.discogman.domain.login.GetRequestTokenUseCaseImpl;
import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.features.login.LoginViewModel;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module to provide {@link LoginService} to {@link LoginViewModel}.
 */

@Module
public class GetRequestTokenUseCaseModule {

    @ActivityScope
    @Provides
    LoginService providesLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @ActivityScope
    @Provides
    GetRequestTokenUseCase providesRequestTokenUseCase(LoginService loginService, BaseSchedulerProvider schedulerProvider) {
        return new GetRequestTokenUseCaseImpl(loginService, schedulerProvider);
    }

}
