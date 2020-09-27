package com.wanniu.game.rank.handler;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
import com.wanniu.game.leaderBoard.LeaderBoardProto;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.rank.AbstractGuildRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.LeaderBoardHandler;


public class GuildBossPreRankGuildHandler
        extends AbstractGuildRankHandler {
    public static GuildBossPreRankGuildHandler instance = new GuildBossPreRankGuildHandler();


    public void putStaticData(List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks) {
        String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
        String key = getRedisKey(GWorld.__SERVER_ID);
        GCache.put(key, strVL);
    }


    public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank, GuildBossAreaHurtRankCenter.GuildStaticRankBean bean) {
        LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();

        GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
        if (null == guild) {
            return null;
        }

        List<String> contents = new ArrayList<>(7);
        contents.add(String.valueOf(rank));
        contents.add(memberId);
        contents.add(guild.icon);
        contents.add(guild.name);
        contents.add(String.valueOf(guild.level));
        contents.add(String.valueOf(bean.getTotalHurt()));
        contents.add(String.valueOf(bean.getSeconds()));
        builder.addAllContents(contents);
        return builder.build();
    }


    public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
        String key = getRedisKey(GWorld.__SERVER_ID);
        String vl = GCache.get(key);
        int rank = 1;
        LeaderBoardProto result = new LeaderBoardProto();
        if (vl != null) {
            List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
            for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
                LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, bean);
                if (build == null) {
                    continue;
                }
                rank++;
                result.s2c_lists.add(build);

                if (selfId.equals(bean.getGuildId())) {
                    result.s2c_myData = build;
                }
            }
        }
        return result;
    }


    public void delRankMember(int serverId, String memberId) {
        String key = getRedisKey(serverId);
        String vl = GCache.get(key);
        boolean hasChanged = false;
        if (!StringUtil.isEmpty(vl)) {
            List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
            for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
                if (bean.getGuildId().equals(memberId)) {
                    worldRanks.remove(bean);
                    hasChanged = true;
                    break;
                }
            }
            if (hasChanged) {
                putStaticData(worldRanks);
            }
        }
    }


    public void handle(WNPlayer player, Object... value) {
    }


    protected String getRedisKey(int logicServerId, int season) {
        return RankType.GUILD_BOSS_GUILD.getRedisKey(logicServerId, season) + "/preday";
    }


    public static GuildBossPreRankGuildHandler getInstance() {
        return instance;
    }
}


