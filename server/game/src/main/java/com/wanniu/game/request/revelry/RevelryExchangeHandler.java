/*    */ package com.wanniu.game.request.revelry;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.KingCO;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.revelry.ActivityRevelryHandler;
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
/*    */ @GClientEvent("revelry.activityRevelryHandler.revelryExchangeRequest")
/*    */ public class RevelryExchangeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 30 */     ActivityRevelryHandler.RevelryExchangeRequest req = ActivityRevelryHandler.RevelryExchangeRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 32 */     int tabId = req.getId();
/* 33 */     KingCO template = (KingCO)GameData.Kings.get(Integer.valueOf(tabId));
/* 34 */     if (template == null) {
/* 35 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 38 */     int count = req.getNum();
/* 39 */     if (count <= 0 || count > 9999) {
/* 40 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("PARAM_ERROR"));
/*    */     }
/*    */     
/* 43 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */     
/* 46 */     int needNum = template.num2 * count;
/* 47 */     if (!player.getWnBag().isItemNumEnough(template.item2code, needNum)) {
/* 48 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("NOT_ENOUGH_ITEM"));
/*    */     }
/*    */ 
/*    */     
/* 52 */     int addNum = template.num1 * count;
/* 53 */     if (!player.getWnBag().testAddCodeItem(template.item1code, addNum)) {
/* 54 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("BAG_FULL"));
/*    */     }
/*    */     
/* 57 */     Out.info(new Object[] { "冲榜兑换物品，playerId=", player.getId(), ",name=", player.getName(), ",tabId=", Integer.valueOf(tabId), ",num=", Integer.valueOf(count) });
/*    */     
/* 59 */     player.getWnBag().discardItem(template.item2code, needNum, Const.GOODS_CHANGE_TYPE.REVELRY_EXCHANGE);
/*    */     
/* 61 */     player.getWnBag().addCodeItem(template.item1code, addNum, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.REVELRY_EXCHANGE);
/*    */     
/* 63 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 66 */           ActivityRevelryHandler.RevelryExchangeResponse.Builder result = ActivityRevelryHandler.RevelryExchangeResponse.newBuilder();
/* 67 */           result.setS2CCode(200);
/* 68 */           this.body.writeBytes(result.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\revelry\RevelryExchangeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */