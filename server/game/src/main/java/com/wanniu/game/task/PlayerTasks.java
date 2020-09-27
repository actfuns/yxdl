package com.wanniu.game.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.common.StringString;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.data.BranchLineCO;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.CharacterLevelCO;
import com.wanniu.game.data.CircleRewardCO;
import com.wanniu.game.data.DailyReduceCO;
import com.wanniu.game.data.DailyRewardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TaskChestCO;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.equip.EquipManager;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.data.ItemToBtlServerData;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.po.MiscData;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.TaskListPO;
import com.wanniu.game.request.task.AcceptTaskHandler;
import com.wanniu.game.task.po.TaskPO;
import com.wanniu.game.team.TeamData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.TaskHandler;
import pomelo.task.TaskOuterClass;


public class PlayerTasks {
    private WNPlayer player;
    public TaskListPO taskListPO;
    public LoopResult loopResult;
    private int playerPro;
    public Map<Integer, TaskPO> normalTasks;
    public Map<Integer, Integer> finishedNormalTasks;
    public Map<Integer, TaskPO> dailyTasks;
    public Map<Integer, Integer> finishedDailyTasks;
    public Map<Integer, TaskPO> treasureTasks;
    public Map<Integer, Integer> finishedTreasureTasks;
    private Map<Integer, List<TaskData>> eventWatchers;

    public static class NotifyToBattleServerParam {
        public String playerUUID;
        public String questID;
        public boolean initStatus;
        public List<StringString> status;
    }

    public static class DropItemServerData {
        public Const.Position pos;
        public List<ItemToBtlServerData> items;
    }

    public PlayerTasks(WNPlayer player, TaskListPO tasks) {
        this.player = player;
        this.playerPro = player.getPro();
        this.taskListPO = tasks;
        init(tasks);
    }


    private final void init(TaskListPO data) {
        this.normalTasks = data.normalTasks;

        this.finishedNormalTasks = data.finishedNormalTasks;

        if (GWorld.DEBUG) {
            if (data.treasureTasks == null) {
                data.treasureTasks = new HashMap<>();
            }
            if (data.finishedTreasureTasks == null) {
                data.finishedTreasureTasks = new HashMap<>();
            }
            if (data.loopResult == null) {
                data.loopResult = new LoopResult();
            }
        }

        this.dailyTasks = data.dailyTasks;
        this.finishedDailyTasks = data.finishedDailyTasks;

        this.treasureTasks = data.treasureTasks;
        this.finishedTreasureTasks = data.finishedTreasureTasks;

        this.loopResult = data.loopResult;

        refreshWatchEvents();
    }


    public final void refreshNewDay() {
        MiscData miscData = this.player.playerAttachPO.miscData;
        if (miscData != null) {
            miscData.guildBlessToday = 0;
            miscData.guildSkillUpToday = 0;
            miscData.guildDonateToday = 0;
        }

        this.finishedDailyTasks = new HashMap<>();

        if (this.taskListPO != null) {
            this.taskListPO.todayLoopTaskCount = 0;
            this.taskListPO.todayDailyTaskCount = 0;
        }


        for (TaskBase prop : GameData.BranchLines.values()) {
            if (this.player.getLevel() < prop.level) {
                continue;
            }
            if (this.normalTasks.containsKey(Integer.valueOf(prop.iD))) {

                if (prop.type == Const.TaskType.ACTIVITY_NUM.getValue() || prop.type == Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() || prop.type == Const.TaskType.KILL_BOSS_COUNT.getValue()) {
                    TaskData task = new TaskData(this.normalTasks.get(Integer.valueOf(prop.iD)));
                    task.setProgress(0);
                    pushTaskUpdate(task);
                }
                continue;
            }
            if (prop.type == Const.TaskType.ACTIVITY_NUM.getValue() || prop.type == Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() || prop.type == Const.TaskType.KILL_BOSS_COUNT.getValue()) {
                AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
                if (result.task != null) {
                    result.task.setSecProgress(getSecProgress(result.task.getKind()));
                    pushTaskUpdate(result.task);
                }
                continue;
            }
            if (prop.type == Const.TaskType.ACCEPT_DAILY_LOOP.getValue() && StringUtil.isNotEmpty(prop.targetID)) {
                int targetId = Integer.parseInt(prop.targetID);
                if (targetId == 2 && this.dailyTasks.size() == 0) {
                    AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
                    if (result.task != null) {
                        result.task.setSecProgress(getSecProgress(result.task.getKind()));
                        pushTaskUpdate(result.task);
                    }
                    continue;
                }
                if (targetId == 3) {
                    TeamData team = this.player.getTeamManager().getTeam();
                    if (team == null || (team != null && (team.loopTasks == null || team.loopTasks.size() == 0))) {
                        AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.iD, 1);
                        if (result.task != null) {
                            result.task.setSecProgress(getSecProgress(result.task.getKind()));
                            pushTaskUpdate(result.task);
                        }
                    }
                }
            }
        }


