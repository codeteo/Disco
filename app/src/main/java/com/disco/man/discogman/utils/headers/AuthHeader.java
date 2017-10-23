package com.disco.man.discogman.utils.headers;

import com.disco.man.discogman.BuildConfig;

/**
 * Creates header for network requests that need authorization.
 */

public class AuthHeader {

    public String createHeaderForAuthToken(String authAccessToken, String authAccessSecretToken) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ")
                .append("oauth_consumer_key=\"" + BuildConfig.CONSUMER_KEY + "\",");
        stringBuilder.append("oauth_nonce=\"")
                .append(String.valueOf(System.currentTimeMillis())).append("\",");
        stringBuilder.append("oauth_signature=\"" + BuildConfig.CONSUMER_SECRET_KEY).append("&")
                .append(authAccessSecretToken).append("\",");
        stringBuilder.append("oauth_signature_method=\"" + "PLAINTEXT" + "\",");
        stringBuilder.append("oauth_timestamp=\"")
                .append(String.valueOf(System.currentTimeMillis())).append("\",");
        stringBuilder.append("oauth_token=\"").append(authAccessToken).append("\"");

        return stringBuilder.toString();
    }

}
