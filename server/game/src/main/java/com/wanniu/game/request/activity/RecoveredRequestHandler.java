/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.activity.ActivityManager;
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
/*    */ @GClientEvent("area.activityFavorHandler.recoveredRequest")
/*    */ public class RecoveredRequestHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final ActivityFavorHandler.RecoveredRequest request = ActivityFavorHandler.RecoveredRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 26 */           ActivityManager m = ((WNPlayer)RecoveredRequestHandler.this.pak.getPlayer()).activityManager;
/* 27 */           this.body.writeBytes(m.recoveredRequest(request.getId(), request.getType()).toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\RecoveredRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */