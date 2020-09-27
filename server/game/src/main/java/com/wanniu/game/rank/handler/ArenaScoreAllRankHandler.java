package com.wanniu.game.rank.handler;

import com.wanniu.game.arena.ArenaService;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;


public class ArenaScoreAllRankHandler
        extends AbstractPlayerRankHandler {
    private static final ArenaScoreAllRankHandler instance = new ArenaScoreAllRankHandler();

    public static ArenaScoreAllRankHandler getInstance() {
        return instance;
    }


    protected String getRedisKey(int logicServerId, int season) {
        return RankType.ARENA_SCOREALL.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(String.valueOf(score));
    }

    public void asyncUpdateRank(int serverId, String playerId, int score) {
        String key = getRedisKey(serverId, getCurrentSeason());
        updateRank(key, score, playerId);
    }


    public int getCurrentSeason() {
        return ArenaService.getInstance().getTerm();
    }


    public int getLastSeason() {
        int term = getCurrentSeason() - 1;
        return (term < 0) ? 0 : term;
    }
}


