/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*    */ import com.wanniu.game.rank.AbstractPlayerRankHandler;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import com.wanniu.game.solo.SoloService;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoloRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 21 */     return RankType.SOLO_SCORE.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 26 */     int term = ((Integer)value[0]).intValue();
/* 27 */     int source = ((Integer)value[1]).intValue();
/*    */ 
/*    */     
/* 30 */     String key = getRedisKey(GWorld.__SERVER_ID, term);
/* 31 */     updateRank(key, source, player.getId());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 36 */     contents.add(String.valueOf(player.getLevel()));
/* 37 */     contents.add(String.valueOf(player.getFightPower()));
/* 38 */     contents.add(String.valueOf(score));
/* 39 */     contents.add(player.getGuildName());
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCurrentSeason() {
/* 44 */     return SoloService.getInstance().getTerm();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLastSeason() {
/* 49 */     int term = getCurrentSeason() - 1;
/* 50 */     return (term < 0) ? 0 : term;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\SoloRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */