package com.wanniu.game.request.five2five;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.five2five.Five2FiveHandler;


@GClientEvent("five2five.five2FiveHandler.five2FiveReadyRequest")
public class MatchReadyHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                Five2FiveHandler.Five2FiveReadyRequest req = Five2FiveHandler.Five2FiveReadyRequest.parseFrom(MatchReadyHandler.this.pak.getRemaingBytes());

                String teamId = req.getTempTeamId();
                Five2FiveHandler.Five2FiveReadyResponse.Builder res = Five2FiveHandler.Five2FiveReadyResponse.newBuilder();
                String msg = player.five2FiveManager.matchReady(teamId);
                if (!StringUtil.isEmpty(msg)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


