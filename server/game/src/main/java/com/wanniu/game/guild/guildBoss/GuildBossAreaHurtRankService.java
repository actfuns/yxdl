package com.wanniu.game.guild.guildBoss;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.game.common.ConstsTR;

import java.util.List;


public class GuildBossAreaHurtRankService {
    public void saveAfterOver(String guildId, List<RankBean> list) {
        GCache.hset(ConstsTR.guildBossHurtTR.value, guildId, JSONObject.toJSONString(list));
    }

    private GuildBossAreaHurtRankService() {
    }

    private static class GuildBossAreaHurtRankServiceHolder {
        public static final GuildBossAreaHurtRankService INSTANCE = new GuildBossAreaHurtRankService();
    }

    public static GuildBossAreaHurtRankService getInstance() {
        return GuildBossAreaHurtRankServiceHolder.INSTANCE;
    }
}


