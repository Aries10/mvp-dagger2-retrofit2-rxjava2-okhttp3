package com.bwei.frame.video;

import dagger.Module;

/**
 * 1. 类的用途 容器-实例化对象
 * 2. @author forever
 * 3. @date 2017/12/4 14:27
 */

@Module
public class VideoModule {

    private VideoView videoView;
    //构造传参初始化 上下文
    public VideoModule(VideoView videoView) {
        this.videoView = videoView;
    }


}
