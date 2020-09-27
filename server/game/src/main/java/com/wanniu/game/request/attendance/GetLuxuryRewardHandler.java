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
/*    */ @GClientEvent("area.attendanceHandler.getLuxuryRewardRequest")
/*    */ public class GetLuxuryRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 29 */           GPlayer player = GetLuxuryRewardHandler.this.pak.getPlayer();
/* 30 */           if (player == null) {
/* 31 */             AttendanceHandler.GetLuxuryRewardResponse.Builder builder = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 32 */             builder.setS2CCode(500);
/* 33 */             builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 34 */             this.body.writeBytes(builder.build().toByteArray());
/*    */             return;
/*    */           } 
/* 37 */           WNPlayer wPlayer = (WNPlayer)player;
/* 38 */           int resultCode = wPlayer.playerAttendance.getLuxuryReward();
/* 39 */           AttendanceHandler.GetLuxuryRewardResponse.Builder res = null;
/* 40 */           switch (resultCode) {
/*    */             case 0:
/* 42 */               res = wPlayer.playerAttendance.createGetLuxuryRewardResponse();
/* 43 */               res.setS2CCode(200);
/* 44 */               this.body.writeBytes(res.build().toByteArray());
/* 45 */               Out.info(new Object[] { player.getId(), ":豪华签到成功" });
/*    */               return;
/*    */             case -1:
/* 48 */               res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 49 */               res.setS2CCode(500);
/* 50 */               res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
/* 51 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -2:
/* 54 */               res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 55 */               res.setS2CCode(500);
/* 56 */               res.setS2CMsg(LangService.getValue("SIGN_NOT_RECHARGE"));
/* 57 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -3:
/* 60 */               res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 61 */               res.setS2CCode(500);
/* 62 */               res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 63 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */           } 
/* 66 */           res = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
/* 67 */           res.setS2CCode(500);
/* 68 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 69 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\attendance\GetLuxuryRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */