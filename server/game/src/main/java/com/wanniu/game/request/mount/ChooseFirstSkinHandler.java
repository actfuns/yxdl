package com.wanniu.game.request.mount;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MountHandler;

@GClientEvent("area.mountHandler.chooseFirstSkinRequest")
public class ChooseFirstSkinHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final MountHandler.ChooseFirstSkinRequest req = MountHandler.ChooseFirstSkinRequest.parseFrom(this.pak.getRemaingBytes());

        return new PomeloResponse() {
            protected void write() throws IOException {
                WNPlayer player = (WNPlayer) ChooseFirstSkinHandler.this.pak.getPlayer();
                int skinId = req.getC2SSkinId();
                MountHandler.ChooseFirstSkinResponse.Builder res = MountHandler.ChooseFirstSkinResponse.newBuilder();


                boolean result = player.mountManager.chooseFirstSkin(skinId);
                if (!result) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                } else {

                    res.setS2CCode(200);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


