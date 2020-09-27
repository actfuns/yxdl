package com.wanniu.game.task;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.common.StringString;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.task.po.TaskPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.task.TaskOuterClass;


public class TaskData {
    public TaskBase prop;
    public TaskPO db;
    private int secProgress = -1;

    public TaskData(TaskBase prop) {
        this.db = new TaskPO();
        this.db.templateId = prop.getId();
        this.db.progress = 0;
        this.db.finishCount = 0;
        this.db.extendData = new HashMap<>();
        this.prop = prop;
    }

    public TaskData(TaskPO po) {
        this.db = po;

        TaskBase prop = TaskUtils.getTaskProp(this.db.templateId);
        if (prop != null) {
            this.prop = prop;
            setProgress(this.db.progress);
        } else {
            Out.error(new Object[]{"there is no data of id: ", Integer.valueOf(this.db.templateId), " in taskProps "});
        }
    }

    protected Map<String, String> _getBattlerAttribute() {
        if (this.db.battle_attributes == null) {
            this.db.battle_attributes = new HashMap<>();
        }
        return this.db.battle_attributes;
    }


    public final int getKind() {
        return this.prop.getKind();
    }


    public final int getType() {
        return this.prop.getType();
    }


    public final int getTargetNum() {
        return this.prop.quantity;
    }


    public final boolean isTargetID(TaskEvent msg) {
        if (this.prop.getType() == Const.TaskType.FINISH_CLONESCENE.getValue()) {
            if (Integer.valueOf(msg.params[0].toString()).intValue() == this.prop.doScene) {
                return true;
            }
            return false;
        }
        if (this.prop.getType() == Const.TaskType.TAKE_EQUIP_Qt.getValue()) {
            String[] conditionArr = ((String) this.prop.targets.get(0)).split("\\|");
            String[] conditionArr1 = ((String) msg.params[0]).split("\\|");
            if (conditionArr.length > 1 && conditionArr1.length > 2) {
                int arr0 = Integer.parseInt(conditionArr[0]);
                int arr10 = Integer.parseInt(conditionArr1[0]);
                int arr1 = Integer.parseInt(conditionArr[1]);
                int arr11 = Integer.parseInt(conditionArr1[1]);
                int arr12 = Integer.parseInt(conditionArr1[2]);
                if (arr10 >= arr0 && arr11 >= arr1) {
                    if (this.db.extendData == null) {
                        this.db.extendData = new HashMap<>();
                    }
                    if (this.db.extendData.containsKey(Integer.valueOf(arr12))) {
                        return false;
                    }
                    this.db.extendData.put(Integer.valueOf(arr12), Integer.valueOf(1));
                    return true;
                }
                if (arr10 < arr0 || arr11 >= arr1) ;


                return false;
            }
            return false;
        }

        if (this.prop.isTarget(String.valueOf(msg.params[0]))) {
            return true;
        }
        if (this.prop.isTarget("") && this.prop.getType() != Const.TaskType.reachPos.getValue()) {
            return true;
        }
        if (this.prop.getType() == Const.TaskType.TRAIN_EQUIP.getValue() && this.prop.isTarget("0")) {
            return true;
        }
        return false;
    }

    public final boolean isTargetFromID(String id) {
        return this.prop.isTargetFormId(id);
    }

    public final String questTc() {
        return this.prop.questTC;
    }


    public final boolean submit() {
        if (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
            this.db.state = Const.TaskState.COMPLETED.getValue();
            return true;
        }
        return false;
    }


    public final boolean isCompleted() {
        return (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue());
    }


    public final void complete() {
        if (this.db.state == Const.TaskState.NOT_COMPLETED.getValue()) {
            this.db.progress = getTargetNum();
            this.db.state = Const.TaskState.COMPLETED_NOT_DELIVERY.getValue();
        }
    }


    public final boolean isDaily() {
        return (2 == getKind());
    }


    public final boolean isLoop() {
        return (3 == getKind());
    }


    public final boolean isTreasure() {
        return (8 == getKind());
    }


    public final boolean autoAccept() {
        if (this.prop.giveNpc == 0) {
            return true;
        }
        return false;
    }


    public final int getState() {
        return this.db.state;
    }

    public final void pushProgressTips(WNPlayer player) {
        if (this.db.progress > 0) {
            String tips = this.prop.changePrompt;
            if (tips.length() > 0) {
                String replaceStr = "(" + this.db.progress + "/" + getTargetNum() + ")";
                tips = tips.replace("{0}", replaceStr);
                player.sendSysTip(tips, Const.TipsType.NO_BG);
            }
        }
    }

    public final boolean onEvent(WNPlayer player, TaskEvent event) {
        boolean flag = false;
        if (this.db.state != Const.TaskState.NOT_COMPLETED.getValue()) {
            return flag;
        }
        int name = event.type;
        if (name == getType()) {
            int targetNum = getTargetNum();
            if (isTargetID(event)) {
                Out.debug(new Object[]{"enter  task onEvent"});
                if (name == Const.TaskType.LEVEL_UP.getValue() || name == Const.TaskType.USERUP_LEVEL.getValue() || name == Const.TaskType.TRAIN_EQUIP.getValue() || name == Const.TaskType.MOUNT_UPLEVEL.getValue() || name == Const.TaskType.WING_UPLEVEL.getValue() || name == Const.TaskType.TRAIN_EQUIP_ALL.getValue()) {
                    this.db.progress = Math.max(((Integer) event.params[1]).intValue(), this.db.progress);
                } else {
                    this.db.progress += ((Integer) event.params[1]).intValue();
                }

                if (this.db.progress >= targetNum) {
                    this.db.progress = targetNum;
                    complete();
                    if (getKind() == 2) {
                        player.getPlayerTasks().dailyTaskFinEvent();
                    } else if (getKind() == 3) {
                        player.getPlayerTasks().loopTaskFinEvent();
                    }


                    BILogService.getInstance().ansycReportMission(player.getPlayer(), "任务完成", this.prop.kind, this.prop.iD, this.prop.name);
                }
                pushProgressTips(player);
                flag = true;
            }
        }

        return flag;
    }

    public int getProgress() {
        return this.db.progress;
    }


    public final boolean setProgress(int prgs) {
        this.db.progress = prgs;
        if (this.db.progress >= getTargetNum()) {
            complete();
        }
        return (this.db.progress >= getTargetNum());
    }

    public int getSecProgress() {
        return this.secProgress;
    }

    public void setSecProgress(int secProgress) {
        this.secProgress = secProgress;
    }

    public final List<StringString> initBattleServerAttribute() {
        List<StringString> attr = new ArrayList<>();
        attr.add(new StringString("type", String.valueOf(getType())));
        attr.add(new StringString("areaId", String.valueOf(this.prop.doScene)));
        attr.add(new StringString("pointId", String.valueOf(this.prop.doPoint)));
        attr.add(new StringString("targetId", String.valueOf(this.prop.targetID)));


        if (this.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
            attr.add(new StringString("state", "1"));
        } else {
            attr.add(new StringString("state", "0"));
        }


        Map<String, String> saved_attrs = _getBattlerAttribute();
        for (Map.Entry<String, String> node : saved_attrs.entrySet()) {
            attr.add(new StringString(node.getKey(), node.getValue()));
        }
        return attr;
    }

    public final void setBattleAttribute(String key, String value) {
        Map<String, String> saved_attrs = _getBattlerAttribute();
        if (value != null) {
            saved_attrs.put(key, value);
        } else {
            saved_attrs.remove(key);
        }
    }


    public final JSONObject toJson4BattleServer() {
        JSONObject data = new JSONObject();
        data.put("QuestID", Integer.valueOf(this.db.templateId));
        data.put("State", Integer.valueOf(1));
        data.put("Attributes", initBattleServerAttribute());
        return data;
    }


    public TaskPO toJson4Serialize() {
        return this.db;
    }

    public final TaskOuterClass.Task buildTask() {
        TaskOuterClass.Task.Builder builder = TaskOuterClass.Task.newBuilder();
        builder.setTemplateId(this.db.templateId);
        builder.setState(this.db.state);
        if (this.secProgress > -1) {
            builder.addProgress(this.secProgress);
        }
        builder.addProgress(this.db.progress);
        builder.setLeftTime(this.prop.limitTime);
        return builder.build();
    }

    public final TaskData clone() {
        TaskData task = new TaskData(this.prop);
        task.db.state = this.db.state;
        task.db.progress = this.db.progress;
        task.db.finishCount = this.db.finishCount;
        return task;
    }
}


