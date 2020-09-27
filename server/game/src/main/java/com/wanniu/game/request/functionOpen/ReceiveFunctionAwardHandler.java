package com.wanniu.game.request.functionOpen;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FunctionOpenHandler;


@GClientEvent("area.functionOpenHandler.receiveFunctionAwardRequest")
public class ReceiveFunctionAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        FunctionOpenHandler.ReceiveFunctionAwardRequest req = FunctionOpenHandler.ReceiveFunctionAwardRequest.parseFrom(this.pak.getRemaingBytes());
        final int guideId = req.getGuideId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FunctionOpenHandler.ReceiveFunctionAwardResponse.Builder res = FunctionOpenHandler.ReceiveFunctionAwardResponse.newBuilder();

                String msg = player.functionOpenManager.receiveFunctionAward(guideId);

                if (msg != null) {
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


