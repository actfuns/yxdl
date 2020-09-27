/*    */ package com.wanniu.game.request.five2five;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.request.solo.SoloRequestFilter;
/*    */ import java.io.IOException;
/*    */ import pomelo.five2five.Five2FiveHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("five2five.five2FiveHandler.five2FiveLookBtlReportRequest")
/*    */ public class LookBtlReportHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 20 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 23 */           Five2FiveHandler.Five2FiveLookBtlReportResponse.Builder res = Five2FiveHandler.Five2FiveLookBtlReportResponse.newBuilder();
/* 24 */           player.five2FiveManager.lookBtlReport(res);
/* 25 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\five2five\LookBtlReportHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */