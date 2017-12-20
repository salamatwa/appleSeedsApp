package com.example.salam.androidappappleseeds;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by salam on 12/20/2017.
 */

public class ItemViewOnWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view_on_web);

        Intent intent = getIntent();
        String url = "www.shopyourway.com" + intent.getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);
    }


}
