package com.wanniu.game.request.map;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.data.base.MapBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pomelo.area.MapHandler;


@GClientEvent("area.mapHandler.getWorldMapListRequest")
public class GetWorldMapListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                MapHandler.GetWorldMapListResponse.Builder res = MapHandler.GetWorldMapListResponse.newBuilder();
                List<MapHandler.WorldMap> data = new ArrayList<>();
                List<MapBase> props = AreaDataConfig.getInstance().find(t ->
                        (t.type >= 1 && t.type <= 2));

                props.forEach(prop -> {
                    MapHandler.WorldMap.Builder map = MapHandler.WorldMap.newBuilder();
                    map.setId(prop.mapID);
                    map.setIsOpen(1);
                    data.add(map.build());
                });
                res.addAllData(data);
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


