/*    */ package com.wanniu.db.handler;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DBHandler
/*    */   extends NetHandler
/*    */ {
/*    */   public static String tableName(String tr) {
/* 17 */     return "tb_" + tr;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\handler\DBHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */