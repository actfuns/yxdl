package com.wanniu.game.mail;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.CommonUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.po.ItemSpeData;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.PlayerMailDataPO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import pomelo.area.MailHandler;
import pomelo.area.PlayerHandler;

public class MailManager
        extends ModuleManager {
    public Map<String, WNMail> mails;
    public String playerId;
    public PlayerMailDataPO data;

    public enum ERR_CODE {
        ERR_CODE_OK(0), ERR_CODE_BAG_FULL(1), ERR_CODE_NO_ATTACH(2), ERR_CODE_NO_SUCH_MAIL(3);
        private int value;

        ERR_CODE(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }


    public WNPlayer getPlayer() {
        return PlayerUtil.getOnlinePlayer(this.playerId);
    }

    public MailManager(String playerId, PlayerMailDataPO data) {
        this.data = data;
        this.playerId = playerId;
        this.mails = data.mails;
    }


    public void addServerMailRecord(String serverMailId) {
        this.data.serverMailRecord.put(serverMailId, serverMailId);
    }


    public final int[] getUnReadMailCount() {
        int[] retValue = new int[2];
        for (WNMail mail : this.mails.values()) {
            if (mail.status == Const.MailState.MAIL_STATE_NULL.getValue()) {
                retValue[Const.MailStaus.MAIL_UNREAD.getValue()] = retValue[Const.MailStaus.MAIL_UNREAD.getValue()] + 1;
            }
            if (hasAttachment(mail)) {
                retValue[Const.MailStaus.MAIL_UNRECEIVE.getValue()] = retValue[Const.MailStaus.MAIL_UNRECEIVE.getValue()] + 1;
            }
        }
        return retValue;
    }


    public final boolean hasAttachment(WNMail mail) {
        if (mail.attachment == null || mail.attachment.size() == 0) {
            return false;
        }
        return true;
    }

    public final int getMailCount() {
        return this.mails.size();
    }


    private final ArrayList<WNMail> getSortMailList() {
        ArrayList<WNMail> list = new ArrayList<>();
        for (Map.Entry<String, WNMail> node : this.mails.entrySet()) {
            list.add(node.getValue());
        }
        Collections.sort(list, new Comparator<WNMail>() {
            public int compare(WNMail arg0, WNMail arg1) {
                return arg0.compareTo(arg1);
            }
        });
        return list;
    }


    public final boolean addMail(WNMail mail, boolean isUpdateScript) {
        WNPlayer player = getPlayer();
        if (player != null && player.isRobot()) {
            return false;
        }
        if (this.mails.containsKey(mail.id)) {
            return false;
        }
        if (this.mails.size() >= Const.MailSysParam.MAIL_MAX_NUM.getValue()) {

            ArrayList<WNMail> mailArray = getSortMailList();
            int delCount = this.mails.size() - Const.MailSysParam.MAIL_MAX_NUM.getValue() + 1;
            for (int i = 0; i < delCount; i++) {
                mailDelete(((WNMail) mailArray.get(mailArray.size() - 1)).id, true);
            }
        }


        this.mails.put(mail.id, mail);
        Out.info(new Object[]{"新增邮件 playerId=", mail.playerId, ",mailId=", mail.id, ",attachment=", JSON.toJSONString(mail.attachment)});

        if (player == null) {
            return false;
        }

        MailHandler.Mail data = mail.toMailBuilder(player.getPlayerAttach()).build();
        ArrayList<MailHandler.Mail> list = new ArrayList<>();
        list.add(data);

        WNNotifyManager.getInstance().pushMails(player, list);

        if (isUpdateScript) {
            updateSuperScript();
            CommonUtil.sendIconMsgType(Const.MESSAGE_TYPE.mail_receive, player.getId());
        }


        Out.debug(new Object[]{"mail count :", Integer.valueOf(getMailCount())});
        return true;
    }


    public final void readMail(String[] ids) {
        if (ids != null) {
            for (String key : ids) {
                WNMail mail = this.mails.get(key);
                if (mail != null) {
                    if (mail.mailRead == Const.MailReadDeal.MAIL_READ_DEL.getValue()) {
                        mail.status = Const.MailState.MAIL_STATE_READ.getValue();
                        if (!hasAttachment(mail)) {
                            mailDelete(mail.id, false);
                        }
                    } else if (mail.status == Const.MailState.MAIL_STATE_NULL.getValue()) {
                        mail.status = Const.MailState.MAIL_STATE_READ.getValue();
                        updateSuperScript();
                    }
                }
            }
        }
    }


    public final boolean mailDelete(String id, boolean isForce) {
        WNMail mail = this.mails.get(id);
        boolean isDelete = false;
        if (mail != null) {
            if (isForce) {
                isDelete = true;
            } else {
                if (mail.status == Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue()) {
                    isDelete = true;
                }
                if (mail.status == Const.MailState.MAIL_STATE_READ.getValue() && !hasAttachment(mail)) {
                    isDelete = true;
                }
            }
            if (isDelete) {
                this.mails.remove(id);
                Out.info(new Object[]{"删除邮件 playerId=", mail.playerId, ",mailId=", mail.id, ",isForce=", Boolean.valueOf(isForce)});
                updateSuperScript();
                return true;
            }
        }

        return false;
    }


    public final String[] mailDeleteOneKey() {
        List<String> deleteIds = new ArrayList<>();
        for (Map.Entry<String, WNMail> node : this.mails.entrySet()) {
            WNMail mail = node.getValue();
            String id = node.getKey();
            if (mail.status == Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue()) {
                deleteIds.add(id);
            }

            if (mail.status == Const.MailState.MAIL_STATE_READ.getValue() && !hasAttachment(mail)) {
                deleteIds.add(id);
            }
        }
        String[] ids = new String[deleteIds.size()];
        int index = 0;
        for (String id : deleteIds) {
            this.mails.remove(id);
            ids[index++] = id;
        }
        deleteIds.clear();
        updateSuperScript();
        return ids;
    }


    public final int mailGetAttachment(String id, boolean isUpdate) {
        if (!this.mails.containsKey(id)) {
            return ERR_CODE.ERR_CODE_NO_SUCH_MAIL.getValue();
        }
        WNMail mail = this.mails.get(id);
        if (!hasAttachment(mail)) {
            return ERR_CODE.ERR_CODE_NO_ATTACH.getValue();
        }
        List<PlayerItemPO> attachment = mail.attachment;


        if (!getPlayer().getWnBag().testAddEntityItemsPO(attachment, true)) {
            return ERR_CODE.ERR_CODE_BAG_FULL.getValue();
        }

        Out.info(new Object[]{"领取邮件附件 playerId=", getPlayer().getId(), ",mailId=", mail.id, ",attachment=", JSON.toJSONString(attachment)});

        Const.GOODS_CHANGE_TYPE origin = Const.GOODS_CHANGE_TYPE.getE(mail.origin);
        getPlayer().getWnBag().addEntityItemsPO(attachment, (origin == null) ? Const.GOODS_CHANGE_TYPE.mail : origin);
        mail.status = Const.MailState.MAIL_STATE_ATTACH_RECEIVE.getValue();
        mail.attachment = new ArrayList<>();
        if (mail.mailRead == Const.MailReadDeal.MAIL_READ_DEL.getValue()) {
            mailDelete(id, false);
        }

        if (StringUtil.isNotEmpty(mail.mailSubType) && mail.mailSubType.equals("Consignment_sale")) {
            for (PlayerItemPO item : attachment) {
                if (item.code.equals("diamond")) {
                    (getPlayer()).achievementManager.onGetDiamondInConsignment(item.speData.worth);
                }
            }
        }

        for (PlayerItemPO item : attachment) {
            if (item.code.equals("diamond")) {
                if (item.speData.worth >= 6480)
                    PlayerUtil.bi(getClass(), Const.BiLogType.Mail, getPlayer(), new Object[]{id, mail.mailSenderId, Integer.valueOf(item.speData.worth)});
                continue;
            }
            DItemEquipBase prop = ItemConfig.getInstance().getItemProp(item.code);
            if (prop != null && prop.qcolor >= Const.ItemQuality.ORANGE.getValue() && ItemUtil.isEquipByItemType(prop.itemType)) {
                StringBuffer sb = new StringBuffer();
                if (item.speData != null) {
                    ItemSpeData speData = item.speData;
                    if (speData != null) {
                        sb.append(speData.baseAtts.toString());
                        if (speData.extAtts != null) {
                            sb.append("|||").append(speData.extAtts.toString());
                        }
                        if (speData.legendAtts != null) {
                            sb.append("|||").append(speData.legendAtts.toString());
                        }
                    }
                }
                PlayerUtil.bi(getClass(), Const.BiLogType.Mail, getPlayer(), new Object[]{id, mail.mailSenderId, item.id, item.code, sb.toString()});
            }
        }


        if (!isUpdate) {
            return ERR_CODE.ERR_CODE_OK.getValue();
        }

        updateSuperScript();
        return ERR_CODE.ERR_CODE_OK.getValue();
    }


    public final Const.MailAttachments mailGetAttachmentOneKey() {
        Const.MailAttachments mailAttachments = new Const.MailAttachments();
        List<String> ids = new ArrayList<>();
        String[] idstr = new String[this.mails.size()];
        idstr = (String[]) this.mails.keySet().toArray((Object[]) idstr);
        for (String id : idstr) {
            int code = mailGetAttachment(id, false);
            if (code == ERR_CODE.ERR_CODE_OK.getValue()) {
                ids.add(id);
            } else {
                if (code == ERR_CODE.ERR_CODE_BAG_FULL.getValue()) {
                    mailAttachments.code = code;
                    break;
                }
                mailAttachments.code = code;
            }

        }


        mailAttachments.mailIds = ids;
        updateSuperScript();
        return mailAttachments;
    }

    public final boolean onMessage(int operate, MessageData message) {
        if (message.getMessageType() == Const.MESSAGE_TYPE.mail_receive.getValue()) {
            return false;
        }
        return true;
    }


    public final WNMail getMailByID(String id) {
        if (this.mails.containsKey(id)) {
            return this.mails.get(id);
        }
        return null;
    }


    public final void updateSuperScript() {
        if (getPlayer() != null)
            getPlayer().updateSuperScriptList(getSuperScript());
    }

    public final List<PlayerHandler.SuperScriptType> getSuperScript() {
        int[] countInfo = getUnReadMailCount();
        int number = 0;
        if (countInfo[Const.MailStaus.MAIL_UNREAD.getValue()] > 0) {
            number = countInfo[Const.MailStaus.MAIL_UNREAD.getValue()];
        } else if (countInfo[Const.MailStaus.MAIL_UNRECEIVE.getValue()] > 0) {
            number = countInfo[Const.MailStaus.MAIL_UNRECEIVE.getValue()];
        }

        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        PlayerHandler.SuperScriptType.Builder script = PlayerHandler.SuperScriptType.newBuilder();
        script.setType(Const.SUPERSCRIPT_TYPE.MAIL.getValue());
        script.setNumber(number);
        list.add(script.build());
        return list;
    }


    public final MailHandler.Mail[] getAllMails(WNPlayer player) {
        MailHandler.Mail[] mailArray = new MailHandler.Mail[this.mails.size()];
        ArrayList<WNMail> list_mailArray = getSortMailList();
        int index = 0;
        for (WNMail mail : list_mailArray) {
            mailArray[index++] = mail.toMailBuilder(player.getPlayerAttach()).build();
        }


        return mailArray;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
        switch (eventType) {
            case AFTER_LOGIN:
                MailCenter.getInstance().checkServerMail(this);
                break;
        }
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.MAIL;
    }
}


