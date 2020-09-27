/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getBossInfoRequest")
/*    */ public class GetBossInfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 24 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 27 */           FightLevelHandler.GetBossInfoResponse.Builder res = FightLevelHandler.GetBossInfoResponse.newBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 34 */           res.setS2CCode(200);
/*    */ 
/*    */           
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\GetBossInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */