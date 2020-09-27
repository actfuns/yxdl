package com.wanniu.core;

import io.netty.util.AttributeKey;

import java.nio.ByteOrder;


public interface GGlobal
        extends GFile, GConst {
    public static final String L_JGAME = "jgame";
    public static final AttributeKey<Boolean> __KEY_LOGIN = AttributeKey.valueOf("__KEY.PLAYER.LOGIN__");

    public static final AttributeKey<Integer> __KEY_REMOTE = AttributeKey.valueOf("__KEY.PLAYER.REMOTE__");


    public static final AttributeKey<Boolean> _KEY_SECOND_PWD = AttributeKey.valueOf("_KEY_SECOND_PWD");

    public static final AttributeKey<Byte> _KEY_SECOND_PWD_ERR = AttributeKey.valueOf("_KEY_SECOND_PWD_ERR");


    public static final AttributeKey<Integer> _KEY_CHANNEL_ID = AttributeKey.valueOf("_KEY_CHANNEL_ID");


    public static final AttributeKey<String> _KEY_TOKEN = AttributeKey.valueOf("_KEY_TOKEN");


    public static final AttributeKey<String> _KEY_USER_ID = AttributeKey.valueOf("_KEY_USER_ID");


    public static final AttributeKey<String> _KEY_USER_NAME = AttributeKey.valueOf("_KEY_USER_NAME");


    public static final AttributeKey<Integer> _KEY_ROLE_COUNT = AttributeKey.valueOf("_KEY_ROLE_COUNT");


    public static final AttributeKey<Integer> _KEY_LOGICSERVERID = AttributeKey.valueOf("Integer");


    public static final byte __HEAD_CALLBACK_REMOTE = 127;


    public static final byte __HEAD_CALLBACK_DEFAULT = -1;

    public static final ByteOrder __BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;


    public static final int __BUFFER_CAPACITY = GConfig.getInstance().getInt("tcp.buffer.capacity", 256);

    public static final int __BODY_CAPACITY = GConfig.getInstance().getInt("tcp.body.capacity", 512);

    public static final int __REQUEST_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", 10240);

    public static final int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("tcp.response.maxlen", 524288);


    public static final int __TPC_IDLE_TIME = GConfig.getInstance().getInt("tcp.time.idle", 60000);


    public static final int __CLIENT_TIMEOUT = GConfig.getInstance().getInt("tcp.time.out", __TPC_IDLE_TIME);


    public static final long __BATTLE_YIELD_TIME = GConfig.getInstance().getInt("game.battle.yield", 10);
}


