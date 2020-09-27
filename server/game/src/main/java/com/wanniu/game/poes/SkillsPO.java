/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.playerSkill.po.SkillDB;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_skill")
/*    */ public final class SkillsPO
/*    */   extends GEntity
/*    */ {
/*    */   public Map<Integer, SkillDB> skills;
/*    */   public Map<Integer, Integer> skillKeys;
/*    */   public int openCount;
/*    */   public Map<Integer, SkillDB> talentSkills;
/* 27 */   public int talentPoint = 0;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\SkillsPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */