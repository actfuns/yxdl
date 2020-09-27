/*    */ package com.wanniu.game.poes;
/*    */ 
/*    */ import com.wanniu.core.game.entity.GEntity;
/*    */ import com.wanniu.game.DBTable;
/*    */ import com.wanniu.game.data.GameData;
/*    */ import com.wanniu.game.data.SevDayTaskCO;
/*    */ import com.wanniu.game.sevengoal.DayInfo;
/*    */ import com.wanniu.game.sevengoal.SevenGoalManager;
/*    */ import com.wanniu.game.sevengoal.TaskInfo;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ @DBTable("player_seven_goal")
/*    */ public class SevenGoalPO
/*    */   extends GEntity
/*    */ {
/*    */   public Map<Integer, DayInfo> dayInfoMap;
/*    */   public int currentTurn;
/*    */   
/*    */   public SevenGoalPO() {
/* 32 */     reset(-1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset(int newTurn) {
/* 37 */     this.dayInfoMap = new HashMap<>();
/* 38 */     for (SevDayTaskCO sevDayTaskCO : GameData.SevDayTasks.values()) {
/* 39 */       DayInfo dayInfo = this.dayInfoMap.get(Integer.valueOf(sevDayTaskCO.date));
/* 40 */       if (dayInfo == null) {
/* 41 */         dayInfo = new DayInfo();
/* 42 */         dayInfo.dayId = sevDayTaskCO.date;
/* 43 */         this.dayInfoMap.put(Integer.valueOf(dayInfo.dayId), dayInfo);
/*    */       } 
/*    */       
/* 46 */       TaskInfo taskInfo = new TaskInfo();
/* 47 */       taskInfo.taskId = sevDayTaskCO.iD;
/* 48 */       dayInfo.taskMap.put(Integer.valueOf(taskInfo.taskId), taskInfo);
/*    */     } 
/*    */     
/* 51 */     this.currentTurn = newTurn;
/*    */   }
/*    */   
/*    */   public void processAddFriend() {
/* 55 */     for (DayInfo dayInfo : this.dayInfoMap.values()) {
/* 56 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 57 */         SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 58 */         SevenGoalManager.SevenGoalTaskType sevenGoalTaskType = SevenGoalManager.SevenGoalTaskType.getType(sevDayTaskCO.style);
/* 59 */         if (sevenGoalTaskType == SevenGoalManager.SevenGoalTaskType.ADD_FRIEND) {
/* 60 */           taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void processPayCount() {
/* 67 */     for (DayInfo dayInfo : this.dayInfoMap.values()) {
/* 68 */       for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
/* 69 */         SevDayTaskCO sevDayTaskCO = (SevDayTaskCO)GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
/* 70 */         SevenGoalManager.SevenGoalTaskType sevenGoalTaskType = SevenGoalManager.SevenGoalTaskType.getType(sevDayTaskCO.style);
/* 71 */         if (sevenGoalTaskType == SevenGoalManager.SevenGoalTaskType.PAY_COUNT)
/* 72 */           taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\SevenGoalPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */