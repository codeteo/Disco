package com.disco.man.discogman.features.login;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Retrofit service for login screen.
 */

public interface LoginService {

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "User-Agent: Discs/1.0 +https://jb.com"
    })
    @GET("/oauth/request_token")
    Single<ResponseBody> getRequestToken(@Header("Authorization") String header);

}