        refreshWatchEvents();
    }

    public final void refreshWatchEvents() {
        this.eventWatchers = new ConcurrentHashMap<>();

        for (TaskPO db : this.normalTasks.values()) {
            TaskData task = new TaskData(db);
            int type = task.getType();
            List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
            if (tasks == null) {
                tasks = new ArrayList<>();
                this.eventWatchers.put(Integer.valueOf(type), tasks);
            }
            tasks.add(task);
        }

        for (TaskPO db : this.dailyTasks.values()) {
            TaskData task = new TaskData(db);
            int type = task.getType();
            List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
            if (tasks == null) {
                tasks = new ArrayList<>();
                this.eventWatchers.put(Integer.valueOf(type), tasks);
            }
            tasks.add(task);
        }


        for (TaskPO db : this.treasureTasks.values()) {
            TaskData task = new TaskData(db);
            int type = task.getType();
            List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(type));
            if (tasks == null) {
                tasks = new ArrayList<>();
                this.eventWatchers.put(Integer.valueOf(type), tasks);
            }
            tasks.add(task);
        }
    }


    public final JSONArray toJson4BattleServer() {
        JSONArray data = new JSONArray();
        for (Map.Entry<Integer, TaskPO> node : this.normalTasks.entrySet()) {
            TaskData task = new TaskData(node.getValue());
            if (task.getState() > Const.TaskState.NOT_START.getValue()) {
                data.add(task.toJson4BattleServer());
            }
        }
        for (Map.Entry<Integer, TaskPO> node : this.dailyTasks.entrySet()) {
            TaskData task = new TaskData(node.getValue());
            if (task.getState() > Const.TaskState.NOT_START.getValue()) {
                data.add(task.toJson4BattleServer());
            }
        }

        Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
        if (loopTasks != null) {
            for (Map.Entry<Integer, TaskPO> node : loopTasks.entrySet()) {
                TaskData task = new TaskData(node.getValue());
                if (task.getState() > Const.TaskState.NOT_START.getValue()) {
                    data.add(task.toJson4BattleServer());
                }
            }
        }

        for (Map.Entry<Integer, TaskPO> node : this.treasureTasks.entrySet()) {
            TaskData task = new TaskData(node.getValue());
            if (task.getState() > Const.TaskState.NOT_START.getValue()) {
                data.add(task.toJson4BattleServer());
            }
        }
        return data;
    }


    public final void dealTaskEvent(Const.TaskType type, int num) {
        onEvent(new TaskEvent(type, new Object[]{null, Integer.valueOf(num)}));
    }

    public final void dealTaskEvent(Const.TaskType type, String target, int num) {
        onEvent(new TaskEvent(type, new Object[]{target, Integer.valueOf(num)}));
    }

    public final TaskData getTask(int templateId, int kind) {
        if (kind == 0 || kind == 1) {
            if (this.normalTasks.containsKey(Integer.valueOf(templateId))) {
                return new TaskData(this.normalTasks.get(Integer.valueOf(templateId)));
            }
        } else if (kind == 2) {
            if (this.dailyTasks.containsKey(Integer.valueOf(templateId))) {
                return new TaskData(this.dailyTasks.get(Integer.valueOf(templateId)));
            }
        } else if (kind == 3) {

            TeamData team = this.player.getTeamManager().getTeam();
            if (team != null && team.loopTasks != null && team.loopTasks.containsKey(Integer.valueOf(templateId))) {
                return new TaskData((TaskPO) team.loopTasks.get(Integer.valueOf(templateId)));
            }
        } else if (kind == 8) {
            if (this.treasureTasks.containsKey(Integer.valueOf(templateId))) {
                return new TaskData(this.treasureTasks.get(Integer.valueOf(templateId)));
            }
        } else {
            Out.error(new Object[]{"getTask is null:templateId=", Integer.valueOf(templateId), ",kind=", Integer.valueOf(kind)});
        }
        return null;
    }

    public final TaskData getTaskByID(int templateId) {
        TaskPO task = this.normalTasks.get(Integer.valueOf(templateId));
        if (task == null) {
            task = this.dailyTasks.get(Integer.valueOf(templateId));
        }
        if (task == null) {
            TeamData team = this.player.getTeamManager().getTeam();
            if (team != null && team.loopTasks != null) {
                task = (TaskPO) team.loopTasks.get(Integer.valueOf(templateId));
            }
        }
        if (task == null) {
            task = this.treasureTasks.get(Integer.valueOf(templateId));
        }
        if (task != null) {
            return new TaskData(task);
        }
        return null;
    }

    public final boolean isTaskDoingOrFinish(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null &&
                task.getState() >= Const.TaskState.NOT_COMPLETED.getValue()) {
            return true;
        }

        if (isFinish(templateId, 0)) {
            return true;
        }
        return false;
    }

    public final boolean isTaskDoing(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null &&
                task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
            return true;
        }

        return false;
    }


    public final TaskData doingTaskHaveType(int taskType) {
        Out.debug(new Object[]{"doingTaskHaveType:", Integer.valueOf(taskType)});
        List<TaskData> all = this.eventWatchers.get(Integer.valueOf(taskType));
        if (all != null && all.size() > 0)
            for (TaskData task : all) {
                if (task != null && task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
                    return task;
                }
            }
        return null;
    }

    public final boolean hasMainLineTask() {
        for (Map.Entry<Integer, TaskPO> node : this.normalTasks.entrySet()) {
            TaskData task = new TaskData(node.getValue());
            if (task != null && task.getKind() == 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean isDailyFinish(int templateId) {
        return this.finishedDailyTasks.containsKey(Integer.valueOf(templateId));
    }

    private final boolean isTreasureFinish(int templateId) {
        return this.finishedTreasureTasks.containsKey(Integer.valueOf(templateId));
    }

    private final boolean isLoopFinish(int templateId) {
        TeamData team = this.player.getTeamManager().getTeam();
        if (team != null && team.finishedLoopTasks != null) {
            return team.finishedLoopTasks.containsKey(Integer.valueOf(templateId));
        }
        return false;
    }

    private final boolean isNormalFinish(int templateId) {
        return this.finishedNormalTasks.containsKey(Integer.valueOf(templateId));
    }

    private final boolean isFinish(int templateId, int kind) {
        switch (kind) {
            case 2:
                return isDailyFinish(templateId);
            case 3:
                return isLoopFinish(templateId);
            case 8:
                return isTreasureFinish(templateId);
        }
        return isNormalFinish(templateId);
    }


    public final boolean isFinishTask(int templateId) {
        return (isDailyFinish(templateId) || isNormalFinish(templateId) || isTreasureFinish(templateId));
    }


    private final String _canAcceptTaskByProp(TaskBase prop) {
        if (prop == null) {
            return LangService.getValue("TASK_TEMPLATE_NOT_EXIST");
        }
        int templateId = prop.getId();
        int kind = prop.getKind();


        if (TaskUtils.checkOpenWay(prop.openWay, prop.openDay) &&
                !TaskUtils.checkTaskValidTime(prop.openTime, prop.endTime)) {
            return LangService.getValue("TASK_TIME_IS_NOT_OPEN");
        }


        if (StringUtil.isNotEmpty(prop.job) &&
                prop.pro != this.player.getPro()) {
            return LangService.getValue("TASK_JOB_ERROR");
        }


        if ((kind == 0 || kind == 1) &&
                isFinish(templateId, prop.getKind())) {
            return LangService.getValue("TASK_IS_ACCPETED");
        }


        TaskData task = getTask(templateId, kind);
        if (task != null && task.getState() != Const.TaskState.NOT_START.getValue()) {
            Out.debug(new Object[]{"task not has get "});

            return LangService.getValue("TASK_IS_ACCPETED");
        }

        if (prop.kind != 3) {

            if ((this.player.getPlayer()).upLevel < prop.upOrder)
                return LangService.getValue("TASK_UPLEVEL_ERROR");
            if ((this.player.getPlayer()).level < prop.level) {
                return LangService.format("TASK_LEVEL_ERROR", new Object[]{Integer.valueOf(prop.level)});
            }


            if ((this.player.getPlayer()).upLevel > prop.upLimit)
                return LangService.getValue("TASK_UPLEVEL_ERROR");
            if (prop.levelLimit > 0 && (this.player.getPlayer()).upLevel == prop.upLimit && (this.player.getPlayer()).level > prop.levelLimit) {
                return LangService.getValue("TASK_UPLEVEL_ERROR");
            }
        }

        if (prop.kind != 2 && prop.type != Const.TaskType.ACCEPT_DAILY_LOOP.getValue() && prop.type != Const.TaskType.ACTIVITY_NUM.getValue() && prop.type != Const.TaskType.FINISH_DUNGEONS_COUNT.getValue() && prop.type != Const.TaskType.KILL_BOSS_COUNT.getValue()) {
            if (prop.beforeRelations > 0) {

                for (int j = 0; j < prop.beforeTask.length; j++) {
                    int beforeTask = Integer.parseInt(prop.beforeTask[j]);
                    if (beforeTask != 0 &&
                            isFinish(beforeTask, prop.getKind())) {
                        return null;
                    }
                }

                return LangService.getValue("TASK_BEFORE_ERROR");
            }

            for (int i = 0; i < prop.beforeTask.length; i++) {
                int beforeTask = Integer.parseInt(prop.beforeTask[i]);
                if (beforeTask != 0 &&
                        !isFinish(beforeTask, prop.getKind())) {
                    Out.debug(new Object[]{"beforeTask not finished beforeTask:" + beforeTask});
                    return LangService.getValue("TASK_BEFORE_ERROR");
                }
            }

            return null;
        }

        return null;
    }

    private final boolean _isDiscardItemTask(TaskData task) {
        if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
            task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
            String itemId = task.prop.targets.get(0);
            if (itemId.length() > 0 &&
                    this.player.getWnBag().findItemNumByCode(itemId) >= task.getTargetNum()) {
                dealTaskEvent(Const.TaskType.DISCARD_ITEM, itemId, task.getTargetNum());
                task.setSecProgress(getSecProgress(task.getKind()));
                pushTaskUpdate(task);
            }

        } else if (task.getTargetNum() != 0) {
            task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
        }

        return true;
    }


    private final boolean _discardItem(TaskData task) {
        if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
            String itemId = task.prop.targets.get(0);
            if (itemId.length() > 0) {
                Out.debug(new Object[]{"accept code:", itemId});
                boolean flag = this.player.getWnBag().discardItem(itemId, task.getTargetNum(), Const.GOODS_CHANGE_TYPE.task_submit, null, false, false);

                task.db.state = Const.TaskState.COMPLETED_NOT_DELIVERY.getValue();
                return flag;
            }
        }
        return true;
    }

    public final void gmNewTask(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null) {
            task.db.state = Const.TaskState.NOT_START.getValue();
        } else {
            TaskBase prop = TaskUtils.getTaskProp(templateId);
            task = TaskUtils.createTask(prop);
            _addTask(task);
        }
        task.setSecProgress(getSecProgress(task.getKind()));
        pushTaskUpdate(task);
    }

    public final void gmfinishTaskTarget(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null) {
            complete(task);
        }
    }

    public final void gmDiscardTaskByID(int templateId) {
        if (templateId == 0) {
            Out.debug(new Object[]{"------------------deleteTask------all------------"});
            Map<Integer, TaskPO> all = new HashMap<>();
            all.putAll(this.normalTasks);
            all.putAll(this.dailyTasks);
            TeamData team = this.player.getTeamManager().getTeam();
            if (team != null && team.loopTasks != null) {
                all.putAll(team.loopTasks);
            }
            all.putAll(this.treasureTasks);
            for (Map.Entry<Integer, TaskPO> node : all.entrySet()) {
                TaskData task = new TaskData(node.getValue());
                task.db.state = Const.TaskState.DELETE.getValue();
                _deleteTask(task.db.templateId, task.prop.getKind(), true);
                task.setSecProgress(getSecProgress(task.getKind()));
                pushTaskUpdate(task);
            }
        } else {
            TaskData task = getTaskByID(templateId);
            if (task != null) {
                Out.debug(new Object[]{"------------------deleteTask------------------", Integer.valueOf(templateId)});
                task.db.state = Const.TaskState.DELETE.getValue();
                _deleteTask(task.db.templateId, task.prop.getKind(), true);
                task.setSecProgress(getSecProgress(task.getKind()));
                pushTaskUpdate(task);
            }
        }
    }

    public final void gmAcceptTask(int templateId) {
        TaskBase prop = TaskUtils.getTaskProp(templateId);
        TaskData task = TaskUtils.createTask(prop, Const.TaskState.NOT_COMPLETED);
        _isDiscardItemTask(task);
        _addTask(task);


        List<TaskBase.ItemNode> rewards = task.prop.accepTaskRewards;
        Out.debug(new Object[]{"AccepTaskReward", rewards});
        List<WNBag.SimpleItemInfo> items = new ArrayList<>();
        for (TaskBase.ItemNode node : rewards) {
            WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
            map.itemCode = node.itemCode;
            map.itemNum = node.itemNum;
            map.forceType = Const.ForceType.BIND;

            items.add(map);
        }
        if (!this.player.getWnBag().testAddCodeItems(items, Const.ForceType.BIND, false)) {
            return;
        }

        Out.debug(new Object[]{"AccepTask reward ", rewards});
        this.player.getWnBag().addCodeItems(items, Const.GOODS_CHANGE_TYPE.task, null, false, false);


        this.player.functionOpenManager.onAcceptTask(String.valueOf(templateId));


        List<StringString> attr = task.initBattleServerAttribute();
        NotifyToBattleServerParam param1 = new NotifyToBattleServerParam();
        param1.playerUUID = this.player.getId();
        param1.questID = String.valueOf(templateId);
        param1.initStatus = true;
        param1.status = attr;
        notifyToBattleServer("QuestStatusChangedR2B", param1);

        _checkProCondition(task);
        task.setSecProgress(getSecProgress(task.getKind()));
        pushTaskUpdate(task);
    }


    public final AcceptTaskHandler.AcceptTaskResult acceptTask(int templateId, int kind) {
        Out.debug(new Object[]{"acceptTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind)});
        AcceptTaskHandler.AcceptTaskResult result = new AcceptTaskHandler.AcceptTaskResult();
        TaskBase prop = TaskUtils.getTaskProp(templateId);
        String canAcceptRes = _canAcceptTaskByProp(prop);
        if (canAcceptRes != null) {
            result.msg = canAcceptRes;
            return result;
        }
        result.task = getTask(templateId, kind);
        if (result.task == null) {
            result.task = TaskUtils.createTask(prop);
            if (result.task.getTargetNum() == 0) {
                result.task.db.state = Const.TaskState.NOT_COMPLETED.getValue();
            }
            _addTask(result.task);
        }

        if (!_isDiscardItemTask(result.task)) {
            result.msg = LangService.getValue("TASK_BEFORE_ERROR");
            return result;
        }


        if (StringUtil.isNotEmpty(result.task.prop.modID)) {
            String[] data = result.task.prop.modID.split(":");
            this.player.playerBasePO.model = data[0];
            this.player.playerBasePO.speed = Float.parseFloat(data[1]);
            this.player.refreshBattlerServerAvatar();
            this.player.refreshBattlerServerEffect(false);
        }

        _checkProCondition(result.task);


        List<TaskBase.ItemNode> rewards = result.task.prop.accepTaskRewards;
        if (rewards != null) {
            WNBag bag = this.player.getWnBag();
            List<WNBag.SimpleItemInfo> rItems = new ArrayList<>(rewards.size());
            for (TaskBase.ItemNode node : rewards) {
                WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
                map.itemCode = node.itemCode;
                map.itemNum = node.itemNum;
                map.forceType = Const.ForceType.BIND;
                rItems.add(map);
            }
            if (!bag.testAddCodeItems(rItems, Const.ForceType.BIND, false)) {
                return result;
            }
            List<NormalItem> finalRewards = new ArrayList<>();
            for (int i = 0; i < rewards.size(); i++) {
                TaskBase.ItemNode node = rewards.get(i);
                List<NormalItem> items = ItemUtil.createItemsByItemCode(node.itemCode, node.itemNum);
                for (NormalItem item : items) {
                    item.setBind(1);
                    finalRewards.add(item);
                }
            }
            bag.addEntityItems(finalRewards, Const.GOODS_CHANGE_TYPE.task);
        }


        this.player.functionOpenManager.onAcceptTask(String.valueOf(templateId));


        if (kind == 2 || kind == 3) {
            this.player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(kind), 1);
        }

        TeamData team = this.player.getTeamManager().getTeam();
        if (team != null && team.leaderId.equals(this.player.getId()) && kind == 3) {
            for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                WNPlayer mPlayer = member.getPlayer();
                if (mPlayer == null) {
                    continue;
                }
                questStatusChangeR2B(mPlayer, result.task, templateId);
            }
        } else {
            questStatusChangeR2B(this.player, result.task, templateId);
        }


        BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务接取", kind, prop.iD, prop.name);
        return result;
    }


    public void questStatusChangeR2B(WNPlayer player, TaskData task, int templateId) {
        List<StringString> attr = task.initBattleServerAttribute();
        NotifyToBattleServerParam param1 = new NotifyToBattleServerParam();
        param1.playerUUID = player.getId();
        param1.questID = String.valueOf(templateId);
        param1.initStatus = true;
        param1.status = attr;
        player.taskManager.notifyToBattleServer("QuestStatusChangedR2B", param1);
    }

    private final void _checkProCondition(TaskData task) {
        if (task.prop.getType() == Const.TaskType.LEVEL_UP.getValue()) {

            dealTaskEvent(Const.TaskType.LEVEL_UP, (this.player.getPlayer()).level);
        } else if (task.prop.getType() == Const.TaskType.USERUP_LEVEL.getValue()) {

            dealTaskEvent(Const.TaskType.USERUP_LEVEL, (this.player.getPlayer()).upLevel);
        } else if (task.prop.getType() == Const.TaskType.TRAIN_EQUIP.getValue()) {

            EquipManager.EquipAndLevelData equips = this.player.equipManager.getAllEquipAndLevel();
            Out.debug(new Object[]{"_checkProCondition:", equips});


            if (task.prop.targetID.equals("0")) {
                dealTaskEvent(Const.TaskType.TRAIN_EQUIP, task.prop.targetID, equips.maxLevel);
            } else {
                for (Iterator<Integer> iterator = equips.equips.keySet().iterator(); iterator.hasNext(); ) {
                    int pos = ((Integer) iterator.next()).intValue();
                    if (!String.valueOf(pos).equals(task.prop.targetID)) {
                        continue;
                    }
                    PlayerBasePO.EquipStrengthPos equip = (PlayerBasePO.EquipStrengthPos) equips.equips.get(Integer.valueOf(pos));
                    int equipLevel = equip.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + equip.enLevel;
                    if (equipLevel > 0) {
                        dealTaskEvent(Const.TaskType.TRAIN_EQUIP, String.valueOf(pos), equipLevel);
                    }
                }


            }
        } else if (task.prop.getType() == Const.TaskType.TRAIN_EQUIP_ALL.getValue()) {
            TaskUtils.dealTrainEquipAllTask(this.player);
        } else if (task.prop.getType() == Const.TaskType.FILL_GEM.getValue()) {

            for (PlayerBasePO.EquipStrengthPos posInfo : this.player.equipManager.strengthPos.values()) {
                for (String code : posInfo.gems.values()) {
                    if (StringUtil.isEmpty(code))
                        continue;
                    DItemBase prop = ItemUtil.getUnEquipPropByCode(code);
                    dealTaskEvent(Const.TaskType.FILL_GEM, String.valueOf(prop.levelReq), 1);
                }
            }
        } else if (task.prop.getType() == Const.TaskType.FRIEND_NUM.getValue()) {

            int frinedNum = this.player.getFriendManager().getFriendsNum();
            if (frinedNum > 0) {
                dealTaskEvent(Const.TaskType.FRIEND_NUM, frinedNum);
            }
        } else if (task.prop.getType() == Const.TaskType.JOIN_LEAGUE.getValue()) {

            if (DaoYouService.getInstance().getDaoYou(this.player.getId()) != null) {
                dealTaskEvent(Const.TaskType.JOIN_LEAGUE, 1);
            }
        } else if (task.prop.getType() == Const.TaskType.EARN_NECK.getValue()) {

            if (this.player.playerAttachPO.miscData.hasGetNeck > 0) {
                dealTaskEvent(Const.TaskType.EARN_NECK, 1);
            }
        } else if (task.prop.getType() == Const.TaskType.ADD_GUILD.getValue()) {

            if (this.player.guildManager.isInGuild()) {
                dealTaskEvent(Const.TaskType.ADD_GUILD, 1);
            }
        } else if (task.prop.getType() == Const.TaskType.JOIN_SOLO.getValue()) {

            if (this.player.soloManager.soloData.havePlayed) {
                dealTaskEvent(Const.TaskType.JOIN_SOLO, 1);
            }
        } else if (task.prop.getType() == Const.TaskType.GUILD_PRAY.getValue()) {

            if (this.player.playerAttachPO.miscData.guildBlessToday > 0) {
                dealTaskEvent(Const.TaskType.GUILD_PRAY, this.player.playerAttachPO.miscData.guildBlessToday);
            }
        } else if (task.prop.getType() == Const.TaskType.GUILD_DONATE.getValue()) {

            if (this.player.playerAttachPO.miscData.guildDonateToday > 0) {
                dealTaskEvent(Const.TaskType.GUILD_DONATE, this.player.playerAttachPO.miscData.guildDonateToday);
            }
        } else if (task.prop.getType() == Const.TaskType.GUILD_TECH_UP.getValue()) {

            if (this.player.playerAttachPO.miscData.guildSkillUpToday > 0) {
                dealTaskEvent(Const.TaskType.GUILD_TECH_UP, this.player.playerAttachPO.miscData.guildSkillUpToday);
            }
        } else if (task.prop.getType() == Const.TaskType.TAKE_EQUIP_Qt.getValue()) {

            Map<Integer, NormalEquip> equips = this.player.equipManager.equips;
            for (Map.Entry<Integer, NormalEquip> node : equips.entrySet()) {
                NormalEquip equip = node.getValue();
                String[] conditionArr = ((String) task.prop.targets.get(0)).split("\\|");
                if (conditionArr.length > 1 &&
                        equip.getQLevel() >= Integer.parseInt(conditionArr[0]) && equip.getQColor() >= Integer.parseInt(conditionArr[1])) {
                    String tarSz = equip.getQLevel() + "|" + equip.getQColor() + "|" + equip.getPosition();
                    dealTaskEvent(Const.TaskType.TAKE_EQUIP_Qt, tarSz, 1);
                }

            }
        } else if (task.prop.getType() == Const.TaskType.MOUNT_UPLEVEL.getValue()) {

            if (this.player.mountManager != null && this.player.mountManager.mount != null) {
                int mountLevel = this.player.mountManager.mount.rideLevel * 11 + this.player.mountManager.mount.starLv;
                if (mountLevel > 0) {
                    dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, mountLevel);
                }
            }
        } else if (task.prop.getType() != Const.TaskType.TRAIN_RIDE.getValue()) {


            if (task.prop.getType() != Const.TaskType.PET_TRAIN.getValue()) {


                if (task.prop.getType() == Const.TaskType.ACCEPT_DAILY_LOOP.getValue()) {

                    int kind = task.prop.getKind();
                    boolean completed = false;
                    if (kind == 2) {
                        if (this.dailyTasks.size() > 0 || this.taskListPO.todayDailyTaskCount > 0) {
                            completed = true;
                        }
                    } else if (kind == 3) {
                        TeamData team = this.player.teamManager.getTeam();
                        if (team != null && team.loopTasks != null && team.loopTasks.size() > 0) {
                            completed = true;
                        } else if (this.taskListPO.todayLoopTaskCount > 0) {
                            completed = true;
                        }
                    }
                    if (completed) {
                        this.player.taskManager.dealTaskEvent(Const.TaskType.ACCEPT_DAILY_LOOP, String.valueOf(kind), 1);
                    }
                } else if (task.prop.getType() == Const.TaskType.ROLE_UPGRADE.getValue() &&
                        this.player.player.upLevel > 0) {
                    dealTaskEvent(Const.TaskType.ROLE_UPGRADE, this.player.player.upLevel);
                }
            }
        }
    }


    public final boolean discardTask(int templateId, int kind) {
        Out.debug(new Object[]{"discardTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind)});
        TaskData task = getTask(templateId, kind);
        if (task != null) {


            Out.debug(new Object[]{"------------------deleteTask------------------", Integer.valueOf(templateId)});
            task.db.state = Const.TaskState.DELETE.getValue();
            task.setSecProgress(getSecProgress(task.getKind()));
            _deleteTask(templateId, kind, true);


            TeamData team = this.player.getTeamManager().getTeam();
            if (kind == 3 && team != null) {
                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer != null) {
                        mPlayer.taskManager.pushTaskUpdate(task);
                    }
                }
            } else {
                pushTaskUpdate(task);
            }


            return true;
        }
        return false;
    }

    public final boolean discardTaskByID(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null && task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
            Out.debug(new Object[]{"------------------deleteTask------------------", Integer.valueOf(templateId)});
            task.db.state = Const.TaskState.DELETE.getValue();
            task.setSecProgress(getSecProgress(task.getKind()));
            _deleteTask(templateId, task.getKind(), true);
            pushTaskUpdate(task);
            return true;
        }
        return false;
    }

    public final boolean complete(TaskData task) {
        if (task.getState() == Const.TaskState.NOT_COMPLETED.getValue()) {
            task.complete();

            BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务完成", task.getKind(), task.prop.iD, task.prop.name);


            NotifyToBattleServerParam param = new NotifyToBattleServerParam();
            param.playerUUID = this.player.getId();
            param.questID = String.valueOf(task.db.templateId);
            param.initStatus = false;
            param.status = new ArrayList<>();
            param.status.add(new StringString("state", String.valueOf(task.db.templateId)));
            notifyToBattleServer("QuestStatusChangedR2B", param);

            task.setSecProgress(getSecProgress(task.getKind()));
            pushTaskUpdate(task);
            if (task.getKind() == 2) {
                dailyTaskFinEvent();
            } else if (task.getKind() == 3) {
                loopTaskFinEvent();
            }
            return true;
        }
        return false;
    }


    public final boolean completeTask(int templateId, int kind) {
        TaskData task = getTask(templateId, kind);
        if (task != null) {
            return complete(task);
        }
        return false;
    }

    public final void dailyTaskFinEvent() {
        dealTaskEvent(Const.TaskType.FINISH_DAILY_TASK, 1);
        Out.info(new Object[]{this.player.getId(), ":完成了一次师门任务进度。"});

        this.player.dailyActivityMgr.onEvent(Const.DailyType.DAILY_TASK, "0", 1);
    }

    public final void loopTaskFinEvent() {
        TeamData team = this.player.teamManager.getTeam();
        if (team == null) {
            return;
        }
        for (TeamData.TeamMemberData member : team.teamMembers.values()) {
            WNPlayer player = member.getPlayer();
            if (player == null) {
                continue;
            }

            player.taskManager.dealTaskEvent(Const.TaskType.FINISH_LOOP_TASK, 1);

            player.dailyActivityMgr.onEvent(Const.DailyType.LOOP_TASK, "0", 1);
        }
    }

    public final boolean completeTaskByID(int templateId) {
        TaskData task = getTaskByID(templateId);
        if (task != null) {
            return complete(task);
        }
        return false;
    }

    public final boolean isCompleteTaskByID(int templateId) {
        if (isFinishTask(templateId)) {
            return true;
        }
        TaskData task = getTaskByID(templateId);
        if (task != null) {
            return task.isCompleted();
        }
        return false;
    }


    public final boolean gmFinishTask(int templateId) {
        if (templateId == 0) {
            for (TaskPO taskPO : this.normalTasks.values()) {
                TaskBase prop = TaskUtils.getTaskProp(taskPO.templateId);
                if (prop.getKind() == 0) {
                    templateId = taskPO.templateId;
                    break;
                }
            }
        } else if (templateId == 1) {
            for (TaskPO taskPO : this.normalTasks.values()) {
                TaskBase prop = TaskUtils.getTaskProp(taskPO.templateId);
                if (prop.getKind() == 1) {
                    templateId = taskPO.templateId;
                    break;
                }
            }
        } else if (templateId == 2) {
            Iterator<TaskPO> iterator = this.dailyTasks.values().iterator();
            if (iterator.hasNext()) {
                TaskPO taskPO = iterator.next();
                templateId = taskPO.templateId;
            }


        } else if (templateId == 8) {
            Iterator<TaskPO> iterator = this.treasureTasks.values().iterator();
            if (iterator.hasNext()) {
                TaskPO taskPO = iterator.next();
                templateId = taskPO.templateId;
            }


        } else if (templateId == 3) {
            TeamData team = this.player.teamManager.getTeam();
            if (team != null) {
                Iterator<TaskPO> iterator = team.loopTasks.values().iterator();
                if (iterator.hasNext()) {
                    TaskPO taskPO = iterator.next();
                    templateId = taskPO.templateId;
                }

            }
        }


        TaskData task = getTaskByID(templateId);
        if (task != null) {
            int kind = task.getKind();
            if (task.getState() >= Const.TaskState.NOT_START.getValue() && task.getState() <= Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {

                if (task.prop.overState2 == 1) {
                    this.player.playerBasePO.model = null;
                    this.player.playerBasePO.speed = 0.0F;
                    this.player.refreshBattlerServerAvatar();
                    this.player.refreshBattlerServerEffect(false);
                }

                List<TaskBase.ItemNode> rewards = TaskUtils.getReward(task.prop, this.playerPro);
                List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(task.prop.tcReward);
                for (NormalItem v : tcItems) {
                    if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
                        rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, v.getWorth(), 0));
                        continue;
                    }
                    rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, (v.getTemplate()).groupCount, 0));
                }

                Out.debug(new Object[]{"gmFinishTask task prop:", rewards});

                WNBag bag = this.player.getWnBag();
                Out.debug(new Object[]{"gmFinishTask testAddCodeItems "});
                List<WNBag.SimpleItemInfo> rItems = new ArrayList<>();
                for (TaskBase.ItemNode node : rewards) {
                    WNBag.SimpleItemInfo map = new WNBag.SimpleItemInfo();
                    map.itemCode = node.itemCode;
                    map.itemNum = node.itemNum;
                    map.forceType = Const.ForceType.BIND;
                    rItems.add(map);
                }

                if (!bag.testAddCodeItems(rItems, Const.ForceType.BIND, false)) {
                    return false;
                }

                task.db.state = Const.TaskState.COMPLETED.getValue();


                NotifyToBattleServerParam param = new NotifyToBattleServerParam();
                param.playerUUID = this.player.getId();
                param.questID = String.valueOf(templateId);
                notifyToBattleServer("QuestCommittedR2B", param);

                task.setSecProgress(getSecProgress(task.getKind()));
                pushTaskUpdate(task);

                String[] nextTask = task.prop.nextTask;

                _finishTask(templateId, kind);
                _deleteTask(templateId, kind, false);

                TeamData team = this.player.teamManager.getTeam();
                if (kind == 2) {

                    TaskBase nextProp = TaskUtils.getRDDailyTask(this.player.getLevel(), templateId, this.player.getPro());
                    nextTask = new String[]{String.valueOf(nextProp.iD)};
                    _getNextAcceptTask(kind, nextTask, task.db.finishCount);
                } else if (kind == 3) {

                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        WNPlayer mPlayer = member.getPlayer();
                        if (mPlayer == null) {
                            continue;
                        }
                        nextTask = task.prop.nextTask;
                        mPlayer.taskManager._getNextAcceptTask(kind, nextTask, task.db.finishCount);
                    }
                } else {
                    _getNextAcceptTask(kind, nextTask, task.db.finishCount);
                }


                Out.debug(new Object[]{"gmFinishTask submit reward ", rewards});
                bag.addCodeItems(rItems, Const.GOODS_CHANGE_TYPE.task, null, false, false);
            }
        }
        if (!this.player.getArea().isNormal()) {
            this.player.fightLevelManager.leaveDungeon(this.player, this.player.getArea());
        }
        return true;
    }


    public final int getTaskExp(int exp, int expRatio) {
        if (expRatio <= 0) {
            return exp;
        }
        int maxLevel = GlobalConfig.Role_LevelLimit;
        if ((this.player.getPlayer()).level >= maxLevel) {
            return exp;
        }

        CharacterLevelCO prop = (CharacterLevelCO) GameData.CharacterLevels.get(Integer.valueOf(this.player.getLevel()));
        if (prop != null) {
            return exp + expRatio * prop.experience / 10000;
        }
        return exp;
    }


    public final int submitTask(int templateId, int kind, int isDouble) {
        TaskData task = getTask(templateId, kind);
        if (task == null || (task.getState() != Const.TaskState.COMPLETED_NOT_DELIVERY.getValue() && task.getType() != Const.TaskType.DISCARD_ITEM.getValue())) {
            Out.error(new Object[]{"submitTask: task is null", (this.player.getPlayer()).name, ",kind=", Integer.valueOf(kind), ",id:", Integer.valueOf(templateId), "-", (task != null) ? Integer.valueOf(task.getState()) : null});
            return -1;
        }
        List<TaskBase.ItemNode> rewards = TaskUtils.getReward(task.prop, this.playerPro);
        List<NormalItem> tcItems = ItemUtil.createItemsByTcCode(task.prop.tcReward);

        for (NormalItem v : tcItems) {
            if (v.prop.itemSecondType == Const.ItemSecondType.virtual.getValue()) {
                rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, v.getWorth(), 0));
                continue;
            }
            rewards.add(new TaskBase.ItemNode((v.getTemplate()).code, (v.getTemplate()).groupCount, 0));
        }

        int i;

        for (i = 0; i < rewards.size(); i++) {
            TaskBase.ItemNode reward = rewards.get(i);
            if (task.prop.expRatio > 0) {
                if (reward.itemCode.equals("exp")) {
                    reward.itemNum = getTaskExp(reward.itemNum, task.prop.expRatio);
                }
            }

            if (reward.itemCode.equals("gold")) {
                int vip = this.player.baseDataManager.getVip();
                int add = 0;
                if (vip > 0) {
                    add = ((CardCO) GameData.Cards.get(Integer.valueOf(vip))).prv3;
                }
                reward.itemNum += reward.itemNum * add / 10000;
            }
        }

        if (isDouble > 0) {

            if (task.prop.isDouble == 0) {
                return -1;
            }
            if (!this.player.moneyManager.enoughDiamond(task.prop.doubleCost)) {
                return -2;
            }
            for (TaskBase.ItemNode v : rewards) {
                v.itemNum *= 2;
            }
        }


        if (kind == 2) {
            for (i = 0; i < rewards.size(); i++) {
                TaskBase.ItemNode reward = rewards.get(i);
                reward.itemNum = reward.itemNum * TaskUtils.getDailyAwardRate(this.taskListPO.todayDailyTaskCount) / 100;
            }
        }

        Out.debug(new Object[]{"submit task prop:", rewards});
        WNBag bag = this.player.getWnBag();
        List<Map<String, Object>> rItems = new ArrayList<>();
        for (TaskBase.ItemNode node : rewards) {
            Map<String, Object> map = new HashMap<>();
            map.put("itemCode", node.itemCode);
            map.put("itemNum", Integer.valueOf(node.itemNum));
            map.put("isBind", Integer.valueOf(node.isBind));
            rItems.add(map);
        }


        if (!_discardItem(task)) {
            Out.error(new Object[]{"submitTask:", (this.player.getPlayer()).name, "id:", Integer.valueOf(templateId), "_discardItem"});
            return -1;
        }

        TeamData team = this.player.getTeamManager().getTeam();
        if (task.submit()) {

            if (task.prop.overState2 == 1) {
                this.player.playerBasePO.model = null;
                this.player.playerBasePO.speed = 0.0F;
                this.player.refreshBattlerServerAvatar();
                this.player.refreshBattlerServerEffect(false);
            }


            NotifyToBattleServerParam param = new NotifyToBattleServerParam();
            param.playerUUID = this.player.getId();
            param.questID = String.valueOf(templateId);
            notifyToBattleServer("QuestCommittedR2B", param);
            task.setSecProgress(getSecProgress(task.getKind()));

            if (kind == 3 && team != null) {
                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer == null) {
                        continue;
                    }
                    mPlayer.taskManager.pushTaskUpdate(task);
                }
            } else {
                pushTaskUpdate(task);
            }

            if (isDouble > 0) {
                this.player.moneyManager.costDiamond(task.prop.doubleCost, Const.GOODS_CHANGE_TYPE.task);
            }

            _finishTask(templateId, kind);
            _deleteTask(templateId, kind, false);


            if (kind == 3 && team != null && team.leaderId.equals(this.player.getId())) {

                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                    WNPlayer player = member.getPlayer();
                    if (player != null) {
                        CircleRewardCO circleReward = (CircleRewardCO) GameData.CircleRewards.get(Integer.valueOf(player.getLevel()));
                        if (circleReward != null) {
                            Out.debug(new Object[]{"----------------" + circleReward.gold});
                            int rate = TaskUtils.getLoopAwardRate(player.taskManager.taskListPO.todayLoopTaskCount);
                            if (rate > 0) {
                                int award_exp = circleReward.exp * rate / 100;
                                int award_upexp = circleReward.cul * rate / 100;

                                if (team.leaderId.equals(player.getId()) && player.taskManager.taskListPO.todayLoopTaskCount <= 10) {
                                    award_exp += award_exp * 5 / 100;
                                    award_upexp += award_upexp * 5 / 1000;
                                }
                                player.addExp(award_exp, Const.GOODS_CHANGE_TYPE.task);
                                player.addUpExp(award_upexp, Const.GOODS_CHANGE_TYPE.task);
                                player.moneyManager.addGold(circleReward.gold * rate / 100, Const.GOODS_CHANGE_TYPE.task);
                            }
                            for (TeamData.TeamMemberData tempMember : team.teamMembers.values()) {
                                WNPlayer teamMemPlayer = tempMember.getPlayer();
                                if (teamMemPlayer == null) {
                                    continue;
                                }
                                int teamMemLvl = teamMemPlayer.getLevel();
                                if (player.getLevel() >= teamMemLvl + 5) {
                                    int xianyuan = GlobalConfig.Fate_Loop;


                                    player.processXianYuanGet(xianyuan);
                                    break;
                                }
                            }
                        } else {
                            Out.error(new Object[]{"一条龙等级对应的奖励未配置 level=:" + player.getLevel()});
                        }


                        int taskCircle = player.taskManager.taskListPO.todayLoopTaskCount / 5;
                        if (player.taskManager.taskListPO.todayLoopTaskCount > 0 && player.taskManager.taskListPO.todayLoopTaskCount % 5 == 0 && taskCircle <= GlobalConfig.Quest_rewardTimes2) {
                            TaskChestCO taskChest = TaskUtils.getProgressBox(3, player.getLevel());
                            player.bag.addCodeItemMail(taskChest.chest, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");
                        }
                    }
                }


                if (team.finishedLoopTasks != null && team.finishedLoopTasks.size() >= 5) {
                    team.onAllOverLoopTask();
                    team.finishedLoopTasks.clear();
                }

                if (this.taskListPO.todayLoopTaskCount != 10 || this.taskListPO.loopBreaked) {
                    if (this.taskListPO.todayLoopTaskCount > 0 && this.taskListPO.todayLoopTaskCount % GlobalConfig.Loop_completeTips == 0) {
                        MessageData.MessageData_Quest data = new MessageData.MessageData_Quest();
                        data.finishCount = task.db.finishCount;
                        Map<String, String> strMsg = new HashMap<>();
                        strMsg.put("times", String.valueOf(this.taskListPO.todayLoopTaskCount));
                        MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.loop_task_times.getValue(), this.player.getId(), (MessageData.MessageData_Data) data, strMsg);
                        message.id = this.player.getId();
                        MessageUtil.sendMessageToPlayer(message, this.player.getId());
                    } else {
                        String[] nextTask = task.prop.nextTask;
                        List<TaskData> tasks = _getNextAcceptTask(kind, nextTask, task.db.finishCount);
                        if (tasks.size() > 0) {
                            for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                                WNPlayer mPlayer = member.getPlayer();
                                if (mPlayer == null || mPlayer == this.player) {
                                    continue;
                                }
                                for (TaskData t : tasks) {
                                    mPlayer.taskManager.pushTaskUpdate(t);
                                }
                            }
                        }
                    }
                }
                if (this.taskListPO.todayLoopTaskCount == 10 && !this.taskListPO.loopBreaked) {
                    this.taskListPO.loopBreaked = true;
                }
            } else if (kind == 2) {

                DailyRewardCO dailyReward = (DailyRewardCO) GameData.DailyRewards.get(Integer.valueOf(this.player.getLevel()));
                if (dailyReward != null) {
                    int rate = TaskUtils.getDailyAwardRate(this.taskListPO.todayDailyTaskCount);
                    if (rate > 0) {
                        this.player.addExp(dailyReward.exp * rate / 100, Const.GOODS_CHANGE_TYPE.task);
                        this.player.addUpExp(dailyReward.cul * rate / 100, Const.GOODS_CHANGE_TYPE.task);
                        this.player.moneyManager.addGold(dailyReward.gold * rate / 100, Const.GOODS_CHANGE_TYPE.task);
                    }
                }

                if (this.player.taskManager.taskListPO != null && this.player.taskManager.taskListPO.todayDailyTaskCount < GlobalConfig.Daily_completeMax) {

                    if (this.player.taskManager.taskListPO.todayDailyTaskCount > 0 && this.player.taskManager.taskListPO.todayDailyTaskCount % 10 == 0) {
                        TaskHandler.TaskAutoPush.Builder autoPush = TaskHandler.TaskAutoPush.newBuilder();
                        autoPush.setAuto(0);
                        this.player.receive("area.taskPush.taskAutoPush", (GeneratedMessage) autoPush.build());
                    }


                    DailyReduceCO dr = (DailyReduceCO) GameData.DailyReduces.get(Integer.valueOf(this.taskListPO.todayDailyTaskCount));
                    if (this.taskListPO.todayDailyTaskCount > 0 && dr != null) {
                        MessageData.MessageData_Quest data = new MessageData.MessageData_Quest();
                        data.finishCount = task.db.finishCount;
                        Map<String, String> strMsg = new HashMap<>(2);
                        strMsg.put("times", String.valueOf(this.taskListPO.todayDailyTaskCount));
                        strMsg.put("rate", String.valueOf(dr.rate));

                        MessageData message = MessageUtil.createMessage(Const.MESSAGE_TYPE.daily_task_times.getValue(), this.player.getId(), (MessageData.MessageData_Data) data, strMsg);
                        message.id = this.player.getId();
                        MessageUtil.sendMessageToPlayer(message, this.player.getId());
                    } else {

                        TaskBase nextProp = TaskUtils.getRDDailyTask(this.player.getLevel(), templateId, this.player.getPro());
                        String[] nextTask = {String.valueOf(nextProp.iD)};
                        _getNextAcceptTask(kind, nextTask, task.db.finishCount);
                    }
                }

                int taskCircle = this.taskListPO.todayDailyTaskCount / 10;
                if (this.taskListPO.todayDailyTaskCount > 0 && this.taskListPO.todayDailyTaskCount % 10 == 0 && taskCircle <= GlobalConfig.Quest_rewardTimes1) {
                    TaskChestCO taskChest = TaskUtils.getProgressBox(2, this.player.getLevel());
                    this.player.bag.addCodeItemMail(taskChest.chest, 1, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");
                }


                if (task.getType() == Const.TaskType.DISCARD_ITEM.getValue()) {
                    dailyTaskFinEvent();
                }
            } else {
                String[] nextTask = task.prop.nextTask;
                _getNextAcceptTask(kind, nextTask, task.db.finishCount);
            }


            Out.debug(new Object[]{"task submit rewards ", rewards});

            List<NormalItem> finalRewards = new ArrayList<>();
            for (int j = 0; j < rewards.size(); j++) {
                TaskBase.ItemNode reward = rewards.get(j);
                if (reward.itemCode.equals("exp")) {
                    if (this.player.petNewManager.getFightingPetId() != null) {
                        int petProb = GlobalConfig.Pet_GetExp_Prob;
                        if (petProb > 100) {
                            petProb = 100;
                        }
                        int petExp = (int) Math.floor((((TaskBase.ItemNode) rewards.get(j)).itemNum * petProb / 100));
                        this.player.petNewManager.addExp(this.player.petNewManager.getFightingPetId(), petExp);
                    }
                }
                List<NormalItem> items = ItemUtil.createItemsByItemCode(reward.itemCode, reward.itemNum);
                for (NormalItem item : items) {
                    item.setBind(1);
                    finalRewards.add(item);
                }
            }
            bag.addCodeItemMail(finalRewards, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.task, "Bag_full_common");

            if (kind == 3) {
                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer == null) {
                        continue;
                    }

                    mPlayer.functionOpenManager.onFinishTask(String.valueOf(templateId));

                    mPlayer.achievementManager.onFinishTask(templateId);
                    mPlayer.achievementManager.onFinishTaskNum(kind);
                }
            } else {

                this.player.functionOpenManager.onFinishTask(String.valueOf(templateId));

                this.player.achievementManager.onFinishTask(templateId);
                this.player.achievementManager.onFinishTaskNum(kind);
            }
            return 1;
        }
        Out.error(new Object[]{"submitTask:", (this.player.getPlayer()).name, "id:", Integer.valueOf(templateId), " submit error"});
        return -1;
    }

    public final boolean updateStatus(int templateId, int kind) {
        TaskData task = getTask(templateId, kind);
        if (task == null) {
            return false;
        }

        if (task.getType() != Const.TaskType.INTERACT_NPC.getValue()) {
            return false;
        }

        if (task.getState() != Const.TaskState.NOT_COMPLETED.getValue()) {
            return false;
        }


        task.complete();
        task.setSecProgress(getSecProgress(task.getKind()));
        pushTaskUpdate(task);
        if (kind == 2) {
            dailyTaskFinEvent();
        } else if (kind == 3) {
            loopTaskFinEvent();
        }

        BILogService.getInstance().ansycReportMission(this.player.getPlayer(), "任务完成", task.getKind(), task.prop.iD, task.prop.name);
        return true;
    }


    public final void onEvent(TaskEvent event) {
        int eventType = event.type;
        Out.debug(new Object[]{"task event handle", Integer.valueOf(eventType)});
        List<TaskData> tasks = this.eventWatchers.get(Integer.valueOf(eventType));
        if (tasks != null && tasks.size() > 0) {
            for (TaskData task : tasks) {
                if (task.onEvent(this.player, event)) {
                    task.setSecProgress(getSecProgress(task.getKind()));
                    onComplteTask(this.player, event, task);
                }
            }
        }


        TeamData team = this.player.teamManager.getTeam();
        if (team != null && team.isInLoopTask()) {
            Map<Integer, TaskPO> loopTasks = team.loopTasks;
            for (TaskPO db : loopTasks.values()) {
                TaskData taskData = new TaskData(db);
                if (taskData.getType() != eventType) {
                    continue;
                }
                if (taskData.onEvent(this.player, event)) {
                    taskData.setSecProgress(getSecProgress(taskData.getKind()));
                }
                if (taskData.isCompleted()) {
                    for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                        WNPlayer mPlayer = member.getPlayer();
                        if (mPlayer == null) {
                            continue;
                        }
                        onComplteTask(mPlayer, event, taskData);
                    }
                }
            }
        }
    }

    private void onComplteTask(WNPlayer player, TaskEvent event, TaskData task) {
        player.taskManager.pushTaskUpdate(task);

        if (task.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {

            NotifyToBattleServerParam param = new NotifyToBattleServerParam();
            param.playerUUID = player.getId();
            param.questID = String.valueOf(task.db.templateId);
            param.initStatus = false;
            param.status = new ArrayList<>();
            param.status.add(new StringString("state", String.valueOf(Const.TaskState.COMPLETED_NOT_DELIVERY.getValue())));
            player.taskManager.notifyToBattleServer("QuestStatusChangedR2B", param);


            if (task.prop.completeNpc == -1) {
                player.taskManager.submitTask(task.db.templateId, task.getKind(), 0);
            }
        }
    }


    private final void notifyToBattleServer(String name, NotifyToBattleServerParam param) {
        this.player.getXmdsManager().notifyBattleServer(this.player.getInstanceId(), name, JSON.toJSONString(param));
    }


    public final List<TaskData> _getNextAcceptTask(int kind, String[] nextTasks, int finishCount) {
        List<TaskData> tasks = new ArrayList<>(2);
        TaskData task = null;
        boolean hasMain = false;
        for (String taskId : nextTasks) {
            int id = Integer.parseInt(taskId);
            TaskBase prop = TaskUtils.getTaskProp(id);

            if (prop != null && _canAcceptTaskByProp(prop) == null) {
                if (prop.getKind() == 0) {
                    hasMain = true;
                }
                if (prop.giveNpc == 0) {
                    task = (acceptTask(prop.getId(), prop.getKind())).task;
                } else {
                    task = TaskUtils.createTask(prop);
                    if (prop.getKind() == 0) {
                        if (!hasMainLineTask() && !isFinishTask(id)) {
                            this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
                        }
                    } else if (prop.getKind() == 1) {
                        this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
                    } else if (prop.getKind() == 8) {
                        this.treasureTasks.put(Integer.valueOf(task.db.templateId), task.db);
                    } else if (prop.getKind() == 3) {
                        TeamData team = this.player.teamManager.getTeam();
                        if (team != null) {
                            if (team.loopTasks == null) {
                                team.loopTasks = new HashMap<>();
                            }
                            team.loopTasks.put(Integer.valueOf(task.db.templateId), task.db);
                        }
                    } else {
                        this.dailyTasks.put(Integer.valueOf(task.db.templateId), task.db);
                    }
                }
                task.db.finishCount = finishCount;
                task.setSecProgress(getSecProgress(task.getKind()));
                tasks.add(task);
                pushTaskUpdate(task);
            }
        }

        if (kind == 0 && !hasMain) {
            for (String taskId : nextTasks) {
                int id = Integer.parseInt(taskId);
                TaskBase prop = TaskUtils.getTaskProp(id);
                if (prop != null && prop.getKind() == 0) {
                    task = TaskUtils.createTask(prop);
                    this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
                    task.db.finishCount = finishCount;
                    task.setSecProgress(getSecProgress(task.getKind()));
                    tasks.add(task);
                    pushTaskUpdate(task);
                }
            }
        }
        refreshWatchEvents();
        return tasks;
    }


    private final void _addTask(TaskData task) {
        if (task.isDaily()) {
            this.dailyTasks.put(Integer.valueOf(task.db.templateId), task.db);
        } else if (task.isLoop()) {
            TeamData team = this.player.teamManager.getTeam();
            if (team != null) {
                team.onFirstAcceptLoopTask();
                if (team.loopTasks == null) {
                    team.loopTasks = new HashMap<>();
                }
                team.loopTasks.put(Integer.valueOf(task.db.templateId), task.db);
            }
        } else if (task.isTreasure()) {
            this.treasureTasks.put(Integer.valueOf(task.db.templateId), task.db);
        } else {
            this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
        }
        refreshWatchEvents();
    }


    private final void _deleteTask(int templateId, int kind, boolean sendtoBattle) {
        Out.debug(new Object[]{"_deleteTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind)});
        if (kind == 2) {
            this.dailyTasks.remove(Integer.valueOf(templateId));
        } else if (kind == 3) {
            Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
            if (loopTasks != null) {
                loopTasks.remove(Integer.valueOf(templateId));
            }
        } else if (kind == 8) {
            this.treasureTasks.remove(Integer.valueOf(templateId));
        } else {
            this.normalTasks.remove(Integer.valueOf(templateId));
        }

        if (sendtoBattle) {

            NotifyToBattleServerParam param = new NotifyToBattleServerParam();
            param.playerUUID = this.player.getId();
            param.questID = String.valueOf(templateId);
            notifyToBattleServer("QuestDroppedR2B", param);
        }
        refreshWatchEvents();
    }


    private final void _finishTask(int templateId, int kind) {
        Out.debug(new Object[]{"_finishTask templateId: ", Integer.valueOf(templateId), " kind: ", Integer.valueOf(kind)});
        if (kind == 2) {
            this.finishedDailyTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
            this.taskListPO.todayDailyTaskCount++;
        } else if (kind == 3) {

            TeamData team = this.player.teamManager.getTeam();
            if (team != null) {
                if (team.finishedLoopTasks == null) {
                    team.finishedLoopTasks = new HashMap<>();
                }
                team.finishedLoopTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));

                for (TeamData.TeamMemberData member : team.teamMembers.values()) {
                    WNPlayer mPlayer = member.getPlayer();
                    if (mPlayer != null) {
                        mPlayer.taskManager.taskListPO.todayLoopTaskCount++;
                    }
                }
            }
        } else if (kind == 8) {
            this.finishedTreasureTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
        } else {

            this.finishedNormalTasks.put(Integer.valueOf(templateId), Integer.valueOf(templateId));
        }
    }

    public TaskOuterClass.Tasks toJson4Payload() {
        TaskOuterClass.Tasks.Builder data = TaskOuterClass.Tasks.newBuilder();
        List<TaskOuterClass.Task> taskList = new ArrayList<>();
        Iterator<Integer> iterator1;
        for (iterator1 = this.normalTasks.keySet().iterator(); iterator1.hasNext(); ) {
            int templateId = ((Integer) iterator1.next()).intValue();
            TaskData task = new TaskData(this.normalTasks.get(Integer.valueOf(templateId)));
            task.setSecProgress(getSecProgress(task.getKind()));
            if (task.getState() != Const.TaskState.DELETE.getValue()) {
                TaskOuterClass.Task payLoad = task.buildTask();
                if (payLoad != null) {
                    taskList.add(payLoad);
                }
            }
        }


        for (iterator1 = this.dailyTasks.keySet().iterator(); iterator1.hasNext(); ) {
            int templateId = ((Integer) iterator1.next()).intValue();
            TaskData task = new TaskData(this.dailyTasks.get(Integer.valueOf(templateId)));
            task.setSecProgress(getSecProgress(task.getKind()));
            if (task.getState() != Const.TaskState.DELETE.getValue()) {
                TaskOuterClass.Task payLoad = task.buildTask();
                if (payLoad != null) {
                    taskList.add(payLoad);
                }
            }
        }


        Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
        if (loopTasks != null) {
            for (Iterator<Integer> iterator = loopTasks.keySet().iterator(); iterator.hasNext(); ) {
                int templateId = ((Integer) iterator.next()).intValue();
                TaskData task = new TaskData(loopTasks.get(Integer.valueOf(templateId)));
                task.setSecProgress(getSecProgress(task.getKind()));
                if (task.getState() != Const.TaskState.DELETE.getValue()) {
                    TaskOuterClass.Task payLoad = task.buildTask();
                    if (payLoad != null) {
                        taskList.add(payLoad);
                    }
                }
            }

        }


        for (Iterator<Integer> iterator2 = this.treasureTasks.keySet().iterator(); iterator2.hasNext(); ) {
            int templateId = ((Integer) iterator2.next()).intValue();
            TaskData task = new TaskData(this.treasureTasks.get(Integer.valueOf(templateId)));
            task.setSecProgress(getSecProgress(task.getKind()));
            if (task.getState() != Const.TaskState.DELETE.getValue()) {
                TaskOuterClass.Task payLoad = task.buildTask();
                if (payLoad != null) {
                    taskList.add(payLoad);
                }
            }
        }


        data.addAllTaskList(taskList);

        getDailyTask(taskList, -1, false);
        return data.build();
    }


    public final void getDailyTask(List<TaskOuterClass.Task> dataArray, int cycleType, boolean isNewDay) {
    }


    public void pushTaskUpdate(TaskData data) {
        pushTaskUpdate(data, this.player.teamManager.getTeam());
    }

    public final void pushTaskUpdate(TaskData data, TeamData team) {
        if (data != null) {
            data.setSecProgress(getSecProgress(data.getKind(), team));
            TaskHandler.TaskUpdatePush.Builder builder = TaskHandler.TaskUpdatePush.newBuilder();
            TaskOuterClass.Tasks.Builder task = TaskOuterClass.Tasks.newBuilder();
            task.addTaskList(data.buildTask());
            builder.setS2CData(task.build());
            this.player.receive("area.taskPush.taskUpdatePush", (GeneratedMessage) builder.build());
        }
    }

    public final void pushTaskUpdate(List<TaskOuterClass.Task> data) {
        if (data.size() > 0) {
            TaskHandler.TaskUpdatePush.Builder builder = TaskHandler.TaskUpdatePush.newBuilder();
            TaskOuterClass.Tasks.Builder task = TaskOuterClass.Tasks.newBuilder();
            task.addAllTaskList(data);
            builder.setS2CData(task.build());
            this.player.receive("area.taskPush.taskUpdatePush", (GeneratedMessage) builder.build());
        }
    }


    public final void onTaskRequestEvent(String eventName, int templateId, String key, int value) {
        Out.debug(new Object[]{"onTaskRequestEvent recived name:", eventName, " id: ", Integer.valueOf(templateId)});
        if (!eventName.equals("AcceptQuest")) {
            if (!eventName.equals("CommitQuest")) {
                if (eventName.equals("DropQuest")) {
                    discardTaskByID(templateId);
                } else if (eventName.equals("UpdateQuestStatus")) {

                    TaskData task = getTaskByID(templateId);
                    if (task == null) {
                        Out.error(new Object[]{"UpdateQuestStatus can not find task: ", Integer.valueOf(templateId)});
                        return;
                    }
                    if (key.equals("state") && value == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {

                        completeTaskByID(templateId);
                        if (task != null && task.prop.completeNpc == -1) {
                            submitTask(task.db.templateId, task.getKind(), 0);
                        }
                    } else if (key.equals("add_progress")) {
                        Out.debug(new Object[]{"onTaskRequestEvent add_progress", task});
                        if (task != null) {
                            int progress = task.getProgress();

                            progress += value;
                            if (progress >= task.getTargetNum()) {
                                progress = task.getTargetNum();
                            }
                            boolean killed = task.setProgress(progress);
                            if (task.db.state == Const.TaskState.COMPLETED_NOT_DELIVERY.getValue()) {
                                NotifyToBattleServerParam param = new NotifyToBattleServerParam();
                                param.playerUUID = this.player.getId();
                                param.questID = String.valueOf(templateId);
                                param.initStatus = false;
                                param.status = new ArrayList<>();
                                param.status.add(new StringString("state", String.valueOf(Const.TaskState.COMPLETED_NOT_DELIVERY.getValue())));
                                notifyToBattleServer("QuestStatusChangedR2B", param);
                            } else if (killed) {

                                NotifyToBattleServerParam param = new NotifyToBattleServerParam();
                                param.playerUUID = this.player.getId();
                                param.questID = String.valueOf(templateId);
                                param.initStatus = false;
                                param.status = new ArrayList<>();
                                param.status.add(new StringString("refine_killed", "true"));
                                notifyToBattleServer("QuestStatusChangedR2B", param);
                                task.setBattleAttribute("refine_killed", "true");
                            }
                            task.pushProgressTips(this.player);

                            task.setSecProgress(getSecProgress(task.getKind()));
                            pushTaskUpdate(task);
                        }
                    } else {
                        TaskData task1 = getTaskByID(templateId);
                        if (task1 != null) {
                            task1.setBattleAttribute(key, String.valueOf(value));
                        }
                    }
                } else if (eventName.equals("accessable")) {

                    TaskBase prop = TaskUtils.getTaskProp(templateId);
                    if (prop == null) {
                        Out.warn(new Object[]{"accessable task not found: ", Integer.valueOf(templateId)});
                    } else if (_canAcceptTaskByProp(prop) == null) {
                        TaskData newTask = null;
                        if (prop.giveNpc == 0) {
                            AcceptTaskHandler.AcceptTaskResult result = acceptTask(prop.getId(), prop.getKind());
                            newTask = result.task;
                        }
                        if (newTask != null) {
                            _addTask(newTask);
                            newTask.setSecProgress(getSecProgress(newTask.getKind()));
                            pushTaskUpdate(newTask);
                        }

                    }

                } else if (eventName.equals("unaccessable")) {

                    TaskData task = getTaskByID(templateId);
                    if (task != null && task.getState() == Const.TaskState.NOT_START.getValue()) {
                        task.db.state = Const.TaskState.DELETE.getValue();
                        task.setSecProgress(getSecProgress(task.getKind()));
                        _deleteTask(templateId, task.getKind(), true);
                        pushTaskUpdate(task);
                    }
                }
            }
        }
    }


    public int getSecProgress(int kind) {
        return getSecProgress(kind, this.player.teamManager.getTeam());
    }


    public int getSecProgress(int kind, TeamData team) {
        if (kind == 2) {
            int all = (this.taskListPO.todayDailyTaskCount + this.dailyTasks.size()) % 10;
            if (all == 0) {
                all = 10;
            }
            return all;
        }
        if (kind == 3) {
            int all = 0;

            if (team == null) {
                return -1;
            }
            if ((team.finishedLoopTasks == null || team.finishedLoopTasks.size() == 0) && (team.loopTasks == null || team.loopTasks.size() == 0)) {
                return -1;
            }
            if (team.finishedLoopTasks != null) {
                all += team.finishedLoopTasks.size();
            }
            if (team.loopTasks != null) {
                all += team.loopTasks.size();
            }
            return all;
        }
        return -1;
    }


    public final void onLevelChange(int level) {
        List<TaskOuterClass.Task> data = new ArrayList<>();
        for (BranchLineCO prop : GameData.BranchLines.values()) {
            if (prop.level <= level &&
                    !isFinish(prop.iD, prop.kind) && _canAcceptTaskByProp((TaskBase) prop) == null) {
                if (prop.giveNpc == 0) {
                    acceptTask(prop.iD, prop.kind);
                    TaskData taskData = getTask(prop.iD, prop.kind);
                    if (taskData != null) {
                        taskData.setSecProgress(getSecProgress(taskData.getKind()));
                        data.add(taskData.buildTask());
                    }
                    continue;
                }
                TaskData task = TaskUtils.createTask((TaskBase) prop);
                this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
                task.setSecProgress(getSecProgress(task.getKind()));
                data.add(task.buildTask());
            }
        }


        getDailyTask(data, -1, false);
        Out.debug(new Object[]{"task onLevelChange: ", data});
        if (data.size() > 0) {
            refreshWatchEvents();
            pushTaskUpdate(data);
        }

        dealTaskEvent(Const.TaskType.LEVEL_UP, level);
    }

    public final void onUpLevelChange(int upLevel) {
        List<TaskOuterClass.Task> data = new ArrayList<>();
        for (BranchLineCO p : GameData.BranchLines.values()) {
            if (p.level <= upLevel && p.level > 0 &&
                    !isFinish(p.iD, p.kind) && _canAcceptTaskByProp((TaskBase) p) == null) {
                if (p.giveNpc == 0) {
                    acceptTask(p.iD, p.kind);
                    TaskData taskData = getTask(p.iD, p.kind);
                    if (taskData != null) {
                        taskData.setSecProgress(getSecProgress(taskData.getKind()));
                        data.add(taskData.buildTask());
                    }
                    continue;
                }
                TaskData task = TaskUtils.createTask((TaskBase) p);
                this.normalTasks.put(Integer.valueOf(task.db.templateId), task.db);
                task.setSecProgress(getSecProgress(task.getKind()));
                data.add(task.buildTask());
            }
        }


        getDailyTask(data, -1, false);
        Out.debug(new Object[]{"task onUpLevelChange: ", data});
        if (data.size() > 0) {
            refreshWatchEvents();
            pushTaskUpdate(data);
        }

        dealTaskEvent(Const.TaskType.USERUP_LEVEL, (this.player.getPlayer()).upLevel);
    }


    public void onLogin() {
        Map<Integer, TaskPO> loopTasks = this.player.teamManager.getLoopTasks();
        if (loopTasks != null)
            for (TaskPO db : loopTasks.values())
                pushTaskUpdate(new TaskData(db));
    }
}


