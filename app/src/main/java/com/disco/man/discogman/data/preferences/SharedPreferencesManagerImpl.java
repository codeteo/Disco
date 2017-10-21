package com.disco.man.discogman.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Concrete implementation of {@link SharedPreferencesManager}
 */

public class SharedPreferencesManagerImpl implements SharedPreferencesManager {

    private static final String PREF_KEY_ACCESS_TOKEN = "access_token";
    private static final String PREF_KEY_ACCESS_SECRET_TOKEN = "access_secret_token";

    private SharedPreferences sharedPreferences;

    public SharedPreferencesManagerImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void storeAccessTokens(String accessToken, String accessTokenSecret) {
        sharedPreferences.edit()
                .putString(PREF_KEY_ACCESS_TOKEN, accessToken)
                .putString(PREF_KEY_ACCESS_SECRET_TOKEN, accessTokenSecret)
                .apply();
    }

    /**
     * Checks if user has authorized the app. If true then
     * access token and access token secret should exist in preferences.
     *
     * @return true if user gave access, else false.
     */
    @Override
    public boolean checkIfUserGaveAccess() {
        return sharedPreferences.contains(PREF_KEY_ACCESS_TOKEN) &&
                sharedPreferences.contains(PREF_KEY_ACCESS_SECRET_TOKEN);

    }
}
