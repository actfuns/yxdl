package com.wanniu.game.task;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.CircleCO;
import com.wanniu.game.data.CircleChoiceCO;
import com.wanniu.game.data.DailyCO;
import com.wanniu.game.data.DailyReduceCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TaskChestCO;
import com.wanniu.game.data.base.TaskBase;
import com.wanniu.game.data.ext.WayTreasureExt;
import com.wanniu.game.functionOpen.FunctionOpenUtil;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerBasePO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.team.TeamData;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pomelo.area.TaskHandler;


public class TaskUtils {
    public static Map<Integer, TaskBase> AllTasks = new HashMap<>();

    public static List<CircleCO> AllCircleRates = null;

    public static List<DailyReduceCO> AllDailyRates = null;

    private static Map<Integer, List<TaskChestCO>> progressBox = null;

    private static List<Integer> dailySceneIds = null;

    private static Map<Integer, List<TaskBase>> sceneDailyTask = null;

    private static List<Integer> dailyLevels = null;

    public static void init() {
        AllTasks.putAll(GameData.MainLines);
        AllTasks.putAll(GameData.BranchLines);
        AllTasks.putAll(GameData.Dailys);
        AllTasks.putAll(GameData.CircleScenes);


        AllCircleRates = new ArrayList<>(GameData.Circles.values());
        AllCircleRates.sort(new Comparator<CircleCO>() {
            public int compare(CircleCO arg0, CircleCO arg1) {
                int result = 0;
                if (arg0.num > arg1.num) {
                    result = 1;
                } else if (arg0.num < arg1.num) {
                    result = -1;
                }
                return result;
            }
        });

        AllDailyRates = new ArrayList<>(GameData.DailyReduces.values());
        AllDailyRates.sort(new Comparator<DailyReduceCO>() {
            public int compare(DailyReduceCO arg0, DailyReduceCO arg1) {
                int result = 0;
                if (arg0.num > arg1.num) {
                    result = 1;
                } else if (arg0.num < arg1.num) {
                    result = -1;
                }
                return result;
            }
        });


        GameData.CircleScenes = new TreeMap<>(GameData.CircleScenes);


        progressBox = new HashMap<>();
        progressBox.put(Integer.valueOf(2), new ArrayList<>());
        progressBox.put(Integer.valueOf(3), new ArrayList<>());

        for (TaskChestCO taskChest : GameData.TaskChests.values()) {
            ((List<TaskChestCO>) progressBox.get(Integer.valueOf(taskChest.kind))).add(taskChest);
        }

        for (List<TaskChestCO> taskChestList : progressBox.values()) {
            taskChestList.sort(new Comparator<TaskChestCO>() {
                public int compare(TaskChestCO o1, TaskChestCO o2) {
                    if (o1.charLevel < o2.charLevel)
                        return 1;
                    if (o1.charLevel > o2.charLevel) {
                        return -1;
                    }
                    return 0;
                }
            });
        }

        sceneDailyTask = new HashMap<>();
        dailySceneIds = new ArrayList<>();
        dailyLevels = new ArrayList<>();
        for (TaskBase daily : GameData.Dailys.values()) {
            List<TaskBase> list = sceneDailyTask.get(Integer.valueOf(daily.startScene));
            if (list == null) {
                list = new ArrayList<>();
                sceneDailyTask.put(Integer.valueOf(daily.startScene), list);
            }
            list.add(daily);

            if (!dailySceneIds.contains(Integer.valueOf(daily.startScene))) {
                dailySceneIds.add(Integer.valueOf(daily.startScene));
            }

            if (!dailyLevels.contains(Integer.valueOf(daily.level))) {
                dailyLevels.add(Integer.valueOf(daily.level));
            }
        }
        for (List<TaskBase> list_daily : sceneDailyTask.values()) {
            list_daily.sort(new Comparator<TaskBase>() {
                public int compare(TaskBase o1, TaskBase o2) {
                    if (o1.iD < o2.iD)
                        return -1;
                    if (o1.iD > o2.iD) {
                        return 1;
                    }
                    return 0;
                }
            });
        }


        dailyLevels.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() < o2.intValue())
                    return -1;
                if (o1.intValue() > o2.intValue()) {
                    return 1;
                }
                return 0;
            }
        });
    }


    public static TaskData createTask(TaskBase prop) {
        return createTask(prop, Const.TaskState.NOT_START);
    }

    public static TaskData createTask(TaskBase prop, Const.TaskState state) {
        TaskData data = new TaskData(prop);
        data.db.state = state.getValue();
        return data;
    }

    public static List<TaskBase.ItemNode> getReward(TaskBase prop, int pro) {
        List<TaskBase.ItemNode> rewards = new ArrayList<>();
        if (prop.rewards.containsKey(Integer.valueOf(pro))) {
            List<TaskBase.ItemNode> temp = (List<TaskBase.ItemNode>) prop.rewards.get(Integer.valueOf(pro));
            for (TaskBase.ItemNode node : temp) {
                rewards.add(new TaskBase.ItemNode(node.itemCode, node.itemNum, node.isBind));
            }
        }
        if (prop.rewards.containsKey(Integer.valueOf(0))) {
            List<TaskBase.ItemNode> temp = (List<TaskBase.ItemNode>) prop.rewards.get(Integer.valueOf(0));
            for (TaskBase.ItemNode node : temp) {
                rewards.add(new TaskBase.ItemNode(node.itemCode, node.itemNum, node.isBind));
            }
        }
        return rewards;
    }


    public static List<TaskBase> getDailyTasks(int level, int rank, int pro, int cycleType) {
        List<TaskBase> dailyTasks = new ArrayList<>();


        for (DailyCO daily : GameData.Dailys.values()) {
            if (daily.before.equals("0") && (cycleType == -1 || daily.taskCycle == cycleType) && (daily.pro == 0 || daily.pro == pro) &&
                    checkOpenWay(daily.openWay, daily.openDay) && checkTaskValidTime(daily.openTime, daily.endTime)) {
                dailyTasks.add(daily);
            }
        }


        return dailyTasks;
    }

    public static final TaskBase getTaskProp(int id) {
        TaskBase task = (TaskBase) GameData.MainLines.get(Integer.valueOf(id));
        if (task == null) {
            task = (TaskBase) GameData.BranchLines.get(Integer.valueOf(id));
            if (task == null) {
                task = (TaskBase) GameData.Dailys.get(Integer.valueOf(id));
            }
            if (task == null) {
                task = (TaskBase) GameData.CircleScenes.get(Integer.valueOf(id));
            }
            if (task == null) {
                task = (TaskBase) GameData.Treasures.get(Integer.valueOf(id));
            }
        }
        return task;
    }


    public static TaskBase getStealTaskProp(int giveNpc) {
        int type = Const.TaskType.STEAL.getValue();
        for (TaskBase task : AllTasks.values()) {
            if (task.type == type && task.giveNpc == giveNpc) {
                return task;
            }
        }
        for (DailyCO daily : GameData.Dailys.values()) {
            if (daily.giveNpc == giveNpc) {
                return (TaskBase) daily;
            }
        }
        return null;
    }

    public static boolean checkOpenWay(int openWay, String[] openDay) {
        if (openWay == Const.TaskOpenWay.None.getValue()) {
            return false;
        }
        if (openWay == Const.TaskOpenWay.DailyOpenInTime.getValue()) {
            return true;
        }
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int indexDay = c.get(7);
        if (indexDay == 0) {
            indexDay = 7;
        }
        for (String day : openDay) {
            int dayInt = Integer.parseInt(day);
            if (dayInt == indexDay &&
                    openWay == Const.TaskOpenWay.WeekOpenInTime.getValue()) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkTaskValidTime(String startTime, String endTime) {
        if (StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
            return true;
        }

        Date start = Utils.getTodayTimeFromString(startTime, null);
        Date end = Utils.getTodayTimeFromString(endTime, null);
        Date now = new Date();
        if (now.getTime() >= start.getTime() && now.getTime() <= end.getTime()) {
            return true;
        }
        return false;
    }


    public static int getLoopAwardRate(int times) {
        int rate = 0;
        for (CircleCO co : AllCircleRates) {
            if (co.num <= times) {
                rate = co.rate;
            }
        }
        return rate;
    }


    public static boolean profitableLoop(WNPlayer player) {
        int times = player.taskManager.taskListPO.todayLoopTaskCount;
        CircleCO co = AllCircleRates.get(AllCircleRates.size() - 1);

        return (co.num > times);
    }


    public static int getAvgLevel(TeamData team) {
        int openLevel = (FunctionOpenUtil.getPropByName(Const.FunctionType.LoopTask.getValue())).openLv;
        if (team == null) {
            return openLevel;
        }
        float levelRate = ((CircleChoiceCO) GameData.CircleChoices.get(Integer.valueOf(team.memberCount()))).rate;
        int totalLevel = 0;
        for (TeamData.TeamMemberData member : team.teamMembers.values()) {
            WNPlayer mPlayer = member.getPlayer();
            int lv = 0;
            if (mPlayer != null) {
                lv = mPlayer.getLevel();
            } else {
                PlayerPO playerPO = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, member.id, PlayerPO.class);
                if (playerPO != null) {
                    lv = playerPO.level;
                }
            }

            lv = (int) (lv * levelRate);
            totalLevel += (lv > openLevel) ? lv : openLevel;
        }
        int avgLevel = totalLevel / team.memberCount();
        return avgLevel;
    }

    private static int times = 0;


    public static TaskBase getRDDailyTask(int level, int beforeTaskId, int pro) {
        List<TaskBase> list_tasks = null;
        TaskBase prop = null;
        int taskSceneId = 0;
        if (beforeTaskId == 0) {
            while (prop == null) {
                taskSceneId = ((Integer) dailySceneIds.get(RandomUtil.getIndex(dailySceneIds.size()))).intValue();
                list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
                prop = getDailyTask(level, pro, list_tasks, 0);
                times++;
                if (times > 50) {
                    times = 0;
                    Out.error(new Object[]{"1getRDDailyTask死锁level=", Integer.valueOf(level), ",beforeTaskId=", Integer.valueOf(beforeTaskId), ",pro=", Integer.valueOf(pro)});
                    break;
                }
            }
            if (prop != null) {
                times = 0;
            }
            return prop;
        }

        TaskBase beforeProp = (TaskBase) GameData.Dailys.get(Integer.valueOf(beforeTaskId));
        taskSceneId = beforeProp.startScene;
        list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
        int index = -1;
        for (int i = 0; i < list_tasks.size(); i++) {
            if (((TaskBase) list_tasks.get(i)).iD == beforeTaskId) {
                index = i;

                break;
            }
        }
        while (prop == null) {
            list_tasks = sceneDailyTask.get(Integer.valueOf(taskSceneId));
            prop = getDailyTask(level, pro, list_tasks, index + 1);
            taskSceneId = getRDTaskSceneId(taskSceneId);
            index = -1;
            times++;
            if (times > 50) {
                times = 0;
                Out.error(new Object[]{"2getRDDailyTask死锁level=" + level + ",beforeTaskId=" + beforeTaskId + ",pro=" + pro});
                break;
            }
        }
        if (prop != null) {
            times = 0;
        }


        return prop;
    }

    private static int getRDTaskSceneId(int beforeSceneId) {
        List<Integer> list = new ArrayList<>();
        for (Iterator<Integer> iterator = dailySceneIds.iterator(); iterator.hasNext(); ) {
            int sceneId = ((Integer) iterator.next()).intValue();
            if (beforeSceneId != sceneId) {
                list.add(Integer.valueOf(sceneId));
            }
        }

        return ((Integer) list.get(RandomUtil.getIndex(list.size()))).intValue();
    }

    private static TaskBase getDailyTask(int level, int pro, List<TaskBase> list_tasks, int index) {
        if (index >= list_tasks.size() - 1) {
            return null;
        }

        for (int i = index; i < list_tasks.size(); i++) {
            TaskBase prop = list_tasks.get(i);


            if (level >= prop.level && prop.level == getNeerLevel(level)) {


                if (prop.pro == 0 || prop.pro == pro) {

                    return prop;
                }
            }
        }
        return null;
    }


    private static int getNeerLevel(int myLevel) {
        int lv = 0;
        for (Iterator<Integer> iterator = dailyLevels.iterator(); iterator.hasNext(); ) {
            int level = ((Integer) iterator.next()).intValue();
            if (level <= myLevel) {
                lv = level;
            }
        }


        return lv;
    }


    public static int getDailyAwardRate(int times) {
        int rate = 0;
        for (DailyReduceCO co : AllDailyRates) {
            if (co.num <= times) {
                rate = co.rate;
            }
        }
        return rate;
    }


    public static void dealTrainEquipAllTask(WNPlayer player) {
        int equip_count = 0;
        Map<Integer, PlayerBasePO.EquipStrengthPos> strengthPos = player.equipManager.strengthPos;
        for (Iterator<Integer> iterator = strengthPos.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            PlayerBasePO.EquipStrengthPos equip = strengthPos.get(Integer.valueOf(pos));
            int equipLevel = equip.enSection * (GlobalConfig.EquipmentCraft_Enchant_MaxenLevel + 1) + equip.enLevel;
            if (equipLevel < 10) {
                continue;
            }
            equip_count++;
        }

        player.taskManager.dealTaskEvent(Const.TaskType.TRAIN_EQUIP_ALL, "-1", equip_count);
    }


    public static TaskChestCO getProgressBox(int taskKind, int level) {
        List<TaskChestCO> list = progressBox.get(Integer.valueOf(taskKind));
        for (TaskChestCO taskChest : list) {
            if (level >= taskChest.charLevel) {
                return taskChest;
            }
        }
        Out.error(new Object[]{"getProgressBox error, taskKind=", Integer.valueOf(taskKind), ", level=", Integer.valueOf(level)});
        return null;
    }


    public static TaskBase getFirstLoopTask() {
        Iterator<TaskBase> iterator = GameData.CircleScenes.values().iterator();
        if (iterator.hasNext()) {
            TaskBase _prop = iterator.next();
            return _prop;
        }

        return null;
    }


    public static boolean canTalkWithNpc(int templateId, int npcId) {
        TaskBase prop = getTaskProp(templateId);
        if (prop != null && prop.needNpcs.contains(Integer.valueOf(npcId))) {
            return true;
        }
        return false;
    }

    public static void treasurePush(WNPlayer player, int wayId, int taskId) {
        TaskHandler.TreasureScenePointPush.Builder scenePointPush = TaskHandler.TreasureScenePointPush.newBuilder();
        WayTreasureExt way = (WayTreasureExt) GameData.WayTreasures.get(Integer.valueOf(wayId));
        int sceneIndex = RandomUtil.getIndex(way.doScenes.size());
        scenePointPush.setSceneId(((Integer) way.doScenes.get(sceneIndex)).intValue());
        List<Integer> points = way.doPoints.get(sceneIndex);
        scenePointPush.setPoint(((Integer) points.get(RandomUtil.getIndex(points.size()))).intValue());
        scenePointPush.setTaskId(taskId);
        player.receive("area.taskPush.treasureScenePointPush", (GeneratedMessage) scenePointPush.build());

        player.getXmdsManager().addUnit("", 0, null);
    }
}


