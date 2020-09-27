/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.flee.FleeReportCO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @DBTable("player_flee")
/*    */ public class FleePO
/*    */   extends GEntity
/*    */ {
/*    */   public int score;
/* 25 */   public Date seasonEndTime = new Date();
/*    */ 
/*    */   
/* 28 */   public int grade = 1;
/*    */ 
/*    */   
/* 31 */   public int maxGrade = 1;
/*    */ 
/*    */   
/*    */   public int maxRank;
/*    */ 
/*    */   
/* 37 */   public List<Integer> receiveGrades = new ArrayList<>();
/*    */ 
/*    */   
/* 40 */   public List<FleeReportCO> reports = new ArrayList<>();
/*    */   public boolean isPlayed;
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\FleePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */