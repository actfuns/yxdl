package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;


public class PlayerPhyRankHandler
        extends AbstractPlayerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.PHY.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        PlayerRankInfoPO info = player.rankManager.getRankPO();
        info.setPhy(((Integer) value[0]).intValue());


        String key = getRedisKey(GWorld.__SERVER_ID);
        updateRank(key, info.getPhy(), player.getId());
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(String.valueOf(score));
        contents.add(player.getGuildName());
    }
}


