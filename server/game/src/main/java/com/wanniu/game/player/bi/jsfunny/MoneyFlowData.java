package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.poes.PlayerPO;


public class MoneyFlowData
        extends AnsycPublisher {
    protected String channel() {
        return "data.MoneyFlow";
    }


    protected boolean oneDay() {
        return true;
    }

    public MoneyFlowData(PlayerPO player, VirtualItemType type, int before, int operate, int value, int after, int origin) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("type", type.getItemcode());
        this.data.put("before", Integer.valueOf(before));
        this.data.put("operate", Integer.valueOf(operate));
        this.data.put("value", Integer.valueOf(value));
        this.data.put("after", Integer.valueOf(after));
        this.data.put("origin", Integer.valueOf(origin));
    }
}


