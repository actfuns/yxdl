package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.solo.SoloService;

import java.util.List;


public class SoloRankHandler
        extends AbstractPlayerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.SOLO_SCORE.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        int term = ((Integer) value[0]).intValue();
        int source = ((Integer) value[1]).intValue();


        String key = getRedisKey(GWorld.__SERVER_ID, term);
        updateRank(key, source, player.getId());
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(String.valueOf(player.getLevel()));
        contents.add(String.valueOf(player.getFightPower()));
        contents.add(String.valueOf(score));
        contents.add(player.getGuildName());
    }


    public int getCurrentSeason() {
        return SoloService.getInstance().getTerm();
    }


    public int getLastSeason() {
        int term = getCurrentSeason() - 1;
        return (term < 0) ? 0 : term;
    }
}


