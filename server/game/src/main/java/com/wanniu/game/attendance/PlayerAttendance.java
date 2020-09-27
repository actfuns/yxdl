package com.wanniu.game.attendance;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.ext.AccumulateExt;
import com.wanniu.game.data.ext.LuxurySignExt;
import com.wanniu.game.data.ext.NormalSignExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.AttendancePO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.AttendanceHandler;
import pomelo.area.PlayerHandler;
import pomelo.item.ItemOuterClass;


public class PlayerAttendance {
    public WNPlayer player;
    public AttendancePO attDb;

    public enum GiftState {
        NO_RECEIVE(0), CAN_RECEIVE(1), RECEIVED(2), VIP_NOT_RECEIVE(3);

        private int value;

        GiftState(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public class DailySignInfo {
        public int id;
        public int boxIcon;
        public ItemOuterClass.MiniItem.Builder[] items;
        public int vipDoubleLevel;
        public int state;

        public final ItemOuterClass.MiniItem[] getMiniItems() {
            if (this.items != null) {
                ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
                for (int i = 0; i < itemList.length; i++) {
                    ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
                    if (null == miniItem) {
                        Out.error(new Object[]{getClass(), "->[", this.items[i].getCode(), "] is not found"});
                    } else {

                        itemList[i] = miniItem.build();
                    }
                }
                return itemList;
            }
            return null;
        }


        public final AttendanceHandler.DailyInfo getDailyInfo() {
            AttendanceHandler.DailyInfo.Builder builder = AttendanceHandler.DailyInfo.newBuilder();
            builder.setId(this.id);
            builder.setVipDoubleLevel(this.vipDoubleLevel);
            builder.setState(this.state);
            ItemOuterClass.MiniItem[] itemList = getMiniItems();
            if (itemList != null && itemList.length > 0 &&
                    null != itemList[0]) {
                builder.setItemList(itemList[0]);
            }

            return builder.build();
        }
    }

    public class CumulativeSignInfo {
        public int id;
        public String boxIcon;
        public ItemOuterClass.MiniItem.Builder[] items;
        public int needCountDay;
        public int state;

        public final ItemOuterClass.MiniItem[] getMiniItems() {
            if (this.items != null) {
                ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
                for (int i = 0; i < itemList.length; i++) {
                    ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
                    if (null == miniItem) {
                        Out.error(new Object[]{getClass(), "->[", this.items[i].getCode(), "] is not found"});
                    } else {

                        itemList[i] = miniItem.build();
                    }
                }
                return itemList;
            }
            return null;
        }


        public final AttendanceHandler.CumulativeInfo getCumulativeInfo() {
            AttendanceHandler.CumulativeInfo.Builder builder = AttendanceHandler.CumulativeInfo.newBuilder();
            builder.setId(this.id);
            builder.setBoxIcon((this.boxIcon == null) ? "" : this.boxIcon);
            builder.setNeedCountDay(this.needCountDay);
            builder.setState(this.state);
            ItemOuterClass.MiniItem[] itemList = getMiniItems();
            if (itemList != null)
                for (int i = 0; i < itemList.length; i++) {
                    ItemOuterClass.MiniItem miniItem = itemList[i];
                    if (null != miniItem) {


                        builder.addItemList(miniItem);
                    }
                }
            return builder.build();
        }
    }

    public class LuxurySignInfo {
        public int id;
        public ItemOuterClass.MiniItem.Builder[] items;
        public int state;

        public final ItemOuterClass.MiniItem[] getMiniItems() {
            if (this.items != null) {
                ItemOuterClass.MiniItem[] itemList = new ItemOuterClass.MiniItem[this.items.length];
                for (int i = 0; i < itemList.length; i++) {
                    if (null != itemList[i]) {


                        ItemOuterClass.MiniItem.Builder miniItem = ItemUtil.getMiniItemData(this.items[i].getCode(), this.items[i].getGroupCount());
                        if (null == miniItem) {
                            Out.error(new Object[]{getClass(), "->[", this.items[i].getCode(), "] is not found"});
                        } else {
                            itemList[i] = miniItem.build();
                        }
                    }
                }
                return itemList;
            }
            return null;
        }


        public final AttendanceHandler.LuxuryInfo getLuxuryInfo() {
            AttendanceHandler.LuxuryInfo.Builder builder = AttendanceHandler.LuxuryInfo.newBuilder();
            builder.setState(this.state);
            ItemOuterClass.MiniItem[] itemList = getMiniItems();
            if (itemList != null)
                for (int i = 0; i < itemList.length; i++) {
                    if (null != itemList[i]) {

                        builder.addItemList(itemList[i]);
                    }
                }
            return builder.build();
        }
    }


    public PlayerAttendance(WNPlayer player, AttendancePO attDb) {
        this.player = player;
        this.attDb = attDb;
    }


    public void refreshNewDay() {
        if (DateUtil.canRefreshData(5, this.attDb.lastLuxuryTime)) {
            this.attDb.luxuryState = GiftState.NO_RECEIVE.getValue();
        }
        if (DateUtil.canRefreshData(5, this.attDb.lastSignTime) && getSignedCount() >= 30) {
            int lastId = 30;
            NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, lastId);
            NormalSignExt propNext = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage + 1, 1);

            if (prop != null && prop.nextRound > 0) {
                this.attDb.stage = prop.nextRound;
            } else if (propNext != null) {
                this.attDb.stage++;
            } else {
                this.attDb.stage = 1;
            }
            this.attDb.signMap = new HashMap<>();
            this.attDb.cumulativeMap = new HashMap<>();
        }
    }


