package com.wanniu.game.request.fightLevel.illusion;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.IllusionPO;
import com.wanniu.game.request.fightLevel.FightLevelLine;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.getLllsionInfoRequest")
public class GetIllsionInfoHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        IllusionPO illusion = player.illusionManager.illusionPO;

        final FightLevelHandler.GetLllsionInfoResponse.Builder res = FightLevelHandler.GetLllsionInfoResponse.newBuilder();
        res.setS2CCode(200);
        res.setS2CMaxExp(0);
        res.setS2CMaxClassexp(0);
        res.setS2CMaxGold(0);

        res.setS2CTodayExp(illusion.todayExp);
        res.setS2CTodayClassexp(illusion.todayClassExp);
        res.setS2CTodayGold(illusion.todayGold);

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


