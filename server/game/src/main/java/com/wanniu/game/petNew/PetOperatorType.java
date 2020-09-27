/*    */ package com.wanniu.game.petNew;
/*    */ 
/*    */ public enum PetOperatorType
/*    */ {
/*  5 */   Add(0), Delete(1), Replace(2), Reset(3);
/*    */   
/*    */   private int value;
/*    */   
/*    */   PetOperatorType(int value) {
/* 10 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 14 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\petNew\PetOperatorType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */