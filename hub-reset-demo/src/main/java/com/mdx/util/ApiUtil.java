package com.mdx.util;

import cn.hutool.http.HttpUtil;

import java.util.Map;

/**
 * 调用外部接口使用
 * @author Mengdl
 * @date 2023/11/13
 */
public class ApiUtil {

    /**
     * post请求
     * @param url 地址
     * @param head 请求头
     * @param jsonStr body
     * @return 返回结果
     */
    public static String post(String url, Map<String, String> head, String jsonStr) {
        return HttpUtil
                .createPost(url)
                .addHeaders(head)
                .body(jsonStr)
                .execute()
                .body();
    }

    /**
     * get请求
     * @param url 地址
     * @param head 请求头
     * @param form 表单
     * @return 返回结果
     */
    public static String get(String url, Map<String, String> head, Map<String, Object> form) {
        return HttpUtil
                .createGet(url)
                .addHeaders(head)
                .form(form)
                .execute()
                .body();
    }


}
