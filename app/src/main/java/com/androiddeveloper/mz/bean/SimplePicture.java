package com.androiddeveloper.mz.bean;

/**
 * Created by zzh on 16/4/25.
 */
public class SimplePicture {
    private String description;
    private String url;

    private static String BASE_IMG_URL = "http://tnfs.tngou.net/img";

    public SimplePicture(String description,String url){
        this.description = description;
        this.url = BASE_IMG_URL + url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
