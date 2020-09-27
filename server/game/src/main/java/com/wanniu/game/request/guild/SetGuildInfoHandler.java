/*    */ package com.wanniu.game.request.guild;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.data.ext.GuildSettingExt;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.GuildSetData;
/*    */ import com.wanniu.game.guild.GuildUtil;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildHandler.setGuildInfoRequest")
/*    */ public class SetGuildInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     final GuildHandler.SetGuildInfoRequest req = GuildHandler.SetGuildInfoRequest.parseFrom(this.pak.getRemaingBytes());
/*    */     
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildHandler.SetGuildInfoResponse.Builder res = GuildHandler.SetGuildInfoResponse.newBuilder();
/* 29 */           GuildSetData params = new GuildSetData();
/* 30 */           params.entryLevel = req.getEntryLevel();
/* 31 */           params.entryUpLevel = req.getEntryUpLevel();
/* 32 */           params.guildMode = req.getGuildMode();
/* 33 */           GuildResult ret = player.guildManager.setGuildInfo(params);
/* 34 */           int result = ret.result;
/* 35 */           if (result == 0) {
/* 36 */             res.setS2CCode(200);
/* 37 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 39 */           if (result == -1) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 42 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 44 */           if (result == -2) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 47 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 49 */           if (result == -3) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 52 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 54 */           if (result == -4) {
/* 55 */             GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/* 56 */             res.setS2CCode(500);
/* 57 */             res.setS2CMsg(LangService.getValue("GUILD_ENTRY_MIN_LEVEL").replace("{roleLevel}", String.valueOf(prop.joinLv)));
/* 58 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 61 */           res.setS2CCode(500);
/* 62 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 63 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\SetGuildInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */