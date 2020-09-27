/*    */ package com.wanniu.game.request.attendance;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.AttendanceHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.attendanceHandler.getDailyRewardRequest")
/*    */ public class GetDailyRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           GPlayer player = GetDailyRewardHandler.this.pak.getPlayer();
/* 31 */           if (player == null) {
/* 32 */             AttendanceHandler.GetDailyRewardResponse.Builder res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 33 */             res.setS2CCode(500);
/* 34 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 35 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/* 37 */             WNPlayer wplayer = (WNPlayer)player;
/* 38 */             int code = wplayer.playerAttendance.getDailyReward();
/* 39 */             AttendanceHandler.GetDailyRewardResponse.Builder res = null;
/* 40 */             switch (code) {
/*    */               case 0:
/* 42 */                 res = wplayer.playerAttendance.createGetDailyRewardResponse();
/* 43 */                 res.setS2CCode(200);
/* 44 */                 this.body.writeBytes(res.build().toByteArray());
/* 45 */                 wplayer.activityManager.updateDeskRedPoint();
/* 46 */                 Out.info(new Object[] { player.getId(), ":普通签到成功" });
/*    */                 return;
/*    */               case -1:
/* 49 */                 res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 50 */                 res.setS2CCode(500);
/* 51 */                 res.setS2CMsg(LangService.getValue("SIGN_HAVE_SIGNED"));
/* 52 */                 this.body.writeBytes(res.build().toByteArray());
/*    */                 return;
/*    */               case -2:
/* 55 */                 res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 56 */                 res.setS2CCode(500);
/* 57 */                 res.setS2CMsg(LangService.getValue("SIGN_NOT_EXIST"));
/* 58 */                 this.body.writeBytes(res.build().toByteArray());
/*    */                 return;
/*    */               case -3:
/* 61 */                 res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 62 */                 res.setS2CCode(500);
/* 63 */                 res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 64 */                 this.body.writeBytes(res.build().toByteArray());
/*    */                 return;
/*    */             } 
/* 67 */             res = AttendanceHandler.GetDailyRewardResponse.newBuilder();
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 70 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\attendance\GetDailyRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */