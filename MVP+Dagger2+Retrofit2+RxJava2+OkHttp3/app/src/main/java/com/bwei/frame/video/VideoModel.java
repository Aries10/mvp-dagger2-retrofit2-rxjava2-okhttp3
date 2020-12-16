package com.bwei.frame.video;

import android.util.Log;

import com.bwei.frame.Api;
import com.bwei.frame.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 14:25
 */


public class VideoModel {
    //实例化对象
    @Inject
    public VideoModel() {
    }


    public Flowable<List<VideoInfo>> getData() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.url).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient).build();
        //通过动态代理获得网络接口代理对象
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<List<VideoInfo>> flowable = apiService.getVideo("26868b32e808498db32fd51fb422d00175e179df", 83);
        return flowable;


    }
}
