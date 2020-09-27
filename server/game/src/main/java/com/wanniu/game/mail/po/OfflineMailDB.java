package com.wanniu.game.mail.po;

import com.wanniu.game.mail.data.MailData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfflineMailDB {
    public String id;
    public int logicServerId;
    public Date modifyTime;
    public Date oldestTime;
    public List<MailData> mails = new ArrayList<>();
}


