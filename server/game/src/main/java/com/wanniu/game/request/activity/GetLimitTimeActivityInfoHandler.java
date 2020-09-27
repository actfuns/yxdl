/*    */ package com.wanniu.game.request.activity;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.LimitTimeActivityHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.limitTimeActivityHandler.getLimitTimeActivityInfoRequest")
/*    */ public class GetLimitTimeActivityInfoHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 18 */           LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.Builder res = LimitTimeActivityHandler.GetLimitTimeActivityInfoResponse.newBuilder();
/* 19 */           res.setS2CCode(200);
/* 20 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\activity\GetLimitTimeActivityInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */