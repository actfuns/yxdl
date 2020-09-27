/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ext.ActivityExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.ActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.activityHandler.activityInviteCodeRequest")
/*    */ public class ActivityInviteCodeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 23 */           WNPlayer player = (WNPlayer)ActivityInviteCodeHandler.this.pak.getPlayer();
/* 24 */           ActivityHandler.ActivityInviteCodeResponse.Builder res = ActivityHandler.ActivityInviteCodeResponse.newBuilder();
/* 25 */           ActivityExt prop = player.activityManager.findActivityByType(Const.ACTIVITY_CENTER_TYPE.INVITE_CODE.getValue());
/* 26 */           if (prop == null) {
/* 27 */             res.setS2CCode(500);
/* 28 */             res.setS2CMsg(LangService.getValue("CUR_NO_ACTIVITY"));
/* 29 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\ActivityInviteCodeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */