/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.logfs.Out;
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
/* 18 */     GClientEvent handler = getClass().<GClientEvent>getAnnotation(GClientEvent.class);
/* 19 */     if (handler != null) {
/* 20 */       this.type = handler.type();
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
/* 31 */     return this.type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void bindSession(Channel session) {
/* 36 */     this.__session__ = session;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Message msg) {
/* 41 */     if (this.__session__ != null) {
/* 42 */       if (!this.__session__.isActive()) {
/* 43 */         GPlayer pl = (GPlayer)this.__session__.attr(GGlobal.__KEY_PLAYER).get();
/* 44 */         String pId = (pl == null) ? "" : pl.getId();
/* 45 */         Out.warn(new Object[] { "send msg warning noActivity,pid=", pId });
/* 46 */       } else if (!this.__session__.isWritable()) {
/* 47 */         GPlayer pl = (GPlayer)this.__session__.attr(GGlobal.__KEY_PLAYER).get();
/* 48 */         String pId = (pl == null) ? "" : pl.getId();
/* 49 */         Out.warn(new Object[] { "send msg warning noWriteable,pid=", pId });
/*    */       } else {
/* 51 */         this.__session__.writeAndFlush(msg, this.__session__.voidPromise());
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
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
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int getRunIndex() {
/* 70 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\protocol\NetHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */