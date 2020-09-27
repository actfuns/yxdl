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
/*    */ @GClientEvent("auction.auctionHandler.syncAuctionInfoRequest")
/*    */ public class SyncAuctionInfoHandle
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 36 */     AuctionService.getInstance().addSyncRequest(this.pak.getPlayer().getId());
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           this.body.writeBytes(AuctionHandler.SyncAuctionInfoResponse.newBuilder().setS2CCode(200).build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\auction\SyncAuctionInfoHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */