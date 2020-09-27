package com.wanniu.game.sevengoal;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtils;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.DateUtils;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SevDayTaskCO;
import com.wanniu.game.data.SevTaskInsCO;
import com.wanniu.game.data.ext.SevTaskRewardExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.SevenGoalPO;
import com.wanniu.redis.PlayerPOManager;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.PlayerHandler;
import pomelo.sevengoal.SevenGoalHandler;


public class SevenGoalManager
        extends ModuleManager {
    public WNPlayer player;
    public SevenGoalPO sevenGoalPO;

    public enum SevenGoalTaskType {
        MOUNT_UPGRADE_LV(1),
        SOLO_ANTICIPATE(2),
        ADD_FRIEND(3),
        PAY_COUNT(4),
        PET_UPGRADE_UPLV(5),
        EQUIP_STRENTHEN_COUNT(6),
        FIVE_MOUNTAIN_ANTICIPATE(7),
        COST_DIAMOND_COUNT(8),
        FIGHTPOWER_TO(9),
        GEM_COMBINE_COUNT(10),
        TRIAL_ANTICIPATE(11),
        COST_DIAMOND_OR_BINDDIAMOND_COUNT(12),
        EQUIP_REFINE_COUNT(13),
        EQUIP_REBORN_COUNT(14),
        EQUIP_REBUILD_COUNT(15),
        DEMON_TOWER_COUNT(16),
        AREA_BOSS_KILL_COUNT(17),
        LEVEL_TO(18),
        XIANYUAN_TO(19),
        GUILD_BOSS_COUNT(20),
        ILLUSION2_COUNT(21);

        final int value;

        SevenGoalTaskType(int value) {
            this.value = value;
        }

        public static SevenGoalTaskType getType(int value) {
            for (SevenGoalTaskType sevenGoalTaskType : values()) {
                if (sevenGoalTaskType.value == value) {
                    return sevenGoalTaskType;
                }
            }
            return null;
        }
    }

    public SevenGoalManager(WNPlayer player) {
        this.player = player;

        this.sevenGoalPO = (SevenGoalPO) PlayerPOManager.findPO(ConstsTR.SevenGoal, player.getId(), SevenGoalPO.class);
        if (this.sevenGoalPO == null) {
            this.sevenGoalPO = new SevenGoalPO();
            PlayerPOManager.put(ConstsTR.SevenGoal, player.getId(), (GEntity) this.sevenGoalPO);
        }
    }


    public LocalDateTime getStartDateTime() {
        Instant startInstant = null;
        try {
            startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
        } catch (Exception exception) {
        }
        LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
        startDateTime.toLocalDate().atTime(5, 0);
        if (GWorld.OPEN_SERVER_DATE.atTime(5, 0).isAfter(startDateTime)) {
            startDateTime = GWorld.OPEN_SERVER_DATE.atTime(5, 0);
        }
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return getStartDateTime().plus(GlobalConfig.SevenGoal_Continued, ChronoUnit.HOURS);
    }

    public boolean isActive() {
        Instant startInstant = null;
        try {
            startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());
        startDateTime.toLocalDate().atTime(5, 0);

        if (GWorld.OPEN_SERVER_DATE.atTime(5, 0).isAfter(startDateTime)) {
            startDateTime = GWorld.OPEN_SERVER_DATE.atTime(5, 0);
        }

        int durationHour = GlobalConfig.SevenGoal_Continued;
        LocalDateTime endDateTime = startDateTime.plus(durationHour, ChronoUnit.HOURS);


        if (LocalDateTime.now().isBefore(startDateTime)) {
            return false;
        }
        if (LocalDateTime.now().isAfter(endDateTime)) {
            return false;
        }
        return true;
    }

    private int getDayId() {
        Instant startInstant = null;
        try {
            startInstant = DateUtils.parse(GlobalConfig.SevenGoal_Begin, "yyyy-MM-dd HH:mm:ss").toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDate startDate = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault()).toLocalDate();


        if (GWorld.OPEN_SERVER_DATE.isAfter(startDate)) {
            startDate = GWorld.OPEN_SERVER_DATE;
        }


        return (int) ChronoUnit.DAYS.between(startDate, LocalDate.now()) + 1;
    }


    public void checkData() {
        if (GlobalConfig.SevenGoal_CurrentTurn != this.sevenGoalPO.currentTurn) {
            this.sevenGoalPO.reset(GlobalConfig.SevenGoal_CurrentTurn);
            initData();
        }
    }


    public SevenGoalHandler.GetSevenGoalResponse.Builder getSevenGoal() {
        checkData();

        SevenGoalHandler.GetSevenGoalResponse.Builder builder = SevenGoalHandler.GetSevenGoalResponse.newBuilder();


        for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
            SevenGoalHandler.DayInfo.Builder dayinfoBuilder = SevenGoalHandler.DayInfo.newBuilder();
            dayinfoBuilder.setDayId(dayInfo.dayId);


            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                SevenGoalHandler.TaskInfo.Builder taskInfoBuilder = SevenGoalHandler.TaskInfo.newBuilder();

                taskInfoBuilder.setTaskId(taskInfo.taskId);
                taskInfoBuilder.setFinishedNum(taskInfo.finishedNum);


                dayinfoBuilder.addTaskInfo(taskInfoBuilder);
            }
            dayinfoBuilder.setFetched(dayInfo.fetched);
            builder.addDayInfo(dayinfoBuilder);
        }
        builder.setCurrentDayId(getDayId());
        builder.setStartTimestamp(getStartDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
        builder.setEndTimestamp(getEndDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
        builder.setS2CCode(200);
        Out.error(new Object[]{builder});
        return builder;
    }

    public SevenGoalHandler.FetchAwardResponse.Builder fetchAward(int dayId) {
        checkData();

        SevenGoalHandler.FetchAwardResponse.Builder builder = SevenGoalHandler.FetchAwardResponse.newBuilder();

        if (!isActive()) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_INACTIVED"));
            return builder;
        }

        if (!this.sevenGoalPO.dayInfoMap.containsKey(Integer.valueOf(dayId))) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_PARAM_ERROR"));
            return builder;
        }

        if (dayId > getDayId()) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_PARAM_ERROR"));
            return builder;
        }

        DayInfo dayInfo = (DayInfo) this.sevenGoalPO.dayInfoMap.get(Integer.valueOf(dayId));


        if (dayInfo.fetched == true) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_FETCHED"));
            return builder;
        }

        boolean allFinished = true;
        for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
            SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
            if (taskInfo.finishedNum < sevDayTaskCO.targetNum) {
                allFinished = false;
                break;
            }
        }
        if (!allFinished) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("SEVEN_GOAL_NOT_FINISHED"));
            return builder;
        }
        dayInfo.fetched = true;
        Out.info(new Object[]{"玩家：", this.player.getId(), "  领取了七日目标奖励，dayId:", Integer.valueOf(dayId)});


        SevTaskRewardExt sevTaskRewardExt = (SevTaskRewardExt) GameData.SevTaskRewards.get(Integer.valueOf(dayInfo.dayId));

        List<NormalItem> rewards = new ArrayList<>();
        String[] rewardStrs = sevTaskRewardExt.reward.split(";");
        for (String rewardSubStr : rewardStrs) {
            String[] rewardSubStrs = rewardSubStr.split(":");
            rewards.addAll(ItemUtil.createItemsByItemCode(rewardSubStrs[0], Integer.parseInt(rewardSubStrs[1])));
        }
        this.player.bag.addCodeItemMail(rewards, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.SevenGoal, "Bag_full_common");


        builder.setS2CCode(200);


        updateSuperScript();

        return builder;
    }

    public void processGoal(SevenGoalTaskType taskType, Object... params) {
        if (!isActive()) {
            return;
        }
        checkData();
        int dayId = getDayId();


        boolean done = false;

        for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
                if (sevDayTaskCO.style != taskType.value) {
                    continue;
                }
                if (sevDayTaskCO.date > dayId && sevDayTaskCO.advancedDown == 0) {
                    continue;
                }
                if (taskInfo.finishedNum >= sevDayTaskCO.targetNum) {
                    continue;
                }


                switch (taskType) {
                    case MOUNT_UPGRADE_LV:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case SOLO_ANTICIPATE:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case ADD_FRIEND:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;


                    case PAY_COUNT:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case PET_UPGRADE_UPLV:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case EQUIP_STRENTHEN_COUNT:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case FIVE_MOUNTAIN_ANTICIPATE:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case COST_DIAMOND_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;


                    case FIGHTPOWER_TO:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;


                    case GEM_COMBINE_COUNT:
                        if (((Integer) params[0]).intValue() == sevDayTaskCO.numParameter1) {
                            taskInfo.finishedNum = Math.min(taskInfo.finishedNum + ((Integer) params[1]).intValue(), sevDayTaskCO.targetNum);
                            done = true;
                        }

                    case TRIAL_ANTICIPATE:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case COST_DIAMOND_OR_BINDDIAMOND_COUNT:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case EQUIP_REFINE_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case EQUIP_REBORN_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case EQUIP_REBUILD_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case DEMON_TOWER_COUNT:
                        taskInfo.finishedNum = Math.min(this.player.demonTowerManager.getMaxFloor() - 1, sevDayTaskCO.targetNum);
                        done = true;

                    case AREA_BOSS_KILL_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case LEVEL_TO:
                        taskInfo.finishedNum = Math.min(((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case XIANYUAN_TO:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + ((Integer) params[0]).intValue(), sevDayTaskCO.targetNum);
                        done = true;

                    case GUILD_BOSS_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;

                    case ILLUSION2_COUNT:
                        taskInfo.finishedNum = Math.min(taskInfo.finishedNum + 1, sevDayTaskCO.targetNum);
                        done = true;
                }


            }
        }
        if (done) {
            updateSuperScript();
        }
    }


    public void initData() {
        if (!isActive()) {
            return;
        }

        for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                int maxPetUpLv;
                SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
                SevTaskInsCO sevTaskInsCO = (SevTaskInsCO) GameData.SevTaskInss.get(Integer.valueOf(sevDayTaskCO.style));
                if (sevTaskInsCO.tip != 0) {
                    continue;
                }

                SevenGoalTaskType sevenGoalTaskType = SevenGoalTaskType.getType(sevDayTaskCO.style);
                switch (sevenGoalTaskType) {
                    case MOUNT_UPGRADE_LV:
                        taskInfo.finishedNum = Math.min(this.player.mountManager.getMountLevel(), sevDayTaskCO.targetNum);

                    case PET_UPGRADE_UPLV:
                        maxPetUpLv = this.player.petNewManager.getMaxPetUpLv();
                        taskInfo.finishedNum = Math.min(maxPetUpLv, sevDayTaskCO.targetNum);

                    case EQUIP_STRENTHEN_COUNT:
                        taskInfo.finishedNum = Math.min(this.player.equipManager.getTotalStrenthenLv(), sevDayTaskCO.targetNum);

                    case FIGHTPOWER_TO:
                        taskInfo.finishedNum = Math.min(this.player.getFightPower(), sevDayTaskCO.targetNum);

                    case DEMON_TOWER_COUNT:
                        taskInfo.finishedNum = Math.min(this.player.demonTowerManager.getMaxFloor() - 1, sevDayTaskCO.targetNum);

                    case LEVEL_TO:
                        taskInfo.finishedNum = Math.min(this.player.getLevel(), sevDayTaskCO.targetNum);
                }


            }
        }
        updateSuperScript();
    }


    public void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> data = getSuperScript();
        this.player.updateSuperScriptList(data);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();

        int day = getDayId();

        int totalCount = 0;
        for (DayInfo dayInfo : this.sevenGoalPO.dayInfoMap.values()) {
            if (dayInfo.dayId > day || dayInfo.fetched) {
                continue;
            }
            boolean allFinished = true;
            for (TaskInfo taskInfo : dayInfo.taskMap.values()) {
                SevDayTaskCO sevDayTaskCO = (SevDayTaskCO) GameData.SevDayTasks.get(Integer.valueOf(taskInfo.taskId));
                if (taskInfo.finishedNum < sevDayTaskCO.targetNum) {
                    allFinished = false;
                    break;
                }
            }
            if (allFinished) {
                totalCount++;
            }
        }
        PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
        t.setType(Const.SUPERSCRIPT_TYPE.SEVEN_GOAL.getValue());
        int count = 0;
        if (isActive()) {
            count = 1;
            if (totalCount > 0) {
                count = 2;
            }
        }
        t.setNumber(count);
        ret.add(t.build());

        return ret;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.SEVEN_GOAL;
    }
}


