package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouKickTeamRequest")
public class KickTeamHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouKickTeamRequest req = DaoYouHandler.DaoYouKickTeamRequest.parseFrom(this.pak.getRemaingBytes());

        final String kickPlayerId = req.getPlayerId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouKickTeamResponse.Builder res = DaoYouHandler.DaoYouKickTeamResponse.newBuilder();

                String playerId = player.getId();
                String msg = DaoYouService.getInstance().kickDaoYou(playerId, player.getName(), kickPlayerId);
                if (StringUtil.isNotEmpty(msg)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(msg);
                } else {
                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


