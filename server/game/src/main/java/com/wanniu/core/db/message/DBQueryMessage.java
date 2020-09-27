/*    */ package com.wanniu.core.db.message;
/*    */ 
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.db.QueryVo;
/*    */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBQueryMessage
/*    */   extends RequestMessage
/*    */ {
/*    */   private QueryVo query;
/*    */   
/*    */   public DBQueryMessage(QueryVo query) {
/* 18 */     this.query = query;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 23 */     this.body.writeLong(this.reqId);
/* 24 */     this.body.writeString(this.query.getQueryTR());
/* 25 */     this.body.writeByte(this.query.type);
/* 26 */     this.body.writeString(this.query.getConVal());
/*    */   }
/*    */ 
/*    */   
/*    */   public short getType() {
/* 31 */     return DBType.QUERY;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\message\DBQueryMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */