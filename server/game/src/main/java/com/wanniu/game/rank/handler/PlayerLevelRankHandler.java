/*    */ package com.wanniu.game.rank.handler;
/*    */ 
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
/*    */ public class PlayerLevelRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 20 */     return RankType.LEVEL.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 26 */     PlayerRankInfoPO info = player.rankManager.getRankPO();
/* 27 */     info.setLevel(((Integer)value[0]).intValue());
/* 28 */     info.setUpOrder(((Integer)value[1]).intValue());
/*    */ 
/*    */     
/* 31 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 32 */     updateRank(key, info.getLevel(), player.getId());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 37 */     contents.add(String.valueOf(score));
/* 38 */     contents.add(String.valueOf(player.getFightPower()));
/* 39 */     contents.add(String.valueOf(player.getUpOrder()));
/* 40 */     contents.add(player.getGuildName());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\PlayerLevelRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */