package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModel;
import android.net.Uri;
import android.util.Pair;

import com.disco.man.discogman.domain.login.GetAccessTokenUseCase;
import com.disco.man.discogman.domain.login.GetRequestTokenUseCase;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * View Model for {@link LoginActivity}.
 */

public class LoginViewModel extends ViewModel {

    private GetRequestTokenUseCase requestTokenUseCase;
    private GetAccessTokenUseCase accessTokenUseCase;

    @Inject
    public LoginViewModel(GetRequestTokenUseCase requestTokenUseCase, GetAccessTokenUseCase accessTokenUseCase) {
        this.requestTokenUseCase = requestTokenUseCase;
        this.accessTokenUseCase = accessTokenUseCase;
    }

    Single<Pair<String, String>> getRequestToken() {
        return requestTokenUseCase.getRequestToken();
    }

    Single<Boolean> postAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken) {
        return accessTokenUseCase.getAccessToken(uri, authRequestToken, authRequestSecretToken);
    }

}
