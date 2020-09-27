package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class RechargeData
        extends AnsycPublisher {
    protected String channel() {
        return "data.Recharge";
    }

    public RechargeData(PlayerPO player, int productId, int type, int money) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("productId", Integer.valueOf(productId));
        this.data.put("type", Integer.valueOf(type));
        this.data.put("money", Integer.valueOf(money));
        this.data.put("hour", Integer.valueOf(this.now.getHour()));
    }
}


