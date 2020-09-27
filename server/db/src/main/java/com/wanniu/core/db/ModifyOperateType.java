/*    */ package com.wanniu.core.db;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ModifyOperateType
/*    */ {
/* 11 */   UPDATE(1), INSERT(2), DELETE(0);
/*    */   
/*    */   public int value;
/*    */   
/*    */   ModifyOperateType(int tr) {
/* 16 */     this.value = tr;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\db\ModifyOperateType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */