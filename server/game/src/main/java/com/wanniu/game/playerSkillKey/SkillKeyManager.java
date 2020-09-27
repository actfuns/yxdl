/*    */ package com.wanniu.game.playerSkillKey;
/*    */ 
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.common.ModuleManager;
/*    */ import com.wanniu.game.data.ext.SkillDataExt;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.playerSkill.SkillUtil;
/*    */ import com.wanniu.game.playerSkill.po.SkillDB;
/*    */ import com.wanniu.game.poes.SkillsPO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import pomelo.Common;
/*    */ 
/*    */ 
/*    */ public class SkillKeyManager
/*    */   extends ModuleManager
/*    */ {
/*    */   public WNPlayer player;
/*    */   public SkillsPO player_skills;
/*    */   
/*    */   public SkillKeyManager(WNPlayer player, SkillsPO skills) {
/* 22 */     this.player = player;
/* 23 */     this.player_skills = skills;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Common.SkillKeyStruct> toJson4Payload() {
/* 30 */     List<Common.SkillKeyStruct> list = new ArrayList<>();
/* 31 */     for (SkillDB skill : this.player_skills.skills.values()) {
/*    */       
/* 33 */       Common.SkillKeyStruct.Builder sk = Common.SkillKeyStruct.newBuilder();
/* 34 */       sk.setKeyPos(skill.pos);
/* 35 */       sk.setFlag(skill.flag);
/* 36 */       sk.setBaseSkillId(skill.id);
/* 37 */       SkillDataExt prop = SkillUtil.getProp(skill.id);
/* 38 */       sk.setIcon(prop.skillIcon);
/* 39 */       sk.setName(prop.skillName);
/* 40 */       sk.setAdvancedSkillId(skill.id);
/* 41 */       sk.setUnlockLevel(((Integer)prop.lvReqData.get(0)).intValue());
/* 42 */       list.add(sk.build());
/*    */     } 
/*    */     
/* 45 */     return list;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onPlayerEvent(Const.PlayerEventType eventType) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public Const.ManagerType getManagerType() {
/* 55 */     return Const.ManagerType.SKILL_KEY;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\playerSkillKey\SkillKeyManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */