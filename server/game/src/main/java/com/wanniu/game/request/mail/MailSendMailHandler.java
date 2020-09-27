package com.wanniu.game.request.mail;

import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailPlayerData;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.util.BlackWordUtil;

import java.io.IOException;

import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailSendMailRequest")
public class MailSendMailHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        final MailHandler.MailSendMailRequest req = MailHandler.MailSendMailRequest.parseFrom(this.pak.getRemaingBytes());

        GPlayer player = this.pak.getPlayer();
        final WNPlayer wPlayer = (WNPlayer) player;
        final MailPlayerData mailData = new MailPlayerData();
        mailData.mailSender = wPlayer.getName();
        mailData.mailSenderId = wPlayer.getId();
        mailData.mailTitle = req.getMailTitle();
        mailData.mailText = req.getMailText();
        mailData.mailRead = req.getMailRead();
        mailData.mailIcon = (wPlayer.getPlayer()).pro;
        return new PomeloResponse() {
            protected void write() throws IOException {
                MailHandler.MailSendMailResponse.Builder res = MailHandler.MailSendMailResponse.newBuilder();

                if (BlackWordUtil.isIncludeBlackString(mailData.mailTitle)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_TITLE_BLACK_STRING"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (BlackWordUtil.isIncludeBlackString(mailData.mailText)) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_TEXT_BLACK_STRING"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (mailData.mailText.length() > Const.MailSysParam.MAIL_MAX_WORD.getValue() + 10) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_TEXT_TOO_LONG"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                if (wPlayer.friendManager.isInBlackList(req.getToPlayerId())) {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("MAIL_PLAYER_IN_BLACK_LIST"));
                    this.body.writeBytes(res.build().toByteArray());
                    return;
                }
                boolean result = MailUtil.getInstance().sendMailToOnePlayer(req.getToPlayerId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.mail);
                if (result) {
                    res.setS2CCode(200);
                } else {
                    res.setS2CCode(500);
                    res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
                }

                this.body.writeBytes(res.build().toByteArray());
            }
        };
    }
}


