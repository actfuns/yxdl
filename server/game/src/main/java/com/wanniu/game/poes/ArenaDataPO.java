/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_arena_data")
/*    */ public class ArenaDataPO
/*    */   extends GEntity
/*    */ {
/* 15 */   public int usedDefTimes = 0;
/* 16 */   public int singleReward = 0;
/* 17 */   public int totalReward = 0;
/*    */   
/* 19 */   public int score = 0;
/* 20 */   public int combo = 0;
/* 21 */   public int comboDaily = 0;
/* 22 */   public int scoreMonth = 0;
/*    */   
/* 24 */   public int killDaily = 0;
/* 25 */   public int killMonth = 0;
/* 26 */   public int deadMonth = 0;
/*    */   
/* 28 */   public int singleWinTimes = 0;
/* 29 */   public long firstSingleWinTime = 0L;
/*    */   public long activityTime;
/*    */   public int season;
/*    */   public String arenaInstanceId;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\ArenaDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */