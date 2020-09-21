package com.example.mall.preasenter.home;


import com.example.mall.base.BasePersenter;
import com.example.mall.bean.HomeBean;
import com.example.mall.common.CommonSubscriber;
import com.example.mall.mole.HttpManager;
import com.example.mall.mole.home.Ihomeapi;
import com.example.mall.utile.RxUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import okhttp3.internal.http.HttpMethod;

public class HomeBennPreasenter extends BasePersenter<Ihomeapi.ivew> implements Ihomeapi.ipreasenter {
    @Override
    public void onthomebenn() {
        Disposable disposable = HttpManager.getInstance().gethomebenns().gethomebann()
                .compose(RxUtils.<HomeBean>rxScheduler())

                .map(new Function<HomeBean, List<HomeBean.HomelistBean>>() {
                    @Override
                    public List<HomeBean.HomelistBean> apply(HomeBean homeBean) throws Exception {
                         List<HomeBean.HomelistBean>   list = new ArrayList<>();
                        HomeBean.HomelistBean benn = new HomeBean.HomelistBean();
                        benn.itemetype = HomeBean.HOMEBANNITME;
                        benn.data = homeBean.getData().getBanner();
                        list.add(benn);
                        //标题列表
                        HomeBean.HomelistBean tab = new HomeBean.HomelistBean();
                        tab.itemetype = HomeBean.HOMETABITME;
                        tab.data = homeBean.getData().getChannel();
                        list.add(tab);
                        //title
                        HomeBean.HomelistBean title = new HomeBean.HomelistBean();
                        title.itemetype = HomeBean.HOMETITLEITME;
                        title.data = "品牌制造商直供";
                        list.add(title);

                        //品牌列表

                        for (int i = 0; i < homeBean.getData().getBrandList().size(); i++) {
                            HomeBean.HomelistBean brand = new HomeBean.HomelistBean();
                            brand.itemetype = HomeBean.HOMEBRANDITME;
                            brand.data = homeBean.getData().getBrandList().get(i);
                            list.add(brand);
                        }
                        //新品
                        HomeBean.HomelistBean newtitle = new HomeBean.HomelistBean();
                        newtitle.itemetype = HomeBean.HOMETITLEITME;
                        newtitle.data = "周一周四·新品首发";
                        list.add(newtitle);
                        for (int i = 0; i < homeBean.getData().getNewGoodsList().size(); i++) {
                            HomeBean.HomelistBean newlist = new HomeBean.HomelistBean();
                            newlist.itemetype = HomeBean.HOMENEWITME;
                            newlist.data = homeBean.getData().getNewGoodsList().get(i);
                            list.add(newlist);
                        }
                        //人气推荐
                        HomeBean.HomelistBean poiltitle = new HomeBean.HomelistBean();
                        poiltitle.itemetype = HomeBean.HOMETITLEITME;
                        poiltitle.data = "人气推荐";
                        list.add(poiltitle);
                        for (int i = 0; i < homeBean.getData().getHotGoodsList().size(); i++) {
                            HomeBean.HomelistBean hotlist = new HomeBean.HomelistBean();
                            hotlist.itemetype = HomeBean.HOMEPOPULITME;
                            hotlist.data = homeBean.getData().getHotGoodsList().get(i);
                            list.add(hotlist);
                        }
                        //精选
                        HomeBean.HomelistBean selected = new HomeBean.HomelistBean();
                        selected.itemetype = HomeBean.HOMETITLEITME;
                        selected.data = "专题精选";
                        list.add(selected);
                        HomeBean.HomelistBean selectedlist = new HomeBean.HomelistBean();
                        selectedlist.itemetype = HomeBean.HOMEIFICATIONITME;
                        selectedlist.data = homeBean.getData().getTopicList();
                        list.add(selectedlist);
                        //分类
                        for (HomeBean.DataBean.CategoryListBean cat :homeBean.getData().getCategoryList()) {
                            HomeBean.HomelistBean cationlist = new HomeBean.HomelistBean();
                            cationlist.itemetype = HomeBean.HOMETITLEITME;
                            cationlist.data = cat.getName();
                            list.add(cationlist);
                            for (HomeBean.DataBean.CategoryListBean.GoodsListBean item:cat.getGoodsList()) {
                                HomeBean.HomelistBean cation = new HomeBean.HomelistBean();
                                cation.itemetype = HomeBean.HOMESPECIALLITME;
                                cation.data =item;
                                list.add(cation);
                            }


                        }

                        return list;
                    }

                }).subscribeWith(new CommonSubscriber<List<HomeBean.HomelistBean>>(mView) {
                    @Override
                    public void onNext(List<HomeBean.HomelistBean> lists) {
                        mView.gethomebenn(lists);
                    }
                });
        addSubscribe(disposable);
    }
}
