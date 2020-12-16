package com.bwei.frame.video;

import com.bwei.frame.MainActivity;

import dagger.Component;

/**
 * 1. 类的用途 桥梁 关联容器和调用者
 * 2. @author forever
 * 3. @date 2017/12/4 14:31
 */

@Component(modules = VideoModule.class)
public interface VideoComponent {
    void inject(MainActivity mainActivity);
}
