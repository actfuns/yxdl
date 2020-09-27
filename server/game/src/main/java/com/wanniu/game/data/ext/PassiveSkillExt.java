/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.core.util.StringUtil;
/*    */ import com.wanniu.game.common.Const;
/*    */ import com.wanniu.game.data.PassiveSkillCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PassiveSkillExt
/*    */   extends PassiveSkillCO {
/*    */   public Const.PlayerBtlData ValueAttribute1;
/*    */   public Map<Integer, Integer> ValueSetMap1;
/*    */   public Const.PlayerBtlData ValueAttribute2;
/*    */   public Map<Integer, Integer> ValueSetMap2;
/*    */   public Const.PlayerBtlData ValueAttribute3;
/*    */   public Map<Integer, Integer> ValueSetMap3;
/*    */   
/*    */   public void initProperty() {
/* 19 */     if (StringUtil.isNotEmpty(this.valueAttributeName1)) {
/* 20 */       this.ValueAttribute1 = Const.PlayerBtlData.getEByKey(this.valueAttributeName1);
/* 21 */       this.ValueSetMap1 = new HashMap<>();
/* 22 */       String[] ss = this.valueSet.split(";");
/* 23 */       int len = ss.length;
/* 24 */       for (int i = 0; i < len; i++) {
/* 25 */         String str = ss[i];
/* 26 */         String[] a_str = str.split(":");
/* 27 */         if (a_str != null && a_str.length >= 2) {
/* 28 */           this.ValueSetMap1.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
/*    */         }
/*    */       } 
/*    */     } 
/* 32 */     if (StringUtil.isNotEmpty(this.valueAttributeName2)) {
/* 33 */       this.ValueAttribute2 = Const.PlayerBtlData.getEByKey(this.valueAttributeName2);
/* 34 */       this.ValueSetMap2 = new HashMap<>();
/* 35 */       String[] ss = this.valueSet2.split(";");
/* 36 */       int len = ss.length;
/* 37 */       for (int i = 0; i < len; i++) {
/* 38 */         String str = ss[i];
/* 39 */         String[] a_str = str.split(":");
/* 40 */         if (a_str != null && a_str.length >= 2) {
/* 41 */           this.ValueSetMap2.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1])));
/*    */         }
/*    */       } 
/*    */     } 
/* 45 */     if (StringUtil.isNotEmpty(this.valueAttributeName3)) {
/* 46 */       this.ValueAttribute3 = Const.PlayerBtlData.getEByKey(this.valueAttributeName3);
/* 47 */       this.ValueSetMap3 = new HashMap<>();
/* 48 */       String[] ss = this.valueSet3.split(";");
/* 49 */       int len = ss.length;
/* 50 */       for (int i = 0; i < len; i++) {
/* 51 */         String str = ss[i];
/* 52 */         String[] a_str = str.split(":");
/* 53 */         if (a_str != null && a_str.length >= 2)
/* 54 */           this.ValueSetMap3.put(Integer.valueOf(Integer.parseInt(a_str[0])), Integer.valueOf(Integer.parseInt(a_str[1]))); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\PassiveSkillExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */