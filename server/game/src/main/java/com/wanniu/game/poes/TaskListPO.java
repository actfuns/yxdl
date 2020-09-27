package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.task.LoopResult;
import com.wanniu.game.task.po.TaskPO;
import java.util.Map;

@DBTable("player_tasks")
public final class TaskListPO extends GEntity {
  public Map<Integer, TaskPO> normalTasks;
  
  public Map<Integer, Integer> finishedNormalTasks;
  
  public Map<Integer, TaskPO> dailyTasks;
  
  public Map<Integer, Integer> finishedDailyTasks;
  
  public Map<Integer, TaskPO> treasureTasks;
  
  public Map<Integer, Integer> finishedTreasureTasks;
  
  public int todayLoopTaskCount;
  
  public int todayDailyTaskCount;
  
  public boolean loopBreaked;
  
  public LoopResult loopResult;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\TaskListPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */