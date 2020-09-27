/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.wanniu.core.tcp.protocol.Message;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public abstract class GMResponse
/*    */   extends Message
/*    */ {
/*    */   protected long key;
/*    */   private short type;
/*    */   
/*    */   public GMResponse(int type) {
/* 13 */     this.type = (short)type;
/*    */   }
/*    */   
/*    */   public GMResponse(long key, int type) {
/* 17 */     this.key = key;
/* 18 */     this.type = (short)type;
/*    */   }
/*    */   
/*    */   public void setKey(long key) {
/* 22 */     this.key = key;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 27 */     this.body.writeLong(this.key);
/* 28 */     response();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract void response() throws IOException;
/*    */   
/*    */   public short getType() {
/* 35 */     return this.type;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */