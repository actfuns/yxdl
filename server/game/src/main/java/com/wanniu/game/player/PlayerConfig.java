package com.wanniu.game.player;

import com.wanniu.game.data.GameData;
import com.wanniu.game.data.PrefixCO;
import com.wanniu.game.data.SuffixCO;
import com.wanniu.game.data.ext.UpLevelExpExt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlayerConfig {
    public List<PrefixCO> randomname_prefix = null;

    public Map<Integer, List<SuffixCO>> randomname_suffix;
    private static PlayerConfig instance;

    public static PlayerConfig getInstance() {
        if (instance == null) {
            instance = new PlayerConfig();
        }
        return instance;
    }


    private PlayerConfig() {
        this.randomname_prefix = new ArrayList<>(GameData.Prefixs.values());
        this.randomname_suffix = new HashMap<>();
        for (SuffixCO suffix : GameData.Suffixs.values()) {

            if (suffix.sex == 2) {
                ((List<SuffixCO>) this.randomname_suffix.computeIfAbsent(Integer.valueOf(0), key -> new ArrayList())).add(suffix);
                ((List<SuffixCO>) this.randomname_suffix.computeIfAbsent(Integer.valueOf(1), key -> new ArrayList())).add(suffix);
                continue;
            }
            ((List<SuffixCO>) this.randomname_suffix.computeIfAbsent(Integer.valueOf(suffix.sex), key -> new ArrayList())).add(suffix);
        }
    }


    public UpLevelExpExt findupLevelExpPropsByUpLevelAndPro(int upLevel, int pro) {
        GameData.findUpLevelExps(o ->
                (o.classUPLevel == upLevel && o.Pro == pro));

        return null;
    }
}


