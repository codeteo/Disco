package com.disco.man.discogman.domain.login;

import android.net.Uri;
import android.text.TextUtils;

import com.disco.man.discogman.data.preferences.SharedPreferencesManager;
import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.utils.headers.AccessHeader;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

/**
 * Concrete implementation for {@link GetAccessTokenUseCase}.
 */

public class GetAccessTokenUseCaseImpl implements GetAccessTokenUseCase {

    private LoginService loginService;
    private BaseSchedulerProvider schedulerProvider;
    private SharedPreferencesManager sharedPreferencesManager;

    @Inject
    public GetAccessTokenUseCaseImpl(LoginService loginService, BaseSchedulerProvider schedulerProvider,
                                     SharedPreferencesManager sharedPreferencesManager) {
        this.loginService = loginService;
        this.schedulerProvider = schedulerProvider;
        this.sharedPreferencesManager = sharedPreferencesManager;
    }

    @Override
    public void getAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken) {
        loginService.postAccessToken(new AccessHeader()
                .createHeaderForAccessToken(uri, authRequestToken, authRequestSecretToken))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe((response, throwable) -> {

                    String[] tokens = TextUtils.split(response.string(), "&");
                    String authAccessSecretToken = TextUtils.split(tokens[0], "=")[1];
                    String authAccessToken = TextUtils.split(tokens[1], "=")[1];

                    sharedPreferencesManager.storeAccessTokens(authAccessToken, authAccessSecretToken);

                });
    }
}
