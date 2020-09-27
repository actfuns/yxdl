package com.wanniu.game.request.map;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.Area;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MapHandler;


@GClientEvent("area.mapHandler.getAliveMonsterLineInfoRequest")
public class GetAliveMonsterLineInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        final Area area = player.getArea();

        return new PomeloResponse() {
            protected void write() throws IOException {
                MapHandler.GetAliveMonsterLineInfoResponse.Builder res = MapHandler.GetAliveMonsterLineInfoResponse.newBuilder();
                res.setS2CCode(200);
                res.addAllS2CMonsterInfos(area.aliveBoss);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


