package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.ErrorResponse;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouRequest")
public class ApplyDaoYouHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        if (!player.functionOpenManager.isOpen(Const.FunctionType.DaoYou.getValue())) {
            return (PomeloResponse) new ErrorResponse(LangService.getValue("DAO_YOU_NOT_OPEN"));
        }

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouResponse.Builder res = DaoYouHandler.DaoYouResponse.newBuilder();

                String playerId = player.getId();
                DaoYouService.getInstance().applyDaoYouList(playerId, res);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


