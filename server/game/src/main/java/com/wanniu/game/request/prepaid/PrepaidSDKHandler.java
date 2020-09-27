/*    */ package com.wanniu.game.request.prepaid;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.PrepaidHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.prepaidHandler.prepaidSDKRequest")
/*    */ public class PrepaidSDKHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     return new PomeloResponse() {
/*    */         protected void write() throws IOException {
/* 18 */           PrepaidHandler.PrepaidSDKResponse.Builder res = PrepaidHandler.PrepaidSDKResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 23 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\prepaid\PrepaidSDKHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */