/*     */ package com.wanniu.game.cross;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.game.protocol.PomeloPush;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CrossServerArea
/*     */   extends CrossServerLocalArea
/*     */ {
/*     */   private boolean isLocal;
/*     */   
/*     */   public CrossServerArea(JSONObject opts) {
/*  23 */     super(opts);
/*  24 */     if (opts.containsKey("lineIndex")) {
/*  25 */       this.lineIndex = opts.getIntValue("lineIndex");
/*     */     }
/*  27 */     this.isLocal = !opts.containsKey("exists");
/*     */   }
/*     */   
/*     */   public void init() {
/*  31 */     super.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerEntered(final WNPlayer player) {
/*  36 */     super.onPlayerEntered(player);
/*  37 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/*  40 */             this.body.writeString(CrossServerArea.this.instanceId);
/*  41 */             this.body.writeString(player.getId());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/*  46 */             return 258;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerLeaved(final WNPlayer player) {
/*  53 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/*  56 */             this.body.writeString(CrossServerArea.this.instanceId);
/*  57 */             this.body.writeString(player.getId());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/*  62 */             return 259;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  69 */     if (this.isLocal) {
/*  70 */       super.dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void receive(final PomeloPush push) {
/*  76 */     ProxyClient.getInstance().add(new Message()
/*     */         {
/*     */           protected void write() throws IOException {
/*  79 */             this.body.writeString(CrossServerArea.this.instanceId);
/*  80 */             this.body.writeBuffer(push.getContent());
/*     */           }
/*     */ 
/*     */           
/*     */           public short getType() {
/*  85 */             return 497;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUnitDead(JSONObject msg) {
/*  92 */     int unitType = msg.getIntValue("unitType");
/*  93 */     if (unitType == 1) {
/*  94 */       final String unitPlayerId = msg.getString("unitPlayerId");
/*  95 */       final String hitFinalPlayerId = msg.getString("hitFinal");
/*     */       
/*  97 */       WNPlayer deadPlayer = getPlayer(unitPlayerId);
/*  98 */       if (deadPlayer != null) {
/*  99 */         pushRelive(deadPlayer);
/*     */       } else {
/* 101 */         ProxyClient.getInstance().add(new Message()
/*     */             {
/*     */               protected void write() throws IOException {
/* 104 */                 this.body.writeString(CrossServerArea.this.instanceId);
/* 105 */                 this.body.writeString(unitPlayerId);
/* 106 */                 this.body.writeString(hitFinalPlayerId);
/*     */               }
/*     */ 
/*     */               
/*     */               public short getType() {
/* 111 */                 return 499;
/*     */               }
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\cross\CrossServerArea.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */