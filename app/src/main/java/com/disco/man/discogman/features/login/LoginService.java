package com.disco.man.discogman.features.login;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.HTTP;

/**
 * Retrofit service for login screen.
 */

public interface LoginService {

    @HTTP(method = "GET", path = "/oauth/request_token", hasBody = true)
    Single<Void> getRequestToken(@Body RequestBody requestBody);

}
