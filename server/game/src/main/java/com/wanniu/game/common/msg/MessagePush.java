/*    */ package com.wanniu.game.common.msg;
/*    */ 
/*    */ import com.google.protobuf.GeneratedMessage;
/*    */ import com.wanniu.core.game.protocol.PomeloPush;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessagePush
/*    */   extends PomeloPush
/*    */ {
/*    */   private GeneratedMessage msg;
/*    */   private String route;
/*    */   
/*    */   public MessagePush(String route, GeneratedMessage msg) {
/* 20 */     this.msg = msg;
/* 21 */     this.route = route;
/* 22 */     (getHeader()).route_s = route;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 27 */     this.body.writeBytes(this.msg.toByteArray());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRoute() {
/* 32 */     return this.route;
/*    */   }
/*    */   
/*    */   public GeneratedMessage getMsg() {
/* 36 */     return this.msg;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\msg\MessagePush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */