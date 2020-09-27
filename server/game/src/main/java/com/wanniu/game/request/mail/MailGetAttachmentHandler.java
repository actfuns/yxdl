package com.wanniu.game.request.mail;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.mail.MailManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailGetAttachmentRequest")
public class MailGetAttachmentHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MailHandler.MailGetAttachmentRequest req = MailHandler.MailGetAttachmentRequest.parseFrom(this.pak.getRemaingBytes());

        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        final int code = wPlayer.mailManager.mailGetAttachment(req.getC2SId(), true);
        return new PomeloResponse() {
            protected void write() throws IOException {
                MailHandler.MailGetAttachmentResponse.Builder res = MailHandler.MailGetAttachmentResponse.newBuilder();

                if (code == MailManager.ERR_CODE.ERR_CODE_OK.getValue()) {
                    res.setS2CCode(200);
                } else if (code == MailManager.ERR_CODE.ERR_CODE_BAG_FULL.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                } else if (code == MailManager.ERR_CODE.ERR_CODE_NO_ATTACH.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_NO_ATTACHMENT"));
                } else if (code == MailManager.ERR_CODE.ERR_CODE_NO_SUCH_MAIL.getValue()) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_NO_SUCH_MAIL"));
                } else {

                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


