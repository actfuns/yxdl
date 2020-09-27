/*    */ package com.wanniu.game.request.sale;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
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
/*    */ 
/*    */ @GClientEvent("area.saleHandler.sellItemsRequest")
/*    */ public class SellItemsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     SaleHandler.SellItemsRequest msg = SaleHandler.SellItemsRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final List<SaleHandler.SellGrid> sellGrids = msg.getC2SSellGridsList();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           SaleHandler.SellItemsResponse.Builder res = SaleHandler.SellItemsResponse.newBuilder();
/* 29 */           int result = player.saleManager.handleSellItems(sellGrids);
/*    */           
/* 31 */           if (result == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/*    */             
/* 33 */             res.setS2CCode(200);
/* 34 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_SELL_ITEMS_EMPTY.getValue()) {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("SALE_SELL_ITEMS_EMPTY"));
/* 38 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue()) {
/*    */             
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("SALE_ITEM_NOT_EXIST"));
/* 42 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOSELL.getValue()) {
/*    */             
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("SALE_ITEM_NOSELL"));
/* 46 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_PARAM_ERROR.getValue()) {
/*    */             
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*    */           } else {
/*    */             
/* 52 */             res.setS2CCode(500);
/* 53 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/* 55 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sale\SellItemsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */