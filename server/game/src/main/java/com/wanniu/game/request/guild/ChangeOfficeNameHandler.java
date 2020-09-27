/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.changeOfficeNameRequest")
/*    */ public class ChangeOfficeNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     GuildHandler.ChangeOfficeNameRequest req = GuildHandler.ChangeOfficeNameRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final List<GuildHandler.OfficeName> officeNames = req.getOfficeNamesList();
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildHandler.ChangeOfficeNameResponse.Builder res = GuildHandler.ChangeOfficeNameResponse.newBuilder();
/* 29 */           if (null == player) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           GuildResult ret = player.guildManager.changeOfficeName(officeNames);
/* 37 */           int result = ret.result;
/* 38 */           if (result == 0) {
/* 39 */             res.setS2CCode(200);
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == -1) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == -2) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == -3) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NOT_EXIST"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -4) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_EMPTY"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -5) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_TOO_LONG"));
/* 65 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 67 */           if (result == -8) {
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_SPECIAL_CHAR"));
/* 70 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 72 */           if (result == -9) {
/* 73 */             res.setS2CCode(500);
/* 74 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_BLACK_STRING"));
/* 75 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 77 */           if (result == 1) {
/* 78 */             res.setS2CCode(500);
/* 79 */             res.setS2CMsg(LangService.getValue("GUILD_JOB_NAME_REPEATED"));
/* 80 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 83 */           res.setS2CCode(500);
/* 84 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 85 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ChangeOfficeNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */