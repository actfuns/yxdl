/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.SoloRankSeasonRewardCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class SoloRankSeasonRewardExt
/*    */   extends SoloRankSeasonRewardCO
/*    */ {
/* 11 */   public Map<String, Integer> rankRewards = new HashMap<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 16 */     String[] items = this.rankReward.trim().split(";");
/* 17 */     for (String item : items) {
/* 18 */       String[] str = item.trim().split(":");
/* 19 */       this.rankRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SoloRankSeasonRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */