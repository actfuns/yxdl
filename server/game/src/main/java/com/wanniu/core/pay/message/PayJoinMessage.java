/*    */ package com.wanniu.core.pay.message;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PayJoinMessage
/*    */   extends Message
/*    */ {
/*    */   protected void write() throws IOException {
/* 16 */     this.body.writeInt(GGame.__SERVER_ID);
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 21 */     return 241;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\pay\message\PayJoinMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */