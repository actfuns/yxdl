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
/*    */ 
/*    */ @GClientEvent("area.guildTechHandler.upgradeGuildBuffRequest")
/*    */ public class UpgradeGuildBuffHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 21 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/*    */     
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           GuildTechHandler.UpgradeGuildBuffResponse.Builder res = GuildTechHandler.UpgradeGuildBuffResponse.newBuilder();
/*    */           
/* 28 */           GuildTechManager guildTechManager = player.guildManager.guildTechManager;
/* 29 */           GuildResult ret = guildTechManager.upgradeBuffLevel();
/* 30 */           GuildResult.UpgradeLevel resData = (GuildResult.UpgradeLevel)ret.data;
/* 31 */           int result = ret.result;
/* 32 */           if (result == 0) {
/* 33 */             GuildTechHandler.GuildBuff buffData = guildTechManager.getBuffData();
/* 34 */             res.setS2CCode(200);
/* 35 */             res.setS2CBuffInfo(buffData);
/* 36 */             res.setS2CFund((int)resData.fund);
/* 37 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 39 */           if (result == 1) {
/* 40 */             res.setS2CCode(500);
/* 41 */             res.setS2CMsg(LangService.getValue("GUILD_NOT_JOIN"));
/* 42 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 44 */           if (result == 2) {
/* 45 */             res.setS2CCode(500);
/* 46 */             res.setS2CMsg(LangService.getValue("GUILD_NO_POWER"));
/* 47 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 49 */           if (result == 3) {
/* 50 */             res.setS2CCode(500);
/* 51 */             res.setS2CMsg(LangService.getValue("TECH_BUFF_LEVEL_FULL"));
/* 52 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 54 */           if (result == 4) {
/* 55 */             res.setS2CCode(500);
/* 56 */             res.setS2CMsg(LangService.getValue("TECH_BUFF_NEED_TECH_LEVEL"));
/* 57 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 59 */           if (result == 5) {
/* 60 */             res.setS2CCode(500);
/* 61 */             res.setS2CMsg(LangService.getValue("GUILD_FUND_NOT_ENOUGH"));
/* 62 */             this.body.writeBytes(res.build().toByteArray());
/*    */             return;
/*    */           } 
/* 65 */           res.setS2CCode(500);
/* 66 */           res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 67 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildTech\UpgradeGuildBuffHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */