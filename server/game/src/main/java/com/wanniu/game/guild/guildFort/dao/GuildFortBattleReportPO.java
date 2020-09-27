package com.wanniu.game.guild.guildFort.dao;

import com.alibaba.fastjson.annotation.JSONField;

public class GuildFortBattleReportPO {
    public int fortId = 0;
    public String fortName = "";
    public GuildFortContenderPO defenser = null;
    public GuildFortContenderPO attacker = null;

    @JSONField(deserialize = false, serialize = false)
    public GuildFortContenderPO getContender(String guildId) {
        if (this.defenser != null && this.defenser.guildId.equals(guildId))
            return this.defenser;
        if (this.attacker != null && this.attacker.guildId.equals(guildId)) {
            return this.attacker;
        }

        return null;
    }
}


