package com.wanniu.game.rich;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtils;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.DateUtils;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ZillionaireCageCO;
import com.wanniu.game.data.ZillionaireFreeCO;
import com.wanniu.game.data.ext.ScheduleExt;
import com.wanniu.game.data.ext.TurnRewardExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DailyActivityPO;
import com.wanniu.game.poes.RichPO;
import com.wanniu.redis.PlayerPOManager;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.area.PlayerHandler;
import pomelo.rich.RichHandler;


public class RichManager
        extends ModuleManager {
    WNPlayer player;
    RichPO richPO;
    DailyActivityMgr dailyActivityMgr;

    public RichManager(WNPlayer player) {
        this.player = player;
    }

    public void init() {
        this.richPO = (RichPO) PlayerPOManager.findPO(ConstsTR.Rich, this.player.getId(), RichPO.class);
        if (this.richPO == null) {
            this.richPO = new RichPO();
            PlayerPOManager.put(ConstsTR.Rich, this.player.getId(), (GEntity) this.richPO);
        }

        this.dailyActivityMgr = this.player.dailyActivityMgr;
    }

    LocalDateTime getStartLocalDateTime() {
        Instant startInstant = null;
        try {
            startInstant = DateUtils.parse(GlobalConfig.Zillionaire_Open_Time, "yyyy-MM-dd HH:mm:ss").toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }

        LocalDateTime startLocalDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());

        if (GWorld.OPEN_SERVER_DATE.atTime(0, 0).isAfter(startLocalDateTime)) {
            startLocalDateTime = GWorld.OPEN_SERVER_DATE.atTime(0, 0);
        }

        return startLocalDateTime;
    }


    LocalDateTime getEndLocalDateTime() {
        LocalDateTime startDateTime = getStartLocalDateTime();
        int durationHour = GlobalConfig.Zillionaire_Continued_Time;
        return startDateTime.plus(durationHour, ChronoUnit.HOURS);
    }


    public boolean isActive() {
        Instant startInstant = null;
        try {
            startInstant = DateUtils.parse(GlobalConfig.Zillionaire_Open_Time, "yyyy-MM-dd HH:mm:ss").toInstant();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault());

        if (GWorld.OPEN_SERVER_DATE.atTime(0, 0).isAfter(startDateTime)) {
            startDateTime = GWorld.OPEN_SERVER_DATE.atTime(0, 0);
        }

        int durationHour = GlobalConfig.Zillionaire_Continued_Time;
        LocalDateTime endDateTime = startDateTime.plus(durationHour, ChronoUnit.HOURS);

        if (LocalDateTime.now().isBefore(startDateTime)) {
            return false;
        }
        if (LocalDateTime.now().isAfter(endDateTime)) {
            return false;
        }
        return true;
    }


    public void checkData() {
        if (this.richPO.currentTurn != GlobalConfig.Zillionaire_CurrentTurn) {
            this.richPO.reset(GlobalConfig.Zillionaire_CurrentTurn);
        }
    }


    public RichHandler.GetRichInfoResponse.Builder getRichInfo(String playerId) {
        RichHandler.GetRichInfoResponse.Builder builder = RichHandler.GetRichInfoResponse.newBuilder();

        checkData();

        if (!isActive()) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
            return builder;
        }

        for (ZillionaireFreeCO zillionaireFreeCO : GameData.ZillionaireFrees.values()) {
            RichHandler.TaskInfo.Builder taskInfoBuilder = RichHandler.TaskInfo.newBuilder();

            DailyActivityPO.DailyInfo info = this.player.dailyActivityMgr.getTaskInfo(zillionaireFreeCO.taskID);
            ScheduleExt scheduleExt = (ScheduleExt) GameData.Schedules.get(Integer.valueOf(zillionaireFreeCO.taskID));
            taskInfoBuilder.setSchName(scheduleExt.schName);
            taskInfoBuilder.setFinishedCount(info.process);
            taskInfoBuilder.setMaxCount(scheduleExt.maxCount);

            builder.addTaskInfo(taskInfoBuilder.build());
        }
        for (TurnRewardExt turnRewardExt : GameData.TurnRewards.values()) {
            RichHandler.TurnReward.Builder turnRewardBuilder = RichHandler.TurnReward.newBuilder();
            turnRewardBuilder.setTurnId(turnRewardExt.sort);

            for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) turnRewardExt.getRewardMap.entrySet()) {
                RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
                rewardBuilder.setCode(entry.getKey());
                rewardBuilder.setGroupCount(((Integer) entry.getValue()).intValue());

                turnRewardBuilder.addReward(rewardBuilder);
            }

            turnRewardBuilder.setState(((Integer) this.richPO.turnStatesMap.get(Integer.valueOf(turnRewardExt.sort))).intValue());

            builder.addTurnReward(turnRewardBuilder);
        }

        builder.setCurrentStep(this.richPO.currentStep);
        builder.setFreeCount(this.richPO.freeCount);


        builder.setStartTimestamp(getStartLocalDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
        builder.setEndTimestamp(getEndLocalDateTime().format(DateUtils.F_YYYYMMDDHHMMSS));
        builder.setS2CCode(200);

        return builder;
    }

    private int getRound() {
        int finishedRound = 0;
        for (Iterator<Integer> iterator = this.richPO.turnStatesMap.values().iterator(); iterator.hasNext(); ) {
            int state = ((Integer) iterator.next()).intValue();
            if (state != 0) {
                finishedRound++;
            }
        }


        return Math.min(GameData.TurnRewards.size(), finishedRound + 1);
    }

    public RichHandler.DiceResponse.Builder dice(String playerId) {
        RichHandler.DiceResponse.Builder builder = RichHandler.DiceResponse.newBuilder();

        checkData();

        if (!isActive()) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
            return builder;
        }

        if (this.richPO.freeCount > 0) {
            this.richPO.freeCount--;
            updateSuperScript();
        } else {
            if (!this.player.moneyManager.enoughDiamond(GlobalConfig.Zillionaire_Yuanbao_One)) {
                builder.setS2CCode(500);
                builder.setS2CMsg(LangService.getValue("RICH_NOT_ENOUGH_DIAMOND"));
                Out.error(new Object[]{builder});
                return builder;
            }
            this.player.moneyManager.costDiamond(GlobalConfig.Zillionaire_Yuanbao_One, Const.GOODS_CHANGE_TYPE.Rich);
        }


        int stepCount = GameData.ZillionaireCages.size();


        int randomStep = RandomUtil.getInt(1, 6);

        int newStep = (this.richPO.currentStep - 1 + randomStep) % stepCount + 1;

        if (this.richPO.currentStep + randomStep > stepCount) {
            int currentRound = getRound();

            if (((Integer) this.richPO.turnStatesMap.get(Integer.valueOf(currentRound))).intValue() == 0) {
                this.richPO.turnStatesMap.put(Integer.valueOf(currentRound), Integer.valueOf(1));
                updateSuperScript();
            }
        }


        this.richPO.currentStep = newStep;

        builder.setStep(randomStep);

        RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
        ZillionaireCageCO zillionaireCageCO = (ZillionaireCageCO) GameData.ZillionaireCages.get(Integer.valueOf(this.richPO.currentStep));
        rewardBuilder.setCode(zillionaireCageCO.itemCode);
        rewardBuilder.setGroupCount(zillionaireCageCO.nUM);

        this.player.bag.addCodeItemMail(zillionaireCageCO.itemCode, zillionaireCageCO.nUM, (zillionaireCageCO.isBind == 0) ? Const.ForceType.UN_BIND : Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.Rich, "Bag_full_common");


        builder.setS2CCode(200);
        builder.setReward(rewardBuilder);

        return builder;
    }

    public RichHandler.FetchTurnAwardResponse.Builder fetchTurnAward(String playerId, int turnId) {
        RichHandler.FetchTurnAwardResponse.Builder builder = RichHandler.FetchTurnAwardResponse.newBuilder();

        checkData();

        if (!isActive()) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_INACTIVED"));
            return builder;
        }

        if (!this.richPO.turnStatesMap.containsKey(Integer.valueOf(turnId))) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_TURN_ID_ERROR"));
            return builder;
        }

        int state = ((Integer) this.richPO.turnStatesMap.get(Integer.valueOf(turnId))).intValue();
        if (state == 0) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_TURN_NOT_FINISHED"));
            return builder;
        }
        if (state == 2) {
            builder.setS2CCode(500);
            builder.setS2CMsg(LangService.getValue("RICH_TURN_FETCHED"));
            return builder;
        }

        TurnRewardExt turnRewardExt = (TurnRewardExt) GameData.TurnRewards.get(Integer.valueOf(turnId));

        this.richPO.turnStatesMap.put(Integer.valueOf(turnId), Integer.valueOf(2));
        List<NormalItem> rewards = ItemUtil.createItemsByItemCode(turnRewardExt.getRewardMap);
        this.player.bag.addCodeItemMail(rewards, (turnRewardExt.isBind == 0) ? Const.ForceType.UN_BIND : Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.Rich, "Bag_full_common");


        for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) turnRewardExt.getRewardMap.entrySet()) {
            RichHandler.Reward.Builder rewardBuilder = RichHandler.Reward.newBuilder();
            rewardBuilder.setCode(entry.getKey());
            rewardBuilder.setGroupCount(((Integer) entry.getValue()).intValue());

            builder.addReward(rewardBuilder);
        }

        builder.setS2CCode(200);

        updateSuperScript();

        return builder;
    }


    public void AddFreeCount(int taskId) {
        if (!isActive()) {
            return;
        }

        for (ZillionaireFreeCO zillionaireFreeCO : GameData.ZillionaireFrees.values()) {
            if (zillionaireFreeCO.taskID == taskId) {
                if (this.richPO.freeCount < GlobalConfig.Zillionaire_FreeUp) {
                    this.richPO.freeCount++;

                    updateSuperScript();
                }
                return;
            }
        }
    }


    private int getFechableCount() {
        int count = 0;
        for (Iterator<Integer> iterator = this.richPO.turnStatesMap.values().iterator(); iterator.hasNext(); ) {
            int value = ((Integer) iterator.next()).intValue();
            if (value == 1) {
                count++;
            }
        }

        return count;
    }

    public void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> data = getSuperScript();
        this.player.updateSuperScriptList(data);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
        t.setType(Const.SUPERSCRIPT_TYPE.RICH.getValue());
        int count = 0;
        if (isActive()) {
            count = 1;
            if (this.richPO.freeCount > 0) {
                count = 2;
            }
            if (getFechableCount() > 0) {
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
        return Const.ManagerType.RICH;
    }
}


