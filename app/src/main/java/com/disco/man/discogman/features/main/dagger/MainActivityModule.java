package com.disco.man.discogman.features.main.dagger;

import android.arch.lifecycle.ViewModelProvider;

import com.disco.man.discogman.features.main.MainActivity;
import com.disco.man.discogman.features.main.MainViewModel;
import com.disco.man.discogman.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module for {@link MainActivity}.
 */

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }
}