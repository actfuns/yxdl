package com.wanniu.game.request.mount;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;


@GClientEvent("area.mountHandler.activeMountSkinRequest")
public class ActiveMountSkinHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final MountHandler.ActiveMountSkinRequest req = MountHandler.ActiveMountSkinRequest.parseFrom(this.pak.getRemaingBytes());
        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ActiveMountSkinHandler.this.pak.getPlayer();
                int skinId = req.getC2SSkinId();
                MountHandler.ActiveMountSkinResponse.Builder res = MountHandler.ActiveMountSkinResponse.newBuilder();

                int oldSkin = player.mountManager.mount.usingSkinId;
                int result = player.mountManager.changeSkin(skinId);
                if (result == -1) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MOUNT_SKIN_NOT_HAVE"));
                } else {
                    res.setS2CCode(200);
                }
                Out.info(new Object[]{"坐骑换肤成功,roleId=", player.getId(), ",老坐骑外形Id=", Integer.valueOf(oldSkin), "新坐骑外形Id=",
                        Integer.valueOf(player.mountManager.mount.usingSkinId)});
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


