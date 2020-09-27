/*    */ package com.wanniu.login.request;
/*    */ 
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.game.request.GClientEvent;
/*    */ import com.wanniu.login.proto.Common;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ @GClientEvent("connector.entryHandler.getSysTimeRequest")
/*    */ public class SysTimeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 15 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 18 */           Common.SysTimeResponse.Builder res = Common.SysTimeResponse.newBuilder();
/* 19 */           res.setS2CCode(200);
/*    */           
/* 21 */           res.setS2CTime(String.valueOf(System.currentTimeMillis()));
/*    */           
/* 23 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\login\request\SysTimeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */