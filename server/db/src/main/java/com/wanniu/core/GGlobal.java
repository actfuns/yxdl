/*    */ package com.wanniu.core;
/*    */ 
/*    */ import io.netty.util.AttributeKey;
/*    */ import java.nio.ByteOrder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface GGlobal
/*    */   extends GFile, GConst
/*    */ {
/*    */   public static final String L_JGAME = "jgame";
/* 18 */   public static final AttributeKey<Boolean> __KEY_LOGIN = AttributeKey.valueOf("__KEY.PLAYER.LOGIN__");
/*    */   
/* 20 */   public static final AttributeKey<Integer> __KEY_REMOTE = AttributeKey.valueOf("__KEY.PLAYER.REMOTE__");
/*    */ 
/*    */   
/* 23 */   public static final AttributeKey<Boolean> _KEY_SECOND_PWD = AttributeKey.valueOf("_KEY_SECOND_PWD");
/*    */   
/* 25 */   public static final AttributeKey<Byte> _KEY_SECOND_PWD_ERR = AttributeKey.valueOf("_KEY_SECOND_PWD_ERR");
/*    */ 
/*    */   
/* 28 */   public static final AttributeKey<Integer> _KEY_CHANNEL_ID = AttributeKey.valueOf("_KEY_CHANNEL_ID");
/*    */ 
/*    */   
/* 31 */   public static final AttributeKey<String> _KEY_TOKEN = AttributeKey.valueOf("_KEY_TOKEN");
/*    */ 
/*    */   
/* 34 */   public static final AttributeKey<String> _KEY_USER_ID = AttributeKey.valueOf("_KEY_USER_ID");
/*    */ 
/*    */   
/* 37 */   public static final AttributeKey<String> _KEY_USER_NAME = AttributeKey.valueOf("_KEY_USER_NAME");
/*    */ 
/*    */   
/* 40 */   public static final AttributeKey<Integer> _KEY_ROLE_COUNT = AttributeKey.valueOf("_KEY_ROLE_COUNT");
/*    */ 
/*    */   
/* 43 */   public static final AttributeKey<Integer> _KEY_LOGICSERVERID = AttributeKey.valueOf("Integer");
/*    */ 
/*    */   
/*    */   public static final byte __HEAD_CALLBACK_REMOTE = 127;
/*    */ 
/*    */   
/*    */   public static final byte __HEAD_CALLBACK_DEFAULT = -1;
/*    */   
/* 51 */   public static final ByteOrder __BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
/*    */ 
/*    */   
/* 54 */   public static final int __BUFFER_CAPACITY = GConfig.getInstance().getInt("tcp.buffer.capacity", 256);
/*    */   
/* 56 */   public static final int __BODY_CAPACITY = GConfig.getInstance().getInt("tcp.body.capacity", 512);
/*    */   
/* 58 */   public static final int __REQUEST_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", 10240);
/*    */   
/* 60 */   public static final int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("tcp.response.maxlen", 524288);
/*    */ 
/*    */   
/* 63 */   public static final int __TPC_IDLE_TIME = GConfig.getInstance().getInt("tcp.time.idle", 60000);
/*    */ 
/*    */   
/* 66 */   public static final int __CLIENT_TIMEOUT = GConfig.getInstance().getInt("tcp.time.out", __TPC_IDLE_TIME);
/*    */ 
/*    */   
/* 69 */   public static final long __BATTLE_YIELD_TIME = GConfig.getInstance().getInt("game.battle.yield", 10);
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\GGlobal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */