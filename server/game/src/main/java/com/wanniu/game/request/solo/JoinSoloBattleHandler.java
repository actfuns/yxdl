package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.solo.vo.ResultVO;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.joinSoloBattleRequest")
public class JoinSoloBattleHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.JoinSoloBattleResponse.Builder res = SoloHandler.JoinSoloBattleResponse.newBuilder();
                ResultVO result = player.soloManager.handleJoinSoloBattle();

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


