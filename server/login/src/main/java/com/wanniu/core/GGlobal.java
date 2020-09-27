package com.wanniu.core;

import io.netty.util.AttributeKey;

import java.nio.ByteOrder;


public interface GGlobal
        extends GFile, GConst {
    public static final AttributeKey<Integer> _KEY_CHANNEL_ID = AttributeKey.valueOf("_KEY_CHANNEL_ID");


    public static final AttributeKey<String> _KEY_TOKEN = AttributeKey.valueOf("_KEY_TOKEN");


    public static final AttributeKey<String> _KEY_USER_ID = AttributeKey.valueOf("_KEY_USER_ID");


    public static final ByteOrder __BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;


    public static final int __BUFFER_CAPACITY = GConfig.getInstance().getInt("tcp.buffer.capacity", 256);

    public static final int __BODY_CAPACITY = GConfig.getInstance().getInt("tcp.body.capacity", 512);

    public static final int __REQUEST_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", 10240);

    public static final int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("tcp.response.maxlen", 524288);


    public static final int __TPC_IDLE_TIME = GConfig.getInstance().getInt("tcp.time.idle", 60000);


    public static final int __CLIENT_TIMEOUT = GConfig.getInstance().getInt("tcp.time.out", __TPC_IDLE_TIME);


    public static final long __BATTLE_YIELD_TIME = GConfig.getInstance().getInt("game.battle.yield", 10);
}


