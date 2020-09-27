package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.battleRecordRequest")
public class BattleRecordHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                SoloHandler.BattleRecordResponse.Builder res = SoloHandler.BattleRecordResponse.newBuilder();
                player.soloManager.handleBattleRecord(res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


