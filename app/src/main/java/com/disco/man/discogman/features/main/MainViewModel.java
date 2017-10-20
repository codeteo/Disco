package com.disco.man.discogman.features.main;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.data.api.DiscogsApiService;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

/**
 * View model for {@link MainActivity}
 */

public class MainViewModel extends ViewModel {

    private DiscogsApiService discogsService;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public MainViewModel(DiscogsApiService discogsService, BaseSchedulerProvider schedulerProvider) {
        this.discogsService = discogsService;
        this.schedulerProvider = schedulerProvider;
    }

}
