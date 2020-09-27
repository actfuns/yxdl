package com.wanniu.game.guild.dao;

import com.wanniu.core.db.GCache;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.Utils;
import com.wanniu.game.guild.GuildCommonUtil;
import com.wanniu.game.poes.GuildDepotPO;

import java.util.ArrayList;


public class GuildDepotDao {
    public static GuildDepotPO getDepot(String id) {
        return (GuildDepotPO) GuildCommonUtil.hget(ConstsTR.guildDepotTR, id, GuildDepotPO.class);
    }


    public static ArrayList<GuildDepotPO> getDepotList() {
        return GuildCommonUtil.hgetAll(ConstsTR.guildDepotTR, GuildDepotPO.class);
    }

    public static void updateDepot(GuildDepotPO data) {
        GCache.hset(ConstsTR.guildDepotTR.value, data.id, Utils.serialize(data));
    }

    public static void removeDepotToRedis(GuildDepotPO data) {
        GCache.hremove(ConstsTR.guildDepotTR.value, data.id);
    }
}


