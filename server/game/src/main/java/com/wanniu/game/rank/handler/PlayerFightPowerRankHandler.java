/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*    */ import com.wanniu.game.rank.AbstractPlayerRankHandler;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerFightPowerRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 21 */     return RankType.FIGHTPOWER.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 27 */     PlayerRankInfoPO info = player.rankManager.getRankPO();
/* 28 */     info.setFightPower(((Integer)value[0]).intValue());
/*    */ 
/*    */     
/* 31 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 32 */     updateRank(key, info.getFightPower(), player.getId());
/*    */ 
/*    */     
/* 35 */     switch (player.getPro()) {
/*    */       case 1:
/* 37 */         updateRank(RankType.FIGHTPOWER_1.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
/*    */         return;
/*    */       case 3:
/* 40 */         updateRank(RankType.FIGHTPOWER_3.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
/*    */         return;
/*    */       case 5:
/* 43 */         updateRank(RankType.FIGHTPOWER_5.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
/*    */         return;
/*    */     } 
/* 46 */     Out.warn(new Object[] { "未实现的职业排行榜. pro=", Integer.valueOf(player.getPro()) });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 53 */     contents.add(String.valueOf(player.getLevel()));
/* 54 */     contents.add(String.valueOf(score));
/* 55 */     contents.add(player.getGuildName());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\PlayerFightPowerRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */