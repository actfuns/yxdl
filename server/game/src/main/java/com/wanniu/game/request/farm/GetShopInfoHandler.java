/*    */ package com.wanniu.game.request.farm;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.bag.WNBag;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.PlantShopCO;
/*    */ import com.wanniu.game.farm.FarmMgr;
/*    */ import com.wanniu.game.item.ItemUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.Common;
/*    */ import pomelo.farm.Farm;
/*    */ import pomelo.farm.FarmHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("farm.farmHandler.getShopInfoRequest")
/*    */ public class GetShopInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     FarmHandler.GetShopInfoRequest msg = FarmHandler.GetShopInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           FarmHandler.GetShopInfoResponse.Builder res = FarmHandler.GetShopInfoResponse.newBuilder();
/* 31 */           FarmMgr farmMgr = player.farmMgr;
/* 32 */           for (PlantShopCO plantShopCO : GameData.PlantShops.values()) {
/* 33 */             Farm.ShopItemInfo.Builder sb = Farm.ShopItemInfo.newBuilder();
/* 34 */             sb.setItemId(plantShopCO.iD);
/* 35 */             if (farmMgr.myPO.shopToday.containsKey(Integer.valueOf(plantShopCO.iD))) {
/*    */               
/* 37 */               sb.setChangeNumCurrent(((Integer)farmMgr.myPO.shopToday.get(Integer.valueOf(plantShopCO.iD))).intValue());
/*    */             }
/*    */             else {
/*    */               
/* 41 */               sb.setChangeNumCurrent(0);
/*    */             } 
/* 43 */             sb.setChangeNumMax(plantShopCO.changeNum);
/* 44 */             List<WNBag.SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(plantShopCO.parameter);
/* 45 */             for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/* 46 */               Common.KeyValueStruct.Builder kvBuilder = Common.KeyValueStruct.newBuilder();
/* 47 */               kvBuilder.setKey(simpleItemInfo.itemCode);
/* 48 */               kvBuilder.setValue(String.valueOf(simpleItemInfo.itemNum));
/* 49 */               sb.addNeed(kvBuilder.build());
/*    */             } 
/*    */             
/* 52 */             simpleItemInfos = ItemUtil.parseString(plantShopCO.itemCode);
/* 53 */             for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
/* 54 */               Common.KeyValueStruct.Builder kvBuilder = Common.KeyValueStruct.newBuilder();
/* 55 */               kvBuilder.setKey(simpleItemInfo.itemCode);
/* 56 */               kvBuilder.setValue(String.valueOf(simpleItemInfo.itemNum));
/* 57 */               sb.addAward(kvBuilder.build());
/*    */             } 
/*    */           } 
/*    */ 
/*    */           
/* 62 */           res.setS2CCode(200);
/* 63 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\farm\GetShopInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */