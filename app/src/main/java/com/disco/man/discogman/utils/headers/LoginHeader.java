package com.disco.man.discogman.utils.headers;

import com.disco.man.discogman.BuildConfig;
import com.disco.man.discogman.Constants;

/**
 * Creates header for network request to get Request Token
 * needed for the Login.
 */

public class LoginHeader {

    public String createHeaderForRequestToken() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ").append("oauth_consumer_key=\"" + BuildConfig.CONSUMER_KEY + "\",");
        stringBuilder.append("oauth_nonce=\"").append(String.valueOf(System.currentTimeMillis()) + "\",");
        stringBuilder.append("oauth_signature=\"" + BuildConfig.CONSUMER_SECRET_KEY + "&\",");
        stringBuilder.append("oauth_signature_method=\"" + "PLAINTEXT" + "\",");
        stringBuilder.append("oauth_timestamp=\"").append(String.valueOf(System.currentTimeMillis()) + "\",");
        stringBuilder.append("oauth_callback=\"" + Constants.OAUTH_CALLBACK + "\"");

        return stringBuilder.toString();
    }

}