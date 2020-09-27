/*    */ package com.wanniu.game.request.auction;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.auction.AuctionService;
/*    */ import java.io.IOException;
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
/*    */ @GClientEvent("auction.auctionHandler.cancelSyncAuctionInfoRequest")
/*    */ public class CancelSyncAuctionInfoHandle
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 36 */     AuctionService.getInstance().cancelSyncRequest(this.pak.getPlayer().getId());
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           this.body.writeBytes(AuctionHandler.CancelSyncAuctionInfoResponse.newBuilder().setS2CCode(200).build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\auction\CancelSyncAuctionInfoHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */