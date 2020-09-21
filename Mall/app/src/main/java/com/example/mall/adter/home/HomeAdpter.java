package com.example.mall.adter.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.mall.R;
import com.example.mall.bean.HomeBean;
import com.example.mall.utile.SystemUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HomeAdpter extends BaseMultiItemQuickAdapter<HomeBean.HomelistBean, BaseViewHolder> implements LifecycleOwner {
    private Context context;

    public HomeAdpter(@Nullable List<HomeBean.HomelistBean> data, Context context) {

        super(data);
        this.context = context;
        addItemType(HomeBean.HOMEBANNITME, R.layout.home_banner);
        addItemType(HomeBean.HOMETABITME, R.layout.home_tab);
        addItemType(HomeBean.HOMETITLEITME, R.layout.home_title);
        addItemType(HomeBean.HOMEBRANDITME, R.layout.home_brand);
        addItemType(HomeBean.HOMENEWITME, R.layout.home_new);
        addItemType(HomeBean.HOMEPOPULITME, R.layout.home_hot);
        addItemType(HomeBean.HOMEIFICATIONITME, R.layout.home_ification);
        addItemType(HomeBean.HOMESPECIALLITME, R.layout.ification);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.HomelistBean item) {
        switch (item.getItemType()) {
            case HomeBean.HOMEBANNITME:
                updateBanner(helper, (List<HomeBean.DataBean.BannerBean>) item.data);
                break;
            case HomeBean.HOMETABITME:
                uodatetab(helper, (List<HomeBean.DataBean.ChannelBean>) item.data);
                break;
            case HomeBean.HOMETITLEITME:
                updatetitle(helper, (String) item.data);
                break;
            case HomeBean.HOMEBRANDITME:
                updatebrand(helper, (HomeBean.DataBean.BrandListBean) item.data);
                break;
            case HomeBean.HOMENEWITME:
                updatenew(helper, (HomeBean.DataBean.NewGoodsListBean) item.data);
                break;
            case HomeBean.HOMEPOPULITME:
                updatehow(helper, (HomeBean.DataBean.HotGoodsListBean) item.data);
                break;
            case HomeBean.HOMEIFICATIONITME:
                updateselected(helper, (List<HomeBean.DataBean.TopicListBean>) item.data);
                break;
            case HomeBean.HOMESPECIALLITME:
                updateification(helper, (HomeBean.DataBean.CategoryListBean.GoodsListBean) item.data);
                break;
        }

    }

    private void updateBanner(BaseViewHolder holder, List<HomeBean.DataBean.BannerBean> list) {
        Banner banner = holder.getView(R.id.home_banner);
        if (banner.getTag() == null || (int) banner.getTag() == 0) {

            List<String> listbean = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listbean.add(list.get(i).getImage_url());
            }
            banner.setImages(listbean);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
        }

    }

    private void uodatetab(BaseViewHolder holder, List<HomeBean.DataBean.ChannelBean> list) {
        LinearLayout tab = holder.getView(R.id.home_tab);
        if (tab.getChildCount() == 0) {
            for (HomeBean.DataBean.ChannelBean item : list) {
                TextView tabs = new TextView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                tabs.setLayoutParams(params);
                tabs.setTextSize(15);
                tabs.setGravity(Gravity.CENTER);

                Drawable icon = mContext.getResources().getDrawable(R.mipmap.ic_launcher_round);
                tabs.setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
                tabs.setText(item.getName());
                tabs.setTag(item.getId());
                tab.addView(tabs);
            }
        }
    }

    public void updatetitle(BaseViewHolder holder, String date) {
        TextView title = holder.getView(R.id.home_title);

        title.setText(date);
    }

    public void updatebrand(BaseViewHolder holder, HomeBean.DataBean.BrandListBean datas) {
        if (!TextUtils.isEmpty(datas.getNew_pic_url())) {
            TextView price = holder.getView(R.id.brand_price);
            ImageView img = holder.getView(R.id.brand_img);
            TextView title = holder.getView(R.id.brand_title);

            price.setText(datas.getFloor_price() + "元起");
            Glide.with(mContext).load(datas.getNew_pic_url()).into(img);
            title.setText(datas.getName() + "");
        }
    }

    public void updatenew(BaseViewHolder holder, HomeBean.DataBean.NewGoodsListBean datas) {
        if (!TextUtils.isEmpty(datas.getList_pic_url())) {
            TextView price = holder.getView(R.id.new_price);
            ImageView img = holder.getView(R.id.new_img);
            TextView title = holder.getView(R.id.new_title);

            price.setText(datas.getRetail_price() + "");
            Glide.with(mContext).load(datas.getList_pic_url()).into(img);
            title.setText(datas.getName() + "");
        }
    }

    public void updatehow(BaseViewHolder holder, HomeBean.DataBean.HotGoodsListBean datas) {
        if (!TextUtils.isEmpty(datas.getList_pic_url())) {
            TextView price = holder.getView(R.id.hot_price);
            ImageView img = holder.getView(R.id.hot_img);
            TextView title = holder.getView(R.id.hot_title);
            TextView titles = holder.getView(R.id.hot_usetitle);
            Glide.with(mContext).load(datas.getList_pic_url()).into(img);
            price.setText("￥" + datas.getRetail_price());
            titles.setText(datas.getGoods_brief());
            title.setText(datas.getName());
        }
    }

    public void updateselected(BaseViewHolder holder, List<HomeBean.DataBean.TopicListBean> list) {
        RecyclerView rec = holder.getView(R.id.ification_rec);

        SelectedAdater selectedAdater = new SelectedAdater(mContext);
        selectedAdater.setData(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(selectedAdater);

    }

    public void updateification(BaseViewHolder holder, HomeBean.DataBean.CategoryListBean.GoodsListBean list) {

        if (!TextUtils.isEmpty(list.getName())) {

            ImageView img = holder.getView(R.id.ification_img);
            TextView title = holder.getView(R.id.ification_title);
            TextView price = holder.getView(R.id.ification_price);

            title.setText(list.getName());
            Glide.with(mContext).load(list.getList_pic_url()).into(img);
            price.setText("￥" + list.getRetail_price());

        }
    }


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
