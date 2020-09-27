package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class CreatePlayerData
        extends AnsycPublisher {
    protected String channel() {
        return "data.CreatePlayer";
    }

    public CreatePlayerData(PlayerPO player) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("uid", player.uid);
        this.data.put("pro", Integer.valueOf(player.pro));
        this.data.put("mac", player.mac);
        this.data.put("ip", player.ip);
        this.data.put("hour", Integer.valueOf(this.now.getHour()));
    }
}


