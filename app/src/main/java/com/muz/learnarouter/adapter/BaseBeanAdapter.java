package com.muz.learnarouter.adapter;

import android.content.Context;
import android.view.View;

import com.muz.learnarouter.R;
import com.muz.learnarouter.bean.BaseBean;
import com.muz.learnarouter.recyclerview.CommonAdapter;
import com.muz.learnarouter.recyclerview.base.ViewHolder;

import java.util.List;

public class BaseBeanAdapter extends CommonAdapter<BaseBean> {

    public BaseBeanAdapter(Context context, int layoutId, List<BaseBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, BaseBean baseBean, int position) {
        holder.setText(R.id.recycler_title, baseBean.getName());
    }
}
