/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.TalentEffectCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TalentEffectExt
/*    */   extends TalentEffectCO
/*    */ {
/*    */   public int[] power_arr;
/*    */   public Map<Integer, Integer> replaceSkillMap;
/*    */   
/*    */   public void initProperty() {
/* 20 */     if (StringUtil.isNotEmpty(this.power)) {
/* 21 */       String[] str_arr = this.power.split(";");
/* 22 */       int len = str_arr.length;
/* 23 */       this.power_arr = new int[len + 1];
/* 24 */       this.power_arr[0] = 0;
/* 25 */       for (int i = 0; i < len; i++) {
/* 26 */         String str = str_arr[i];
/* 27 */         String[] a_str = str.split(":");
/* 28 */         int lvl = Integer.parseInt(a_str[0]);
/* 29 */         if (lvl != i + 1) {
/* 30 */           Out.error(new Object[] { "天赋的战力有问题,talentID=", Integer.valueOf(this.talentID) });
/*    */         }
/* 32 */         this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
/*    */       } 
/*    */     } 
/*    */     
/* 36 */     if (this.talentType == 2) {
/* 37 */       this.replaceSkillMap = new HashMap<>();
/* 38 */       String[] str_arr = this.replaceSkill.split(";");
/* 39 */       int len = str_arr.length;
/* 40 */       for (int i = 0; i < len; i++) {
/* 41 */         String str = str_arr[i];
/* 42 */         String[] a_str = str.split(":");
/* 43 */         int lvl = Integer.parseInt(a_str[0]);
/* 44 */         if (lvl != i + 1) {
/* 45 */           Out.error(new Object[] { "天赋脚本的替换的技能,talentID=", Integer.valueOf(this.talentID) });
/*    */         }
/* 47 */         this.replaceSkillMap.put(Integer.valueOf(lvl), Integer.valueOf(Integer.parseInt(a_str[1])));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getSkillPower(int lvl) {
/* 60 */     if (lvl < 0)
/* 61 */       return 0; 
/* 62 */     if (this.power_arr != null) {
/*    */ 
/*    */       
/* 65 */       if (lvl > this.power_arr.length - 1) {
/* 66 */         return this.power_arr[this.power_arr.length - 1];
/*    */       }
/* 68 */       return this.power_arr[lvl];
/*    */     } 
/* 70 */     return 0;
/*    */   }
/*    */   
/*    */   public int getReplaceSkillId(int talentLv) {
/* 74 */     if (this.replaceSkillMap != null && this.replaceSkillMap.containsKey(Integer.valueOf(talentLv)))
/* 75 */       return ((Integer)this.replaceSkillMap.get(Integer.valueOf(talentLv))).intValue(); 
/* 76 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\TalentEffectExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */