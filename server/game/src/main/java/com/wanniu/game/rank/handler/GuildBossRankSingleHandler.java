package com.wanniu.game.rank.handler;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.GCache;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.guild.guildBoss.GuildBossCenter;
import com.wanniu.game.guild.guildBoss.GuildBossService;
import com.wanniu.game.guild.guildBoss.RankBean;
import com.wanniu.game.leaderBoard.LeaderBoardProto;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;

import pomelo.area.LeaderBoardHandler;


public class GuildBossRankSingleHandler
        extends AbstractPlayerRankHandler {
    public static GuildBossRankSingleHandler instance = new GuildBossRankSingleHandler();


    public String getRedisKey(int logicServerId, int season) {
        return RankType.GUILD_BOSS_SINGLE.getRedisKey(logicServerId, season) + "/today";
    }


    public void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(player.getGuildName());
        contents.add(String.valueOf(score));
    }


    public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
        LeaderBoardProto result = new LeaderBoardProto();
        List<RankBean> worldRanks = null;
        if (GuildBossCenter.getInstance().isOpen()) {
            worldRanks = GuildBossService.getInstance().getWorldSingleRank();
        } else {
            String key = getRedisKey(GWorld.__SERVER_ID);
            String vl = GCache.get(key);
            if (vl != null) {
                worldRanks = JSONObject.parseArray(vl, RankBean.class);
            }
        }
        if (worldRanks != null && !worldRanks.isEmpty()) {
            int rank = 1;
            for (RankBean bean : worldRanks) {
                LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getId(), bean.getHurt(), rank);
                if (build == null) {
                    continue;
                }
                rank++;
                result.s2c_lists.add(build);

                if (selfId.equals(bean.getId())) {
                    result.s2c_myData = build;
                }
            }
        }
        return result;
    }

    public void delRankMember(int serverId, String memberId) {
        boolean hasChanged = false;
        List<RankBean> worldRanks = getDataList();
        if (worldRanks != null) {
            for (RankBean bean : worldRanks) {
                if (bean.getId().equals(memberId)) {
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

    public List<RankBean> getDataList() {
        String key = getRedisKey(GWorld.__SERVER_ID);
        String vl = GCache.get(key);
        if (!StringUtil.isEmpty(vl)) {
            return JSONObject.parseArray(vl, RankBean.class);
        }
        return null;
    }


    public void putStaticData(List<RankBean> worldRanks) {
        String key = getRedisKey(GWorld.__SERVER_ID);
        String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
        GCache.put(key, strVL);
    }


    public void handle(WNPlayer player, Object... value) {
    }


    public static GuildBossRankSingleHandler getInstance() {
        return instance;
    }
}


