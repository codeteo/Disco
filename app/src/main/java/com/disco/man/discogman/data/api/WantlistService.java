package com.disco.man.discogman.data.api;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Retrofit interface for wantlist items.
 */

public interface WantlistService {

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "User-Agent: Discs/1.0 +https://jb.com"
    })
    @GET("/{username}/wants")
    Single<ResponseBody> getWantlist(@Path("username") String username,
                             @Header("Authorization") String header);

}
