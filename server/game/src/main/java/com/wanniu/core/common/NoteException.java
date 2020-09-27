/*    */ package com.wanniu.core.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoteException
/*    */   extends Exception
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   public String reason;
/*    */   
/*    */   public NoteException() {}
/*    */   
/*    */   public NoteException(String reason) {
/* 18 */     this.reason = reason;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\common\NoteException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */