package com.wanniu.game.daoyou;

import com.wanniu.game.data.AllyConfigCO;
import com.wanniu.game.data.GameData;


public class AllyConfiguration {
    public static AllyConfiguration getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static AllyConfiguration instance = new AllyConfiguration();
    }


    private AllyConfiguration() {
    }


    public int getConfigI(String key) {
        return Integer.valueOf(getConfigS(key)).intValue();
    }


    public String getConfigS(String key) {
        return ((AllyConfigCO) GameData.AllyConfigs.get(key)).paramValue;
    }
}


