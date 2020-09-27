/*    */ package com.wanniu.game.request.five2five;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
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
/*    */ @GClientEvent("five2five.five2FiveHandler.five2FiveLookMatchResultRequest")
/*    */ public class LookMatchResultHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 21 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 24 */           Five2FiveHandler.Five2FiveShardMatchResultRequest req = Five2FiveHandler.Five2FiveShardMatchResultRequest.parseFrom(LookMatchResultHandler.this.pak.getRemaingBytes());
/* 25 */           String instanceId = req.getInstanceId();
/* 26 */           Five2FiveHandler.Five2FiveLookMatchResultResponse.Builder res = Five2FiveHandler.Five2FiveLookMatchResultResponse.newBuilder();
/* 27 */           player.five2FiveManager.lookMatchResult(instanceId, res);
/* 28 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\five2five\LookMatchResultHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */