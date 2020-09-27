package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.solo.vo.ResultVO;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.joinSoloRequest")
public class JoinSoloHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.JoinSoloResponse.Builder res = SoloHandler.JoinSoloResponse.newBuilder();
                ResultVO result = player.soloManager.handleJoinSolo();

                if (result.result) {

                    res.setS2CCode(200);
                    res.setS2CAvgMatchTime(result.get(ResultVO.KEY.AVG_MATCHTIME).intValue());
                    res.setS2CStartJoinTime(result.get(ResultVO.KEY.START_JOINTIME).intValue());
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(result.info);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


