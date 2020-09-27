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
/*    */ @GClientEvent("area.saleHandler.autoBuyItemByCodeRequest")
/*    */ public class AutoBuyItemByCodeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     SaleHandler.AutoBuyItemByCodeRequest msg = SaleHandler.AutoBuyItemByCodeRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final List<Integer> typeIds = msg.getC2STypeIdList();
/* 24 */     final String itemCode = msg.getC2SItemCode();
/* 25 */     final int num = msg.getC2SNum();
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           SaleHandler.AutoBuyItemByCodeResponse.Builder result = player.saleManager.handleAutoBuyItemByTypeCode(typeIds, itemCode, num);
/*    */           
/* 31 */           if (result.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_OK.getValue()) {
/*    */             
/* 33 */             result.setS2CCode(200);
/* 34 */             this.body.writeBytes(result.build().toByteArray()); return;
/*    */           } 
/* 36 */           if (result.getS2CCode() == SaleManager.ERR_CODE.ERR_CODE_GOLD_NOT_ENOUGH.getValue()) {
/*    */             
/* 38 */             result.setS2CCode(200);
/* 39 */             result.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 40 */             result.setS2CNotEnoughGold(1);
/* 41 */             int needValue = result.getS2CNeedGold();
/* 42 */             result.setS2CNeedGold(needValue);
/* 43 */             this.body.writeBytes(result.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           result.setS2CCode(200);
/* 47 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\sale\AutoBuyItemByCodeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */