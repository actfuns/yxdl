package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class ItemFlowData
        extends AnsycPublisher {
    protected String channel() {
        return "data.ItemFlow";
    }


    protected boolean oneDay() {
        return true;
    }

    public ItemFlowData(PlayerPO player, int operate, String itemcode, int count, boolean bind, int origin) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("operate", Integer.valueOf(operate));
        this.data.put("itemcode", itemcode);
        this.data.put("count", Integer.valueOf(count));
        this.data.put("bind", Boolean.valueOf(bind));
        this.data.put("origin", Integer.valueOf(origin));
    }
}


