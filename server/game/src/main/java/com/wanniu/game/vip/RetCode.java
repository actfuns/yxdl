/*    */ package com.wanniu.game.vip;
/*    */ 
/*    */ public enum RetCode {
/*  4 */   VIP_ERROR_NOT_EXIST(-1), VIP_ERROR_LESS_LEVEL(-2), VIP_ERROR_GRID_NOT_ENOUGH(-3), VIP_ERROR_GIFT_GET(-4), VIP_ERROR_CAN_NOT_GET(-5), VIP_ERROR_GIFT_BUY(-6), VIP_ERROR_CAN_NOT_BUY(-7), VIP_ERROR_DIAMOND_NOT_ENOUGH(-8), VIP_OK(1);
/*    */   private int value;
/*    */   
/*    */   RetCode(int value) {
/*  8 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 12 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\vip\RetCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */