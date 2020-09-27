/*    */ package com.wanniu.game.item.data.tc;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TCItemData
/*    */ {
/*    */   public static final int TC_EQUIP_TYPE = 1;
/*    */   public static final int TC_ITEMCODE = 2;
/*    */   public static final int TC_INNER_TC = 3;
/*    */   public int tcType;
/*    */   public String code;
/*    */   public int num;
/*    */   public int minNum;
/*    */   public int maxNum;
/*    */   public int rare;
/*    */   public List<Integer> expandParas;
/*    */   
/*    */   public TCItemData() {}
/*    */   
/*    */   public TCItemData(String code, int num, int rare, List<Integer> expandParas, int minNum, int maxNum) {
/* 40 */     this.code = code;
/* 41 */     this.num = num;
/* 42 */     this.rare = rare;
/* 43 */     this.expandParas = expandParas;
/*    */     
/* 45 */     this.minNum = minNum;
/* 46 */     this.maxNum = maxNum;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\data\tc\TCItemData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */