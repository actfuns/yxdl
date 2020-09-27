/*     */ package com.wanniu.game.request.auction;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.protocol.PomeloRequest;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.auction.AuctionDataManager;
/*     */ import com.wanniu.game.auction.AuctionService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.ErrorResponse;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.RewardListCO;
/*     */ import com.wanniu.game.item.VirtualItemType;
/*     */ import com.wanniu.game.money.CostResult;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.AuctionItemPO;
/*     */ import java.io.IOException;
/*     */ import java.time.Duration;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.HashSet;
/*     */ import java.util.Optional;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import pomelo.auction.AuctionHandler;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @GClientEvent("auction.auctionHandler.auctionRequest")
/*     */ public class AuctionHandle
/*     */   extends PomeloRequest
/*     */ {
/*     */   public PomeloResponse request() throws Exception {
/*  56 */     AuctionHandler.AuctionRequest request = AuctionHandler.AuctionRequest.parseFrom(this.pak.getRemaingBytes());
/*  57 */     String id = request.getItemId();
/*  58 */     int price = request.getPrice();
/*     */ 
/*     */     
/*  61 */     AuctionItemPO item = AuctionDataManager.getInstance().getAuctionItem(id);
/*  62 */     if (item == null) {
/*  63 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("AUCTION_ITEM_NOT_EXSIT"));
/*     */     }
/*     */     
/*  66 */     synchronized (item) {
/*     */       
/*  68 */       if (item.state != 2) {
/*  69 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("AUCTION_NOT_START"));
/*     */       }
/*     */ 
/*     */       
/*  73 */       Optional<RewardListCO> template = GameData.RewardLists.values().stream().filter(v -> item.db.code.equals(v.code)).findFirst();
/*  74 */       if (!template.isPresent()) {
/*  75 */         Out.warn(new Object[] { "竞拍物品找不到竞价模板，code=", item.db.code });
/*  76 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*     */       } 
/*     */ 
/*     */       
/*  80 */       if (price < item.maxPrice && item.nextPrice != price) {
/*  81 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("AUCTION_PRICE_CHANGE"));
/*     */       }
/*     */       
/*  84 */       WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*     */ 
/*     */       
/*  87 */       if (StringUtils.isNotEmpty(item.guildId) && !item.guildId.equals(player.guildManager.getGuildId())) {
/*  88 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("AUCTION_NOT_GUILD"));
/*     */       }
/*     */ 
/*     */       
/*  92 */       price = Math.min(price, item.maxPrice);
/*     */ 
/*     */       
/*  95 */       CostResult result = player.moneyManager.costTicketAndDiamond(price, Const.GOODS_CHANGE_TYPE.AUCTION);
/*  96 */       if (!result.isSuccess()) {
/*  97 */         return (PomeloResponse)new ErrorResponse(LangService.getValue("TICKET_NOT_ENOUGH"));
/*     */       }
/*     */       
/* 100 */       int bonus = 0;
/*     */       
/* 102 */       if (StringUtils.isNotEmpty(item.playerId)) {
/* 103 */         bonus = price - item.curPrice;
/* 104 */         AuctionService.getInstance().restitution(item);
/*     */       } else {
/* 106 */         bonus = item.curPrice;
/*     */       } 
/* 108 */       player.guildManager.addAuctionBonus(bonus);
/*     */ 
/*     */       
/* 111 */       item.curPrice = price;
/* 112 */       item.nextPrice = Math.min(item.maxPrice, item.curPrice + ((RewardListCO)template.get()).addPrice * item.db.groupCount);
/* 113 */       item.playerId = player.getId();
/* 114 */       item.diamond = result.getValue(VirtualItemType.DIAMOND);
/* 115 */       item.ticket = result.getValue(VirtualItemType.CASH);
/*     */ 
/*     */       
/* 118 */       LocalDateTime now = LocalDateTime.now();
/* 119 */       long timeleft = Duration.between(now, item.stateOverTime).getSeconds();
/* 120 */       if (timeleft < GlobalConfig.Auction_LastAddTimes) {
/* 121 */         item.stateOverTime = now.plusSeconds(GlobalConfig.Auction_PerAddTimes + timeleft);
/* 122 */         AuctionService.getInstance().resetDelayJob(now, item);
/*     */       } 
/*     */ 
/*     */       
/* 126 */       if (item.participant == null) {
/* 127 */         item.participant = new HashSet();
/*     */       }
/* 129 */       item.participant.add(item.playerId);
/*     */ 
/*     */       
/* 132 */       if (item.curPrice >= item.maxPrice) {
/* 133 */         AuctionService.getInstance().settlementAttribution(item);
/*     */       }
/*     */       else {
/*     */         
/* 137 */         GWorld.getInstance().ansycExec(() -> AuctionService.getInstance().syncAuctionItemInfo(item));
/*     */       } 
/*     */     } 
/*     */     
/* 141 */     return new PomeloResponse()
/*     */       {
/*     */         protected void write() throws IOException {
/* 144 */           AuctionHandler.AuctionResponse.Builder response = AuctionHandler.AuctionResponse.newBuilder();
/* 145 */           response.setS2CCode(200);
/* 146 */           this.body.writeBytes(response.build().toByteArray());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\auction\AuctionHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */