package com.wanniu.game.rank.handler;

import com.wanniu.game.rank.RankType;


public class PlayerFightPower_5RankHandler
        extends PlayerFightPowerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.FIGHTPOWER_5.getRedisKey(logicServerId, season);
    }
}


