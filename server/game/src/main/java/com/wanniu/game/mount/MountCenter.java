package com.wanniu.game.mount;

import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.poes.MountPO;
import com.wanniu.redis.PlayerPOManager;

public class MountCenter {
    private static MountCenter instance;

    public static synchronized MountCenter getInstance() {
        if (instance == null)
            instance = new MountCenter();
        return instance;
    }


    public MountPO findMount(String playerId) {
        MountPO mount = (MountPO) PlayerPOManager.findPO(ConstsTR.mountTR, playerId, MountPO.class);
        return mount;
    }
}


