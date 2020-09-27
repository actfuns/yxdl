package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.TransportCO;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.transportRequest")
public class TransportHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        PlayerHandler.TransportRequest req = PlayerHandler.TransportRequest.parseFrom(this.pak.getRemaingBytes());
        final int transportId = req.getC2STransportId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.TransportResponse.Builder res = PlayerHandler.TransportResponse.newBuilder();

                boolean result = PlayerUtil.transPortById(player, transportId);
                if (result) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } else {
                    TransportCO transportProp = (TransportCO) GameData.Transports.get(Integer.valueOf(transportId));
                    if (transportProp != null) {
                        res.setS2CCode(500);
                        res.setS2CMsg(transportProp.failTips);
                        this.body.writeBytes(res.build().toByteArray());
                    } else {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                        this.body.writeBytes(res.build().toByteArray());
                    }
                }
            }
        };
    }
}


