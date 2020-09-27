package com.wanniu.game.request.solo;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.solo.vo.ResultVO;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.leaveSoloAreaRequest")
public class LeaveSoloAreaHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        if (player.getSceneType() != Const.SCENE_TYPE.SIN_COM.getValue()) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("AREA_ID_NULL"));
        }
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.LeaveSoloAreaResponse.Builder res = SoloHandler.LeaveSoloAreaResponse.newBuilder();

                ResultVO result = player.soloManager.handleLeaveSoloArea();
                if (result.result) {


                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(result.info);
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


