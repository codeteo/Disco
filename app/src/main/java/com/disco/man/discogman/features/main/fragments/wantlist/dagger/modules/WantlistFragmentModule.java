package com.disco.man.discogman.features.main.fragments.wantlist.dagger.modules;

import com.disco.man.discogman.data.api.WantlistService;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.domain.features.wantlist.GetWantlistUseCase;
import com.disco.man.discogman.domain.features.wantlist.GetWantlistUseCaseImpl;
import com.disco.man.discogman.features.main.fragments.wantlist.WantlistFragment;
import com.disco.man.discogman.features.main.fragments.wantlist.WantlistViewModel;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Dagger Module providing dependencies for {@link WantlistFragment}'s ViewModel.
 */

@Module
public class WantlistFragmentModule {

    @Provides
    WantlistViewModel providesWantlistViewModel(GetWantlistUseCase useCase, SharedPreferencesManager preferences) {
        return new WantlistViewModel(useCase, preferences);
    }

    @Provides
    WantlistService providesWantlistService(Retrofit retrofit) {
        return retrofit.create(WantlistService.class);
    }

    @Provides
    GetWantlistUseCase providesGetWantlistUseCase(WantlistService wantlistService,
                          BaseSchedulerProvider schedulerProvider, SharedPreferencesManager preferencesManager) {
        return new GetWantlistUseCaseImpl(wantlistService, schedulerProvider, preferencesManager);
    }

}
