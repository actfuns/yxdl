/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.data.ext.GuildSettingExt;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.changeGuildNameRequest")
/*    */ public class ChangeGuildNameHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 22 */     GuildHandler.ChangeGuildNameRequest req = GuildHandler.ChangeGuildNameRequest.parseFrom(this.pak.getRemaingBytes());
/* 23 */     final String name = req.getName();
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildHandler.ChangeGuildNameResponse.Builder res = GuildHandler.ChangeGuildNameResponse.newBuilder();
/* 29 */           if (null == player) {
/* 30 */             res.setS2CCode(500);
/* 31 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 32 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 36 */           GuildResult ret = player.guildManager.changeGuildName(name);
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
/* 54 */             res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -4) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_SHORT"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -5) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_TOO_LONG"));
/* 65 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 67 */           if (result == -6) {
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_MATERIAL_NOT_ENOUGH"));
/* 70 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 72 */           if (result == -8) {
/* 73 */             res.setS2CCode(500);
/* 74 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_SPECIAL_CHAR"));
/* 75 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 77 */           if (result == -9) {
/* 78 */             res.setS2CCode(500);
/* 79 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_BLACK_STRING"));
/* 80 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 82 */           if (result == 1) {
/* 83 */             res.setS2CCode(500);
/* 84 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_EXIST"));
/* 85 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 87 */           if (result == 2) {
/* 88 */             GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/* 89 */             res.setS2CCode(500);
/* 90 */             res.setS2CMsg(LangService.getValue("GUILD_NAME_CHANGE_CD").replace("{cd}", String.valueOf(prop.changeNameCD)));
/* 91 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 94 */           res.setS2CCode(500);
/* 95 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 96 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\ChangeGuildNameHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */