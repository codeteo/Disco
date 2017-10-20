package com.disco.man.discogman.features.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.disco.man.discogman.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class WebActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_AUTHORIZE = 0;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.webView) WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        webView.setWebViewClient(new CustomWebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String authorizationUrl = getIntent().getExtras().getString("authorizationUrl");
        webView.loadUrl(Uri.parse(authorizationUrl).toString());
    }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Timber.i("shouldOverrideUrlLoading ");
            if (!url.contains("authorize")) {
                Timber.i("shouldOverrideUrlLoading--OAUTH url= " + url);

                Intent intent = new Intent();
                intent.setData(Uri.parse(url));
                setResult(REQUEST_CODE_AUTHORIZE, intent);
                finish();
            } else {
                Timber.i("shouldOverrideUrlLoading PROBLEM");
                view.loadUrl(url);
            }
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Timber.i("onPageStarted URL = "  + url );

            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Timber.i("onPageFinished ");

            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
        }
    }
}