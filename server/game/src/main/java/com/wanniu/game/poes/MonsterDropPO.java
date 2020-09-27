package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;


@DBTable("monster_drop_info")
public class MonsterDropPO
        extends GEntity {
    private int todayCount;

    public int getTodayCount() {
        return this.todayCount;
    }

    public void setTodayCount(int todayCount) {
        this.todayCount = todayCount;
    }

    public void clear() {
        this.todayCount = 0;
    }

    public void addBossCount() {
        this.todayCount++;
    }
}


