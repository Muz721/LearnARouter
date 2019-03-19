package com.muz.learnarouter.testActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muz.learnarouter.R;
@Route(path = "/test/activity/3")
public class Test3Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("3");
        Intent intent = new Intent();
        intent.putExtra("number",123);
        intent.putExtra("text","测试");
        setResult(111,intent);
    }
}
