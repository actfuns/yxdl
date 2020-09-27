/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ public class IllusionPO
/*    */ {
/*    */   public int todayExp;
/*    */   public int todayClassExp;
/*    */   public int todayGold;
/*    */   public Map<Integer, Integer> boxs;
/*    */   public Map<String, Integer> items;
/*    */   
/*    */   public boolean hasBoxData() {
/* 28 */     return (this.boxs != null && !this.boxs.isEmpty());
/*    */   }
/*    */   public boolean hasItemData() {
/* 31 */     return (this.items != null && !this.items.isEmpty());
/*    */   }
/*    */   
/*    */   public void resetBoxData() {
/* 35 */     if (this.boxs != null) {
/* 36 */       this.boxs.clear();
/*    */     }
/*    */   }
/*    */   
/*    */   public void resetItemData() {
/* 41 */     if (this.items != null) {
/* 42 */       this.items.clear();
/*    */     }
/*    */   }
/*    */   
/*    */   public void putBox(int lv, int count) {
/* 47 */     if (this.boxs == null) {
/* 48 */       this.boxs = new HashMap<>();
/*    */     }
/* 50 */     Integer cur = this.boxs.get(Integer.valueOf(lv));
/* 51 */     if (cur == null) {
/* 52 */       this.boxs.put(Integer.valueOf(lv), Integer.valueOf(count));
/*    */     } else {
/* 54 */       this.boxs.put(Integer.valueOf(lv), Integer.valueOf(count + cur.intValue()));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void putItem(String code, int count) {
/* 59 */     if (this.items == null) {
/* 60 */       this.items = new HashMap<>();
/*    */     }
/* 62 */     Integer cur = this.items.get(code);
/* 63 */     if (cur == null) {
/* 64 */       this.items.put(code, Integer.valueOf(count));
/*    */     } else {
/* 66 */       this.items.put(code, Integer.valueOf(count + cur.intValue()));
/*    */     } 
/*    */   }
/*    */   
/*    */   public int calTotalItemNum(String code) {
/* 71 */     if (this.items == null || this.items.isEmpty()) {
/* 72 */       return 0;
/*    */     }
/* 74 */     Integer c = this.items.get(code);
/* 75 */     return (c == null) ? 0 : c.intValue();
/*    */   }
/*    */   
/*    */   public int calTotalNum() {
/* 79 */     if (this.boxs == null || this.boxs.isEmpty()) {
/* 80 */       return 0;
/*    */     }
/* 82 */     int total = 0;
/* 83 */     Collection<Integer> cols = this.boxs.values();
/* 84 */     for (Integer i : cols) {
/* 85 */       total += i.intValue();
/*    */     }
/* 87 */     return total;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\IllusionPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */