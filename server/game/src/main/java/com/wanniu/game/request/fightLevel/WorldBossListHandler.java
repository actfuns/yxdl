package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FightLevelHandler;


@GClientEvent("area.fightLevelHandler.worldBossListRequest")
public class WorldBossListHandler
        extends FightLevelLine {
    public PomeloResponse request(WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                FightLevelHandler.WorldBossListResponse.Builder res = FightLevelHandler.WorldBossListResponse.newBuilder();


                res.setS2CCode(200);


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


