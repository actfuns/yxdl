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
/*    */ @GClientEvent("area.attendanceHandler.getLeftVipRewardRequest")
/*    */ public class GetLeftVipRewardHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 26 */     return new PomeloResponse() {
/* 27 */         AttendanceHandler.GetLeftVipRewardRequest req = AttendanceHandler.GetLeftVipRewardRequest.parseFrom(GetLeftVipRewardHandler.this.pak.getRemaingBytes());
/*    */         
/*    */         protected void write() throws IOException {
/* 30 */           int id = this.req.getId();
/* 31 */           GPlayer player = GetLeftVipRewardHandler.this.pak.getPlayer();
/* 32 */           if (player == null) {
/* 33 */             AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 34 */             builder.setS2CCode(500);
/* 35 */             builder.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 36 */             this.body.writeBytes(builder.build().toByteArray());
/*    */             return;
/*    */           } 
/* 39 */           if (id == 0) {
/* 40 */             AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 41 */             builder.setS2CCode(500);
/* 42 */             builder.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 43 */             this.body.writeBytes(builder.build().toByteArray());
/*    */             return;
/*    */           } 
/* 46 */           WNPlayer wPlayer = (WNPlayer)player;
/* 47 */           int resultCode = wPlayer.playerAttendance.getLeftVipReward(id);
/* 48 */           AttendanceHandler.GetLeftVipRewardResponse.Builder res = null;
/* 49 */           switch (resultCode) {
/*    */             case 0:
/* 51 */               res = wPlayer.playerAttendance.createGetLeftVipRewardResponse();
/* 52 */               res.setS2CCode(200);
/* 53 */               this.body.writeBytes(res.build().toByteArray());
/* 54 */               Out.info(new Object[] { player.getId(), ":vip签到成功" });
/*    */               return;
/*    */             case -1:
/* 57 */               res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 58 */               res.setS2CCode(500);
/* 59 */               res.setS2CMsg(LangService.getValue("SIGN_HAVE_RECEIVED"));
/* 60 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -2:
/* 63 */               res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 64 */               res.setS2CCode(500);
/* 65 */               res.setS2CMsg(LangService.getValue("SIGN_HAVE_NOT_SIGN"));
/* 66 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -3:
/* 69 */               res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 70 */               res.setS2CCode(500);
/* 71 */               res.setS2CMsg(LangService.getValue("SIGN_NO_VIP_DOUBLE"));
/* 72 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -4:
/* 75 */               res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 76 */               res.setS2CCode(500);
/* 77 */               res.setS2CMsg(LangService.getValue("SIGN_VIP_LEVEL_NOT_ENOUGH"));
/* 78 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */             case -5:
/* 81 */               res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 82 */               res.setS2CCode(500);
/* 83 */               res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 84 */               this.body.writeBytes(res.build().toByteArray());
/*    */               return;
/*    */           } 
/* 87 */           res = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
/* 88 */           res.setS2CCode(500);
/* 89 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 90 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\attendance\GetLeftVipRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */