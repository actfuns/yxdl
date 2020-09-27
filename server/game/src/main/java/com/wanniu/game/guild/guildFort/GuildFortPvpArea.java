package com.wanniu.game.guild.guildFort;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.DamageHealVO;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessagePush;
import com.wanniu.game.guild.guildFort.dao.GuildFortContenderPO;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuildFortPvpArea
        extends Area {
    private GuildFort fort;
    private Map<String, Integer> playerEnterCount = new ConcurrentHashMap<>();


    public GuildFortPvpArea(JSONObject opts) {
        super(opts);
        int fortId = opts.getIntValue("fortId");
        this.fort = GuildFortCenter.getInstance().getFort(fortId);
    }


    public void onBattleReport(List<DamageHealVO> datas) {
        if (this.fort.isBattleOver()) {
            return;
        }
        if (datas != null && !datas.isEmpty()) {
            for (DamageHealVO heal : datas) {
                if (heal.TotalDamage <= 0) {
                    Out.error(new Object[]{"Damage onBattleReport value exception, val=", Integer.valueOf(heal.TotalDamage)});
                }

                if (heal.TotalHealing <= 0) {
                    Out.error(new Object[]{"Healing onBattleReport value exception, val=", Integer.valueOf(heal.TotalHealing)});
                }

                WNPlayer player = getPlayer(heal.PlayerUUID);
                if (player == null) {
                    Out.warn(new Object[]{"player null onBattleReport"});
                    continue;
                }
                int count = getEnterCount(player.getId());
                this.fort.onBattleReport(player, heal, count);
            }
        }
    }


    public void onPlayerEntered(WNPlayer player) {
        super.onPlayerEntered(player);
        this.fort.onPlayerEntered(player);
        addEnterCount(player);
    }

    private void addEnterCount(WNPlayer player) {
        Integer count = this.playerEnterCount.get(player.player.id);
        if (count == null) {
            this.playerEnterCount.put(player.player.id, Integer.valueOf(1));
        } else {
            this.playerEnterCount.put(player.player.id, Integer.valueOf(count.intValue() + 1));
        }
    }

    private int getEnterCount(String playerId) {
        Integer count = this.playerEnterCount.get(playerId);
        if (count == null) {
            return 0;
        }
        return count.intValue();
    }


    public void setForce(WNPlayer player) {
        if (this.fort.isDefenserMember(player.guildManager.getGuildId())) {
            player.setForce(Const.AreaForce.FORCEA.value);
        } else {
            player.setForce(Const.AreaForce.FORCEB.value);
        }
    }


    protected boolean noCloseIfNoPlayer() {
        return true;
    }


    public void onPlayerDeadByPlayer(WNPlayer deadPlayer, WNPlayer hitPlayer, float x, float y) {
        super.onPlayerDeadByPlayer(deadPlayer, hitPlayer, x, y);
        this.fort.onKilledPlayer(hitPlayer);
    }


    public void onMonsterDead(int monsterId, int level, float x, float y, int attackType, String refreshPoint, WNPlayer player, JSONArray teamSharedIdList, JSONArray atkAssistantList) {
        super.onMonsterDead(monsterId, level, x, y, attackType, refreshPoint, player, teamSharedIdList, atkAssistantList);

        this.fort.onKilledFlag(player, monsterId);
    }


    public void onAddBuff(GuildFortContenderPO contender) {
        for (String pid : this.actors.keySet()) {
            WNPlayer player = PlayerUtil.getOnlinePlayer(pid);
            if (player != null && player.guildManager.guild != null &&
                    player.guildManager.getGuildId().equals(contender.guildId)) {
                Map<String, Integer> map = new HashMap<>();
                map.put(Const.PlayerBtlData.Attack.toString(), Integer.valueOf(contender.attBuff));
                map.put(Const.PlayerBtlData.Def.toString(), Integer.valueOf(contender.defBuff));
                player.btlDataManager.calFinalData(map, true);
                player.refreshBattlerServerEffect(false);
            }
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


