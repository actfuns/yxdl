/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.data.CharacterCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class CharacterExt
/*    */   extends CharacterCO
/*    */ {
/*    */   public List<InitItem> initItems;
/*    */   public List<InitSkill> initSkills;
/*    */   public List<String> initEquips;
/*    */   
/*    */   public void initProperty() {
/* 26 */     this.initItems = new ArrayList<>();
/* 27 */     if (StringUtil.isNotEmpty(this.initItem)) {
/* 28 */       String[] itemStrs = this.initItem.split("\\|");
/* 29 */       for (String itemStr : itemStrs) {
/* 30 */         if (StringUtil.isNotEmpty(itemStr)) {
/* 31 */           String[] item = itemStr.split(":");
/* 32 */           this.initItems.add(new InitItem(item[0], Integer.valueOf(item[1]).intValue()));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     this.initSkills = new ArrayList<>();
/* 38 */     if (StringUtil.isNotEmpty(this.initSkill)) {
/* 39 */       String[] skillStrs = this.initSkill.split("\\|");
/* 40 */       int index = 0;
/* 41 */       for (String skillStr : skillStrs) {
/* 42 */         if (StringUtil.isNotEmpty(skillStr)) {
/* 43 */           String[] skill = skillStr.split(":");
/* 44 */           if (skill.length > 1) {
/*    */ 
/*    */ 
/*    */             
/* 48 */             this.initSkills.add(new InitSkill(Integer.parseInt(skill[0]), Integer.parseInt(skill[1]), index));
/* 49 */             index++;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 56 */     this.initEquips = new ArrayList<>();
/* 57 */     if (StringUtil.isNotEmpty(this.initEquip)) {
/* 58 */       String[] equips = this.initEquip.split("\\|");
/* 59 */       for (String equip : equips) {
/* 60 */         if (StringUtil.isNotEmpty(equip)) {
/* 61 */           this.initEquips.add(equip);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public class InitItem
/*    */   {
/*    */     public String itemCode;
/*    */     public int itemNum;
/*    */     
/*    */     public InitItem(String itemCode, int itemNum) {
/* 73 */       this.itemCode = itemCode;
/* 74 */       this.itemNum = itemNum;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class InitSkill
/*    */   {
/*    */     public int id;
/*    */     
/*    */     public int level;
/*    */     
/*    */     public int pos;
/*    */ 
/*    */     
/*    */     public InitSkill(int id, int level, int pos) {
/* 90 */       this.id = id;
/* 91 */       this.level = level;
/* 92 */       this.pos = pos;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\CharacterExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */