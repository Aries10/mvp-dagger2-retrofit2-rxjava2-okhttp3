package com.bwei.frame.video;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 14:25
 */


public class VideoPresenter {
    //订阅管理器管理订阅者
    CompositeDisposable compositeDisposable = null;

    //实例化对象
    @Inject
    public VideoPresenter() {
    }

    //注入对象
    @Inject
    VideoModel videoModel;
    VideoView videoView;

    public void attachView(VideoView videoView) {
        this.videoView = videoView;
    }

    //p关联m
    public void relevance() {
        compositeDisposable = new CompositeDisposable();
        Flowable<List<VideoInfo>> flowable = videoModel.getData();
        DisposableSubscriber<List<VideoInfo>> disposableSubscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<VideoInfo>>() {
                    @Override
                    public void onNext(List<VideoInfo> videoInfos) {
                        Log.i("xxx", videoInfos.get(0).getName());
                        videoView.showView(videoInfos);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //解除关联
    public void detachView() {
        //false没有取消
        boolean disposed = compositeDisposable.isDisposed();
        Log.i("xxx", disposed + "");
        //没有取消才取消
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            Log.i("xxx", "取消了");
            compositeDisposable.dispose();

        }
        videoView = null;
    }

}
