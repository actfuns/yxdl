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
/*    */ @GClientEvent("area.activityHandler.activityLuckyAwardViewRequest")
/*    */ public class ActivityLuckyAwardViewHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 19 */           WNPlayer player = (WNPlayer)ActivityLuckyAwardViewHandler.this.pak.getPlayer();
/* 20 */           ActivityHandler.ActivityLuckyAwardViewResponse.Builder data = player.activityManager.activityLuckyAwardView();
/* 21 */           data.setS2CCode(200);
/* 22 */           this.body.writeBytes(data.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityLuckyAwardViewHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */