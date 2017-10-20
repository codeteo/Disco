package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.BuildConfig;
import com.disco.man.discogman.Constants;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * View Model for {@link LoginActivity}.
 */

public class LoginViewModel extends ViewModel {

    private LoginService loginService;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public LoginViewModel(LoginService loginService, BaseSchedulerProvider schedulerProvider) {
        this.loginService = loginService;
        this.schedulerProvider = schedulerProvider;
    }

    public void getRequestToken() {
        loginService.getRequestToken(createHeaderForRequestToken())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe((aVoid, throwable) -> {
                    Timber.i("DONE!");
                    Timber.i("Throwable == %s", throwable.getMessage());
                    Timber.i("aVoid == %s", aVoid);
                });
    }

    private String createHeaderForRequestToken() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ").append("oauth_consumer_key=\"" + BuildConfig.CONSUMER_KEY + "\",");
        stringBuilder.append("oauth_nonce=\"").append(String.valueOf(System.currentTimeMillis()) + "\",");
        stringBuilder.append("oauth_signature=\"" + BuildConfig.CONSUMER_SECRET_KEY + "&\",");
        stringBuilder.append("oauth_signature_method=\"" + "PLAINTEXT" + "\",");
        stringBuilder.append("oauth_timestamp=\"").append(String.valueOf(System.currentTimeMillis()) + "\",");
        stringBuilder.append("oauth_callback=\"" + Constants.OAUTH_CALLBACK + "\"");

        return stringBuilder.toString();
    }

}
