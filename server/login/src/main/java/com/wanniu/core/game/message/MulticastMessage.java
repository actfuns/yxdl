/*    */ package com.wanniu.core.game.message;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MulticastMessage
/*    */   extends PomeloResponse
/*    */ {
/*    */   public ByteBuf getContent() {
/* 16 */     return super.getContent().slice();
/*    */   }
/*    */   
/*    */   public String getRoute() {
/* 20 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\message\MulticastMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */