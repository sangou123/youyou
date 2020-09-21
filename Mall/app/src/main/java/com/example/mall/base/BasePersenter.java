package com.example.mall.base;






import com.example.mall.interfse.IBasePersenter;
import com.example.mall.interfse.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

//P层基类

public abstract class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {
    protected V mView;//P层所关联的V层

    //弱引用V层,解决activity或者fragment使用MVP的内存泄露问题
    WeakReference<V> weakReference;

    //rxjava背压式网络请求处理
    CompositeDisposable compositeDisposable;

    @Override
    public void attachView(V v) {
        weakReference=new WeakReference<V>(v);
        mView=weakReference.get();
    }

    //把请求网络的数据对象加入到排列中
    public void addSubscribe(Disposable disposable){
        if (compositeDisposable!=null){
            compositeDisposable.add(disposable);
        }
    }

    //把排列对象同意清理
    public void clearSubscribe(){
        if (compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }

    //取消V层和P层关联
    //TODO
    @Override
    public void detachView() {
        mView=null;
        clearSubscribe();
    }
}
