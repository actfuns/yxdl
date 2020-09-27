/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_daily")
/*    */ public final class DailyActivityPO
/*    */   extends GEntity
/*    */ {
/* 18 */   public Map<Integer, DailyInfo> activeMap = new HashMap<>();
/* 19 */   public Map<Integer, DailyRewardInfo> rewards = new HashMap<>();
/*    */   public int totalDegree;
/*    */   
/*    */   public static class DailyInfo {
/*    */     public int id;
/*    */     public int process;
/*    */   }
/*    */   
/*    */   public static class DailyRewardInfo {
/*    */     public int id;
/*    */     public int state;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\DailyActivityPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */