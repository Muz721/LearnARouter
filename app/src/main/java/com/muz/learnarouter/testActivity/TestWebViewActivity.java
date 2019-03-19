package com.muz.learnarouter.testActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.muz.learnarouter.R;

@Route(path = "/test/activity/webview")
public class TestWebViewActivity extends AppCompatActivity {
    WebView webview;
    @Autowired
    String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_webview);
        ARouter.getInstance().inject(this);
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(url);
    }
}
