package com.disco.man.discogman.features.main.fragments.wantlist;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.domain.features.wantlist.GetWantlistUseCase;

import javax.inject.Inject;

/**
 * View model for {@link WantlistFragment}.
 */

public class WantlistViewModel extends ViewModel {

    private GetWantlistUseCase wantlistUseCase;
    private SharedPreferencesManager preferences;

    @Inject
    public WantlistViewModel(GetWantlistUseCase wantlistUseCase, SharedPreferencesManager preferences) {
        this.wantlistUseCase = wantlistUseCase;
        this.preferences = preferences;
    }

    void onInit() {
//        wantlistUseCase.getWantlist()
    }
}
