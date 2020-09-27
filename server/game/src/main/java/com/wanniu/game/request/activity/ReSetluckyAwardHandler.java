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
/*    */ @GClientEvent("area.activityHandler.reSetluckyAwardRequest")
/*    */ public class ReSetluckyAwardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 19 */           WNPlayer player = (WNPlayer)ReSetluckyAwardHandler.this.pak.getPlayer();
/* 20 */           ActivityHandler.ReSetluckyAwardResponse.Builder res = ActivityHandler.ReSetluckyAwardResponse.newBuilder();
/* 21 */           ActivityHandler.ReSetluckyAwardResponse.Builder data = player.activityManager.reSetluckyAward();
/* 22 */           if (data.getS2CCode() == 200) {
/*    */             
/* 24 */             res.setS2CCode(200);
/* 25 */             res.addAllS2CAwards(data.getS2CAwardsList());
/* 26 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(data.getS2CMsg());
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ReSetluckyAwardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */