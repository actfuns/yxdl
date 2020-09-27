/*    */ package com.wanniu.core.gm.request;
/*    */ 
/*    */ import com.wanniu.core.gm.GMClient;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GMHandler
/*    */   extends NetHandler
/*    */ {
/*    */   protected static final byte CALLBACK_DEFAULT = 0;
/*    */   
/*    */   public void sendGM(Message msg) {
/* 17 */     GMClient.getInstance().add(msg);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\request\GMHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */