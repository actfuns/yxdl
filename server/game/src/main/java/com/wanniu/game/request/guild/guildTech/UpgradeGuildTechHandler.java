/*    */ package com.wanniu.game.request.guild.guildTech;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildTechHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildTechHandler.upgradeGuildTechRequest")
/*    */ public class UpgradeGuildTechHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 20 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GuildTechHandler.UpgradeGuildTechResponse.Builder res = GuildTechHandler.UpgradeGuildTechResponse.newBuilder();
/*    */           
/* 27 */           GuildTechManager guildTechManager = player.guildManager.guildTechManager;
/* 28 */           GuildResult ret = guildTechManager.upgradeTechLevel();
/* 29 */           int result = ret.result;
/* 30 */           GuildResult.UpgradeLevel resData = (GuildResult.UpgradeLevel)ret.data;
/* 31 */           if (result == 0) {
/* 32 */             res.setS2CCode(200);
/* 33 */             res.setS2CLevel(resData.level);
/* 34 */             res.setS2CFund((int)resData.fund);
/* 35 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 37 */           if (result == 1) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == 2) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == 3) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("TECH_LEVEL_FULL"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == 4) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(LangService.getValue("GUILD_NEED_GUILD_LEVEL").replace("{buildingLevel}", String.valueOf(ret.needLevel)));
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == 5) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == 6) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildTech\UpgradeGuildTechHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */