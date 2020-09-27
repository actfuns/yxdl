package com.wanniu.game.request.mail;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailDeleteRequest")
public class MailDeleteHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MailHandler.MailDeleteRequest req = MailHandler.MailDeleteRequest.parseFrom(this.pak.getRemaingBytes());

        GPlayer gPlayer = this.pak.getPlayer();
        final String id = req.getC2SId();
        final WNPlayer wPlayer = (WNPlayer) gPlayer;
        return new PomeloResponse() {
            protected void write() throws IOException {
                MailHandler.MailDeleteResponse.Builder res = MailHandler.MailDeleteResponse.newBuilder();
                if (wPlayer.mailManager.mailDelete(id, false)) {
                    res.setS2CCode(200);
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_DEL_NOT_READ_OR_NOT_GET_ATTACH"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


