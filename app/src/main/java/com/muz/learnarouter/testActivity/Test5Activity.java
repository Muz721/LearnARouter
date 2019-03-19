package com.muz.learnarouter.testActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.muz.learnarouter.R;

@Route(path = "/test/activity/5")
public class Test5Activity extends AppCompatActivity {
    @Autowired
    String name;
    @Autowired
    int id;
    @Autowired
    String txt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("5");
        ARouter.getInstance().inject(this);
        Log.e("Test5Activity: name= ",name);
        Log.e("Test5Activity: id= ",id+"");
        Log.e("Test5Activity: txt= ",txt+"");
    }
}
