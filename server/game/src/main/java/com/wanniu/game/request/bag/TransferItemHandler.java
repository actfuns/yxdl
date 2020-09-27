/*    */ package com.wanniu.game.request.bag;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.BagUtil;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
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
/*    */ @GClientEvent("area.bagHandler.transferItemRequest")
/*    */ public class TransferItemHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 32 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 34 */     BagHandler.TransferItemRequest req = BagHandler.TransferItemRequest.parseFrom(this.pak.getRemaingBytes());
/* 35 */     int fromType = req.getC2SFromType();
/* 36 */     int fromIndex = req.getC2SFromIndex();
/* 37 */     int toType = req.getC2SToType();
/* 38 */     int num = req.getC2SNum();
/*    */     
/* 40 */     if (fromType == toType) {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 44 */     WNBag fromStore = BagUtil.getStoreByType(player, fromType);
/* 45 */     WNBag toStore = BagUtil.getStoreByType(player, toType);
/* 46 */     if (fromStore == null || toStore == null) {
/* 47 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 50 */     NormalItem item = fromStore.getItem(fromIndex);
/* 51 */     if (item == null) {
/* 52 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NULL"));
/*    */     }
/*    */     
/* 55 */     if (toType == Const.BAG_TYPE.WAREHOUSE.getValue() && 
/* 56 */       !item.canDepotRole()) {
/* 57 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("ITEM_NOT_STORE"));
/*    */     }
/*    */ 
/*    */     
/* 61 */     if (item.itemDb.groupCount < num || num <= 0) {
/* 62 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 65 */     Const.ForceType forceType = item.isBinding() ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
/* 66 */     if (!toStore.testAddCodeItem(item.itemDb.code, num, forceType, true)) {
/* 67 */       String str = "";
/* 68 */       if (toType == Const.BAG_TYPE.BAG.getValue()) {
/* 69 */         str = LangService.getValue("BAG_NOT_ENOUGH_POS");
/* 70 */       } else if (toType == Const.BAG_TYPE.WAREHOUSE.getValue()) {
/* 71 */         str = LangService.getValue("WAREHOUSE_SPACE_NOT_ENOUGH");
/*    */       } 
/* 73 */       return (PomeloResponse)new ErrorResponse(LangService.getValue(str));
/*    */     } 
/*    */     
/* 76 */     if (item.itemDb.groupCount != num) {
/*    */       
/* 78 */       fromStore.discardItemByPos(fromIndex, num, false, Const.GOODS_CHANGE_TYPE.move);
/* 79 */       NormalItem newItem = ItemUtil.createItemsByItemCode(item.itemDb.code, num).get(0);
/* 80 */       newItem.itemDb.isNew = 0;
/* 81 */       newItem.setBind(item.getBind());
/* 82 */       toStore.addEntityItem(newItem, Const.GOODS_CHANGE_TYPE.move, null, true, true);
/*    */     } else {
/* 84 */       item.itemDb.isNew = 0;
/* 85 */       fromStore.removeItemByPos(fromIndex, false, Const.GOODS_CHANGE_TYPE.move);
/* 86 */       toStore.addEntityItem(item, Const.GOODS_CHANGE_TYPE.move, null, true, true);
/*    */     } 
/*    */     
/* 89 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 92 */           BagHandler.TransferItemResponse.Builder res = BagHandler.TransferItemResponse.newBuilder();
/* 93 */           res.setS2CCode(200);
/* 94 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\bag\TransferItemHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */