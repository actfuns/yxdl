package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailGmData;
import com.wanniu.game.player.PlayerDao;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;

import java.util.ArrayList;


@GMEvent
public class MailHandler
        extends GMBaseHandler {
    public GMResponse execute(JSONArray arr) {
        int type = arr.getIntValue(0);
        String rids = arr.getString(1);
        String title = arr.getString(2);
        String content = arr.getString(3);
        String sender = arr.getString(4);
        String createRoleDate = arr.getString(5);
        String minLevel = arr.getString(6);
        String atta = arr.getString(7);
        String mailId = null;
        if (type == 1) {
            mailId = arr.getString(8);
        }

        ArrayList<MailData.Attachment> list = new ArrayList<>();
        if (StringUtil.isNotEmpty(atta)) {
            for (String its : atta.split(";")) {
                MailData.Attachment attachment = new MailData.Attachment();
                attachment.itemCode = its.split(":")[0];
                attachment.itemNum = Integer.parseInt(its.split(":")[1]);

                attachment.isBind = Const.ForceType.BIND.getValue();
                list.add(attachment);
            }
        }
        MailGmData mail = new MailGmData();
        mail.mailSender = sender;
        mail.mailTitle = title;
        mail.mailText = content;
        if (StringUtil.isNotEmpty(minLevel)) {
            mail.minLevel = Integer.parseInt(minLevel);
        }
        mail.attachments = list;

        if (type == 0) {
            String[] ids = rids.split(";");
            for (int i = 0; i < ids.length; i++) {
                String id = ids[i];
                if (PlayerUtil.getPlayerBaseData(id) == null) {

                    String rid = PlayerDao.getIdByName(id);
                    if (rid == null) {
                        return (GMResponse) new GMStateResponse(-2);
                    }
                    ids[i] = rid;
                }
            }
            MailUtil.getInstance().sendMailToSomePlayer(ids, (MailData) mail, Const.GOODS_CHANGE_TYPE.GMT);
        } else {

            if (StringUtil.isNotEmpty(createRoleDate)) {
                mail.createRoleDate = DateUtil.format(createRoleDate);
            }
            MailCenter.getInstance().addServerMail(mailId, mail, Const.GOODS_CHANGE_TYPE.GMT);
        }
        Out.info(new Object[]{"GM邮件记录 json=", arr.toJSONString()});
        return (GMResponse) new GMStateResponse(1);
    }

    public short getType() {
        return 4577;
    }
}


