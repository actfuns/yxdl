package com.wanniu.game.request.leaderboard;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.LeaderBoardHandler;


@GClientEvent("area.leaderBoardHandler.worShipRequest")
public class WorShipHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        LeaderBoardHandler.WorShipRequest req = LeaderBoardHandler.WorShipRequest.parseFrom(this.pak.getRemaingBytes());
        final int _type = req.getC2SType();

        return new PomeloResponse() {
            protected void write() throws IOException {
                LeaderBoardHandler.WorShipResponse.Builder res = LeaderBoardHandler.WorShipResponse.newBuilder();

                WorShipHandler.WorshipRes result = player.leaderBoardManager.worShip(player, _type);
                if (result.result) {
                    res.setS2CCode(200);
                    res.addAllS2CAwards(result.awards);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(result.info);
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }

    public static final class WorshipRes {
        public boolean result;
        public String info;
        public List<String> awards;

        public WorshipRes(boolean result, String info, List<String> awards) {
            this.result = result;
            this.info = info;
            this.awards = awards;
        }
    }
}


