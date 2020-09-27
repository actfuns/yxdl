package com.wanniu.game.consignmentShop;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;
import com.wanniu.game.data.base.DItemEquipBase;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.ConsignmentItemsPO;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.ConsignmentLineHandler;
import pomelo.item.ItemOuterClass;


public class ConsignmentLineService {
    private static ConsignmentLineService instance;
    public static final int ONE_PAGE = 20;
    public static final int MAX_PAGE = 999;

    public static ConsignmentLineService getInstance() {
        if (instance == null) {
            synchronized (ConsignmentLineService.class) {
                if (instance == null) {
                    instance = new ConsignmentLineService();
                }
            }
        }
        return instance;
    }

    public static final int MAX_SEARCH = 100;
    private ConsignmentDataManager dataManager;

    public static class ConsignmentQueryParam {
        public int pro;
        public int qColor;
        public int order;
        public int itemSecondType;
        public int page;
        public String itemType;
        public int level;
    }

    private ConsignmentLineService() {
        this.dataManager = new ConsignmentDataManager();
    }


    public boolean add(ConsignmentItemsPO item) {
        return this.dataManager.insert(item);
    }


    public boolean insert(ConsignmentItemsPO item) {
        Out.debug(new Object[]{"ConsignmentService insert:", "item:", item});
        boolean ret = this.dataManager.insert(item);
        if (ret) {

            Out.debug(new Object[]{"寄卖行 新增物品 id:", item.id});
        } else {
            Out.error(new Object[]{"寄卖行新增物品不成功：", item.id});
        }

        return ret;
    }


    public boolean remove(String id) {
        boolean ret = this.dataManager.remove(id);
        if (ret) {

            Out.debug(new Object[]{"寄卖行 主动删除物品 id:", id});
        } else {
            Out.error(new Object[]{"寄卖行 要删除的物品不存在:", id});
        }
        return ret;
    }

    public ConsignmentItemsPO getById(String id) {
        return this.dataManager.findById(id);
    }


    public List<ConsignmentItemsPO> findByPlayerId(String playerId) {
        return this.dataManager.findByPlayerId(playerId);
    }


    public void onCloseGame() {
        this.dataManager.saveConsignmentItems();
    }

    public final ConsignmentLineHandler.ConsignmentListResponse.Builder query(WNPlayer player, int logicServerId, ConsignmentQueryParam opts) {
        int pro = opts.pro;
        int qColor = opts.qColor;
        int order = opts.order;
        int itemSecondType = opts.itemSecondType;
        String itemType = opts.itemType;
        int level = opts.level;
        int page = opts.page;

        if (page > 999) {
            page = 999;
        }

        ConsignmentLineHandler.ConsignmentListResponse.Builder ret = ConsignmentLineHandler.ConsignmentListResponse.newBuilder();
        List<ItemOuterClass.ConsignmentItem> data = new ArrayList<>();


        List<ConsignmentItemsPO> result = null;

        if (pro == -1 && qColor == -1 && itemSecondType == -1 && itemType.length() == 0 && (level == 0 || level == -1)) {

            result = this.dataManager.data(order);
        } else {
            String type = ConsignmentDataManager.getCacheType(itemSecondType, pro, qColor, order, itemType, level);
            if (this.dataManager.isNeedRefresh(type)) {
                this.dataManager.refreshCache(itemSecondType, pro, qColor, order, itemType, level);
            }
            result = this.dataManager.getCache(type);
            if (result == null) {
                this.dataManager.refreshCache(itemSecondType, pro, qColor, order, itemType, level);
                result = this.dataManager.getCache(type);
            }
        }
        ret.setS2CTotalPage((result.size() + 20 - 1) / 20);
        int end = page * 20;
        int begin = end - 20;
        if (begin < result.size()) {
            for (int i = begin; i < end && i < result.size(); i++) {
                ConsignmentItemsPO item = result.get(i);


                data.add(ConsignmentUtil.buildConsignmentItem(player, item));
            }
            ret.addAllS2CData(data);
        }
        return ret;
    }


    public final ArrayList<ItemOuterClass.ConsignmentItem> search(WNPlayer player, int logicServerId, String condition) {
        List<ConsignmentItemsPO> result = this.dataManager.data(Const.ConsignmentOrderType.TIME_DES.getValue());

        ArrayList<ItemOuterClass.ConsignmentItem> ret = new ArrayList<>();
        for (int i = 0, sum = 0; i < result.size() && sum < 100; i++) {
            ConsignmentItemsPO item = result.get(i);
            DItemEquipBase itemBase = ItemUtil.getPropByCode(item.db.code);
            if (itemBase.name.indexOf(condition) != -1) {


                ret.add(ConsignmentUtil.buildConsignmentItem(player, item));
                sum++;
            }
        }

        Out.debug(new Object[]{"ConsignmentService search:", ret});
        return ret;
    }
}


