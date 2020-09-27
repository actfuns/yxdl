/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.data.SkillDataCO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkillDataExt
/*     */   extends SkillDataCO
/*     */ {
/*     */   public int pro_;
/*     */   public List<Integer> lvReqData;
/*     */   public Map<Integer, Integer> costReqData;
/*     */   public List<CostItemReqData> costItemReqData;
/*     */   public int[] power_arr;
/*     */   
/*     */   public void initProperty() {
/*  31 */     this.pro_ = Const.PlayerPro.Value(this.pro);
/*     */     
/*  33 */     String lvReqStr = this.upReqLevel;
/*  34 */     this.lvReqData = new ArrayList<>();
/*  35 */     if (StringUtil.isNotEmpty(lvReqStr)) {
/*  36 */       String[] a_lvReqStr = lvReqStr.split(";");
/*  37 */       int len = a_lvReqStr.length;
/*  38 */       for (int i = 0; i < len; i++) {
/*  39 */         this.lvReqData.add(Integer.valueOf(Integer.parseInt(a_lvReqStr[i])));
/*     */       }
/*     */     } 
/*  42 */     this.lvReqData.add(Integer.valueOf(-1));
/*     */     
/*  44 */     String costReqStr = this.upCostGold;
/*  45 */     this.costReqData = new HashMap<>();
/*  46 */     if (StringUtil.isNotEmpty(costReqStr)) {
/*  47 */       String[] a_costReqStr = costReqStr.split(";");
/*  48 */       int len = a_costReqStr.length;
/*  49 */       for (int i = 0; i < len; i++) {
/*  50 */         String str = a_costReqStr[i];
/*  51 */         String[] a_str = str.split(":");
/*  52 */         if (a_str != null && a_str.length >= 2) {
/*  53 */           this.costReqData.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     String costItemReqStr = this.upCostItem;
/*  62 */     this.costItemReqData = new ArrayList<>();
/*  63 */     if (StringUtil.isNotEmpty(costItemReqStr)) {
/*  64 */       String[] a_costItemReqStr = costItemReqStr.split(";");
/*  65 */       int len = a_costItemReqStr.length;
/*  66 */       for (int i = 0; i < len; i++) {
/*  67 */         String str = a_costItemReqStr[i];
/*  68 */         String[] a_str = str.split(":");
/*  69 */         if (a_str != null && a_str.length >= 2) {
/*  70 */           this.costItemReqData.add(new CostItemReqData(i, a_str[0], Integer.parseInt(a_str[1])));
/*  71 */           if (i == len - 1) {
/*  72 */             this.costItemReqData.add(new CostItemReqData(i, a_str[0], -1));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  79 */     if (StringUtil.isNotEmpty(this.power)) {
/*  80 */       String[] str_arr = this.power.split(";");
/*  81 */       int len = str_arr.length;
/*  82 */       this.power_arr = new int[len + 1];
/*  83 */       this.power_arr[0] = 0;
/*  84 */       for (int i = 0; i < len; i++) {
/*  85 */         String str = str_arr[i];
/*  86 */         String[] a_str = str.split(":");
/*  87 */         int lvl = Integer.parseInt(a_str[0]);
/*  88 */         if (lvl != i + 1) {
/*  89 */           Out.error(new Object[] { "技能脚本的战力有问题,skillid=", Integer.valueOf(this.skillID) });
/*     */         }
/*  91 */         this.power_arr[Integer.parseInt(a_str[0])] = Integer.parseInt(a_str[1]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public class CostItemReqData
/*     */   {
/*     */     public int lv;
/*     */     public String itemCode;
/*     */     public int num;
/*     */     
/*     */     public CostItemReqData(int lv, String itemCode, int num) {
/* 103 */       this.lv = lv;
/* 104 */       this.itemCode = itemCode;
/* 105 */       this.num = num;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSkillPower(int lvl) {
/* 115 */     if (lvl < 0)
/* 116 */       return 0; 
/* 117 */     if (this.power_arr != null) {
/*     */ 
/*     */       
/* 120 */       if (lvl > this.power_arr.length - 1) {
/* 121 */         return this.power_arr[this.power_arr.length - 1];
/*     */       }
/* 123 */       return this.power_arr[lvl];
/*     */     } 
/* 125 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SkillDataExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */