/*    */ package com.wanniu.game.request.playerSkills;
/*    */ 
/*    */ import com.wanniu.core.game.LangService;
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.playerSkill.SkillManager;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SkillHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.skillHandler.upgradeSkillOneKeyRequest")
/*    */ public class UpgradeSkillOneKeyHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 19 */     final WNPlayer player = (WNPlayer)this.pak.getPlayer();
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           SkillHandler.UpgradeSkillOneKeyResponse.Builder res = SkillHandler.UpgradeSkillOneKeyResponse.newBuilder();
/* 24 */           SkillManager skillManager = player.skillManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 30 */           int result = skillManager.upgradeSkillOneKey2();
/* 31 */           if (result == 0) {
/*    */             
/* 33 */             res.setS2CCode(200);
/* 34 */             res.addAllSkillList(player.skillManager.getSkillsBasicList());
/* 35 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/* 37 */           else if (result == -1) {
/* 38 */             res.setS2CCode(500);
/* 39 */             res.setS2CMsg(LangService.getValue("SKILL_UPGRADE_NONE"));
/* 40 */             this.body.writeBytes(res.build().toByteArray());
/*    */           }
/* 42 */           else if (result == -2) {
/* 43 */             res.setS2CCode(500);
/* 44 */             res.setS2CMsg(LangService.getValue("NOT_ENOUGH_GOLD_LEARN"));
/* 45 */             this.body.writeBytes(res.build().toByteArray());
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\playerSkills\UpgradeSkillOneKeyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */