/*    */ package com.wanniu.game.request.attendance;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.entity.GPlayer;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
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
/*    */ @GClientEvent("area.attendanceHandler.getAttendanceInfoRequest")
/*    */ public class GetAttendanceInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GPlayer player = GetAttendanceInfoHandler.this.pak.getPlayer();
/* 27 */           if (player != null) {
/* 28 */             WNPlayer wPlayer = (WNPlayer)player;
/* 29 */             AttendanceHandler.GetAttendanceInfoResponse.Builder res = wPlayer.playerAttendance.createGetAttendanceInfoResponse();
/* 30 */             res.setS2CCode(200);
/* 31 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } else {
/*    */             
/* 34 */             AttendanceHandler.GetAttendanceInfoResponse.Builder res = AttendanceHandler.GetAttendanceInfoResponse.newBuilder();
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\attendance\GetAttendanceInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */