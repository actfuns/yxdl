/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.buyShopItemRequest")
/*    */ public class ChangeShopItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     FarmHandler.ChangeShopItemRequest msg = FarmHandler.ChangeShopItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     final int itemId = msg.getItemId();
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           FarmHandler.ChangeShopItemResponse.Builder res = FarmHandler.ChangeShopItemResponse.newBuilder();
/* 26 */           FarmMgr farmMgr = player.farmMgr;
/*    */           
/* 28 */           boolean changeRes = farmMgr.ChangeShopItem(itemId);
/* 29 */           if (!changeRes) {
/*    */             
/* 31 */             res.setS2CCode(200);
/* 32 */             res.setS2CMsg(LangService.getValue("FARM_CANNOT_CHANGE"));
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           res.setS2CCode(200);
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\ChangeShopItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */