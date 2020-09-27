/*    */ package com.wanniu.game.request.sale;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.sale.SaleManager;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.SaleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.saleHandler.buyPageRequest")
/*    */ public class BuyPageHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     SaleHandler.BuyPageRequest req = SaleHandler.BuyPageRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final List<Integer> typeIds = req.getC2SSellIndexList();
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 27 */           SaleHandler.BuyPageResponse.Builder res = player.saleManager.handleBuyPage(typeIds);
/* 28 */           if (res.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/* 29 */             res.setS2CCode(200);
/*    */           } else {
/*    */             
/* 32 */             res.setS2CCode(500);
/*    */           } 
/* 34 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sale\BuyPageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */