package com.bwei.frame;

import com.bwei.frame.video.VideoInfo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 14:45
 */


public interface ApiService {
    //categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("categories")
    Flowable<List<VideoInfo>> getVideo(@Query("udid") String udid, @Query("vc") int vc);
}
