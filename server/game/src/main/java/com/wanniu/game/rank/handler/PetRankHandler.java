package com.wanniu.game.rank.handler;

import com.wanniu.game.GWorld;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.BaseDataExt;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.game.rank.AbstractPlayerRankHandler;
import com.wanniu.game.rank.RankType;

import java.util.Collections;
import java.util.List;

import pomelo.Common;


public class PetRankHandler
        extends AbstractPlayerRankHandler {
    protected String getRedisKey(int logicServerId, int season) {
        return RankType.PET.getRedisKey(logicServerId, season);
    }


    public void handle(WNPlayer player, Object... value) {
        PlayerRankInfoPO info = player.rankManager.getRankPO();
        int oldFightPower = info.getPetFightPower();
        info.setPetId(((Integer) value[0]).intValue());
        info.setPetName((String) value[1]);
        info.setPetFightPower(((Integer) value[2]).intValue());


        if (oldFightPower != info.getPetFightPower()) {
            String key = getRedisKey(GWorld.__SERVER_ID);
            updateRank(key, info.getPetFightPower(), player.getId());
        }
    }


    protected void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
        contents.add(player.getPetName());
        contents.add(String.valueOf(score));
        BaseDataExt prop = (BaseDataExt) GameData.BaseDatas.get(Integer.valueOf(player.getPetId()));
        if (null == prop) {
            return;
        }

        contents.add(prop.model);

        contents.add(String.valueOf(prop.modelPercent));

        contents.add(prop.icon);

        contents.add(String.valueOf(prop.qcolor));

        contents.add(String.valueOf(player.getLevel()));

        contents.add(String.valueOf(prop.modelY));

        contents.add(player.getGuildName());
    }


    protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
        return Collections.emptyList();
    }
}


