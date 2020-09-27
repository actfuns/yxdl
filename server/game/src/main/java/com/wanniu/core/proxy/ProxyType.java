/*    */ package com.wanniu.core.proxy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ProxyType
/*    */ {
/*    */   public static final short JOIN = 255;
/*    */   public static final short PING = 242;
/*    */   public static final short REQUEST = 257;
/*    */   public static final short ENTER = 258;
/*    */   public static final short LEAVE = 259;
/*    */   public static final short AREA_RECEIVE = 497;
/*    */   public static final short DISPONSE = 498;
/*    */   public static final short DIE = 499;
/*    */   public static final short QUERY = 513;
/*    */   public static final short RESULT = 770;
/*    */   public static final short PLAYER_DATA = 1025;
/*    */   public static final short PLAYER_EVENT = 1026;
/*    */   public static final short TEAM = 1265;
/*    */   public static final short CHANGE_AREA = 1266;
/*    */   public static final short PLAYER_RECEIVE = 1267;
/*    */   public static final short SOLO_MATCH = 1281;
/*    */   public static final short SOLO_QUIT = 1282;
/*    */   public static final short SOLO_MATCH_OK = 1283;
/*    */   public static final short SOLO_JOIN = 1284;
/*    */   
/*    */   public enum ProxyMethod
/*    */   {
/* 37 */     M_DISPATCHER(10),
/* 38 */     M_CREATE(11),
/* 39 */     M_DISPONSE(12),
/* 40 */     M_LINES(13),
/* 41 */     M_TRANS_LINE(14);
/*    */     public final int value;
/*    */     
/*    */     ProxyMethod(int value) {
/* 45 */       this.value = value;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\proxy\ProxyType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */