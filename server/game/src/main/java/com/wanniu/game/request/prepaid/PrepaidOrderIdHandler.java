package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.prepaid.PrepaidService;
import pomelo.area.PrepaidHandler;


@GClientEvent("area.prepaidHandler.prepaidOrderIdRequest")
public class PrepaidOrderIdHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        PrepaidHandler.PrepaidOrderIdRequest req = PrepaidHandler.PrepaidOrderIdRequest.parseFrom(this.pak.getRemaingBytes());
        int productId = req.getC2SProductId();
        int channelId = req.getC2SChannelId();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        int isCard = req.getC2SType();

        String imei = req.getC2SImei();
        int os = req.getC2SOs();

        return PrepaidService.getInstance().createOrderId(productId, channelId, player, (isCard == 1), imei, os);
    }
}


