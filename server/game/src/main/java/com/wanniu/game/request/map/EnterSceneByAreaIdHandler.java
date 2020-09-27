package com.wanniu.game.request.map;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.area.AreaDataConfig;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.player.ChangeAreaFilter;

import java.io.IOException;

import pomelo.area.MapHandler;


@GClientEvent("area.mapHandler.enterSceneByAreaIdRequest")
public class EnterSceneByAreaIdHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        MapHandler.GnterSceneByAreaIdRequest req = MapHandler.GnterSceneByAreaIdRequest.parseFrom(this.pak.getRemaingBytes());
        int areaId = req.getC2SAreaId();
        if (areaId == 0) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
        }
        MapBase prop = AreaDataConfig.getInstance().get(areaId);
        if (prop == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
        }

        AreaUtil.enterArea(player, areaId);

        return new PomeloResponse() {
            protected void write() throws IOException {
                MapHandler.GnterSceneByAreaIdResponse.Builder res = MapHandler.GnterSceneByAreaIdResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


