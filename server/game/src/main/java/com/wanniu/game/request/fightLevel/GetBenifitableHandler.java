package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.getBenifitableRequest")
public class GetBenifitableHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        FightLevelHandler.GetBenifitableRequest req = FightLevelHandler.GetBenifitableRequest.parseFrom(this.pak.getRemaingBytes());

        final Area area = player.getArea();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.GetBenifitableResponse.Builder res = FightLevelHandler.GetBenifitableResponse.newBuilder();


                res.setS2CCode(200);
                res.setBenifitable((area.getActor(player.getId())).profitable);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


