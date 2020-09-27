package com.wanniu.game.player;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.redis.GlobalDao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;


public class RebateCheckTask
        implements Runnable {
    private static int rate = 20;

    private final String uid;
    private final String palyerId;
    private final String palyerName;

    public RebateCheckTask(WNPlayer player) {
        this.uid = player.getUid();
        this.palyerId = player.getId();
        this.palyerName = player.getName();
    }


    public void run() {
        try {
            String value = GlobalDao.hget("rebate", this.uid);
            if (StringUtils.isNotEmpty(value) &&
                    GlobalDao.hremove("rebate", this.uid) > 0L) {
                int diamond = Integer.parseInt(value) / 100 * rate;
                Out.info(new Object[]{"充值返利.uid=", this.uid, ",playerId=", this.palyerId, ",name=", this.palyerName, ",rmb=", value, " 分, diamond=", Integer.valueOf(diamond)});

                MailSysData mail = new MailSysData("CCBReward1");
                mail.attachments = new ArrayList();


                MailData.Attachment att = new MailData.Attachment();
                att.itemCode = VirtualItemType.DIAMOND.getItemcode();
                att.itemNum = diamond;
                mail.attachments.add(att);

                mail.replace = new HashMap<>();
                MailUtil.getInstance().sendMailToOnePlayer(this.palyerId, (MailData) mail, Const.GOODS_CHANGE_TYPE.PAY_REBATE);
            }

        } catch (Exception e) {
            Out.info(new Object[]{"充值返利异常.uid=", this.uid, ",playerId=", this.palyerId, ",name=", this.palyerName, e});
        }
    }
}


