package com.wanniu.game.request.mail;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.game.common.Const;
import com.wanniu.game.player.WNPlayer;

import java.io.IOException;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailGetAllRequest")
public class MailGetAllHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        return new PomeloResponse() {
            protected void write() throws IOException {
                MailHandler.MailGetAllResponse.Builder res = MailHandler.MailGetAllResponse.newBuilder();

                res.setS2CCode(200);
                GPlayer gPlayer = MailGetAllHandler.this.pak.getPlayer();
                WNPlayer wPlayer = (WNPlayer) gPlayer;
                MailHandler.Mail[] mails = wPlayer.mailManager.getAllMails(wPlayer);
                for (int i = 0; i < mails.length; i++) {
                    res.addMails(mails[i]);
                }
                res.setS2CMaxMailNum(Const.MailSysParam.MAIL_MAX_NUM.getValue());
                res.setS2CMaxWordNum(Const.MailSysParam.MAIL_MAX_WORD.getValue());
                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


