package com.wanniu.game.rank.handler;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.List;


public class PlayerFightPowerRankHandler
        extends AbstractPlayerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.FIGHTPOWER.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        PlayerRankInfoPO info = player.rankManager.getRankPO();
        info.setFightPower(((Integer) value[0]).intValue());


        String key = getRedisKey(GWorld.__SERVER_ID);
        updateRank(key, info.getFightPower(), player.getId());


        switch (player.getPro()) {
            case 1:
                updateRank(RankType.FIGHTPOWER_1.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
                return;
            case 3:
                updateRank(RankType.FIGHTPOWER_3.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
                return;
            case 5:
                updateRank(RankType.FIGHTPOWER_5.getRedisKey(GWorld.__SERVER_ID, 0), info.getFightPower(), player.getId());
                return;
        }
        Out.warn(new Object[]{"未实现的职业排行榜. pro=", Integer.valueOf(player.getPro())});
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(score));
        contents.add(player.getGuildName());
    }
}


