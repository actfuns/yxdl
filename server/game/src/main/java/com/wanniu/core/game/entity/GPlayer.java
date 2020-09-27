/*     */ package com.wanniu.core.game.entity;
/*     */ 
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.channel.Channel;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GPlayer
/*     */ {
/*  19 */   public static volatile long Buf = 0L;
/*  20 */   public static volatile long Count = 0L;
/*     */   
/*     */   protected Channel session;
/*  23 */   protected byte state = 0;
/*     */   
/*     */   private Date logoutDate;
/*     */   
/*     */   public long modifyTime;
/*     */   
/*     */   public final Watcher watcher;
/*     */ 
/*     */   
/*     */   public void bind(Channel session) {
/*  33 */     this.session = session;
/*  34 */     session.attr(GGlobal.__KEY_PLAYER).set(this);
/*  35 */     GGame.getInstance().addPlayer(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getState() {
/*  43 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(byte state) {
/*  47 */     this.state = state;
/*     */   }
/*     */ 
/*     */   
/*     */   public Channel getSession() {
/*  52 */     return this.session;
/*     */   }
/*     */   
/*     */   public static class Watcher { public int count;
/*     */     public long buf;
/*     */     
/*     */     public void inrc(ByteBuf buf) {
/*  59 */       if (!GGame.MONITOR)
/*  60 */         return;  this.buf += buf.readableBytes();
/*  61 */       this.count++;
/*     */     } }
/*     */   
/*     */   public GPlayer() {
/*  65 */     this.watcher = new Watcher();
/*     */     this.modifyTime = System.currentTimeMillis();
/*     */   } public void endWatch() {
/*  68 */     if (GGame.MONITOR) {
/*  69 */       Buf += this.watcher.buf;
/*  70 */       Count += this.watcher.count;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void receive(Message msg) {
/*  76 */     if (this.session != null) {
/*  77 */       msg.getContent();
/*  78 */       this.watcher.inrc(msg.getContent());
/*  79 */       this.session.writeAndFlush(msg);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Message msg) {
/*  85 */     if (this.session != null) {
/*  86 */       this.watcher.inrc(msg.getContent());
/*  87 */       this.session.writeAndFlush(msg.getContent());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLogoutTime() {
/*  93 */     return this.logoutDate;
/*     */   }
/*     */   
/*     */   public void setLogoutTime(Date date) {
/*  97 */     this.logoutDate = date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doLogout(boolean self) {
/* 107 */     setState((byte)0);
/* 108 */     Date date = new Date();
/* 109 */     this.logoutDate = date;
/* 110 */     setLogoutTime(date);
/* 111 */     GGame.getInstance().removePlayer(this);
/* 112 */     if (!self) {
/* 113 */       GGame.getInstance().addWaitPlayer(this);
/*     */     }
/* 115 */     onLogout(self);
/* 116 */     sync();
/*     */   }
/*     */   
/*     */   public void bindBattleServer(String serverId) {}
/*     */   
/*     */   public abstract String getId();
/*     */   
/*     */   public abstract void onLogout(boolean paramBoolean);
/*     */   
/*     */   public abstract String getUid();
/*     */   
/*     */   public abstract String getBattleServerId();
/*     */   
/*     */   public abstract String getName();
/*     */   
/*     */   public abstract void sync();
/*     */   
/*     */   public abstract void free();
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\entity\GPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */