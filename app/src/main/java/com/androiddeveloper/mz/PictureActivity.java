package com.androiddeveloper.mz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.androiddeveloper.mz.bean.SimplePicture;

/**
 * Created by zzh on 16/4/25.
 */
public class PictureActivity extends AppCompatActivity {

    private ViewPager mViewPagerShowPicture;
    private PagerViewShowPictureAdapter mPagerAdapter;
    private static int sPosition = 0;
    private View mDecorView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_picture);
        mViewPagerShowPicture = (ViewPager) findViewById(R.id.viewpager_activity_picture_show_activity);
        mPagerAdapter = new PagerViewShowPictureAdapter(this);
        mViewPagerShowPicture.setAdapter(mPagerAdapter);
        mViewPagerShowPicture.setCurrentItem(sPosition);
        hideSystemUI();
    }

    public static void startPictureActivity(SimplePicture simplePicture, Context context) {
        sPosition = PictureInfo.sPictures.indexOf(simplePicture);
        context.startActivity(new Intent(context, PictureActivity.class));
    }

    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
}

