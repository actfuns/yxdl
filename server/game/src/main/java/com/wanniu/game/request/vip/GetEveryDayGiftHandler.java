package com.wanniu.game.request.vip;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.VipHandler;


@GClientEvent("area.vipHandler.getEveryDayGiftRequest")
public class GetEveryDayGiftHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) GetEveryDayGiftHandler.this.pak.getPlayer();
                VipHandler.GetEveryDayGiftRequest req = VipHandler.GetEveryDayGiftRequest.parseFrom(GetEveryDayGiftHandler.this.pak.getRemaingBytes());
                int type = req.getC2SType();
                int result = player.vipManager.takeDailyReward(type);
                VipHandler.GetEveryDayGiftResponse.Builder res = VipHandler.GetEveryDayGiftResponse.newBuilder();
                if (result == 0) {
                    res.setS2CCode(200);
                } else if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CARD_MONTH_NONE"));
                } else if (result == -2) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CARD_FOREVER_NONE"));
                } else if (result == -3) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("CARD_RECEIVED"));
                } else if (result == -4) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }


                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


