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
/*    */ @GClientEvent("area.attendanceHandler.getCumulativeRewardRequest")
/*    */ public class GetCumulativeRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     final AttendanceHandler.GetCumulativeRewardRequest req = AttendanceHandler.GetCumulativeRewardRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 30 */           GPlayer player = GetCumulativeRewardHandler.this.pak.getPlayer();
/* 31 */           if (player == null) {
/* 32 */             AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 33 */             builder.setS2CCode(500);
/* 34 */             builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 35 */             this.body.writeBytes(builder.build().toByteArray());
/*    */             return;
/*    */           } 
/* 38 */           int id = req.getId();
/* 39 */           if (id == 0) {
/* 40 */             AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 41 */             builder.setS2CCode(500);
/* 42 */             builder.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 43 */             this.body.writeBytes(builder.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           WNPlayer wPlayer = (WNPlayer)player;
/* 47 */           AttendanceHandler.GetCumulativeRewardResponse.Builder res = null;
/* 48 */           int resultCode = wPlayer.playerAttendance.getCumulativeReward(id);
/* 49 */           switch (resultCode) {
/*    */             case 0:
/* 51 */               res = wPlayer.playerAttendance.createGetCumulativeRewardResponse();
/* 52 */               res.setS2CCode(200);
/* 53 */               this.body.writeBytes(res.build().toByteArray());
/* 54 */               Out.info(new Object[] { player.getId(), ":累计签到成功" });
/*    */               return;
/*    */             case -1:
/* 57 */               res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 58 */               res.setS2CCode(500);
/* 59 */               res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
/* 60 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -2:
/* 63 */               res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 64 */               res.setS2CCode(500);
/* 65 */               res.setS2CMsg(LangService.getValue("SIGN_NOT_EXIST"));
/* 66 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -3:
/* 69 */               res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 70 */               res.setS2CCode(500);
/* 71 */               res.setS2CMsg(LangService.getValue("SIGN_NOT_ENOUGH_COUNT"));
/* 72 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -4:
/* 75 */               res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 76 */               res.setS2CCode(500);
/* 77 */               res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 78 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */           } 
/* 81 */           res = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
/* 82 */           res.setS2CCode(500);
/* 83 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 84 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\attendance\GetCumulativeRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */