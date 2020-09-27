/*    */ package com.wanniu.game.item;
/*    */ 
/*    */ import com.wanniu.game.data.base.DItemEquipBase;
/*    */ import com.wanniu.game.item.po.PlayerItemPO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VirtualItem
/*    */   extends NormalItem
/*    */ {
/*    */   public VirtualItem(PlayerItemPO itemDb, DItemEquipBase prop) {
/* 15 */     super(itemDb, prop);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWorth() {
/* 20 */     return this.itemDb.speData.worth;
/*    */   }
/*    */   
/*    */   public void addWorth(int num) {
/* 24 */     this.itemDb.speData.worth += num;
/*    */   }
/*    */   
/*    */   public void setWorth(int num) {
/* 28 */     this.itemDb.speData.worth = num;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dropResetWorth(int args0, int args1, int args2) {
/* 35 */     int oldWorth = this.itemDb.speData.worth;
/* 36 */     int newWorth = this.itemDb.speData.worth;
/* 37 */     if (this.itemDb.code.equals("gold")) {
/* 38 */       int monsterLevel = args0;
/* 39 */       int goldPerMonLv = args1;
/* 40 */       int playerNum = (args2 > 1) ? args2 : 1;
/*    */ 
/*    */       
/* 43 */       newWorth = (oldWorth + (monsterLevel - 1) * goldPerMonLv) / playerNum;
/*    */     
/*    */     }
/* 46 */     else if (this.itemDb.code.equals("exp")) {
/* 47 */       int monsterLevel = args0;
/* 48 */       int expRatio = args1;
/* 49 */       int playerLevelUpExp = args2;
/*    */       
/* 51 */       newWorth = oldWorth + playerLevelUpExp * expRatio / 10000;
/*    */     } 
/*    */ 
/*    */     
/* 55 */     setWorth(newWorth);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\item\VirtualItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */