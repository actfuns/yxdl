/*    */ package com.wanniu.game.request.bag;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.BagUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.BagHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.bagHandler.openBagGridRequest")
/*    */ public class OpenBagGridHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 29 */     BagHandler.OpenBagGridRequest req = BagHandler.OpenBagGridRequest.parseFrom(this.pak.getRemaingBytes());
/* 30 */     final int type_from = req.getC2SType();
/* 31 */     final int num = req.getC2SNumber();
/*    */     
/* 33 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 36 */           BagHandler.OpenBagGridResponse.Builder res = BagHandler.OpenBagGridResponse.newBuilder();
/*    */           
/* 38 */           if (num <= 0) {
/* 39 */             res.setS2CCode(500);
/* 40 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 41 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 45 */           WNBag store = BagUtil.getStoreByType(player, type_from);
/* 46 */           if (store == null) {
/* 47 */             res.setS2CCode(500);
/* 48 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 49 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 53 */           int needDiamond = num * BagUtil.getGridPrice(type_from);
/*    */           
/* 55 */           if (!player.moneyManager.enoughTicketAndDiamond(needDiamond)) {
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(LangService.getValue("DIAMAND_NOT_ENOUGH"));
/* 58 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 62 */           if (store.openGrid(num))
/*    */           {
/* 64 */             player.moneyManager.costTicketAndDiamond(needDiamond, Const.GOODS_CHANGE_TYPE.openbag);
/*    */           }
/*    */           
/* 67 */           res.setS2CCode(200);
/* 68 */           res.setS2CBagGridCount(store.bagPO.bagGridCount);
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\bag\OpenBagGridHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */