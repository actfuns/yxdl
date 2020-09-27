/*    */ package com.wanniu.game.data.base;
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
/*    */ public abstract class SaleBase
/*    */ {
/*    */   public int iD;
/*    */   public int typeID;
/*    */   public String typeName;
/*    */   public int itemID;
/*    */   public String itemShowName;
/*    */   public String itemCode;
/*    */   public int isDynamic;
/*    */   public int isBind;
/*    */   public int itemCount;
/*    */   public int goldPrice;
/*    */   public int cashPrice;
/*    */   public int diamondPrice;
/*    */   public int moneyType;
/*    */   public int needMoney;
/*    */   
/*    */   public Integer getKey() {
/* 36 */     return Integer.valueOf(this.iD);
/*    */   }
/*    */ 
/*    */   
/*    */   public void beforeProperty() {}
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 44 */     if (this.goldPrice > 0) {
/* 45 */       this.moneyType = 1;
/* 46 */       this.needMoney = this.goldPrice;
/* 47 */     } else if (this.cashPrice > 0) {
/* 48 */       this.moneyType = 2;
/* 49 */       this.needMoney = this.cashPrice;
/* 50 */     } else if (this.diamondPrice > 0) {
/* 51 */       this.moneyType = 3;
/* 52 */       this.needMoney = this.diamondPrice;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\base\SaleBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */