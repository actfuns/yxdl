package com.wanniu.game.request.solo;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.solo.vo.ResultVO;

import java.io.IOException;

import pomelo.area.SoloHandler;


@GClientEvent("area.soloHandler.queryRewardRequest")
public class QueryRewardHandler
        extends SoloRequestFilter {
    public PomeloResponse request(final WNPlayer player) throws Exception {
        return new PomeloResponse() {

            protected void write() throws IOException {
                SoloHandler.QueryRewardResponse.Builder res = SoloHandler.QueryRewardResponse.newBuilder();
                ResultVO result = player.soloManager.handleQueryReward();
                res.setS2CCode(200);
                res.setS2CHasReward(result.get(ResultVO.KEY.HAS_REWARD).intValue());

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


