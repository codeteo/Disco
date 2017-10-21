package com.disco.man.discogman.features.login.dagger.modules;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.features.login.LoginService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module to provide {@link LoginService} to use cases.
 */

@Module
public class LoginServiceModule {

    @ActivityScope
    @Provides
    LoginService providesLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

}
