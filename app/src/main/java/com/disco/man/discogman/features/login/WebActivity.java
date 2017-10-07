package com.disco.man.discogman.features.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.disco.man.discogman.R;

public class WebActivity extends AppCompatActivity {
    private static final String TAG = "WEBACTIVITY";
    private ProgressBar progressBar;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        init();
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new CustomWebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String authorizationUrl = getIntent().getExtras().getString("authorizationUrl");
        webView.loadUrl(Uri.parse(authorizationUrl).toString());
    }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i(TAG, "shouldOverrideUrlLoading ");
            if (!url.contains("authorize")) {
                Log.i(TAG, "shouldOverrideUrlLoading--OAUTH url= " + url);

                Intent intent = new Intent();
                intent.setData(Uri.parse(url));
                setResult(Constants.REQUEST_CODE_AUTHORIZE, intent);
                finish();
//                return true;
            } else {
                Log.i(TAG, "shouldOverrideUrlLoading PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM PROBLEM");
                view.loadUrl(url);
            }
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.i(TAG, "onPageStarted URL = "  + url );
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.i(TAG, "onPageFinished ");
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
        }
    }
}