package com.wanniu.game.intergalmall;

import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.CardCO;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ShopLabCO;
import com.wanniu.game.data.base.IntergalShopBase;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.poes.IntergalMallPO;
import com.wanniu.redis.GameDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pomelo.area.IntergalMallHandler;


public class IntergalMallManager {
    public WNPlayer player;
    public IntergalMallPO intergalMallPO;

    public IntergalMallManager(WNPlayer player) {
        this.player = player;

        this.intergalMallPO = (IntergalMallPO) GameDao.get(ConstsTR.intergalMallTR.value, player.getId(), IntergalMallPO.class);
        if (this.intergalMallPO == null) {
            this.intergalMallPO = new IntergalMallPO();
            this.intergalMallPO.hasBuyItem = new HashMap<>();
        }
    }


    public List<IntergalMallHandler.IntergalMallTab> getIntergalMallItemList(int shopType) {
        List<IntergalMallHandler.IntergalMallTab> list = new ArrayList<>();

        for (ShopLabCO tabCO : GameData.ShopLabs.values()) {
            if (shopType != -1 && shopType != tabCO.id) {
                continue;
            }
            IntergalMallHandler.IntergalMallTab.Builder mallTab = IntergalMallHandler.IntergalMallTab.newBuilder();
            mallTab.setTabId(tabCO.id);
            if (tabCO.id == 2) {
                mallTab.setCurrencyNum(this.player.moneyManager.getConsumePoint());
            } else if (tabCO.id == 3) {
                if (this.player.allBlobData.xianYuan != null) {
                    mallTab.setCurrencyNum(this.player.moneyManager.getXianYuan());
                }
            } else if (tabCO.id == 4) {
                mallTab.setCurrencyNum(this.player.soloManager.getSolopoint());
            } else if (tabCO.id == 5) {
                mallTab.setCurrencyNum(this.player.guildManager.getContribution());
            } else if (tabCO.id == 1) {
                mallTab.setCurrencyNum(this.player.moneyManager.getGold());
            }

            Map<Integer, IntergalShopBase> items = (IntergalMallConfig.getInstance()).shopItems.get(Integer.valueOf(tabCO.id));
            for (IntergalShopBase prop : items.values()) {

                if (prop.isShow == 0) {
                    continue;
                }
                if (prop.periodStartDate != null && prop.periodStartDate.getTime() > System.currentTimeMillis()) {
                    continue;
                }

                if (prop.periodEndDate != null && prop.periodEndDate.getTime() < System.currentTimeMillis()) {
                    continue;
                }

                IntergalMallHandler.IntergalMallItem.Builder item = IntergalMallHandler.IntergalMallItem.newBuilder();
                item.setId(prop.iD);
                item.setCode(prop.itemCode);

                if (prop.buyTimes == -1) {
                    item.setLastcount(-1);
                } else {

                    Map<Integer, Integer> shopHasBuyMap = (Map<Integer, Integer>) this.intergalMallPO.hasBuyItem.get(Integer.valueOf(tabCO.id));
                    if (shopHasBuyMap == null) {
                        shopHasBuyMap = new HashMap<>();
                        this.intergalMallPO.hasBuyItem.put(Integer.valueOf(tabCO.id), shopHasBuyMap);
                    }
                    int hasBuyNum = shopHasBuyMap.containsKey(Integer.valueOf(prop.iD)) ? ((Integer) shopHasBuyMap.get(Integer.valueOf(prop.iD))).intValue() : 0;
                    if (hasBuyNum > 0) {
                        Out.debug(new Object[]{Integer.valueOf(prop.iD), "---------------------------------------"});
                    }

                    int vip = this.player.baseDataManager.getVip();
                    int add = 0;
                    if (vip > 0) {
                        add = ((CardCO) GameData.Cards.get(Integer.valueOf(vip))).prv7;
                    }

                    int lastBuyNum = prop.buyTimes - hasBuyNum + add;


                    item.setLastcount(lastBuyNum);
                }

                if (prop.countDown == 1) {
                    item.setCountdown(prop.periodEndDate.getTime());
                }
                mallTab.addItems(item);
            }
            list.add(mallTab.build());
        }

        return list;
    }


    public void refreshNewDay() {
        this.intergalMallPO.hasBuyItem.clear();
    }
}


