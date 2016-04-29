package com.androiddeveloper.mz.net;

/**
 * Created by zzh on 16/4/24.
 */
public class NetApiFactory  {
    private static NetApi netApi = null;

    public synchronized static NetApi getNetApi(){
        if (netApi == null){
            netApi = new RetrofitApibuider().getNetInterface();
        }
        return netApi;
    }
}
