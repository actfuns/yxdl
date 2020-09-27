/*    */ package com.wanniu.game.request.entry;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloRequest;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import java.io.IOException;
/*    */ import pomelo.connector.EntryHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("connector.entryHandler.getSysTimeRequest")
/*    */ public class GetSysTimeHandler
/*    */   extends PomeloRequest
/*    */ {
/*    */   public PomeloResponse request() throws Exception {
/* 16 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 19 */           EntryHandler.GetSysTimeResponse.Builder res = EntryHandler.GetSysTimeResponse.newBuilder();
/* 20 */           res.setS2CCode(200);
/* 21 */           res.setS2CTime(String.valueOf(System.currentTimeMillis()));
/* 22 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public short getType() {
/* 28 */     return 786;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\entry\GetSysTimeHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */