package com.wanniu.game.consignmentShop;

import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SaleReviewTimeCO;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.mail.MailCenter;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.message.MessageData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.util.ArrayList;
import java.util.HashMap;

import pomelo.item.ItemOuterClass;


public class ConsignmentUtil {
    public static int depositPrice(int price) {
        int ratio = GlobalConfig.Consignment_Fee;
        int min = GlobalConfig.Consignment_MinFee;
        return Math.max(min, (int) Math.floor((price * ratio / 100)));
    }


    public static int commissionPrice(int globalZone, int price) {
        int ratio = GlobalConfig.Consignment_Commission;
        if (globalZone == 1) {
            ratio = GlobalConfig.Consignment_Commission_serverEnter;
        }
        int min = GlobalConfig.Consignment_MinCommission;
        return Math.max(min, (int) Math.floor((price * ratio / 100)));
    }


    public static int consignmentMinPrice(int price) {
        int min = GlobalConfig.Consignment_MinPrice;
        return Math.max(price, min);
    }


    public static int consignmentMaxPrice(int price) {
        int max = GlobalConfig.Consignment_MaxPrice;
        return Math.min(price, max);
    }


    public static int sellNum(WNPlayer player) {
        int orgin = GlobalConfig.Consignment_SellNum;
        int vip = player.baseDataManager.getVip();
        int add = 0;
        if (vip > 0) {
            add = ((CardCO) GameData.Cards.get(Integer.valueOf(vip))).prv4;
        }
        return orgin + add;
    }


    public static int sellTime() {
        return GlobalConfig.Consignment_SellTime * Const.Time.Hour.getValue();
    }

    public static int getConsignmentLevel() {
        return GlobalConfig.Consignment_Level;
    }

    public static String sysItemId = "0000000";


    public static int getLateMinutes(int price) {
        int minutes = 0;
        for (SaleReviewTimeCO cfg : GameData.SaleReviewTimes.values()) {
            if (price >= cfg.minDiamond && price <= cfg.maxDiamond) {
                minutes = RandomUtil.getInt(cfg.minTime, cfg.maxTime);
                break;
            }
        }
        return minutes;
    }


    public static void timeOutMail(ConsignmentItemsPO v) {
        NormalItem actualItem = ItemUtil.createItemByDbOpts(v.db);
        String itemName = MessageUtil.itemColorName(actualItem.prop.qcolor, actualItem.prop.name);
        MailSysData mailData = new MailSysData("Consignment_sendback");
        mailData.replace = new HashMap<>();
        mailData.replace.put("storeItem", itemName);
        mailData.entityItems = new ArrayList();
        mailData.entityItems.add(actualItem.itemDb);
        MailCenter.getInstance().sendOfflineMailToPlayers(new String[]{v.consignmentPlayerId}, (MailData) mailData, Const.GOODS_CHANGE_TYPE.CONSIGNMENT_TIMEOUT);
    }


    public static ItemOuterClass.ConsignmentItem buildConsignmentItem(WNPlayer player, ConsignmentItemsPO item) {
        NormalItem normalItem = ItemUtil.createItemByDbOpts(item.db);
        ItemOuterClass.ConsignmentItem.Builder builder = ItemOuterClass.ConsignmentItem.newBuilder();
        builder.setDetail(normalItem.getItemDetail(player.playerBasePO));
        builder.setGroupCount(item.groupCount);
        builder.setPublishTimes(item.publishTimes);
        builder.setConsignmentPlayerId(item.consignmentPlayerId);

        builder.setConsignmentPlayerName(GlobalConfig.Consignment_Anonymous_Show);
        builder.setConsignmentPrice(item.consignmentPrice);
        builder.setConsignmentPlayerPro(item.consignmentPlayerPro);

        long lateTime = (item.lateMinutes * Const.Time.Minute.getValue());
        builder.setLateTime(lateTime);
        builder.setConsignmentTime(String.valueOf(item.consignmentTime));


        return builder.build();
    }

    public static boolean onMessage(WNPlayer player, Const.MESSAGE_TYPE msgType, int operate, MessageData message) {
        if (operate == Const.MESSAGE_OPERATE.TYPE_ACCEPT.getValue()) {
            Out.error(new Object[]{Utils.serialize(message)});
        }
        return true;
    }
}


