/*    */ package com.wanniu.game.request.five2five;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.core.util.StringUtil;
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
/*    */ @GClientEvent("five2five.five2FiveHandler.five2FiveShardMatchResultRequest")
/*    */ public class ShardMatchResultHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           Five2FiveHandler.Five2FiveShardMatchResultRequest req = Five2FiveHandler.Five2FiveShardMatchResultRequest.parseFrom(ShardMatchResultHandler.this.pak.getRemaingBytes());
/* 26 */           String instanceId = req.getInstanceId();
/*    */           
/* 28 */           Five2FiveHandler.Five2FiveShardMatchResultResponse.Builder res = Five2FiveHandler.Five2FiveShardMatchResultResponse.newBuilder();
/* 29 */           String msg = player.five2FiveManager.shardMatchResult(instanceId);
/* 30 */           if (!StringUtil.isEmpty(msg)) {
/* 31 */             res.setS2CCode(500);
/* 32 */             res.setS2CMsg(msg);
/*    */           } else {
/* 34 */             res.setS2CCode(200);
/*    */           } 
/* 36 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\five2five\ShardMatchResultHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */