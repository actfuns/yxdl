/*    */ package com.wanniu.login.vo;
/*    */ 
/*    */ public enum ServerLoad
/*    */ {
/*  5 */   MAINTAIN(0, "维护"),
/*  6 */   SMOOTH(1, "流畅"),
/*  7 */   BUSY(2, "繁忙"),
/*  8 */   FULL(3, "爆满");
/*    */   
/*    */   public final int value;
/*    */   
/*    */   ServerLoad(int value, String desc) {
/* 13 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\vo\ServerLoad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */