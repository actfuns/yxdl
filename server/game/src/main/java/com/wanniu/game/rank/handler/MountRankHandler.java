package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.Collections;
import java.util.List;

import pomelo.Common;


public class MountRankHandler
        extends AbstractPlayerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.Mount.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        PlayerRankInfoPO info = player.rankManager.getRankPO();
        int oldFightPower = info.getMountFightPower();
        info.setMountFightPower(((Integer) value[0]).intValue());
        info.setMountSkinId(((Integer) value[1]).intValue());


        if (oldFightPower != info.getMountFightPower()) {
            String key = getRedisKey(GWorld.__SERVER_ID);
            updateRank(key, info.getMountFightPower(), player.getId());
        }
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(score));
        contents.add(String.valueOf(player.getMountSkinId()));
        contents.add(player.getGuildName());
    }


    protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
        return Collections.emptyList();
    }
}


