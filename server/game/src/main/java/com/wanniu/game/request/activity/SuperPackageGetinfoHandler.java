package com.wanniu.game.request.activity;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.prepaid.PrepaidManager;

import java.io.IOException;

import pomelo.area.ActivityFavorHandler;


@GClientEvent("area.activityFavorHandler.superPackageGetInfoRequest")
public class SuperPackageGetinfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        ActivityFavorHandler.SuperPackageGetInfoRequest req = ActivityFavorHandler.SuperPackageGetInfoRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) SuperPackageGetinfoHandler.this.pak.getPlayer();

                ActivityManager activityManager = player.activityManager;
                PrepaidManager prepaidManager = player.prepaidManager;

                ActivityFavorHandler.SuperPackageGetInfoResponse.Builder res = ActivityFavorHandler.SuperPackageGetInfoResponse.newBuilder();
                ActivityFavorHandler.SuperPackageInfo.Builder spiBuilder = activityManager.SuperPackage_GetInfo();


                res.setSuperPackageInfo(spiBuilder.build());

                res.setS2CCode(200);
                this.body.writeBytes(res.build().toByteArray());
                Out.debug(new Object[]{Integer.valueOf(3)});
            }
        };
    }
}


