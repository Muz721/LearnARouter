package com.muz.learnarouter.testinterceptor;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 5)
public class Test5Insterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Bundle bundle = postcard.getExtras();
        if (bundle.getString("name").equals("测试")){
            postcard.withString("txt","txt");
            callback.onContinue(postcard);
        Log.e("name","name");
        }else {
//            callback.onInterrupt(null);
        }
    }

    @Override
    public void init(Context context) {

    }
}
