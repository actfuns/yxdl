package com.wanniu.redis;

import com.wanniu.core.GConfig;
import com.wanniu.core.redis.Redis;


public class PublishCenter {
    private static Redis redis;

    static {
        String host = GConfig.getInstance().get("publish.redis.host", "127.0.0.1");
        int port = GConfig.getInstance().getInt("publish.redis.port", 6379);
        String password = GConfig.getInstance().get("publish.redis.password", null);
        int dbIndex = GConfig.getInstance().getInt("publish.redis.db", 1);
        redis = new Redis(host, port, password, dbIndex);
    }


    public static void publish(String channel, String message) {
        redis.publish(channel, message);
    }
}


