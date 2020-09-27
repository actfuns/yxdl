package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_online_data")
public class OnlineDataPO
        extends GEntity {
    public long sumTime;
    public Map<Integer, Integer> rewardState = new HashMap<>();
}


