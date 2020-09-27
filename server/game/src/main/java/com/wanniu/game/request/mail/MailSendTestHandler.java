package com.wanniu.game.request.mail;

import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.protocol.PomeloRequest;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.game.common.Const;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailPlayerData;
import com.wanniu.game.player.WNPlayer;
import pomelo.area.MailHandler;


@GClientEvent("area.mailHandler.mailSendTestNotify")
public class MailSendTestHandler
        extends PomeloRequest {
    public PomeloResponse request() throws Exception {
        MailHandler.MailSendTestNotify req = MailHandler.MailSendTestNotify.parseFrom(this.pak.getRemaingBytes());

        GPlayer player = this.pak.getPlayer();
        WNPlayer wPlayer = (WNPlayer) player;
        MailPlayerData mailData = new MailPlayerData();
        mailData.mailId = req.getC2SMailId();
        mailData.mailSender = wPlayer.getName();
        mailData.mailSenderId = wPlayer.getId();
        mailData.tcCode = req.getC2STcCode();
        mailData.mailIcon = (wPlayer.getPlayer()).pro;
        MailUtil.getInstance().sendMailToOnePlayer(player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.mail);
        return null;
    }
}


