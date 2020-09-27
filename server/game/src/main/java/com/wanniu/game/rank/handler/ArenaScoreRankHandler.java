/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.core.db.GCache;
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
/*    */ public class ArenaScoreRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/* 17 */   private static final ArenaScoreRankHandler instance = new ArenaScoreRankHandler();
/*    */   
/*    */   public static ArenaScoreRankHandler getInstance() {
/* 20 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 25 */     return RankType.ARENA_SCORE.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {}
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 33 */     contents.add(String.valueOf(player.getLevel()));
/* 34 */     contents.add(String.valueOf(player.getFightPower()));
/* 35 */     contents.add(String.valueOf(score));
/*    */   }
/*    */ 
/*    */   
/*    */   public void asyncUpdateRank(int serverId, String playerId, int score) {
/* 40 */     String key = getRedisKey(serverId);
/* 41 */     Double oldScore = GCache.zscore(key, playerId);
/* 42 */     if (oldScore != null && oldScore.doubleValue() > score) {
/*    */       return;
/*    */     }
/* 45 */     updateRank(key, score, playerId);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\ArenaScoreRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */