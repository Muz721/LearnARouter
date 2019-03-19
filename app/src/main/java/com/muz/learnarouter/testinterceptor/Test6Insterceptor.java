package com.muz.learnarouter.testinterceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.muz.learnarouter.Constants;
@Interceptor(priority = 1)
public class Test6Insterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getExtra() == Constants.LOGIN_PATH){
            callback.onContinue(postcard);
        }else {
        callback.onInterrupt(null);}
    }

    @Override
    public void init(Context context) {

    }
}
