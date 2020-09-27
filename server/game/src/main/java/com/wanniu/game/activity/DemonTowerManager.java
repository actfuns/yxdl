package com.wanniu.game.activity;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.DropListExt;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.DemonTowerPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;

import pomelo.Common;


public class DemonTowerManager {
    private static Map<String, ScheduledFuture<?>> scheduleMap = new HashMap<>();


    public DemonTowerPO po;


    private WNPlayer player;


    TimerTask timerTask;


    public DemonTowerManager(WNPlayer player) {
        this.timerTask = new TimerTask() {
            public void run() {
                String callbackPlayerId = DemonTowerManager.this.player.getId();
                DemonTowerPO tempPo = (DemonTowerPO) PlayerPOManager.findPO(ConstsTR.PLAYER_DEMON_TOWER, DemonTowerManager.this.player.getId(), DemonTowerPO.class);
                tempPo.sweepEndTime = null;

                MailSysData mailData = new MailSysData("DemonTower_sweep");

                mailData.attachments = new ArrayList();
                HashMap<String, Integer> rewardMap = DemonTowerManager.this.ComputeSweepRewards();
                for (String code : rewardMap.keySet()) {
                    MailData.Attachment item = new MailData.Attachment();
                    item.itemCode = code;
                    item.itemNum = ((Integer) rewardMap.get(code)).intValue();
                    mailData.attachments.add(item);
                }
                MailUtil.getInstance().sendMailToOnePlayer(callbackPlayerId, (MailData) mailData, Const.GOODS_CHANGE_TYPE.DemonTower);

                DemonTowerManager.scheduleMap.remove(DemonTowerManager.this.player.getId());
            }
        };
        this.po = (DemonTowerPO) PlayerPOManager.findPO(ConstsTR.PLAYER_DEMON_TOWER, player.getId(), DemonTowerPO.class);
        if (this.po == null) {
            this.po = new DemonTowerPO(player.getId(), 1, 0, GlobalConfig.ResetNum);
            PlayerPOManager.put(ConstsTR.PLAYER_DEMON_TOWER, player.getId(), (GEntity) this.po);
        }
        this.player = player;
    }

    public void init() {
        if (this.po.sweepEndTime != null) {
            Date now = new Date();
            long timeOffset = this.po.sweepEndTime.getTime() - now.getTime();
            if (timeOffset <= 0L) {
                GetSweepRewards();
            } else if (!scheduleMap.containsKey(this.player.getId())) {
                ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(this.timerTask, timeOffset);
                scheduleMap.put(this.player.getId(), scheduledFuture);
            }
        }
    }

    public void FinishSweepWhenSpeeping() {
        if (this.po.sweepEndTime == null) {
            Out.debug(new Object[]{"不在扫荡中"});
        }
        GetSweepRewards();
        ((ScheduledFuture) scheduleMap.get(this.player.getId())).cancel(false);
        scheduleMap.remove(this.player.getId());
    }

    public int GetSecondToEndTime() {
        if (this.po.sweepEndTime != null) {
            Date now = new Date();
            return (int) ((this.po.sweepEndTime.getTime() - now.getTime()) / 1000L);
        }
        return 0;
    }

    public void StartToSweep(int sweepTime) {
        if (this.po.sweepCountLeft <= 0) {
            Out.error(new Object[]{"没有扫荡次数！"});
            return;
        }
        this.po.sweepCountLeft--;
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(13, sweepTime);
        this.po.sweepEndTime = calendar.getTime();
        ScheduledFuture<?> scheduledFuture = JobFactory.addDelayJob(this.timerTask, (sweepTime * 1000));
        scheduleMap.put(this.player.getId(), scheduledFuture);
        this.player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1);
    }

    public void FinishSweep() {
        if (this.po.sweepEndTime != null) {
            Out.debug(new Object[]{"在扫荡中"});
        }
        GetSweepRewards();

        this.player.dailyActivityMgr.onEvent(Const.DailyType.DEMON_TOWER, "0", 1);
    }


    public HashMap<String, Integer> ComputeSweepRewards() {
        HashMap<String, Integer> rewardMap = new HashMap<>();

        if (this.po.maxFloor == 1) {
            return rewardMap;
        }
        for (int i = 1; i < this.po.maxFloor; i++) {
            DropListExt dropListExt = (DropListExt) GameData.DropLists.get(Integer.valueOf(i));

            for (Map.Entry<String, Integer> entry : (Iterable<Map.Entry<String, Integer>>) dropListExt.rewardPreview.entrySet()) {
                if (!rewardMap.containsKey(entry.getKey()))
                    rewardMap.put(entry.getKey(), Integer.valueOf(0));
                rewardMap.put(entry.getKey(), Integer.valueOf(((Integer) rewardMap.get(entry.getKey())).intValue() + ((Integer) entry.getValue()).intValue()));
            }
        }


        return rewardMap;
    }


    private void GetSweepRewards() {
        HashMap<String, Integer> rewardMap = ComputeSweepRewards();

        for (String code : rewardMap.keySet()) {
            this.player.bag.addCodeItem(code, ((Integer) rewardMap.get(code)).intValue(), Const.ForceType.DEFAULT, Const.GOODS_CHANGE_TYPE.DemonTower);
        }


        this.po.sweepEndTime = null;
    }


    public void UpdateSweepCount() {
        this.po.sweepCountLeft = 1;
    }

    public void refreshNewDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.get(7) == 2) {
            DemonTowerService.getInstance().dispatchWeekReward(this.player);
        }
    }


    public Common.DemonTowerFloorInfo.Builder getFloorInfoBuilder(int floorId) {
        Common.DemonTowerFloorInfo.Builder floorInfoBuilder = Common.DemonTowerFloorInfo.newBuilder();
        floorInfoBuilder.setFloorId(floorId);

        String firstPlayerId = null;
        Date firstPlayerDate = null;
        String fastPlayerId = null;
        Long fastPlayerTime = null;
        synchronized ((DemonTowerService.getInstance()).demonTowerCenterPO) {
            firstPlayerId = (DemonTowerService.getInstance()).demonTowerCenterPO.firstPlayerIds.get(floorId - 1);
            firstPlayerDate = (DemonTowerService.getInstance()).demonTowerCenterPO.firstPlayerDates.get(floorId - 1);
            fastPlayerId = (DemonTowerService.getInstance()).demonTowerCenterPO.fastPlayerIds.get(floorId - 1);
            fastPlayerTime = (DemonTowerService.getInstance()).demonTowerCenterPO.fastPlayerTimes.get(floorId - 1);
        }


        if (firstPlayerId != null) {
            PlayerPO playerPO = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, firstPlayerId, PlayerPO.class);
            if (playerPO != null) {
                floorInfoBuilder.setFirstPlayerName(playerPO.name);
                floorInfoBuilder.setFirstPlayerDate(firstPlayerDate.getTime());
            } else {

                DemonTowerService.getInstance().clearFirstData(floorId);
            }
        }


        if (fastPlayerId != null) {
            PlayerPO playerPO = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, fastPlayerId, PlayerPO.class);
            if (playerPO != null) {
                floorInfoBuilder.setFastPlayerName(playerPO.name);
                floorInfoBuilder.setFastPlayerTime(fastPlayerTime.intValue() / 1000);
            } else {

                DemonTowerService.getInstance().clearFastData(floorId);
            }
        }

        if (this.po.leastTimeList.size() >= floorId) {
            floorInfoBuilder.setMyFastTime(((Long) this.po.leastTimeList.get(floorId - 1)).intValue() / 1000);
        }

        return floorInfoBuilder;
    }


    public int getMaxFloor() {
        return this.po.maxFloor;
    }


    public int getSweepCountLeft() {
        return this.po.sweepCountLeft;
    }
}


