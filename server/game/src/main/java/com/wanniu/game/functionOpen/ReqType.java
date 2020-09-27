/*    */ package com.wanniu.game.functionOpen;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ enum ReqType
/*    */ {
/* 27 */   LEVEL(0),
/* 28 */   ACCEPT_TASK(1),
/* 29 */   FINISH_TASK(2),
/* 30 */   INTERACT_ITEM(3);
/*    */   
/*    */   private int value;
/*    */   
/*    */   ReqType(int value) {
/* 35 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 39 */     return this.value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\functionOpen\ReqType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */