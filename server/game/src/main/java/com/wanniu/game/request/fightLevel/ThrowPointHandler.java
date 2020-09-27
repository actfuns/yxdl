package com.wanniu.game.request.fightLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.BattleHandler;


@GClientEvent("area.battleHandler.throwPointRequest")
public class ThrowPointHandler
        extends FightLevelLine {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        BattleHandler.ThrowPointRequest req = BattleHandler.ThrowPointRequest.parseFrom(this.pak.getRemaingBytes());
        final String id = req.getId();
        return new PomeloResponse() {
            protected void write() throws IOException {
                BattleHandler.ThrowPointResponse.Builder res = BattleHandler.ThrowPointResponse.newBuilder();

                Area area = player.getArea();

                res.setS2CCode(200);
                res.setPoint(area.randomPoint(player, id));

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


