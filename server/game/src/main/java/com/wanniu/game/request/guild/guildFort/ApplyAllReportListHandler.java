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
/*    */ @GClientEvent("area.guildFortHandler.applyAllReportListRequest")
/*    */ public class ApplyAllReportListHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           GuildFortHandler.ApplyAllReportListResponse.Builder res = GuildFortHandler.ApplyAllReportListResponse.newBuilder();
/* 28 */           String msg = player.guildFortManager.handleApplyAllReportList(res);
/* 29 */           if (msg != null) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(msg);
/*    */           } else {
/* 33 */             res.setS2CCode(200);
/*    */           } 
/* 35 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildFort\ApplyAllReportListHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */