package com.androiddeveloper.mz.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zzh on 16/4/24.
 */
public class RetrofitApibuider {
    private NetApi netApi;
    private final static String BASE_URL = "http://apis.baidu.com/";
    public RetrofitApibuider(){
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();
        netApi = retrofit.create(NetApi.class);
    }

    public NetApi getNetInterface(){
        return netApi;
    }

}
