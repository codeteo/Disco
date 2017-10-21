package com.disco.man.discogman.data.preferences;

import android.content.SharedPreferences;

/**
 * Interface which defines the contract for the class
 * that will handle {@link SharedPreferences} operations in app.
 */

public interface SharedPreferencesManager {

    void storeAccessTokens(String accessToken, String accessTokenSecret);

}
