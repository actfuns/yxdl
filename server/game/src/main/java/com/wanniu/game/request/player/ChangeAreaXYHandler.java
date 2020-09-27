package com.wanniu.game.request.player;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.area.AreaData;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.changeAreaXYRequest")
public class ChangeAreaXYHandler
        extends ChangeAreaFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        PlayerHandler.ChangeAreaXYRequest req = PlayerHandler.ChangeAreaXYRequest.parseFrom(this.pak.getRemaingBytes());

        final String instanceId = req.getInstanceId();
        if (StringUtil.isEmpty(instanceId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DATA_ERR"));
        }
        if (instanceId.equals(player.getInstanceId())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("MAP_NOT_SWITCH"));
        }

        final int areaId = req.getMapId();
        final int posx = req.getPosx();
        final int posy = req.getPosy();
        Out.debug(new Object[]{"changeAreaXYRequest player instanceId:", instanceId, "AreaId:", Integer.valueOf(areaId), " x:", Integer.valueOf(posx), " y:", Integer.valueOf(posy)});

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.ChangeAreaXYResponse.Builder res = PlayerHandler.ChangeAreaXYResponse.newBuilder();


                MapBase sceneProp = AreaUtil.getAreaProp(areaId);
                String result = AreaUtil.canTransArea(sceneProp, player);
                if (result != null) {
                    res.setS2CCode(500);
                    res.setS2CMsg(result);
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                AreaUtil.disCardItemByTransArea(sceneProp, player);
                AreaUtil.changeArea(player, new AreaData(areaId, posx, posy, instanceId));
                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


