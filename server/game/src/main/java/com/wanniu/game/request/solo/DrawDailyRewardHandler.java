package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.drawDailyRewardRequest")
public class DrawDailyRewardHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                SoloHandler.DrawDailyRewardResponse.Builder res = SoloHandler.DrawDailyRewardResponse.newBuilder();
                SoloHandler.DrawDailyRewardRequest req = SoloHandler.DrawDailyRewardRequest.parseFrom(DrawDailyRewardHandler.this.pak.getRemaingBytes());
                int index = req.getC2SIndex();
                player.soloManager.handleDrawDailyReward(index, res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


