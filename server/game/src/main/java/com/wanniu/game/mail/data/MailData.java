package com.wanniu.game.mail.data;

import com.wanniu.game.item.po.PlayerItemPO;

import java.util.Date;
import java.util.List;

public class MailData {
    public int mailId;

    public int mailType;

    public List<Attachment> attachments;

    public List<PlayerItemPO> entityItems;

    public String tcCode;

    public String orderId;

    public Date createTime;

    public static class Attachment {
        public String itemCode;

        public int itemNum;

        public int isBind;
    }
}


