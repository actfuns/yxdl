package com.wanniu.game.mail;

import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.MailSystemCO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailGmData;
import com.wanniu.game.mail.data.MailPlayerData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class MailUtil {
    private static MailUtil instance;

    public static MailUtil getInstance() {
        if (instance == null) {
            instance = new MailUtil();
        }
        return instance;
    }


    public boolean sendMail(WNPlayer player, WNMail mail) {
        Out.debug(new Object[]{"add a new mail1: ", mail});
        if (player == null) {
            return false;
        }
        MailCenter.getInstance().addMail(player.getId(), mail, true);

        return false;
    }


    public MailSystemCO getMailSystemPropByKey(String key) {
        MailSystemCO mailProp = (MailSystemCO) GameData.MailSystems.get(key);
        return mailProp;
    }


    public String replacString(String resource, Map<String, String> replaceObject) {
        if (replaceObject == null) {
            return resource;
        }
        String result = resource;
        for (Map.Entry<String, String> node : replaceObject.entrySet()) {
            String replaceKey = "{" + (String) node.getKey() + "}";
            result = result.replace(replaceKey, node.getValue());
        }
        return result;
    }


    public WNMail createMail(MailData mailData, String playerId, Const.GOODS_CHANGE_TYPE origin) {
        if (mailData.mailType < 0) {
            return null;
        }
        WNMail newMail = new WNMail();
        newMail.id = UUID.randomUUID().toString();
        newMail.origin = origin.value;
        newMail.playerId = playerId;
        newMail.status = Const.MailState.MAIL_STATE_NULL.getValue();
        newMail.createTime = (mailData.createTime != null) ? mailData.createTime : new Date();
        newMail.attachment = new ArrayList<>();
        newMail.orderId = (mailData.orderId != null) ? mailData.orderId : "";
        if (mailData.mailType == Const.MailType.MAIL_PLAYER_TYPE.getValue()) {
            MailPlayerData playerData = (MailPlayerData) mailData;
            if (playerData.mailSender == null || playerData.mailSenderId == null || playerData.mailTitle == null || playerData.mailIcon <= 0 || playerData.mailRead <= 0 || playerData.mailText == null) {
                Out.error(new Object[]{"createMail playerData param error "});
                return null;
            }
            newMail.mailType = playerData.mailType;
            newMail.mailSender = playerData.mailSender;
            newMail.mailSenderId = playerData.mailSenderId;
            newMail.mailTitle = playerData.mailTitle;
            newMail.mailText = playerData.mailText;
            newMail.mailRead = playerData.mailRead;
            newMail.mailIcon = playerData.mailIcon;
        } else if (mailData.mailType == Const.MailType.MAIL_SYSTEM_TYPE.getValue()) {


            MailSysData sysData = (MailSysData) mailData;


            MailSystemCO mailProp = getMailSystemPropByKey(sysData.key);
            if (mailProp == null) {
                Out.error(new Object[]{"createMail mailKey error : " + sysData.key});
                return null;
            }
            newMail.mailType = mailProp.mailType;
            newMail.mailSender = mailProp.mailSender;
            newMail.mailSenderId = "";
            newMail.mailTitle = mailProp.mailTitle;
            newMail.mailText = replacString(mailProp.mailText, sysData.replace);
            newMail.mailRead = mailProp.mailRead;
            newMail.mailIcon = 0;
            newMail.mailSubType = sysData.key;
        } else if (mailData.mailType == Const.MailType.MAIL_GM_TYPE.getValue()) {
            MailGmData gmMail = (MailGmData) mailData;
            newMail.mailType = gmMail.mailType;
            newMail.mailSender = gmMail.mailSender;
            newMail.mailSenderId = "";
            newMail.mailTitle = gmMail.mailTitle;
            newMail.mailText = gmMail.mailText;
            newMail.mailRead = Const.MailReadDeal.MAIL_READ_NULL.getValue();
            newMail.mailIcon = 0;
        }


        if (mailData.attachments != null) {
            for (MailData.Attachment attach : mailData.attachments) {
                List<NormalItem> items = ItemUtil.createItemsByItemCode(attach.itemCode, attach.itemNum);
                for (NormalItem item : items) {

                    if (attach.isBind == Const.ForceType.BIND.getValue()) {
                        item.setBind(Const.BindType.BIND.getValue());
                    }

                    if (attach.isBind == Const.ForceType.UN_BIND.getValue()) {
                        item.setBind(Const.BindType.UN_BIND.getValue());
                    }

                    newMail.addAttach(item.itemDb);
                }
            }
        }
        if (mailData.tcCode != null) {

            List<NormalItem> items = ItemUtil.createItemsByTcCode(mailData.tcCode);
            for (NormalItem item : items) {
                newMail.addAttach(item.itemDb);
            }
        }
        if (mailData.entityItems != null) {
            for (int i = 0; i < mailData.entityItems.size(); i++) {
                PlayerItemPO itemData = mailData.entityItems.get(i);
                NormalItem item = ItemUtil.createItemByDbOpts(itemData);
                if (item == null) {
                    Out.error(new Object[]{"createMail createItemByDbOpts error:", itemData});
                    return null;
                }
                newMail.addAttach(item.itemDb);
            }
        }

        if (newMail.attachment != null && newMail.attachment.size() > 0) {
            newMail.hadAttach = Const.MailAttach.MAIL_ATTACH_CARRY.getValue();
        } else {
            newMail.hadAttach = Const.MailAttach.MAIL_ATTACH_NULL.getValue();
        }
        GCache.push("sendMails", newMail.toString());
        return newMail;
    }


    public boolean sendMailToOnePlayer(String playerId, MailData mailData, Const.GOODS_CHANGE_TYPE origin) {
        String[] playerIds = {playerId};
        return sendMailToSomePlayer(playerIds, mailData, origin);
    }

    public boolean sendMailToSomePlayer(String[] playerIds, MailData mailData, Const.GOODS_CHANGE_TYPE origin) {
        for (int i = 0; i < playerIds.length; i++) {
            String playerId = playerIds[i];
            WNMail mail = createMail(mailData, playerId, origin);
            MailCenter.getInstance().addMail(playerId, mail, true);
        }
        return true;
    }
}


