package com.wanniu.game.activity;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.AddRechargeLimitCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.RevelryCO;
import com.wanniu.game.data.StartSerRechargeCO;
import com.wanniu.game.data.ext.ActivityConfigExt;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ContinuousRechargePO;
import com.wanniu.game.poes.RechargeActivityPO;
import com.wanniu.game.poes.RevelryRechargePO;
import com.wanniu.game.poes.SingleRechargePO;
import com.wanniu.game.poes.TotalConsumePO;
import com.wanniu.game.poes.TotalRechargePO;
import com.wanniu.redis.PlayerPOManager;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;


public class RechargeActivityService {
    private static final RechargeActivityService instance = new RechargeActivityService();

    private static final int STATE_NOT_COMPLETE = 0;

    private static final int STATE_COMPLETED = 1;

    private static final int STATE_RECEIVED = 2;

    public static RechargeActivityService getInstance() {
        return instance;
    }


    public void onPayEvent(String playerId, int todayPayRmb, int payRmb) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        long now = System.currentTimeMillis();


        if (inContinuousTime(now)) {
            onContinuousRecharge(playerId, po, todayPayRmb);
        }


        if (inSingleTime(now)) {
            onSingleRecharge(playerId, po, payRmb);
        }


        if (inActvityTime(Const.ActivityRewardType.TOTAL_PAY, now)) {
            onTotalRecharge(playerId, po, payRmb);
        }


        if (inRevelayTime()) {
            onRevelryRecharge(playerId, po, todayPayRmb);
        }
    }


    public void onConsumeEvent(String playerId, int value) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        long now = System.currentTimeMillis();


        if (inActvityTime(Const.ActivityRewardType.TOTAL_CONSUME, now)) {
            onTotalConsume(playerId, po, value);
        }
    }

    private void onTotalConsume(String playerId, RechargeActivityPO po, int value) {
        refreshTotalConsumePO(playerId, po);
        TotalConsumePO info = po.totalConsume;
        info.setRmb(info.getRmb() + value);
        Out.info(new Object[]{"累计消耗金额变更 playerId=", playerId, ", rmb=", Integer.valueOf(info.getRmb())});
    }

    private void refreshTotalConsumePO(String playerId, RechargeActivityPO po) {
        if (po.totalConsume == null || !inActvityTime(Const.ActivityRewardType.TOTAL_CONSUME, po.totalConsume.getDate().getTime())) {
            Out.info(new Object[]{"重置累计消耗PO playerId=", playerId, ", po=", JSON.toJSONString(po.totalConsume)});
            po.totalConsume = new TotalConsumePO();
            po.totalConsume.setDate(new Date());
            po.totalConsume.setRmb(0);
        }
    }

    public int getTotalConsumeValue(String playerId) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        if (po.totalConsume == null) {
            return 0;
        }
        refreshTotalConsumePO(playerId, po);
        return po.totalConsume.getRmb();
    }

    private void onTotalRecharge(String playerId, RechargeActivityPO po, int payRmb) {
        refreshTotalRechargePO(playerId, po);
        TotalRechargePO info = po.totalRecharge;
        info.setRmb(info.getRmb() + payRmb);
        Out.info(new Object[]{"累计充值金额变更 playerId=", playerId, ", rmb=", Integer.valueOf(info.getRmb())});
    }


    private void refreshTotalRechargePO(String playerId, RechargeActivityPO po) {
        if (po.totalRecharge == null || !inActvityTime(Const.ActivityRewardType.TOTAL_PAY, po.totalRecharge.getDate().getTime())) {
            Out.info(new Object[]{"重置累计充值PO playerId=", playerId, ", po=", JSON.toJSONString(po.totalRecharge)});
            po.totalRecharge = new TotalRechargePO();
            po.totalRecharge.setDate(new Date());
            po.totalRecharge.setRmb(0);
        }
    }

    public int getTotalPayValue(String playerId) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        if (po.totalRecharge == null) {
            return 0;
        }
        refreshTotalRechargePO(playerId, po);
        return po.totalRecharge.getRmb();
    }


    private boolean inActvityTime(Const.ActivityRewardType type, long time) {
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == type.getValue()));
        if (props.isEmpty()) {
            return false;
        }
        ActivityExt activityExt = props.get(0);
        if (activityExt == null) {
            return false;
        }
        if (activityExt.beginTime > time) {
            return false;
        }
        if (activityExt.endTime < time) {
            return false;
        }
        return true;
    }

    private void onContinuousRecharge(String playerId, RechargeActivityPO po, int rmb) {
        refreshContinuousRechargePO(po);

        ContinuousRechargePO info = po.continuousRecharge;

        if (((Integer) info.getState().getOrDefault(Integer.valueOf(info.getDay()), Integer.valueOf(0))).intValue() == 0) {
            AddRechargeLimitCO template = getAddRechargeLimitCO(info.getDay());

            if (template != null && template.rechargeLimit * 100 <= rmb) {
                info.getState().put(Integer.valueOf(info.getDay()), Integer.valueOf(1));
                info.setDate(new Date());


                boolean flag = true;
                for (AddRechargeLimitCO temlate : GameData.AddRechargeLimits.values()) {
                    if (((Integer) po.continuousRecharge.getState().getOrDefault(Integer.valueOf(temlate.addTime), Integer.valueOf(0))).intValue() == 0) {
                        flag = false;

                        break;
                    }
                }
                if (flag) {
                    info.getState().put(Integer.valueOf(0), Integer.valueOf(1));
                }


                WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
                if (player != null) {
                    player.updateSuperScript(Const.SUPERSCRIPT_TYPE.CONTINUOUS_RECHARGE, 2);
                }
            }
        }
    }

    private AddRechargeLimitCO getAddRechargeLimitCO(int day) {
        List<AddRechargeLimitCO> ts = GameData.findAddRechargeLimits(v -> (day == v.addTime));
        if (!ts.isEmpty()) {
            return ts.get(0);
        }
        return null;
    }


    private void refreshContinuousRechargePO(RechargeActivityPO po) {
        if (po.continuousRecharge == null || !inContinuousTime(po.continuousRecharge.getDate().getTime())) {
            po.continuousRecharge = new ContinuousRechargePO();
            po.continuousRecharge.setDate(new Date());
            po.continuousRecharge.setDay(1);
            po.continuousRecharge.setState(new HashMap<>());
        } else {
            ContinuousRechargePO info = po.continuousRecharge;

            if (((Integer) info.getState().getOrDefault(Integer.valueOf(info.getDay()), Integer.valueOf(0))).intValue() > 0 &&
                    !DateUtils.isSameDay(info.getDate(), new Date())) {
                info.setDate(new Date());
                info.setDay(info.getDay() + 1);
            }
        }
    }


    public RechargeActivityPO getRechargeActivityPO(String playerId) {
        RechargeActivityPO po = (RechargeActivityPO) PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
        if (po == null) {
            po = new RechargeActivityPO();
            PlayerPOManager.put(ConstsTR.playerRechargeActivityTR, playerId, (GEntity) po);
        }
        return po;
    }


    public Map<Integer, Integer> getContinuousRechargeInfo(String playerId) {
        if (!inContinuousTime(System.currentTimeMillis())) {
            return Collections.emptyMap();
        }

        RechargeActivityPO po = getRechargeActivityPO(playerId);
        refreshContinuousRechargePO(po);


        return po.continuousRecharge.getState();
    }


    public int getContinuousRechargeDay(String playerId) {
        if (!inContinuousTime(System.currentTimeMillis())) {
            return 0;
        }

        RechargeActivityPO po = getRechargeActivityPO(playerId);
        refreshContinuousRechargePO(po);

        return po.continuousRecharge.getDay();
    }

    private boolean inContinuousTime(long time) {
        int day = getOpenServerDay();
        return (0 < day && day <= 7);
    }


    public PomeloResponse receiveContinuousRecharge(WNPlayer player, int day) {
        String reward;
        RechargeActivityPO po = getRechargeActivityPO(player.getId());
        if (po == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        if (po.continuousRecharge == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        if (((Integer) po.continuousRecharge.getState().getOrDefault(Integer.valueOf(day), Integer.valueOf(0))).intValue() != 1) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        po.continuousRecharge.getState().put(Integer.valueOf(day), Integer.valueOf(2));
        Out.info(new Object[]{"领取连续充值奖励，playerId=", player.getId(), ", day=", Integer.valueOf(day)});


        if (day > 0) {
            AddRechargeLimitCO template = getAddRechargeLimitCO(day);
            reward = template.rechargeFReward;
        } else {
            reward = GlobalConfig.AddRecharge_Reward;
        }

        List<NormalItem> result = new ArrayList<>();
        String[] strs1 = reward.split(",");
        for (String strs1_item : strs1) {
            String[] strs2 = strs1_item.split(":");
            result.addAll(ItemUtil.createItemsByItemCode(strs2[0], Integer.parseInt(strs2[1])));
        }
        player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.ContinuousRecharge, "Bag_full_common");


        onLogin(player);

        return null;
    }

    public Map<Integer, Integer> getSingleRechargeInfo(String playerId) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        refreshSingleRechargePO(po);

        return po.singleRecharge.getState();
    }


    private void refreshSingleRechargePO(RechargeActivityPO po) {
        if (po.singleRecharge == null || !inSingleTime(po.singleRecharge.getDate().getTime())) {
            po.singleRecharge = new SingleRechargePO();
            po.singleRecharge.setDate(new Date());
            po.singleRecharge.setState(new HashMap<>());
        }
    }

    private boolean inSingleTime(long time) {
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()));
        if (props.isEmpty()) {
            return false;
        }
        ActivityExt activityExt = props.get(0);
        if (activityExt == null) {
            return false;
        }
        if (activityExt.beginTime > time) {
            return false;
        }
        if (activityExt.endTime < time) {
            return false;
        }
        return true;
    }

    private void onSingleRecharge(String playerId, RechargeActivityPO po, int payRmb) {
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()));
        if (props.isEmpty()) {
            return;
        }
        ActivityExt activityExt = props.get(0);
        if (activityExt == null) {
            return;
        }
        List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID && payRmb == t.parameter1 * 100));
        if (activityConfigExts.isEmpty()) {
            return;
        }

        ActivityConfigExt template = activityConfigExts.get(0);

        refreshSingleRechargePO(po);

        SingleRechargePO info = po.singleRecharge;


        if (((Integer) info.getState().getOrDefault(Integer.valueOf(template.id), Integer.valueOf(0))).intValue() == 0) {
            info.getState().put(Integer.valueOf(template.id), Integer.valueOf(1));
            Out.info(new Object[]{"完成单笔充值活动 playerId=", playerId, ", id=", Integer.valueOf(template.id), ", rmb=", Integer.valueOf(payRmb)});

            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null) {
                player.activityManager.updateSuperScriptList();
            }
        }
    }

    public int getSingleRechargeRedPoint(String playerId) {
        RechargeActivityPO po = (RechargeActivityPO) PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
        if (po == null) {
            return 0;
        }
        if (po.singleRecharge == null) {
            return 0;
        }
        if (!inSingleTime(System.currentTimeMillis())) {
            return 0;
        }
        refreshSingleRechargePO(po);
        for (Integer i : po.singleRecharge.getState().values()) {
            if (i.intValue() == 1) {
                return 1;
            }
        }
        return 0;
    }

    public PomeloResponse receiveSingleRecharge(WNPlayer player, int id) {
        List<ActivityConfigExt> activityConfigExts = GameData.findActivityConfigs(t -> (t.id == id));
        if (activityConfigExts.isEmpty()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        RechargeActivityPO po = getRechargeActivityPO(player.getId());
        if (po == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        if (po.singleRecharge == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        if (((Integer) po.singleRecharge.getState().getOrDefault(Integer.valueOf(id), Integer.valueOf(0))).intValue() != 1) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }


        po.singleRecharge.getState().put(Integer.valueOf(id), Integer.valueOf(2));
        Out.info(new Object[]{"领取单笔充值奖励 playerId=", player.getId(), ", id=", Integer.valueOf(id)});

        ActivityConfigExt template = activityConfigExts.get(0);

        ArrayList<WNBag.SimpleItemInfo> reward = player.activityManager.getRankReward(template.RankReward);
        List<NormalItem> result = new ArrayList<>();
        for (WNBag.SimpleItemInfo sii : reward) {
            result.addAll(ItemUtil.createItemsByItemCode(sii.itemCode, sii.itemNum));
        }
        player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.SingleRecharge, "Bag_full_common");
        return null;
    }

    public void onLogin(WNPlayer player) {
        int value = 0;
        if (inContinuousTime(System.currentTimeMillis())) {
            value = 1;

            RechargeActivityPO po = getRechargeActivityPO(player.getId());
            refreshContinuousRechargePO(po);
            for (Iterator<Integer> iterator = po.continuousRecharge.getState().values().iterator(); iterator.hasNext(); ) {
                int v = ((Integer) iterator.next()).intValue();
                if (v == 1) {
                    value = 2;

                    break;
                }
            }

        }
        player.updateSuperScript(Const.SUPERSCRIPT_TYPE.CONTINUOUS_RECHARGE, value);
    }


    public int getOpenServerDay() {
        return (int) ChronoUnit.DAYS.between(GWorld.OPEN_SERVER_DATE, LocalDate.now()) + 1;
    }

    public Map<Integer, String> getAllColumn() {
        Map<Integer, String> result = new HashMap<>();
        for (StartSerRechargeCO template : GameData.StartSerRecharges.values()) {
            result.put(Integer.valueOf(template.date), template.showDate);
        }
        return result;
    }

    public RevelryRechargePO getRevelryRechargeInfo(String playerId, int day) {
        RechargeActivityPO po = getRechargeActivityPO(playerId);
        if (po.revelryRecharge == null) {
            return null;
        }
        return (RevelryRechargePO) po.revelryRecharge.get(Integer.valueOf(day));
    }

    private boolean inRevelayTime() {
        LocalDate openServerDate = GWorld.OPEN_SERVER_DATE;
        LocalDate now = LocalDate.now();
        return GameData.Revelrys.values().stream().filter(v -> (v.isOpen == 1 && now.isBefore(openServerDate.plusDays(v.endDays2)))).findFirst().isPresent();
    }

    private void onRevelryRecharge(String playerId, RechargeActivityPO po, int todayPayRmb) {
        refreshRevelryRechargePO(po);
        Integer day = Integer.valueOf(getOpenServerDay());
        RevelryRechargePO info = (RevelryRechargePO) po.revelryRecharge.get(day);
        if (info == null) {
            info = new RevelryRechargePO();
            info.setState(new HashMap<>());
            po.revelryRecharge.put(day, info);
        }
        info.setRmb(todayPayRmb);

        boolean flag = false;
        for (StartSerRechargeCO template : GameData.findStartSerRecharges(v -> (v.date == day.intValue()))) {
            if (info.getRmb() >= template.rechargeNumber * 100 && (
                    (Integer) info.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue() == 0) {
                info.getState().put(Integer.valueOf(template.iD), Integer.valueOf(1));
                flag = true;
            }
        }

        if (flag) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(playerId);
            if (player != null) {
                player.activityManager.updateSuperScriptList();
            }
        }
    }

    private void refreshRevelryRechargePO(RechargeActivityPO po) {
        if (po.revelryRecharge == null) {
            po.revelryRecharge = new HashMap<>();
        }
    }

    public PomeloResponse receiveRevelryRecharge(WNPlayer player, int id) {
        List<StartSerRechargeCO> templates = GameData.findStartSerRecharges(v -> (v.iD == id));
        if (templates.isEmpty()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        StartSerRechargeCO template = templates.get(0);
        if (template == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        RevelryRechargePO po = getRevelryRechargeInfo(player.getId(), template.date);
        if (po == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        if (((Integer) po.getState().getOrDefault(Integer.valueOf(template.iD), Integer.valueOf(0))).intValue() == 1) {
            po.getState().put(Integer.valueOf(template.iD), Integer.valueOf(2));
            Out.info(new Object[]{"领取开服狂欢的充值奖励，playerId=", player.getId(), ", day=", Integer.valueOf(template.date), ", id=", Integer.valueOf(template.iD)});

            List<NormalItem> result = new ArrayList<>();
            result.addAll(ItemUtil.createItemsByItemCode(template.reward1, template.num1));
            result.addAll(ItemUtil.createItemsByItemCode(template.reward2, template.num2));
            result.addAll(ItemUtil.createItemsByItemCode(template.reward3, template.num3));
            result.addAll(ItemUtil.createItemsByItemCode(template.reward4, template.num4));
            result.addAll(ItemUtil.createItemsByItemCode(template.reward5, template.num5));
            player.bag.addCodeItemMail(result, Const.ForceType.BIND, Const.GOODS_CHANGE_TYPE.RevelryRecharge, "Bag_full_common");
        }


        player.activityManager.updateSuperScriptList();
        return null;
    }

    public int getRevelryRechargeRedPoint(String playerId) {
        RechargeActivityPO po = (RechargeActivityPO) PlayerPOManager.findPO(ConstsTR.playerRechargeActivityTR, playerId, RechargeActivityPO.class);
        if (po == null) {
            return 0;
        }
        if (po.revelryRecharge == null) {
            return 0;
        }
        if (!inRevelayTime()) {
            return 0;
        }
        for (RevelryRechargePO p : po.revelryRecharge.values()) {
            for (Integer i : p.getState().values()) {
                if (i.intValue() == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}


