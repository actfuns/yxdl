package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.DBTable;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@DBTable("player_demon_tower")
public final class DemonTowerPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String playerId;
    public int maxFloor = 1;
    public int failedMapId;
    public Date firstTimeToPeak = new Date();
    public int sweepCountLeft;
    public Date sweepEndTime;
    public List<Long> leastTimeList = new LinkedList<>();

    public DemonTowerPO() {
    }

    public DemonTowerPO(String playerId, int currentFloor, int failedMapId, int sweepCountLeft) {
        this();
        this.playerId = playerId;
        this.maxFloor = currentFloor;
        this.failedMapId = 0;
        this.sweepCountLeft = sweepCountLeft;

        this.sweepEndTime = null;
    }
}


