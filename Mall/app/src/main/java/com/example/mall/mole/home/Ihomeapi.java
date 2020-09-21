package com.example.mall.mole.home;


import com.example.mall.bean.HomeBean;
import com.example.mall.interfse.IBasePersenter;
import com.example.mall.interfse.IBaseView;

import java.util.List;

public interface Ihomeapi {
    interface ivew extends IBaseView {
        void gethomebenn(List<HomeBean.HomelistBean> list);
    }
    interface ipreasenter extends IBasePersenter<ivew> {
        void onthomebenn();
    }
}
