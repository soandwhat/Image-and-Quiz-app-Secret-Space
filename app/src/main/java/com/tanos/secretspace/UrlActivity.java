package com.tanos.secretspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UrlActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        webView = (WebView) findViewById (R.id.webview);

        webView.post(new Runnable() {
            @Override
            public void run() {
                webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(false);
                webSettings.setDisplayZoomControls(false);
                webView.setInitialScale(1);

                webSettings.setDatabaseEnabled(true);
                webSettings.setAllowContentAccess(true);
                webSettings.setAllowFileAccessFromFileURLs(true);
                webSettings.setAllowUniversalAccessFromFileURLs(true);
                ///////////////////////////////////////////////

                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);
                webView.getSettings().setAllowContentAccess(true);
                webView.getSettings().setAllowFileAccess(true);
                webView.getSettings().setAllowFileAccess(true);

                webView.loadUrl("https://clwik7t85ej3fg1p-59717877954.shopifypreview.com/products/book-the-ultimate-book-of-space");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);

                    }

                });
            }
        });
    }
}