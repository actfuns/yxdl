package com.wanniu.game.request.five2five;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.request.solo.SoloRequestFilter;

import java.io.IOException;

import pomelo.five2five.Five2FiveHandler;


@GClientEvent("five2five.five2FiveHandler.five2FiveAgreeMatchRequest")
public class AgreeMatchHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                Five2FiveHandler.Five2FiveAgreeMatchResponse.Builder res = Five2FiveHandler.Five2FiveAgreeMatchResponse.newBuilder();
                String msg = player.five2FiveManager.agreeMatch(player);
                if (!StringUtil.isEmpty(msg)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


