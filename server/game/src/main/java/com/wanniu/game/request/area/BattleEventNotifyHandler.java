package com.wanniu.game.request.area;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;


@GClientEvent("area.playerHandler.battleEventNotify")
public class BattleEventNotifyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return null;
    }
}


