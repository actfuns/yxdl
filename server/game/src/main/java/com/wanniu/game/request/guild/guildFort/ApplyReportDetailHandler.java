/*    */ package com.wanniu.game.request.guild.guildFort;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildFortHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildFortHandler.applyReportDetailRequest")
/*    */ public class ApplyReportDetailHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     GuildFortHandler.ApplyReportDetailRequest req = GuildFortHandler.ApplyReportDetailRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final String date = req.getDate();
/* 26 */     final int fortId = req.getAreaId();
/*    */     
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           GuildFortHandler.ApplyReportDetailResponse.Builder res = GuildFortHandler.ApplyReportDetailResponse.newBuilder();
/* 32 */           String msg = player.guildFortManager.handleApplyReportDetail(res, date, fortId);
/* 33 */           if (msg != null) {
/* 34 */             res.setS2CCode(500);
/* 35 */             res.setS2CMsg(msg);
/*    */           } else {
/* 37 */             res.setS2CCode(200);
/*    */           } 
/* 39 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyReportDetailHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */