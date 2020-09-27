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
/*    */ @GClientEvent("area.saleHandler.rebuyItemRequest")
/*    */ public class RebuyItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     SaleHandler.RebuyItemRequest msg = SaleHandler.RebuyItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 22 */     final int gridIndex = msg.getC2SGridIndex();
/* 23 */     final int num = msg.getC2SNum();
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           SaleHandler.RebuyItemResponse.Builder res = SaleHandler.RebuyItemResponse.newBuilder();
/* 29 */           int result = player.saleManager.handleRebuyItem(gridIndex, num);
/*    */           
/* 31 */           if (result == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/*    */             
/* 33 */             res.setS2CCode(200);
/* 34 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_ITEM_NOT_EXIST.getValue()) {
/*    */             
/* 36 */             res.setS2CCode(500);
/* 37 */             res.setS2CMsg(LangService.getValue("SALE_ITEM_NOT_EXIST"));
/* 38 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_PARAM_ERROR.getValue()) {
/*    */             
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 42 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue()) {
/*    */             
/* 44 */             res.setS2CCode(500);
/* 45 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 46 */           } else if (result == SaleManager.ERR_CODE.ERR_CODE_BAG_NOT_ENOUGH_POS.getValue()) {
/*    */             
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sale\RebuyItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */