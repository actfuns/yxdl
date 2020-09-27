package com.wanniu.game.intergalmall;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.IntergalShopBase;

import java.util.HashMap;
import java.util.Map;


public class IntergalMallConfig {
    public Map<Integer, Map<Integer, IntergalShopBase>> shopItems = new HashMap<>();

    private static IntergalMallConfig intergalMallConfig = null;

    private IntergalMallConfig() {
        this.shopItems.put(Integer.valueOf(1), new HashMap<>());
        this.shopItems.put(Integer.valueOf(2), new HashMap<>());
        this.shopItems.put(Integer.valueOf(3), new HashMap<>());
        this.shopItems.put(Integer.valueOf(4), new HashMap<>());
        this.shopItems.put(Integer.valueOf(5), new HashMap<>());
        ((Map) this.shopItems.get(Integer.valueOf(1))).putAll(GameData.SundryShops);
        ((Map) this.shopItems.get(Integer.valueOf(2))).putAll(GameData.MallShops);
        ((Map) this.shopItems.get(Integer.valueOf(3))).putAll(GameData.FateShops);
        ((Map) this.shopItems.get(Integer.valueOf(4))).putAll(GameData.AthleticShops);
        ((Map) this.shopItems.get(Integer.valueOf(5))).putAll(GameData.GuildShops);
    }

    public static IntergalMallConfig getInstance() {
        if (intergalMallConfig == null) {
            intergalMallConfig = new IntergalMallConfig();
        }
        return intergalMallConfig;
    }

    public IntergalShopBase getIntergalMallProp(int shopType, int itemId) {
        Map<Integer, IntergalShopBase> items = this.shopItems.get(Integer.valueOf(shopType));
        for (IntergalShopBase prop : items.values()) {
            if (prop.iD == itemId) {
                return prop;
            }
        }
        return null;
    }
}


