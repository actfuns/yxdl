package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;


@DBTable("player_arena_data")
public class ArenaDataPO
        extends GEntity {
    public int usedDefTimes = 0;
    public int singleReward = 0;
    public int totalReward = 0;

    public int score = 0;
    public int combo = 0;
    public int comboDaily = 0;
    public int scoreMonth = 0;

    public int killDaily = 0;
    public int killMonth = 0;
    public int deadMonth = 0;

    public int singleWinTimes = 0;
    public long firstSingleWinTime = 0L;
    public long activityTime;
    public int season;
    public String arenaInstanceId;
}


