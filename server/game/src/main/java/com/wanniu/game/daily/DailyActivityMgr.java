package com.wanniu.game.daily;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.attendance.PlayerAttendance;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ScheduleExt;
import com.wanniu.game.data.ext.VitBonusExt;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DailyActivityPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.rich.RichManager;
import com.wanniu.game.sevengoal.SevenGoalManager;
import io.netty.util.internal.StringUtil;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.DailyActivityHandler;
import pomelo.area.PlayerHandler;
import pomelo.dailyActivity.DailyActivity;


public class DailyActivityMgr {
    private String playerId;
    public DailyActivityPO po;
    private RichManager richManager;
    private SevenGoalManager sevenGoalManager;

    public enum ScheduleType {
        DEMON_INVADE(13), FIVE_MOUNTAIN(7), SOLO(6), TRIAL(8), ILLUSION2(15), GUILD_BOSS(16);

        private int value;

        ScheduleType(int value) {
            this.value = value;
        }


        public int getValue() {
            return this.value;
        }
    }


    protected DailyActivityMgr() {
    }


    public DailyActivityMgr(String playerId, DailyActivityPO po) {
        setPlayerId(playerId);
        this.po = po;
    }


    public void init(RichManager richManager, SevenGoalManager sevenGoalManager) {
        for (Integer id : GameData.Schedules.keySet()) {
            if (!this.po.activeMap.containsKey(id)) {
                DailyActivityPO.DailyInfo dailyInfo = new DailyActivityPO.DailyInfo();
                dailyInfo.id = id.intValue();
                dailyInfo.process = 0;
                this.po.activeMap.put(id, dailyInfo);
            }
        }

        for (Integer id : GameData.VitBonuss.keySet()) {
            if (!this.po.rewards.containsKey(id)) {
                DailyActivityPO.DailyRewardInfo reward = new DailyActivityPO.DailyRewardInfo();
                reward.id = id.intValue();
                reward.state = 0;
                this.po.rewards.put(id, reward);
            }
        }

        updateRewardState();

        this.richManager = richManager;
        this.sevenGoalManager = sevenGoalManager;
    }

    public void reset() {
        for (Integer id : this.po.activeMap.keySet()) {
            DailyActivityPO.DailyInfo info = (DailyActivityPO.DailyInfo) this.po.activeMap.get(id);
            if (null == info) {
                continue;
            }
            info.process = 0;
        }

        for (Integer id : this.po.rewards.keySet()) {
            DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo) this.po.rewards.get(id);
            if (null == reward) {
                continue;
            }
            reward.state = 0;
        }

