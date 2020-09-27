package com.wanniu.game.request.daoyou;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.daoyou.DaoYouHandler;


@GClientEvent("daoyou.daoYouHandler.daoYouNoticeRequest")
public class NoticeHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final WNPlayer player = (WNPlayer) this.pak.getPlayer();

        DaoYouHandler.DaoYouNoticeRequest req = DaoYouHandler.DaoYouNoticeRequest.parseFrom(this.pak.getRemaingBytes());

        final String notice = req.getNotice();
        return new PomeloResponse() {
            protected void write() throws IOException {
                DaoYouHandler.DaoYouNoticeResponse.Builder res = DaoYouHandler.DaoYouNoticeResponse.newBuilder();

                String trimNotice = notice.trim();
                String playerId = player.getId();
                String msg = DaoYouService.getInstance().editNotice(playerId, trimNotice);
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


