package com.example.administrator.mypanda.ui;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mypanda.R;
import com.example.administrator.mypanda.ui.base.BaseActivity;

/**
 * @author 农民伯伯
 * @version 2017/11/5
 */

public class WebActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mWeb_return;
    private TextView mWeb_title;
    private WebView mWeb_webView;
    private ImageView mShare;
    private ProgressBar mProgressBar;

    @Override
    public void setViewVisible() {
        setNotScrollViewVisible(View.VISIBLE);
        setHeaderViewVisible(View.VISIBLE);
        setHeaderView(R.layout.activity_web_header);
        setBodyView(R.layout.activity_web_body);
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        mWeb_return = (ImageView) findViewById(R.id.mWeb_Return);
        mWeb_title = (TextView) findViewById(R.id.mWeb_Title);
        mWeb_webView = (WebView) findViewById(R.id.mWeb_WebView);
        mShare = (ImageView) findViewById(R.id.mShare);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mWeb_return.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mWeb_title.setText(title);
        loadUlr(url);


    }

    @Override
    public void setDagger() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mWeb_Return:
                finish();
                break;
            case R.id.mShare:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;


        }
    }

    public void loadUlr(String url) {
        //获取一个webviewsetting对象
        WebSettings setting = mWeb_webView.getSettings();
        //支持JavaScript
        setting.setJavaScriptEnabled(true);
        //显示缩放控制工具
        setting.setDisplayZoomControls(true);
        //设置webview支持缩放
        setting.setSupportZoom(true);
        setting.setBuiltInZoomControls(true);
        //设置加载进来的页面自适应手机屏幕
        //设置缓存
        setting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //设置适应Html5的一些方法
        setting.setDomStorageEnabled(true);
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        mWeb_webView.setWebChromeClient(new WebChromeClient());
        mWeb_webView.setWebViewClient(new WebViewClient());
//        rv_same.getSettings().setJavaScriptEnabled(true);
        mWeb_webView.loadUrl(url);
//        WebSettings settings = rv_same.getSettings();
//        settings.setJavaScriptEnabled(true);
        mWeb_webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWeb_webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    mProgressBar.setProgress(newProgress);//设置进度值
                }

            }
        });
    }
}
