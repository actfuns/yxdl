/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityFavorHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityFavorHandler.sevenDayPackageAwardRequest")
/*    */ public class SevenDayPackageAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final ActivityFavorHandler.SevenDayPackageAwardRequest req = ActivityFavorHandler.SevenDayPackageAwardRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 26 */           WNPlayer player = (WNPlayer)SevenDayPackageAwardHandler.this.pak.getPlayer();
/*    */           
/* 28 */           ActivityFavorHandler.SevenDayPackageAwardResponse response = player.activityManager.receiveSevenDayPackageAward(req.getPackageId());
/* 29 */           this.body.writeBytes(response.toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\SevenDayPackageAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */