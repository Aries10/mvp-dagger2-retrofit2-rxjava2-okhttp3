package com.bwei.frame;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 14:42
 */


public class Api {
    //http://baobab.kaiyanapp.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83

    //false代表线上 true 代表测试
    private static boolean isDebug = false;
    private static String onTestUrl = "http://baobab.kaiyanapp.com/";
    private static String onLineUrl = "http://baobab.kaiyanapp.com/";
    public static String url = baseUrl() + "api/v2/";
    //三目运算

    private static String baseUrl() {
        return isDebug ? onTestUrl : onLineUrl;
    }
}
