package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class FashionData
        extends AnsycPublisher {
    protected String channel() {
        return "data.Fashion";
    }

    public FashionData(PlayerPO player, String code) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("code", code);
    }
}


