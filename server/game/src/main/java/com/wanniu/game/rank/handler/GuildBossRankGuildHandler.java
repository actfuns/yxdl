package com.wanniu.game.rank.handler;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.guild.GuildServiceCenter;
import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
import com.wanniu.game.guild.guildBoss.GuildBossCenter;
import com.wanniu.game.guild.guildBoss.GuildBossService;
import com.wanniu.game.guild.guildBoss.GuildRankBean;
import com.wanniu.game.leaderBoard.LeaderBoardProto;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.GuildPO;
import com.wanniu.game.rank.AbstractGuildRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.LeaderBoardHandler;


public class GuildBossRankGuildHandler
        extends AbstractGuildRankHandler {
    public static GuildBossRankGuildHandler instance = new GuildBossRankGuildHandler();


    public void putStaticData(List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks) {
        String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
        String key = getRedisKey(GWorld.__SERVER_ID);
        GCache.put(key, strVL);
    }


    public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank, int seconds) {
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
        contents.add(String.valueOf(score));
        contents.add(String.valueOf(seconds));
        builder.addAllContents(contents);
        return builder.build();
    }


    public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
        LeaderBoardProto result = new LeaderBoardProto();
        if (GuildBossCenter.getInstance().isOpen()) {
            List<GuildRankBean> worldRanks = GuildBossService.getInstance().getGuildRankSort();
            if (worldRanks != null && !worldRanks.isEmpty()) {
                int rank = 1;
                for (GuildRankBean bean : worldRanks) {
                    int sec = 0;
                    if (bean.hasKilled()) {
                        sec = (int) ((bean.getBossKillTime() - GuildBossCenter.getInstance().getBeginTime()) / 1000L);
                    }
                    LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, sec);
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
        } else {
            String key = getRedisKey(GWorld.__SERVER_ID);
            String vl = GCache.get(key);
            int rank = 1;
            if (vl != null) {
                List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
                for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
                    LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, bean.getSeconds());
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
        }
        return result;
    }


    public void delRankMember(int serverId, String memberId) {
        boolean hasChanged = false;
        List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = getDataList();
        if (worldRanks != null && !worldRanks.isEmpty()) {
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

    public List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> getDataList() {
        String key = getRedisKey(GWorld.__SERVER_ID);
        String vl = GCache.get(key);
        if (!StringUtil.isEmpty(vl)) {
            return JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
        }
        return null;
    }


    public void handle(WNPlayer player, Object... value) {
    }


    protected String getRedisKey(int logicServerId, int season) {
        return RankType.GUILD_BOSS_GUILD.getRedisKey(logicServerId, season) + "/today";
    }


    public static GuildBossRankGuildHandler getInstance() {
        return instance;
    }
}


