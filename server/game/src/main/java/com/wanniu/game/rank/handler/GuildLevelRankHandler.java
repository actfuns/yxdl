package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.rank.AbstractGuildRankHandler;
import com.wanniu.game.rank.RankType;


public class GuildLevelRankHandler
        extends AbstractGuildRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.GUILD_LEVEL.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
    }


    public void handle(GuildPO guild) {
        String key = getRedisKey(GWorld.__SERVER_ID);

        long sumFund = (guild.sumFund > 100000000L) ? 99999999L : guild.sumFund;
        updateRank(key, guild.level * 100000000L + sumFund, guild.id);
    }
}


