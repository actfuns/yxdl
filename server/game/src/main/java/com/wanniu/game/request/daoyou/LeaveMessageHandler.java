package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouLeaveMessageRequest")
public class LeaveMessageHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouLeaveMessageRequest req = DaoYouHandler.DaoYouLeaveMessageRequest.parseFrom(this.pak.getRemaingBytes());

        final String messsage = req.getMessage();
        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouLeaveMessageResponse.Builder res = DaoYouHandler.DaoYouLeaveMessageResponse.newBuilder();
                String trimMessage = messsage.trim();
                String msg = DaoYouService.getInstance().leaveMessage(player, trimMessage);
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


