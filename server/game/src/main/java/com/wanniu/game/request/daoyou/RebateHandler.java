package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouRebateRequest")
public class RebateHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouRebateResponse.Builder res = DaoYouHandler.DaoYouRebateResponse.newBuilder();

                DaoYouService.getInstance().getAllRebate(player, res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


