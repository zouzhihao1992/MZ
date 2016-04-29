package com.androiddeveloper.mz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by zzh on 16/4/24.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {


    private Context mContext;

    public MainRecyclerViewAdapter(Context context){
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pictures, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final  int pos = position;
        holder.textView.setText(PictureInfo.sPictures.get(position).getDescription());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("zzh","点击图片"+PictureInfo.sPictures.get(pos).getDescription());
                //启动pictureActivty,传入对应的SimplePicture对象。
                PictureActivity.startPictureActivity(PictureInfo.sPictures.get(pos),mContext);
            }
        });

        Picasso.with(mContext).load(PictureInfo.sPictures.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return PictureInfo.sPictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_item_description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView_item_show_picture);
        }
    }



}