/*    */ package com.wanniu.game.rank.handler;
/*    */ 
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
/*    */ public class DaoYouRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/* 16 */   private static final DaoYouRankHandler instance = new DaoYouRankHandler();
/*    */   
/*    */   public static DaoYouRankHandler getInstance() {
/* 19 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 24 */     return RankType.DAOYOU.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {}
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 32 */     contents.add(String.valueOf(player.getLevel()));
/* 33 */     contents.add(String.valueOf(player.getFightPower()));
/* 34 */     contents.add(String.valueOf(score));
/*    */   }
/*    */   
/*    */   public void asyncUpdateRank(int serverId, String memberId, int score) {
/* 38 */     updateRank(getRedisKey(serverId), score, memberId);
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\DaoYouRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */