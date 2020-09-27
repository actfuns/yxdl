package com.wanniu.game.request.vip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;

import java.io.IOException;

import pomelo.area.VipHandler;


@GClientEvent("area.vipHandler.buyVipCardRequest")
public class BuyVipCardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final VipHandler.BuyVipCardResponse.Builder res = VipHandler.BuyVipCardResponse.newBuilder();


        res.setS2CCode(500);
        res.setS2CMsg(LangService.getValue("CONFIG_ERR"));

        return new PomeloResponse() {
            protected void write() throws IOException {
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


