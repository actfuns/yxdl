package com.wanniu.game.rank;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.MountPO;
import com.wanniu.game.poes.PetNewPO;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.Map;


public class RankManager {
    private final WNPlayer player;
    private PlayerRankInfoPO rankPO;

    public RankManager(WNPlayer player) {
        this.player = player;
        this.rankPO = RankCenter.getInstance().findRankPO(player.getId());
        if (this.rankPO == null) {
            this.rankPO = initRankPO();
            PlayerPOManager.put(ConstsTR.playerRankTR, player.getId(), (GEntity) this.rankPO);
        }
    }

    public PlayerRankInfoPO getRankPO() {
        return this.rankPO;
    }

    private PlayerRankInfoPO initRankPO() {
        PlayerRankInfoPO info = new PlayerRankInfoPO();
        info.setId(this.player.getId());
        info.setName(this.player.getName());
        info.setPro(this.player.getPro());
        info.setLevel(this.player.getLevel());
        info.setUpOrder(this.player.getUpOrder());
        info.setFightPower(this.player.getFightPower());

        Map<Const.PlayerBtlData, Integer> attrs = this.player.btlDataManager.finalInflus;
        info.setHp(((Integer) attrs.getOrDefault(Const.PlayerBtlData.MaxHP, Integer.valueOf(0))).intValue());
        info.setMag(((Integer) attrs.getOrDefault(Const.PlayerBtlData.Mag, Integer.valueOf(0))).intValue());
        info.setPhy(((Integer) attrs.getOrDefault(Const.PlayerBtlData.Phy, Integer.valueOf(0))).intValue());

        info.setXianyuan(this.player.moneyManager.getXianYuan());
        info.setDemonTower(this.player.demonTowerManager.getMaxFloor());


        MountPO mount = this.player.mountManager.mount;
        info.setMountFightPower((mount == null) ? 0 : mount.fightPower);
        info.setMountSkinId((mount == null) ? 0 : mount.usingSkinId);


        PetNewPO petMax = null;
        int petFightPowerMax = 0;
        for (PetNewPO pet : this.player.petNewManager.petsPO.pets.values()) {
            int petFightPower = pet.fightPower;
            if (petFightPower > petFightPowerMax) {
                petFightPowerMax = petFightPower;
                petMax = pet;
            }
        }
        if (petMax != null) {
            info.setPetId(petMax.id);
            info.setPetName(petMax.name);
            info.setPetFightPower(petMax.fightPower);
        } else {
            info.setPetId(1);
            info.setPetName("");
            info.setPetFightPower(1);
        }
        return info;
    }


    public void onEvent(RankType type, Object... value) {
        if (this.player.isRobot()) {
            return;
        }
        GWorld.getInstance().ansycExec(() -> type.getHandler().handle(this.player, value));
    }


    public void onChangeName() {
        this.rankPO.setName(this.player.getName());
    }
}


