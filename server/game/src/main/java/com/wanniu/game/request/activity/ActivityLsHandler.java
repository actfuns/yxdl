/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.ActivityManager;
/*    */ import com.wanniu.game.common.msg.ErrorResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityLsRequest")
/*    */ public class ActivityLsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 24 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 25 */     if (null == player) {
/* 26 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
/*    */     }
/* 28 */     final ActivityManager activityMgr = player.activityManager;
/* 29 */     if (null == activityMgr) {
/* 30 */       return (PomeloResponse)new ErrorResponse(LangService.getValue("SOMETHING_ERR"));
/*    */     }
/*    */     
/* 33 */     final ActivityHandler.ActivityLsResponse.Builder res = ActivityHandler.ActivityLsResponse.newBuilder();
/* 34 */     res.addAllS2CWelfareLs(activityMgr.getVailyActivityLs());
/*    */     
/* 36 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 39 */           res.setS2CCode(200);
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/* 41 */           activityMgr.updateSuperScriptList();
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityLsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */