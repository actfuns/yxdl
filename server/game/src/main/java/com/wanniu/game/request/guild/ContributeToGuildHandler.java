/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.contributeToGuildRequest")
/*    */ public class ContributeToGuildHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 21 */     final GuildHandler.ContributeToGuildRequest req = GuildHandler.ContributeToGuildRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildHandler.ContributeToGuildResponse.Builder res = GuildHandler.ContributeToGuildResponse.newBuilder();
/* 27 */           if (null == player) {
/* 28 */             res.setS2CCode(500);
/* 29 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 30 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 34 */           GuildResult resData = player.guildManager.contributeToGuild(req.getType(), req.getTimes());
/* 35 */           int result = resData.result;
/* 36 */           if (result == 0) {
/* 37 */             GuildHandler.MyGuildInfo guildInfo = player.guildManager.getMyGuildInfo();
/* 38 */             res.setS2CCode(200);
/* 39 */             res.setS2CGuildInfo(guildInfo);
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == -1) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == -2) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == -3) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -4) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTE_MATERIAL_NOT_ENOUGH"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -5) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTE_TIME_NOT_ENOUGH"));
/* 65 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 68 */           res.setS2CCode(500);
/* 69 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 70 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ContributeToGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */