/*    */ package com.wanniu.game.request.sale;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.sale.SaleManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SaleHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.saleHandler.buyItemRequest")
/*    */ public class BuyItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     SaleHandler.BuyItemRequest msg = SaleHandler.BuyItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int typeId = msg.getC2STypeId();
/* 23 */     final int itemId = msg.getC2SItemId();
/* 24 */     final int num = msg.getC2SNum();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           SaleHandler.BuyItemResponse.Builder res = SaleHandler.BuyItemResponse.newBuilder();
/* 29 */           int result = player.saleManager.handleBuyItem(typeId, itemId, num, false);
/* 30 */           if (result == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/* 31 */             res.setS2CCode(200);
/* 32 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue()) {
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(LangService.getValue("SALE_ITEM_NOT_EXIST"));
/* 35 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue()) {
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 38 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_TICKET_NOT_ENOUGH.getValue()) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("TICKET_NOT_ENOUGH"));
/* 41 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_DIAMAND_NOT_ENOUGH.getValue()) {
/* 42 */             res.setS2CCode(500);
/* 43 */             res.setS2CMsg("");
/* 44 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue()) {
/*    */             
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/*    */           } else {
/* 49 */             res.setS2CCode(500);
/* 50 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/* 52 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sale\BuyItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */