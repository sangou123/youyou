package com.example.mall.interfse;

//P层接口基类,用来约束管理进来的V层接口
public interface IBasePersenter<T extends IBaseView> {
    //V层接口的关联
    void attachView(T t);

    //V层的取消关联
    void detachView();
}
