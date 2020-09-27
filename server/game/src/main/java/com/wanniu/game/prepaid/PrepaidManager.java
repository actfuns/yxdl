package com.wanniu.game.prepaid;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.activity.ActivityManager;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.ModuleManager;
import com.wanniu.game.common.Utils;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PayCO;
import com.wanniu.game.data.SuperPackageCO;
import com.wanniu.game.data.ext.DailyPayExt;
import com.wanniu.game.data.ext.FirstPayExt;
import com.wanniu.game.data.ext.TotalPayExt;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.BILogService;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.ActivityDataPO;
import com.wanniu.game.poes.BagsPO;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.SevenGoalPO;
import com.wanniu.game.prepaid.po.PrepaidPO;
import com.wanniu.game.prepaid.po.PrepaidRecord;
import com.wanniu.game.sevengoal.SevenGoalManager;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import pomelo.Common;
import pomelo.area.ActivityFavorHandler;
import pomelo.area.PrepaidHandler;


public class PrepaidManager
        extends ModuleManager {
    public final String playerId;
    public PrepaidPO po;

    public PrepaidManager(String playerId) {
        this.playerId = playerId;
        this.po = loadPO(playerId);
    }

    private PrepaidPO loadPO(String playerId2) {
        PrepaidPO po = (PrepaidPO) PlayerPOManager.findPO(ConstsTR.prepaidNewTR, this.playerId, PrepaidPO.class);
        if (po == null) {
            po = new PrepaidPO();
            PlayerPOManager.put(ConstsTR.prepaidNewTR, this.playerId, (GEntity) po);
        }
        return po;
    }


    public void onCharge(int productId, boolean isCard, boolean isSuperPackage, boolean logBI) {
        int oldPayMoney = this.po.total_charge;

        if (this.po.dailyDate != null && !DateUtils.isSameDay(new Date(), this.po.dailyDate)) {
            this.po.dailyPayRmb = 0;
        }

        if (!isSuperPackage) {
            if (isCard) {
                chargeCard(productId, logBI);
            } else {
                chargeDiamond(productId, logBI);
            }
        } else {
            chargeDiamondOfSuperPackage(productId, logBI);
        }

        this.po.dailyDate = new Date();
        int payRmb = this.po.total_charge - oldPayMoney;
        this.po.dailyPayRmb += payRmb;


        if (oldPayMoney == 0) {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
            List<FirstPayExt> props = GameData.findFirstPays(t -> (t.Job == baseData.pro));
            MailSysData d = new MailSysData("Pay_FirstPay");
            ArrayList<MailData.Attachment> list = new ArrayList<>();
            for (DailyPayExt.AwardInfo a : ((FirstPayExt) props.get(0)).awards) {
                MailData.Attachment attachment = new MailData.Attachment();
                attachment.itemCode = a.itemCode;
                attachment.itemNum = a.itemNum;
                attachment.isBind = 1;
                list.add(attachment);
            }
            d.attachments = list;
            MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData) d, Const.GOODS_CHANGE_TYPE.FIRST_CHARGE);
        }


        for (TotalPayExt i : GameData.TotalPays.values()) {
            if (oldPayMoney < i.target && this.po.total_charge >= i.target) {
                MailSysData d = new MailSysData("Pay_TotalPay");
                ArrayList<MailData.Attachment> list = new ArrayList<>();
                for (DailyPayExt.AwardInfo a : i.awards) {
                    MailData.Attachment attachment = new MailData.Attachment();
                    attachment.itemCode = a.itemCode;
                    attachment.itemNum = a.itemNum;
                    attachment.isBind = 1;
                    list.add(attachment);
                }
                d.attachments = list;
                MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData) d, Const.GOODS_CHANGE_TYPE.CUMULATIVE_CHARGE);
            }
        }

        if (getFirstPayStatus() == 2) {
            WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
            if (wNPlayer != null) {
                wNPlayer.updateSuperScript(Const.SUPERSCRIPT_TYPE.FIRSTPAY_GIFT, 0);
            }
        }


        if (isSuperPackage) {
            ActivityDataPO activityDataPO = (ActivityDataPO) PlayerPOManager.findPO(ConstsTR.activityTR, this.playerId, ActivityDataPO.class);
            if (!activityDataPO.superPackageRecorder.containsKey(Integer.valueOf(productId))) {
                ActivityManager.RewardRecord rewardRecord = new ActivityManager.RewardRecord();
                rewardRecord.awardId = productId;
                rewardRecord.awardTime = new Date();
                activityDataPO.superPackageRecorder.put(Integer.valueOf(productId), rewardRecord);
                MailSysData d = new MailSysData("SuperPackage_Item");
                ArrayList<MailData.Attachment> list = new ArrayList<>();
                SuperPackageCO superPackageCO = (SuperPackageCO) GameData.SuperPackages.get(Integer.valueOf(productId));
                MailData.Attachment attachment = new MailData.Attachment();
                attachment.itemCode = superPackageCO.packageCode;
                attachment.itemNum = superPackageCO.packageNum;
                attachment.isBind = 1;
                list.add(attachment);
                d.attachments = list;
                MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData) d, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE);

                WNPlayer wNPlayer = PlayerUtil.getOnlinePlayer(this.playerId);
                if (wNPlayer != null) {
                    ActivityFavorHandler.SuperPackageBuyPush.Builder spbpBuilder = ActivityFavorHandler.SuperPackageBuyPush.newBuilder();
                    spbpBuilder.setS2CCode(200);
                    spbpBuilder.setPackageId(productId);
                }
            }
        }


        RechargeActivityService.getInstance().onPayEvent(this.playerId, this.po.dailyPayRmb, payRmb);


        WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
        if (player != null) {

            player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.PAY_COUNT, new Object[]{Integer.valueOf(this.po.dailyPayRmb / 100)});
        } else {

            SevenGoalPO sevenGoalPO = (SevenGoalPO) PlayerPOManager.findPO(ConstsTR.SevenGoal, this.playerId, SevenGoalPO.class);
            sevenGoalPO.processPayCount();
        }
    }


    public void onCharge(int productId, boolean isCard) {
        onCharge(productId, isCard, false, false);
    }


    public int getFirstPayStatus() {
        if (this.po.total_charge == 0) {
            return 0;
        }
        boolean totalFinished = true;
        for (TotalPayExt i : GameData.TotalPays.values()) {
            if (this.po.total_charge < i.target) {
                totalFinished = false;
                break;
            }
        }
        return totalFinished ? 2 : 1;
    }


    private void chargeCard(int productId, boolean logBI) {
        CardCO cardProp = (CardCO) GameData.Cards.get(Integer.valueOf(productId));
        if (cardProp == null)
            return;
        int amount = cardProp.payMoneyAmount;
        this.po.total_charge += amount;
        this.po.dailyChargeDiamond += cardProp.payDiamond;
        PrepaidRecord record = new PrepaidRecord();
        record.money = amount;
        record.date = new Date();
        record.isCard = true;

        this.po.chargeRecord.add(record);
        Calendar c = Calendar.getInstance();
        c.add(5, cardProp.lastTime);
        WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
        if (player != null) {
            player.baseDataManager.modifyVip(cardProp.iD, cardProp.lastTime);
            player.moneyManager.addDiamond(cardProp.payDiamond, Const.GOODS_CHANGE_TYPE.VIPBUY);
            player.pushDynamicData(Utils.ofMap(new Object[]{"vip", Integer.valueOf(player.player.vip)}));

            if (cardProp.iD == Const.VipType.forever.value) {
                player.bag.addBagGridCount(cardProp.prv6);
                player.wareHouse.addBagGridCount(cardProp.prv5);
            }
            player.onPay();

            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), cardProp.payDiamond, cardProp.payMoneyAmount, cardProp.name);
            }
        } else {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
            modifyVip(cardProp.iD, cardProp.lastTime, baseData);
            int before = baseData.diamond;
            baseData.diamond += cardProp.payDiamond;
            int after = baseData.diamond;


            if (cardProp.iD == Const.VipType.forever.value) {
                BagsPO bagsPO = (BagsPO) PlayerPOManager.findPO(ConstsTR.bagTR, this.playerId, BagsPO.class);
                bagsPO.bagData.bagGridCount += cardProp.prv6;
                bagsPO.wareHouseData.bagGridCount += cardProp.prv5;
            }
            PlayerPOManager.sync(this.playerId);

            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(baseData, cardProp.payDiamond, cardProp.payMoneyAmount, cardProp.name);
            }


            LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, cardProp.payDiamond, after, Const.GOODS_CHANGE_TYPE.VIPBUY.value);
        }
        if (StringUtil.isNotEmpty(cardProp.prv9)) {
            MailSysData d = new MailSysData("Pay_title");
            ArrayList<MailData.Attachment> list = new ArrayList<>();
            MailData.Attachment attachment = new MailData.Attachment();
            attachment.itemCode = cardProp.prv9;
            attachment.itemNum = 1;
            list.add(attachment);
            d.attachments = list;
            d.replace = new HashMap<>();
            d.replace.put("card", cardProp.name);
            MailUtil.getInstance().sendMailToOnePlayer(this.playerId, (MailData) d, Const.GOODS_CHANGE_TYPE.VIPBUY);
        }


        if (this.po.firstCharge == 0) {
            this.po.firstCharge = amount;
        }


        if (player != null) {
            player.vipManager.updateSuperScript();
        }
    }


    private void chargeDiamond(int productId, boolean logBI) {
        PayCO payProp = (PayCO) GameData.Pays.get(Integer.valueOf(productId));
        if (payProp == null)
            return;
        int amount = payProp.payMoneyAmount;
        this.po.total_charge += amount;
        this.po.dailyChargeDiamond += payProp.payDiamond;
        PrepaidRecord record = new PrepaidRecord();
        record.money = amount;
        record.date = new Date();
        this.po.chargeRecord.add(record);
        int chargeDiamond = payProp.payDiamond;

        if (!this.po.first_buy_record.containsKey(Integer.valueOf(productId))) {
            this.po.first_buy_record.put(Integer.valueOf(productId), Integer.valueOf(productId));
            chargeDiamond += payProp.firstDiamond;
        } else {
            chargeDiamond += payProp.nonFirstDiamond;
        }
        WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
        if (player != null) {
            player.moneyManager.addDiamond(chargeDiamond, Const.GOODS_CHANGE_TYPE.CHARGE);
            player.onPay();
            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), chargeDiamond, payProp.payMoneyAmount, payProp.packageName);
            }
        } else {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
            int before = baseData.diamond;
            baseData.diamond += chargeDiamond;
            int after = baseData.diamond;
            PlayerPOManager.sync(this.playerId);

            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(baseData, chargeDiamond, payProp.payMoneyAmount, payProp.packageName);
            }


            LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, chargeDiamond, after, Const.GOODS_CHANGE_TYPE.CHARGE.value);
        }
        if (this.po.firstCharge == 0) {
            this.po.firstCharge = payProp.payMoneyAmount;
        }
    }


    private void chargeDiamondOfSuperPackage(int productId, boolean logBI) {
        SuperPackageCO superPackageCO = (SuperPackageCO) GameData.SuperPackages.get(Integer.valueOf(productId));
        if (superPackageCO == null)
            return;
        int amount = superPackageCO.packagePrice;
        this.po.total_charge += amount;
        this.po.dailyChargeDiamond += superPackageCO.diamondNum;
        PrepaidRecord record = new PrepaidRecord();
        record.money = amount;
        record.date = new Date();
        this.po.chargeRecord.add(record);
        int chargeDiamond = superPackageCO.diamondNum;

        WNPlayer player = PlayerUtil.getOnlinePlayer(this.playerId);
        if (player != null) {
            player.moneyManager.addDiamond(chargeDiamond, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE);
            player.onPay();
            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(player.getPlayer(), chargeDiamond, superPackageCO.packagePrice, superPackageCO.packageName);
            }
        } else {
            PlayerPO baseData = (PlayerPO) PlayerPOManager.findPO(ConstsTR.playerTR, this.playerId, PlayerPO.class);
            int before = baseData.diamond;
            baseData.diamond += chargeDiamond;
            int after = baseData.diamond;
            PlayerPOManager.sync(this.playerId);

            if (logBI) {
                BILogService.getInstance().ansycReportRechargeSuccess(baseData, chargeDiamond, superPackageCO.packagePrice, superPackageCO.packageName);
            }


            LogReportService.getInstance().ansycReportMoneyFlow(baseData, VirtualItemType.DIAMOND, before, 1, chargeDiamond, after, Const.GOODS_CHANGE_TYPE.SUPER_PACKAGE.value);
        }
        if (this.po.firstCharge == 0) {
            this.po.firstCharge = superPackageCO.packagePrice;
        }
    }

    public void onResume(int consumeDiamond) {
        this.po.total_consume += consumeDiamond;
    }


    public void modifyVip(int vip, int lastTime, PlayerPO baseData) {
        Const.VipType vt = Const.VipType.getE(vip);


        if ((baseData.vip == Const.VipType.month.value || baseData.vip == Const.VipType.sb_double.value) &&
                baseData.vipEndTime.before(Calendar.getInstance().getTime())) {
            baseData.vipEndTime = null;
            if (baseData.vip == Const.VipType.month.value) {
                baseData.vip = Const.VipType.none.value;
            } else {
                baseData.vip = Const.VipType.forever.value;
            }
        }

        if (vt == null)
            return;
        if (vt == Const.VipType.month) {
            if (baseData.vip == Const.VipType.forever.value || baseData.vip == Const.VipType.sb_double.value) {
                baseData.vip = Const.VipType.sb_double.value;
            } else {
                baseData.vip = vt.value;
            }
        }
        if (vt == Const.VipType.forever) {
            if (baseData.vip == Const.VipType.month.value || baseData.vip == Const.VipType.sb_double.value) {
                baseData.vip = Const.VipType.sb_double.value;
            } else {
                baseData.vip = vt.value;
            }
        }
        if (vt == Const.VipType.month) {
            CardCO cardProp = (CardCO) GameData.Cards.get(Integer.valueOf(vip));
            Calendar c = Calendar.getInstance();
            if (baseData.vipEndTime != null && baseData.vipEndTime.after(Calendar.getInstance().getTime())) {
                c.setTime(baseData.vipEndTime);
                c.add(5, cardProp.lastTime);
                baseData.vipEndTime = c.getTime();
            } else {
                c.add(5, cardProp.lastTime);
                baseData.vipEndTime = c.getTime();
            }
        }
    }

    public int getDailyCharge() {
        return this.po.dailyChargeDiamond;
    }

    public int getPayedTimes() {
        return this.po.chargeRecord.size();
    }


    public boolean isEachPayMoneyEnough(int times, int money) {
        return false;
    }


    public void onPrepaidChargeByMoney(int money) {
        onCharge(((PayCO) GameData.Pays.values().stream().filter(v -> (v.nonFirstDiamond == money)).findFirst().get()).iD, false);
    }

    public Date getDailyDate() {
        return this.po.dailyDate;
    }


    public void onPlayerEvent(Const.PlayerEventType eventType) {
    }


    public Const.ManagerType getManagerType() {
        return Const.ManagerType.PREPAID;
    }

    public List<PrepaidHandler.FeeItem> getPrepaidList() {
        List<PrepaidHandler.FeeItem> list = new ArrayList<>();
        for (PayCO prop : GameData.Pays.values()) {
            PrepaidHandler.FeeItem.Builder fi = PrepaidHandler.FeeItem.newBuilder();
            fi.setId(prop.iD);
            fi.setPackageIcon(prop.packageIcon);
            fi.setAppProductId(prop.appProductId);
            fi.setPackageName(prop.packageName);
            fi.setPackageDesc(prop.packageDesc);
            fi.setPackageDescFirst(prop.packageDescFirst);
            fi.setPayMoneyType(prop.payMoneyType);
            fi.setPayMoneyAmount(prop.payMoneyAmount);
            fi.setPayDiamond(prop.payDiamond);
            fi.setFirstDiamond(prop.firstDiamond);
            fi.setNonFirstDiamond(prop.nonFirstDiamond);
            fi.setPayCashFirst(prop.payCashFirst);
            fi.setPayTag(prop.payTag);
            if (this.po.first_buy_record.containsKey(Integer.valueOf(prop.iD))) {
                fi.setVirgin(0);
            } else {
                fi.setVirgin(1);
            }
            list.add(fi.build());
        }
        return list;
    }


    public PrepaidHandler.PrepaidFirstResponse getPrepaidFirstAward() {
        PrepaidHandler.PrepaidFirstResponse.Builder res = PrepaidHandler.PrepaidFirstResponse.newBuilder();
        res.setS2CCode(200);
        res.setTotalPay(this.po.total_charge);
        for (TotalPayExt p : GameData.TotalPays.values()) {
            PrepaidHandler.PrepaidFirstItem.Builder item = PrepaidHandler.PrepaidFirstItem.newBuilder();
            item.setIsFinish((this.po.total_charge >= p.target) ? 1 : 0);
            item.setPayMoney(p.target);
            for (DailyPayExt.AwardInfo a : p.awards) {
                Common.KeyValueStruct.Builder i = Common.KeyValueStruct.newBuilder();
                i.setKey(a.itemCode);
                i.setValue(String.valueOf(a.itemNum));
                item.addItems(i);
            }
            res.addAwards(item);
        }
        return res.build();
    }


    public void onChargeCardByOpen(Object type) {
        onCharge(((CardCO) GameData.Cards.values().stream().filter(v -> v.name.equals(type)).findFirst().get()).iD, true);
    }

    public int getTodayPayValue() {
        if (this.po.dailyDate != null && !DateUtils.isSameDay(new Date(), this.po.dailyDate)) {
            return 0;
        }
        return this.po.dailyPayRmb;
    }
}


