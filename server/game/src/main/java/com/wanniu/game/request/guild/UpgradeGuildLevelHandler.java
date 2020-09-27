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
/*    */ @GClientEvent("area.guildHandler.upgradeGuildLevelRequest")
/*    */ public class UpgradeGuildLevelHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */ 
/*    */ 
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildHandler.UpgradeGuildLevelResponse.Builder res = GuildHandler.UpgradeGuildLevelResponse.newBuilder();
/*    */           
/* 28 */           GuildResult ret = player.guildManager.upgradeGuildLevel();
/* 29 */           int result = ret.result;
/* 30 */           if (result == 0) {
/* 31 */             GuildHandler.MyGuildInfo myGuildInfo = player.guildManager.getMyGuildInfo();
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CGuildInfo(myGuildInfo);
/* 34 */             this.body.writeBytes(res.build().toByteArray());
/* 35 */             player.guildManager.update(); return;
/*    */           } 
/* 37 */           if (result == -1) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == -2) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == -3) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == -4) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == 1) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_LEVEL_FULL"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == 2) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_NEED_BLESS_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
/* 65 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 67 */           if (result == 3) {
/* 68 */             res.setS2CCode(500);
/* 69 */             res.setS2CMsg(LangService.getValue("GUILD_NEED_TECH_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
/* 70 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 72 */           if (result == 4) {
/* 73 */             res.setS2CCode(500);
/* 74 */             res.setS2CMsg(LangService.getValue("GUILD_NEED_DEPOT_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
/* 75 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 77 */           if (result == 5) {
/* 78 */             res.setS2CCode(500);
/* 79 */             res.setS2CMsg(LangService.getValue("GUILD_EXP_NOT_ENOUGH"));
/* 80 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 82 */           if (result == 6) {
/* 83 */             res.setS2CCode(500);
/* 84 */             res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
/* 85 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 88 */           res.setS2CCode(500);
/* 89 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 90 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\UpgradeGuildLevelHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */