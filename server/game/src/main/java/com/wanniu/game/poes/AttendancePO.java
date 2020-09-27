package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;
import java.util.Map;

@DBTable("player_sign")
public final class AttendancePO extends GEntity {
    public int stage;

    public Date lastSignTime;

    public Date lastLuxuryTime;

    public int luxuryState;

    public Map<Integer, Integer> signMap;

    public Map<Integer, Integer> cumulativeMap;
}


