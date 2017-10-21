package com.disco.man.discogman.utils.headers;

import android.net.Uri;

import com.disco.man.discogman.BuildConfig;
import com.disco.man.discogman.Constants;

import java.io.UnsupportedEncodingException;

import static java.net.URLDecoder.decode;

/**
 * Creates header for network request to get Access Token
 * needed for the Login.
 */

public class AccessHeader {

    public String createHeaderForAccessToken(Uri uri, String authRequestToken, String authRequestSecretToken) {
        String uriString = null;
        try {
            uriString = decode(uri.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OAuth ").append("oauth_consumer_key=\"" + BuildConfig.CONSUMER_KEY + "\",");
        stringBuilder.append("oauth_nonce=\"").append(String.valueOf(System.currentTimeMillis())).append("\",");
        stringBuilder.append("oauth_signature=\"" + BuildConfig.CONSUMER_SECRET_KEY).append("&")
                .append(authRequestSecretToken).append("\",");
        stringBuilder.append("oauth_signature_method=\"" + "PLAINTEXT" + "\",");
        stringBuilder.append("oauth_timestamp=\"").append(String.valueOf(System.currentTimeMillis())).append("\",");
        stringBuilder.append("oauth_verifier=\"").append(Uri.parse(uriString).getQueryParameter("oauth_verifier"))
                .append("\",");
        stringBuilder.append("oauth_token=\"").append(authRequestToken).append("\",");
        stringBuilder.append("oauth_callback=\"" + Constants.OAUTH_CALLBACK + "\"");

        return stringBuilder.toString();
    }

}
