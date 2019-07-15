package com.example.myapplication;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {

    public static final String WEBSITE_ADDRESS = "website_address";
    String urls = "https://andela.com/alc/";

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        String url  = getIntent().getStringExtra(WEBSITE_ADDRESS);
        if (url == null || url.isEmpty()){finish();}

        WebView webView = (WebView) findViewById(R.id.webSite);
        webView.setWebViewClient(new WebViewClient() {
           @Override
           public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
           }
        }
        );
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.loadUrl(urls);

        }
}
