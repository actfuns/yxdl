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
/*    */ @GClientEvent("area.activityHandler.payFirstRequest")
/*    */ public class PayFirstRequestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 20 */           WNPlayer player = (WNPlayer)PayFirstRequestHandler.this.pak.getPlayer();
/* 21 */           ActivityHandler.PayFirstResponse.Builder res = ActivityHandler.PayFirstResponse.newBuilder();
/* 22 */           ActivityHandler.PayFirstResponse.Builder data = player.activityManager.payFirst();
/* 23 */           data.setS2CCode(200);
/* 24 */           this.body.writeBytes(data.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\PayFirstRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */