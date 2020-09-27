/*    */ package com.wanniu.core.pay.message;
/*    */ 
/*    */ import com.wanniu.core.game.message.ResponseMessage;
/*    */ import java.io.IOException;
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
/*    */ public class PayPingMessage
/*    */   extends ResponseMessage
/*    */ {
/*    */   protected void write() throws IOException {}
/*    */   
/*    */   public short getType() {
/* 21 */     return 242;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\pay\message\PayPingMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */