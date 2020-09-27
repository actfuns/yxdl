package com.wanniu.game.consignmentShop;

import com.alibaba.fastjson.JSON;
import com.wanniu.core.db.GCache;
import com.wanniu.core.db.ModifyDataType;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.StringUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.poes.ConsignmentItemsPO;
import com.wanniu.redis.GameDao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConsignmentDataManager {
    private Date refreshTime;
    private Map<String, List<ConsignmentItemsPO>> cache;
    private Map<String, Date> cacheTime;
    public Map<String, ConsignmentItemsPO> items = new ConcurrentHashMap<>();

    public ConsignmentDataManager() {
        this.refreshTime = new Date();
        this.cache = new HashMap<>();
        this.cacheTime = new HashMap<>();

        ConstsTR tr = ConstsTR.consignment_itemsTR;
        long start = System.currentTimeMillis();
        Map<String, String> result = GCache.hgetAll(tr.value);
        Out.info(new Object[]{"加载寄卖行耗时:", Long.valueOf(System.currentTimeMillis() - start)});
        if (result != null) {
            for (String id : result.keySet()) {
                ConsignmentItemsPO item = (ConsignmentItemsPO) JSON.parseObject(result.get(id), ConsignmentItemsPO.class);
                if (item.consignmentTime <= System.currentTimeMillis()) {
                    GCache.hremove(tr.value, id);
                    GameDao.delToDB(tr, id);


                    ConsignmentUtil.timeOutMail(item);
                    continue;
                }
                this.items.put(id, item);
            }
        } else {
            List<ConsignmentItemsPO> list = GameDao.findFromDB(tr, null, ConsignmentItemsPO.class);
            for (ConsignmentItemsPO item : list) {
                if (item.consignmentTime <= System.currentTimeMillis()) {

                    GameDao.delToDB(tr, item.id);


                    ConsignmentUtil.timeOutMail(item);
                    continue;
                }
                this.items.put(item.id, item);
            }
        }
    }

    public ConsignmentItemsPO findById(String id) {
        return this.items.get(id);
    }


    public List<ConsignmentItemsPO> findByPlayerId(String playerId) {
        List<ConsignmentItemsPO> list = new ArrayList<>();
        for (ConsignmentItemsPO item : this.items.values()) {
            if (item.consignmentPlayerId.equals(playerId)) {
                list.add(item);
            }
        }
        return list;
    }

    public boolean insert(ConsignmentItemsPO item) {
        ConsignmentItemsPO cItem = this.items.get(item.id);
        if (cItem == null) {
            this.items.put(item.id, item);
            this.refreshTime = new Date();
            return true;
        }
        return false;
    }

    public boolean remove(String id) {
        ConsignmentItemsPO cItem = this.items.get(id);
        if (cItem == null) {
            return false;
        }
        this.items.remove(id);
        GCache.hremove(ConstsTR.consignment_itemsTR.value, id);
        GameDao.delToDB(ConstsTR.consignment_itemsTR, id);

        this.refreshTime = new Date();
        return true;
    }


    public void saveConsignmentItems() {
        for (String id : this.items.keySet()) {

            GameDao.update(ConstsTR.consignment_itemsTR.value, id, this.items.get(id));

            GameDao.updateToDB(ConstsTR.consignment_itemsTR, id, ModifyDataType.MAP);
        }
    }

    public boolean isNeedRefresh(String type) {
        Date cTime = this.cacheTime.get(type);
        if (cTime == null || cTime.getTime() <= this.refreshTime.getTime()) {
            return true;
        }

        return false;
    }


    public static String getCacheType(int itemSecondType, int pro, int qcolor, int order, String itemType, int level) {
        return new String(itemSecondType + ":" + itemType + ":" + pro + qcolor + order + level);
    }

    public void refreshCache(int itemSecondType, int pro, int qcolor, int order, String itemType, int level) {
        Map<String, Object> query = new HashMap<>();
        if (itemSecondType != -1) {
            query.put("itemSeondType", Integer.valueOf(itemSecondType));
        }
        if (pro != -1) {
            query.put("pro", Integer.valueOf(pro));
        }

        if (qcolor != -1) {
            query.put("qColor", Integer.valueOf(qcolor));
        }

        if (StringUtil.isNotEmpty(itemType)) {
            String[] types = itemType.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            if (types.length == 1) {
                list.add(Integer.valueOf(Integer.parseInt(types[0])));
            } else {
                for (String str : types) {
                    list.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            query.put("itemType", list);
        }

        if (level != 0 && level != -1) {
            query.put("levelReq", Integer.valueOf(level));
        }

        Out.debug(new Object[]{"query:", query});
        Out.debug(new Object[]{"order:", Integer.valueOf(order)});
        List<ConsignmentItemsPO> data = find(query, order);
        String type = getCacheType(itemSecondType, pro, qcolor, order, itemType, level);
        this.cache.put(type, data);
        this.cacheTime.put(type, new Date());

        Out.debug(new Object[]{"type " + type + " cache:", this.cache});
    }

    public List<ConsignmentItemsPO> getCache(String type) {
        List<ConsignmentItemsPO> list = this.cache.get(type);
        List<ConsignmentItemsPO> result = new ArrayList<>();
        long now = System.currentTimeMillis();
        for (ConsignmentItemsPO item : list) {

            if (item.consignmentTime - ConsignmentUtil.sellTime() > now) {
                continue;
            }

            if (item.consignmentTime < now) {
                continue;
            }
            result.add(item);
        }
        return result;
    }


    public List<ConsignmentItemsPO> data(int order) {
        long now = System.currentTimeMillis();
        List<ConsignmentItemsPO> list = new ArrayList<>();
        for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
            ConsignmentItemsPO item = node.getValue();

            if (item.consignmentTime - ConsignmentUtil.sellTime() > now) {
                continue;
            }

            if (item.consignmentTime < now) {
                continue;
            }
            list.add(node.getValue());
        }
        list.sort(comparator(order));
        return list;
    }


    private Comparator<ConsignmentItemsPO> comparator(final int order) {
        Comparator<ConsignmentItemsPO> comparator = new Comparator<ConsignmentItemsPO>() {
            public int compare(ConsignmentItemsPO o1, ConsignmentItemsPO o2) {
                if (order == Const.ConsignmentOrderType.TIME_ASC.getValue())
                    return (int) (o1.consignmentTime - o2.consignmentTime);
                if (order == Const.ConsignmentOrderType.TIME_DES.getValue())
                    return (int) (o2.consignmentTime - o1.consignmentTime);
                if (order == Const.ConsignmentOrderType.PRICE_ASC.getValue())
                    return o1.consignmentPrice - o2.consignmentPrice;
                if (order == Const.ConsignmentOrderType.PRICE_DES.getValue())
                    return o2.consignmentPrice - o1.consignmentPrice;
                if (order == Const.ConsignmentOrderType.LEVEL_ASC.getValue())
                    return o1.level - o2.level;
                if (order == Const.ConsignmentOrderType.LEVEL_DES.getValue()) {
                    return o2.level - o1.level;
                }
                return 0;
            }
        };
        return comparator;
    }


    private List<ConsignmentItemsPO> findByItemSeondType(int itemSecondType, List<ConsignmentItemsPO> list) {
        List<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                if (item.itemSecondType == itemSecondType) {
                    retList.add(item);
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                if (item.itemSecondType == itemSecondType) {
                    retList.add(item);
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> findByItemId(String id, List<ConsignmentItemsPO> list) {
        List<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                if (item.id.equals(id)) {
                    retList.add(item);
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                if (item.id.equals(id)) {
                    retList.add(item);
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> findByPro(int pro, List<ConsignmentItemsPO> list) {
        ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                if (item.pro == pro) {
                    retList.add(item);
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                if (item.pro == pro) {
                    retList.add(item);
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> findByQColor(int qColor, List<ConsignmentItemsPO> list) {
        ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                if ((ItemUtil.getPropByCode(item.db.code)).qcolor == qColor) {
                    retList.add(item);
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                if ((ItemUtil.getPropByCode(item.db.code)).qcolor == qColor) {
                    retList.add(item);
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> findByReqLevel(int level, List<ConsignmentItemsPO> list) {
        List<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                if (item.level == level) {
                    retList.add(item);
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                if ((ItemUtil.getPropByCode(item.db.code)).levelReq == level) {
                    retList.add(item);
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> findByItemType(List<Integer> itemType, List<ConsignmentItemsPO> list) {
        ArrayList<ConsignmentItemsPO> retList = new ArrayList<>();
        if (list == null) {
            for (Map.Entry<String, ConsignmentItemsPO> node : this.items.entrySet()) {
                ConsignmentItemsPO item = node.getValue();
                for (Integer value : itemType) {
                    if (item.itemType == value.intValue()) {
                        retList.add(item);
                    }
                }
            }
        } else {
            for (ConsignmentItemsPO item : list) {
                for (Integer value : itemType) {
                    if (item.itemType == value.intValue()) {
                        retList.add(item);
                    }
                }
            }
        }
        return retList;
    }

    private List<ConsignmentItemsPO> find(Map<String, Object> types, int order) {
        List<ConsignmentItemsPO> list = null;
        for (Map.Entry<String, Object> node : types.entrySet()) {
            String key = node.getKey();
            if (key.equals("id")) {
                String value = String.valueOf(node.getValue());
                list = findByItemId(value, list);
            }
            if (key.equals("itemSeondType")) {
                int value = ((Integer) node.getValue()).intValue();
                list = findByItemSeondType(value, list);
                continue;
            }
            if (key.equals("pro")) {
                int value = ((Integer) node.getValue()).intValue();
                list = findByPro(value, list);
                continue;
            }
            if (key.equals("qColor")) {
                int value = ((Integer) node.getValue()).intValue();
                list = findByQColor(value, list);
                continue;
            }
            if (key.equals("itemType")) {
                List<Integer> value = (List<Integer>) node.getValue();
                list = findByItemType(value, list);
                continue;
            }
            if (key.equals("levelReq")) {
                int value = ((Integer) node.getValue()).intValue();
                list = findByReqLevel(value, list);
            }
        }
        list.sort(comparator(order));
        return list;
    }
}