        this.po.totalDegree = 0;
    }


    public void refreshNewDay() {
        reset();
    }


    public int getTimeState(int taskId) {
        int size = (getConfig(taskId)).timeArray.size();
        if (size > 0) {

            for (int j = 0; j < size; j++) {
                ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
                int timeState = DateUtil.isInTime(timeCond.beginTime, timeCond.endTime);
                if (Const.TimeState.TIME_NOT_UP.getValue() == timeState)
                    return Const.TimeState.TIME_NOT_UP.getValue();
                if (Const.TimeState.TIME_UP.getValue() == timeState) {
                    return Const.TimeState.TIME_UP.getValue();
                }
            }
            return Const.TimeState.TIME_OVER.getValue();
        }

        return Const.TimeState.TIME_UP.getValue();
    }


    public static int getTimeState2(int taskId) {
        int size = (getConfig(taskId)).periodInCalendarArray.size();
        if (size > 0) {

            for (int j = 0; j < size; j++) {
                ScheduleExt.TimeCond timeCond = (getConfig(taskId)).periodInCalendarArray.get(j);
                int timeState = DateUtil.isInTime2(timeCond.beginTime, timeCond.endTime);
                if (timeState == 1 || timeState == 2) {
                    return timeState;
                }
            }
            return 0;
        }

        return 2;
    }


    public DailyActivity.DailyInfo.Builder dailyToProto(int taskId) {
        DailyActivityPO.DailyInfo elem = (DailyActivityPO.DailyInfo) this.po.activeMap.get(Integer.valueOf(taskId));
        if (!isWeekSatisfy(taskId)) {
            return null;
        }

        DailyActivity.DailyInfo.Builder info = DailyActivity.DailyInfo.newBuilder();
        info.setId(taskId);
        info.setCurNum(elem.process);
        info.setMaxNum((getConfig(taskId)).maxCount);
        info.setPerDegree((getConfig(taskId)).vitBonus);
        info.setLvLimit((getConfig(taskId)).lvLimit);

        for (int j = 0; j < (getConfig(taskId)).timeArray.size(); j++) {
            ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
            int timeState = DateUtil.isInTime(timeCond.beginTime, timeCond.endTime);
            if (Const.TimeState.TIME_NOT_UP.getValue() == timeState) {
                String timeStr = timeCond.beginTime + "-" + timeCond.endTime;
                info.setOpenPeriod(timeStr);

                break;
            }
        }
        info.setIsOver(getTimeState(taskId));
        return info;
    }


    public List<DailyActivity.DailyInfo> getDailyLs() {
        List<DailyActivity.DailyInfo> dailyLs = new ArrayList<>();
        for (Integer taskId : this.po.activeMap.keySet()) {
            if (!isValid(taskId.intValue())) {
                continue;
            }
            DailyActivity.DailyInfo.Builder info = dailyToProto(taskId.intValue());
            if (null != info)
                dailyLs.add(info.build());
        }
        return dailyLs;
    }


    public List<DailyActivity.DegreeInfo> getDegreeLs() {
        updateRewardState();
        List<DailyActivity.DegreeInfo> degreeLs = new ArrayList<>();
        for (Integer id : this.po.rewards.keySet()) {
            DailyActivityPO.DailyRewardInfo elem = (DailyActivityPO.DailyRewardInfo) this.po.rewards.get(id);

            DailyActivity.DegreeInfo.Builder info = DailyActivity.DegreeInfo.newBuilder();
            info.setId(id.intValue());
            info.setNeedDegree((getVitBounsConfig(id.intValue())).reqVit);
            info.setState(elem.state);
            degreeLs.add(info.build());
        }
        return degreeLs;
    }


    public JSONObject getReward(int id) {
        JSONObject ret = new JSONObject();
        if (!this.po.rewards.containsKey(Integer.valueOf(id))) {
            ret.put("result", Integer.valueOf(-1));
            ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_EXIST"));
            return ret;
        }

        DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo) this.po.rewards.get(Integer.valueOf(id));
        if (null == reward) {
            ret.put("result", Integer.valueOf(-1));
            ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_EXIST"));
            return ret;
        }

        if (PlayerAttendance.GiftState.NO_RECEIVE.getValue() == reward.state) {
            ret.put("result", Integer.valueOf(-2));
            ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_RECEIVE"));
            return ret;
        }

        if (PlayerAttendance.GiftState.RECEIVED.getValue() == reward.state) {
            ret.put("result", Integer.valueOf(-3));
            ret.put("des", LangService.getValue("DAILY_ACTIVITY_RECEIVED"));
            return ret;
        }

        if (PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == reward.state) {
            reward.state = PlayerAttendance.GiftState.RECEIVED.getValue();
            ret.put("result", Integer.valueOf(0));
            ret.put("des", LangService.getValue("DAILY_ACTIVITY_SUCESS"));
            return ret;
        }

        ret.put("result", Integer.valueOf(-2));
        ret.put("des", LangService.getValue("DAILY_ACTIVITY_NOT_RECEIVE"));
        return ret;
    }


    public boolean isTaskExist(int taskId) {
        return this.po.activeMap.containsKey(Integer.valueOf(taskId));
    }


    public DailyActivityPO.DailyInfo getTaskInfo(int taskId) {
        return (DailyActivityPO.DailyInfo) this.po.activeMap.get(Integer.valueOf(taskId));
    }


    public boolean isWeekSatisfy(int taskId) {
        int w = CommonUtil.getWeek();
        ScheduleExt config = getConfig(taskId);
        if (null == config) {
            Out.error(new Object[]{"dailyActivityMgr config is error in Schedules.json--->>>", Integer.valueOf(taskId)});
            return false;
        }
        List<Integer> weekArray = config.weekArray;
        if (weekArray.size() > 0 && -1 == weekArray.indexOf(Integer.valueOf(w))) {
            return false;
        }
        return true;
    }


    public boolean isTimeSatisfy(int taskId) {
        if ((getConfig(taskId)).timeArray.isEmpty()) {
            return true;
        }
        for (int j = 0; j < (getConfig(taskId)).timeArray.size(); j++) {
            ScheduleExt.TimeCond timeCond = (getConfig(taskId)).timeArray.get(j);
            if (Const.TimeState.TIME_UP.getValue() == DateUtil.isInTime(timeCond.beginTime, timeCond.endTime)) {
                return true;
            }
        }
        return false;
    }


    public boolean isLvSatisfy(int taskId) {
        PlayerPO playerPO = PlayerUtil.getPlayerBaseData(getPlayerId());

        if (null == playerPO) {
            Out.error(new Object[]{"playerPO is null"});
            return false;
        }


        if (playerPO.level < (getConfig(taskId)).lvLimit) {
            Out.debug(new Object[]{"playerPO.level limit ->>>>", Integer.valueOf(playerPO.level), "config lv ->>>", Integer.valueOf((getConfig(taskId)).lvLimit)});
            return false;
        }
        return true;
    }

    public boolean isValid(int taskId) {
        ScheduleExt config = getConfig(taskId);
        if (null == config) {
            Out.error(new Object[]{"config is null-->>", Integer.valueOf(taskId)});
            return false;
        }

        return (1 == (getConfig(taskId)).isValid);
    }


    public boolean isSatisfyCond(int taskId) {
        if (!isWeekSatisfy(taskId)) {
            return false;
        }

        if (!isLvSatisfy(taskId)) {
            return false;
        }

        if (!isTimeSatisfy(taskId)) {
            return false;
        }
        return true;
    }


    public static ScheduleExt getConfig(int taskId) {
        return (ScheduleExt) GameData.Schedules.get(Integer.valueOf(taskId));
    }

    public VitBonusExt getVitBounsConfig(int id) {
        return (VitBonusExt) GameData.VitBonuss.get(Integer.valueOf(id));
    }


    public int getCanAddNum(int taskId, int num) {
        DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
        if (null == info) {
            return 0;
        }

        ScheduleExt config = getConfig(taskId);
        if (null == config) {
            return 0;
        }

        return Math.min(num, config.maxCount - info.process);
    }


    public void updatePush(int taskId) {
        WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
        if (null != player) {
            List<DailyActivity.DailyInfo> dailyLs = new ArrayList<>();
            dailyLs.add(dailyToProto(taskId).build());
            DailyActivityHandler.UpdateActivityPush.Builder dailyPush = DailyActivityHandler.UpdateActivityPush.newBuilder();
            dailyPush.addAllS2CDailyLs(dailyLs);
            dailyPush.setS2CTotalDegree(this.po.totalDegree);
            dailyPush.addAllS2CDegreeLs(getDegreeLs());
            player.receive("area.dailyActivityPush.updateActivityPush", (GeneratedMessage) dailyPush.build());
        }
    }

    public void updateRewardState() {
        for (Integer key : this.po.rewards.keySet()) {
            DailyActivityPO.DailyRewardInfo reward = (DailyActivityPO.DailyRewardInfo) this.po.rewards.get(key);
            if (null == reward || PlayerAttendance.GiftState.RECEIVED.getValue() == reward.state) {
                continue;
            }

            if (this.po.totalDegree >= (getVitBounsConfig(reward.id)).reqVit) {
                reward.state = PlayerAttendance.GiftState.CAN_RECEIVE.getValue();

                continue;
            }
            reward.state = PlayerAttendance.GiftState.NO_RECEIVE.getValue();
        }
    }


    public void doProcess(int taskId, int num) {
        if (isTaskExist(taskId)) {
            DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
            if (null != info && isSatisfyCond(taskId)) {
                int canAddNum = getCanAddNum(taskId, num);
                info.process += canAddNum;

                ScheduleExt config = getConfig(taskId);
                if (null == config) {
                    Out.error(new Object[]{"config is null-->>", Integer.valueOf(taskId)});
                    return;
                }
                this.po.totalDegree += canAddNum * config.vitBonus;
                if (canAddNum > 0) {

                    updatePush(taskId);
                    updateRewardState();
                    updateSuperScript();

                    if (isComplete(taskId)) {
                        this.richManager.AddFreeCount(taskId);
                    }
                }


                WNPlayer player = PlayerUtil.getOnlinePlayer(getPlayerId());
                if (player != null) {
                    player.taskManager.dealTaskEvent(Const.TaskType.ACTIVITY_NUM, canAddNum * config.vitBonus);
                }
            }
        }
    }


    public boolean isComplete(int taskId) {
        DailyActivityPO.DailyInfo info = getTaskInfo(taskId);
        if (null == info) {
            Out.error(new Object[]{"DailyInfo is null", info});
            return false;
        }

        if ((getConfig(taskId)).maxCount <= 0) {
            return false;
        }
        return (info.process >= (getConfig(taskId)).maxCount);
    }

    public boolean dailyAPI(Const.DailyType type, String target, ScheduleExt task) {
        if (StringUtil.isNullOrEmpty(target)) {
            return (task.type == type.value);
        }

        return (task.type == type.value && -1 != task.targetArray.indexOf(target));
    }


    public int[] findTaskId(Const.DailyType type, String id) {
        List<ScheduleExt> ls = GameData.findSchedules(o -> dailyAPI(type, id, o));


        int[] ids = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            ids[i] = ((ScheduleExt) ls.get(i)).schID;
        }

        return ids;
    }


    public void onEvent(Const.DailyType type, String target, int num) {
        int[] taskIds = findTaskId(type, target);
        for (int i = 0; i < taskIds.length; i++) {
            int taskId = taskIds[i];
            if (!isTaskExist(taskId)) {
                return;
            }
            if (isSatisfyCond(taskId) && !isComplete(taskId)) {
                doProcess(taskId, num);
            }
        }
    }


    public void onLogin() {
        updateSuperScript();
    }

    public void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> data = getSuperScript();
        PlayerUtil.getOnlinePlayer(getPlayerId()).updateSuperScriptList(data);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> ret = new ArrayList<>();

        int sum = 0;
        for (Integer id : this.po.rewards.keySet()) {
            DailyActivityPO.DailyRewardInfo elem = (DailyActivityPO.DailyRewardInfo) this.po.rewards.get(id);
            if (PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == elem.state) {
                sum++;
            }
        }

        PlayerHandler.SuperScriptType.Builder t = PlayerHandler.SuperScriptType.newBuilder();
        t.setType(Const.SUPERSCRIPT_TYPE.ACTIVITY_CENTER.getValue());
        t.setNumber(sum);
        ret.add(t.build());

        PlayerHandler.SuperScriptType.Builder sst = PlayerHandler.SuperScriptType.newBuilder();
        sst.setType(Const.SUPERSCRIPT_TYPE.FLAG_ACTIVITY_ACIVITY.getValue());
        sst.setNumber(sum);
        ret.add(sst.build());

        ScheduleExt scheduleExt = getConfig(ScheduleType.DEMON_INVADE.value);
        int timeState = getTimeState2(scheduleExt.schID);
        PlayerHandler.SuperScriptType.Builder yzrq = PlayerHandler.SuperScriptType.newBuilder();
        yzrq.setType(Const.SUPERSCRIPT_TYPE.DEMON_INVADE_ACTIVED.getValue());
        yzrq.setNumber(timeState);
        ret.add(yzrq.build());

        scheduleExt = getConfig(ScheduleType.FIVE_MOUNTAIN.value);
        timeState = getTimeState2(scheduleExt.schID);
        PlayerHandler.SuperScriptType.Builder f2f = PlayerHandler.SuperScriptType.newBuilder();
        f2f.setType(Const.SUPERSCRIPT_TYPE.FIVE_MOUNTAIN_ACTIVED.getValue());
        f2f.setNumber(timeState);
        ret.add(f2f.build());

        scheduleExt = getConfig(ScheduleType.SOLO.value);
        timeState = getTimeState2(scheduleExt.schID);
        PlayerHandler.SuperScriptType.Builder solo = PlayerHandler.SuperScriptType.newBuilder();
        solo.setType(Const.SUPERSCRIPT_TYPE.SOLO_ACTIVED.getValue());
        solo.setNumber(timeState);
        ret.add(solo.build());

        scheduleExt = getConfig(ScheduleType.TRIAL.value);
        timeState = getTimeState2(scheduleExt.schID);
        PlayerHandler.SuperScriptType.Builder trial = PlayerHandler.SuperScriptType.newBuilder();
        trial.setType(Const.SUPERSCRIPT_TYPE.TRIAL_ACTIVIED.getValue());
        trial.setNumber(timeState);
        ret.add(trial.build());


        PlayerHandler.SuperScriptType.Builder illusion2 = PlayerHandler.SuperScriptType.newBuilder();
        illusion2.setType(Const.SUPERSCRIPT_TYPE.ILLUSION2.getValue());
        illusion2.setNumber(calIllusion2ScriptNum());
        ret.add(illusion2.build());


        scheduleExt = getConfig(ScheduleType.GUILD_BOSS.value);
        timeState = getTimeState2(scheduleExt.schID);
        PlayerHandler.SuperScriptType.Builder guild_boss = PlayerHandler.SuperScriptType.newBuilder();
        guild_boss.setType(Const.SUPERSCRIPT_TYPE.GUILD_BOSS2.getValue());
        guild_boss.setNumber(timeState);
        ret.add(guild_boss.build());

        return ret;
    }


    public int calIllusion2ScriptNum() {
        return getTimeState2(ScheduleType.ILLUSION2.value);
    }


    public static int getCloseIllusion2Second() {
        List<ScheduleExt.TimeCond> times = (getConfig(ScheduleType.ILLUSION2.value)).periodInCalendarArray;
        if (times.isEmpty()) {
            return 1;
        }

        for (ScheduleExt.TimeCond timeCond : times) {
            if (DateUtil.isInTime2(timeCond.beginTime, timeCond.endTime) == 2) {
                String[] ts = timeCond.endTime.split(":");
                int hour = Integer.parseInt(ts[0]);
                int minute = Integer.parseInt(ts[1]);
                int second = (ts.length == 3) ? Integer.parseInt(ts[2]) : 0;
                LocalTime now = LocalTime.now();
                LocalTime end = LocalTime.of(hour, minute, second);
                return Math.max(1, (int) Duration.between(now, end).getSeconds());
            }
        }
        return 1;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}


