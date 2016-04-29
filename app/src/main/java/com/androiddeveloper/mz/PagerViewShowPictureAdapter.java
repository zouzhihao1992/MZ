package com.androiddeveloper.mz;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by zzh on 16/4/25.
 */
public class PagerViewShowPictureAdapter extends PagerAdapter {

    private Context mContext;


    public PagerViewShowPictureAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return PictureInfo.sPictures.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view =  LayoutInflater.from(mContext).inflate(R.layout.activity_picture_show,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView_picture_activity_show);
        Picasso.with(mContext).load(PictureInfo.sPictures.get(position).getUrl()).into(imageView);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if(container.getChildAt(position)!=null && container.getChildCount() > 10){
            container.removeViewAt(position);
        }

    }


}
