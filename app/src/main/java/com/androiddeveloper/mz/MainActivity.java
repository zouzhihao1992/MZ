package com.androiddeveloper.mz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.androiddeveloper.mz.bean.PictureList;
import com.androiddeveloper.mz.bean.SimplePicture;
import com.androiddeveloper.mz.net.NetApi;
import com.androiddeveloper.mz.net.NetApiFactory;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayoutForRefresh;
    private RecyclerView mRecyclerViewShowPicture;
    private MainRecyclerViewAdapter mMainRecyclerViewAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private static final int ADD_PICTURE_START = 0;
    private static final int ADD_PICTURE_END = 1;

    private int id = 6;
    private int id_start = 6;
    private int id_end = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_share);
        setSupportActionBar(mToolbar);
        initSwipeRefreshLayout();
        initRecyclerView();
        setLoadMore();
        getPictureListFormNet(ADD_PICTURE_START);
    }


    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayoutForRefresh = (SwipeRefreshLayout)
                findViewById(R.id.swiperefreshlayout_mainactivity_forrefresh);

        mSwipeRefreshLayoutForRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //更新数据
                Log.d("zzh", "swipeRefreshLayout 更新数据");
                getPictureListFormNet(ADD_PICTURE_START);
            }
        });
    }

    /**
     * 设置上拉加载更多
     */
    private void setLoadMore() {
        mRecyclerViewShowPicture.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dy应该表示的是初始位置减去结束位置
                boolean isbottom = mMainRecyclerViewAdapter.getItemCount() - mStaggeredGridLayoutManager.findLastVisibleItemPositions(new int[2])[1] <= 6;
                if (isbottom && !mSwipeRefreshLayoutForRefresh.isRefreshing() && dy > 0) {
                    //加载底部数据
                    getPictureListFormNet(ADD_PICTURE_END);
                    //底部数据加载完毕
                    Log.d("zzh", "加载底部数据完毕");
                    mSwipeRefreshLayoutForRefresh.setRefreshing(false);
                }
            }

        });

    }

    private void initRecyclerView() {
        mRecyclerViewShowPicture = (RecyclerView) findViewById(R.id.recyclerview_mainactivity_show_pictures);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMainRecyclerViewAdapter = new MainRecyclerViewAdapter(this);
        mRecyclerViewShowPicture.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerViewShowPicture.setAdapter(mMainRecyclerViewAdapter);
    }

    private void getPictureListFormNet(final int location) {
        mSwipeRefreshLayoutForRefresh.setRefreshing(true);
        NetApi netApi = NetApiFactory.getNetApi();
        if (location == ADD_PICTURE_START){
            //下拉刷新
            id_start--;
            if (id_start < 0){
                id_start = 0;
            }
            id = id_start;

        }else if(location == ADD_PICTURE_END){
            //上拉加载更多
            id_end++;
            id = id_end;
        }
        Log.d("zzh","Id = " + id);
        Observable<PictureList> observable = netApi.GetPictureList("0","20",id+"");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PictureList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("zzh", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("zzh", "onError" + e.toString());

                    }

                    @Override
                    public void onNext(PictureList pictureList) {
                        Log.d("zzh", "onNext");
                        List<SimplePicture> list = new ArrayList<SimplePicture>();
                        if (pictureList != null) {
                            if (pictureList.getTngou() !=null){
                                for (PictureList.TngouBean picture : pictureList.getTngou()) {
                                    list.add(new SimplePicture(picture.getTitle(), picture.getImg()));
                                }
                                if (location == ADD_PICTURE_END){
                                    PictureInfo.addPictures(list,PictureInfo.ADD_AT_END);

                                }else if(location == ADD_PICTURE_START){
                                    PictureInfo.addPictures(list,PictureInfo.ADD_AT_START);

                                }


                                mMainRecyclerViewAdapter.notifyDataSetChanged();

                            }

                        }
                        mSwipeRefreshLayoutForRefresh.setRefreshing(false);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                break;
        }

        return true;
    }
}
