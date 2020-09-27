/*    */ package com.wanniu.core.db;
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
/*    */ public class ModifyVo
/*    */ {
/*    */   private String modifyTR;
/*    */   private String modifyPKey;
/*    */   private int modifyOperate;
/*    */   private int modifyDataType;
/*    */   
/*    */   public ModifyVo(String modifyTR, String modifyPKey, ModifyOperateType modifyOperate) {
/* 21 */     this.modifyTR = modifyTR;
/* 22 */     this.modifyPKey = modifyPKey;
/* 23 */     this.modifyOperate = modifyOperate.value;
/*    */   }
/*    */   
/*    */   public ModifyVo(String modifyTR, String modifyPKey, ModifyOperateType modifyOperate, ModifyDataType modifyDataType) {
/* 27 */     this(modifyTR, modifyPKey, modifyOperate);
/* 28 */     this.modifyDataType = modifyDataType.value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getModifyTR() {
/* 35 */     return this.modifyTR;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getModifyPKey() {
/* 42 */     return this.modifyPKey;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getModifyOperate() {
/* 49 */     return this.modifyOperate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getModifyDataType() {
/* 56 */     return this.modifyDataType;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\ModifyVo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */