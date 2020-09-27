package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SevDayTaskCO;
import com.wanniu.game.sevengoal.DayInfo;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.sevengoal.TaskInfo;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_seven_goal")
public class SevenGoalPO
        extends GEntity {
    public Map<Integer, DayInfo> dayInfoMap;
    public int currentTurn;

    public SevenGoalPO() {
        reset(-1);
    }


    public void reset(int newTurn) {
        this.dayInfoMap = new HashMap<>();
        for (SevDayTaskCO sevDayTaskCO : GameData.SevDayTasks.values()) {
            DayInfo dayInfo = this.dayInfoMap.get(Integer.valueOf(sevDayTaskCO.date));
            if (dayInfo == null) {
                dayInfo = new DayInfo();
                dayInfo.dayId = sevDayTaskCO.date;
                this.dayInfoMap.put(Integer.valueOf(dayInfo.dayId), dayInfo);
            }

            TaskInfo taskInfo = new TaskInfo();
            taskInfo.taskId = sevDayTaskCO.iD;
            dayInfo.taskMap.put(Integer.valueOf(taskInfo.taskId), taskInfo);
        }

        this.currentTurn = newTurn;
    }

    public void processAddFriend() {
        for (DayInfo dayInfo : this.dayInfoMap.values()) {
            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
                SevenGoalManager.SevenGoalTaskType sevenGoalTaskType = SevenGoalManager.SevenGoalTaskType.getType(sevDayTaskCO.style);
                if (sevenGoalTaskType == SevenGoalManager.SevenGoalTaskType.ADD_FRIEND) {
                    taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                }
            }
        }
    }

    public void processPayCount() {
        for (DayInfo dayInfo : this.dayInfoMap.values()) {
            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
                SevenGoalManager.SevenGoalTaskType sevenGoalTaskType = SevenGoalManager.SevenGoalTaskType.getType(sevDayTaskCO.style);
                if (sevenGoalTaskType == SevenGoalManager.SevenGoalTaskType.PAY_COUNT)
                    taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
            }
        }
    }
}


