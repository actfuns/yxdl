package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class LuckDrawData
        extends AnsycPublisher {
    protected String channel() {
        return "data.LuckDraw";
    }

    public LuckDrawData(PlayerPO player, int type, int count, int money, int itemcount) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("type", Integer.valueOf(type));
        this.data.put("count", Integer.valueOf(count));
        this.data.put("money", Integer.valueOf(money));
        this.data.put("itemcount", Integer.valueOf(itemcount));
    }
}


