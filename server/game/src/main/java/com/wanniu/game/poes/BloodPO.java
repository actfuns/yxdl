package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.DBTable;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_blood")
public final class BloodPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String playerId = null;
    public Map<Integer, Integer> equipedMap = new HashMap<>();

    public BloodPO(String playerId) {
        this();
        this.playerId = playerId;
    }

    public BloodPO() {
    }
}


