package com.wanniu.game.rank.handler;

import com.wanniu.core.db.GCache;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;


public class ArenaScoreRankHandler
        extends AbstractPlayerRankHandler {
    private static final ArenaScoreRankHandler instance = new ArenaScoreRankHandler();

    public static ArenaScoreRankHandler getInstance() {
        return instance;
    }


    protected String getRedisKey(int logicServerId, int season) {
        return RankType.ARENA_SCORE.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(String.valueOf(score));
    }


    public void asyncUpdateRank(int serverId, String playerId, int score) {
        String key = getRedisKey(serverId);
        Double oldScore = GCache.zscore(key, playerId);
        if (oldScore != null && oldScore.doubleValue() > score) {
            return;
        }
        updateRank(key, score, playerId);
    }
}


