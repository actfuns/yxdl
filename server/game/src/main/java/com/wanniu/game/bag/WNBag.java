package com.wanniu.game.bag;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.RandomUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.CurrencyData;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.DItemBase;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.equip.NormalEquip;
import com.wanniu.game.item.ItemConfig;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.po.DetailItemNum;
import com.wanniu.game.item.po.PlayerItemPO;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.BagsPO;
import com.wanniu.game.task.TaskEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import pomelo.area.BagHandler;
import pomelo.item.ItemOuterClass;
import pomelo.player.PlayerOuterClass;


public class WNBag {
    private WNPlayer player;
    public BagsPO bags;
    public BagPO bagPO;
    public Map<Integer, NormalItem> bagGrids;
    public int usedGridCount;
    private int bagTotalCount;
    private Const.BAG_TYPE type;

    public static class TradeMessageItemData {
        public String name;
        public int qt;
        public int num;
    }

    private ItemConfig itemManager = ItemConfig.getInstance();
    public long bagGridPackUpTime = 0L;


    protected WNBag() {
    }


    public WNBag(WNPlayer player, Const.BAG_TYPE type, BagPO bagPO, BagsPO bags) {
        this.player = player;
        this.type = type;
        this.bags = bags;

        _init(bagPO);
    }

    private void _init(BagPO bagPO) {
        this.bagPO = bagPO;
        this.bagGrids = new ConcurrentHashMap<>();
        this.usedGridCount = 0;


        if (GWorld.DEBUG) {
            Iterator<Integer> iter = bagPO.bagGrids.keySet().iterator();
            while (iter.hasNext()) {
                int index = ((Integer) iter.next()).intValue();
                if (ItemConfig.getInstance().getItemProp(((PlayerItemPO) bagPO.bagGrids.get(Integer.valueOf(index))).code) == null) {
                    iter.remove();
                }
            }
        }
        for (Integer index : bagPO.bagGrids.keySet()) {
            NormalItem item = ItemUtil.createItemByDbOpts(bagPO.bagGrids.get(index));
            if (item != null) {
                this.bagGrids.put(index, item);
                this.usedGridCount++;
            }
        }
        this.bagTotalCount = BagUtil.getTotalCount(this.type);
    }


    public NormalItem getGridItemCode(int gridNndex) {
        return this.bagGrids.get(Integer.valueOf(gridNndex));
    }

    public void setBagGrid(int gridIndex, NormalItem item) {
        this.bagGrids.put(Integer.valueOf(gridIndex), item);
    }

    public void addBagGrid(int gridIndex, NormalItem item) {
        this.bagGrids.put(Integer.valueOf(gridIndex), item);
    }

    public NormalItem getItem(int gridIndex) {
        return this.bagGrids.get(Integer.valueOf(gridIndex));
    }


    public NormalItem randomGetItem() {
        List<Integer> emptyIndex = new ArrayList<>();

        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && !item.isBinding() &&
                    GameData.PKLostBagItemTypes.containsKey(item.itemCode())) {
                emptyIndex.add(Integer.valueOf(i));
            }
        }

        if (emptyIndex.size() > 0) {
            int emptyPos = RandomUtil.getInt(0, emptyIndex.size() - 1);
            int randomPos = ((Integer) emptyIndex.get(emptyPos)).intValue();
            int randGoldPercent = RandomUtil.getInt(GlobalConfig.PK_DropGoldMin, GlobalConfig.PK_DropGoldMax);
            return discardItemByPosPerent(randomPos, randGoldPercent, Const.GOODS_CHANGE_TYPE.hitUser);
        }
        return null;
    }


    public Object[] randomGetItem(Set<String> codes, int maxReduceCount) {
        if (this.bagPO.bagGridCount < 1) {
            return null;
        }
        Object[] obj = null;
        List<NormalItem> l = getNormalItemOrder(codes, this.bagPO.bagGridCount);
        if (l != null && !l.isEmpty()) {
            NormalItem dpItem = l.get(0);
            int groupCount = dpItem.itemDb.groupCount;
            int min = Math.min(maxReduceCount, groupCount);
            int trueCount = RandomUtil.getInt(min);
            if (discardItem(dpItem.itemDb.code, trueCount, Const.GOODS_CHANGE_TYPE.hitUser)) {
                obj = new Object[2];
                obj[0] = dpItem.itemDb.code;
                obj[1] = Integer.valueOf(trueCount);
            }
        }
        return obj;
    }

    private List<NormalItem> getNormalItemOrder(Set<String> codes, int count) {
        List<NormalItem> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && codes.contains(item.prop.code)) {
                list.add(item);
            }
        }
        if (list.size() > 1) {
            Collections.shuffle(list);
        }
        return list;
    }

    public PlayerOuterClass.Store toJson4Payload() {
        PlayerOuterClass.Store.Builder data = PlayerOuterClass.Store.newBuilder();
        data.addAllBagGrids(getGrids4PayLoad());
        data.setBagGridCount(this.bagPO.bagGridCount);
        data.setBagTotalCount(this.bagTotalCount);
        data.setType(this.type.getValue());
        data.setGridPrice(BagUtil.getGridPrice(this.type));
        return data.build();
    }

    public void _addUsedGridCount(int num) {
        if (num != 0) {
            this.usedGridCount += num;
            _gridNumChangePush();
        }
    }

    public void _gridNumChangePush() {
        _gridNumChangePush(false);
    }


    public void _gridNumChangePush(boolean force) {
        if (this.type == Const.BAG_TYPE.BAG) {
            int emptyNum = emptyGridNum();
            if (emptyNum <= 3 || force) {
                this.player.refreshPlayerRemainBagCountData(emptyNum);
            }
        }
    }


    public boolean openGrid(int num) {
        if (num + this.bagPO.bagGridCount > this.bagTotalCount) {
            return false;
        }


        int oldGridCount = this.bagPO.bagGridCount;
        this.bagPO.bagGridCount += num;
        List<Integer> list_gridIndexs = new ArrayList<>();
        for (int i = oldGridCount + 1; i <= this.bagPO.bagGridCount; i++) {
            list_gridIndexs.add(Integer.valueOf(i));
        }

        _updateAndPush(list_gridIndexs, false);
        if (this.type == Const.BAG_TYPE.BAG) {
            int emptyNum = emptyGridNum();
            this.player.refreshPlayerRemainBagCountData(emptyNum);
        }
        return true;
    }


    public void onEvent(TaskEvent event) {
        Out.debug(new Object[]{getClass(), "Bag onEvent ", Integer.valueOf(event.type)});
        if (event.type == Const.EventType.consumeItem.getValue()) {
            String objId = (String) event.params[0];
            int objNum = ((Integer) event.params[1]).intValue();
            if (objId.equals("diamond")) {
                this.player.moneyManager.costDiamond(objNum, Const.GOODS_CHANGE_TYPE.consume);
            } else {

                itemUseById(objId, objNum);
            }
        }
    }


    public List<ItemOuterClass.Grid> getGrids4PayLoad() {
        List<ItemOuterClass.Grid> data = new ArrayList<>();
        for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {
                data.add(getGrid4PayLoad(index).build());
            }
        }
        return data;
    }

    public ItemOuterClass.Grid.Builder getGrid4PayLoad(int index) {
        ItemOuterClass.Grid.Builder grid = ItemOuterClass.Grid.newBuilder();
        grid.setGridIndex(index);
        NormalItem item = getItem(index);
        if (item != null) {
            grid.setItem(item.toJSON4GridPayload());
        }
        return grid;
    }


    public List<ItemOuterClass.ItemDetail> getAllEquipDetails4PayLoad() {
        List<ItemOuterClass.ItemDetail> data = new ArrayList<>();
        for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {
                data.add(item.getItemDetail(this.player.playerBasePO).build());
            }
        }
        return data;
    }


    public int findItemNumByCode(String code) {
        int num = 0;
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code)) {
                num += item.itemDb.groupCount;
            }
        }
        return num;
    }


    public DetailItemNum findDetailItemNumByCode(String code) {
        DetailItemNum data = new DetailItemNum();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code)) {
                data.totalNum += item.itemDb.groupCount;
                if (item.isBinding()) {
                    data.bindNum += item.itemDb.groupCount;
                } else {
                    data.unBindNum += item.itemDb.groupCount;
                }
            }
        }
        return data;
    }


    public List<NormalItem> findGridsByCode(String code, boolean bind) {
        List<NormalItem> grids = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code) && item.isBinding() == bind) {
                grids.set(i, item);
            }
        }
        return grids;
    }


    public Map<Integer, NormalItem> findNotFullGridsByCode(String code, boolean bind) {
        Map<Integer, NormalItem> grids = new HashMap<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {

            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code) && item.isBinding() == bind && item.leftGroup() > 0) {
                grids.put(Integer.valueOf(i), item);
            }
        }
        return grids;
    }


    public Map<Integer, Integer> findItemPosAndCountByCode(String code) {
        Map<Integer, Integer> posCount = new HashMap<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code)) {
                posCount.put(Integer.valueOf(i), Integer.valueOf(item.itemDb.groupCount));
            }
        }
        return posCount;
    }


    public NormalItem findFirstItemByCode(String code) {
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code)) {
                return item;
            }
        }
        return null;
    }


    @Deprecated
    public int findPosByCode(String code) {
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && code.equals(item.itemDb.code)) {
                return i;
            }
        }
        return 0;
    }


    public NormalItem findItemById(String id) {
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && id.equals(item.itemDb.id)) {
                return item;
            }
        }
        return null;
    }


    public int findPosById(String id) {
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && id.equals(item.itemDb.id)) {
                return i;
            }
        }
        return -1;
    }


    public int emptyGridNum() {
        return this.bagPO.bagGridCount - this.usedGridCount;
    }


    public List<Integer> findEmptyGrids(int num) {
        List<Integer> emptyIndex = new ArrayList<>();
        if (num <= 0) {
            return emptyIndex;
        }
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item == null) {
                emptyIndex.add(Integer.valueOf(i));
            }
            if (emptyIndex.size() == num) {
                break;
            }
        }
        return emptyIndex;
    }

    public boolean testEmptyGridLarge(int actNum) {
        return testEmptyGridLarge(actNum, false);
    }


    public boolean testEmptyGridLarge(int actNum, boolean isSilient) {
        if (emptyGridNum() >= actNum) {
            return true;
        }
        if (!isSilient) {
            WNNotifyManager.getInstance().gridNotEnough(this.player);
        }
        return false;
    }


    public void sendItemTips(WNPlayer player, String code, int number) {
        DItemEquipBase prop = this.itemManager.getItemProp(code);
        if (prop != null) {
            MessageUtil.sendItemTip(player, prop.name, prop.qcolor, number);
        }
    }

    public boolean addItemToPos(int gridIndex, NormalItem item, Const.GOODS_CHANGE_TYPE from) {
        if (item != null) {
            if (_isVirtualItem(item, from)) {
                return true;
            }
            NormalItem oldItem = getItem(gridIndex);
            if (oldItem == null) {
                this.bagGrids.put(Integer.valueOf(gridIndex), item);
                _addUsedGridCount(1);
                List<Integer> gridIndexs = new ArrayList<>();
                gridIndexs.add(Integer.valueOf(gridIndex));
                _updateAndPush(gridIndexs, false, from);
                WNNotifyManager.getInstance().updateScript(this.player);
                Out.info(new Object[]{"增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(gridIndex), ",来源为:", (from == null) ? "未知" : Integer.valueOf(from.value)});
                return true;
            }
        }
        return false;
    }

    public boolean isMagicRingTaskOpen(WNPlayer player) {
        int taskId = GlobalConfig.MagicRing_MissionID;
        if (taskId == 0) {
            return true;
        }
        if (player.taskManager.isTaskDoingOrFinish(taskId)) {
            return true;
        }
        return false;
    }


    public boolean _isVirtualItem(NormalItem item, Const.GOODS_CHANGE_TYPE from) {
        if (item != null) {
            if (this.itemManager.getSecondType(item.prop.type) == Const.ItemSecondType.virtual.getValue()) {
                int num = item.getWorth();
                String code = item.itemDb.code;
                if (code.equals("gold")) {
                    this.player.moneyManager.addGold(num, from);
                } else if (code.equals(Const.ITEM_CODE.TICKET.value)) {
                    this.player.moneyManager.addTicket(num, from);
                } else if (code.equals("diamond")) {
                    this.player.moneyManager.addDiamond(num, from);
                } else if (code.equals("fate")) {
                    this.player.moneyManager.addXianYuan(num, from);
                } else if (code.equals("exp")) {
                    this.player.addExp(num, from);
                } else if (code.equals("upexp")) {
                    this.player.baseDataManager.addClassExp(num, from);
                } else if (!code.equals("sp")) {

                    if (code.equals("prestige")) {
                        this.player.addPrestige(num);
                        this.player.pushDynamicData("prestige", Integer.valueOf(this.player.player.prestige));
                    } else if (!code.equals("ringpres")) {


                        if (code.equals("solopoint")) {
                            this.player.soloManager.addSolopoint(num, from);
                        } else if (code.equals("consumepoint")) {
                            this.player.moneyManager.addConsumePoint(num, from);
                        } else if (code.equals("friendly")) {
                            this.player.baseDataManager.addFriendly(num);
                            this.player.pushDynamicData("friendly", Integer.valueOf(this.player.player.friendly));
                        } else if (code.indexOf("rank") == 0) {
                            int rankId = Integer.parseInt(code.replace("rank", ""));
                            this.player.titleManager.onAwardRank(rankId);
                        } else if (code.indexOf("guildpoint") == 0) {
                            this.player.addGuildPoint(num);
                            this.player.pushDynamicData("guildpoint", Integer.valueOf(this.player.player.guildpoint));
                        } else if (code.equals(Const.ITEM_CODE.TREASURE_POINT.value)) {
                            this.player.baseDataManager.addTreasurePoint(num);
                        }
                    }
                }
                return true;
            }


            if (item.isVirtQuest()) {
                return true;
            }
        }

        return false;
    }


    private Map<String, Object> _hasEnoughItem(String code, int num, final boolean unbindFist) {
        boolean flag = false;
        int sum = 0;
        Map<Integer, NormalItem> itemAll = new HashMap<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = getItem(i);
            if (item != null && code.equals(item.itemDb.code)) {
                itemAll.put(Integer.valueOf(i), item);


                sum += item.itemDb.groupCount;
            }
        }

        if (sum >= num) {
            flag = true;
        }


        List<Map.Entry<Integer, NormalItem>> list = new ArrayList<>(itemAll.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, NormalItem>>() {
            public int compare(Map.Entry<Integer, NormalItem> item1, Map.Entry<Integer, NormalItem> item2) {
                int bind1 = ((NormalItem) item1.getValue()).itemDb.isBind;

                int bind2 = ((NormalItem) item2.getValue()).itemDb.isBind;

                if (bind1 != bind2) {
                    if (unbindFist) {
                        return (bind1 < bind2) ? -1 : 1;
                    }
                    return (bind1 < bind2) ? 1 : -1;
                }

                return 0;
            }
        });
        Out.debug(new Object[]{getClass(), "unbindFist:", Boolean.valueOf(unbindFist), ",haveEnoughItem:", itemAll});

        Map<Integer, Integer> items = new HashMap<>();
        for (Iterator<Integer> iterator = itemAll.keySet().iterator(); iterator.hasNext(); ) {
            int index = ((Integer) iterator.next()).intValue();
            items.put(Integer.valueOf(index), Integer.valueOf(((NormalItem) itemAll.get(Integer.valueOf(index))).itemDb.groupCount));
        }


        Map<String, Object> result = new HashMap<>();
        result.put("flag", Boolean.valueOf(flag));
        result.put("items", items);
        return result;
    }


    public List<Integer> discardEnoughItem(Map<Integer, Integer> items, int sum, Const.GOODS_CHANGE_TYPE costDes) {
        List<Integer> indexs = new ArrayList<>();

        for (Iterator<Integer> iterator = items.keySet().iterator(); iterator.hasNext(); ) {
            int pos = ((Integer) iterator.next()).intValue();
            int num = ((Integer) items.get(Integer.valueOf(pos))).intValue();
            NormalItem realItem = getItem(pos);
            if (num > sum) {
                num = sum;
                sum = 0;
            } else {
                sum -= num;
            }

            if (realItem != null &&
                    realItem.deleteGroup(num)) {
                if (realItem.isInvalid()) {
                    _delete(pos);
                }
                indexs.add(Integer.valueOf(pos));

                Out.info(new Object[]{"扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", realItem.itemDb.code, ",id=", realItem.itemDb.id, ",数量=", Integer.valueOf(realItem.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value)});
                if (this.type == Const.BAG_TYPE.BAG) {
                    LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, realItem.itemDb.code, num, (realItem.itemDb.isBind == 1), costDes, realItem.getName());
                }
            }

            if (sum == 0) {
                break;
            }
        }

        return indexs;
    }


    public boolean discardItem(String code, int num, Const.GOODS_CHANGE_TYPE costDes, List<CurrencyData> currencyList, boolean unBindFist, boolean isNotPush) {
        boolean isPush = !isNotPush;
        if (currencyList == null) {
            CurrencyData currency = new CurrencyData(Const.CurrencyType.NONE.getValue(), 0);
            currencyList = new ArrayList<>();
            currencyList.add(currency);
        }

        Map<String, Object> data = _hasEnoughItem(code, num, unBindFist);
        boolean flag = ((Boolean) data.get("flag")).booleanValue();
        Map<Integer, Integer> items = (Map<Integer, Integer>) data.get("items");
        if (flag) {
            List<Integer> indexs = discardEnoughItem(items, num, costDes);
            if (isPush) {
                _updateAndPush(indexs, true, costDes);
            }
            WNNotifyManager.getInstance().updateScript(this.player);


            this.player.guildManager.bagDelItem(code);
        }
        return flag;
    }

    public boolean discardItem(String code, int num, Const.GOODS_CHANGE_TYPE costDes) {
        return discardItem(code, num, costDes, null, false, false);
    }


    public void discardItemByPos(int pos, int delNum, Const.GOODS_CHANGE_TYPE costDes) {
        discardItemByPos(pos, delNum, false, costDes);
    }


    public NormalItem discardItemByPosPerent(int pos, int percent, Const.GOODS_CHANGE_TYPE costDes) {
        NormalItem item = getItem(pos);
        if (percent == 0 || item.itemDb.groupCount <= 0) {
            return null;
        }
        float fc = 1.0F * item.itemDb.groupCount / 10000.0F * percent;
        int cost = Math.round(fc);
        cost = (cost <= 0) ? 1 : cost;
        discardItemByPos(pos, cost, costDes);


        NormalItem drop = ItemUtil.createItemByOpts(item.itemDb.copy(), item.prop);
        drop.itemDb.groupCount = cost;
        return drop;
    }


    public void discardItemByPos(int pos, int delNum, boolean all, Const.GOODS_CHANGE_TYPE costDes) {
        NormalItem item = getItem(pos);
        if (item != null) {
            if (all) {
                delNum = item.itemDb.groupCount;
            }

            Map<Integer, Integer> currency = new HashMap<>();
            currency.put(Integer.valueOf(Const.CurrencyType.NONE.getValue()), Integer.valueOf(0));
            if (item.deleteGroup(delNum)) {
                if (item.isInvalid()) {
                    _delete(pos);
                }
                List<Integer> list = new ArrayList<>();
                list.add(Integer.valueOf(pos));
                _updateAndPush(list, true, costDes);
                WNNotifyManager.getInstance().updateScript(this.player);

                Out.info(new Object[]{"扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value)});
                if (this.type == Const.BAG_TYPE.BAG) {
                    LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, delNum, (item.itemDb.isBind == 1), costDes, item.getName());
                }
            }
        }
    }


    public void discardItemsByPos(List<Map<String, Object>> posnums, Const.GOODS_CHANGE_TYPE source) {
        List<Integer> gridIndexs = new ArrayList<>();
        List<TradeMessageItemData> sysMessageItems = new ArrayList<>();

        for (int i = 0; i < posnums.size(); i++) {
            int pos = ((Integer) ((Map) posnums.get(i)).get("pos")).intValue();
            int num = ((Integer) ((Map) posnums.get(i)).get("num")).intValue();
            Map<Integer, Integer> currency = (Map<Integer, Integer>) ((Map) posnums.get(i)).get("currency");
            if (currency == null) {
                currency = new HashMap<>();
                currency.put(Integer.valueOf(Const.CurrencyType.NONE.getValue()), Integer.valueOf(0));
            }
            int costDes = ((Integer) ((Map) posnums.get(i)).get("costDes")).intValue();
            NormalItem item = getItem(pos);

            if (costDes == Const.GOODS_CHANGE_TYPE.trade.getValue()) {
                TradeMessageItemData data = new TradeMessageItemData();
                data.name = item.getName();
                data.qt = item.prop.qcolor;
                data.num = num;
                sysMessageItems.add(data);
            }
            if (item != null && num <= item.itemDb.groupCount) {
                if (num < item.itemDb.groupCount) {
                    item.deleteGroup(num);
                } else {
                    _delete(pos);
                }
                gridIndexs.add(Integer.valueOf(pos));
                Out.info(new Object[]{"扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (source == null) ? "未知" : Integer.valueOf(source.value)});
                if (this.type == Const.BAG_TYPE.BAG) {
                    LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, item.itemDb.groupCount, (item.itemDb.isBind == 1), source, item.getName());
                }
            }
        }

        if (gridIndexs.size() > 0) {
            _updateAndPush(gridIndexs, true, source);
            WNNotifyManager.getInstance().updateScript(this.player);
        }
        if (sysMessageItems.size() > 0) {
            this.player.pushChatSystemMessage(Const.SYS_CHAT_TYPE.TRADE, "0", sysMessageItems, null);
        }
    }


    public boolean discardItemsByCode(String code, Const.GOODS_CHANGE_TYPE costDes) {
        List<SimpleItemInfo> simpleItemInfos = ItemUtil.parseString(code);
        for (SimpleItemInfo simpleItemInfo : simpleItemInfos) {
            int totalNum = findItemNumByCode(simpleItemInfo.itemCode);
            if (totalNum < simpleItemInfo.itemNum) {
                return false;
            }
        }
        for (SimpleItemInfo simpleItemInfo : simpleItemInfos) {
            discardItem(simpleItemInfo.itemCode, simpleItemInfo.itemNum, costDes);
        }

        return true;
    }


    public void removeItemByPos(int pos, boolean flag, Const.GOODS_CHANGE_TYPE costDes) {
        NormalItem item = getItem(pos);
        if (item != null) {
            _delete(pos);
            List<Integer> list_pos = new ArrayList<>();
            list_pos.add(Integer.valueOf(pos));
            _updateAndPush(list_pos, true, costDes);
            WNNotifyManager.getInstance().updateScript(this.player);
            Out.info(new Object[]{"扣除道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (costDes == null) ? "未知" : Integer.valueOf(costDes.value)});
            if (this.type == Const.BAG_TYPE.BAG) {
                LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 2, item.itemDb.code, item.itemDb.groupCount, (item.itemDb.isBind == 1), costDes, item.getName());
            }
        }
    }


    public void removeAllItems() {
        List<Integer> gridIndexs = new ArrayList<>();

        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = getItem(i);
            if (item != null) {
                _delete(i);
                gridIndexs.add(Integer.valueOf(i));
            }
        }

        if (gridIndexs.size() > 0) {
            _updateAndPush(gridIndexs, true, Const.GOODS_CHANGE_TYPE.clear_when_logout);
            WNNotifyManager.getInstance().updateScript(this.player);
            Out.info(new Object[]{"下线时清除所有回购背包的物品:playerId=", this.player.getId()});
        }
    }


    public boolean canPackUp() {
        long now = System.currentTimeMillis();
        if (now - this.bagGridPackUpTime < 5000L) {
            return false;
        }
        return true;
    }


    public void merge(NormalItem item, Map<String, NormalItem> temp, List<NormalItem> newData) {
        if (temp.get(item.itemDb.code) == null) {
            temp.put(item.itemDb.code, item);
        } else if (((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount + item.itemDb.groupCount >= item.prop.groupCount) {
            int tmpCount = item.itemDb.groupCount;

            item.setNum(item.prop.groupCount);
            newData.add(item);


            ((NormalItem) temp.get(item.itemDb.code)).setNum(((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount + tmpCount - item.prop.groupCount);
            if (((NormalItem) temp.get(item.itemDb.code)).itemDb.groupCount == 0) {
                temp.remove(item.itemDb.code);
            }
        } else {

            ((NormalItem) temp.get(item.itemDb.code)).addGroupNum(item.itemDb.groupCount);
        }
    }


    public List<NormalItem> _packUpStackNum() {
        List<NormalItem> newData = new ArrayList<>();

        Map<String, NormalItem> temp = new HashMap<>();
        Map<String, NormalItem> tempBind = new HashMap<>();

        for (int index = 1; index <= this.bagPO.bagGridCount; index++) {
            NormalItem item = getItem(index);
            if (item != null) {


                if (item.itemDb.groupCount != item.prop.groupCount) {
                    if (item.isBinding()) {
                        ItemUtil.mergeItems(item, tempBind, newData);
                    } else {
                        ItemUtil.mergeItems(item, temp, newData);
                    }
                } else {
                    newData.add(item);
                }
            }
        }
        for (NormalItem opts : temp.values()) {
            newData.add(opts);
        }

        for (NormalItem opts : tempBind.values()) {
            newData.add(opts);
        }

        return newData;
    }


    public boolean itemUseById(String id, int num) {
        if (num > findItemNumByCode(id)) {
            Out.warn(new Object[]{this.player.getId(), "在使用物品的时候失败了!个数不足:id=", id, ",要扣的数量为:", Integer.valueOf(num)});
            return false;
        }
        NormalItem item = findFirstItemByCode(id);

        if (item == null || !item.canUse()) {
            Out.warn(new Object[]{this.player.getId(), "在使用物品的时候失败了!是不可使用的类型:id=", id, ",要扣的数量为:", Integer.valueOf(num)});
            return false;
        }


        if (!discardItem(id, num, Const.GOODS_CHANGE_TYPE.use, null, false, false)) {
            Out.warn(new Object[]{this.player.getId(), "在使用物品的时候失败了!个数不足2:id=", id, ",要扣的数量为:", Integer.valueOf(num)});
            return false;
        }

        return true;
    }


    public boolean isItemNumEnough(String code, int num) {
        if (findItemNumByCode(code) >= num) {
            return true;
        }
        return false;
    }


    public void ItemStatusUpdate(int index) {
        NormalItem item = getItem(index);
        if (item != null) {
            item.itemDb.isNew = 0;
            this.bagGrids.put(Integer.valueOf(index), item);
        }
    }


    public void _updateAndPush(List<Integer> gridIndexs, boolean refresh, Const.GOODS_CHANGE_TYPE source) {
        _pushDynamicData(gridIndexs, refresh, source);
    }

    public void _updateAndPush(List<Integer> gridIndexs, boolean refresh) {
        _pushDynamicData(gridIndexs, refresh, null);
    }


    public void _pushDynamicData(List<Integer> gridIndexs, boolean refresh, Const.GOODS_CHANGE_TYPE source) {
        if (this.type == Const.BAG_TYPE.BAG) {
            WNNotifyManager.getInstance().pushBagItemDynamic(this.player, gridIndexs, refresh, source);
        } else if (this.type == Const.BAG_TYPE.WAREHOUSE) {
            WNNotifyManager.getInstance().pushBagItemDynamicWareHouse(this.player, gridIndexs, refresh);
        } else if (this.type == Const.BAG_TYPE.RECYCLE) {
            WNNotifyManager.getInstance().pushBagItemDynamicRecycle(this.player, gridIndexs, refresh);
        }
    }

    public void _pushNewItem(String code, int num, Const.GOODS_CHANGE_TYPE from) {
        WNNotifyManager.getInstance().pushBagNewItem(this.player, code, num, from);
    }

    public boolean identify() {
        return false;
    }


    public void _delete(int pos) {
        this.bagGrids.remove(Integer.valueOf(pos));
        _addUsedGridCount(-1);
    }


    public void setCD(int secondType, int pos) {
        List<Integer> grids = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null &&
                    this.itemManager.getSecondType(item.prop.type) == secondType) {
                item.setCD();
                if (i != pos) {
                    grids.add(Integer.valueOf(i));
                }
            }
        }


        _updateAndPush(grids, false);
    }


    public List<NormalItem> getAllTypeGem() {
        Map<Integer, NormalItem> data = new HashMap<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = getItem(i);
            DItemBase prop = (DItemBase) item.prop;
            if (item != null && item.prop.itemSecondType == Const.ItemSecondType.gem.getValue() &&
                    item.getLevel() <= this.player.getLevel()) {


                NormalItem old = data.get(Integer.valueOf(prop.par));
                if (old != null) {
                    if (old.prop.price < item.prop.price) {
                        data.put(Integer.valueOf(prop.par), item);
                    }
                } else {
                    data.put(Integer.valueOf(prop.par), item);
                }
            }
        }

        Out.debug(new Object[]{getClass(), "getAllTypeGem:", data});
        List<NormalItem> res = new ArrayList<>();
        for (NormalItem v : data.values()) {
            res.add(v);
        }

        res.sort(new Comparator<NormalItem>() {
            public int compare(NormalItem a, NormalItem b) {
                return (a.prop.price < b.prop.price) ? 1 : -1;
            }
        });

        return res;
    }


    public List<NormalEquip> findEquipByType(int equipType, int pro, int level) {
        List<NormalEquip> items = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null) {

                if (item.isEquip()) {

                    if (item.prop.Pro == 0 || item.prop.Pro == pro) {

                        if (item.prop.levelReq <= level) {


                            NormalEquip equip = (NormalEquip) item;
                            if (equip.prop.itemTypeId == equipType) {
                                items.add(equip);
                            }
                        }
                    }
                }
            }
        }
        return items;
    }


    public List<NormalItem> findItemByType(String type) {
        List<NormalItem> items = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && item.prop.type.equals(type)) {
                items.add(item);
            }
        }
        return items;
    }


    public List<NormalItem> findItemBySecondType(Const.ItemSecondType secondType) {
        List<NormalItem> items = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && item.prop.itemSecondType == secondType.getValue()) {
                items.add(item);
            }
        }
        return items;
    }


    public List<NormalItem> findItemByProp(String prop) {
        List<NormalItem> items = new ArrayList<>();
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null) {

                if (!item.isEquip()) {


                    DItemBase template = (DItemBase) item.prop;
                    if (template != null && template.prop.equals(prop))
                        items.add(item);
                }
            }
        }
        return items;
    }


    public void gmDeleteItemById(String id, int num) {
        for (int i = 1; i <= this.bagPO.bagGridCount; i++) {
            NormalItem item = this.bagGrids.get(Integer.valueOf(i));
            if (item != null && item.itemDb.id.equalsIgnoreCase(id)) {
                num = Math.min(num, item.itemDb.groupCount);
                discardItemByPos(i, num, false, Const.GOODS_CHANGE_TYPE.gm);
                List<Integer> grids = new ArrayList<>();
                grids.add(Integer.valueOf(i));
                _updateAndPush(grids, true, Const.GOODS_CHANGE_TYPE.gm);
                break;
            }
        }
    }


    public static class SimpleItemInfo {
        public String itemCode;

        public int itemNum;

        public Const.ForceType forceType;

        public int type;

        public int index;

        public int pos;
    }


    public int _calcNeedGridNumByCode(List<SimpleItemInfo> itemList, Const.ForceType forceType) {
        int needGridNum = 0;

        Map<String, Integer> bindGroup = new HashMap<>();
        Map<String, Integer> unBindGroup = new HashMap<>();
        for (int i = 0; i < itemList.size(); i++) {
            SimpleItemInfo itemInfo = itemList.get(i);

            if (!ItemUtil.isVirtualItem(itemInfo.itemCode)) {


                Const.ForceType finalForceType = (itemInfo.forceType != null) ? itemInfo.forceType : forceType;


                DItemEquipBase prop = ItemUtil.getPropByCode(itemInfo.itemCode);
                if (prop == null) {
                    return 9999;
                }
                int finalBindType = ItemUtil.getPropBindType(prop, finalForceType);
                boolean isBind = (finalBindType == 1);

                Map<String, Integer> group = isBind ? bindGroup : unBindGroup;
                if (group.get(itemInfo.itemCode) != null) {

                    group.put(itemInfo.itemCode, Integer.valueOf(((Integer) group.get(itemInfo.itemCode)).intValue() + itemInfo.itemNum));
                } else {

                    group.put(itemInfo.itemCode, Integer.valueOf(itemInfo.itemNum));
                }
            }
        }
        List<Object[]> items = new ArrayList();
        Iterator<String> keys_bind = bindGroup.keySet().iterator();
        while (keys_bind.hasNext()) {
            String itemCode = keys_bind.next();
            int itemNum = ((Integer) bindGroup.get(itemCode)).intValue();
            items.add(new Object[]{itemCode, Integer.valueOf(itemNum), Boolean.valueOf(true)});
        }
        Iterator<String> keys_unbind = unBindGroup.keySet().iterator();
        while (keys_unbind.hasNext()) {
            String itemCode = keys_unbind.next();
            int itemNum = ((Integer) unBindGroup.get(itemCode)).intValue();
            items.add(new Object[]{itemCode, Integer.valueOf(itemNum), Boolean.valueOf(false)});
        }

        if (items.size() == 0) {
            return needGridNum;
        }
        for (int j = 0; j < items.size(); j++) {
            Object[] itemInfo = items.get(j);
            String itemCode = (String) itemInfo[0];
            int calcNum = ((Integer) itemInfo[1]).intValue();
            boolean isBind = ((Boolean) itemInfo[2]).booleanValue();

            DItemEquipBase prop = ItemUtil.getPropByCode(itemCode);
            Map<Integer, NormalItem> grids = findNotFullGridsByCode(itemCode, isBind);
            Iterator<Integer> keys = grids.keySet().iterator();
            while (keys.hasNext()) {
                int gridIndex = ((Integer) keys.next()).intValue();

                NormalItem item = getItem(gridIndex);
                int leftNum = item.leftGroup();
                if (leftNum <= 0) {
                    continue;
                }
                int addNum = (leftNum < calcNum) ? leftNum : calcNum;
                if (addNum > 0) {
                    calcNum -= addNum;
                }
                if (calcNum == 0) {
                    break;
                }
            }
            if (calcNum > 0) {
                needGridNum += (calcNum + prop.groupCount - 1) / prop.groupCount;
            }
        }
        return needGridNum;
    }


    public boolean testAddCodeItem(String itemCode, int itemNum) {
        return testAddCodeItem(itemCode, itemNum, null, false);
    }

    public boolean testAddCodeItem(String itemCode, int itemNum, Const.ForceType forceType) {
        return testAddCodeItem(itemCode, itemNum, forceType, false);
    }


    public boolean testAddCodeItem(String itemCode, int itemNum, Const.ForceType forceType, boolean isNotNotify) {
        List<SimpleItemInfo> list = new ArrayList<>();
        SimpleItemInfo map = new SimpleItemInfo();
        map.itemCode = itemCode;
        map.itemNum = itemNum;
        map.forceType = forceType;
        list.add(map);
        return testAddCodeItems(list, forceType, isNotNotify);
    }


    public boolean testAddCodeItems(List<SimpleItemInfo> itemList) {
        return testAddCodeItems(itemList, null, false);
    }


    public boolean testAddCodeItems(List<SimpleItemInfo> itemList, Const.ForceType forceType, boolean isNotNotify) {
        int needGrids = _calcNeedGridNumByCode(itemList, forceType);
        if (itemList.size() > 0) {
            Out.debug(new Object[]{getClass(), "testAddCodeItems ", ((SimpleItemInfo) itemList.get(0)).itemCode, " needGrids:", Integer.valueOf(needGrids)});
        } else {
            Out.debug(new Object[]{getClass(), "testAddCodeItems needGrids:", Integer.valueOf(needGrids)});
        }

        if (emptyGridNum() < needGrids) {
            if (!isNotNotify) {
                WNNotifyManager.getInstance().gridNotEnough(this.player);
            }
            return false;
        }
        return true;
    }


    public boolean testAddEntityItem(NormalItem item, boolean isNotNotify) {
        List<NormalItem> list_items = new ArrayList<>();
        list_items.add(item);
        return testAddEntityItems(list_items, isNotNotify);
    }


    public boolean testAddEntityItemsPO(List<PlayerItemPO> items, boolean isNotNotify) {
        List<NormalItem> list = new ArrayList<>();
        for (PlayerItemPO po : items) {
            list.add(ItemUtil.createItemByDbOpts(po));
        }
        return testAddEntityItems(list, isNotNotify);
    }


    public boolean testAddEntityItems(List<NormalItem> items, boolean isNotNotify) {
        List<SimpleItemInfo> itemList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            NormalItem item = items.get(i);

            Const.ForceType forceType = item.isBinding() ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
            SimpleItemInfo map = new SimpleItemInfo();
            map.itemCode = item.itemDb.code;
            map.itemNum = item.itemDb.groupCount;
            map.forceType = forceType;
            itemList.add(map);
        }
        return testAddCodeItems(itemList, null, isNotNotify);
    }


    public boolean addCodeItemMail(List<NormalItem> items, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
        if (testAddEntityItems(items, false)) {
            System.out.println(":::::::::::::::::::addEEEEE:::::::::::::::::::::::");
            addEntityItems(items, fromDes);
        } else {
            MailSysData mailData = new MailSysData(mailKey);
            List<MailData.Attachment> list_attach = new ArrayList<>();
            for (NormalItem item : items) {

                if (item.isVirtual()) {
                    addEntityItem(item, fromDes);
                    continue;
                }
                MailData.Attachment attachment = new MailData.Attachment();
                attachment.itemCode = item.itemCode();
                attachment.itemNum = item.getNum();
                list_attach.add(attachment);
            }

            if (list_attach.size() > 0) {
                mailData.attachments = list_attach;
                MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, fromDes);
            }
        }
        return false;
    }


    public boolean addCodeItemMail(String itemCode, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
        if (testAddCodeItem(itemCode, number, forceType)) {
            addCodeItem(itemCode, number, forceType, fromDes);
        } else {
            MailSysData mailData = new MailSysData(mailKey);
            mailData.attachments = new ArrayList();
            MailData.Attachment attachment = new MailData.Attachment();
            attachment.itemCode = itemCode;
            attachment.itemNum = number;
            mailData.attachments.add(attachment);
            MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, fromDes);
        }
        return false;
    }


    public void addEntityItemMail(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes, String mailKey) {
        Const.ForceType forceType = (item.getBind() == 1) ? Const.ForceType.BIND : Const.ForceType.UN_BIND;
        if (testAddCodeItem(item.itemCode(), item.getNum(), forceType)) {
            addEntityItem(item, fromDes);
        } else {
            MailSysData mailData = new MailSysData(mailKey);
            mailData.entityItems = new ArrayList();
            mailData.entityItems.add(item.itemDb);
            MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, fromDes);
        }
    }

    public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes) {
        addCodeItem(code, number, forceType, fromDes, null, false, false);
    }

    public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList) {
        addCodeItem(code, number, forceType, fromDes, currencyList, false, false);
    }


    public void addCodeItem(String code, int number, Const.ForceType forceType, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
        List<SimpleItemInfo> codeItems = new ArrayList<>();
        SimpleItemInfo itemInfo = new SimpleItemInfo();
        itemInfo.itemCode = code;
        itemInfo.itemNum = number;
        itemInfo.forceType = forceType;
        codeItems.add(itemInfo);
        addCodeItems(codeItems, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg);
    }


    public void addCodeItems(List<SimpleItemInfo> codeItems, Const.GOODS_CHANGE_TYPE fromDes) {
        addCodeItems(codeItems, fromDes, null, false, false);
    }


    public void addCodeItems(List<SimpleItemInfo> codeItems, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
        List<NormalItem> items = new ArrayList<>();
        for (int i = 0; i < codeItems.size(); i++) {
            SimpleItemInfo itemInfo = codeItems.get(i);
            Const.ForceType realForceType = itemInfo.forceType;
            List<NormalItem> itemList = ItemUtil.createItemsByItemCode(itemInfo.itemCode, itemInfo.itemNum);
            for (int j = 0; j < itemList.size(); j++) {
                NormalItem item = itemList.get(j);
                int bindType = ItemUtil.getPropBindType(item.prop, realForceType);
                item.setBind(bindType);
            }
            items.addAll(itemList);
        }
        addEntityItems(items, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg, true);
    }

    public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes) {
        addEntityItem(item, fromDes, null, false, false);
    }


    public void addEntityItem(NormalItem item, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg) {
        List<NormalItem> items = new ArrayList<>();
        items.add(item);
        addEntityItems(items, fromDes, currencyList, isNotPushNewItem, isNotSendFullMsg, false);
    }

    public void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList) {
        addEntityItems(items, fromDes, currencyList, false, false, false);
    }


    public void addEntityItemsPO(List<PlayerItemPO> items, Const.GOODS_CHANGE_TYPE fromDes) {
        List<NormalItem> list = new ArrayList<>();
        for (PlayerItemPO po : items) {
            list.add(ItemUtil.createItemByDbOpts(po));
        }
        addEntityItems(list, fromDes);
    }

    public void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes) {
        addEntityItems(items, fromDes, null, false, false, false);
    }


    private void addEntityItems(List<NormalItem> items, Const.GOODS_CHANGE_TYPE fromDes, Map<Integer, Object> currencyList, boolean isNotPushNewItem, boolean isNotSendFullMsg, boolean isCanChangeParam) {
        if (items == null || items.size() <= 0 || this.player.isRobot()) {
            return;
        }

        List<NormalItem> actualItems = new ArrayList<>();
        Map<String, Integer> actualCounts = new HashMap<>();

        for (int i = 0; i < items.size(); i++) {
            NormalItem item = items.get(i);

            this.player.achievementManager.onGetEquipment(item.itemDb.code);

            this.player.equipManager.updateStrengthScript(item.itemDb.code);

            this.player.equipManager.updateMakeScript(item.itemDb.code);

            this.player.equipManager.updateFillGemScript(item.itemDb.code);

            if (item.isEquip()) {
                try {
                    this.player.equipManager.updateEquipScript((NormalEquip) item);
                } catch (ClassCastException e) {
                    Out.error(new Object[]{"NormalEquip cast exception, id=" + item.getId() + " code=" + item.itemDb.code + " name=" + item.getName()});
                    throw e;
                }
            }

            if (!_isVirtualItem(item, fromDes)) {


                if (!isCanChangeParam && item.prop.groupCount > 1) {
                    NormalItem cloneItem = ItemUtil.createItemByDbOpts(item.cloneItemDB());
                    actualItems.add(cloneItem);
                } else {
                    actualItems.add(item);
                }

                if (actualCounts.get(item.itemDb.code) != null) {
                    actualCounts.put(item.itemDb.code, Integer.valueOf(((Integer) actualCounts.get(item.itemDb.code)).intValue() + item.itemDb.groupCount));
                } else {
                    actualCounts.put(item.itemDb.code, Integer.valueOf(item.itemDb.groupCount));
                }

                this.player.taskManager.dealTaskEvent(Const.TaskType.GET_ITEM, item.itemDb.code, item.itemDb.groupCount);
            }
        }
        if (actualItems.size() == 0) {
            return;
        }

        List<Integer> gridIndexs = new ArrayList<>();
        List<NormalItem> createArray = new ArrayList<>();
        List<HashMap<String, NormalItem>> notFullCache = new ArrayList<>();


        notFullCache.add(new HashMap<>());
        notFullCache.add(new HashMap<>());
        List<HashMap<String, Boolean>> bagFullCheck = new ArrayList<>();

        bagFullCheck.add(new HashMap<>());
        bagFullCheck.add(new HashMap<>());

        for (int j = 0; j < actualItems.size(); j++) {
            NormalItem newItem = actualItems.get(j);
            boolean isBind = newItem.isBinding();
            String code = newItem.itemDb.code;

            if (this.type == Const.BAG_TYPE.BAG) {
                LogReportService.getInstance().ansycReportItemFlow(this.player.getPlayer(), 1, code, newItem.itemDb.groupCount, isBind, fromDes, newItem.getName());
            }

            Map<String, Boolean> bagCheck = isBind ? bagFullCheck.get(0) : bagFullCheck.get(1);
            Map<String, NormalItem> cache = isBind ? notFullCache.get(0) : notFullCache.get(1);

            if (bagCheck.get(code) == null || !((Boolean) bagCheck.get(code)).booleanValue()) {
                Map<Integer, NormalItem> grids = findNotFullGridsByCode(newItem.itemDb.code, isBind);
                Iterator<Integer> keys = grids.keySet().iterator();
                while (keys.hasNext()) {
                    int pos = ((Integer) keys.next()).intValue();
                    NormalItem item = grids.get(Integer.valueOf(pos));
                    int leftNum = item.prop.groupCount - item.itemDb.groupCount;
                    if (leftNum <= 0) {
                        continue;
                    }
                    int addNum = (newItem.itemDb.groupCount <= leftNum) ? newItem.itemDb.groupCount : leftNum;
                    newItem.addGroupNum(-addNum);
                    item.addGroupNum(addNum);
                    if (!gridIndexs.contains(Integer.valueOf(pos))) {
                        gridIndexs.add(Integer.valueOf(pos));
                        Out.info(new Object[]{"增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(addNum), "更新后数量为:", Integer.valueOf(item.itemDb.groupCount), ",位置=", Integer.valueOf(pos), ",来源为:", (fromDes == null) ? "未知" : Integer.valueOf(fromDes.value)});
                    }
                    if (newItem.itemDb.groupCount <= 0) {
                        break;
                    }
                }
            }

            if (newItem.itemDb.groupCount > 0) {
                bagCheck.put(code, Boolean.valueOf(true));

                int maxGroupCount = newItem.prop.groupCount;
                if (newItem.itemDb.groupCount >= maxGroupCount) {
                    createArray.add(newItem);
                } else if (cache.get(code) == null) {
                    cache.put(code, newItem);
                } else {
                    NormalItem cacheItem = cache.get(code);
                    int totalCount = cacheItem.itemDb.groupCount + newItem.itemDb.groupCount;
                    if (totalCount > maxGroupCount) {
                        cacheItem.setNum(maxGroupCount);
                        newItem.setNum(totalCount - maxGroupCount);

                        createArray.add(cacheItem);
                        cache.put(code, newItem);
                    } else {
                        cacheItem.setNum(totalCount);
                        if (cacheItem.itemDb.groupCount == maxGroupCount) {
                            createArray.add(cacheItem);
                            cache.remove(code);
                        }
                    }
                }
            }
        }

        for (Map<String, NormalItem> cache : notFullCache) {
            for (NormalItem newItem : cache.values()) {
                if (newItem != null) {
                    createArray.add(newItem);
                }
            }
        }


        List<Integer> emptyIndexs = findEmptyGrids(createArray.size());
        if (emptyIndexs.size() < createArray.size()) {
            StringBuilder sb = new StringBuilder("addEntityItems error, playerId=" + this.player.getId() + " emptyIndexsSize:" + emptyIndexs.size() + " createArraySize:" + createArray.size());
            sb.append("\r\nlostItems: ");
            for (NormalItem lostItem : createArray) {
                sb.append("code").append(lostItem.itemCode()).append(",num").append(lostItem.getNum()).append(";");
            }
            Out.error(new Object[]{sb.toString()});
            return;
        }
        for (int k = 0; k < createArray.size(); k++) {
            NormalItem item = createArray.get(k);
            this.bagGrids.put(emptyIndexs.get(k), createArray.get(k));
            gridIndexs.add(emptyIndexs.get(k));
            Out.info(new Object[]{"增加道具成功,角色id=", this.player.getId(), ",背包类型为:", Integer.valueOf(this.type.getValue()), ",道具code=", item.itemDb.code, ",id=", item.itemDb.id, ",数量=", Integer.valueOf(item.itemDb.groupCount), "更新后数量为:", Integer.valueOf(item.itemDb.groupCount), ",位置=", emptyIndexs.get(k), ",来源为:", (fromDes == null) ? "未知" : Integer.valueOf(fromDes.value)});
        }
        _addUsedGridCount(createArray.size());


        if (gridIndexs.size() > 0) {
            _updateAndPush(gridIndexs, true, fromDes);
        }
        if (!isNotPushNewItem) {
            Iterator<String> keys = actualCounts.keySet().iterator();
            while (keys.hasNext()) {
                String code = keys.next();
                int actualCount = ((Integer) actualCounts.get(code)).intValue();
                _pushNewItem(code, actualCount, fromDes);
            }
        }

        if (emptyGridNum() <= 0 && !isNotSendFullMsg) {
            PlayerUtil.sendSysMessageToPlayer(LangService.getValue("BAG_BECOME_FULL_NOTICE"), this.player.getId(), Const.TipsType.BLACK);
        }
        WNNotifyManager.getInstance().updateScript(this.player);


        this.player.guildManager.bagAddItems(items);
    }

    public void addBagGridCount(int num) {
        int oldCount = this.bagPO.bagGridCount;
        this.bagPO.bagGridCount += num;
        List<Integer> gridIndexs = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            gridIndexs.add(Integer.valueOf(oldCount + i));
        }
        _updateAndPush(gridIndexs, false);
        _gridNumChangePush();


        BagHandler.BagGridNumPush.Builder gridNumChange = BagHandler.BagGridNumPush.newBuilder();
        gridNumChange.setS2CType(this.type.getValue());
        gridNumChange.setGridNum(this.bagPO.bagGridCount);
        this.player.receive("area.bagPush.bagGridNumPush", (GeneratedMessage) gridNumChange.build());
    }


    public void update() {
        Map<Integer, PlayerItemPO> grids = new HashMap<>();
        for (Integer pos : this.bagGrids.keySet()) {
            if (this.bagGrids.get(pos) != null) {
                grids.put(pos, ((NormalItem) this.bagGrids.get(pos)).itemDb);
            }
        }
        this.bagPO.bagGrids = grids;
    }
}


