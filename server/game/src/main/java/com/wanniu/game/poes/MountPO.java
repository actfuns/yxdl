package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.common.Const;

import java.util.List;


@DBTable("player_mount")
public class MountPO
        extends GEntity {
    public int starLv;
    public int rideLevel;
    public int usingSkinId = 0;

    public List<Integer> mountSkins;

    public int fightPower;

    public int rideFlag = Const.MOUNT_RIDING_STATE.off.getValue();


    public boolean firstChoose;


    public MountPO() {
        this.firstChoose = false;
    }
}


