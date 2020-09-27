package com.wanniu.game.request.mount;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.getMountInfoRequest")
public class GetMountInfoHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MountHandler.GetMountInfoRequest req = MountHandler.GetMountInfoRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) GetMountInfoHandler.this.pak.getPlayer();
                MountHandler.GetMountInfoResponse.Builder res = MountHandler.GetMountInfoResponse.newBuilder();
                if (!player.mountManager.isOpenMount()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MOUNT_NOT_HAVE"));
                    this.body.writeBytes(res.build().toByteArray());

                    return;
                }
                res.setS2CCode(200);
                res.setS2CData(player.mountManager.getMountData().build());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


