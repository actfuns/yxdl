/*    */ package com.wanniu.game.request.solo;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
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
/*    */ @GClientEvent("area.soloHandler.battleRecordRequest")
/*    */ public class BattleRecordHandler
/*    */   extends SoloRequestFilter
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 22 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 25 */           SoloHandler.BattleRecordResponse.Builder res = SoloHandler.BattleRecordResponse.newBuilder();
/* 26 */           player.soloManager.handleBattleRecord(res);
/* 27 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\solo\BattleRecordHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */