package com.disco.man.discogman.features.login;

import android.arch.lifecycle.ViewModel;

import com.disco.man.discogman.BuildConfig;
import com.disco.man.discogman.Constants;
import com.disco.man.discogman.utils.schedulers.BaseSchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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
        loginService.getRequestToken(createRequestBodyForRequestToken())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe((aVoid, throwable) -> {
                    Timber.i("DONE!");
                    Timber.i("Throwable == %s", throwable.getMessage());
                    Timber.i("aVoid == %s", aVoid);
                });
    }

    private RequestBody createRequestBodyForRequestToken() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject()
                    .put("oauth_consumer_key", BuildConfig.CONSUMER_KEY)
                    .put("oauth_nonce", String.valueOf(System.currentTimeMillis()))
                    .put("oauth_signature", BuildConfig.CONSUMER_SECRET_KEY)
                    .put("oauth_signature_method", "plaintext")
                    .put("oauth_timestamp", String.valueOf(System.currentTimeMillis()))
                    .put("oauth_callback", Constants.OAUTH_CALLBACK);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return RequestBody.create(
                MediaType.parse("application/x-www-form-urlencoded"),
                jsonObject.toString());
    }

}
