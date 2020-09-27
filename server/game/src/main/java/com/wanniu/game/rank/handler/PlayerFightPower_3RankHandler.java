package com.wanniu.game.rank.handler;

import com.wanniu.game.rank.RankType;


public class PlayerFightPower_3RankHandler
        extends PlayerFightPowerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.FIGHTPOWER_3.getRedisKey(logicServerId, season);
    }
}


