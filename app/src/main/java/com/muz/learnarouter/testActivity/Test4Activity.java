package com.muz.learnarouter.testActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muz.learnarouter.R;

@Route(path = "/test/activity/4")
public class Test4Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("4");
    }
}
