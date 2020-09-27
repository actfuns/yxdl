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
/*    */ public class PlayerMagRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 20 */     return RankType.MAGIC.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 26 */     PlayerRankInfoPO info = player.rankManager.getRankPO();
/* 27 */     info.setMag(((Integer)value[0]).intValue());
/*    */ 
/*    */     
/* 30 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 31 */     updateRank(key, info.getMag(), player.getId());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 36 */     contents.add(String.valueOf(player.getLevel()));
/* 37 */     contents.add(String.valueOf(player.getFightPower()));
/* 38 */     contents.add(String.valueOf(score));
/* 39 */     contents.add(player.getGuildName());
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\PlayerMagRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */