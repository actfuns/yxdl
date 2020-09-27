package com.wanniu.game.bag;

import com.wanniu.game.common.Const;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BagUtil {
    public static int getGridPrice(int type) {
        if (type == Const.BAG_TYPE.BAG.getValue())
            return GlobalConfig.Package_PricePer;
        if (type == Const.BAG_TYPE.RECYCLE.getValue()) {
            return 0;
        }
        return GlobalConfig.PersonalWarehouse_PricePer;
    }


    public static boolean checkCost(WNPlayer player, List<Object[]> costs) {
        boolean flag = true;
        if (costs.size() == 0) {
            flag = false;
        }
        for (Object[] intString : costs) {
            if (player.getWnBag().findItemNumByCode((String) intString[0]) < ((Integer) intString[1]).intValue()) {
                flag = false;
            }
        }

        return flag;
    }


    public static void cost(WNPlayer player, List<Object[]> costs, Const.GOODS_CHANGE_TYPE costFrom) {
        costs.forEach(v -> player.getWnBag().discardItem((String) v[0], ((Integer) v[1]).intValue(), costFrom, null, false, false));
    }


    public static void costJustHave(WNPlayer player, List<Object[]> costs) {
        costs.forEach(v -> {
            int num = player.getWnBag().findItemNumByCode((String) v[0]);
            player.getWnBag().discardItem((String) v[0], num, null, null, false, false);
        });
    }


    public static int getGridPrice(Const.BAG_TYPE type) {
        if (type == Const.BAG_TYPE.BAG)
            return GlobalConfig.Package_PricePer;
        if (type == Const.BAG_TYPE.RECYCLE) {
            return 0;
        }
        return GlobalConfig.PersonalWarehouse_PricePer;
    }


    public static int getTotalCount(Const.BAG_TYPE type) {
        if (type == Const.BAG_TYPE.BAG)
            return GlobalConfig.Package_MaxSize;
        if (type == Const.BAG_TYPE.RECYCLE) {
            return GlobalConfig.Package_MaxSize;
        }
        return GlobalConfig.PersonalWarehouse_MaxSize;
    }


    public static int getSellPrice(int price, int num) {
        return Math.round((price * GlobalConfig.NpcShop_ItemPrice_CutRate / 100)) * num;
    }


    public static WNBag getStoreByType(WNPlayer player, int type) {
        if (type == Const.BAG_TYPE.BAG.getValue())
            return player.bag;
        if (type == Const.BAG_TYPE.WAREHOUSE.getValue()) {
            return player.wareHouse;
        }
        return null;
    }


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            Condition condition = lock.newCondition();
            condition.await(15000L, TimeUnit.MILLISECONDS);
            System.out.println("xxx");
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


