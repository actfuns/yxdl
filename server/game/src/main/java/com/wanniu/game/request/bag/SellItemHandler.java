/*    */ package com.wanniu.game.request.bag;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.BagUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.item.NormalItem;
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
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.bagHandler.sellItemRequest")
/*    */ public class SellItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 31 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 32 */     WNBag wnBag = player.getWnBag();
/*    */     
/* 34 */     BagHandler.SellItemRequest req = BagHandler.SellItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     final int index = req.getC2SGridIndex();
/* 36 */     final int num = req.getC2SNum();
/*    */     
/* 38 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 41 */           BagHandler.SellItemResponse.Builder res = BagHandler.SellItemResponse.newBuilder();
/*    */ 
/*    */           
/* 44 */           NormalItem item = player.bag.getItem(index);
/* 45 */           if (item == null) {
/* 46 */             res.setS2CCode(500);
/* 47 */             res.setS2CMsg(LangService.getValue("ITEM_NULL"));
/*    */             
/*    */             return;
/*    */           } 
/* 51 */           if (!item.canSell()) {
/* 52 */             res.setS2CCode(500);
/* 53 */             res.setS2CMsg(LangService.getValue("ITEM_CAN_NOT_SELL"));
/*    */             
/*    */             return;
/*    */           } 
/* 57 */           if (item.itemDb.groupCount < num || num <= 0) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/*    */             
/*    */             return;
/*    */           } 
/* 63 */           int price = BagUtil.getSellPrice(item.price(), num);
/*    */           
/* 65 */           int delNum = num;
/*    */ 
/*    */           
/* 68 */           if (item.itemDb.groupCount != num) {
/*    */             
/* 70 */             player.bag.discardItemByPos(index, num, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 71 */             NormalItem newItem = ItemUtil.createItemsByItemCode(item.itemDb.code, num).get(0);
/* 72 */             newItem.itemDb.isNew = 0;
/* 73 */             newItem.setBind(item.getBind());
/* 74 */             player.recycle.addEntityItem(newItem, Const.GOODS_CHANGE_TYPE.clear_when_logout, null, true, true);
/*    */           } else {
/* 76 */             item.itemDb.isNew = 0;
/* 77 */             delNum = item.itemDb.groupCount;
/* 78 */             player.bag.removeItemByPos(index, true, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 79 */             player.recycle.addEntityItem(item, Const.GOODS_CHANGE_TYPE.clear_when_logout, null, true, true);
/*    */           } 
/*    */           
/* 82 */           player.moneyManager.addGold(price, Const.GOODS_CHANGE_TYPE.clear_when_logout);
/* 83 */           if (item.prop.itemSecondType == Const.ItemSecondType.gem.getValue());
/*    */ 
/*    */ 
/*    */           
/* 87 */           res.setS2CCode(200);
/* 88 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\bag\SellItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */