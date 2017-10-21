package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.domain.login.GetRequestTokenUseCase;

import javax.inject.Inject;

/**
 * View Model for {@link LoginActivity}.
 */

public class LoginViewModel extends ViewModel {

    private GetRequestTokenUseCase requestTokenUseCase;

    @Inject
    public LoginViewModel(GetRequestTokenUseCase requestTokenUseCase) {
        this.requestTokenUseCase = requestTokenUseCase;
    }

    void getRequestToken() {
        requestTokenUseCase.getRequestToken();
    }

}
