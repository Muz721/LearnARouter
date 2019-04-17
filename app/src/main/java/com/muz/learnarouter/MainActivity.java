package com.muz.learnarouter;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.muz.learnarouter.adapter.BaseBeanAdapter;
import com.muz.learnarouter.bean.BaseBean;
import com.muz.learnarouter.bean.Test2Bean;
import com.muz.learnarouter.recyclerview.MultiItemTypeAdapter;
import com.muz.learnarouter.recyclerview.decoration.TestDividerItemDecoration;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MultiItemTypeAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    BaseBeanAdapter adapter;
    private ArrayList<BaseBean> baseBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        baseBeans.add(new BaseBean(0, "应用内简单的跳转"));
        baseBeans.add(new BaseBean(1, "跳转并携带参数"));
        baseBeans.add(new BaseBean(2, "数据回传"));
        baseBeans.add(new BaseBean(3, "通过url跳转"));
        baseBeans.add(new BaseBean(4, "旧版转场动画"));
        baseBeans.add(new BaseBean(5, "新版转场动画"));
        baseBeans.add(new BaseBean(6, "拦截器"));
        baseBeans.add(new BaseBean(7, "登录拦截"));
        adapter = new BaseBeanAdapter(this, R.layout.recycler, baseBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new TestDividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(this);
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(getApplication());//初始化
        //TODO 测试
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                ARouter.getInstance().build("/test/activity/1").navigation();
                break;
            case 1:
                ARouter.getInstance().build("/test/activity/2")
                        .withLong("key1", 666L)
                        .withString("key2", "888")
//                        .withObject("key3",new Test2Bean("Jack","Rose"))
                        .navigation();
                break;
            case 2:
                ARouter.getInstance().build("/test/activity/3")
                        .navigation(this, 3);
                break;
            case 3:
                ARouter.getInstance().build("/test/activity/webview")
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
                break;
            case 4:
                ARouter.getInstance().build("/test/activity/3")
                        .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                        .navigation(this);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityOptionsCompat compat = ActivityOptionsCompat.
                            makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);

                    ARouter.getInstance()
                            .build("/test/activity/3")
                            .withOptionsCompat(compat)
                            .navigation();
                } else {
                    Toast.makeText(this, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show();
                }
                break;
            case 6:
                ARouter.getInstance()
                        .build("/test/activity/5")
                        .withString("name", "测试")
                        .withInt("id", 123)
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d("ARouter", "被拦截了");
                            }
                        });
                break;
            case 7:
                ARouter.getInstance()
                        .build("/test/activity/6")
                        .withString("name", "测试1")
                        .withInt("id", 123)
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d("ARouter", "被拦截了");
                            }
                        });
                break;
        }
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 3:
                Log.e("返回数据", "number==" + data.getIntExtra("number", 0));
                Log.e("返回数据1", "text==" + data.getStringExtra("text"));
                break;
        }
    }
}
