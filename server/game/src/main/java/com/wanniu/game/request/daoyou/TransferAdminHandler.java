package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouTransferAdminRequest")
public class TransferAdminHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouTransferAdminRequest req = DaoYouHandler.DaoYouTransferAdminRequest.parseFrom(this.pak.getRemaingBytes());

        final String newAdminPlayerId = req.getPlayerId();

        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouKickTeamResponse.Builder res = DaoYouHandler.DaoYouKickTeamResponse.newBuilder();
                try {
                    if (null == player) {
                        res.setS2CCode(500);
                        res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                        this.body.writeBytes(res.build().toByteArray());

                        return;
                    }
                    String msg = DaoYouService.getInstance().transferAdmin(player, newAdminPlayerId);
                    if (!msg.equals("")) {
                        res.setS2CCode(500);
                        res.setS2CMsg(msg);
                        this.body.writeBytes(res.build().toByteArray());
                        return;
                    }
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                } catch (Exception err) {
                    Out.error(new Object[]{err});
                    res.setS2CCode(500);
                    this.body.writeBytes(res.build().toByteArray());
                }
            }
        };
    }
}


