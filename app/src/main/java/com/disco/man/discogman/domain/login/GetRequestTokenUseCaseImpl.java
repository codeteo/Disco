package com.disco.man.discogman.domain.login;

import android.text.TextUtils;
import android.util.Pair;

import com.disco.man.discogman.features.login.LoginService;
import com.disco.man.discogman.utils.headers.LoginHeader;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;

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
    public Single<Pair<String, String>> getRequestToken() {
        return loginService.getRequestToken(new LoginHeader().createHeaderForRequestToken())
                .map(responseBody -> {

                    String[] tokens = TextUtils.split(responseBody.string(), "&");
                    String authRequestSecretToken = TextUtils.split(tokens[0], "=")[1];
                    String authRequestToken = TextUtils.split(tokens[1], "=")[1];

                    return new Pair<>(authRequestToken, authRequestSecretToken);
                })
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }
}
