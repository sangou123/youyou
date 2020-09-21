package com.example.mall.mole.api;



import com.example.mall.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Apicrevit {
    @GET("index")
    Flowable<HomeBean>gethomebann();
}
