/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.BattleRoyaleRankSeasonRewardCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class BattleRoyaleRankSeasonRewardExt
/*    */   extends BattleRoyaleRankSeasonRewardCO
/*    */ {
/* 11 */   public Map<String, Integer> rankRewards = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 15 */     String[] items = this.rankReward.trim().split(";");
/* 16 */     for (String item : items) {
/* 17 */       String[] str = item.trim().split(":");
/* 18 */       this.rankRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BattleRoyaleRankSeasonRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */