package com.wanniu.game.request.functionOpen;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FunctionOpenHandler;


@GClientEvent("area.functionOpenHandler.setFunctionPlayedRequest")
public class SetFunctionPlayedHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final FunctionOpenHandler.SetFunctionPlayedRequest req = FunctionOpenHandler.SetFunctionPlayedRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FunctionOpenHandler.SetFunctionPlayedResponse.Builder res = FunctionOpenHandler.SetFunctionPlayedResponse.newBuilder();


                int result = player.functionOpenManager.setFunctionPlayed(req.getFunctionName());
                if (result == 0) {
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("FUNC_SET_PLAYED_NOT_OPEN"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                res.setS2CCode(500);
                res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


