/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.ClassUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.data.PetSkillCO;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetSkillExt
/*     */   extends PetSkillCO
/*     */ {
/*  19 */   public Map<Const.PlayerBtlData, Map<Integer, Integer>> attributeValues = new HashMap<>();
/*     */ 
/*     */   
/*     */   public int[] power_arr;
/*     */ 
/*     */ 
/*     */   
/*     */   public void initProperty() {
/*  27 */     for (int i = 1; i < 4; i++) {
/*     */       
/*  29 */       String strValueSet = "valueSet";
/*  30 */       if (i > 1) {
/*  31 */         strValueSet = strValueSet + i;
/*     */       }
/*     */       
/*  34 */       Map<Integer, Integer> attributeValue = new HashMap<>();
/*     */       try {
/*  36 */         String[] valueSet = ClassUtil.getProperty(this, strValueSet).toString().split(";");
/*     */         
/*  38 */         for (String attribute : valueSet) {
/*     */           
/*  40 */           String[] as = attribute.split(":");
/*     */           
/*  42 */           if (as.length > 1) {
/*     */             
/*  44 */             int level = Integer.parseInt(as[0]);
/*     */             
/*  46 */             String value = as[1];
/*     */             
/*  48 */             String[] tmp = value.split("-");
/*  49 */             int _value = 0;
/*  50 */             if (tmp.length > 1) {
/*     */               
/*  52 */               _value = Utils.random(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
/*     */             } else {
/*  54 */               _value = Integer.parseInt(value);
/*     */             } 
/*     */             
/*  57 */             attributeValue.put(Integer.valueOf(level), Integer.valueOf(_value));
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/*  62 */         String attributeName = (String)ClassUtil.getProperty(this, "valueAttributeName" + i);
/*     */         
/*  64 */         if (StringUtil.isNotEmpty(attributeName) && 
/*  65 */           Const.PlayerBtlData.getEByKey(attributeName) != null)
/*     */         {
/*     */           
/*  68 */           this.attributeValues.put(Const.PlayerBtlData.getEByKey(attributeName), attributeValue);
/*     */         }
/*  70 */       } catch (Exception e) {
/*  71 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     if (StringUtil.isNotEmpty(this.power)) {
/*  76 */       String[] str_arr = this.power.split(";");
/*  77 */       int len = str_arr.length;
/*  78 */       this.power_arr = new int[len + 1];
/*  79 */       this.power_arr[0] = 0;
/*  80 */       for (int j = 0; j < len; j++) {
/*  81 */         String str = str_arr[j];
/*  82 */         String[] a_str = str.split(":");
/*  83 */         int lvl = Integer.parseInt(a_str[0]);
/*  84 */         if (lvl != j + 1) {
/*  85 */           Out.error(new Object[] { "宠物技能脚本的战力有问题,skillid=" + this.skillID });
/*     */         }
/*  87 */         this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSkillPower(int lvl) {
/*  99 */     if (lvl < 0)
/* 100 */       return 0; 
/* 101 */     if (this.power_arr != null) {
/*     */ 
/*     */       
/* 104 */       if (lvl > this.power_arr.length - 1) {
/* 105 */         return this.power_arr[this.power_arr.length - 1];
/*     */       }
/* 107 */       return this.power_arr[lvl];
/*     */     } 
/* 109 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PetSkillExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */