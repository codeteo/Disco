package com.disco.man.discogman.domain.login;

import android.util.Pair;

import io.reactivex.Single;

/**
 * Use case for login feature.
 */

public interface GetRequestTokenUseCase {
    Single<Pair<String, String>> getRequestToken();
}
