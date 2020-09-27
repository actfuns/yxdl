package com.wanniu.game.request.mail;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.mail.MailManager;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;
import java.util.List;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailGetAttachmentOneKeyRequest")
public class MailGetAttachmentOneKeyHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;
        return new PomeloResponse() {
            protected void write() throws IOException {
                Const.MailAttachments attachments = wPlayer.mailManager.mailGetAttachmentOneKey();
                MailHandler.MailGetAttachmentOneKeyResponse.Builder res = MailHandler.MailGetAttachmentOneKeyResponse.newBuilder();

                res.setS2CCode(200);
                List<String> mailIds = attachments.mailIds;
                res.addAllS2CIds(mailIds);


                if (attachments.code == MailManager.ERR_CODE.ERR_CODE_BAG_FULL.getValue()) {

                    res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


