package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_daily")
public final class DailyActivityPO
        extends GEntity {
    public Map<Integer, DailyInfo> activeMap = new HashMap<>();
    public Map<Integer, DailyRewardInfo> rewards = new HashMap<>();
    public int totalDegree;

    public static class DailyInfo {
        public int id;
        public int process;
    }

    public static class DailyRewardInfo {
        public int id;
        public int state;
    }
}


