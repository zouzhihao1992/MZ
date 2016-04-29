package com.androiddeveloper.mz.net;

import com.androiddeveloper.mz.bean.PictureList;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zzh on 16/4/24.
 */
public interface NetApi {
    @Headers({"apikey:d614ea4e26e293c87fb3bd90188b33df"})
    @GET("tngou/gallery/list")
    Observable<PictureList> GetPictureList(@Query("id") String id,@Query("rows") String rows,@Query("page") String page);
}
