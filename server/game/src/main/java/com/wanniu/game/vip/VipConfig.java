package com.wanniu.game.vip;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.VipCO;

import java.util.Collection;

public class VipConfig {
    private static VipConfig _instance;
    private VipCO[] vipProps;
    private int maxVipLevel;

    public static VipConfig getInstance() {
        if (_instance == null) {
            _instance = new VipConfig();
        }
        return _instance;
    }


    private VipConfig() {
        if (this.vipProps == null) {
            Collection<VipCO> loadVips = GameData.Vips.values();
            this.vipProps = new VipCO[loadVips.size()];
            loadVips.toArray(this.vipProps);
            int maxVipLev = 0;
            for (VipCO v : this.vipProps) {
                if (v.vipLevel > maxVipLev) {
                    maxVipLev = v.vipLevel;
                }
            }


            this.maxVipLevel = maxVipLev;
        }
    }


    public int getMaxVipLevel() {
        return this.maxVipLevel;
    }

    public VipCO[] getVipProps() {
        return this.vipProps;
    }

    public VipCO findVipProp(int vipLev) {
        for (VipCO v : this.vipProps) {
            if (v.vipLevel > vipLev) {
                return v;
            }
        }
        return null;
    }

    public int getVipFunc(int vip, VipFuncType vft) {
        VipCO vipProp = findVipProp(vip);
        if (vipProp == null) {
            return 0;
        }
        switch (vft) {
            case MONERY_TREE:
                return vipProp.vipMoneyTime;
            case MONSTER_KILL_EXP:
                return vipProp.extraExp;
            case SINGLE_SCENE:
                return vipProp.singleDungeonTime;
            case TEAM_SCENE:
                return vipProp.teamDungeonTime;
            case SECRET_SCENE:
                return vipProp.mysteriesDungeonTime;
            case SUPER_SCENE:
                return vipProp.superDungeonTime;
            case SIN_COM:
                return vipProp.soloTime;
            case CONSIGNMENT_STORE:
                return vipProp.storeItemNum;
            case BUY_SINGLE_SCENE:
                return vipProp.buySingleDungeonTime;
            case BUY_TEAM_SCENE:
                return vipProp.buyTeamDungeonTime;
            case BUY_SUPER_SCENE:
                return vipProp.buySuperDungeonTime;
        }
        return 0;
    }
}


