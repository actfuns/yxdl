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
/*    */ @GClientEvent("area.activityHandler.consumeTotalRequest")
/*    */ public class ConsumeTotalHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 18 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 20 */           WNPlayer player = (WNPlayer)ConsumeTotalHandler.this.pak.getPlayer();
/* 21 */           ActivityHandler.ConsumeTotalResponse.Builder res = ActivityHandler.ConsumeTotalResponse.newBuilder();
/*    */           
/* 23 */           ActivityHandler.totalInfo.Builder data = player.activityManager.consumeTotal();
/* 24 */           res.setS2CCode(200);
/* 25 */           res.setS2CData(data);
/* 26 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ConsumeTotalHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */