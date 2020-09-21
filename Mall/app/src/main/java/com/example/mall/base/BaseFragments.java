package com.example.mall.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mall.interfse.IBasePersenter;
import com.example.mall.interfse.IBaseView;


public abstract class BaseFragments<P extends IBasePersenter> extends Fragment implements IBaseView {
    protected Context mcontext;
    protected  static  int layout;
    protected P presenter;
    public abstract Fragment getlayouts(int layouts);





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mcontext).inflate(layout, null);
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        presenter=getPresenter();
        if (presenter!=null){
            presenter.attachView(this);
            initData();
        }
    }

    protected abstract void initview();


    protected abstract P getPresenter();
    protected abstract void initData();



    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }
}
