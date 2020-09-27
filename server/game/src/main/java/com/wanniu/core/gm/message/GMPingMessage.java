/*    */ package com.wanniu.core.gm.message;
/*    */ 
/*    */ import com.wanniu.core.GGame;
/*    */ import com.wanniu.core.game.message.ResponseMessage;
/*    */ import com.wanniu.core.gm.GMType;
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
/*    */ public class GMPingMessage
/*    */   extends ResponseMessage
/*    */ {
/*    */   protected void write() throws IOException {
/* 22 */     this.body.writeShort(GGame.getInstance().getOnlineCount());
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 27 */     return GMType.PING;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\message\GMPingMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */