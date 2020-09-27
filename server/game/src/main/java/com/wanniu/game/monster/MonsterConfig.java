package com.wanniu.game.monster;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.base.MonsterBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class MonsterConfig {
    private static MonsterConfig instance;

    public static MonsterConfig getInstance() {
        if (instance == null) {
            instance = new MonsterConfig();
        }
        return instance;
    }

    public Map<Integer, MonsterBase> monsterProps = new HashMap<>();

    public void loadScript() {
        this.monsterProps.putAll(GameData.Normal_Worlds);
        this.monsterProps.putAll(GameData.Dungeons);
        this.monsterProps.putAll(GameData.DemonTowers);
        this.monsterProps.putAll(GameData.Dungeon_Normals);
        this.monsterProps.putAll(GameData.Dungeon_Elites);
        this.monsterProps.putAll(GameData.Dungeon_Heros);
    }

    public MonsterBase get(int id) {
        return this.monsterProps.get(Integer.valueOf(id));
    }


    public List<MonsterBase> find(Predicate<MonsterBase> t) {
        List<MonsterBase> list = new ArrayList<>();
        for (MonsterBase m : this.monsterProps.values()) {
            if (t.test(m)) {
                list.add(m);
            }
        }
        return list;
    }
}


