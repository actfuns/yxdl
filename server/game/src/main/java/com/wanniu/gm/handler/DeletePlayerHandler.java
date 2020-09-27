package com.wanniu.gm.handler;

import com.alibaba.fastjson.JSONArray;
import com.wanniu.core.db.GCache;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.prepaid.po.PrepaidPO;
import com.wanniu.gm.GMEvent;
import com.wanniu.gm.GMResponse;
import com.wanniu.gm.GMStateResponse;
import com.wanniu.redis.GameDao;
import com.wanniu.redis.PlayerPOManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@GMEvent
public class DeletePlayerHandler
        extends GMBaseHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public GMResponse execute(JSONArray arr) {
        Out.warn(new Object[]{"开始删除小号..."});


        Out.warn(new Object[]{"发补偿..."});
        LocalDate openDate = LocalDate.parse(arr.getString(0), this.formatter);
        Map<String, String> names = GCache.hgetAll("NAME_MODULE");
        for (String playerId : names.values()) {


            try {
                PrepaidPO po = (PrepaidPO) PlayerPOManager.findPO(ConstsTR.prepaidNewTR, playerId, PrepaidPO.class);
                po.first_buy_record.clear();


                PlayerPO player = (PlayerPO) GameDao.get(playerId, ConstsTR.playerTR, PlayerPO.class);
                LocalDate createTime = LocalDate.parse(DateUtil.format(player.createTime, "yyyy-MM-dd"), this.formatter);
                int daysDiff = (int) Math.min(Math.max(0L, ChronoUnit.DAYS.between(openDate, createTime)), GlobalConfig.Combine_MaxDay);
                Out.info(new Object[]{"合服补偿 playerId=", playerId, ",day=", Integer.valueOf(daysDiff)});
                if (daysDiff > 0) {
                    String mailKey = "CombineCompensate";
                    MailSysData mail = new MailSysData(mailKey);
                    mail.attachments = new ArrayList();

                    MailData.Attachment item = new MailData.Attachment();
                    item.itemCode = VirtualItemType.EXP.getItemcode();
                    item.itemNum = daysDiff * GlobalConfig.Combine_Exp;
                    item.isBind = Const.BindType.BIND.getValue();
                    mail.attachments.add(item);


                    item = new MailData.Attachment();
                    item.itemCode = VirtualItemType.UPEXP.getItemcode();
                    item.itemNum = daysDiff * GlobalConfig.Combine_UpExp;
                    item.isBind = Const.BindType.BIND.getValue();
                    mail.attachments.add(item);


                    for (String is : GlobalConfig.Combine_Items.split(",")) {
                        String[] i = is.split(":");
                        MailData.Attachment attachment = new MailData.Attachment();
                        attachment.itemCode = i[0];
                        attachment.itemNum = daysDiff * Integer.parseInt(i[1]);
                        attachment.isBind = Const.BindType.BIND.getValue();
                        mail.attachments.add(attachment);
                    }

                    mail.replace = new HashMap<>();
                    mail.replace.put("day", String.valueOf(daysDiff));
                    MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData) mail, Const.GOODS_CHANGE_TYPE.CombineCompensate);
                }
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
        PlayerPOManager.clearOfflinePO();
        return (GMResponse) new GMStateResponse(0);
    }


    public short getType() {
        return 5;
    }
}


