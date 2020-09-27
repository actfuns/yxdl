package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class ShopData
        extends AnsycPublisher {
    protected String channel() {
        return "data.Shop";
    }

    public ShopData(PlayerPO player, String itemcode, int itemnum, int type, int money) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("itemcode", itemcode);
        this.data.put("itemnum", Integer.valueOf(itemnum));
        this.data.put("type", Integer.valueOf(type));
        this.data.put("money", Integer.valueOf(money));
    }
}


