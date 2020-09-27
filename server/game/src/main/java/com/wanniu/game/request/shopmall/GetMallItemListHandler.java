/*    */ package com.wanniu.game.request.shopmall;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ShopMallConfigCO;
/*    */ import com.wanniu.game.player.GlobalConfig;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import pomelo.area.ShopMallHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.shopMallHandler.getMallItemListRequest")
/*    */ public class GetMallItemListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     ShopMallHandler.GetMallItemListRequest req = ShopMallHandler.GetMallItemListRequest.parseFrom(this.pak.getRemaingBytes());
/* 31 */     GPlayer player = this.pak.getPlayer();
/* 32 */     final WNPlayer wPlayer = (WNPlayer)player;
/*    */     
/* 34 */     final int itemType = req.getC2SItemType();
/*    */ 
/*    */ 
/*    */     
/* 38 */     final ShopMallConfigCO shopMallConfigCO = (ShopMallConfigCO)GameData.ShopMallConfigs.get(Integer.valueOf(itemType));
/* 39 */     if (shopMallConfigCO == null)
/*    */     {
/* 41 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 64 */           ShopMallHandler.GetMallItemListResponse.Builder res = ShopMallHandler.GetMallItemListResponse.newBuilder();
/*    */           
/* 66 */           ArrayList<ShopMallHandler.MallItem.Builder> items = wPlayer.shopMallManager.getMallItemList(itemType);
/* 67 */           int endTime = 0;
/*    */           
/* 69 */           if (wPlayer.shopMallManager.isOpenOfMallTab(itemType)) {
/* 70 */             Date now = new Date();
/* 71 */             Calendar c = Calendar.getInstance();
/* 72 */             c.setTime(now);
/* 73 */             int nowHour = c.get(11);
/* 74 */             int onSaleTime = 1;
/* 75 */             int shelfTime = 1;
/* 76 */             if (shopMallConfigCO.consumeType == Const.SHOP_MALL_CONSUME_TYPE.DIAMOND.getValue()) {
/* 77 */               onSaleTime = GlobalConfig.Shop_OnSaleTime_Diamond;
/* 78 */               shelfTime = GlobalConfig.Shop_ShelfTime_Diamond;
/*    */             } else {
/* 80 */               onSaleTime = GlobalConfig.Shop_OnSaleTime_Ticket;
/* 81 */               shelfTime = GlobalConfig.Shop_ShelfTime_Ticket;
/*    */             } 
/* 83 */             if (nowHour >= onSaleTime && nowHour < shelfTime) {
/* 84 */               c.set(11, shelfTime);
/* 85 */               c.set(12, 0);
/* 86 */               c.set(13, 0);
/* 87 */               endTime = (int)Math.ceil((now.getTime() / 1000L));
/*    */             } 
/*    */           } else {
/*    */             
/* 91 */             endTime = -1;
/*    */           } 
/* 93 */           res.setS2CCode(200);
/* 94 */           res.setS2CEndTime(endTime);
/* 95 */           for (int i = 0; i < items.size(); i++) {
/* 96 */             res.addS2CItems(((ShopMallHandler.MallItem.Builder)items.get(i)).build());
/*    */           }
/* 98 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\shopmall\GetMallItemListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */