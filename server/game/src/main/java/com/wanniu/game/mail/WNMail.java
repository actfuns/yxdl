package com.wanniu.game.mail;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.poes.PlayerBasePO;

import java.util.Date;
import java.util.List;

import pomelo.area.MailHandler;
import pomelo.item.ItemOuterClass;


public class WNMail {
    public String id;
    public String playerId;
    public Date createTime;
    public List<PlayerItemPO> attachment;
    public String orderId;
    public String mailSender;
    public String mailSenderId;
    public String mailTitle;
    public String mailText;
    public int mailRead;
    public int mailIcon;
    public int mailId;
    public int mailType;
    public String mailSubType;
    public int hadAttach;
    public int status;
    public int origin;

    public String toString() {
        return "WNMail{id='" + this.id + '\'' + ", playerId='" + this.playerId + '\'' + ", createTime=" + this.createTime + ", attachment=" + this.attachment + ", orderId='" + this.orderId + '\'' + ", mailSender='" + this.mailSender + '\'' + ", mailSenderId='" + this.mailSenderId + '\'' + ", mailTitle='" + this.mailTitle + '\'' + ", mailText='" + this.mailText + '\'' + ", mailRead=" + this.mailRead + ", mailIcon=" + this.mailIcon + ", mailId=" + this.mailId + ", mailType=" + this.mailType + ", mailSubType='" + this.mailSubType + '\'' + ", hadAttach=" + this.hadAttach + ", status=" + this.status + ", origin=" + this.origin + '}';
    }


    public int compareTo(WNMail mail) {
        int flag = 0;
        if (this.attachment != null && this.attachment.size() > 0) {
            if (mail.attachment == null || mail.attachment.size() < 1) {
                return -1;
            }
        } else if (mail.attachment != null && mail.attachment.size() > 0) {
            return 1;
        }


        if (this.status != mail.status) {
            return this.status - mail.status;
        }

        if (this.createTime.after(mail.createTime))
            return -1;
        if (this.createTime.before(mail.createTime))
            return 1;
        return flag;
    }


    public MailHandler.Mail.Builder toMailBuilder(PlayerBasePO basePO) {
        MailHandler.Mail.Builder builder = MailHandler.Mail.newBuilder();
        builder.setId(this.id);
        builder.setMailId(0);
        builder.setMailType(this.mailType);
        builder.setMailIcon(this.mailIcon);
        builder.setMailSender(this.mailSender);
        builder.setMailSenderId(this.mailSenderId);
        builder.setMailTitle(this.mailTitle);
        builder.setMailText(this.mailText);
        String time = String.valueOf(this.createTime.getTime());
        builder.setCreateTime(time);
        builder.setStatus(this.status);
        builder.setMailRead(this.mailRead);
        builder.setHadAttach(this.hadAttach);
        if (this.hadAttach == Const.MailAttach.MAIL_ATTACH_CARRY.getValue()) {
            for (PlayerItemPO att : this.attachment) {

                int groupCount = att.groupCount;
                DItemEquipBase prop = ItemConfig.getInstance().getItemProp(att.code);
                if (ItemConfig.getInstance().getSecondType(prop.type) == Const.ItemSecondType.virtual.getValue() &&
                        att.speData != null) {
                    groupCount = att.speData.worth;
                }

                ItemOuterClass.MiniItem item = ItemUtil.getMiniItemData(att.code, groupCount, Const.ForceType.getE(att.isBind)).build();
                builder.addAttachment(item);


                builder.addNewAttachment(ItemUtil.createItemByDbOpts(att).getItemDetail(basePO));
            }
        }
        return builder;
    }

    public void addAttach(PlayerItemPO item) {
        if (this.attachment.size() <= GlobalConfig.Mail_Attach_Size) {
            this.attachment.add(item);
        } else {
            Out.warn(new Object[]{"mail attach too many:", Utils.serialize(item)});
        }
    }
}


