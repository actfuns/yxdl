/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.game.arena.ArenaService;
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
/*    */ public class ArenaScoreAllRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/* 17 */   private static final ArenaScoreAllRankHandler instance = new ArenaScoreAllRankHandler();
/*    */   
/*    */   public static ArenaScoreAllRankHandler getInstance() {
/* 20 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 25 */     return RankType.ARENA_SCOREALL.getRedisKey(logicServerId, season);
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
/*    */   public void asyncUpdateRank(int serverId, String playerId, int score) {
/* 39 */     String key = getRedisKey(serverId, getCurrentSeason());
/* 40 */     updateRank(key, score, playerId);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCurrentSeason() {
/* 45 */     return ArenaService.getInstance().getTerm();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLastSeason() {
/* 50 */     int term = getCurrentSeason() - 1;
/* 51 */     return (term < 0) ? 0 : term;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\ArenaScoreAllRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */