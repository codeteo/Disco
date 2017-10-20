package com.disco.man.discogman.features.main.dagger.modules;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.data.api.DiscogsApiService;
import com.disco.man.discogman.features.main.MainViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module to provide {@link DiscogsApiService} to {@link MainViewModel}
 */

@Module
public class MainActivityServiceModule {

    @ActivityScope
    @Provides
    DiscogsApiService providesDiscogsApiService(Retrofit retrofit) {
        return retrofit.create(DiscogsApiService.class);
    }

}