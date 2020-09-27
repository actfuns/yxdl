package com.wanniu.game.request.player;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.transByAreaIdRequest")
public class TransByAreaIdHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(WNPlayer player) throws Exception {
        PlayerHandler.TransByAreaIdRequest req = PlayerHandler.TransByAreaIdRequest.parseFrom(this.pak.getRemaingBytes());
        int areaId = req.getC2SAreaId();
        MapBase sceneProp = AreaUtil.getAreaProp(areaId);
        String result = AreaUtil.canTransArea(sceneProp, player);
        if (result != null) {
            return (PomeloResponse) new ErrorResponse(result);
        }

        GWorld.getInstance().ansycExec(() -> {
            AreaUtil.disCardItemByTransArea(sceneProp, player);

            AreaUtil.enterArea(player, areaId, 0.0F, 0.0F);
        });
        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.TransByAreaIdResponse.Builder res = PlayerHandler.TransByAreaIdResponse.newBuilder();
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


