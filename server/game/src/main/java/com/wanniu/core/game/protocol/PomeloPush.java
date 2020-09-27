/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PomeloPush
/*    */   extends PomeloResponse
/*    */ {
/*    */   public PomeloPush() {
/* 13 */     this.type = 3;
/* 14 */     (getHeader()).route_s = getRoute();
/*    */   }
/*    */   
/*    */   public ByteBuf getContent() {
/* 18 */     return super.getContent().slice();
/*    */   }
/*    */   
/*    */   public abstract String getRoute();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\protocol\PomeloPush.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */