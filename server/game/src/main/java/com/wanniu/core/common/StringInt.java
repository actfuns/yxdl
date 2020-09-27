/*    */ package com.wanniu.core.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class StringInt
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public int intValue;
/*    */   public String strValue;
/*    */   
/*    */   public StringInt() {}
/*    */   
/*    */   public StringInt(int intValue, String strValue) {
/* 15 */     this.intValue = intValue;
/* 16 */     this.strValue = strValue;
/*    */   }
/*    */   
/*    */   public StringInt(String strValue, int intValue) {
/* 20 */     this.intValue = intValue;
/* 21 */     this.strValue = strValue;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\common\StringInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */