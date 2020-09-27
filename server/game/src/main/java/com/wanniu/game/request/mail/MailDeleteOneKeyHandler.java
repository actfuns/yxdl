package com.wanniu.game.request.mail;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailDeleteOneKeyRequest")
public class MailDeleteOneKeyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        final String[] ids = wPlayer.mailManager.mailDeleteOneKey();
        return new PomeloResponse() {
            protected void write() throws IOException {
                MailHandler.MailDeleteOneKeyResponse.Builder res = MailHandler.MailDeleteOneKeyResponse.newBuilder();

                res.setS2CCode(200);
                for (int i = 0; i < ids.length; i++) {
                    res.addS2CIds(ids[i]);
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


