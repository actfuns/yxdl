package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouInviteDaoYouRequest")
public class InviteDaoYouHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouInviteDaoYouRequest req = DaoYouHandler.DaoYouInviteDaoYouRequest.parseFrom(this.pak.getRemaingBytes());

        final String toPlayerId = req.getPlayerId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouInviteDaoYouResponse.Builder res = DaoYouHandler.DaoYouInviteDaoYouResponse.newBuilder();
                String msg = DaoYouService.getInstance().inviteDaoYou(player, toPlayerId, false);
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


