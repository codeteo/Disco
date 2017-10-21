package com.disco.man.discogman.domain.login;

import android.net.Uri;

import io.reactivex.Single;

/**
 * Use case for login feature.
 */

public interface GetAccessTokenUseCase {
    Single<Boolean> getAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken);
}