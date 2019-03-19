package com.muz.learnarouter.testService;

import android.content.Context;

public class HelloServiceImpl implements HelloService {
    private Context context;

    @Override
    public void sayHello(String name) {

    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
