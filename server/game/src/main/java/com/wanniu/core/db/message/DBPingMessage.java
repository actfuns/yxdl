/*    */ package com.wanniu.core.db.message;
/*    */ 
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBPingMessage
/*    */   extends RequestMessage
/*    */ {
/*    */   protected void write() throws IOException {}
/*    */   
/*    */   public short getType() {
/* 21 */     return DBType.PING;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\message\DBPingMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */