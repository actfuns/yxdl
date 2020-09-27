/*    */ package com.wanniu.game.request.auction;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.auction.AuctionService;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.AuctionItemPO;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.auction.AuctionHandler;
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
/*    */ @GClientEvent("auction.auctionHandler.auctionListRequest")
/*    */ public class AuctionListHandle
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 42 */     AuctionHandler.AuctionListRequest request = AuctionHandler.AuctionListRequest.parseFrom(this.pak.getRemaingBytes());
/* 43 */     int type = request.getC2SType();
/*    */     
/* 45 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 47 */     final AuctionHandler.AuctionListResponse.Builder response = AuctionHandler.AuctionListResponse.newBuilder();
/*    */     
/* 49 */     List<AuctionItemPO> items = new ArrayList<>();
/* 50 */     switch (type) {
/*    */       case 1:
/* 52 */         response.setS2CBonus(player.guildManager.calAuctionBonus());
/* 53 */         items = AuctionService.getInstance().getGuildAuctionItemList(player);
/*    */         break;
/*    */       case 2:
/* 56 */         items = AuctionService.getInstance().getWorldAuctionItemList(player);
/*    */         break;
/*    */       case 3:
/* 59 */         items = AuctionService.getInstance().getSelfAuctionItemList(player);
/*    */         break;
/*    */       default:
/* 62 */         Out.warn(new Object[] { "拉取竞拍列表大类错误 type=", Integer.valueOf(type) });
/*    */         break;
/*    */     } 
/*    */     
/* 66 */     for (AuctionItemPO item : items) {
/* 67 */       response.addS2CData(AuctionService.getInstance().toAuctionItem(player, item));
/*    */     }
/*    */     
/* 70 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 73 */           response.setS2CCode(200);
/* 74 */           this.body.writeBytes(response.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\auction\AuctionListHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */