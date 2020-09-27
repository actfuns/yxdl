/*    */ package com.wanniu.game.request.shopmall;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.ext.ShopMallItemsExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.shopMall.ShopMallConfig;
/*    */ import com.wanniu.game.shopMall.ShopMallManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ShopMallHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.shopMallHandler.buyMallItemRequest")
/*    */ public class BuyMallItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     GPlayer player = this.pak.getPlayer();
/* 26 */     ShopMallHandler.BuyMallItemRequest req = ShopMallHandler.BuyMallItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     String itemId = req.getC2SItemId();
/* 28 */     int count = req.getC2SCount();
/* 29 */     String playerId = req.getC2SPlayerId();
/* 30 */     int bDiamond = req.getC2SBDiamond();
/*    */     
/* 32 */     if (itemId == null || count <= 0 || playerId == null || count > 9999) {
/* 33 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */ 
/*    */     
/* 37 */     ShopMallItemsExt mallItemProp = ShopMallConfig.getInstance().fingShowMallItemByID(itemId);
/* 38 */     if (!GWorld.DEBUG && mallItemProp != null && mallItemProp.itemType == 199) {
/* 39 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 42 */     WNPlayer wPlayer = (WNPlayer)player;
/* 43 */     ShopMallManager.ShopMallResult result = wPlayer.shopMallManager.buyMallItem(itemId, count, playerId, bDiamond);
/*    */     
/* 45 */     final ShopMallHandler.BuyMallItemResponse.Builder res = ShopMallHandler.BuyMallItemResponse.newBuilder();
/*    */     
/* 47 */     if (result.result) {
/* 48 */       res.setTotalNum(result.totalNum);
/* 49 */       res.setS2CCode(200);
/*    */     } else {
/* 51 */       if (!result.msg.equals(LangService.getValue("BAG_NOT_ENOUGH_POS")))
/*    */       {
/* 53 */         return (PomeloResponse)new ErrorResponse(result.msg);
/*    */       }
/* 55 */       return (PomeloResponse)new ErrorResponse();
/*    */     } 
/*    */ 
/*    */     
/* 59 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 62 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\shopmall\BuyMallItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */