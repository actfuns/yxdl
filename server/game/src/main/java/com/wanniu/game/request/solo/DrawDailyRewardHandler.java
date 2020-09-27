/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.SoloHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.soloHandler.drawDailyRewardRequest")
/*    */ public class DrawDailyRewardHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 23 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException
/*    */         {
/* 27 */           SoloHandler.DrawDailyRewardResponse.Builder res = SoloHandler.DrawDailyRewardResponse.newBuilder();
/* 28 */           SoloHandler.DrawDailyRewardRequest req = SoloHandler.DrawDailyRewardRequest.parseFrom(DrawDailyRewardHandler.this.pak.getRemaingBytes());
/* 29 */           int index = req.getC2SIndex();
/* 30 */           player.soloManager.handleDrawDailyReward(index, res);
/* 31 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\DrawDailyRewardHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */