package com.androiddeveloper.mz.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzh on 16/4/24.
 */
public class PictureList {


    /**
     * status : true
     * total : 714
     * tngou : [{"count":890,"fcount":0,"galleryclass":1,"id":728,"img":"/ext/160417/677ab7206386e96d45dfa67e719f4335.jpg","rcount":0,"size":6,"time":1460857234000,"title":"粉嫩少女"},{"count":540,"fcount":0,"galleryclass":5,"id":727,"img":"/ext/160417/9f77927365e2fc34f895bfe373dc2af2.jpg","rcount":0,"size":7,"time":1460857120000,"title":"赵雨菲清纯白诱惑"},{"count":427,"fcount":0,"galleryclass":4,"id":726,"img":"/ext/160417/fc9d6b190c5300159d82b4579378bcbf.jpg","rcount":0,"size":5,"time":1460857085000,"title":"媚娘花枝招展的青春"},{"count":346,"fcount":0,"galleryclass":5,"id":725,"img":"/ext/160417/5980119433ef21b42e40358e26a6ede3.jpg","rcount":0,"size":6,"time":1460857039000,"title":"校花李岩西绝美诱惑组图"},{"count":268,"fcount":0,"galleryclass":4,"id":724,"img":"/ext/160415/e4b0f5a3cb74bdaa9c7e3e01186fa467.jpg","rcount":0,"size":6,"time":1460697398000,"title":"简洁的审美"},{"count":3143,"fcount":0,"galleryclass":6,"id":723,"img":"/ext/160415/11c1b32ba00145b351390941b97c0224.jpg","rcount":0,"size":8,"time":1460697305000,"title":"清纯女孩清新照"},{"count":113,"fcount":0,"galleryclass":4,"id":722,"img":"/ext/160415/35e4a2d4adbdfb61191d67748874c39a.jpg","rcount":0,"size":6,"time":1460697249000,"title":"清纯可人的小美女"},{"count":3689,"fcount":0,"galleryclass":6,"id":721,"img":"/ext/160408/e65ae3efd6d166c3c88e1679c7d5a383.jpg","rcount":0,"size":10,"time":1460114354000,"title":"小萝莉清纯照 "},{"count":2030,"fcount":0,"galleryclass":6,"id":720,"img":"/ext/160408/fcacfc698fc887758af9528c87e111ec.jpg","rcount":0,"size":9,"time":1460114312000,"title":"清凉秋日清纯少女"},{"count":1419,"fcount":0,"galleryclass":6,"id":719,"img":"/ext/160408/728c12c0936d89e4af50719aefd57611.jpg","rcount":0,"size":8,"time":1460114274000,"title":"90后卖萌女女 "},{"count":1374,"fcount":0,"galleryclass":6,"id":718,"img":"/ext/160408/57417c559e8fb923bcafce294a20f49c.jpg","rcount":0,"size":6,"time":1460114248000,"title":"国内最清纯漂亮大学校花"},{"count":1157,"fcount":0,"galleryclass":1,"id":717,"img":"/ext/160408/1d3a87c0a012024db834eeba9f28d891.jpg","rcount":0,"size":9,"time":1460114220000,"title":"清纯美女明星李七喜"},{"count":826,"fcount":0,"galleryclass":2,"id":716,"img":"/ext/160408/b6938f83adf37b1eeb1c320bd5842b88.jpg","rcount":0,"size":23,"time":1460114164000,"title":"清纯女孩松嶋ののか私房诱惑美图"},{"count":281,"fcount":0,"galleryclass":4,"id":715,"img":"/ext/160408/839f087b1aca9921a111cc39b3e0e880.jpg","rcount":0,"size":7,"time":1460114142000,"title":"白皙美女皮肤如牛奶一般"},{"count":846,"fcount":0,"galleryclass":1,"id":714,"img":"/ext/160408/d80563951d37941965b3c5819247b923.jpg","rcount":0,"size":16,"time":1460114121000,"title":"娇俏mm绮里嘉清纯脸蛋不忘露纹身"},{"count":184,"fcount":0,"galleryclass":4,"id":713,"img":"/ext/160408/b7c7473b7ff6e7a936d917cbd3043c35.jpg","rcount":0,"size":11,"time":1460114090000,"title":"可爱小猫女清新写真"},{"count":1215,"fcount":0,"galleryclass":6,"id":712,"img":"/ext/160408/5768277643936ae4c565ce24bb8e003b.jpg","rcount":0,"size":20,"time":1460114061000,"title":"台湾E胸果小糖迷人自拍图片"},{"count":368,"fcount":0,"galleryclass":5,"id":711,"img":"/ext/160408/c382655e564848d8809a062d76764403.jpg","rcount":0,"size":6,"time":1460114020000,"title":"性感美女黑丝抹胸户外写真 "},{"count":6760,"fcount":0,"galleryclass":3,"id":710,"img":"/ext/160321/e57d5816cb72d7486aa6dbf19a7d0c6c.jpg","rcount":0,"size":16,"time":1458561029000,"title":"很诱人的美女翘臀诱惑那超波肉丝腿真长"},{"count":2890,"fcount":0,"galleryclass":3,"id":709,"img":"/ext/160321/0443e950c8e75792ef033472c9071f44.jpg","rcount":0,"size":10,"time":1458560993000,"title":"性感腿模诱人黑丝腿魔鬼身材真美"}]
     */

    private boolean status;
    private int total;
    /**
     * count : 890
     * fcount : 0
     * galleryclass : 1
     * id : 728
     * img : /ext/160417/677ab7206386e96d45dfa67e719f4335.jpg
     * rcount : 0
     * size : 6
     * time : 1460857234000
     * title : 粉嫩少女
     */

    private List<TngouBean> tngou;

    public static PictureList objectFromData(String str) {

        return new Gson().fromJson(str, PictureList.class);
    }

    public static PictureList objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), PictureList.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<PictureList> arrayPictureListFromData(String str) {

        Type listType = new TypeToken<ArrayList<PictureList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<PictureList> arrayPictureListFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<PictureList>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public static TngouBean objectFromData(String str) {

            return new Gson().fromJson(str, TngouBean.class);
        }

        public static TngouBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), TngouBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<TngouBean> arrayTngouBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TngouBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<TngouBean> arrayTngouBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<TngouBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
