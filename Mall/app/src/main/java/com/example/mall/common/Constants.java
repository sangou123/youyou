package com.example.mall.common;





import com.example.mall.app.MyApp;

import java.io.File;

public class Constants {
    public static final String homeapi="https://cdwan.cn/api/";


    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/myll";
}