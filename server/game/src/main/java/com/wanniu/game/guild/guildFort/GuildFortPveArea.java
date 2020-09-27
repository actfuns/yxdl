package com.wanniu.game.guild.guildFort;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.area.Area;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

public class GuildFortPveArea extends Area {
    private GuildFort fort;

    public GuildFortPveArea(JSONObject opts) {
        super(opts);
        int fortId = opts.getIntValue("fortId");
        this.fort = GuildFortCenter.getInstance().getFort(fortId);
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        this.fort.onPlayerEntered(player);
    }


    protected boolean noCloseIfNoPlayer() {
        return true;
    }


    public void onInterActiveItem(WNPlayer player, int objId, int itemId) {
        super.onInterActiveItem(player, objId, itemId);
        if (this.fort != null) {
            this.fort.onPickedItem(player, itemId);
        } else {
            Out.warn(new Object[]{"contender null onInterActiveItem: " + player.getId() + " " + itemId});
        }
    }


    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);
        if (this.fort != null) {
            this.fort.onKilledMonster(player, monsterId);
        } else {
            Out.warn(new Object[]{"contender null onMonsterDead: " + player.getId() + " " + monsterId});
        }
    }


    public void pushReport(MessagePush defenserMessage, MessagePush attackerMessage) {
        for (String pid : this.actors.keySet()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(pid);
            if (player != null) {
                if (this.fort.isDefenserMember(player.guildManager.getGuildId())) {
                    player.receive((Message) defenserMessage);
                    continue;
                }
                player.receive((Message) attackerMessage);
            }
        }
    }
}


