package com.wanniu.game.guild.guildFort.dao;

import com.alibaba.fastjson.annotation.JSONField;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.guildFort.GuildFortStatPush;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GuildFortContenderPO {
    public String guildId = "";
    public String guildName = "";
    public String guildIcon = "";
    public int guildLevel = 0;
    public int attendTimes = 0;
    public int winTimes = 0;


    public Map<String, GuildFortMemberPO> members = new HashMap<>();
    public int memberNumber = 0;

    public int pickItemNum = 0;
    public int defBuffScore = 0;
    public int defBuff = 0;

    public int killMonsterNum = 0;
    public int attBuffScore = 0;
    public int attBuff = 0;

    public int killPlayerNum = 0;
    public int killPlayerScore = 0;
    public int killFlagNum = 0;
    public int killFlagScore = 0;
    public int score = 0;

    public boolean isWinner = false;


    public GuildFortContenderPO() {
    }


    public GuildFortContenderPO(String guildId) {
        this.guildId = guildId;
        build();
    }


    @JSONField(deserialize = false, serialize = false)
    public synchronized GuildFortContenderPO getContenderPO() {
        build();
        GuildFortContenderPO po = new GuildFortContenderPO();

        po.guildId = this.guildId;
        po.guildName = this.guildName;
        po.guildIcon = this.guildIcon;
        po.guildLevel = this.guildLevel;
        po.attendTimes = this.attendTimes;
        po.winTimes = this.winTimes;

        po.memberNumber = this.memberNumber;


        po.pickItemNum = this.pickItemNum;
        po.defBuffScore = this.defBuffScore;
        po.defBuff = this.defBuff;

        po.killMonsterNum = this.killMonsterNum;
        po.attBuffScore = this.attBuffScore;
        po.attBuff = this.attBuff;


        po.killPlayerNum = this.killPlayerNum;
        po.killPlayerScore = this.killPlayerScore;
        po.killFlagNum = this.killFlagNum;
        po.killFlagScore = this.killFlagScore;
        po.score = this.score;
        po.isWinner = this.isWinner;
        return po;
    }

    @JSONField(deserialize = false, serialize = false)
    public synchronized GuildFortStatPush getPush() {
        GuildFortStatPush po = new GuildFortStatPush();
        po.memberNumber = this.members.size();
        for (GuildFortMemberPO member : this.members.values()) {
            po.killPlayerNum += member.getKilledPlayerNum();
            po.killFlagNum += member.getKilledFlagNum();
            po.defBuffScore += member.getDefBuffScore();
            po.attBuffScore += member.getAttBuffScore();
            po.score += member.getScore();
        }
        po.defBuff = po.defBuffScore / GlobalConfig.GuildFort_PickAddDefense;
        po.attBuff = po.attBuffScore / GlobalConfig.GuildFort_KillMonAddAttack;

        return po;
    }

    @JSONField(deserialize = false, serialize = false)
    public synchronized GuildFortContenderPO build() {
        if (StringUtil.isNotEmpty(this.guildId)) {
            GuildPO guild = GuildServiceCenter.getInstance().getGuild(this.guildId);
            if (guild != null) {
                this.guildName = guild.name;
                this.guildIcon = guild.icon;
                this.guildLevel = guild.level;
                this.attendTimes = (guild.getFortInfo()).attendTimes;
                this.winTimes = (guild.getFortInfo()).winTimes;

                this.memberNumber = this.members.size();
                this.pickItemNum = 0;
                this.killMonsterNum = 0;
                this.killPlayerNum = 0;
                this.killFlagNum = 0;


                for (GuildFortMemberPO member : this.members.values()) {
                    this.pickItemNum += member.getPickItemNum();
                    this.killMonsterNum += member.getKilledMonsterNum();
                    this.killPlayerNum += member.getKilledPlayerNum();
                    this.killFlagNum += member.getKilledFlagNum();
                }


                this.killPlayerScore = this.killPlayerNum * GlobalConfig.GuildFort_KillPoint;
                this.killFlagScore = this.killFlagNum * GlobalConfig.GuildFort_DestroyPoint;
            }
        }


        return this;
    }


    @JSONField(deserialize = false, serialize = false)
    public synchronized GuildFortMemberPO getMemberAndPut(WNPlayer player) {
        String playerId = player.getId();
        if (this.members.containsKey(playerId)) {
            return this.members.get(playerId);
        }
        GuildFortMemberPO member = new GuildFortMemberPO(playerId, player.getName(), player.getLevel(), player.guildManager.getJob(), player.guildManager.getGuildName());
        this.members.put(playerId, member);
        return member;
    }


    @JSONField(deserialize = false, serialize = false)
    public synchronized Collection<GuildFortMemberPO> getMembers() {
        return this.members.values();
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isMember(WNPlayer player) {
        return isMember(player.guildManager.getGuildId());
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isMember(String guildId) {
        if (guildId == null) {
            return false;
        }
        return guildId.equals(this.guildId);
    }

    @JSONField(deserialize = false, serialize = false)
    public String getGuildId() {
        return this.guildId;
    }


    @JSONField(deserialize = false, serialize = false)
    public boolean isWinner() {
        return this.isWinner;
    }

    @JSONField(deserialize = false, serialize = false)
    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getScore() {
        return this.score;
    }
}