    public final void testRefresh() {
        this.attDb.lastSignTime = DateUtil.getZeroDate();
        refreshNewDay();
    }


    public final DailySignInfo[] getDailyList() {
        ArrayList<DailySignInfo> infoList = new ArrayList<>();
        ArrayList<NormalSignExt> list = AttendanceConfig.getInstance().getDnormalSignsWithRound(this.attDb.stage);
        for (NormalSignExt prop : list) {
            DailySignInfo tempInfo = new DailySignInfo();
            tempInfo.id = prop.id;
            tempInfo.items = prop.getMiniItems();
            tempInfo.vipDoubleLevel = prop.vip;
            if (this.attDb.signMap.containsKey(Integer.valueOf(prop.id))) {
                tempInfo.state = (((Integer) this.attDb.signMap.get(Integer.valueOf(prop.id))).intValue() > 0) ? ((Integer) this.attDb.signMap.get(Integer.valueOf(prop.id))).intValue() : GiftState.CAN_RECEIVE.getValue();
            } else {
                this.attDb.signMap.put(Integer.valueOf(prop.id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
                tempInfo.state = GiftState.NO_RECEIVE.getValue();
            }
            infoList.add(tempInfo);
        }
        DailySignInfo[] infos = new DailySignInfo[infoList.size()];
        int index = 0;
        for (DailySignInfo info : infoList) {
            infos[index++] = info;
        }
        return infos;
    }


    public final CumulativeSignInfo[] getCumulativeList() {
        ArrayList<CumulativeSignInfo> infoList = new ArrayList<>();
        ArrayList<AccumulateExt> list = AttendanceConfig.getInstance().getDaccumulateWithRound(this.attDb.stage);
        for (AccumulateExt prop : list) {
            CumulativeSignInfo tempInfo = new CumulativeSignInfo();
            tempInfo.id = prop.id;
            tempInfo.items = prop.getMiniItems();
            tempInfo.needCountDay = prop.days;
            tempInfo.boxIcon = prop.iconcode;
            if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(prop.id))) {
                int receive = ((Integer) this.attDb.cumulativeMap.get(Integer.valueOf(prop.id))).intValue();
                if (receive > 0) {
                    tempInfo.state = receive;
                } else if (getSignedCount() >= prop.days) {
                    tempInfo.state = GiftState.CAN_RECEIVE.getValue();
                } else {
                    tempInfo.state = GiftState.NO_RECEIVE.getValue();
                }
            } else {
                tempInfo.state = GiftState.NO_RECEIVE.getValue();
                this.attDb.cumulativeMap.put(Integer.valueOf(prop.id), Integer.valueOf(tempInfo.state));
            }
            infoList.add(tempInfo);
        }
        CumulativeSignInfo[] infos = new CumulativeSignInfo[infoList.size()];
        int index = 0;
        for (CumulativeSignInfo info : infoList) {
            infos[index++] = info;
        }
        return infos;
    }


    public final LuxurySignInfo getLuxuryList() {
        LuxurySignInfo info = new LuxurySignInfo();
        LuxurySignExt tempInfo = AttendanceConfig.getInstance().findDluxurySignWithID(1);
        info.id = tempInfo.id;
        info.items = tempInfo.getMiniItems();
        info.state = this.attDb.luxuryState;
        return info;
    }


    public final int getDailyReward() {
        Date nowDate = new Date();
        if (!DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
            return -1;
        }
        int nextId = getSignedCount() + 1;
        NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, nextId);
        if (prop == null) {
            return -2;
        }
        if (!this.attDb.signMap.containsKey(Integer.valueOf(nextId))) {
            this.attDb.signMap.put(Integer.valueOf(nextId), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
        }

        if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
            return -3;
        }

        this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign);
        this.attDb.lastSignTime = nowDate;
        this.attDb.signMap.put(Integer.valueOf(nextId), Integer.valueOf(GiftState.RECEIVED.getValue()));


        this.player.activityManager.updateSuperScriptList();

        return 0;
    }


    public final int getCumulativeReward(int id) {
        int receive = 0;
        if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(id))) {
            receive = ((Integer) this.attDb.cumulativeMap.get(Integer.valueOf(id))).intValue();
        } else {
            this.attDb.cumulativeMap.put(Integer.valueOf(id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
            receive = GiftState.NO_RECEIVE.getValue();
        }
        if (receive == GiftState.RECEIVED.getValue()) {
            return -1;
        }
        AccumulateExt prop = AttendanceConfig.getInstance().findDaccumulateWithIDAndRound(this.attDb.stage, id);
        if (prop == null) {
            return -2;
        }
        if (getSignedCount() < prop.days) {
            return -3;
        }

        if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
            return -4;
        }

        this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
        this.attDb.cumulativeMap.put(Integer.valueOf(id), Integer.valueOf(GiftState.RECEIVED.getValue()));
        this.player.activityManager.updateSuperScriptList();
        return 0;
    }


    public final int getLuxuryReward() {
        Date now = new Date();
        if (this.attDb.luxuryState == GiftState.RECEIVED.getValue()) {
            return -1;
        }
        if (this.attDb.luxuryState == GiftState.NO_RECEIVE.getValue()) {
            return -2;
        }

        LuxurySignExt prop = AttendanceConfig.getInstance().findDluxurySignWithID(1);

        if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
            return -3;
        }


        this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
        this.attDb.lastLuxuryTime = now;
        this.attDb.luxuryState = GiftState.RECEIVED.getValue();

        updateSuperScript();


        return 0;
    }


    public final int getLeftVipReward(int id) {
        int sign = 0;
        if (this.attDb.signMap.containsKey(Integer.valueOf(id))) {
            sign = ((Integer) this.attDb.signMap.get(Integer.valueOf(id))).intValue();
        } else {
            sign = GiftState.NO_RECEIVE.getValue();
            this.attDb.signMap.put(Integer.valueOf(id), Integer.valueOf(sign));
        }
        sign = ((Integer) this.attDb.signMap.get(Integer.valueOf(id))).intValue();
        int receive = sign;
        if (receive == GiftState.RECEIVED.getValue()) {
            return -1;
        }
        if (receive != GiftState.VIP_NOT_RECEIVE.getValue()) {
            return -2;
        }
        NormalSignExt prop = AttendanceConfig.getInstance().findDnormalSignWithIDAndRound(this.attDb.stage, id);
        if (prop.vip == 0) {
            return -3;
        }


        if (!this.player.getWnBag().testAddCodeItems(prop.items)) {
            return -5;
        }

        this.player.getWnBag().addCodeItems(prop.items, Const.GOODS_CHANGE_TYPE.sign, null, false, false);
        sign = GiftState.RECEIVED.getValue();
        this.attDb.signMap.put(Integer.valueOf(id), Integer.valueOf(sign));
        updateSuperScript();

        return 0;
    }

    public final void onRecharge() {
        if (this.attDb.luxuryState == GiftState.NO_RECEIVE.getValue()) {
            this.attDb.luxuryState = GiftState.CAN_RECEIVE.getValue();
            pushToClientLuxuryReward();
            updateSuperScript();
        }
    }


    public final void pushToClientLuxuryReward() {
        AttendanceHandler.LuxuryRewardPush.Builder builder = AttendanceHandler.LuxuryRewardPush.newBuilder();
        builder.setS2CCode(200);
        LuxurySignInfo info = getLuxuryList();
        builder.setS2CLuxury(info.getLuxuryInfo());
        this.player.receive("area.attendancePush.luxuryRewardPush", (GeneratedMessage) builder.build());
    }


    public final int getSignedCount() {
        int count = 0;
        for (Map.Entry<Integer, Integer> node : (Iterable<Map.Entry<Integer, Integer>>) this.attDb.signMap.entrySet()) {
            int state = ((Integer) node.getValue()).intValue();
            if (state >= GiftState.RECEIVED.getValue()) {
                count++;
            }
        }
        return count;
    }

    private final AttendanceHandler.AttendanceInfo getAttendanceInfo() {
        AttendanceHandler.AttendanceInfo.Builder infoBuilder = AttendanceHandler.AttendanceInfo.newBuilder();
        if (!DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
            infoBuilder.setTodayState(GiftState.RECEIVED.getValue());
        } else {
            infoBuilder.setTodayState(GiftState.CAN_RECEIVE.getValue());
        }
        infoBuilder.setSignedCount(getSignedCount());
        DailySignInfo[] dailyList = getDailyList();
        CumulativeSignInfo[] cumulativeList = getCumulativeList();
        int i;
        for (i = 0; i < dailyList.length; i++) {
            infoBuilder.addDailyList(dailyList[i].getDailyInfo());
        }
        for (i = 0; i < cumulativeList.length; i++) {
            infoBuilder.addCumulativeList(cumulativeList[i].getCumulativeInfo());
        }
        return infoBuilder.build();
    }


    public final AttendanceHandler.GetAttendanceInfoResponse.Builder createGetAttendanceInfoResponse() {
        AttendanceHandler.GetAttendanceInfoResponse.Builder builder = AttendanceHandler.GetAttendanceInfoResponse.newBuilder();
        AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
        LuxurySignInfo luxury = getLuxuryList();
        builder.setS2CLuxury(luxury.getLuxuryInfo());
        builder.setS2CAttendance(info);
        return builder;
    }

    public final AttendanceHandler.GetDailyRewardResponse.Builder createGetDailyRewardResponse() {
        AttendanceHandler.GetDailyRewardResponse.Builder builder = AttendanceHandler.GetDailyRewardResponse.newBuilder();
        AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
        builder.setS2CAttendance(info);
        return builder;
    }

    public final AttendanceHandler.GetCumulativeRewardResponse.Builder createGetCumulativeRewardResponse() {
        AttendanceHandler.GetCumulativeRewardResponse.Builder builder = AttendanceHandler.GetCumulativeRewardResponse.newBuilder();
        AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
        builder.setS2CAttendance(info);
        return builder;
    }

    public final AttendanceHandler.GetLuxuryRewardResponse.Builder createGetLuxuryRewardResponse() {
        AttendanceHandler.GetLuxuryRewardResponse.Builder builder = AttendanceHandler.GetLuxuryRewardResponse.newBuilder();
        LuxurySignInfo luxury = getLuxuryList();
        builder.setS2CLuxury(luxury.getLuxuryInfo());
        return builder;
    }

    public final AttendanceHandler.GetLeftVipRewardResponse.Builder createGetLeftVipRewardResponse() {
        AttendanceHandler.GetLeftVipRewardResponse.Builder builder = AttendanceHandler.GetLeftVipRewardResponse.newBuilder();
        AttendanceHandler.AttendanceInfo info = getAttendanceInfo();
        builder.setS2CAttendance(info);
        return builder;
    }


    public final void updateSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        list.add(getSuperScript());
        this.player.updateSuperScriptList(list);
    }


    public PlayerHandler.SuperScriptType getSuperScript() {
        int number = 0;

        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SIGN.getValue())) {
            PlayerHandler.SuperScriptType.Builder builder = PlayerHandler.SuperScriptType.newBuilder();
            builder.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_SIGN.getValue());
            builder.setNumber(number);
            return builder.build();
        }
        int signedCount = 0;
        for (Map.Entry<Integer, Integer> node : (Iterable<Map.Entry<Integer, Integer>>) this.attDb.signMap.entrySet()) {
            int state = ((Integer) node.getValue()).intValue();
            if (state >= GiftState.RECEIVED.getValue()) {
                signedCount++;
            }
        }
        if (DateUtil.canRefreshData(5, this.attDb.lastSignTime)) {
            number++;
        }

        ArrayList<AccumulateExt> cumulativeList = AttendanceConfig.getInstance().getDaccumulateWithRound(this.attDb.stage);
        for (int i = 0; i < cumulativeList.size(); i++) {
            AccumulateExt prop = cumulativeList.get(i);
            int receive = 0;
            if (this.attDb.cumulativeMap.containsKey(Integer.valueOf(prop.id))) {
                receive = ((Integer) this.attDb.cumulativeMap.get(Integer.valueOf(prop.id))).intValue();
            } else {
                this.attDb.cumulativeMap.put(Integer.valueOf(prop.id), Integer.valueOf(GiftState.NO_RECEIVE.getValue()));
                receive = GiftState.NO_RECEIVE.getValue();
            }
            if (receive <= 0 && signedCount >= prop.days) {
                number++;
            }
        }
        if (this.attDb.luxuryState == GiftState.CAN_RECEIVE.getValue()) {
            number++;
        }
        PlayerHandler.SuperScriptType.Builder scriptNum = PlayerHandler.SuperScriptType.newBuilder();
        scriptNum.setType(Const.SUPERSCRIPT_TYPE.FLAG_WELFARE_SIGN.getValue());
        scriptNum.setNumber(number);

        return scriptNum.build();
    }
}


