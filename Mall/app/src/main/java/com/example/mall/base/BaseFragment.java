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


public abstract class BaseFragment<P extends IBasePersenter> extends Fragment implements IBaseView {
    public Context mcontext;
    protected P presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mcontext=getContext();
        initView();
        presenter=getPresenter();
        if (presenter!=null){
            presenter.attachView(this);
            initData();
        }
    }
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract P getPresenter();

    protected abstract void initData();




    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }

}
