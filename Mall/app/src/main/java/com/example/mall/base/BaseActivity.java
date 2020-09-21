package com.example.mall.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mall.interfse.IBasePersenter;
import com.example.mall.interfse.IBaseView;


public abstract class BaseActivity<P extends IBasePersenter> extends AppCompatActivity implements IBaseView {

    protected P persenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设计模式中的模板方法调用
        setContentView(getLayout());
        initView();
        persenter=initPresenter();
        //P层不为空时候调用获取数据的方法,否则容易出现空指针
        if (persenter!=null){
            //P层与V层关联
            persenter.attachView(this);
            initData();
            Log.d("TAG", "baseactivity");

        }
    }
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract P initPresenter();

    protected abstract void initData();







    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }

    //取消V层和P层关联
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (persenter!=null)
            persenter.detachView();
    }
   /* @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("BaseActivity"); // [统计页面(仅有Activity的应用中SDK自动调用,不需要单独写。参数为页面名称,可自定义)]
        MobclickAgent.onResume(this);// 友盟统计，所有Activity中添加，父类添加后子类不用重复添加
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("BaseActivity"); // [(仅有Activity的应用中SDK自动调用,不需要单独写)保证onPageEnd在onPause之前调用,因为onPause中会保存信息。参数页面名称,可自定义]
        MobclickAgent.onPause(this);// 友盟统计，所有Activity中添加，父类添加后子类不用重复添加
    }*/
}
