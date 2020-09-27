/*    */ package com.wanniu.game.data.ext;
/*    */ 
/*    */ import com.wanniu.game.data.GuildFortCO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GuildFortExt
/*    */   extends GuildFortCO
/*    */ {
/* 10 */   public Map<String, Integer> winnerReward = new HashMap<>();
/*    */   
/* 12 */   public Map<String, Integer> loserReward = new HashMap<>();
/*    */   
/* 14 */   public Map<String, Integer> dailyReward = new HashMap<>();
/*    */   
/*    */   public void initProperty() {
/* 17 */     String[] items = this.victoryResources.trim().split(";");
/* 18 */     for (String item : items) {
/* 19 */       String[] str = item.trim().split(":");
/* 20 */       this.winnerReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */     
/* 23 */     items = this.failResources.trim().split(";");
/* 24 */     for (String item : items) {
/* 25 */       String[] str = item.trim().split(":");
/* 26 */       this.loserReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */     
/* 29 */     items = this.dayResources.trim().split(";");
/* 30 */     for (String item : items) {
/* 31 */       String[] str = item.trim().split(":");
/* 32 */       this.dailyReward.put(str[0], Integer.valueOf(Integer.parseInt(str[1])));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\GuildFortExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */