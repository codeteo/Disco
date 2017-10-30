package com.disco.man.discogman.features.main.fragments.wantlist;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.domain.features.wantlist.GetWantlistUseCase;

import javax.inject.Inject;

/**
 * View model for {@link WantlistFragment}.
 */

public class WantlistViewModel extends ViewModel {

    private GetWantlistUseCase wantlistUseCase;

    @Inject
    public WantlistViewModel(GetWantlistUseCase wantlistUseCase) {
        this.wantlistUseCase = wantlistUseCase;
    }
}
