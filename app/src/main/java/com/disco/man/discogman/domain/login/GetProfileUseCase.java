package com.disco.man.discogman.domain.login;

import io.reactivex.Single;

/**
 * Use case for login feature.
 * <p>
 * Fetches user's profile from server and stores some data
 * to shared preferences.
 */

public interface GetProfileUseCase {
    Single<Boolean> getUserProfile(String authRequestToken, String authRequestSecretToken);
}
