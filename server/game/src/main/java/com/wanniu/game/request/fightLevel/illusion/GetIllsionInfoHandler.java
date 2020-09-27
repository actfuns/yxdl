/*    */ package com.wanniu.game.request.fightLevel.illusion;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.IllusionPO;
/*    */ import com.wanniu.game.request.fightLevel.FightLevelLine;
/*    */ import java.io.IOException;
/*    */ import pomelo.area.FightLevelHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getLllsionInfoRequest")
/*    */ public class GetIllsionInfoHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(WNPlayer player) throws Exception {
/* 22 */     IllusionPO illusion = player.illusionManager.illusionPO;
/*    */     
/* 24 */     final FightLevelHandler.GetLllsionInfoResponse.Builder res = FightLevelHandler.GetLllsionInfoResponse.newBuilder();
/* 25 */     res.setS2CCode(200);
/* 26 */     res.setS2CMaxExp(0);
/* 27 */     res.setS2CMaxClassexp(0);
/* 28 */     res.setS2CMaxGold(0);
/*    */     
/* 30 */     res.setS2CTodayExp(illusion.todayExp);
/* 31 */     res.setS2CTodayClassexp(illusion.todayClassExp);
/* 32 */     res.setS2CTodayGold(illusion.todayGold);
/*    */     
/* 34 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 37 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\illusion\GetIllsionInfoHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */