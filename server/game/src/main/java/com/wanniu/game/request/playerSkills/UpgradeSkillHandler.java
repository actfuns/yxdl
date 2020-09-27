/*    */ package com.wanniu.game.request.playerSkills;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.ext.SkillDataExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.playerSkill.SkillManager;
/*    */ import com.wanniu.game.playerSkill.SkillUtil;
/*    */ import com.wanniu.game.playerSkill.po.SkillDB;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SkillHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillHandler.upgradeSkillRequest")
/*    */ public class UpgradeSkillHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 25 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 26 */     SkillHandler.UpgradeSkillRequest req = SkillHandler.UpgradeSkillRequest.parseFrom(this.pak.getRemaingBytes());
/* 27 */     final int skillId = req.getS2CSkillId();
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           SkillHandler.UpgradeSkillResponse.Builder res = SkillHandler.UpgradeSkillResponse.newBuilder();
/* 32 */           SkillManager skillManager = player.skillManager;
/* 33 */           SkillDB skill = skillManager.getSkill(skillId);
/* 34 */           if (skill == null) {
/* 35 */             res.setS2CCode(500);
/* 36 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/* 37 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 41 */           if (skill.flag == 0) {
/* 42 */             res.setS2CCode(500);
/* 43 */             res.setS2CMsg(LangService.getValue("SKILL_LOCK"));
/* 44 */             this.body.writeBytes(res.build().toByteArray());
/*    */             
/*    */             return;
/*    */           } 
/* 48 */           SkillManager.CheckSkillData data = skillManager.checkSkillReq(skill);
/* 49 */           int result = data.result;
/* 50 */           if (result == 0) {
/* 51 */             if (skillManager.upgradeOneSkill(skill.id)) {
/* 52 */               SkillDataExt prop = SkillUtil.getProp(skillId);
/* 53 */               if (prop.skillType == Const.SkillType.EFFECT_PASSIVE.getValue()) {
/* 54 */                 player.initAndCalAllInflu(null);
/* 55 */                 player.pushAndRefreshEffect(false);
/*    */               } 
/* 57 */               res.setS2CCode(200);
/*    */             } else {
/* 59 */               res.setS2CCode(500);
/* 60 */               res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */             } 
/* 62 */             player.getPlayerTasks().dealTaskEvent(Const.TaskType.SKILL_UP, 1);
/* 63 */           } else if (result == -1) {
/* 64 */             res.setS2CCode(500);
/* 65 */             res.setS2CMsg(LangService.getValue("SKILL_MAX_LEVEL"));
/* 66 */           } else if (result == -2) {
/* 67 */             res.setS2CCode(500);
/* 68 */             res.setS2CMsg(LangService.getValue("SKILL_LEVEL_NOT_ENOUGH"));
/* 69 */           } else if (result == -3) {
/* 70 */             res.setS2CCode(500);
/* 71 */             res.setS2CMsg(LangService.getValue("GOLD_NOT_ENOUGH"));
/* 72 */           } else if (result == -4) {
/* 73 */             res.setS2CCode(500);
/* 74 */             res.setS2CMsg(LangService.getValue("SKILL_PRESKILL_NOT_READY"));
/* 75 */           } else if (result == -5) {
/* 76 */             res.setS2CCode(500);
/* 77 */             res.setS2CMsg(LangService.getValue("SKILL_PRESKILL_NOT_READY"));
/* 78 */           } else if (result == -6) {
/* 79 */             res.setS2CCode(500);
/* 80 */             res.setS2CMsg(LangService.getValue("ITEM_NOT_ENOUGH"));
/* 81 */           } else if (result == -99) {
/* 82 */             res.setS2CCode(500);
/* 83 */             res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
/*    */           } 
/* 85 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkills\UpgradeSkillHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */