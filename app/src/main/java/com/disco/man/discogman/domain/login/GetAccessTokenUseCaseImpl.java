package com.disco.man.discogman.domain.login;

import android.net.Uri;

import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.utils.headers.AccessHeader;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Concrete implementation for {@link GetAccessTokenUseCase}.
 */

public class GetAccessTokenUseCaseImpl implements GetAccessTokenUseCase {

    private LoginService loginService;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public GetAccessTokenUseCaseImpl(LoginService loginService, BaseSchedulerProvider schedulerProvider) {
        this.loginService = loginService;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void getAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken) {
        loginService.postAccessToken(new AccessHeader()
                .createHeaderForAccessToken(uri, authRequestToken, authRequestSecretToken))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe((response, throwable) -> {

                    Timber.i("throwable == %s", throwable.getMessage());

//                    Timber.i("response == %s", response.toString());

                });
    }
}
