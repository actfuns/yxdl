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
/*    */ 
/*    */ @GClientEvent("area.activityHandler.payTotalRequest")
/*    */ public class PayTotalHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 21 */           WNPlayer player = (WNPlayer)PayTotalHandler.this.pak.getPlayer();
/* 22 */           ActivityHandler.PayTotalResponse.Builder res = ActivityHandler.PayTotalResponse.newBuilder();
/*    */           
/* 24 */           ActivityHandler.totalInfo.Builder data = player.activityManager.payTotal();
/* 25 */           res.setS2CCode(200);
/* 26 */           res.setS2CData(data.build());
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\PayTotalHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */