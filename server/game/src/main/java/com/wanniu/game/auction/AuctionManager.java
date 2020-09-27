/*     */ package com.wanniu.game.auction;
/*     */ 
/*     */ import com.google.protobuf.GeneratedMessage;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ModuleManager;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildBossPo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.PlayerHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuctionManager
/*     */   extends ModuleManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   
/*     */   public AuctionManager(WNPlayer player) {
/*  39 */     this.player = player;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushScript() {
/*  46 */     PlayerHandler.SuperScriptPush.Builder data = PlayerHandler.SuperScriptPush.newBuilder();
/*  47 */     List<PlayerHandler.SuperScriptType> list = getSuperScript();
/*  48 */     if (list != null && !list.isEmpty()) {
/*  49 */       data.addAllS2CData(list);
/*  50 */       this.player.receive("area.playerPush.onSuperScriptPush", (GeneratedMessage)data.build());
/*     */     } 
/*  52 */     this.player.guildManager.pushRedPoint();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/*  57 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/*  58 */     list.add(getGuildScript().build());
/*  59 */     list.add(getWorldScript().build());
/*  60 */     return list;
/*     */   }
/*     */   
/*     */   private PlayerHandler.SuperScriptType.Builder getGuildScript() {
/*  64 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  65 */     data.setType(Const.SUPERSCRIPT_TYPE.GUILD_AUCTION.getValue());
/*  66 */     String guildId = this.player.guildManager.getGuildId();
/*  67 */     if (StringUtil.isEmpty(guildId)) {
/*  68 */       data.setNumber(0);
/*  69 */       return data;
/*     */     } 
/*  71 */     boolean hasGuildAuction = AuctionDataManager.getInstance().hasGuildItem(guildId);
/*  72 */     if (hasGuildAuction) {
/*  73 */       data.setNumber(1);
/*     */     } else {
/*  75 */       data.setNumber(0);
/*     */     } 
/*  77 */     return data;
/*     */   }
/*     */   
/*     */   public boolean canGuildPush() {
/*  81 */     String guildId = this.player.guildManager.getGuildId();
/*  82 */     if (StringUtil.isEmpty(guildId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     boolean hasGuildAuction = AuctionDataManager.getInstance().hasGuildItem(guildId);
/*  86 */     return hasGuildAuction;
/*     */   }
/*     */   
/*     */   public boolean needUpdateRedPoint() {
/*  90 */     GuildBossPo guildBossPO = this.player.guildBossManager.getAndCheckUpdateGuildBossPo(this.player.player.id);
/*  91 */     boolean hasWorldAuction = AuctionDataManager.getInstance().hasWorldItem();
/*  92 */     return (hasWorldAuction && guildBossPO.aucpoint == 0);
/*     */   }
/*     */   
/*     */   private PlayerHandler.SuperScriptType.Builder getWorldScript() {
/*  96 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/*  97 */     data.setType(Const.SUPERSCRIPT_TYPE.WORLD_AUCTION.getValue());
/*  98 */     if (needUpdateRedPoint()) {
/*  99 */       data.setNumber(1);
/*     */     } else {
/* 101 */       data.setNumber(0);
/*     */     } 
/* 103 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Const.ManagerType getManagerType() {
/* 113 */     return Const.ManagerType.AUCTION;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\auction\AuctionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */