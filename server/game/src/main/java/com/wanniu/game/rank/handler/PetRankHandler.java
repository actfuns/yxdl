/*    */ package com.wanniu.game.rank.handler;
/*    */ 
/*    */ import com.wanniu.game.GWorld;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.ext.BaseDataExt;
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
/*    */ public class PetRankHandler
/*    */   extends AbstractPlayerRankHandler
/*    */ {
/*    */   protected String getRedisKey(int logicServerId, int season) {
/* 25 */     return RankType.PET.getRedisKey(logicServerId, season);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void handle(WNPlayer player, Object... value) {
/* 31 */     PlayerRankInfoPO info = player.rankManager.getRankPO();
/* 32 */     int oldFightPower = info.getPetFightPower();
/* 33 */     info.setPetId(((Integer)value[0]).intValue());
/* 34 */     info.setPetName((String)value[1]);
/* 35 */     info.setPetFightPower(((Integer)value[2]).intValue());
/*    */ 
/*    */     
/* 38 */     if (oldFightPower != info.getPetFightPower()) {
/* 39 */       String key = getRedisKey(GWorld.__SERVER_ID);
/* 40 */       updateRank(key, info.getPetFightPower(), player.getId());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/* 46 */     contents.add(player.getPetName());
/* 47 */     contents.add(String.valueOf(score));
/* 48 */     BaseDataExt prop = (BaseDataExt)GameData.BaseDatas.get(Integer.valueOf(player.getPetId()));
/* 49 */     if (null == prop) {
/*    */       return;
/*    */     }
/*    */     
/* 53 */     contents.add(prop.model);
/*    */     
/* 55 */     contents.add(String.valueOf(prop.modelPercent));
/*    */     
/* 57 */     contents.add(prop.icon);
/*    */     
/* 59 */     contents.add(String.valueOf(prop.qcolor));
/*    */     
/* 61 */     contents.add(String.valueOf(player.getLevel()));
/*    */     
/* 63 */     contents.add(String.valueOf(prop.modelY));
/*    */     
/* 65 */     contents.add(player.getGuildName());
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
/* 70 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\PetRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */