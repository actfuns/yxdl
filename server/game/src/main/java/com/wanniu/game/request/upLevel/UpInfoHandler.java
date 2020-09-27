package com.wanniu.game.request.upLevel;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;


@GClientEvent("area.upLevelHandler.upInfoRequest")
public class UpInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return null;
    }
}


