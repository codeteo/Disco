package com.disco.man.discogman.domain.login;

import android.text.TextUtils;

import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.utils.headers.LoginHeader;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Concrete implementation of {@link GetRequestTokenUseCase} Use Case.
 */

public class GetRequestTokenUseCaseImpl implements GetRequestTokenUseCase {

    private LoginService loginService;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public GetRequestTokenUseCaseImpl(LoginService loginService, BaseSchedulerProvider schedulerProvider) {
        this.loginService = loginService;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void getRequestToken() {
        loginService.getRequestToken(new LoginHeader().createHeaderForRequestToken())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe((responseBody, throwable) -> {
                    Timber.i("DONE!");

                    String[] tokens = TextUtils.split(responseBody.string(), "&");
                    String authRequestSecretToken = TextUtils.split(tokens[0], "=")[1];
                    String authRequestToken = TextUtils.split(tokens[1], "=")[1];

                    Timber.i("authToken == %s", authRequestToken);
                    Timber.i("authSecretToken == %s", authRequestSecretToken);
                });

    }
}
