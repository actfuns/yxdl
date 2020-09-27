package com.wanniu.game.request.player;

import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.PlayerUtil;

import java.io.IOException;

import pomelo.area.PlayerHandler;


@GClientEvent("area.playerHandler.getPlayerPositionRequest")
public class GetPlayerPositionHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        PlayerHandler.GetPlayerPositionRequest req = PlayerHandler.GetPlayerPositionRequest.parseFrom(this.pak.getRemaingBytes());
        String playerId = req.getS2CPlayerId();

        if (StringUtil.isEmpty(playerId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PARAM_ERROR"));
        }

        if (!PlayerUtil.isOnline(playerId)) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
        }

        final JSONObject playerNowData = PlayerUtil.getPlayerNowPosition(playerId);
        if (playerNowData == null) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("PLAYER_NOT_ONLINE"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                PlayerHandler.GetPlayerPositionResponse.Builder res = PlayerHandler.GetPlayerPositionResponse.newBuilder();

                res.setS2CCode(200);
                res.setS2CAreaId(playerNowData.getIntValue("areaId"));
                res.setS2CTemplateID(playerNowData.getIntValue("templateID"));
                res.setS2CInstanceId(playerNowData.getString("instanceId"));
                res.setS2CTargetX(playerNowData.getIntValue("x"));
                res.setS2CTargetY(playerNowData.getIntValue("y"));

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


