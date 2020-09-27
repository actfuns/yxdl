/*    */ package com.wanniu.core.db;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ModifyOperateType
/*    */ {
/*  9 */   UPDATE(1), INSERT(2), DELETE(0);
/*    */   
/*    */   public int value;
/*    */   
/*    */   ModifyOperateType(int tr) {
/* 14 */     this.value = tr;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\ModifyOperateType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */