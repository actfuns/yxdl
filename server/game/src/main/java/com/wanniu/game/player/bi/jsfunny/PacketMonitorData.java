package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.poes.PlayerPO;


public class PacketMonitorData
        extends AnsycPublisher {
    protected String channel() {
        return "data.PacketMonitor";
    }

    public PacketMonitorData(PlayerPO player, Integer count, short index, String route) {
        this.data.put("os", player.os);
        this.data.put("channel", player.channel);
        this.data.put("subchannel", player.subchannel);
        this.data.put("id", player.id);
        this.data.put("name", player.name);

        this.data.put("level", Integer.valueOf(player.level));
        this.data.put("count", count);
        this.data.put("index", Short.valueOf(index));
        this.data.put("route", route);
    }
}


