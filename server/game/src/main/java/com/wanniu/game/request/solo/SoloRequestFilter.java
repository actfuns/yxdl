package com.wanniu.game.request.solo;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;


public abstract class SoloRequestFilter
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        WNPlayer player = (WNPlayer) this.pak.getPlayer();

        if (player.getSceneType() == Const.SCENE_TYPE.CROSS_SERVER.getValue()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("CROSS_SERVER_AUTH_LIMIT"));
        }

        return request(player);
    }


    public abstract PomeloResponse request(WNPlayer paramWNPlayer) throws Exception;

    public short getType() {
        return 515;
    }
}


