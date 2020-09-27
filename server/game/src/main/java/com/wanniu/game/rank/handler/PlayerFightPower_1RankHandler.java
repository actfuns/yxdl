package com.wanniu.game.rank.handler;

import com.wanniu.game.rank.RankType;


public class PlayerFightPower_1RankHandler
        extends PlayerFightPowerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.FIGHTPOWER_1.getRedisKey(logicServerId, season);
    }
}


