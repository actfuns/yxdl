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
/*    */ 
/*    */ @GClientEvent("five2five.five2FiveHandler.five2FiveReadyRequest")
/*    */ public class MatchReadyHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 26 */           Five2FiveHandler.Five2FiveReadyRequest req = Five2FiveHandler.Five2FiveReadyRequest.parseFrom(MatchReadyHandler.this.pak.getRemaingBytes());
/*    */           
/* 28 */           String teamId = req.getTempTeamId();
/* 29 */           Five2FiveHandler.Five2FiveReadyResponse.Builder res = Five2FiveHandler.Five2FiveReadyResponse.newBuilder();
/* 30 */           String msg = player.five2FiveManager.matchReady(teamId);
/* 31 */           if (!StringUtil.isEmpty(msg)) {
/* 32 */             res.setS2CCode(500);
/* 33 */             res.setS2CMsg(msg);
/*    */           } else {
/* 35 */             res.setS2CCode(200);
/*    */           } 
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\five2five\MatchReadyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */