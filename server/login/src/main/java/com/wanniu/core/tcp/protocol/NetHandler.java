/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import com.wanniu.core.game.request.GClientEvent;
/*    */ import io.netty.channel.Channel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class NetHandler
/*    */ {
/*    */   private Channel __session__;
/*    */   private short type;
/*    */   
/*    */   public NetHandler() {
/* 15 */     GClientEvent handler = getClass().<GClientEvent>getAnnotation(GClientEvent.class);
/* 16 */     if (handler != null) {
/* 17 */       this.type = handler.type();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getType() {
/* 28 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void bindSession(Channel session) {
/* 33 */     this.__session__ = session;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(Message msg) {
/* 38 */     if (this.__session__ != null) {
/* 39 */       this.__session__.writeAndFlush(msg);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Message msg) {
/* 45 */     if (this.__session__ != null) {
/* 46 */       this.__session__.writeAndFlush(msg.getContent());
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void execute(Packet paramPacket);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isGateHandler() {
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int getRunIndex() {
/* 63 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\protocol\NetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */