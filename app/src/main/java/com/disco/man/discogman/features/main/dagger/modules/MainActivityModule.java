package com.disco.man.discogman.features.main.dagger.modules;


import android.arch.lifecycle.ViewModelProvider;

import com.disco.man.discogman.dagger.ActivityScope;
import com.disco.man.discogman.data.api.DiscogsApiService;
import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.MainViewModel;
import com.disco.man.discogman.utils.ViewModelProviderFactory;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module providing dependencies for {@link MainActivity}'s ViewModel.
 */

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    MainViewModel providesMainViewModel(DiscogsApiService service, BaseSchedulerProvider schedulerProvider) {
        return new MainViewModel(service, schedulerProvider);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesMainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}