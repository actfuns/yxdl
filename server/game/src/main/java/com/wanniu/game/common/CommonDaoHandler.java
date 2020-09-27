/*    */ package com.wanniu.game.common;
/*    */ 
/*    */ import com.wanniu.core.db.handler.DBHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonDaoHandler
/*    */   extends DBHandler
/*    */ {
/*    */   private String sql;
/*    */   
/*    */   public void run() {
/* 16 */     execute(this.sql);
/*    */   }
/*    */   
/*    */   public CommonDaoHandler(String sql) {
/* 20 */     this.sql = sql;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\CommonDaoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */