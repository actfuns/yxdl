package com.wanniu.game.activity;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.ClassUtil;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.activity.po.LuckyAward;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.chat.ChannelUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.daily.DailyActivityMgr;
import com.wanniu.game.data.ActivityCO;
import com.wanniu.game.data.ActivityConfigCO;
import com.wanniu.game.data.AdventureItemAddCO;
import com.wanniu.game.data.AdventureItemCO;
import com.wanniu.game.data.DrawCO;
import com.wanniu.game.data.ForgedRandomAddCO;
import com.wanniu.game.data.ForgedRandomCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GroupRandomAddCO;
import com.wanniu.game.data.GroupRandomCO;
import com.wanniu.game.data.LimitTimeGiftCO;
import com.wanniu.game.data.SevenLoginCO;
import com.wanniu.game.data.SuperPackageCO;
import com.wanniu.game.data.ext.ActivityConfigExt;
import com.wanniu.game.data.ext.ActivityExt;
import com.wanniu.game.data.ext.DrawExt;
import com.wanniu.game.data.ext.RecoveryExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ActivityDataPO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import pomelo.Common;
import pomelo.area.ActivityFavorHandler;
import pomelo.area.ActivityHandler;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


public class ActivityManager
        extends ModuleManager {
    private WNPlayer player;
    private ActivityDataPO opts;
    private int luckyAwardTotalRate;
    private Stack<Integer> cachedLimitTimeGiftStack;

    private static void SortActivityConfigExt(List<ActivityConfigExt> awardProps) {
        Collections.sort(awardProps, (o1, o2) -> o1.parameter1 - o2.parameter1);
    }

    public ActivityManager(WNPlayer player, ActivityDataPO opts) {
        this.player = player;
        this.opts = opts;
        _init();
        this.cachedLimitTimeGiftStack = new Stack<>();
    }

    private void _init() {
        if (this.opts.drawedContainer.size() == 0 && this.opts.luckyAwardContainer.size() == 0)
            refreshLuckyAwardContainer();
    }

    public static class ResultSuperScript {
        public Const.SUPERSCRIPT_TYPE type;
        public int number;
    }

    public ActivityDataPO toJson4Serialize() {
        return this.opts;
    }

    public ActivityExt findActivityByType(int type) {
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityTab == type));
        for (ActivityCO _prop : props) {
            ActivityExt prop = (ActivityExt) _prop;
            if (null != prop) {
                return prop;
            }
        }
        return null;
    }


    public List<ActivityConfigExt> findActivitieConfigsByRewardType(Const.ActivityRewardType activityRewardType) {
        ActivityExt activityExt = findActivityByType(activityRewardType.getValue());
        return GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
    }

    public ActivityExt findActivityById(int id) {
        List<ActivityExt> props = GameData.findActivitys(t -> (t.activityID == id));
        if (props.size() > 0) {
            ActivityExt prop = props.get(0);
            if (null != prop) {
                return prop;
            }
        }
        return null;
    }

    public boolean hasFirstPayReward() {
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.FIRST_PAY.getValue());
        if (prop == null) {
            return false;
        }
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        if (props.size() > 0) {
            return isReward(((ActivityConfigExt) props.get(0)).id);
        }
        return false;
    }


    public boolean isSecondPayVaild() {
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
        if (prop == null)
            return false;
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        for (ActivityConfigCO awardProp : awardProps) {
            if (!isReward(awardProp.id))
                return true;
        }
        return false;
    }

    public ActivityHandler.PayFirstResponse.Builder payFirst() {
        ActivityHandler.PayFirstResponse.Builder data = ActivityHandler.PayFirstResponse.newBuilder();
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.FIRST_PAY.getValue());
        if (prop == null) {
            return data;
        }
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        if (awardProps.size() > 0) {
            ActivityConfigExt awardProp = awardProps.get(0);
            if (!isReward(awardProp.id)) {
                data.setS2CAwardId(awardProp.id);
                ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
                ArrayList<ItemOuterClass.MiniItem> list = new ArrayList<>();
                for (WNBag.SimpleItemInfo item : reward) {
                    ItemOuterClass.MiniItem.Builder bi = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                    list.add(bi.build());
                }
                data.addAllS2CAwardItems(list);
                if (this.player.prepaidManager.getPayedTimes() > 0) {
                    data.setS2CState(1);
                }
            }
        }
        return data;
    }

    public ActivityHandler.PayFirstResponse.Builder paySecond() {
        ActivityHandler.PayFirstResponse.Builder data = ActivityHandler.PayFirstResponse.newBuilder();
        if (this.player.prepaidManager.getPayedTimes() < 1) {
            return data;
        }
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
        if (prop == null) {
            return data;
        }
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        SortActivityConfigExt(awardProps);
        int i = 0;
        for (ActivityConfigCO _awardProp : awardProps) {
            ActivityConfigExt awardProp = (ActivityConfigExt) _awardProp;
            if (!isReward(awardProp.id)) {
                data.setS2CAwardId(awardProp.id);
                ArrayList<ItemOuterClass.MiniItem> list = new ArrayList<>();
                ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
                for (WNBag.SimpleItemInfo item : reward) {
                    ItemOuterClass.MiniItem.Builder bi = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                    list.add(bi.build());
                }
                data.addAllS2CAwardItems(list);
                if (this.player.prepaidManager.isEachPayMoneyEnough(i + 1, awardProp.parameter1)) {
                    data.setS2CState(1);
                }

                break;
            }
            i++;
        }
        return data;
    }

    public ActivityHandler.totalInfo.Builder payTotal() {
        ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.TOTAL_PAY.getValue());
        if (prop == null) {
            data.setBeginTime("");
            data.setEndTime("");
            data.setDescribe("");
            return data;
        }
        data.setBeginTime(prop.openTime);
        data.setEndTime(prop.closeTime);
        data.setDescribe(prop.activityRule);

        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
        for (ActivityConfigCO _awardProp : awardProps) {
            ActivityConfigExt awardProp = (ActivityConfigExt) _awardProp;
            ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
            info.setAwardId(awardProp.id);
            ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
            info.setState(0);
            ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
            for (WNBag.SimpleItemInfo item : reward) {
                ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                list_item.add(_item.build());
            }
            info.addAllAwardItems(list_item);
            int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
            info.setCurrNum(allPrepaidMoney);
            info.setNeedNum(awardProp.parameter1);
            if (isReward(awardProp.id)) {
                info.setState(2);
            } else if (allPrepaidMoney >= awardProp.parameter1) {
                info.setState(1);
            }
            list.add(info.build());
        }
        data.addAllAwards(list);
        return data;
    }

    public ActivityHandler.totalInfo.Builder consumeTotal() {
        ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.TOTAL_CONSUME.getValue());
        if (prop == null) {
            data.setBeginTime("");
            data.setEndTime("");
            data.setDescribe("");
            return data;
        }
        data.setBeginTime(prop.openTime);
        data.setEndTime(prop.closeTime);
        data.setDescribe(prop.activityRule);
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
        for (ActivityConfigCO _awardProp : awardProps) {
            ActivityConfigExt awardProp = (ActivityConfigExt) _awardProp;
            ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
            info.setAwardId(awardProp.id);
            ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
            info.setState(0);
            ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
            for (WNBag.SimpleItemInfo item : reward) {
                ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                list_item.add(_item.build());
            }
            info.addAllAwardItems(list_item);
            int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
            info.setCurrNum(allConsumeMoney);
            info.setNeedNum(awardProp.parameter1);
            if (isReward(awardProp.id)) {
                info.setState(2);
            } else if (allConsumeMoney >= awardProp.parameter1) {
                info.setState(1);
            }
            list.add(info.build());
        }
        data.addAllAwards(list);
        return data;
    }

    public ActivityHandler.ActivityLevelOrSwordResponse.Builder levelOrSword(int activityId) {
        ActivityHandler.ActivityLevelOrSwordResponse.Builder datas = ActivityHandler.ActivityLevelOrSwordResponse.newBuilder();
        ActivityExt activity = findActivityById(activityId);
        if (activity == null)
            return datas;
        datas.setS2CBeginTime(activity.openTime);
        datas.setS2CBeginTime(activity.closeTime);
        datas.setS2CContent(activity.activityRule);
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activity.activityID));
        ArrayList<ActivityHandler.awardState> list = new ArrayList<>();
        for (ActivityConfigCO _prop : props) {
            ActivityConfigExt prop = (ActivityConfigExt) _prop;
            ActivityHandler.awardState.Builder info = ActivityHandler.awardState.newBuilder();
            info.setAwardId(prop.id);
            ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
            info.setState(Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue());
            info.setNeedValue(prop.parameter1);
            ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);
            for (WNBag.SimpleItemInfo item : reward) {
                ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                list_item.add(_item.build());
            }
            info.addAllAwardItems(list_item);
            int currNum = 0;
            if (activity.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
                currNum = this.player.getLevel();
            } else {
                currNum = (this.player.getPlayer()).fightPower;
            }

            if (isReward(prop.id)) {
                info.setState(Const.EVENT_GIFT_STATE.RECEIVED.getValue());
            } else if (currNum >= prop.parameter1) {
                info.setState(Const.EVENT_GIFT_STATE.CAN_RECEIVE.getValue());
            }
            list.add(info.build());
        }
        datas.addAllS2CData(list);

        return datas;
    }

    public ActivityHandler.ActivityOpenFundsRes.Builder openFunds() {
        ActivityHandler.ActivityOpenFundsRes.Builder datas = ActivityHandler.ActivityOpenFundsRes.newBuilder();
        datas.setS2CBuyState(1);
        ArrayList<ActivityHandler.openFundsAward> list = new ArrayList<>();
        ActivityExt activity = findActivityByType(Const.ActivityRewardType.FOUNDATION.getValue());
        if (activity == null) {
            datas.addAllS2CData(new ArrayList());
            return datas;
        }
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activity.activityID));
        Object<Integer, Integer> fund = (Object<Integer, Integer>) getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
        if (fund != null)
            datas.setS2CBuyState(2);
        for (ActivityConfigCO _prop : props) {
            ActivityHandler.openFundsAward.Builder _openFundsAward = ActivityHandler.openFundsAward.newBuilder();
            ActivityConfigExt prop = (ActivityConfigExt) _prop;
            ActivityHandler.awardState.Builder info = ActivityHandler.awardState.newBuilder();
            info.setAwardId(prop.id);
            info.setState(0);
            info.setNeedValue(0);
            ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
            int currNum = 0;
            ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);
            int parameter1 = prop.parameter1;
            for (WNBag.SimpleItemInfo item : reward) {
                _openFundsAward.setDiamond(item.itemNum);
                list_item.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
            }
            info.addAllAwardItems(list_item);
            if ("Activity_Fund".equals(prop.notes1)) {
                currNum = this.player.getLevel();
                _openFundsAward.setType(1);
            } else if ("Activity_Fund_UpLevel".equals(prop.notes1)) {
                if (parameter1 > 10000) {
                    parameter1 %= 10000;
                }
                currNum = this.player.player.upLevel;
                _openFundsAward.setType(1);
            } else {
                currNum = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
                _openFundsAward.setType(2);
            }
            if (isReward(prop.id)) {
                info.setState(2);
            } else if (currNum >= parameter1) {
                info.setState(1);
            } else {
                info.setState(0);
            }
            _openFundsAward.setAward(info.build());
            _openFundsAward.setValue(prop.parameter1);
            list.add(_openFundsAward.build());
        }
        datas.addAllS2CData(list);
        return datas;
    }

    public HashMap<Integer, Integer> getActivityInfo(int value) {
        return (HashMap<Integer, Integer>) this.opts.activityInfo.get(Integer.valueOf(value));
    }

    public void   (int id, HashMap<Integer, Integer> data) {
        this.opts.activityInfo.put(Integer.valueOf(id), data);
    }

    public static class RewardRecord {
        public int awardId;
        public Date awardTime;
    }

    public ActivityHandler.ActivityAwardResponse.Builder activityAward(int awardId, int activityId) {
        ActivityHandler.ActivityAwardResponse.Builder data = ActivityHandler.ActivityAwardResponse.newBuilder();
        data.setS2CCode(200);

        ActivityExt propCenter = findActivityById(activityId);
        if (propCenter == null) {
            data.setS2CCode(500);
            data.setS2CMsg(LangService.getValue("PARAM_ERROR"));
            return data;
        }
        if (propCenter.isOpen == 0) {
            data.setS2CCode(500);
            data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_OPEN"));
            return data;
        }

        if (propCenter.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue()) {
            if (!isReward(awardId)) {
                RewardRecord rr = new RewardRecord();
                rr.awardId = awardId;
                rr.awardTime = new Date();
                this.opts.activityRewardRecorder.put(Integer.valueOf(rr.awardId), rr);
            }
            return data;
        }
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.id == awardId));
        if (props.size() <= 0 || ((ActivityConfigExt) props.get(0)).type != activityId) {
            data.setS2CCode(500);
            data.setS2CMsg(LangService.getValue("PARAM_ERROR"));
            return data;
        }
        ActivityConfigExt prop = props.get(0);
        Const.GOODS_CHANGE_TYPE origin = getActivityDetailOrigin(propCenter.activityTab);

        if (propCenter.activityTab != Const.ActivityRewardType.HAOLI_CHANGE.getValue() &&
                isReward(awardId)) {
            data.setS2CCode(500);
            data.setS2CMsg(LangService.getValue("ACTIVITY_RECEIVE"));
            return data;
        }

        if (propCenter.activityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
            if (this.player.prepaidManager.getPayedTimes() == 0) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
            if (!isSecondAwardValid(awardId)) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
            int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
            if (allPrepaidMoney < prop.parameter1) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
            int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
            if (allConsumeMoney < prop.parameter1) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_REQUIRMENT"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
            if (this.player.getLevel() < prop.parameter1) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
            int power = (this.player.getPlayer()).fightPower;
            if (power < prop.parameter1) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_BATTLE"));
                return data;
            }
        } else if (propCenter.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
            if (getHaoliChangeState(prop) != Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
                data.setS2CCode(500);
                data.setS2CMsg(LangService.getValue("ACTIVITY_CHANGE_ITEM_NOT_ENOUGH"));
                return data;
            }
            ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(prop.costItems);
            List<WNBag.SimpleItemInfo> list = getRankReward(prop.RankReward);

            List<Common.KeyValueStruct> changeItems = new ArrayList<>();
            for (WNBag.SimpleItemInfo simpleItemInfo : list) {
                Common.KeyValueStruct.Builder items = Common.KeyValueStruct.newBuilder();
                items.setKey(simpleItemInfo.itemCode);
                items.setValue(String.valueOf(simpleItemInfo.itemNum));
                changeItems.add(items.build());
            }

            for (int i = 0; i < costItem.size(); i++) {
                if (((WNBag.SimpleItemInfo) costItem.get(i)).itemCode.equals("diamond")) {
                    this.player.moneyManager.costDiamond(((WNBag.SimpleItemInfo) costItem.get(i)).itemNum, origin, changeItems);
                } else if (((WNBag.SimpleItemInfo) costItem.get(i)).itemCode.equals("cash")) {
                    this.player.moneyManager.costTicket(((WNBag.SimpleItemInfo) costItem.get(i)).itemNum, origin, changeItems);
                } else if (((WNBag.SimpleItemInfo) costItem.get(i)).itemCode.equals("gold")) {
                    this.player.moneyManager.costGold(((WNBag.SimpleItemInfo) costItem.get(i)).itemNum, origin);
                } else {
                    this.player.bag.discardItem(((WNBag.SimpleItemInfo) costItem.get(i)).itemCode, ((WNBag.SimpleItemInfo) costItem.get(i)).itemNum, origin);
                }
            }
            HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());

            if (actInfo == null) {
                HashMap<Integer, Integer> actData = new HashMap<>();
                actData.put(Integer.valueOf(prop.id), Integer.valueOf(1));
                addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actData);
            } else if (actInfo.containsKey(Integer.valueOf(prop.id))) {
                actInfo.put(Integer.valueOf(prop.id), Integer.valueOf(((Integer) actInfo.get(Integer.valueOf(prop.id))).intValue() + 1));
                addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actInfo);
            } else {
                actInfo.put(Integer.valueOf(prop.id), Integer.valueOf(1));
                addActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue(), actInfo);
            }

        } else if (propCenter.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
            if (prop.notes1.equals("Activity_Fund") || prop.notes1.equals("Activity_Fund_UpLevel")) {
                HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
                if (actInfo == null) {
                    data.setS2CCode(500);
                    data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_BUYFUND"));
                    return data;
                }
                if (prop.notes1.equals("Activity_Fund")) {
                    int level = this.player.getLevel();
                    if (level < prop.parameter1) {
                        data.setS2CCode(500);
                        data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
                        return data;
                    }
                } else {
                    int level = this.player.player.upLevel;
                    int para = prop.parameter1 % 10000;
                    if (level < para) {
                        data.setS2CCode(500);
                        data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_LEVEL"));
                        return data;
                    }
                }
            } else {
                int buyCount = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
                if (buyCount < prop.parameter1) {
                    data.setS2CCode(500);
                    data.setS2CMsg(LangService.getValue("ACTIVITY_NOT_CONDITION"));
                    return data;
                }
            }
        }


        List<WNBag.SimpleItemInfo> reward = getRankReward(prop.RankReward);

        for (WNBag.SimpleItemInfo item : reward) {
            item.forceType = Const.ForceType.BIND;
        }

        if (this.player.bag.testAddCodeItems(reward, Const.ForceType.BIND, false)) {
            this.player.bag.addCodeItems(reward, origin);
        } else {
            data.setS2CCode(500);
            return data;
        }


        if (propCenter.activityTab != Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
            RewardRecord rr = new RewardRecord();
            rr.awardId = prop.id;
            rr.awardTime = new Date();
            this.opts.activityRewardRecorder.put(Integer.valueOf(prop.id), rr);
        }

        return data;
    }


    public Const.GOODS_CHANGE_TYPE getActivityDetailOrigin(int activityTab) {
        switch (Const.ActivityRewardType.valueOf(activityTab)) {

            case UPGRADE:
                return Const.GOODS_CHANGE_TYPE.ACTIVITY_LEVEL;

            case null:
                return Const.GOODS_CHANGE_TYPE.ACTIVITY_FIGHT_POEWR;

            case null:
                return Const.GOODS_CHANGE_TYPE.RECEIVE_FUNDS;

            case null:
                return Const.GOODS_CHANGE_TYPE.ACTIVITY_TOTAL_PAY;

            case null:
                return Const.GOODS_CHANGE_TYPE.ACTIVITY_TOTAL_CONSUME;

            case null:
                return Const.GOODS_CHANGE_TYPE.exchange;

            case null:
                return Const.GOODS_CHANGE_TYPE.sign;

            case null:
                return Const.GOODS_CHANGE_TYPE.ActivityDraw;


            case null:
                return Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE;


            case null:
                return Const.GOODS_CHANGE_TYPE.recovered;

            case null:
                return Const.GOODS_CHANGE_TYPE.DailyRecharge;


            case null:
                return Const.GOODS_CHANGE_TYPE.ActivityDrawSpring;
        }

        Out.error(new Object[]{"福利活动里的产出类型未配置. activityTab=", Integer.valueOf(activityTab)});
        return Const.GOODS_CHANGE_TYPE.def;
    }


    public boolean isSecondAwardValid(int awardId) {
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.SECOND_PAY.getValue());
        if (prop == null) {
            return false;
        }
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));

        SortActivityConfigExt(awardProps);
        for (int i = 0; i < awardProps.size(); i++) {
            ActivityConfigCO awardProp = (ActivityConfigCO) awardProps.get(i);
            if (awardProp.id == awardId) {
                return this.player.prepaidManager.isEachPayMoneyEnough(i + 1, awardProp.parameter1);
            }
        }
        return false;
    }

    public ActivityHandler.ActivityLuckyAwardViewResponse.Builder activityLuckyAwardView() {
        ActivityHandler.ActivityLuckyAwardViewResponse.Builder data = ActivityHandler.ActivityLuckyAwardViewResponse.newBuilder();
        List<DrawExt> props = GameData.findDraws(t -> (t.iD == Const.LuckyDrawType.RECOMMEND_ITEM.getValue()));
        if (props.size() > 0) {
            DrawExt prop = props.get(0);
            ArrayList<ItemOuterClass.MiniItem> arrayList = new ArrayList<>();
            for (DrawExt.DrawItem item : prop.items) {
                arrayList.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
            }
            data.addAllS2CAwards(arrayList);
        }
        Date now = new Date();
        int refreshInterval = GlobalConfig.Activity_LuckDraw;
        Calendar tmpTime = Calendar.getInstance();
        tmpTime.setTime(this.opts.refreshTime);
        tmpTime.set(11, 0);
        tmpTime.set(12, 0);
        tmpTime.set(13, 0);
        long diff = now.getTime() - tmpTime.getTimeInMillis();
        long intervalSecond = (refreshInterval * Const.Time.Day.getValue());
        if (diff > intervalSecond) {
            diff %= intervalSecond;
        }
        data.setS2CLeftRefreshTime((int) Math.floor(((intervalSecond - diff) / Const.Time.Second.getValue())));
        data.addAllS2CAwards(checkAwardDetail());

        ArrayList<ActivityHandler.awardInfo> list = new ArrayList<>();
        for (Integer pos : this.opts.drawedContainer.keySet()) {
            WNBag.SimpleItemInfo drawedAward = (WNBag.SimpleItemInfo) this.opts.drawedContainer.get(pos);
            ActivityHandler.awardInfo.Builder ab = ActivityHandler.awardInfo.newBuilder();
            ab.setPos(pos.intValue());
            ab.setItemInfo(ItemUtil.getMiniItemData(drawedAward.itemCode, drawedAward.itemNum).build());
        }
        return data;
    }

    public ArrayList<ItemOuterClass.MiniItem> checkAwardDetail() {
        ArrayList<ItemOuterClass.MiniItem> data = new ArrayList<>();
        for (LuckyAward luckyAward : this.opts.luckyAwardContainer) {
            data.add(ItemUtil.getMiniItemData(luckyAward.itemCode, luckyAward.itemNum).build());
        }
        for (WNBag.SimpleItemInfo drawedAward : this.opts.drawedContainer.values()) {
            data.add(ItemUtil.getMiniItemData(drawedAward.itemCode, drawedAward.itemNum).build());
        }
        return data;
    }

    public ArrayList<ItemOuterClass.MiniItem> luckyAwardView() {
        ArrayList<ItemOuterClass.MiniItem> data = new ArrayList<>();
        List<DrawExt> props = GameData.findDraws(t -> (t.iD == Const.LuckyDrawType.VIEW_ITEM.getValue()));
        if (props.size() > 0) {
            DrawExt prop = props.get(0);
            if (prop.items != null) {
                for (DrawExt.DrawItem item : prop.items) {
                    data.add(ItemUtil.getMiniItemData(item.itemCode, item.itemNum).build());
                }
            }
        }
        return data;
    }

    public void refreshNewDay() {
        refreshLuckyAwardContainer();
        refreshSevendayLogin();
        refreshRecovered();


        this.opts.refreshTime = this.player.player.refreshTime;


        this.player.prepaidManager.po.dailyChargeDiamond = 0;
        this.opts.daily_recharge_have_entered = false;
        this.opts.super_pakage_have_enterd = false;
        this.opts.daily_draw_free_time = 1;
        this.opts.daily_draw_free_time_add = 1;
        this.opts.dailyRechargeRecorder.clear();
        this.opts.superPackageRecorder.clear();
        for (Iterator<Integer> iterator = this.opts.timeLimitGiftPushMap.keySet().iterator(); iterator.hasNext(); ) {
            int key = ((Integer) iterator.next()).intValue();
            this.opts.timeLimitGiftPushMap.put(Integer.valueOf(key), Integer.valueOf(0));
        }

    }


    public ActivityHandler.ReSetluckyAwardResponse.Builder reSetluckyAward() {
        ActivityHandler.ReSetluckyAwardResponse.Builder data = ActivityHandler.ReSetluckyAwardResponse.newBuilder();
        int resetCost = GlobalConfig.Activity_LuckDrwa_Reset;
        if (!this.player.moneyManager.enoughDiamond(resetCost)) {
            data.setS2CCode(500);
            return data;
        }
        refreshLuckyAwardContainer();
        this.player.moneyManager.costDiamond(resetCost, Const.GOODS_CHANGE_TYPE.ActivityDraw);

        data.addAllS2CAwards(checkAwardDetail());
        return data;
    }

    public WNBag.SimpleItemInfo rateLuckyAward() {
        if (this.luckyAwardTotalRate <= 0) {
            return null;
        }
        int randRate = Utils.random(0, this.luckyAwardTotalRate - 1);
        int totalRate = 0;
        for (int i = 0; i < this.opts.luckyAwardContainer.size(); i++) {
            LuckyAward luckyAward = this.opts.luckyAwardContainer.get(i);
            if (this.opts.drawedContainer.size() + 1 >= luckyAward.round) {


                totalRate += luckyAward.itemRate;
                if (totalRate > randRate) {
                    WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                    item.index = i;
                    item.itemCode = luckyAward.itemCode;
                    item.itemNum = luckyAward.itemNum;
                    item.type = luckyAward.id;
                    return item;
                }
            }
        }
        return null;
    }

    public ArrayList<WNBag.SimpleItemInfo> getRankReward(HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> data) {
        if (data.containsKey(Integer.valueOf(0))) {
            return data.get(Integer.valueOf(0));
        }
        return data.get(Integer.valueOf(this.player.getPro()));
    }


    public boolean isReward(int id) {
        return this.opts.activityRewardRecorder.containsKey(Integer.valueOf(id));
    }


    public int getSumRedPointNum(List<PlayerHandler.SuperScriptType> ls) {
        int sum = 0;
        for (int i = 0; i < ls.size(); i++) {
            PlayerHandler.SuperScriptType elem = ls.get(i);
            if (null != elem) {

                sum += elem.getNumber();
            }
        }
        return sum;
    }


    public void onLogin() {
        updateDeskRedPoint();
    }


    public void updateDeskRedPoint() {
        List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
        int sum = 0;
        for (int i = 0; i < ls.size(); i++) {
            sum += ((PlayerHandler.SuperScriptType) ls.get(i)).getNumber();
        }

        this.player.updateSuperScript(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE, sum);
    }


    public void updateSuperScriptList() {
        List<PlayerHandler.SuperScriptType> ls = getSuperScriptList();
        updateDeskRedPoint();
        this.player.updateSuperScriptList(ls);
    }


    private PlayerHandler.SuperScriptType createSuperScriptType(int type, int num) {
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(type);
        data.setNumber(num);
        return data.build();
    }


    public List<PlayerHandler.SuperScriptType> getSuperScriptList() {
        List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
        ls.add(this.player.playerAttendance.getSuperScript());
        ls.add(this.player.onlineGiftManager.getSuperScript());

        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.ACTIVITY.getValue())) {
            return ls;
        }
        long now = System.currentTimeMillis();

        for (ActivityExt propCenter : GameData.Activitys.values()) {
            if (propCenter.isOpen == 0) {
                continue;
            }
            int scriptType = getRedpointValue(propCenter);
            boolean hasRedpoint = false;
            if (propCenter.beginTime == 0L || propCenter.endTime == 0L || propCenter.beginTime > now || now > propCenter.endTime) {
                continue;
            }
            if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue() && !hasFirstPayReward()) {
                continue;
            }
            if (propCenter.activityTab == Const.ActivityRewardType.LUCKY_REWARD.getValue()) {
                if (this.opts.drawedContainer.size() == 0) ;

                continue;
            }
            if (propCenter.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue()) {
                for (String key : ActivityNoticeService.getInstance().getNoticeKey()) {
                    if (!isReward(Integer.parseInt(key))) {
                        hasRedpoint = true;

                        break;
                    }
                }
            }

            if (propCenter.activityTab == Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue()) {
                boolean canGet = false;
                for (Iterator<Integer> iterator = this.opts.sevendayList.iterator(); iterator.hasNext(); ) {
                    int state = ((Integer) iterator.next()).intValue();
                    if (state == 1) {
                        canGet = true;
                        break;
                    }
                }

                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.OPEN_SERVER_DAY.getValue(), canGet ? 1 : 0));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.RECOVERY.getValue()) {
                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.RECOVERY.getValue(), hasRecoveryCount() ? 1 : 0));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.SUPER_PACKAGE.getValue()) {
                boolean enable = false;
                if (!this.opts.super_pakage_have_enterd) {
                    for (SuperPackageCO superPackageCO : GameData.SuperPackages.values()) {
                        if (!this.opts.superPackageRecorder.containsKey(Integer.valueOf(superPackageCO.iD))) {
                            enable = true;
                        }
                    }
                }

                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SUPER_PACKAGE.getValue(), enable ? 1 : 0));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.LUCK_DRAW.getValue()) {
                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.LUCKY_DRAW.getValue(), (this.opts.daily_draw_free_time > 0) ? 1 : 0));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.SPRING_DRAW.getValue()) {
                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SPRING_DRAW.getValue(), (this.opts.daily_draw_free_time_add > 0) ? 1 : 0));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.SINGLE_RECHARGE.getValue()) {
                int value = RechargeActivityService.getInstance().getSingleRechargeRedPoint(this.player.getId());
                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.SINGLE_RECHARGE.getValue(), value));

                continue;
            }

            if (propCenter.activityTab == Const.ActivityRewardType.REVELRY_RECHARGE.getValue()) {
                int value = RechargeActivityService.getInstance().getRevelryRechargeRedPoint(this.player.getId());
                ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.REVELRY_RECHARGE.getValue(), value));

                continue;
            }
            List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == propCenter.activityID));
            for (int awardIndex = 0; awardIndex < props.size(); awardIndex++) {
                ActivityConfigExt prop = props.get(awardIndex);
                if (propCenter.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
                    if (getHaoliChangeState(prop) == Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
                        hasRedpoint = true;

                        break;
                    }
                    continue;
                }
                if (propCenter.activityTab == Const.ActivityRewardType.DAILY_RECHARGE.getValue()) {

                    if (!this.opts.daily_recharge_have_entered) {
                        hasRedpoint = true;
                    }
                    if (this.player.prepaidManager.po.dailyChargeDiamond > prop.parameter1 &&
                            !this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(prop.id))) {
                        hasRedpoint = true;
                    }


                    continue;
                }

                if (isReward(prop.id)) {
                    continue;
                }

                if (propCenter.activityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
                    if (this.player.prepaidManager.getPayedTimes() == 0) {
                        continue;
                    }
                } else if (propCenter.activityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
                    if (!hasFirstPayReward()) {
                        break;
                    }
                    if (!isSecondAwardValid(prop.id)) {
                        continue;
                    }
                } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
                    int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());
                    if (allPrepaidMoney < prop.parameter1) {
                        break;
                    }
                } else if (propCenter.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
                    int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());
                    if (allConsumeMoney < prop.parameter1) {
                        break;
                    }
                } else if (propCenter.activityTab == Const.ActivityRewardType.LEVEL.getValue()) {
                    if (this.player.getLevel() < prop.parameter1) {
                        continue;
                    }
                } else if (propCenter.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
                    int power = (this.player.getPlayer()).fightPower;
                    if (power < prop.parameter1) {
                        break;
                    }
                    scriptType = Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_FC_GIFT.getValue();
                } else if (propCenter.activityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
                    if (prop.notes1.equals("Activity_Fund") || prop.notes1.equals("Activity_Fund_UpLevel")) {
                        HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
                        if (actInfo == null) {
                            continue;
                        }
                        if (prop.notes1.equals("Activity_Fund")) {
                            int level = this.player.getLevel();
                            if (level < prop.parameter1) {
                                continue;
                            }
                        } else {
                            int level = this.player.player.upLevel;
                            int para = prop.parameter1 % 10000;
                            if (level < para) {
                                break;
                            }
                        }
                    } else {
                        int buyCount = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
                        if (buyCount < prop.parameter1) {
                            break;
                        }
                    }
                } else {
                    break;
                }
                hasRedpoint = true;
            }

            if (scriptType > Const.SUPERSCRIPT_TYPE.MIN.getValue() && hasRedpoint) {
                ls.add(createSuperScriptType(scriptType, 1));
                continue;
            }
            ls.add(createSuperScriptType(scriptType, 0));
        }


        return ls;
    }

    private List<PlayerHandler.SuperScriptType> getLimitTimeSuperScript() {
        List<PlayerHandler.SuperScriptType> ls = new ArrayList<>();
        int minCount = 0;

        for (Map.Entry<Integer, Date> entry : (Iterable<Map.Entry<Integer, Date>>) this.opts.timeLimitGiftTriggeredTimeMap.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }

            int triggeredId = ((Integer) this.opts.timeLimitGiftTriggeredIdMap.get(entry.getKey())).intValue();

            if (triggeredId == -1) {
                continue;
            }

            LimitTimeGiftCO limitTimeGiftCO = (LimitTimeGiftCO) GameData.LimitTimeGifts.get(Integer.valueOf(triggeredId));


            if (((Integer) this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
                continue;
            }

            long offset = ((Date) entry.getValue()).getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
            int count = 0;
            if (offset > 0L) {
                count = (int) (offset / 1000L);
            }

            if (count > 0) {
                if (minCount == 0) {
                    minCount = count;
                    continue;
                }
                if (minCount > count) {
                    minCount = count;
                }
            }
        }


        ls.add(createSuperScriptType(Const.SUPERSCRIPT_TYPE.LIMIT_TIME_GIFT.getValue(), minCount));


        return ls;
    }


    public int getRedpointValue(ActivityExt ac) {
        if (ac.activityTab == Const.ActivityRewardType.TOTAL_PAY.getValue())
            return Const.SUPERSCRIPT_TYPE.TOTAL_PAY.getValue();
        if (ac.activityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue())
            return Const.SUPERSCRIPT_TYPE.TOTAL_CONSUME.getValue();
        if (ac.activityTab == Const.ActivityRewardType.LEVEL.getValue())
            return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_LV_GIFT.getValue();
        if (ac.activityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue())
            return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ROLE_FC_GIFT.getValue();
        if (ac.activityTab == Const.ActivityRewardType.FOUNDATION.getValue())
            return Const.SUPERSCRIPT_TYPE.FUNDS.getValue();
        if (ac.activityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue())
            return Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_EXCHANGE.getValue();
        if (ac.activityTab == Const.ActivityRewardType.GAME_NOTICE.getValue())
            return Const.SUPERSCRIPT_TYPE.GAME_NOTICE.getValue();
        if (ac.activityTab == Const.ActivityRewardType.DAILY_RECHARGE.getValue())
            return Const.SUPERSCRIPT_TYPE.DAILY_RECHARGE.getValue();
        if (ac.activityTab == Const.ActivityRewardType.SUPER_PACKAGE.getValue())
            return Const.SUPERSCRIPT_TYPE.SUPER_PACKAGE.getValue();
        if (ac.activityTab == Const.ActivityRewardType.LUCK_DRAW.getValue()) {
            return Const.SUPERSCRIPT_TYPE.LUCKY_DRAW.getValue();
        }

        return 0;
    }

    public int getActivityHud(int activityId, int ActivityTab) {
        int hintNum = 0;
        List<ActivityConfigExt> awards = GameData.findActivityConfigs(t -> (t.type == activityId));
        if (ActivityTab == Const.ActivityRewardType.LEVEL.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {
                    int para = this.player.getLevel();
                    if (item.parameter1 > 10000) {
                        int upLevel = item.parameter1 % 10000;
                        if (this.player.player.upLevel >= upLevel)
                            hintNum++;
                        continue;
                    }
                    if (para >= item.parameter1) {
                        hintNum++;
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.FIGHT_POEWR.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {
                    int para = (this.player.getPlayer()).fightPower;
                    if (para >= item.parameter1) {
                        hintNum++;
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.FOUNDATION.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {
                    int para = 0;
                    int needPara = item.parameter1;
                    if ("Activity_Fund".equals(item.notes1) || "Activity_Fund_UpLevel".equals(item.notes1)) {
                        HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.FOUNDATION.getValue());
                        if (actInfo != null) {
                            if ("Activity_Fund" == item.notes1) {
                                para = this.player.getLevel();
                            } else {
                                para = this.player.player.upLevel;
                                needPara %= 10000;
                            }
                        }
                    } else {
                        para = ActivityCenterManager.getIntance().getFundsNum(GWorld.__SERVER_ID);
                    }
                    if (para >= needPara) {
                        hintNum++;
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.FIRST_PAY.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id) &&
                        this.player.prepaidManager.getPayedTimes() > 0) {
                    hintNum++;
                }
            }

        } else if (ActivityTab == Const.ActivityRewardType.SECOND_PAY.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {
                    if (hasFirstPayReward()) {
                        if (isSecondAwardValid(item.id)) {
                            hintNum++;
                        }
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.TOTAL_PAY.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {
                    int allPrepaidMoney = RechargeActivityService.getInstance().getTotalPayValue(this.player.getId());

                    if (allPrepaidMoney >= item.parameter1) {
                        hintNum++;
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.TOTAL_CONSUME.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (!isReward(item.id)) {

                    int allConsumeMoney = RechargeActivityService.getInstance().getTotalConsumeValue(this.player.getId());

                    if (allConsumeMoney >= item.parameter1) {
                        hintNum++;
                    }
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.HAOLI_CHANGE.getValue()) {
            for (ActivityConfigCO item : awards) {
                if (getHaoliChangeState((ActivityConfigExt) item) == Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue()) {
                    hintNum++;
                }
            }
        } else if (ActivityTab == Const.ActivityRewardType.LUCKY_REWARD.getValue() &&
                this.opts.drawedContainer.size() == 0) {
            hintNum++;
        }

        return hintNum;
    }

    public void refreshLuckyAwardContainer() {
        this.opts.luckyAwardContainer = new ArrayList();
        Map<Integer, DrawExt> props = GameData.Draws;
        for (DrawCO _prop : props.values()) {
            DrawExt prop = (DrawExt) _prop;
            if (prop.iD == Const.LuckyDrawType.EXCELLENT_ITEM.getValue() || prop.iD == Const.LuckyDrawType.NORMAL_ITEM.getValue() || prop.iD == Const.LuckyDrawType.BUFF_ITEM.getValue()) {
                int tempTotalRate = prop.totalRate;
                ArrayList<DrawExt.DrawItem> tempItems = new ArrayList<>(prop.items);
                for (int i = 0; i < prop.itemNumber; i++) {
                    ResultRateEachAward result = rateEachAward(tempTotalRate, tempItems);
                    if (result != null) {

                        tempTotalRate -= result.itemRate;
                        tempItems.remove(result.index);
                        LuckyAward item = new LuckyAward();
                        item.itemCode = result.itemCode;
                        item.itemNum = result.itemNum;
                        item.itemRate = result.itemRate;
                        item.id = prop.iD;
                        item.round = prop.round;
                        this.opts.luckyAwardContainer.add(item);
                    }
                }
            }
        }
        this.opts.drawedContainer = new HashMap<>();
        this.opts.buffTimes = 1;

        calcLuckyAwardTotalRate();
    }

    public void calcLuckyAwardTotalRate() {
        this.luckyAwardTotalRate = 0;
        for (int i = 0; i < this.opts.luckyAwardContainer.size(); i++) {

            LuckyAward luckyAward = this.opts.luckyAwardContainer.get(i);

            if (this.opts.drawedContainer.size() + 1 >= luckyAward.round) {


                this.luckyAwardTotalRate += luckyAward.itemRate;
            }
        }
    }


    public static class ResultRateEachAward {
        public int index;


        public String itemCode;


        public int itemNum;


        public int itemRate;
    }


    public ResultRateEachAward rateEachAward(int totalRate, ArrayList<DrawExt.DrawItem> luckyAwardContainer) {
        if (totalRate <= 0) {
            return null;
        }
        int randRate = Utils.random(0, totalRate - 1);
        int addRate = 0;
        for (int i = 0; i < luckyAwardContainer.size(); i++) {
            DrawExt.DrawItem luckyAward = luckyAwardContainer.get(i);
            addRate += luckyAward.itemRate;
            if (addRate > randRate) {
                ResultRateEachAward result = new ResultRateEachAward();
                result.index = i;
                result.itemCode = luckyAward.itemCode;
                result.itemNum = luckyAward.itemNum;
                result.itemRate = luckyAward.itemRate;
                return result;
            }
        }
        return null;
    }


    private ArrayList<WNBag.SimpleItemInfo> getCostItem(HashMap<Integer, ArrayList<WNBag.SimpleItemInfo>> data) {
        if (data.containsKey(Integer.valueOf(0))) {
            return data.get(Integer.valueOf(0));
        }
        return data.get(Integer.valueOf(this.player.getPro()));
    }


    public int getHaoliChangeState(ActivityConfigExt activityConfigProp) {
        int key = activityConfigProp.id;
        if (activityConfigProp.parameter1 != 0) {
            HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
            if (actInfo != null && actInfo.get(Integer.valueOf(key)) != null && (
                    (Integer) actInfo.get(Integer.valueOf(key))).intValue() >= activityConfigProp.parameter1) {
                return Const.HAOLI_CHANGE_STATE.RECEIVED.getValue();
            }
        }

        int state = 0;
        ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(activityConfigProp.costItems);
        for (int j = 0; j < costItem.size(); j++) {
            WNBag.SimpleItemInfo item = costItem.get(j);
            if (item.itemCode.equals("diamond")) {
                if (this.player.moneyManager.enoughDiamond(item.itemNum)) {
                    state++;
                }
            } else if (item.itemCode.equals("cash")) {
                if (this.player.moneyManager.enoughTicket(item.itemNum)) {
                    state++;
                }
            } else if (item.itemCode.equals("gold")) {
                if (this.player.moneyManager.enoughGold(item.itemNum)) {
                    state++;
                }
            } else {
                int haveNum = this.player.bag.findItemNumByCode(item.itemCode);
                if (haveNum >= item.itemNum) {
                    state++;
                }
            }
        }
        if (costItem.size() == 0 || state != costItem.size()) {
            return Const.HAOLI_CHANGE_STATE.CANNOT_RECEIVE.getValue();
        }
        return Const.HAOLI_CHANGE_STATE.CAN_RECEIVE.getValue();
    }

    public ActivityHandler.OpenChangeResponse.Builder haoliChange() {
        ActivityHandler.OpenChangeResponse.Builder changeInfo = ActivityHandler.OpenChangeResponse.newBuilder();
        ArrayList<ActivityHandler.changeInfo> list_changeInfo = new ArrayList<>();
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
        if (prop == null) {
            return changeInfo;
        }
        changeInfo.setS2CBeginTime(prop.openTime);
        changeInfo.setS2CEndTime(prop.closeTime);
        changeInfo.setS2CContent(prop.activityRule);
        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        for (int i = 0; i < awardProps.size(); i++) {
            ActivityConfigExt p = awardProps.get(i);
            ArrayList<WNBag.SimpleItemInfo> costItem = getCostItem(p.costItems);
            ArrayList<WNBag.SimpleItemInfo> rewardItem = getRankReward(p.RankReward);
            if (costItem != null && rewardItem != null) {
                ActivityHandler.changeInfo.Builder changeData = ActivityHandler.changeInfo.newBuilder();
                changeData.setChangeId(p.id);
                ArrayList<ActivityHandler.changeItem> l_costItem = getChangeItemList(costItem);
                ArrayList<ActivityHandler.changeItem> l_rewardItem = getChangeItemList(rewardItem);
                changeData.addAllCostItem(l_costItem);
                changeData.addAllRewardItem(l_rewardItem);
                changeData.setChangeSate(getHaoliChangeState(p));

                int changeNum = 0;
                HashMap<Integer, Integer> actInfo = getActivityInfo(Const.ActivityRewardType.HAOLI_CHANGE.getValue());
                if (actInfo != null && actInfo.get(Integer.valueOf(p.id)) != null) {
                    changeNum = ((Integer) actInfo.get(Integer.valueOf(p.id))).intValue();
                }
                changeData.setChangeNum(changeNum);
                if (p.parameter1 != 0) {
                    changeData.setChangeMax(p.parameter1);
                }
                list_changeInfo.add(changeData.build());
            }
        }

        changeInfo.addAllS2CChangeInfo(list_changeInfo);
        return changeInfo;
    }

    private ArrayList<ActivityHandler.changeItem> getChangeItemList(ArrayList<WNBag.SimpleItemInfo> itemList) {
        ArrayList<ActivityHandler.changeItem> l = new ArrayList<>();
        for (WNBag.SimpleItemInfo info : itemList) {
            ActivityHandler.changeItem.Builder ib = ActivityHandler.changeItem.newBuilder();
            ib.setItemCode(info.itemCode);
            ib.setItemNum(info.itemNum);
            ib.setIsBind(info.forceType.getValue());
            l.add(ib.build());
        }
        return l;
    }


    public List<ActivityHandler.ActivityLs> getVailyActivityLs() {
        List<ActivityHandler.ActivityLs> ls = new ArrayList<>();
        for (ActivityExt t : GameData.Activitys.values()) {
            if (null == t) {
                continue;
            }

            if (Const.TimeState.TIME_UP.getValue() != DateUtil.isOutDate(t.openTime, t.closeTime) || t.isOpen == 0) {
                continue;
            }


            if (t.activityTab == Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue()) {
                boolean continueFlag = true;
                for (Iterator<Integer> iterator = this.opts.sevendayList.iterator(); iterator.hasNext(); ) {
                    int state = ((Integer) iterator.next()).intValue();
                    if (state != 2) {
                        continueFlag = false;
                        break;
                    }
                }

                if (continueFlag) {
                    continue;
                }
            }

            ActivityHandler.ActivityLs.Builder tmp = ActivityHandler.ActivityLs.newBuilder();
            tmp.setId(t.activityID);
            ls.add(tmp.build());
        }
        return ls;
    }

    public ActivityHandler.totalInfo.Builder DailyRecharge_Today() {
        ActivityHandler.totalInfo.Builder data = ActivityHandler.totalInfo.newBuilder();
        ActivityExt prop = findActivityByType(Const.ActivityRewardType.DAILY_RECHARGE.getValue());
        if (prop == null) {
            data.setBeginTime("");
            data.setEndTime("");
            data.setDescribe("");
            return data;
        }
        data.setBeginTime(prop.openTime);
        data.setEndTime(prop.closeTime);
        data.setDescribe(prop.activityRule);

        List<ActivityConfigExt> awardProps = GameData.findActivityConfigs(t -> (t.type == prop.activityID));
        ArrayList<ActivityHandler.awardPreview> list = new ArrayList<>();
        for (ActivityConfigCO _awardProp : awardProps) {
            ActivityConfigExt awardProp = (ActivityConfigExt) _awardProp;
            ActivityHandler.awardPreview.Builder info = ActivityHandler.awardPreview.newBuilder();
            info.setAwardId(awardProp.id);
            ArrayList<ItemOuterClass.MiniItem> list_item = new ArrayList<>();
            info.setState(0);
            ArrayList<WNBag.SimpleItemInfo> reward = getRankReward(awardProp.RankReward);
            for (WNBag.SimpleItemInfo item : reward) {
                ItemOuterClass.MiniItem.Builder _item = ItemUtil.getMiniItemData(item.itemCode, item.itemNum);
                list_item.add(_item.build());
            }
            info.addAllAwardItems(list_item);
            int todayPrepaidMoney = this.player.prepaidManager.getDailyCharge();
            info.setCurrNum(todayPrepaidMoney);
            info.setNeedNum(awardProp.parameter1);
            if (this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(awardProp.id))) {
                info.setState(2);
            } else if (todayPrepaidMoney >= awardProp.parameter1) {
                info.setState(1);
            }
            list.add(info.build());
        }
        data.addAllAwards(list);

        this.opts.daily_recharge_have_entered = true;
        updateSuperScriptList();
        return data;
    }


    public boolean DailyRecharge_GetAward(int awardId) {
        List<ActivityConfigExt> activityConfigExts = findActivitieConfigsByRewardType(Const.ActivityRewardType.DAILY_RECHARGE);
        ActivityConfigExt activityConfigExt = null;
        for (ActivityConfigExt tempActivityConfigExt : activityConfigExts) {
            if (tempActivityConfigExt.id == awardId) {
                activityConfigExt = tempActivityConfigExt;
                break;
            }
        }
        if (activityConfigExt == null)
            return false;
        if (this.player.prepaidManager.po.dailyChargeDiamond < activityConfigExt.parameter1) {
            return false;
        }

        if (this.opts.dailyRechargeRecorder.containsKey(Integer.valueOf(activityConfigExt.id))) {
            return false;
        }


        RewardRecord rr = new RewardRecord();
        rr.awardId = activityConfigExt.id;
        rr.awardTime = new Date();
        this.opts.dailyRechargeRecorder.put(Integer.valueOf(activityConfigExt.id), rr);


        ArrayList<WNBag.SimpleItemInfo> simpleItemInfos = getRankReward(activityConfigExt.RankReward);
        for (WNBag.SimpleItemInfo simpleItemInfo : simpleItemInfos) {
            List<NormalItem> list_items = ItemUtil.createItemsByItemCode(simpleItemInfo.itemCode, simpleItemInfo.itemNum);
            this.player.bag.addEntityItems(list_items, Const.GOODS_CHANGE_TYPE.DailyRecharge, null);
        }


        updateSuperScriptList();
        return true;
    }

    public int DailyRecharge_GetTodayMax() {
        int max = 0;

        List<ActivityConfigExt> activityConfigExts = findActivitieConfigsByRewardType(Const.ActivityRewardType.DAILY_RECHARGE);
        for (ActivityConfigExt tempActivityConfigExt : activityConfigExts) {
            if (tempActivityConfigExt.parameter1 > max) {
                max = tempActivityConfigExt.parameter1;
            }
        }
        return max;
    }


    public ActivityFavorHandler.SuperPackageInfo.Builder SuperPackage_GetInfo() {
        ActivityFavorHandler.SuperPackageInfo.Builder res = ActivityFavorHandler.SuperPackageInfo.newBuilder();

        ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.SUPER_PACKAGE.getValue());

        res.setBeginTime(activityExt.openTime);
        res.setEndTime(activityExt.closeTime);
        res.setDescribe(activityExt.activityRule);

        for (SuperPackageCO superPackageCO : GameData.SuperPackages.values()) {
            ActivityFavorHandler.SuperPackageAwardInfo.Builder spiBuilder = ActivityFavorHandler.SuperPackageAwardInfo.newBuilder();
            spiBuilder.setPackageId(superPackageCO.iD);
            spiBuilder.setPackageName(superPackageCO.packageName);
            spiBuilder.setPackageCode(superPackageCO.packageCode);
            spiBuilder.setPackageNum(superPackageCO.packageNum);
            spiBuilder.setPackageIcon(superPackageCO.packageIcon);
            spiBuilder.setPackageScript(superPackageCO.packageScript);
            spiBuilder.setPackagePrice(superPackageCO.packagePrice);

            boolean bought = this.opts.superPackageRecorder.containsKey(Integer.valueOf(superPackageCO.iD));
            spiBuilder.setPackageState((bought == true) ? 1 : 0);


            res.addSuperPackageAwardInfo(spiBuilder.build());
        }
        this.opts.super_pakage_have_enterd = true;

        updateSuperScriptList();
        return res;
    }

    public boolean SuperPackage_GetBoughtable(int productId) {
        return !this.opts.superPackageRecorder.containsKey(Integer.valueOf(productId));
    }


    public List<AdventureItemCO> DailyDraw_Draw(int times) {
        List<AdventureItemCO> res = new LinkedList<>();


        DailyDrawUpdateForgeRandomMap();

        for (int j = 0; j < times; j++) {

            int totalProb = 0;
            List<Integer> probUpList = new LinkedList<>();
            List<GroupRandomCO> groupRandomCOList = new LinkedList<>();
            boolean forgeRandom = false;

            GroupRandomCO selectedGroupRandomCO = null;
            for (GroupRandomCO groupRandomCO : GameData.GroupRandoms.values()) {
                if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(groupRandomCO.groupID))) {
                    totalProb += groupRandomCO.groupProb;

                } else if (((Integer) this.opts.daily_draw_forgerandom_map.get(Integer.valueOf(groupRandomCO.groupID))).intValue() < ((ForgedRandomCO) GameData.ForgedRandoms.get(Integer.valueOf(groupRandomCO.groupID))).ramRed) {
                    totalProb += groupRandomCO.groupProb;
                } else {
                    selectedGroupRandomCO = (GroupRandomCO) GameData.GroupRandoms.get(Integer.valueOf(groupRandomCO.groupID));
                    forgeRandom = true;

                    break;
                }

                totalProb += groupRandomCO.groupProb;
                groupRandomCOList.add(groupRandomCO);
                probUpList.add(Integer.valueOf(totalProb));
            }

            if (!forgeRandom) {
                int k = -1;
                int m = RandomUtil.getInt(0, totalProb);

                for (int n = 0; n < probUpList.size(); n++) {
                    if (m <= ((Integer) probUpList.get(n)).intValue()) {
                        k = n;
                        break;
                    }
                }
                if (k == -1) {
                    Out.error(new Object[]{"随机出错"});
                    break;
                }
                selectedGroupRandomCO = groupRandomCOList.get(k);
            }


            totalProb = 0;
            probUpList.clear();
            int finalGroupId = selectedGroupRandomCO.groupID;
            List<AdventureItemCO> adventureItemCOList = GameData.findAdventureItems(t -> (t.groupID == finalGroupId));
            for (AdventureItemCO adventureItemCO : adventureItemCOList) {
                if (adventureItemCO.isValid == 1) {
                    if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(adventureItemCO.groupID))) {
                        totalProb += adventureItemCO.prob;
                    } else {
                        totalProb += ((Integer) this.opts.daily_draw_forgerandom_map.get(Integer.valueOf(adventureItemCO.groupID))).intValue();
                    }
                }

                probUpList.add(Integer.valueOf(totalProb));
            }
            int randomProb = RandomUtil.getInt(0, totalProb);
            int selectedId = -1;
            for (int i = 0; i < probUpList.size(); i++) {
                if (randomProb <= ((Integer) probUpList.get(i)).intValue()) {
                    selectedId = i;
                    break;
                }
            }
            if (selectedId == -1) {
                Out.error(new Object[]{"随机出错。"});
                break;
            }
            AdventureItemCO selectedAdventureItemCO = adventureItemCOList.get(selectedId);


            for (Integer groupId : this.opts.daily_draw_forgerandom_map.keySet()) {
                ForgedRandomCO forgedRandomCO = (ForgedRandomCO) GameData.ForgedRandoms.get(groupId);
                int currentProb = ((Integer) this.opts.daily_draw_forgerandom_map.get(groupId)).intValue();
                if (selectedAdventureItemCO.groupID == groupId.intValue()) {
                    this.opts.daily_draw_forgerandom_map.put(groupId, Integer.valueOf(0));
                    continue;
                }
                this.opts.daily_draw_forgerandom_map.put(groupId, Integer.valueOf(currentProb + forgedRandomCO.ramAdd));
            }


            res.add(selectedAdventureItemCO);

            List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(selectedAdventureItemCO.item, selectedAdventureItemCO.itemNum);

            for (NormalItem normalItem : normalItems) {
                normalItem.setBind(selectedAdventureItemCO.isBind);
            }
            this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ActivityDraw, "Activity_turntable");
            if (selectedAdventureItemCO.isShow == 1) {
                NormalItem nItem = normalItems.get(0);

                String playerLink = ChannelUtil.setPlayerInfo(this.player);
                String targetPlayerText = LangService.format("NAME_LINK", new Object[]{playerLink, this.player.getName()});

                String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
                String itemLink = ChannelUtil.setItemInfo(nItem);
                itemText = itemText.replace("{a}", nItem.prop.name).replace("{b}", itemLink);

                String numText = LangService.getValue("DEFAULT");
                numText = numText.replace("{a}", "*" + normalItems.size());

                String targetItemText = itemText + numText;


                String tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_ADVENTURE"), new Object[]{targetPlayerText, targetItemText, Const.TipsType.NORMAL});


                MessageUtil.sendRollChat(this.player.getLogicServerId(), tempStr2, Const.CHAT_SCOPE.SYSTEM);
            }
        }


        updateSuperScriptList();

        return res;
    }


    public List<AdventureItemAddCO> DailyDraw_Draw_Add(int times) {
        List<AdventureItemAddCO> res = new LinkedList<>();


        DailyDrawUpdateForgeRandomMapAdd();

        for (int j = 0; j < times; j++) {

            int totalProb = 0;
            List<Integer> probUpList = new LinkedList<>();
            List<GroupRandomAddCO> groupRandomAddCOList = new LinkedList<>();
            boolean forgeRandom = false;

            GroupRandomAddCO selectedGroupRandomAddCO = null;
            for (GroupRandomAddCO groupRandomAddCO : GameData.GroupRandomAdds.values()) {
                if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(groupRandomAddCO.groupID))) {
                    totalProb += groupRandomAddCO.groupProb;

                } else if (((Integer) this.opts.daily_draw_forgerandom_map_add.get(Integer.valueOf(groupRandomAddCO.groupID))).intValue() < ((ForgedRandomAddCO) GameData.ForgedRandomAdds.get(Integer.valueOf(groupRandomAddCO.groupID))).ramRed) {
                    totalProb += groupRandomAddCO.groupProb;
                } else {
                    selectedGroupRandomAddCO = (GroupRandomAddCO) GameData.GroupRandomAdds.get(Integer.valueOf(groupRandomAddCO.groupID));
                    forgeRandom = true;

                    break;
                }

                totalProb += groupRandomAddCO.groupProb;
                groupRandomAddCOList.add(groupRandomAddCO);
                probUpList.add(Integer.valueOf(totalProb));
            }

            if (!forgeRandom) {
                int k = -1;
                int m = RandomUtil.getInt(0, totalProb);

                for (int n = 0; n < probUpList.size(); n++) {
                    if (m <= ((Integer) probUpList.get(n)).intValue()) {
                        k = n;
                        break;
                    }
                }
                if (k == -1) {
                    Out.error(new Object[]{"随机出错"});
                    break;
                }
                selectedGroupRandomAddCO = groupRandomAddCOList.get(k);
            }


            totalProb = 0;
            probUpList.clear();
            int finalGroupId = selectedGroupRandomAddCO.groupID;
            List<AdventureItemAddCO> adventureItemAddCOList = GameData.findAdventureItemAdds(t -> (t.groupID == finalGroupId));
            for (AdventureItemAddCO adventureItemAddCO : adventureItemAddCOList) {
                if (adventureItemAddCO.isValid == 1) {
                    if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(adventureItemAddCO.groupID))) {
                        totalProb += adventureItemAddCO.prob;
                    } else {
                        totalProb += ((Integer) this.opts.daily_draw_forgerandom_map_add.get(Integer.valueOf(adventureItemAddCO.groupID))).intValue();
                    }
                }

                probUpList.add(Integer.valueOf(totalProb));
            }
            int randomProb = RandomUtil.getInt(0, totalProb);
            int selectedId = -1;
            for (int i = 0; i < probUpList.size(); i++) {
                if (randomProb <= ((Integer) probUpList.get(i)).intValue()) {
                    selectedId = i;
                    break;
                }
            }
            if (selectedId == -1) {
                Out.error(new Object[]{"随机出错。"});
                break;
            }
            AdventureItemAddCO selectedAdventureItemAddCO = adventureItemAddCOList.get(selectedId);


            for (Integer groupId : this.opts.daily_draw_forgerandom_map_add.keySet()) {
                ForgedRandomAddCO forgedRandomAddCO = (ForgedRandomAddCO) GameData.ForgedRandomAdds.get(groupId);
                int currentProb = ((Integer) this.opts.daily_draw_forgerandom_map_add.get(groupId)).intValue();
                if (selectedAdventureItemAddCO.groupID == groupId.intValue()) {
                    this.opts.daily_draw_forgerandom_map_add.put(groupId, Integer.valueOf(0));
                    continue;
                }
                this.opts.daily_draw_forgerandom_map_add.put(groupId, Integer.valueOf(currentProb + forgedRandomAddCO.ramAdd));
            }


            res.add(selectedAdventureItemAddCO);

            List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(selectedAdventureItemAddCO.item, selectedAdventureItemAddCO.itemNum);

            for (NormalItem normalItem : normalItems) {
                normalItem.setBind(selectedAdventureItemAddCO.isBind);
            }
            this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ActivityDrawSpring, "Activity_turntable");
            if (selectedAdventureItemAddCO.isShow == 1) {
                NormalItem nItem = normalItems.get(0);

                String playerLink = ChannelUtil.setPlayerInfo(this.player);
                String targetPlayerText = LangService.format("NAME_LINK", new Object[]{playerLink, this.player.getName()});

                String itemText = LangService.getValue(MessageUtil.getColorLink(nItem.prop.qcolor));
                String itemLink = ChannelUtil.setItemInfo(nItem);
                itemText = itemText.replace("{a}", nItem.prop.name).replace("{b}", itemLink);

                String numText = LangService.getValue("DEFAULT");
                numText = numText.replace("{a}", "*" + normalItems.size());

                String targetItemText = itemText + numText;


                String tempStr2 = String.format(LangService.getValue("ACTIVITY_DAILY_ADVENTURE"), new Object[]{targetPlayerText, targetItemText, Const.TipsType.NORMAL});


                MessageUtil.sendRollChat(this.player.getLogicServerId(), tempStr2, Const.CHAT_SCOPE.SYSTEM);
            }
        }


        updateSuperScriptList();

        return res;
    }

    private void DailyDrawUpdateForgeRandomMap() {
        if (GameData.ForgedRandoms.size() > 1) {
            Out.error(new Object[]{"伪随机配置不能多于1条"});
        }

        for (ForgedRandomCO forgedRandomCO : GameData.ForgedRandoms.values()) {
            if (!this.opts.daily_draw_forgerandom_map.containsKey(Integer.valueOf(forgedRandomCO.groupID))) {
                this.opts.daily_draw_forgerandom_map.put(Integer.valueOf(forgedRandomCO.groupID), Integer.valueOf(forgedRandomCO.initial));
            }
        }


        for (Integer groupId : this.opts.daily_draw_forgerandom_map.keySet()) {
            if (!GameData.ForgedRandoms.containsKey(groupId)) {
                this.opts.daily_draw_forgerandom_map.remove(groupId);
            }
        }
    }


    private void DailyDrawUpdateForgeRandomMapAdd() {
        if (GameData.ForgedRandomAdds.size() > 1) {
            Out.error(new Object[]{"伪随机配置不能多于1条"});
        }

        for (ForgedRandomAddCO forgedRandomAddCO : GameData.ForgedRandomAdds.values()) {
            if (!this.opts.daily_draw_forgerandom_map_add.containsKey(Integer.valueOf(forgedRandomAddCO.groupID))) {
                this.opts.daily_draw_forgerandom_map_add.put(Integer.valueOf(forgedRandomAddCO.groupID), Integer.valueOf(forgedRandomAddCO.initial));
            }
        }


        for (Integer groupId : this.opts.daily_draw_forgerandom_map_add.keySet()) {
            if (!GameData.ForgedRandomAdds.containsKey(groupId)) {
                this.opts.daily_draw_forgerandom_map_add.remove(groupId);
            }
        }
    }


    public Date DailyDrawGetFreeTimeUpdateTime() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int h = calendar.get(11);
        calendar.set(11, 5);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (h > 5)
            calendar.add(5, 1);
        return calendar.getTime();
    }

    public ActivityFavorHandler.SevenDayPackageGetInfoResponse getSevenDayPackageGetInfo() {
        ActivityFavorHandler.SevenDayPackageGetInfoResponse.Builder result = ActivityFavorHandler.SevenDayPackageGetInfoResponse.newBuilder();


        ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.OPEN_SEVEN_DAY.getValue());
        if (activityExt == null) {
            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("PARAM_ERROR"));
            return result.build();
        }


        ActivityFavorHandler.SevenDayPackageInfo.Builder info = ActivityFavorHandler.SevenDayPackageInfo.newBuilder();
        info.setBeginTime(activityExt.openTime);
        info.setEndTime(activityExt.closeTime);
        info.setDescribe(activityExt.activityRule);


        for (int i = 0; i < this.opts.sevendayList.size(); i++) {
            SevenLoginCO sevenLoginCO = (SevenLoginCO) GameData.SevenLogins.get(Integer.valueOf(i + 1));
            ActivityFavorHandler.SevenDayPackageAwardInfo.Builder award = ActivityFavorHandler.SevenDayPackageAwardInfo.newBuilder();
            award.setPackageId(sevenLoginCO.id);
            award.setItemcode(sevenLoginCO.item1code);
            award.setItemcount(sevenLoginCO.item1count);
            award.setItemmodel(sevenLoginCO.item1Model);
            award.setState(((Integer) this.opts.sevendayList.get(i)).intValue());
            info.addSevenDayPackageAwardInfo(award);
        }

        result.setS2CCode(200);
        result.setSevenDayPackageInfo(info);
        return result.build();
    }


    public ActivityFavorHandler.SevenDayPackageAwardResponse receiveSevenDayPackageAward(int packageId) {
        ActivityFavorHandler.SevenDayPackageAwardResponse.Builder result = ActivityFavorHandler.SevenDayPackageAwardResponse.newBuilder();


        if (packageId > 7) {
            result.setS2CCode(200);
            return result.build();
        }


        if (((Integer) this.opts.sevendayList.get(packageId - 1)).intValue() != 1) {
            result.setS2CCode(200);
            return result.build();
        }


        this.opts.sevendayList.set(packageId - 1, Integer.valueOf(2));
        Out.info(new Object[]{"领取七日登录礼包 playerId=", this.player.getId(), ",day=", Integer.valueOf(packageId)});

        SevenLoginCO co = (SevenLoginCO) GameData.SevenLogins.get(Integer.valueOf(packageId));
        this.player.getWnBag().addCodeItemMail(co.item1code, co.item1count, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.ACTIVITY_SEVENDAY, "Bag_full_common");
        result.setS2CCode(200);

        updateSuperScriptList();
        return result.build();
    }


    private void refreshSevendayLogin() {
        for (int i = 0; i < this.opts.sevendayList.size(); i++) {
            if (((Integer) this.opts.sevendayList.get(i)).intValue() == 0) {
                this.opts.sevendayList.set(i, Integer.valueOf(1));
                break;
            }
        }
    }


    public ActivityFavorHandler.RecoveredInfoResponse getRecoveredGetInfo() {
        ActivityFavorHandler.RecoveredInfoResponse.Builder result = ActivityFavorHandler.RecoveredInfoResponse.newBuilder();


        ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
        if (activityExt == null) {
            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("PARAM_ERROR"));
            return result.build();
        }


        ActivityFavorHandler.RecoveredInfo.Builder info = ActivityFavorHandler.RecoveredInfo.newBuilder();
        info.setBeginTime(activityExt.openTime);
        info.setEndTime(activityExt.closeTime);
        info.setDescribe(activityExt.activityRule);

        int recoveryDay = getRecoveryDay(activityExt.activityID);


        for (Map.Entry<Integer, Integer> e : (Iterable<Map.Entry<Integer, Integer>>) this.opts.recovery.entrySet()) {
            RecoveryExt t = (RecoveryExt) GameData.Recoverys.get(e.getKey());
            if (t != null) {
                int count = ((Integer) e.getValue()).intValue();
                ActivityFavorHandler.RecoveredSourceInfo.Builder rsi = ActivityFavorHandler.RecoveredSourceInfo.newBuilder();
                rsi.setId(t.iD);
                rsi.setSourceName(t.name);
                rsi.setMinDate(count);
                rsi.setMaxDate(getRecoveryMaxCount(t.type) * recoveryDay);
                rsi.setState((count > 0) ? 0 : 1);
                rsi.setNeedDiamond(t.cost * count);

                int recoverCount = (count > 0) ? count : ((Integer) this.opts.recoveryHistory.getOrDefault(e.getKey(), Integer.valueOf(0))).intValue();
                buildRecoveredItem(rsi, t.item1code, t.num1 * recoverCount);
                buildRecoveredItem(rsi, t.item2code, t.num2 * recoverCount);
                buildRecoveredItem(rsi, t.item3code, t.num3 * recoverCount);
                buildRecoveredItem(rsi, t.item4code, t.num4 * recoverCount);

                info.addRecoveredSourceInfo(rsi.build());
            }
        }
        result.setRecoveredInfo(info.build());
        result.setS2CCode(200);
        return result.build();
    }

    private void buildRecoveredItem(ActivityFavorHandler.RecoveredSourceInfo.Builder rsi, String itemcode, int num) {
        if (StringUtils.isNotEmpty(itemcode)) {
            ActivityFavorHandler.RecoveredItem.Builder item = ActivityFavorHandler.RecoveredItem.newBuilder();
            item.setCode(itemcode);
            item.setNum(num);
            rsi.addRecoveredItems(item);
        }
    }


    public ActivityFavorHandler.RecoveredResponse recoveredRequest(int id, int type) {
        ActivityFavorHandler.RecoveredResponse.Builder result = ActivityFavorHandler.RecoveredResponse.newBuilder();
        if (!this.opts.recovery.containsKey(Integer.valueOf(id))) {
            result.setS2CCode(500);
            return result.build();
        }


        int count = ((Integer) this.opts.recovery.get(Integer.valueOf(id))).intValue();
        if (count <= 0) {
            result.setS2CCode(500);
            return result.build();
        }

        RecoveryExt template = GameData.findRecoverys(v -> (v.iD == id)).get(0);
        int totalCost = count * template.cost;

        if (type == 1 &&
                !this.player.moneyManager.enoughTicketAndDiamond(totalCost)) {
            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("TICKET_NOT_ENOUGH"));
            return result.build();
        }


        ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
        if (activityExt == null) {
            result.setS2CCode(500);
            return result.build();
        }

        float ratio = 0.5F;
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activityExt.activityID));
        for (ActivityConfigExt t : props) {
            if (type == 0 && "Activity_Recovery_FreeRatio".equals(t.notes1)) {
                ratio = t.parameter1 / 100.0F;
                break;
            }
            if (type == 1 && "Activity_Recovery_PerfectRatio".equals(t.notes1)) {
                ratio = t.parameter1 / 100.0F;
                break;
            }
        }
        List<WNBag.SimpleItemInfo> items = new ArrayList<>(4);
        for (int i = 1; i <= 4; i++) {
            String codeKey = "item" + i + "code";
            String countKey = "num" + i;
            try {
                String itemCode = ClassUtil.getProperty(template, codeKey).toString();
                if (StringUtils.isNotEmpty(itemCode)) {
                    WNBag.SimpleItemInfo item = new WNBag.SimpleItemInfo();
                    item.itemCode = itemCode;
                    item.itemNum = (int) Math.ceil(((((Integer) ClassUtil.getProperty(template, countKey)).intValue() * count) * ratio));
                    items.add(item);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }

        if (!this.player.getWnBag().testAddCodeItems(items)) {
            result.setS2CCode(500);
            result.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
            return result.build();
        }

        Out.info(new Object[]{"资源找回，roleId=", this.player.getId(), ",id=", Integer.valueOf(id), ",type=", Integer.valueOf(type), ",count=", Integer.valueOf(count)});

        if (type == 1) {
            this.player.moneyManager.costTicketAndDiamond(totalCost, Const.GOODS_CHANGE_TYPE.recovered);
        }
        this.opts.recovery.put(Integer.valueOf(id), Integer.valueOf(0));

        this.player.getWnBag().addCodeItems(items, Const.GOODS_CHANGE_TYPE.recovered);

        updateSuperScriptList();
        result.setS2CCode(200);
        return result.build();
    }


    private void refreshRecovered() {
        ActivityExt activityExt = findActivityByType(Const.ActivityRewardType.RECOVERY.getValue());
        if (activityExt == null) {
            return;
        }
        HashMap<Integer, Integer> stub = new HashMap<>(this.opts.recovery);
        this.opts.recovery.clear();
        this.opts.recoveryHistory.clear();

        int recoveryDay = getRecoveryDay(activityExt.activityID);
        int day = Math.max(Math.min(recoveryDay - 1, daysOfTwo(this.opts.refreshTime, new Date()) - 1), 0);
        int level = (this.player.getPlayer()).level;
        List<RecoveryExt> templates = GameData.findRecoverys(v -> (v.minLevel <= level && level <= v.maxLevel));
        for (RecoveryExt t : templates) {
            int progress;
            int max;
            switch (t.type) {

                case 1:
                    if (this.player.demonTowerManager.getSweepCountLeft() > 0) {
                        int i = 0;
                        int j = getRecoveryMaxCount(t.type);
                        refreshRecovery(Integer.valueOf(t.iD), day, j, i, stub, recoveryDay);
                    }


                case 2:
                    progress = (this.player.dailyActivityMgr.getTaskInfo(3)).process;
                    max = getRecoveryMaxCount(t.type);
                    refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);


                case 3:
                    progress = (this.player.dailyActivityMgr.getTaskInfo(4)).process;
                    max = getRecoveryMaxCount(t.type);
                    refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);


                case 4:
                    progress = (this.player.dailyActivityMgr.getTaskInfo(11)).process;
                    max = getRecoveryMaxCount(t.type);
                    refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);


                case 5:
                    progress = (this.player.dailyActivityMgr.getTaskInfo(10)).process;
                    max = getRecoveryMaxCount(t.type);
                    refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);


                case 6:
                    progress = (this.player.dailyActivityMgr.getTaskInfo(12)).process;
                    max = getRecoveryMaxCount(t.type);
                    refreshRecovery(Integer.valueOf(t.iD), day, max, progress, stub, recoveryDay);
            }
        }
    }


    private int getRecoveryMaxCount(int type) {
        switch (type) {
            case 1:
                return 1;
            case 2:
                return (DailyActivityMgr.getConfig(3)).maxCount;
            case 3:
                return (DailyActivityMgr.getConfig(4)).maxCount;
            case 4:
                return (DailyActivityMgr.getConfig(11)).maxCount;
            case 5:
                return (DailyActivityMgr.getConfig(10)).maxCount;
            case 6:
                return (DailyActivityMgr.getConfig(12)).maxCount;
        }
        return 0;
    }


    private int getRecoveryDay(int activityID) {
        List<ActivityConfigExt> props = GameData.findActivityConfigs(t -> (t.type == activityID && "Activity_Recovery_Days".equals(t.notes1)));
        if (props.isEmpty()) {
            Out.error(new Object[]{"未配置资源找回功能所需要的可找回天数参数."});
            return 1;
        }
        return ((ActivityConfigExt) props.get(0)).parameter1;
    }

    private void refreshRecovery(Integer type, int day, int maxCount, int progress, HashMap<Integer, Integer> stub, int recoveryDay) {
        int count = maxCount - progress + day * maxCount;
        if (day == 0) {
            count += ((Integer) stub.getOrDefault(type, Integer.valueOf(0))).intValue();
            count = Math.min(recoveryDay * maxCount, count);
        }
        if (count > 0) {
            this.opts.recovery.put(type, Integer.valueOf(count));
            this.opts.recoveryHistory.put(type, Integer.valueOf(count));
        }
    }

    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(6);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(6);
        return day2 - day1;
    }


    public boolean hasRecoveryCount() {
        for (Map.Entry<Integer, Integer> e : (Iterable<Map.Entry<Integer, Integer>>) this.opts.recovery.entrySet()) {
            if (((Integer) e.getValue()).intValue() > 0) {
                return true;
            }
        }
        return false;
    }


    public void gmRecovered(int day) {
        Date old = this.opts.refreshTime;
        this.opts.refreshTime = DateUtils.addDays(old, -day);
        refreshRecovered();
        this.opts.refreshTime = old;
    }


    public void triggerLimitTimeGift(int condition) {
        this.cachedLimitTimeGiftStack.push(Integer.valueOf(condition));

        CheckLimitTimeGiftList();
    }


    public void CheckLimitTimeGiftList() {
        if (this.player.area.getSceneType() != Const.SCENE_TYPE.NORMAL.getValue()) {
            return;
        }

        boolean needPush = false;
        while (this.cachedLimitTimeGiftStack.size() > 0) {
            int condition = ((Integer) this.cachedLimitTimeGiftStack.pop()).intValue();
            List<LimitTimeGiftCO> limitTimeGiftCOs = GameData.findLimitTimeGifts(t ->
                    (t.condition == condition && t.minLevel <= this.player.getLevel() && t.maxLevel >= this.player.getLevel()));

            if (limitTimeGiftCOs.size() != 1) {
                continue;
            }
            LimitTimeGiftCO limitTimeGiftCO = limitTimeGiftCOs.get(0);


            if (limitTimeGiftCO.onlyPushOne == 1 && ((Integer) this.opts.timeLimitGiftPushMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
                continue;
            }


            if (((Integer) this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
                continue;
            }


            if (RandomUtil.getInt(0, 100) > limitTimeGiftCO.pushPro) {
                continue;
            }


            needPush = true;
            boolean lastOver = false;
            Date lastTime = (Date) this.opts.timeLimitGiftTriggeredTimeMap.get(Integer.valueOf(limitTimeGiftCO.condition));
            if (lastTime != null) {
                long offset = lastTime.getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
                if (offset > 0L) {
                    lastOver = true;
                }
            }
            Out.info(new Object[]{"推送限时礼包，id：", Integer.valueOf(limitTimeGiftCO.id), "  是否覆盖上次推送：", Boolean.valueOf(lastOver)});

            this.opts.timeLimitGiftTriggeredTimeMap.put(Integer.valueOf(limitTimeGiftCO.condition), new Date());
            this.opts.timeLimitGiftTriggeredIdMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(limitTimeGiftCO.id));
            int currentPushTime = ((Integer) this.opts.timeLimitGiftPushMap.get(Integer.valueOf(limitTimeGiftCO.condition))).intValue();
            this.opts.timeLimitGiftPushMap.put(Integer.valueOf(limitTimeGiftCO.condition), Integer.valueOf(currentPushTime + 1));
        }


        checkAndPushLimitTimeSuperScript();

        if (!needPush) {
            return;
        }


        ActivityFavorHandler.LimitTimeGiftInfoPush.Builder builder = ActivityFavorHandler.LimitTimeGiftInfoPush.newBuilder();
        builder.setS2CCode(200);
        builder.addAllLimitTimeGiftInfo(getLimitTimeGiftInfos());
        this.player.receive("area.activityFavorPush.limitTimeGiftInfoPush", (GeneratedMessage) builder.build());
    }


    private void checkAndPushLimitTimeSuperScript() {
        List<PlayerHandler.SuperScriptType> superScriptTypes = getLimitTimeSuperScript();

        if (superScriptTypes.size() != 1) {
            return;
        }


        this.player.updateSuperScriptList(superScriptTypes);

        PlayerHandler.SuperScriptType superScriptType = superScriptTypes.get(0);

        if (superScriptType.getNumber() == 0) {
            return;
        }
        long delay = 1000L * superScriptType.getNumber() + 500L;

        JobFactory.addDelayJob(() -> checkAndPushLimitTimeSuperScript(), delay);
    }


    public List<ActivityFavorHandler.LimitTimeGiftInfo> getLimitTimeGiftInfos() {
        List<ActivityFavorHandler.LimitTimeGiftInfo> limitTimeGiftInfos = new LinkedList<>();
        for (Iterator<Map.Entry<Integer, Date>> iterator = this.opts.timeLimitGiftTriggeredTimeMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, Date> entry = iterator.next();

            List<LimitTimeGiftCO> limitTimeGiftCOs = GameData.findLimitTimeGifts(t ->
                    (t.condition == ((Integer) entry.getKey()).intValue() && t.minLevel <= this.player.getLevel() && t.maxLevel >= this.player.getLevel()));

            if (limitTimeGiftCOs.size() != 1) {
                continue;
            }
            LimitTimeGiftCO limitTimeGiftCO = limitTimeGiftCOs.get(0);

            if (entry.getValue() == null) {
                continue;
            }

            if (((Integer) this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue() > 0) {
                continue;
            }

            long offset = ((Date) entry.getValue()).getTime() + 60000L * limitTimeGiftCO.limitTime - System.currentTimeMillis();
            if (offset <= 0L) {
                continue;
            }
            ActivityFavorHandler.LimitTimeGiftInfo.Builder builder = ActivityFavorHandler.LimitTimeGiftInfo.newBuilder();
            builder.setId(limitTimeGiftCO.id);
            builder.setSecondRemain((int) (offset / 1000L) + 1);
            limitTimeGiftInfos.add(builder.build());
        }

        return limitTimeGiftInfos;
    }


    public int BugLimitTimeGift(int id) {
        LimitTimeGiftCO limitTimeGiftCO = (LimitTimeGiftCO) GameData.LimitTimeGifts.get(Integer.valueOf(id));


        if (!this.opts.timeLimitGiftBuyMap.containsKey(Integer.valueOf(limitTimeGiftCO.id))) {
            return 1;
        }


        int buyCount = ((Integer) this.opts.timeLimitGiftBuyMap.get(Integer.valueOf(limitTimeGiftCO.id))).intValue();

        if (buyCount > 0) {
            return 2;
        }


        if (this.player.moneyManager.getDiamond() < limitTimeGiftCO.price) {
            return 3;
        }

        this.opts.timeLimitGiftBuyMap.put(Integer.valueOf(limitTimeGiftCO.id), Integer.valueOf(buyCount + 1));

        this.player.moneyManager.costDiamond(limitTimeGiftCO.price, Const.GOODS_CHANGE_TYPE.LimitTimeGift);

        String[] strs1 = limitTimeGiftCO.rewardItem.split(";");
        for (String strs1_item : strs1) {
            String[] strs2 = strs1_item.split(":");
            List<NormalItem> normalItems = ItemUtil.createItemsByItemCode(strs2[0], Integer.parseInt(strs2[1]));

            for (NormalItem normalItem : normalItems) {
                normalItem.setBind(1);
            }
            this.player.bag.addCodeItemMail(normalItems, Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.LimitTimeGift, "Bag_full_common");
        }


        checkAndPushLimitTimeSuperScript();

        return 0;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case UPGRADE:
                triggerLimitTimeGift(3);
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.ACTIVITY;
    }
}


