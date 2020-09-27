package com.wanniu.game.request.rank;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.rank.TitleManager;

import java.io.IOException;
import java.util.ArrayList;

import pomelo.area.RankHandler;


@GClientEvent("area.rankHandler.getRankInfoRequest")
public class GetRankInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;
        return new PomeloResponse() {
            protected void write() throws IOException {
                RankHandler.GetRankInfoResponse.Builder res = RankHandler.GetRankInfoResponse.newBuilder();
                TitleManager titleManager = wPlayer.titleManager;
                int id = titleManager.getSelectedRankId();

                res.setS2CCode(200);
                res.setS2CSelectedRankId(id);

                ArrayList<RankHandler.AwardRank.Builder> list = titleManager.getRankInfo();
                for (RankHandler.AwardRank.Builder builder : list) {
                    res.addS2CAwardRanks(builder.build());
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


