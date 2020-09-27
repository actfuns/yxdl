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
/*    */ @GClientEvent("area.activityHandler.openChangeRequest")
/*    */ public class OpenChangeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 17 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 19 */           WNPlayer player = (WNPlayer)OpenChangeHandler.this.pak.getPlayer();
/* 20 */           ActivityHandler.OpenChangeResponse.Builder res = ActivityHandler.OpenChangeResponse.newBuilder();
/* 21 */           ActivityHandler.OpenChangeResponse.Builder changeInfo = player.activityManager.haoliChange();
/* 22 */           changeInfo.setS2CCode(200);
/* 23 */           this.body.writeBytes(changeInfo.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\OpenChangeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */