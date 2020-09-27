/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.BattleRoyaleRankCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class BattleRoyaleRankExt
/*    */   extends BattleRoyaleRankCO
/*    */ {
/* 10 */   public Map<String, Integer> gradeRewards = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 14 */     String[] items = this.rankReward.trim().split(";");
/* 15 */     for (String item : items) {
/* 16 */       String[] str = item.trim().split(":");
/* 17 */       this.gradeRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\BattleRoyaleRankExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */