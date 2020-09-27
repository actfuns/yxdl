package com.wanniu.game.money;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.activity.RechargeActivityService;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.HackerException;
import com.wanniu.game.daoyou.AllyConfiguration;
import com.wanniu.game.daoyou.DaoYouService;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.PlayerPO;
import com.wanniu.game.poes.XianYuanPO;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.sevengoal.SevenGoalManager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pomelo.Common;


public class MoneyManager {
    private final WNPlayer player;
    public static int today_max_diamond_threshold = 100000;
    public static int today_max_kicket_threshold = 20000;
    public static int today_max_gold_threshold = 200000000;

    public MoneyManager(WNPlayer player) {
        this.player = player;
    }


    private PlayerPO getBaseData() {
        return this.player.player;
    }


    public boolean enoughGold(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的银两是否足够时参数小于0.");
        }
        return ((getBaseData()).gold >= num);
    }


    public boolean costGold(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return true;
        }
        if (!enoughGold(num)) {
            return false;
        }
        int before = (getBaseData()).gold;
        (getBaseData()).gold -= num;
        int after = (getBaseData()).gold;
        Out.info(new Object[]{"cost gold. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GOLD, before, 2, num, after, origin.value);


        pushDynamicDataByGold(origin);

        updateScript();
        return true;
    }


    public int costGoldByPercent(int percent, Const.GOODS_CHANGE_TYPE origin) {
        if (percent <= 0 || (getBaseData()).gold <= 0) {
            return 0;
        }
        float fc = 1.0F * (getBaseData()).gold / 10000.0F * percent;
        int cost = Math.round(fc);
        cost = (cost <= 0) ? 1 : cost;
        boolean success = costGold(cost, origin);
        if (!success) {
            Out.warn(new Object[]{"cost gold not enough并发!!!!!. id=", this.player.getId(), ",name=", this.player.getName(), "origin=", Integer.valueOf(origin.value), ",cost:", Integer.valueOf(cost)});
        }
        return success ? cost : 0;
    }


    public int costGoldOnPk(int goldNum, Const.GOODS_CHANGE_TYPE origin) {
        if (goldNum <= 0 || (getBaseData()).gold <= 0) {
            return 0;
        }

        boolean success = costGold(goldNum, origin);
        if (!success) {
            Out.warn(new Object[]{"cost gold not enough并发!!!!!. id=", this.player.getId(), ",name=", this.player.getName(), "origin=", Integer.valueOf(origin.value), ",cost:", Integer.valueOf(goldNum)});
        }
        return success ? goldNum : 0;
    }


    public void addGold(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加银两时参数小于0.");
        }
        int before = (getBaseData()).gold;

        if (0L + (getBaseData()).gold + num > 2147483647L) {
            (getBaseData()).gold = Integer.MAX_VALUE;
        } else {
            (getBaseData()).gold += num;
        }
        int after = (getBaseData()).gold;


        if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
            Out.info(new Object[]{"add gold. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
            LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.GOLD, before, 1, num, after, origin.value);
        }


        pushDynamicDataByGold(origin);
        this.player.achievementManager.onGetGold(num);
        if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
            updateScript();
        }


        (getBaseData()).todayGold += num;
        if ((getBaseData()).todayGold >= today_max_gold_threshold) {
            Out.warn(new Object[]{"今日银两收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayGold:", Integer.valueOf((getBaseData()).todayGold), ",max:", Integer.valueOf(today_max_gold_threshold)});
            LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.GOLD, (getBaseData()).todayGold, today_max_gold_threshold);
        }
    }


    public int getGold() {
        return (getBaseData()).gold;
    }


    private void pushDynamicDataByGold(Const.GOODS_CHANGE_TYPE origin) {
        this.player.pushDynamicData("gold", Integer.valueOf((getBaseData()).gold), origin);
    }


    private void updateScript() {
        this.player.equipManager.updateStrengthScript(null);
        this.player.equipManager.updateMakeScript(null);

        this.player.guildManager.pushRedPoint();
    }


    public boolean enoughDiamond(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的充值元宝是否足够时参数小于0.");
        }
        return ((getBaseData()).diamond >= num);
    }


    public boolean costDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
        return costDiamond(num, origin, null);
    }


    public boolean costDiamond(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
        if (num == 0) {
            return true;
        }
        if (!enoughDiamond(num)) {
            return false;
        }
        int before = (getBaseData()).diamond;
        (getBaseData()).diamond -= num;
        int after = (getBaseData()).diamond;
        Out.info(new Object[]{"cost diamond. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.DIAMOND, before, 2, num, after, origin.value);


        if (!Const.GOODS_CHANGE_TYPE.AUCTION.equals(origin) && !Const.GOODS_CHANGE_TYPE.RedPacket.equals(origin)) {
            (getBaseData()).totalCostDiamond += num;
            RechargeActivityService.getInstance().onConsumeEvent(this.player.getId(), num);


            if (num > AllyConfiguration.getInstance().getConfigI("MinCostDiamond")) {
                int value = num * AllyConfiguration.getInstance().getConfigI("FeeBackRate") / 100;
                DaoYouService.getInstance().calDaoYouRebate(this.player, value);
            }
        }

        this.player.pushDynamicData("diamond", Integer.valueOf((getBaseData()).diamond), origin, itemChange);

        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_COUNT, new Object[0]);
        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_OR_BINDDIAMOND_COUNT, new Object[]{Integer.valueOf(num)});
        return true;
    }


    public void addDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加充值元宝时参数小于0.");
        }
        int before = (getBaseData()).diamond;

        if (0L + (getBaseData()).diamond + num > 2147483647L) {
            (getBaseData()).diamond = Integer.MAX_VALUE;
        } else {
            (getBaseData()).diamond += num;
        }
        int after = (getBaseData()).diamond;
        Out.info(new Object[]{"add diamond. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.DIAMOND, before, 1, num, after, origin.value);

        this.player.pushDynamicData("diamond", Integer.valueOf((getBaseData()).diamond), origin);


        (getBaseData()).todayDiamond += num;
        if ((getBaseData()).todayDiamond >= today_max_diamond_threshold) {
            Out.warn(new Object[]{"今日充值元宝收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayDiamond:", Integer.valueOf((getBaseData()).todayDiamond), ",max:", Integer.valueOf(today_max_diamond_threshold)});
            LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.DIAMOND, (getBaseData()).todayDiamond, today_max_diamond_threshold);
        }
    }


    public int getDiamond() {
        return (getBaseData()).diamond;
    }


    public boolean enoughTicket(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的绑定元宝是否足够时参数小于0.");
        }
        return ((getBaseData()).ticket >= num);
    }


    public boolean costTicket(int num, Const.GOODS_CHANGE_TYPE origin) {
        return costTicket(num, origin, null);
    }


    public boolean costTicket(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
        if (num == 0) {
            return true;
        }
        if (!enoughTicket(num)) {
            return false;
        }
        int before = (getBaseData()).ticket;
        (getBaseData()).ticket -= num;
        int after = (getBaseData()).ticket;
        Out.info(new Object[]{"cost ticket. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CASH, before, 2, num, after, origin.value);

        this.player.pushDynamicData("ticket", Integer.valueOf((getBaseData()).ticket), origin, itemChange);
        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.COST_DIAMOND_OR_BINDDIAMOND_COUNT, new Object[]{Integer.valueOf(num)});
        return true;
    }


    public void addTicket(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加绑定元宝时参数小于0.");
        }
        int before = (getBaseData()).ticket;

        if (0L + (getBaseData()).ticket + num > 2147483647L) {
            (getBaseData()).ticket = Integer.MAX_VALUE;
        } else {
            (getBaseData()).ticket += num;
        }
        int after = (getBaseData()).ticket;
        Out.info(new Object[]{"add ticket. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CASH, before, 1, num, after, origin.value);

        if (origin != Const.GOODS_CHANGE_TYPE.monsterdrop) {
            this.player.customTip(Const.CUSTOMTIPTYPE.TICKET, num);
        }
        this.player.pushDynamicData("ticket", Integer.valueOf((getBaseData()).ticket), origin);


        (getBaseData()).todayTicket += num;
        if ((getBaseData()).todayTicket >= today_max_kicket_threshold) {
            Out.warn(new Object[]{"今日绑定元宝收益超过预期值,playerId:", this.player.getId(), ",name:", this.player.getName(), ",todayTicket:", Integer.valueOf((getBaseData()).todayTicket), ",max:", Integer.valueOf(today_max_kicket_threshold)});
            LogReportService.getInstance().ansycReportMoneyMonitor(this.player, VirtualItemType.CASH, (getBaseData()).todayTicket, today_max_kicket_threshold);
        }
    }


    public int getTicket() {
        return (getBaseData()).ticket;
    }


    public boolean enoughTicketAndDiamond(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的（绑定元宝+充值元宝）总和是否足够时参数小于0.");
        }
        return (0L + (getBaseData()).ticket + (getBaseData()).diamond >= num);
    }


    public CostResult costTicketAndDiamond(int num, Const.GOODS_CHANGE_TYPE origin) {
        return costTicketAndDiamond(num, origin, null);
    }


    public CostResult costTicketAndDiamond(int num, Const.GOODS_CHANGE_TYPE origin, List<Common.KeyValueStruct> itemChange) {
        if (num == 0) {
            return new CostResult(true);
        }

        if (costTicket(num, origin, itemChange)) {
            return (new CostResult(true)).addValue(VirtualItemType.CASH, num);
        }


        if (!enoughTicketAndDiamond(num)) {
            return new CostResult(false);
        }


        int ticket = getTicket();
        if (ticket > 0) {
            costTicket(ticket, origin, itemChange);
        }

        int diamond = num - ticket;
        costDiamond(diamond, origin, itemChange);

        return (new CostResult(true)).addValue(VirtualItemType.CASH, ticket).addValue(VirtualItemType.DIAMOND, diamond);
    }


    public void refreshNewDay() {
        Out.info(new Object[]{"每日监控收入值清零，roleId=", this.player.getId(), ",todayDiamond=", Integer.valueOf((getBaseData()).todayDiamond), ",todayTicket=", Integer.valueOf((getBaseData()).todayTicket), ",todayGold=", Integer.valueOf((getBaseData()).todayGold)});
        (getBaseData()).todayDiamond = 0;
        (getBaseData()).todayTicket = 0;
        (getBaseData()).todayGold = 0;
    }


    public void addConsumePoint(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加消费积分时参数小于0.");
        }

        int before = (getBaseData()).consumePoint;

        if (0L + (getBaseData()).consumePoint + num > 2147483647L) {
            (getBaseData()).consumePoint = Integer.MAX_VALUE;
        } else {
            (getBaseData()).consumePoint += num;
        }
        int after = (getBaseData()).consumePoint;
        Out.info(new Object[]{"add consumePoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CONSUMEPOINT, before, 1, num, after, origin.value);

        pushDynamicDataByConsumePoint(origin);
    }


    public boolean enoughConsumePoint(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的消费积分是否足够时参数小于0.");
        }
        return (getConsumePoint() >= num);
    }


    public boolean costConsumePoint(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return false;
        }
        if (!enoughConsumePoint(num)) {
            return false;
        }

        int before = (getBaseData()).consumePoint;
        (getBaseData()).consumePoint -= num;
        int after = (getBaseData()).consumePoint;
        Out.info(new Object[]{"cost consumePoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.CONSUMEPOINT, before, 2, num, after, origin.value);


        pushDynamicDataByConsumePoint(origin);
        return true;
    }

    private void pushDynamicDataByConsumePoint(Const.GOODS_CHANGE_TYPE origin) {
        this.player.pushDynamicData("consumePoint", Integer.valueOf((getBaseData()).consumePoint));
    }


    public int getConsumePoint() {
        return (getBaseData()).consumePoint;
    }


    private XianYuanPO getXianYuanPo() {
        return this.player.allBlobData.xianYuan;
    }


    public void addXianYuan(int num, Const.GOODS_CHANGE_TYPE origin) {
        addXianYuan(num, origin, -1);
    }

    public void addXianYuan(int num, Const.GOODS_CHANGE_TYPE origin, int from) {
        if (num == 0) {
            return;
        }
        if (num < 0) {
            throw new HackerException("增加仙缘时参数小于0.");
        }

        XianYuanPO po = getXianYuanPo();

        int before = po.xianYuanNum;

        if (0L + po.xianYuanNum + num > 2147483647L) {
            po.xianYuanNum = Integer.MAX_VALUE;
        } else {
            po.xianYuanNum += num;
        }
        int after = po.xianYuanNum;

        Out.info(new Object[]{"add xianyuan. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value), ",from=", Integer.valueOf(from)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.FATE, before, 1, num, after, origin.value);


        po.sumXianYuan += num;
        po.updateTime = new Date();

        this.player.rankManager.onEvent(RankType.XIANYUAN, new Object[]{Integer.valueOf(po.sumXianYuan)});


        this.player.pushDynamicData("fate", Integer.valueOf(num));

        this.player.achievementManager.onXianyuanChange(num);

        this.player.sevenGoalManager.processGoal(SevenGoalManager.SevenGoalTaskType.XIANYUAN_TO, new Object[]{Integer.valueOf(num)});
    }


    public void addXianYuan(int num, int from) {
        addXianYuan(num, Const.GOODS_CHANGE_TYPE.def, from);

        XianYuanPO xianYuanPo = getXianYuanPo();
        if (xianYuanPo.reviceNumbers == null) {
            xianYuanPo.reviceNumbers = new HashMap<>();
        }
        xianYuanPo.reviceNumbers.compute(Integer.valueOf(from), (k, v) -> Integer.valueOf((v == null) ? num : (v.intValue() + num)));
    }


    public boolean enoughXianYuan(int num) {
        if (num < 0) {
            throw new HackerException("判定玩家身上的仙缘值是否足够时参数小于0.");
        }
        return (getXianYuan() >= num);
    }

    public int getXianYuan() {
        return (getXianYuanPo()).xianYuanNum;
    }


    public boolean costXianYuan(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) {
            return false;
        }
        if (!enoughXianYuan(num)) {
            return false;
        }
        XianYuanPO po = getXianYuanPo();
        int before = po.xianYuanNum;
        po.xianYuanNum -= num;
        int after = po.xianYuanNum;
        Out.info(new Object[]{"cost xianyuan. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.FATE, before, 2, num, after, origin.value);

        return true;
    }
}


