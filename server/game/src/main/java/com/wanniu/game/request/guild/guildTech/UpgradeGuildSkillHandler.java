/*    */ package com.wanniu.game.request.guild.guildTech;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.guild.GuildResult;
/*    */ import com.wanniu.game.guild.guildTech.GuildTechManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.GuildTechHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.guildTechHandler.upgradeGuildSkillRequest")
/*    */ public class UpgradeGuildSkillHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 23 */     GuildTechHandler.UpgradeGuildSkillRequest req = GuildTechHandler.UpgradeGuildSkillRequest.parseFrom(this.pak.getRemaingBytes());
/* 24 */     final int skillId = req.getSkillId();
/* 25 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 28 */           GuildTechHandler.UpgradeGuildSkillResponse.Builder res = GuildTechHandler.UpgradeGuildSkillResponse.newBuilder();
/*    */           
/* 30 */           GuildTechManager guildTechManager = player.guildManager.guildTechManager;
/* 31 */           GuildResult ret = guildTechManager.upgradeSkillLevel(skillId);
/* 32 */           int result = ret.result;
/* 33 */           if (result == 0) {
/* 34 */             GuildTechHandler.GuildSkill skillData = guildTechManager.getOneSkillData(skillId);
/* 35 */             player.taskManager.dealTaskEvent(Const.TaskType.GUILD_TECH_UP, 1);
/* 36 */             res.setS2CCode(200);
/* 37 */             res.setS2CSkillInfo(skillData);
/* 38 */             res.setS2CContribution(player.guildManager.getContribution());
/* 39 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 40 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 42 */           if (result == -1) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("TECH_SKILL_NOT_EXIST"));
/* 45 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 47 */           if (result == -2) {
/* 48 */             res.setS2CCode(500);
/* 49 */             res.setS2CMsg(LangService.getValue("TECH_SKILL_LEVEL_FULL"));
/* 50 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 52 */           if (result == -3) {
/* 53 */             res.setS2CCode(500);
/* 54 */             res.setS2CMsg(ret.des);
/* 55 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 57 */           if (result == -4) {
/* 58 */             res.setS2CCode(500);
/* 59 */             res.setS2CMsg(LangService.getValue("GUILD_CONTRIBUTION_NOT_ENOUGH"));
/* 60 */             this.body.writeBytes(res.build().toByteArray()); return;
/*    */           } 
/* 62 */           if (result == -5) {
/* 63 */             res.setS2CCode(500);
/* 64 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
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


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\guild\guildTech\UpgradeGuildSkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */