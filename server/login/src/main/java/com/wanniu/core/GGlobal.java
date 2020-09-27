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
/*    */ public interface GGlobal
/*    */   extends GFile, GConst
/*    */ {
/* 15 */   public static final AttributeKey<Integer> _KEY_CHANNEL_ID = AttributeKey.valueOf("_KEY_CHANNEL_ID");
/*    */ 
/*    */   
/* 18 */   public static final AttributeKey<String> _KEY_TOKEN = AttributeKey.valueOf("_KEY_TOKEN");
/*    */ 
/*    */   
/* 21 */   public static final AttributeKey<String> _KEY_USER_ID = AttributeKey.valueOf("_KEY_USER_ID");
/*    */ 
/*    */   
/* 24 */   public static final ByteOrder __BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
/*    */ 
/*    */   
/* 27 */   public static final int __BUFFER_CAPACITY = GConfig.getInstance().getInt("tcp.buffer.capacity", 256);
/*    */   
/* 29 */   public static final int __BODY_CAPACITY = GConfig.getInstance().getInt("tcp.body.capacity", 512);
/*    */   
/* 31 */   public static final int __REQUEST_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", 10240);
/*    */   
/* 33 */   public static final int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("tcp.response.maxlen", 524288);
/*    */ 
/*    */   
/* 36 */   public static final int __TPC_IDLE_TIME = GConfig.getInstance().getInt("tcp.time.idle", 60000);
/*    */ 
/*    */   
/* 39 */   public static final int __CLIENT_TIMEOUT = GConfig.getInstance().getInt("tcp.time.out", __TPC_IDLE_TIME);
/*    */ 
/*    */   
/* 42 */   public static final long __BATTLE_YIELD_TIME = GConfig.getInstance().getInt("game.battle.yield", 10);
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\GGlobal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */