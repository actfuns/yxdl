/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.ActivityManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.prepaid.PrepaidManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.superPackageGetInfoRequest")
/*    */ public class SuperPackageGetinfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     ActivityFavorHandler.SuperPackageGetInfoRequest req = ActivityFavorHandler.SuperPackageGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 26 */           WNPlayer player = (WNPlayer)SuperPackageGetinfoHandler.this.pak.getPlayer();
/*    */           
/* 28 */           ActivityManager activityManager = player.activityManager;
/* 29 */           PrepaidManager prepaidManager = player.prepaidManager;
/*    */           
/* 31 */           ActivityFavorHandler.SuperPackageGetInfoResponse.Builder res = ActivityFavorHandler.SuperPackageGetInfoResponse.newBuilder();
/* 32 */           ActivityFavorHandler.SuperPackageInfo.Builder spiBuilder = activityManager.SuperPackage_GetInfo();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 39 */           res.setSuperPackageInfo(spiBuilder.build());
/*    */           
/* 41 */           res.setS2CCode(200);
/* 42 */           this.body.writeBytes(res.build().toByteArray());
/* 43 */           Out.debug(new Object[] { Integer.valueOf(3) });
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\SuperPackageGetinfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */