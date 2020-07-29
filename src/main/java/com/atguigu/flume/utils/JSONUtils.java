package com.atguigu.flume.utils;


import com.alibaba.fastjson.JSON;

/**
 * Created by Myron on 2020/7/28.
 */
public class JSONUtils {
    //构造方法私有化
    private JSONUtils() {}

    public static boolean isJSONValidate(String log) {
        try {
            JSON.parse(log);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
