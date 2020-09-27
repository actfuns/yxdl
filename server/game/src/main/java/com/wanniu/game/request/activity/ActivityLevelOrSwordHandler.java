/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityLevelOrSwordRequest")
/*    */ public class ActivityLevelOrSwordHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     final ActivityHandler.ActivityLevelOrSwordRequest req = ActivityHandler.ActivityLevelOrSwordRequest.parseFrom(this.pak.getRemaingBytes());
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           WNPlayer player = (WNPlayer)ActivityLevelOrSwordHandler.this.pak.getPlayer();
/* 22 */           ActivityHandler.ActivityLevelOrSwordResponse.Builder res = ActivityHandler.ActivityLevelOrSwordResponse.newBuilder();
/* 23 */           res = player.activityManager.levelOrSword(req.getC2SActivityId());
/* 24 */           res.setS2CCode(200);
/* 25 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityLevelOrSwordHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */