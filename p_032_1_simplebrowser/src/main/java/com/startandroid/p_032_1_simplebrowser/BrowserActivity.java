package com.startandroid.p_032_1_simplebrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        WebView wv = findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        Uri data = getIntent().getData();
        wv.loadUrl(data.toString());
    }
}