/*    */ package com.wanniu.game.request.fightLevel;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GClientEvent;
/*    */ import com.wanniu.core.game.protocol.PomeloResponse;
/*    */ import com.wanniu.game.area.Area;
/*    */ import com.wanniu.game.fightLevel.FightLevelManager;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
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
/*    */ 
/*    */ @GClientEvent("area.fightLevelHandler.getBossDamageRankRequest")
/*    */ public class GetBossDamageRankHandler
/*    */   extends FightLevelLine
/*    */ {
/*    */   public PomeloResponse request(final WNPlayer player) throws Exception {
/* 28 */     return new PomeloResponse()
/*    */       {
/*    */         protected void write() throws IOException {
/* 31 */           FightLevelHandler.GetBossDamageRankResponse.Builder res = FightLevelHandler.GetBossDamageRankResponse.newBuilder();
/*    */           
/* 33 */           Area area = player.getArea();
/*    */           
/* 35 */           FightLevelManager fightLevelManager = player.fightLevelManager;
/*    */           
/* 37 */           GetBossDamageRankHandler.GetBossDamageRankResult data = fightLevelManager.getBossDamageRank(player, area);
/*    */ 
/*    */ 
/*    */           
/* 41 */           res.setS2CCode(200);
/* 42 */           res.addAllS2CRankInfos(data.rankInfos);
/* 43 */           res.setS2COwnDamage(data.ownDamage);
/* 44 */           res.setS2COwnRank(data.ownRank);
/*    */           
/* 46 */           this.body.writeBytes(res.build().toByteArray());
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public static class GetBossDamageRankResult
/*    */   {
/*    */     public List<FightLevelHandler.RankInfo> rankInfos;
/*    */     public int ownDamage;
/*    */     public int ownRank;
/*    */     
/*    */     public GetBossDamageRankResult(List<FightLevelHandler.RankInfo> rankInfos, int ownDamage, int ownRank) {
/* 58 */       this.rankInfos = rankInfos;
/* 59 */       this.ownDamage = ownDamage;
/* 60 */       this.ownRank = ownRank;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\request\fightLevel\GetBossDamageRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */