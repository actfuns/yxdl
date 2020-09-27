/*    */ package com.wanniu.gm;
/*    */ 
/*    */ import com.wanniu.core.GGlobal;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class GMCDKResponse
/*    */   extends GMResponse
/*    */ {
/*    */   private boolean ok = true;
/*    */   private byte[] bytes;
/*    */   
/*    */   public GMCDKResponse(byte[] bytes) {
/* 13 */     super(252);
/* 14 */     this.bytes = bytes;
/*    */   }
/*    */   
/*    */   public GMCDKResponse(String errMsg) {
/* 18 */     this(errMsg.getBytes(GGlobal.UTF_8));
/* 19 */     this.ok = false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void response() throws IOException {
/* 24 */     this.body.writeBoolean(this.ok);
/* 25 */     this.body.writeInt(this.bytes.length);
/* 26 */     this.body.writeBytes(this.bytes);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\gm\GMCDKResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */