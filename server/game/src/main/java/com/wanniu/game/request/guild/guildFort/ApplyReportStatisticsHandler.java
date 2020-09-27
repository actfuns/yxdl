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
/*    */ @GClientEvent("area.guildFortHandler.applyReportStatisticsRequest")
/*    */ public class ApplyReportStatisticsHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 23 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 24 */     GuildFortHandler.ApplyReportStatisticsRequest req = GuildFortHandler.ApplyReportStatisticsRequest.parseFrom(this.pak.getRemaingBytes());
/* 25 */     final String date = req.getDate();
/* 26 */     final int fortId = req.getAreaId();
/* 27 */     final String guildId = req.getGuildId();
/*    */     
/* 29 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 32 */           GuildFortHandler.ApplyReportStatisticsResponse.Builder res = GuildFortHandler.ApplyReportStatisticsResponse.newBuilder();
/* 33 */           String msg = player.guildFortManager.handleApplyReportStatistics(res, date, fortId, guildId);
/* 34 */           if (msg != null) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(msg);
/*    */           } else {
/* 38 */             res.setS2CCode(200);
/*    */           } 
/* 40 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyReportStatisticsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */