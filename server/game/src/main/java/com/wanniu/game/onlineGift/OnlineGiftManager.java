package com.wanniu.game.onlineGift;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.game.attendance.PlayerAttendance;
import com.wanniu.game.bag.WNBag;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.OlGiftExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.OnlineDataPO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import pomelo.area.OnlineGiftHandler;
import pomelo.area.PlayerHandler;


public class OnlineGiftManager {
    public WNPlayer player;
    public OnlineDataPO onlineData;
    public Const.ONLINE_GIFT_TYPE giftType;
    public ScheduledFuture<?> timer = null;

    public OnlineGiftManager(WNPlayer player, OnlineDataPO data) {
        this.player = player;
        this.onlineData = data;
        initGiftType();
        if (this.onlineData == null) {
            this.onlineData = PlayerUtil.createOnlineData(player.getId(), this.giftType, player.player.upLevel, player.getLevel());
        }
    }


    public Calendar getNextDaySpecifiedTime(Date time, int hour) {
        Calendar nextFive = Calendar.getInstance();
        nextFive.setTime(time);
        nextFive.add(5, 1);
        nextFive.set(11, hour);
        nextFive.set(12, 0);
        nextFive.set(13, 0);
        nextFive.set(14, 0);

        return nextFive;
    }


    public boolean isFirstDay() {
        Calendar now = Calendar.getInstance();
        Calendar nextFive = getNextDaySpecifiedTime((this.player.getPlayer()).createTime, 5);
        return now.before(nextFive);
    }

    public void initGiftType() {
        this.giftType = Const.ONLINE_GIFT_TYPE.NORMAL;
        if (isFirstDay()) {
            this.giftType = Const.ONLINE_GIFT_TYPE.FIRST_DAY;
        }
    }

    public void onLogin() {
        startTimer();
    }

    public void cancelTimer() {
        if (null != this.timer) {
            this.timer.cancel(true);
            this.timer = null;
        }
    }

    public boolean checkIsAllReceived() {
        int sum = 0;
        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
        for (Integer state : this.onlineData.rewardState.values()) {
            if (PlayerAttendance.GiftState.RECEIVED.getValue() == state.intValue() || PlayerAttendance.GiftState.CAN_RECEIVE.getValue() == state.intValue()) {
                sum++;
            }
        }

        return (sum >= propList.size());
    }

    public void startTimer() {
        cancelTimer();
        if (!checkIsAllReceived()) {
            this.timer = JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    OnlineGiftManager.this.onlineData.sumTime++;
                    OnlineGiftManager.this.updateState(OnlineGiftManager.this.onlineData.sumTime);
                    if (OnlineGiftManager.this.checkIsAllReceived()) {
                        OnlineGiftManager.this.cancelTimer();
                    }
                }
            }, 1L, Const.Time.Second.getValue());
        }
    }

    public void refreshNewDay() {
        this.onlineData.sumTime = 0L;
        this.onlineData.rewardState.clear();
        startTimer();
        initGiftType();
        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
        for (int i = 0; i < propList.size(); i++) {
            this.onlineData.rewardState.put(Integer.valueOf(((OlGiftExt) propList.get(i)).giftId), Integer.valueOf(PlayerAttendance.GiftState.NO_RECEIVE.getValue()));
        }
        pushGiftInfoToClient();
    }

    public void updateState(long sumTime) {
        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());
        boolean isNeedPushRedPoint = false;
        for (OlGiftExt prop : propList) {
            if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId)) || PlayerAttendance.GiftState.RECEIVED.getValue() == ((Integer) this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
                continue;
            }

            if (sumTime >= (prop.time * 60) && PlayerAttendance.GiftState.NO_RECEIVE.getValue() == ((Integer) this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
                this.onlineData.rewardState.put(Integer.valueOf(prop.giftId), Integer.valueOf(PlayerAttendance.GiftState.CAN_RECEIVE.getValue()));
                isNeedPushRedPoint = true;
            }
        }

        if (isNeedPushRedPoint) {
            this.player.activityManager.updateSuperScriptList();
        }
    }

    public OnlineGiftHandler.OnlineGift toJson4Payload() {
        OnlineGiftHandler.OnlineGift.Builder data = OnlineGiftHandler.OnlineGift.newBuilder();
        data.setOnlineTime((int) this.onlineData.sumTime);
        ArrayList<OnlineGiftHandler.GiftInfo> giftList = new ArrayList<>();

        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());

        for (OlGiftExt prop : propList) {
            OnlineGiftHandler.GiftInfo.Builder tempInfo = OnlineGiftHandler.GiftInfo.newBuilder();
            if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId))) {
                continue;
            }

            tempInfo.setState(((Integer) this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue());
            tempInfo.setId(prop.giftId);
            tempInfo.setTime(prop.time);
            tempInfo.setName(prop.name);
            tempInfo.addAllItem(prop.getMiniItems());
            giftList.add(tempInfo.build());
        }

        data.addAllGiftList(giftList);

        return data.build();
    }


    public PlayerHandler.SuperScriptType getSuperScript() {
        int number = 0;
        List<OlGiftExt> propList = OlGiftConfig.getInstance().getPropListByLevel(this.giftType.getValue(), (this.player.getPlayer()).upLevel, this.player.getLevel());

        for (OlGiftExt prop : propList) {
            if (!this.onlineData.rewardState.containsKey(Integer.valueOf(prop.giftId)) || PlayerAttendance.GiftState.CAN_RECEIVE.getValue() != ((Integer) this.onlineData.rewardState.get(Integer.valueOf(prop.giftId))).intValue()) {
                continue;
            }

            number++;
        }

        PlayerHandler.SuperScriptType.Builder scriptNum = PlayerHandler.SuperScriptType.newBuilder();
        scriptNum.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_ONLINE_GIFT.getValue());
        scriptNum.setNumber(number);
        return scriptNum.build();
    }


    public void onPlayerOffline() {
        cancelTimer();
    }

    public int receiveGift(int giftId) {
        OlGiftExt prop = OnlineGiftUtil.getPropById(giftId);
        if (prop == null || !this.onlineData.rewardState.containsKey(Integer.valueOf(giftId))) {
            return -6;
        }
        if (prop.type != this.giftType.getValue()) {
            return -7;
        }
        if (PlayerAttendance.GiftState.RECEIVED.getValue() == ((Integer) this.onlineData.rewardState.get(Integer.valueOf(giftId))).intValue()) {
            return -1;
        }
        if ((this.player.getPlayer()).upLevel != 0) {
            if ((this.player.getPlayer()).upLevel < prop.downOrder || (this.player.getPlayer()).upLevel > prop.upOrder) {
                return -2;
            }
        } else if (this.player.getLevel() < prop.lvDown || this.player.getLevel() > prop.lvUp) {
            return -3;
        }


        if (PlayerAttendance.GiftState.NO_RECEIVE.getValue() == ((Integer) this.onlineData.rewardState.get(Integer.valueOf(giftId))).intValue()) {
            return -4;
        }

        List<WNBag.SimpleItemInfo> items = prop.items;
        Map<String, Integer> rewards = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            WNBag.SimpleItemInfo tmp = items.get(i);
            rewards.put(tmp.itemCode, Integer.valueOf(tmp.itemNum));
        }

        List<NormalItem> list_items = ItemUtil.createItemsByItemCode(rewards);
        this.player.bag.addCodeItemMail(list_items, null, Const.GOODS_CHANGE_TYPE.ONLINE_GIFT, "Bag_full_common");

        this.onlineData.rewardState.put(Integer.valueOf(giftId), Integer.valueOf(PlayerAttendance.GiftState.RECEIVED.getValue()));

        this.player.activityManager.updateSuperScriptList();
        return 0;
    }

    public void pushGiftInfoToClient() {
        OnlineGiftHandler.GiftInfoPush.Builder data = OnlineGiftHandler.GiftInfoPush.newBuilder();
        data.setS2CCode(200);
        data.setS2CGift(toJson4Payload());
        this.player.receive("area.onlineGiftPush.giftInfoPush", (GeneratedMessage) data.build());
    }
}


