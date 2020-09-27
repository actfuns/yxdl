/*    */ package com.wanniu.core.db;
/*    */ 
/*    */ import com.wanniu.core.GConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBType
/*    */ {
/* 10 */   public static final short JOIN = GConfig.getInstance().getShort("db.type.join", (short)13297);
/*    */   
/* 12 */   public static final short PING = GConfig.getInstance().getShort("db.type.ping", (short)13298);
/*    */   
/* 14 */   public static final short UPDATE = GConfig.getInstance().getShort("db.type.update", (short)13299);
/*    */   
/* 16 */   public static final short QUERY = GConfig.getInstance().getShort("db.type.query", (short)13300);
/*    */   
/* 18 */   public static final short NOTIFY = GConfig.getInstance().getShort("db.type.notify", (short)13301);
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\DBType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */