/*    */ package com.wanniu.core;
/*    */ 
/*    */ import cn.qeng.common.login.TokenInfo;
/*    */ import com.wanniu.core.game.entity.GPlayer;
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
/*    */ public interface GGlobal
/*    */   extends GFile, GConst
/*    */ {
/* 18 */   public static final AttributeKey<GPlayer> __KEY_PLAYER = AttributeKey.valueOf("__KEY_PLAYER");
/*    */ 
/*    */   
/* 21 */   public static final AttributeKey<Boolean> __KEY_SECURITY = AttributeKey.valueOf("__KEY_SECURITY");
/*    */ 
/*    */   
/* 24 */   public static final AttributeKey<String> __KEY_TOKEN = AttributeKey.valueOf("__KEY_TOKEN");
/*    */ 
/*    */   
/* 27 */   public static final AttributeKey<String> __KEY_USER_ID = AttributeKey.valueOf("__KEY_USER_ID");
/*    */ 
/*    */   
/* 30 */   public static final AttributeKey<Integer> __KEY_ROLE_COUNT = AttributeKey.valueOf("__KEY_ROLE_COUNT");
/*    */ 
/*    */   
/* 33 */   public static final AttributeKey<Integer> __KEY_LOGIC_SERVERID = AttributeKey.valueOf("__KEY_LOGIC_SERVERID");
/*    */ 
/*    */   
/* 36 */   public static final AttributeKey<Boolean> __KEY_SESSION_TIMEOUT = AttributeKey.valueOf("__KEY_SESSION_TIMEOUT");
/*    */   
/* 38 */   public static final AttributeKey<TokenInfo> __KEY_TOKEN_INFO = AttributeKey.valueOf("__KEY_TOKEN_INFO");
/*    */ 
/*    */   
/*    */   public static final byte __HEAD_CALLBACK_REMOTE = 127;
/*    */ 
/*    */   
/*    */   public static final byte __HEAD_CALLBACK_DEFAULT = -1;
/*    */   
/* 46 */   public static final ByteOrder __BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
/*    */ 
/*    */   
/* 49 */   public static final int __BUFFER_CAPACITY = GConfig.getInstance().getInt("tcp.buffer.capacity", 256);
/*    */   
/* 51 */   public static final int __BODY_CAPACITY = GConfig.getInstance().getInt("tcp.body.capacity", 512);
/*    */   
/* 53 */   public static final int __REQUEST_MAX_LEN = GConfig.getInstance().getInt("tcp.request.maxlen", 10240);
/*    */   
/* 55 */   public static final int __RESPONSE_MAX_LEN = GConfig.getInstance().getInt("tcp.response.maxlen", 524288);
/*    */ 
/*    */   
/* 58 */   public static final int __TPC_IDLE_TIME = GConfig.getInstance().getInt("tcp.time.idle", 60000);
/*    */ 
/*    */   
/* 61 */   public static final int __CLIENT_TIMEOUT = GConfig.getInstance().getInt("tcp.time.out", __TPC_IDLE_TIME);
/*    */ 
/*    */   
/* 64 */   public static final long __BATTLE_YIELD_TIME = GConfig.getInstance().getInt("game.battle.yield", 10);
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GGlobal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */