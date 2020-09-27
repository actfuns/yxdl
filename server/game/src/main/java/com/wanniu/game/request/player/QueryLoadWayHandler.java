package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.player.PathService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.queryLoadWayRequest")
public class QueryLoadWayHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.QueryLoadWayRequest req = PlayerHandler.QueryLoadWayRequest.parseFrom(this.pak.getRemaingBytes());
        final int toAreaId = req.getC2SAreaId();
        final String pointId = req.getC2SPointId();
        final int areaId = player.getAreaId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.QueryLoadWayResponse.Builder res = PlayerHandler.QueryLoadWayResponse.newBuilder();


                if (toAreaId == 0 || StringUtil.isEmpty(pointId) || areaId == toAreaId) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                int pointId = PathService.getInstance().findPath(areaId, toAreaId);
                if (pointId != 0) {
                    res.setS2CPointId(String.valueOf(pointId));
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("TARGET_PATH_NOT_AVAILABLE"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
            }
        };
    }
}


