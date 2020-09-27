/*    */ package com.wanniu.core.game.protocol;
/*    */ 
/*    */ import com.wanniu.login.proto.Common;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class ErrorResponse
/*    */   extends PomeloResponse
/*    */ {
/*    */   private String errMsg;
/*    */   
/*    */   public ErrorResponse(String errMsg) {
/* 12 */     this.errMsg = errMsg;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 17 */     Common.ErrMsg.Builder err = Common.ErrMsg.newBuilder();
/* 18 */     err.setS2CCode(500);
/* 19 */     err.setS2CMsg(this.errMsg);
/* 20 */     this.body.writeBytes(err.build().toByteArray());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\protocol\ErrorResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */