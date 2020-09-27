/*    */ package com.wanniu.game.common.msg;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.Common;
/*    */ 
/*    */ 
/*    */ public class ErrorResponse
/*    */   extends PomeloResponse
/*    */ {
/*    */   private String errMsg;
/*    */   
/*    */   public ErrorResponse() {}
/*    */   
/*    */   public ErrorResponse(String errMsg) {
/* 16 */     this.errMsg = errMsg;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void write() throws IOException {
/* 21 */     Common.ErrMsg.Builder err = Common.ErrMsg.newBuilder();
/* 22 */     err.setS2CCode(500);
/* 23 */     err.setS2CMsg((this.errMsg != null) ? this.errMsg : "");
/* 24 */     this.body.writeBytes(err.build().toByteArray());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\msg\ErrorResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */