package com.wanniu.game.rank;

import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerRankInfoPO;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.List;

import pomelo.Common;
import pomelo.area.LeaderBoardHandler;
import pomelo.revelry.ActivityRevelryHandler;


public abstract class AbstractPlayerRankHandler
        extends AbstractRankHandler {
    public String getSelfId(WNPlayer player) {
        return player.getId();
    }


    public String getSelfName(WNPlayer player) {
        return player.getName();
    }


    public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank) {
        LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();

        PlayerRankInfoPO player = RankCenter.getInstance().findRankPO(memberId);
        if (player == null) {
            return null;
        }

        List<String> contents = new ArrayList<>();

        contents.add(String.valueOf(rank));
        contents.add(player.getId());
        contents.add(String.valueOf(player.getPro()));
        contents.add(player.getName());


        buildRankInfo(contents, player, score);

        builder.addAllContents(contents);


        List<Common.Avatar> avatars = buildAvatarsInfo(player);
        if (!avatars.isEmpty()) {
            builder.addAllAvatars(avatars);
        }
        return builder.build();
    }


    protected abstract void buildRankInfo(List<String> paramList, PlayerRankInfoPO paramPlayerRankInfoPO, long paramLong);


    protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
        return PlayerUtil.getBattlerServerAvatar(player.getId());
    }


    public void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder info, SimpleRankData rankData) {
        info.addContents(String.valueOf(rankData.getRank()));

        info.addContents(String.valueOf(rankData.getScore()));

        String playerId = rankData.getId();
        PlayerRankInfoPO rankinfo = (PlayerRankInfoPO) PlayerPOManager.findPO(ConstsTR.playerRankTR, playerId, PlayerRankInfoPO.class);
        if (rankinfo == null) {

            info.addContents("-");

            info.addContents("1");
        } else {

            info.addContents(rankinfo.getName());

            info.addContents(String.valueOf(rankinfo.getPro()));

            info.addContents(String.valueOf(rankinfo.getLevel()));
        }


        if (rankData.getRank() == 1) {
            List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(playerId);
            if (!avatars.isEmpty())
                info.addAllAvatars(avatars);
        }
    }
}


