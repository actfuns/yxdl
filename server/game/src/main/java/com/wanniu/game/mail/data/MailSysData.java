package com.wanniu.game.mail.data;

import com.wanniu.game.common.Const;

import java.util.Map;


public class MailSysData
        extends MailData {
    public Map<String, String> replace;
    public String key;

    public MailSysData(String key) {
        this.key = key;
        this.mailType = Const.MailType.MAIL_SYSTEM_TYPE.getValue();
    }
}


