package com.wanniu.game.request.activity;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.prepaid.PrepaidService;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;
import pomelo.area.PrepaidHandler;


@GClientEvent("area.activityFavorHandler.superPackageBuyRequest")
public class SuperPackageBuyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.SuperPackageBuyRequest req = ActivityFavorHandler.SuperPackageBuyRequest.parseFrom(this.pak.getRemaingBytes());
        int productId = req.getPackageId();
        int channelId = req.getChannelId();
        WNPlayer player = (WNPlayer) this.pak.getPlayer();
        boolean isCard = false;
        String imei = req.getC2SImei();
        int os = req.getC2SOs();

        if (!player.activityManager.SuperPackage_GetBoughtable(productId)) {

            final PrepaidHandler.PrepaidOrderIdResponse.Builder res = PrepaidHandler.PrepaidOrderIdResponse.newBuilder();
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("ACTIVITY_SUPERPACKAGE_HAVE_BOUGHT"));

            PomeloResponse me = new PomeloResponse() {
                protected void write() throws IOException {
                    this.body.writeBytes(res.build().toByteArray());
                }
            };
            return me;
        }
        return PrepaidService.getInstance().createOrderId(productId, channelId, player, isCard, true, imei, os);
    }
}


