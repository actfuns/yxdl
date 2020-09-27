/*    */ package com.wanniu.game.playerSkill;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.SkillDataExt;
/*    */ import com.wanniu.game.data.ext.SkillValueExt;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillUtil
/*    */ {
/*    */   public static SkillDataExt getProp(int skillId) {
/* 19 */     return (SkillDataExt)GameData.SkillDatas.get(Integer.valueOf(skillId));
/*    */   }
/*    */ 
/*    */   
/*    */   public static ArrayList<String> getDesData(int skillId, int skillLevel) {
/* 24 */     SkillValueExt exProp = (SkillValueExt)GameData.SkillValues.get(Integer.valueOf(skillId));
/* 25 */     Out.debug(new Object[] { "this.exProp: ", exProp });
/* 26 */     ArrayList<String> desData = new ArrayList<>();
/*    */     
/* 28 */     float dmgRate = (exProp.dmgRate + (skillLevel - 1) * exProp.dmgRatePerLvl) / 10000.0F;
/* 29 */     desData.add("" + dmgRate);
/*    */     
/* 31 */     int exdDmg = 0;
/* 32 */     if (exProp.exdDmgSetData.containsKey(skillLevel + "")) {
/* 33 */       exdDmg = ((Integer)exProp.exdDmgSetData.get(skillLevel + "")).intValue();
/*    */     }
/*    */     
/* 36 */     desData.add("" + ((exdDmg > 0) ? exdDmg : 0));
/*    */     
/* 38 */     int chance = exProp.chance / 100;
/* 39 */     desData.add("" + chance);
/*    */     
/* 41 */     int buffTime = 0;
/* 42 */     if (exProp.BuffTimeData.containsKey(Integer.valueOf(skillLevel))) {
/* 43 */       buffTime = ((Integer)exProp.BuffTimeData.get(Integer.valueOf(skillLevel))).intValue() / 1000;
/*    */     }
/*    */ 
/*    */     
/* 47 */     desData.add("" + buffTime);
/*    */     
/* 49 */     for (int j = 1; j < 4; j++) {
/* 50 */       Map<String, SkillValueExt.SkillValueSetData> valueSetData = exProp.valueSetData;
/* 51 */       SkillValueExt.SkillValueSetData valuedata = valueSetData.get("valueSetData" + j);
/* 52 */       if (valuedata != null && valuedata.valueSet != null) {
/* 53 */         Map<String, Integer> valueSet = valuedata.valueSet;
/* 54 */         Out.debug(new Object[] { valueSet });
/*    */         try {
/* 56 */           if (valueSet != null && ((Integer)valueSet.get("" + skillLevel)).intValue() > 0) {
/*    */             
/* 58 */             float relative = 1.0F;
/*    */             
/* 60 */             int ValueAttribute = valuedata.valueAttribute;
/*    */ 
/*    */             
/* 63 */             if (ValueAttribute == 1) {
/* 64 */               relative = 100.0F;
/* 65 */             } else if (ValueAttribute == 2) {
/* 66 */               relative = 1000.0F;
/* 67 */             } else if (ValueAttribute == 3) {
/* 68 */               relative = 10000.0F;
/*    */             } 
/*    */             
/* 71 */             desData.add("" + (((Integer)valueSet.get("" + skillLevel)).intValue() / relative));
/*    */           } else {
/* 73 */             desData.add("0");
/*    */           } 
/* 75 */         } catch (Exception e) {
/* 76 */           Out.error(new Object[] { e });
/*    */         } 
/*    */       } else {
/*    */         
/* 80 */         desData.add("0");
/*    */       } 
/*    */     } 
/*    */     
/* 84 */     return desData;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\playerSkill\SkillUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */