/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.activity.ActivityNoticeService;
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
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityNoticeRequest")
/*    */ public class ActivityNoticeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     final String context = ActivityNoticeService.getInstance().getNotice(player);
/*    */     
/* 26 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 28 */           ActivityHandler.ActivityNoticeRes.Builder res = ActivityHandler.ActivityNoticeRes.newBuilder();
/* 29 */           res.setS2CCode(200);
/* 30 */           res.setS2CContext(context);
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public static class ContextInfo {
/*    */     public String Content;
/*    */     public String ReleasePerson;
/*    */     public String ReleaseTime;
/*    */     public String NoticeTitle;
/*    */     public int ID;
/*    */     public int isRead;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityNoticeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */