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
/*    */ @GClientEvent("area.activityHandler.paySecondRequest")
/*    */ public class PaySecondHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     ActivityHandler.PaySecondRequest req = ActivityHandler.PaySecondRequest.parseFrom(this.pak.getRemaingBytes());
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           WNPlayer player = (WNPlayer)PaySecondHandler.this.pak.getPlayer();
/* 22 */           ActivityHandler.PaySecondResponse.Builder res = ActivityHandler.PaySecondResponse.newBuilder();
/*    */           
/* 24 */           ActivityHandler.PayFirstResponse.Builder data = player.activityManager.paySecond();
/* 25 */           data.setS2CCode(200);
/* 26 */           this.body.writeBytes(data.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\PaySecondHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */