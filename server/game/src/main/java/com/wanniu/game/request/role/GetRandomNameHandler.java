package com.wanniu.game.request.role;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.area.PlayerRemote;

import java.io.IOException;

import pomelo.connector.RoleHandler;


@GClientEvent("connector.roleHandler.getRandomNameRequest")
public class GetRandomNameHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        RoleHandler.GetRandomNameRequest req = RoleHandler.GetRandomNameRequest.parseFrom(this.pak.getRemaingBytes());
        final int pro = req.getC2SPro();

        return new PomeloResponse() {
            protected void write() throws IOException {
                RoleHandler.GetRandomNameResponse.Builder res = RoleHandler.GetRandomNameResponse.newBuilder();

                if (pro == 0) {
                    Out.warn(new Object[]{"getRandomNameRequest pro is null!"});
                    res.setS2CCode(400);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));

                    return;
                }
                String lastName = PlayerRemote.getRandomName(pro, 0);

                res.setS2CCode(200);
                res.setS2CName(lastName);

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


