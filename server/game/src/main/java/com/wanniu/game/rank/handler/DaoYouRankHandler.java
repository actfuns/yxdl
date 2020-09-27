package com.wanniu.game.rank.handler;

import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;


public class DaoYouRankHandler
        extends AbstractPlayerRankHandler {
    private static final DaoYouRankHandler instance = new DaoYouRankHandler();

    public static DaoYouRankHandler getInstance() {
        return instance;
    }


    protected String getRedisKey(int logicServerId, int season) {
        return RankType.DAOYOU.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(String.valueOf(score));
    }

    public void asyncUpdateRank(int serverId, String memberId, int score) {
        updateRank(getRedisKey(serverId), score, memberId);
    }
}


