package com.wanniu.game.shopMall;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.ExchangeMallExt;
import com.wanniu.game.data.ext.ShopMallItemsExt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ShopMallConfig {
    private static ShopMallConfig instance;
    private static List<ShopMallItemsExt> shopMallItems = new ArrayList<>();

    public static ShopMallConfig getInstance() {
        if (instance == null) {
            instance = new ShopMallConfig();

            for (ShopMallItemsExt item : GameData.ShopMallItemss.values()) {
                shopMallItems.add(item);
            }
            Collections.sort(shopMallItems, new Comparator<ShopMallItemsExt>() {
                public int compare(ShopMallItemsExt o1, ShopMallItemsExt o2) {
                    return o1.sort - o2.sort;
                }
            });
        }


        return instance;
    }


    public final ShopMallItemsExt fingShowMallItemByID(String id) {
        for (ShopMallItemsExt item : shopMallItems) {
            if (item.iD.equals(id)) {
                return item;
            }
        }

        return null;
    }

    public final ExchangeMallExt findExchangeMallItemByID(String id) {
        for (ExchangeMallExt exchangeMallExt : GameData.ExchangeMalls.values()) {
            if (exchangeMallExt.iD.equals(id)) {
                return exchangeMallExt;
            }
        }

        return null;
    }
}


