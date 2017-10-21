package com.disco.man.discogman.domain.login;

import android.net.Uri;

/**
 * Use case for login feature.
 */

public interface GetAccessTokenUseCase {
    void getAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken);
}