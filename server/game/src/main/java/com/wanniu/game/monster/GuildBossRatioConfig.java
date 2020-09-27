package com.wanniu.game.monster;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GuildBossRatioCO;
import com.wanniu.game.data.ext.InspireLevelExt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class GuildBossRatioConfig {
    public static Map<Integer, GuildBossRatioCO> monsterProps = new HashMap<>();
    public static Map<String, InspireLevelExt> inspires = new HashMap<>();

    public static void loadScript() {
        monsterProps.putAll(GameData.GuildBossRatios);
        loadInspire();
    }

    private static void loadInspire() {
        Map<String, InspireLevelExt> tpInspires = new HashMap<>();
        Map<Integer, InspireLevelExt> inspireLevels = GameData.InspireLevels;
        Set<Map.Entry<Integer, InspireLevelExt>> sets = inspireLevels.entrySet();
        for (Map.Entry<Integer, InspireLevelExt> e : sets) {
            InspireLevelExt co = e.getValue();
            String key = co.inspireType + "_" + co.inspireNum;
            tpInspires.put(key, co);
        }

        for (Map.Entry<Integer, InspireLevelExt> e : sets) {
            InspireLevelExt co = e.getValue();
            int num = co.inspireNum;
            int lastnum = num - 1;
            String key = co.inspireType + "_" + co.inspireNum;
            InspireLevelExt currentExt = tpInspires.get(key);
            currentExt.totalInspirePlus = currentExt.inspirePlus * 100;
            if (lastnum > 0) {
                String lastKey = co.inspireType + "_" + lastnum;
                InspireLevelExt lastExt = tpInspires.get(lastKey);
                currentExt.totalInspirePlus += lastExt.totalInspirePlus;
            }
        }
        inspires = tpInspires;
    }

    public static GuildBossRatioCO getGuildBossRatioCO(int level) {
        return monsterProps.get(Integer.valueOf(level));
    }

    public static InspireLevelExt getInspireLevelCO(int type, int num) {
        String key = type + "_" + num;
        return inspires.get(key);
    }
}


