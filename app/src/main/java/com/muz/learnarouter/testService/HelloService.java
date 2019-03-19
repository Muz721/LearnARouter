package com.muz.learnarouter.testService;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface HelloService extends IProvider {
    void sayHello(String name);
}
