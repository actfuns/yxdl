package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.rank.AbstractGuildRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.LeaderBoardHandler;


public class GuildFortRankHandler
        extends AbstractGuildRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.GUILD_FORT.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        String guildId = (String) value[0];
        long winTimes = ((Integer) value[1]).intValue();

        String key = getRedisKey(GWorld.__SERVER_ID);
        updateRank(key, winTimes, guildId);
    }


    public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank) {
        LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();

        GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
        if (null == guild) {
            return null;
        }

        List<String> contents = new ArrayList<>(5);
        contents.add(String.valueOf(rank));
        contents.add(memberId);
        contents.add(guild.icon);
        contents.add(guild.name);
        contents.add(String.valueOf(guild.level));
        contents.add(String.valueOf(score));
        builder.addAllContents(contents);
        return builder.build();
    }


    public void handle(GuildPO guild) {
        String key = getRedisKey(GWorld.__SERVER_ID);
        long winTimes = guild.fortInfo.winTimes;
        updateRank(key, winTimes, guild.id);
    }
}


