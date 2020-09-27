package com.wanniu.game.guild.dao;

import com.wanniu.core.db.GCache;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.guild.po.GuildBlessPO;

import java.util.ArrayList;


public class GuildBlessDao {
    public static ArrayList<GuildBlessPO> getGuildBlessList() {
        return GuildCommonUtil.hgetAll(ConstsTR.guildBlessTR, GuildBlessPO.class);
    }

    public static void updateGuildBless(GuildBlessPO data) {
        updateBlessToRedis(data);
    }

    public static void updateBlessToRedis(GuildBlessPO data) {
        GCache.hset(ConstsTR.guildBlessTR.value, data.id, Utils.serialize(data));
    }

    public static void removeBlessToRedis(GuildBlessPO data) {
        GCache.hremove(ConstsTR.guildBlessTR.value, data.id);
    }
}


