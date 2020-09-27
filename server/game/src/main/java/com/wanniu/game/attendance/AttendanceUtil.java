/*    */ package com.wanniu.game.attendance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttendanceUtil
/*    */ {
/*    */   private static AttendanceUtil instance;
/*    */   
/*    */   public static AttendanceUtil getInstance() {
/* 13 */     if (instance == null) {
/* 14 */       instance = new AttendanceUtil();
/*    */     }
/* 16 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\attendance\AttendanceUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */