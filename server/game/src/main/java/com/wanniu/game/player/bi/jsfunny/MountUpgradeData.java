package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class MountUpgradeData
        extends AnsycPublisher {
    protected String channel() {
        return "data.MountUpgrade";
    }

    public MountUpgradeData(PlayerPO player, int rideLevel, int starLv) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("rideLevel", Integer.valueOf(rideLevel));
        this.data.put("starLv", Integer.valueOf(starLv));
    }
}


