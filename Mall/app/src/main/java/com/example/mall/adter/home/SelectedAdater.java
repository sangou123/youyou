package com.example.mall.adter.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mall.R;
import com.example.mall.base.BaseAdapter;
import com.example.mall.bean.HomeBean;

import java.util.List;

public class SelectedAdater extends BaseAdapter {
    public SelectedAdater(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.rec_selected;
    }

    @Override
    protected void bindData(BaseViewHolder vh, Object data) {
        ImageView img = (ImageView) vh.getViewById(R.id.selected_img);
        TextView title = (TextView) vh.getViewById(R.id.selected_title);
        TextView price = (TextView) vh.getViewById(R.id.selected_price);
        TextView usertitle = (TextView) vh.getViewById(R.id.selected_usertitle);
        HomeBean.DataBean.TopicListBean list= (HomeBean.DataBean.TopicListBean) data;
        Glide.with(mcontext).load(list.getItem_pic_url()).into(img);
        title.setText(list.getTitle());
        price.setText("￥"+list.getPrice_info());
        usertitle.setText(list.getSubtitle());
    }
}
