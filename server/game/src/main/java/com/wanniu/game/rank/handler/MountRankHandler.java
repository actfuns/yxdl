/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.player.WNPlayer;
/*    */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*    */ import com.wanniu.game.rank.AbstractPlayerRankHandler;
/*    */ import com.wanniu.game.rank.RankType;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import pomelo.Common;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 23 */     return RankType.Mount.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 29 */     PlayerRankInfoPO info = player.rankManager.getRankPO();
/* 30 */     int oldFightPower = info.getMountFightPower();
/* 31 */     info.setMountFightPower(((Integer)value[0]).intValue());
/* 32 */     info.setMountSkinId(((Integer)value[1]).intValue());
/*    */ 
/*    */     
/* 35 */     if (oldFightPower != info.getMountFightPower()) {
/* 36 */       String key = getRedisKey(GWorld.__SERVER_ID);
/* 37 */       updateRank(key, info.getMountFightPower(), player.getId());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 43 */     contents.add(String.valueOf(player.getLevel()));
/* 44 */     contents.add(String.valueOf(score));
/* 45 */     contents.add(String.valueOf(player.getMountSkinId()));
/* 46 */     contents.add(player.getGuildName());
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
/* 51 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\MountRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */