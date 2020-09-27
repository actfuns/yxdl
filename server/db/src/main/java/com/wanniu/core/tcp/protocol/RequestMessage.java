/*    */ package com.wanniu.core.tcp.protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RequestMessage
/*    */   extends Message
/*    */ {
/*    */   protected long reqId;
/*    */   
/*    */   public long setReqId(long reqId) {
/* 12 */     this.reqId = reqId;
/* 13 */     return this.reqId;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\tcp\protocol\RequestMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */