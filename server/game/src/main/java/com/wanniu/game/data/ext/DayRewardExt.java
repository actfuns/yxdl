/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.DayRewardCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DayRewardExt
/*    */   extends DayRewardCO
/*    */ {
/* 14 */   public Map<String, Integer> dayRewards = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 18 */     String[] items = this.rankReward.trim().split(";");
/* 19 */     for (String item : items) {
/* 20 */       String[] str = item.trim().split(":");
/* 21 */       this.dayRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\DayRewardExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */