package com.wanniu.game.request.onlineGift;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.OnlineGiftHandler;


@GClientEvent("area.onlineGiftHandler.receiveGiftRequest")
public class ReceiveGiftHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final OnlineGiftHandler.ReceiveGiftRequest req = OnlineGiftHandler.ReceiveGiftRequest.parseFrom(this.pak.getRemaingBytes());

        final WNPlayer player = (WNPlayer) this.pak.getPlayer();
        return new PomeloResponse() {
            protected void write() throws IOException {
                String msg;
                OnlineGiftHandler.ReceiveGiftResponse.Builder res = OnlineGiftHandler.ReceiveGiftResponse.newBuilder();

                if (req.getC2SId() == 0) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("PARAM_ERROR"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                int resultCode = player.onlineGiftManager.receiveGift(req.getC2SId());
                if (resultCode == 0) {
                    OnlineGiftHandler.OnlineGift giftData = player.onlineGiftManager.toJson4Payload();
                    res.setS2CGift(giftData);
                    res.setS2CCode(200);
                    this.body.writeBytes(res.build().toByteArray());
                    Out.info(new Object[]{this.val$player.getId(), ":领取在线礼包，礼包id:", Integer.valueOf(this.val$req.getC2SId())});

                    return;
                }
                if (resultCode == -1) {
                    msg = LangService.getValue("ONLINE_HAVE_RECEIVED");
                } else if (resultCode == -2) {
                    msg = LangService.getValue("ONLINE_UPLEVEL_NOT_MATCH");
                } else if (resultCode == -3) {
                    msg = LangService.getValue("ONLINE_LEVEL_NOT_MATCH");
                } else if (resultCode == -4) {
                    msg = LangService.getValue("ONLINE_TIME_NOT_ENOUGH");
                } else if (resultCode == -5) {
                    msg = LangService.getValue("BAG_NOT_ENOUGH_POS");
                } else if (resultCode == -6) {
                    msg = LangService.getValue("PARAM_ERROR");
                } else {
                    msg = LangService.getValue("SOMETHING_ERR");
                }
                res.setS2CCode(500);
                res.setS2CMsg(msg);
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


