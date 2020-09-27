package com.wanniu.game.activity;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.DropListExt;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DemonTowerCenterPO;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class DemonTowerService {
    static DemonTowerService demonTowerService;
    public DemonTowerCenterPO demonTowerCenterPO;

    public static DemonTowerService getInstance() {
        if (demonTowerService == null) {
            demonTowerService = new DemonTowerService();
        }
        return demonTowerService;
    }

    public void init() {
        String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value);
        if (data == null) {
            this.demonTowerCenterPO = new DemonTowerCenterPO();
            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
        } else {

            this.demonTowerCenterPO = (DemonTowerCenterPO) JSON.parseObject(data, DemonTowerCenterPO.class);
        }
    }


    public boolean finishFloor(int floorId, String playerId, long time) {
        boolean refreshRechord = false;
        synchronized (this.demonTowerCenterPO) {
            if (this.demonTowerCenterPO.firstPlayerIds.get(floorId - 1) == null) {
                this.demonTowerCenterPO.firstPlayerIds.set(floorId - 1, playerId);
                this.demonTowerCenterPO.firstPlayerDates.set(floorId - 1, new Date());
            }


            if (this.demonTowerCenterPO.fastPlayerTimes.get(floorId - 1) == null || ((Long) this.demonTowerCenterPO.fastPlayerTimes
                    .get(floorId - 1)).longValue() > time) {
                this.demonTowerCenterPO.fastPlayerIds.set(floorId - 1, playerId);
                this.demonTowerCenterPO.fastPlayerTimes.set(floorId - 1, Long.valueOf(time));
                refreshRechord = true;
            }

            GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
        }
        return refreshRechord;
    }

    public void clearFirstData(int floorId) {
        synchronized (this.demonTowerCenterPO) {
            if (this.demonTowerCenterPO.firstPlayerIds.get(floorId - 1) == null) {
                this.demonTowerCenterPO.firstPlayerIds.set(floorId - 1, null);
                this.demonTowerCenterPO.firstPlayerDates.set(floorId - 1, null);

                GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
            }
        }
    }

    public void clearFastData(int floorId) {
        synchronized (this.demonTowerCenterPO) {
            if (this.demonTowerCenterPO.fastPlayerTimes.get(floorId - 1) == null) {
                this.demonTowerCenterPO.fastPlayerIds.set(floorId - 1, null);
                this.demonTowerCenterPO.fastPlayerTimes.set(floorId - 1, null);
                GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
            }
        }
    }

    public void clearAllData() {
        this.demonTowerCenterPO.firstPlayerIds = new LinkedList();
        this.demonTowerCenterPO.firstPlayerDates = new LinkedList();
        this.demonTowerCenterPO.fastPlayerIds = new LinkedList();
        this.demonTowerCenterPO.fastPlayerTimes = new LinkedList();
        for (DropListExt dropListExt : GameData.DropLists.values()) {
            this.demonTowerCenterPO.firstPlayerIds.add(null);
            this.demonTowerCenterPO.firstPlayerDates.add(null);
            this.demonTowerCenterPO.fastPlayerIds.add(null);
            this.demonTowerCenterPO.fastPlayerTimes.add(null);
        }

        GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.DemonTower.value, JSON.toJSONString(this.demonTowerCenterPO));
    }


    public void dispatchWeekReward(WNPlayer player) {
        List<NormalItem> items = new LinkedList<>();

        synchronized (this.demonTowerCenterPO) {
            for (int i = 0; i < this.demonTowerCenterPO.fastPlayerIds.size(); i++) {
                String pid = this.demonTowerCenterPO.fastPlayerIds.get(i);
                if (pid != null &&
                        pid.equals(player.getId())) {
                    DropListExt dropListExt = (DropListExt) GameData.DropLists.get(Integer.valueOf(i + 1));
                    List<NormalItem> item = ItemUtil.createItemsByItemCode(dropListExt.weekRewardPreview);
                    items.addAll(item);
                }
            }
        }


        MailSysData mailData = new MailSysData("DemonTowerFastRecordReward");
        List<MailData.Attachment> list_attach = new ArrayList<>();
        for (NormalItem item : items) {

            if (item.isVirtual()) {
                player.bag.addEntityItem(item, Const.GOODS_CHANGE_TYPE.DemonTower);
                continue;
            }
            MailData.Attachment attachment = new MailData.Attachment();
            attachment.itemCode = item.itemCode();
            attachment.itemNum = item.getNum();
            list_attach.add(attachment);
        }

        if (list_attach.size() > 0) {
            mailData.attachments = list_attach;
            MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.DemonTower);
        }
    }
}


