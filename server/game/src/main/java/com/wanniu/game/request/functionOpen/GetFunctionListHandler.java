package com.wanniu.game.request.functionOpen;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.FunctionOpenHandler;


@GClientEvent("area.functionOpenHandler.getFunctionListRequest")
public class GetFunctionListHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        FunctionOpenHandler.GetFunctionListRequest req = FunctionOpenHandler.GetFunctionListRequest.parseFrom(this.pak.getRemaingBytes());
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                FunctionOpenHandler.GetFunctionListResponse.Builder res = FunctionOpenHandler.GetFunctionListResponse.newBuilder();

                res.addAllS2CList(player.functionOpenManager.toJson4PayLoad());

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


