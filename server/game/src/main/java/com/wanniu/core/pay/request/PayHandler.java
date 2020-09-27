/*    */ package com.wanniu.core.pay.request;
/*    */ 
/*    */ import com.wanniu.core.pay.PayClient;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PayHandler
/*    */   extends NetHandler
/*    */ {
/*    */   protected static final byte CALLBACK_DEFAULT = 0;
/*    */   
/*    */   public void send(Message msg) {
/* 16 */     PayClient.getInstance().add(msg);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\pay\request\PayHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */