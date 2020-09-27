package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.palaceListRequest")
public class PalaceListHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.PalaceListResponse.Builder res = FightLevelHandler.PalaceListResponse.newBuilder();


                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


