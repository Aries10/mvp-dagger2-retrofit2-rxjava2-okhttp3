package com.bwei.frame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bwei.frame.video.DaggerVideoComponent;
import com.bwei.frame.video.VideoInfo;
import com.bwei.frame.video.VideoModule;
import com.bwei.frame.video.VideoPresenter;
import com.bwei.frame.video.VideoView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements VideoView {
    //注入对象
    @Inject
    VideoPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到桥梁对象并注入调用者对象
        DaggerVideoComponent.builder().videoModule(new VideoModule(this)).build().inject(this);
        //关联view
        presenter.attachView(this);
        //关联model
        presenter.relevance();
    }

    @Override
    public void showView(List<VideoInfo> videoInfos) {
    //把数据给适配器

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
