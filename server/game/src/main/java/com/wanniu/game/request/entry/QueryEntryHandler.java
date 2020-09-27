/*    */ package com.wanniu.game.request.entry;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.gate.GateHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("gate.gateHandler.queryEntryRequest")
/*    */ public class QueryEntryHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           GateHandler.QueryEntryResponse.Builder res = GateHandler.QueryEntryResponse.newBuilder();
/* 26 */           res.setS2CCode(200);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 31 */           res.setS2CToken("succeed!");
/*    */           
/* 33 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\entry\QueryEntryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */