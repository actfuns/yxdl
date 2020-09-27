package com.wanniu.game.mount;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.RideListExt;
import com.wanniu.game.data.ext.SkinListExt;
import com.wanniu.game.player.AttributeUtil;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.MountPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.game.task.TaskEvent;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pomelo.Common;
import pomelo.area.MountHandler;
import pomelo.area.PlayerHandler;


public class MountManager
        extends ModuleManager {
    private WNPlayer player;
    public MountPO mount;
    public Map<Const.PlayerBtlData, Integer> data_mount_show = new HashMap<>();
    public Map<Const.PlayerBtlData, Integer> data_mount_show_next = new HashMap<>();
    public Map<Const.PlayerBtlData, Integer> data_mount_final = new HashMap<>();

    public MountManager(WNPlayer player, MountPO mount) {
        this.player = player;
        this.mount = mount;
        player.player.openMount = (mount != null);
        calMountData();
    }

    public static MountPO createMount(String playerId) {
        MountPO mount = new MountPO();
        mount.rideLevel = GlobalConfig.Ride_InitUpLevel;
        mount.starLv = GlobalConfig.Ride_InitStar;
        mount.mountSkins = new ArrayList();
        mount.usingSkinId = GlobalConfig.Ride_DefaultSkinID;
        mount.mountSkins.add(Integer.valueOf(mount.usingSkinId));

        PlayerPOManager.put(ConstsTR.mountTR, playerId, (GEntity) mount);
        return mount;
    }


    private void calMountData() {
        if (this.mount == null || !this.player.functionOpenManager.isOpen(Const.FunctionType.MOUNT.getValue())) {
            return;
        }

        this.data_mount_show.clear();
        this.data_mount_final.clear();
        this.data_mount_show = MountUtil.getMountBaseProp(this.mount.rideLevel, this.mount.starLv);
        int next_lvl = this.mount.rideLevel;
        int next_star = this.mount.starLv + 1;
        if (next_star > GlobalConfig.mountMaxStar) {
            next_lvl++;
            next_star = 0;
        }
        if (next_lvl > GlobalConfig.Ride_MaxUpLevel) {
            this.data_mount_show_next.clear();
        } else {
            this.data_mount_show_next = MountUtil.getMountBaseProp(next_lvl, next_star);
        }
        AttributeUtil.addData2AllData(this.data_mount_show, this.data_mount_final);
        int maxSpeed = 0;
        for (Iterator<Integer> iterator = this.mount.mountSkins.iterator(); iterator.hasNext(); ) {
            int skinId = ((Integer) iterator.next()).intValue();
            SkinListExt skin = (SkinListExt) GameData.SkinLists.get(Integer.valueOf(skinId));
            if (skin != null) {
                AttributeUtil.addData2AllData(skin.skinAttrs, this.data_mount_final);
                if (skin.skinAttrs.containsKey(Const.PlayerBtlData.RunSpeed) && (
                        (Integer) skin.skinAttrs.get(Const.PlayerBtlData.RunSpeed)).intValue() > maxSpeed) {
                    maxSpeed = ((Integer) skin.skinAttrs.get(Const.PlayerBtlData.RunSpeed)).intValue();
                }
            }
        }


        this.data_mount_final.put(Const.PlayerBtlData.RunSpeed, Integer.valueOf(maxSpeed));
        if (this.mount.rideFlag == Const.MOUNT_RIDING_STATE.off.getValue()) {
            this.data_mount_final.remove(Const.PlayerBtlData.RunSpeed);
        }

        refreshFightPower();
        if (this.player.rankManager != null) {
            this.player.rankManager.onEvent(RankType.Mount, new Object[]{Integer.valueOf(this.mount.fightPower), Integer.valueOf(this.mount.usingSkinId)});
        }
    }


    public int upgradeStar() {
        if (this.mount.starLv >= GlobalConfig.mountMaxStar)
            return -1;
        RideListExt prop = GameData.findRideLists(t -> (t.rideLevel == this.mount.rideLevel)).get(0);


        if (this.player.bag.discardItem(prop.upStarItemCode, prop.upStarItemCount, Const.GOODS_CHANGE_TYPE.equipColorUp)) {
            this.mount.starLv++;
            calMountData();
            this.player.onMountPropChange();
        } else {
            return -2;
        }

        this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.TRAIN_RIDE, "0", 1);

        this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, "0", this.mount.rideLevel * 11 + this.mount.starLv);

        LogReportService.getInstance().ansycReportMountUpgrade(this.player, this.mount.rideLevel, this.mount.starLv);
        BILogService.getInstance().ansycReportRideTrainBI(this.player.getPlayer(), 1, this.mount.rideLevel, this.mount.starLv, prop.upStarItemCode, prop.upStarItemCount);
        return 1;
    }


    public int upgradeLv() {
        if (this.mount.rideLevel >= GlobalConfig.Ride_MaxUpLevel)
            return -1;
        if (this.mount.starLv != GlobalConfig.mountMaxStar)
            return -2;
        RideListExt prop = GameData.findRideLists(t -> (t.rideLevel == this.mount.rideLevel)).get(0);
        if (this.player.bag.discardItem(prop.upLevelItemCode, prop.upLevelItemCount, Const.GOODS_CHANGE_TYPE.equipLevelUp)) {
            this.mount.rideLevel++;
            this.mount.starLv = 0;
            calMountData();
            this.player.onMountPropChange();
        } else {

            return -3;
        }
        this.player.achievementManager.onHorseLevelChange(this.mount.rideLevel);

        this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.TRAIN_RIDE, "0", 1);

        this.player.getPlayerTasks().dealTaskEvent(Const.TaskType.MOUNT_UPLEVEL, "0", this.mount.rideLevel * 11 + this.mount.starLv);

        LogReportService.getInstance().ansycReportMountUpgrade(this.player, this.mount.rideLevel, this.mount.starLv);
        BILogService.getInstance().ansycReportRideTrainBI(this.player.getPlayer(), 2, this.mount.rideLevel, this.mount.starLv, prop.upLevelItemCode, prop.upLevelItemCount);

        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.MOUNT_UPGRADE_LV, new Object[]{Integer.valueOf(getMountLevel())});
        return 1;
    }


    public int changeSkin(int _skinId) {
        if (this.mount == null) {
            return -1;
        }
        if (!this.mount.mountSkins.contains(Integer.valueOf(_skinId))) {
            return -1;
        }
        if (this.mount.usingSkinId == _skinId) {
            return -2;
        }
        this.mount.usingSkinId = _skinId;
        calMountData();
        this.player.onMountPropChange();
        this.player.refreshBattlerServerAvatar();
        return 1;
    }


    public int addNewSkin(int _skinId) {
        if (!this.player.player.openMount || this.mount == null)
            return -3;
        if (this.mount.mountSkins.contains(Integer.valueOf(_skinId)))
            return -1;
        if (!GameData.SkinLists.containsKey(Integer.valueOf(_skinId)))
            return -2;
        this.mount.mountSkins.add(Integer.valueOf(_skinId));


        LogReportService.getInstance().ansycReportMountSkin(this.player, _skinId);
        SkinListExt prop = (SkinListExt) GameData.SkinLists.get(Integer.valueOf(_skinId));
        if (prop != null) {
            BILogService.getInstance().ansycReportMountActivate(this.player.getPlayer(), _skinId, prop.skinName);
        }

        MountHandler.MountNewSkinPush.Builder data = MountHandler.MountNewSkinPush.newBuilder();
        data.setS2CSkinId(_skinId);
        this.player.receive("area.mountPush.mountNewSkinPush", (GeneratedMessage) data.build());


        this.player.achievementManager.onMountGot();
        return 1;
    }

    public int getMountLevel() {
        if (this.mount != null)
            return this.mount.rideLevel;
        return 0;
    }


    public void refreshFightPower() {
        this.mount.fightPower = CommonUtil.calFightPower(this.data_mount_final);
    }


    public void openMount() {
        if (this.mount == null) {
            this.mount = createMount(this.player.getId());
            this.player.player.openMount = true;
            calMountData();
            this.player.onMountPropChange();
        }
    }


    public boolean isOpenMount() {
        if (this.mount != null)
            return true;
        return false;
    }

    public MountHandler.MountData.Builder getMountData() {
        MountHandler.MountData.Builder data = MountHandler.MountData.newBuilder();
        data.setRideLevel(this.mount.rideLevel);
        data.setUsingSkinID(this.mount.usingSkinId);
        data.addAllMountSkins(this.mount.mountSkins);
        List<Common.AttributeBase> list = new ArrayList<>();
        for (Const.PlayerBtlData pbd : this.data_mount_show.keySet()) {
            if (pbd == Const.PlayerBtlData.RunSpeed)
                continue;
            Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
            ab.setId(pbd.id);
            ab.setMaxValue(((Integer) this.data_mount_show.get(pbd)).intValue());
            list.add(ab.build());
        }
        data.setStarLv(this.mount.starLv);
        data.setFightPowerValue(0);
        data.addAllMountAttrs(list);
        List<Common.AttributeBase> list_next = new ArrayList<>();
        for (Const.PlayerBtlData pbd : this.data_mount_show_next.keySet()) {
            if (pbd == Const.PlayerBtlData.RunSpeed)
                continue;
            Common.AttributeBase.Builder ab = Common.AttributeBase.newBuilder();
            ab.setId(pbd.id);
            ab.setMaxValue(((Integer) this.data_mount_show_next.get(pbd)).intValue());
            list_next.add(ab.build());
        }
        data.addAllMountAttrsNext(list_next);
        return data;
    }


    public final int ridingMount(int isUp) {
        if (this.mount == null) {
            return 0;
        }
        int times = 0;
        this.player.getXmdsManager().refreshSummonMount(this.player.getId(), times, isUp);


        return 0;
    }

    public void onEvent(TaskEvent event) {
        if (event.type == Const.EventType.summonMount.getValue()) {
            boolean flag = ((Boolean) event.params[0]).booleanValue();


            int rideFlag = flag ? Const.MOUNT_RIDING_STATE.on.getValue() : Const.MOUNT_RIDING_STATE.off.getValue();
            if (this.mount == null) {
                return;
            }


            this.mount.rideFlag = rideFlag;


            pushToClientMountsFlag();
            this.player.refreshBattlerServerAvatar();
            calMountData();
            this.player.onMountPropChange();

            this.mount.firstChoose = true;
        }
    }


    public void pushToClientMountsFlag() {
        MountHandler.MountFlagPush.Builder data = MountHandler.MountFlagPush.newBuilder();
        if (this.mount == null) {
            data.setS2CFlag(Const.MOUNT_RIDING_STATE.off.getValue());
        } else {
            data.setS2CFlag(this.mount.rideFlag);
            data.setS2CUsingSkinId(this.mount.usingSkinId);
        }

        this.player.receive("area.mountPush.mountFlagPush", (GeneratedMessage) data.build());
    }

    public void unMountData() {
        if (this.mount != null) {
            if (this.mount.rideFlag == 0) {
                return;
            }
            this.mount.rideFlag = Const.MOUNT_RIDING_STATE.off.getValue();
            calMountData();
            this.player.onMountPropChange();
        }


        pushToClientMountsFlag();
    }

    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        int number = 0;
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.MOUNT.getValue());
        data.setNumber(number);

        list.add(data.build());
        return list;
    }

    public void addTestSKin() {
        List<Integer> mountSkins = this.mount.mountSkins;
        if (mountSkins.size() < 4) {
            int maxId = ((Integer) mountSkins.get(mountSkins.size() - 1)).intValue();

            addNewSkin(maxId + 1);
        }
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {

        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.MOUNT;
    }


    public void addAllSkin() {
        if (this.mount == null)
            return;
        this.mount.mountSkins = new ArrayList();
        for (SkinListExt skin : GameData.SkinLists.values()) {
            this.mount.mountSkins.add(Integer.valueOf(skin.skinID));
        }
    }

    public boolean chooseFirstSkin(int skinId) {
        if (this.mount == null)
            return false;
        if (this.mount.firstChoose)
            return false;
        SkinListExt prop = (SkinListExt) GameData.SkinLists.get(Integer.valueOf(skinId));
        if (prop == null || prop.skinQColor != 1)
            return false;
        this.mount.mountSkins.clear();
        this.mount.usingSkinId = skinId;
        this.mount.firstChoose = true;
        addNewSkin(skinId);
        return true;
    }
}


