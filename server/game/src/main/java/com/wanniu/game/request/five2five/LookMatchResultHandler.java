package com.wanniu.game.request.five2five;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.five2five.Five2FiveHandler;


@GClientEvent("five2five.five2FiveHandler.five2FiveLookMatchResultRequest")
public class LookMatchResultHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                Five2FiveHandler.Five2FiveShardMatchResultRequest req = Five2FiveHandler.Five2FiveShardMatchResultRequest.parseFrom(LookMatchResultHandler.this.pak.getRemaingBytes());
                String instanceId = req.getInstanceId();
                Five2FiveHandler.Five2FiveLookMatchResultResponse.Builder res = Five2FiveHandler.Five2FiveLookMatchResultResponse.newBuilder();
                player.five2FiveManager.lookMatchResult(instanceId, res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


