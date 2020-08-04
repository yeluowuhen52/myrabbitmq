package com.myrabbitmq.myrabbitmq.utils;

/**
 * @Author: Jiang
 * @Description: 钉钉请求地址
 * @Date: 2020-08-04 16:33
 * @Version: 1.0
 * @Update:
 */
public class DingDingApi {
    /**
     * 基础信息接口
     */
    public static class Agent {
        /**
         * 获取AccessToken
         */
        public static String getToken = "/gettoken";
    }

    /**
     * 用户相关接口
     */
    public static class User {
        /**
         * 通过手机号获取用户信息
         */
        public static String getByMobile = "/user/get_by_mobile";
    }

    /**
     * 消息相关接口
     */
    public static class TopApi {
        /**
         * 发送消息
         */
        public static String getCorpconversationAsyncsend_v2 = "/topapi/message/corpconversation/asyncsend_v2";
    }
}
