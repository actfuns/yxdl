package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.fightLevel.FightLevelManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.getBossDamageRankRequest")
public class GetBossDamageRankHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.GetBossDamageRankResponse.Builder res = FightLevelHandler.GetBossDamageRankResponse.newBuilder();

                Area area = player.getArea();

                FightLevelManager fightLevelManager = player.fightLevelManager;

                GetBossDamageRankHandler.GetBossDamageRankResult data = fightLevelManager.getBossDamageRank(player, area);


                res.setS2CCode(200);
                res.addAllS2CRankInfos(data.rankInfos);
                res.setS2COwnDamage(data.ownDamage);
                res.setS2COwnRank(data.ownRank);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public static class GetBossDamageRankResult {
        public List<FightLevelHandler.RankInfo> rankInfos;
        public int ownDamage;
        public int ownRank;

        public GetBossDamageRankResult(List<FightLevelHandler.RankInfo> rankInfos, int ownDamage, int ownRank) {
            this.rankInfos = rankInfos;
            this.ownDamage = ownDamage;
            this.ownRank = ownRank;
        }
    }
}


