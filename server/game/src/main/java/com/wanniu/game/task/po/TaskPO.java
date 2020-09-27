/*    */ package com.wanniu.game.task.po;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TaskPO
/*    */ {
/*    */   public int templateId;
/*    */   public int state;
/*    */   public int progress;
/* 11 */   public Map<String, String> battle_attributes = new HashMap<>();
/*    */   public int finishCount;
/* 13 */   public Map<Integer, Integer> extendData = new HashMap<>();
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\task\po\TaskPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */