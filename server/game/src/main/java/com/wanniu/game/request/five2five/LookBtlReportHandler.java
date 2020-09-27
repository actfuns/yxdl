package com.wanniu.game.request.five2five;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.five2five.Five2FiveHandler;


@GClientEvent("five2five.five2FiveHandler.five2FiveLookBtlReportRequest")
public class LookBtlReportHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                Five2FiveHandler.Five2FiveLookBtlReportResponse.Builder res = Five2FiveHandler.Five2FiveLookBtlReportResponse.newBuilder();
                player.five2FiveManager.lookBtlReport(res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


