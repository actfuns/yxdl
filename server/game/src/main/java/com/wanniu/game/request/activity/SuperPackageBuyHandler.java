/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.prepaid.PrepaidService;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
/*    */ import pomelo.area.PrepaidHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.superPackageBuyRequest")
/*    */ public class SuperPackageBuyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     ActivityFavorHandler.SuperPackageBuyRequest req = ActivityFavorHandler.SuperPackageBuyRequest.parseFrom(this.pak.getRemaingBytes());
/* 21 */     int productId = req.getPackageId();
/* 22 */     int channelId = req.getChannelId();
/* 23 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     boolean isCard = false;
/* 25 */     String imei = req.getC2SImei();
/* 26 */     int os = req.getC2SOs();
/*    */     
/* 28 */     if (!player.activityManager.SuperPackage_GetBoughtable(productId)) {
/*    */       
/* 30 */       final PrepaidHandler.PrepaidOrderIdResponse.Builder res = PrepaidHandler.PrepaidOrderIdResponse.newBuilder();
/* 31 */       res.setS2CCode(500);
/* 32 */       res.setS2CMsg(LangService.getValue("ACTIVITY_SUPERPACKAGE_HAVE_BOUGHT"));
/*    */       
/* 34 */       PomeloResponse me = new PomeloResponse()
/*    */         {
/*    */           protected void write() throws IOException
/*    */           {
/* 38 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/*    */         };
/* 41 */       return me;
/*    */     } 
/* 43 */     return PrepaidService.getInstance().createOrderId(productId, channelId, player, isCard, true, imei, os);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\SuperPackageBuyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */