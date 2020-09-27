package com.wanniu.game.rank;

import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.LeaderBoardHandler;
import pomelo.revelry.ActivityRevelryHandler;


public abstract class AbstractGuildRankHandler
        extends AbstractRankHandler {
    public String getSelfId(WNPlayer player) {
        return player.guildManager.getGuildId();
    }


    public String getSelfName(WNPlayer player) {
        return player.guildManager.getGuildName();
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
        builder.addAllContents(contents);
        return builder.build();
    }


    public void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder info, SimpleRankData rankData) {
        GuildPO guild = GuildServiceCenter.getInstance().getGuild(rankData.getId());
        if (guild != null) {

            info.addContents(String.valueOf(rankData.getRank()));

            info.addContents(String.valueOf(guild.level));

            info.addContents(guild.name);

            info.addContents(guild.icon);

            info.addContents(String.valueOf(guild.level));
        }
    }
}


