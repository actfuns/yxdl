package com.wanniu.game.request.map;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.WorldZoneCO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.MapHandler;


@GClientEvent("area.mapHandler.getMapListRequest")
public class GetMapListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MapHandler.GetMapListRequest req = MapHandler.GetMapListRequest.parseFrom(this.pak.getRemaingBytes());
        final int mapId = req.getC2SMapId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                MapHandler.GetMapListResponse.Builder res = MapHandler.GetMapListResponse.newBuilder();

                List<Integer> result = new ArrayList<>();
                List<WorldZoneCO> maps = GameData.findWorldZones(t -> (t.followMapID == mapId));
                maps.forEach(map -> {

                });


                res.setS2CCode(200);
                res.addAllS2CMapIds(result);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


