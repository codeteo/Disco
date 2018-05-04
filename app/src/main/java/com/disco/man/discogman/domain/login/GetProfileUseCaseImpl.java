package com.disco.man.discogman.domain.login;

import com.disco.man.discogman.data.api.DiscogsApiService;
import com.disco.man.discogman.data.preferences.SharedPreferencesManager;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Concrete Use case implementation for {@link GetProfileUseCase}.
 */

public class GetProfileUseCaseImpl implements GetProfileUseCase {

    private SharedPreferencesManager preferences;
    private DiscogsApiService apiService;

    @Inject
    public GetProfileUseCaseImpl(SharedPreferencesManager preferences, DiscogsApiService apiService) {
        this.preferences = preferences;
        this.apiService = apiService;
    }

    @Override
    public Single<Boolean> getUserProfile(String authRequestToken, String authRequestSecretToken) {
        return null;
    }
}
