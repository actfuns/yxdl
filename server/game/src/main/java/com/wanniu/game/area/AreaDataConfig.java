package com.wanniu.game.area;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MapBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class AreaDataConfig {
    private static AreaDataConfig instance;
    public Map<Integer, MapBase> allMaps;

    public static AreaDataConfig getInstance() {
        if (instance == null) {
            instance = new AreaDataConfig();
        }
        return instance;
    }


    private AreaDataConfig() {
        this.allMaps = new HashMap<>();
        this.allMaps.putAll(GameData.GameMaps);
        this.allMaps.putAll(GameData.DungeonMaps);
        this.allMaps.putAll(GameData.NormalMaps);
    }

    public final MapBase get(int mapId) {
        return this.allMaps.get(Integer.valueOf(mapId));
    }


    public final List<MapBase> find(Predicate<MapBase> pre) {
        List<MapBase> list = new ArrayList<>();
        for (MapBase map : this.allMaps.values()) {
            if (pre.test(map)) {
                list.add(map);
            }
        }
        return list;
    }

    public final void foreach(Predicate<MapBase> pre) {
        for (MapBase map : this.allMaps.values())
            pre.test(map);
    }
}


