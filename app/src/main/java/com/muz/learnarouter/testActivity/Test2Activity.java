package com.muz.learnarouter.testActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.muz.learnarouter.R;
@Route(path = "/test/activity/2")
public class Test2Activity extends AppCompatActivity {
    @Autowired
    String key2 ;
    @Autowired
    long key1 ;
    TextView textView;
    public static final String TAG = "TestActivity2==";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        ARouter.getInstance().inject(this);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("2");
        String params = String.format(
                "key2=%s,\n",key2);
        String key1s = getIntent().getStringExtra("key2");
        textView.setText(params);
        Log.e(TAG,params);
        Log.e(TAG,"key1=="+key1);
        Log.e(TAG,"key1s=="+key1s);
    }
}
