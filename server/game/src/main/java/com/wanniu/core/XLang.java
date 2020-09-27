/*    */ package com.wanniu.core;
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
/*    */ public enum XLang
/*    */ {
/* 25 */   CN(19968, 40869, 6),
/*    */ 
/*    */ 
/*    */   
/* 29 */   VN(7680, 7935, 15);
/*    */   
/*    */   private final int unicodeStart;
/*    */   private final int unicodeEnd;
/*    */   private final int nameLimit;
/*    */   
/*    */   XLang(int unicodeStart, int unicodeEnd, int nameLimit) {
/* 36 */     this.unicodeStart = unicodeStart;
/* 37 */     this.unicodeEnd = unicodeEnd;
/* 38 */     this.nameLimit = nameLimit;
/*    */   }
/*    */   
/*    */   public int getUnicodeStart() {
/* 42 */     return this.unicodeStart;
/*    */   }
/*    */   
/*    */   public int getUnicodeEnd() {
/* 46 */     return this.unicodeEnd;
/*    */   }
/*    */   
/*    */   public int getNameLimit() {
/* 50 */     return this.nameLimit;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\XLang.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */