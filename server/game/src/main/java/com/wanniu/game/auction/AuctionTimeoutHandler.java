/*     */ package com.wanniu.game.auction;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.poes.AuctionItemPO;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.Arrays;
/*     */ import org.apache.commons.lang3.StringUtils;
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
/*     */ public class AuctionTimeoutHandler
/*     */   implements Runnable
/*     */ {
/*     */   private final String id;
/*     */   
/*     */   public AuctionTimeoutHandler(String id) {
/*  36 */     this.id = id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  41 */     AuctionItemPO item = AuctionDataManager.getInstance().getAuctionItem(this.id);
/*  42 */     if (item == null) {
/*     */       return;
/*     */     }
/*  45 */     synchronized (item) {
/*     */       
/*  47 */       switch (item.state) {
/*     */         case 1:
/*  49 */           updateAuctionState(item);
/*     */           break;
/*     */         case 2:
/*  52 */           updateShowState(item);
/*     */           break;
/*     */         default:
/*  55 */           Out.warn(new Object[] { "竞拍物品出现非法状态了.", Integer.valueOf(item.state) });
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateShowState(AuctionItemPO item) {
/*  63 */     if (StringUtils.isEmpty(item.guildId)) {
/*  64 */       AuctionService.getInstance().settlementAttribution(item);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  69 */       String playerId = item.playerId;
/*  70 */       if (StringUtils.isEmpty(playerId)) {
/*  71 */         Out.debug(new Object[] { "竟拍物品流入世界竟拍.id=", item.id });
/*     */         
/*  73 */         AuctionService.getInstance().syncRemoveAuctionItem(item);
/*     */ 
/*     */         
/*  76 */         String guildId = item.guildId;
/*  77 */         if (StringUtils.isNotEmpty(guildId)) {
/*  78 */           int type = 3;
/*  79 */           GWorld.getInstance().ansycExec(() -> AuctionService.getInstance().log(guildId, playerId, type, item.db.code, item.curPrice));
/*     */         } 
/*     */ 
/*     */         
/*  83 */         if (AuctionDataManager.getInstance().canEnterWorld(item.db.code)) {
/*  84 */           item.state = 1;
/*  85 */           item.guildId = null;
/*  86 */           LocalDateTime now = LocalDateTime.now();
/*  87 */           item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_WorldShowTime);
/*     */ 
/*     */           
/*  90 */           AuctionService.getInstance().addDelayJob(now, item);
/*     */ 
/*     */           
/*  93 */           AuctionService.getInstance().syncAddAuctionItemInfo(Arrays.asList(new AuctionItemPO[] { item }, ), 2);
/*     */ 
/*     */           
/*  96 */           AuctionService.getInstance().processWorldAuctionsPoint();
/*     */         } else {
/*  98 */           Out.info(new Object[] { "世界竞拍此物品已达上限，直接回收掉...id=", item.id });
/*  99 */           item.state = 1;
/* 100 */           item.guildId = null;
/* 101 */           AuctionService.getInstance().settlementAttribution(item);
/*     */         } 
/*     */         
/* 104 */         JobFactory.addDelayJob(() -> AuctionService.getInstance().trySendAuctionBonus(guildId), 100000L);
/*     */       }
/*     */       else {
/*     */         
/* 108 */         AuctionService.getInstance().settlementAttribution(item);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateAuctionState(AuctionItemPO item) {
/* 114 */     Out.debug(new Object[] { "竟拍物品切换竟拍状态.id=", item.id });
/*     */     
/* 116 */     LocalDateTime now = LocalDateTime.now();
/* 117 */     item.state = 2;
/*     */     
/* 119 */     if (StringUtils.isEmpty(item.guildId)) {
/* 120 */       item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_WorldBiddingTime);
/*     */     }
/*     */     else {
/*     */       
/* 124 */       item.stateOverTime = now.plusMinutes(GlobalConfig.Auction_GuildBiddingTime);
/*     */     } 
/*     */ 
/*     */     
/* 128 */     AuctionService.getInstance().addDelayJob(now, item);
/*     */ 
/*     */     
/* 131 */     AuctionService.getInstance().syncAuctionItemInfo(item);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\auction\AuctionTimeoutHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */