package com.wanniu.game.player.bi.jsfunny;

import com.wanniu.game.player.WNPlayer;

import java.util.Date;


public class RoleUpgradeData
        extends AnsycPublisher {
    protected String channel() {
        return "data.RoleUpgrade";
    }

    public RoleUpgradeData(WNPlayer player) {
        this.data.put("os", (player.getPlayer()).os);
        this.data.put("channel", (player.getPlayer()).channel);
        this.data.put("subchannel", (player.getPlayer()).subchannel);
        this.data.put("id", player.getId());

        this.data.put("name", player.getName());
        this.data.put("level", Integer.valueOf(player.getLevel()));
        this.data.put("exp", Long.valueOf(player.getExp()));


        Date lastUpDate = player.baseDataManager.getLvChangeTime();
        if (lastUpDate == null) {
            lastUpDate = (player.getPlayer()).createTime;
        }
        this.data.put("time", Long.valueOf((System.currentTimeMillis() - lastUpDate.getTime()) / 1000L));


        this.data.put("sid", Integer.valueOf((player.getPlayer()).logicServerId));
    }
}


