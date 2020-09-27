package com.wanniu.game.request.prepaid;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;


@GClientEvent("area.prepaidHandler.prepaidAwardRequest")
public class PrepaidAwardHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return null;
    }
}


