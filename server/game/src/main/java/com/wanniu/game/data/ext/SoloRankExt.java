/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.SoloRankCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SoloRankExt
/*    */   extends SoloRankCO
/*    */ {
/* 10 */   public Map<String, Integer> rankRewards = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void initProperty() {
/* 14 */     String[] items = this.rankReward.trim().split(";");
/* 15 */     for (String item : items) {
/* 16 */       String[] str = item.trim().split(":");
/* 17 */       this.rankRewards.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\SoloRankExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */