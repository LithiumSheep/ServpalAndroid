package com.servpal.android.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.servpal.android.CustomWebViewClient;
import com.servpal.android.R;
import com.servpal.android.api.ServpalHttpClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        // open in WebView that intercepts urls to itself
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl(ServpalHttpClient.baseUrl());
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
