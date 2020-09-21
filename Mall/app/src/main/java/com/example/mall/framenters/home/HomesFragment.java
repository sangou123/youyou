package com.example.mall.framenters.home;


import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mall.R;
import com.example.mall.adter.home.HomeAdpter;
import com.example.mall.base.BaseFragment;
import com.example.mall.bean.HomeBean;
import com.example.mall.interfse.IBasePersenter;
import com.example.mall.mole.home.Ihomeapi;
import com.example.mall.preasenter.home.HomeBennPreasenter;

import java.util.ArrayList;
import java.util.List;

public class HomesFragment extends BaseFragment<Ihomeapi.ipreasenter>implements Ihomeapi.ivew {


    private RecyclerView rec;
    private List<HomeBean.HomelistBean> list;
    private HomeAdpter homeAdpter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        rec = getActivity().findViewById(R.id.home_rec);
        list = new ArrayList<>();
        homeAdpter = new HomeAdpter(list,mcontext);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mcontext, 2);
        homeAdpter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int i) {

                        int itemetype = list.get(i).itemetype;
                        switch (itemetype){
                            case HomeBean.HOMEBANNITME:
                            case HomeBean.HOMETABITME:
                            case  HomeBean.HOMETITLEITME:
                            case HomeBean.HOMEPOPULITME:
                            case HomeBean.HOMEIFICATIONITME:
                                return 2;
                            case  HomeBean.HOMEBRANDITME:
                            case HomeBean.HOMENEWITME:
                            case HomeBean.HOMESPECIALLITME:
                                return 1;
                        }
                        return 0;
                    }


        });
        rec.setLayoutManager(gridLayoutManager);

        homeAdpter.bindToRecyclerView(rec);

    }

    @Override
    protected Ihomeapi.ipreasenter getPresenter() {
        return  new HomeBennPreasenter();
    }

    @Override
    protected void initData() {
      presenter.onthomebenn();

    }

    @Override
    public void gethomebenn(List<HomeBean.HomelistBean> lists) {
      list.addAll(lists);
       homeAdpter.notifyDataSetChanged();
    }
}
