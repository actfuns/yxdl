/*    */ package com.wanniu.core.proxy.message;
/*    */ 
/*    */ import com.wanniu.core.GGame;
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
/*    */ 
/*    */ 
/*    */ public class ProxyPingMessage
/*    */   extends ResponseMessage
/*    */ {
/*    */   protected void write() throws IOException {
/* 22 */     this.body.writeShort(GGame.getInstance().getOnlineCount());
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 27 */     return 242;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\proxy\message\ProxyPingMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */