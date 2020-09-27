/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import io.netty.channel.Channel;
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
/*    */ public abstract class NetHandler
/*    */ {
/*    */   private Channel __session__;
/*    */   private short type;
/*    */   
/*    */   public short getType() {
/* 22 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void bindSession(Channel session) {
/* 27 */     this.__session__ = session;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(Message msg) {
/* 32 */     if (this.__session__ != null) {
/* 33 */       this.__session__.writeAndFlush(msg);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Message msg) {
/* 39 */     if (this.__session__ != null) {
/* 40 */       this.__session__.writeAndFlush(msg.getContent());
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
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int getRunIndex() {
/* 57 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\tcp\protocol\NetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */