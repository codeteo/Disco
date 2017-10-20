package com.disco.man.discogman.features.login;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Retrofit service for login screen.
 */

public interface LoginService {

    @POST("/oauth/request_token")
    Single<Call<Void>> getRequestToken(@Body RequestBody requestBody);

}
