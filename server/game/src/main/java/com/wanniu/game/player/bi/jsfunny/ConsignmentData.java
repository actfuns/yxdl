package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class ConsignmentData
        extends AnsycPublisher {
    protected String channel() {
        return "data.Consignment";
    }

    public ConsignmentData(PlayerPO player, String buyerId, String buyerName, String itemcode, int itemcount) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("buyerId", buyerId);
        this.data.put("buyerName", buyerName);
        this.data.put("itemcode", itemcode);
        this.data.put("itemcount", Integer.valueOf(itemcount));
    }
}


