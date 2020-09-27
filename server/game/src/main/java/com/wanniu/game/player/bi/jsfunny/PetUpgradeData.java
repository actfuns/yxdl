package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class PetUpgradeData
        extends AnsycPublisher {
    protected String channel() {
        return "data.PetUpgrade";
    }

    public PetUpgradeData(PlayerPO player, int petId, String petName, int upLevel, int level, long exp) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("petId", Integer.valueOf(petId));
        this.data.put("petName", petName);
        this.data.put("upLevel", Integer.valueOf(upLevel));
        this.data.put("level", Integer.valueOf(level));
        this.data.put("exp", Long.valueOf(exp));
    }
}


