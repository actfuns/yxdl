package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.ext.DropListExt;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@DBTable("player_demon_tower_center")
public final class DemonTowerCenterPO
        extends GEntity {
    public List<String> firstPlayerIds = new LinkedList<>();
    public List<Date> firstPlayerDates = new LinkedList<>();
    public List<String> fastPlayerIds = new LinkedList<>();
    public List<Long> fastPlayerTimes = new LinkedList<>();

    public DemonTowerCenterPO() {
        for (DropListExt dropListExt : GameData.DropLists.values()) {
            this.firstPlayerIds.add(null);
            this.firstPlayerDates.add(null);
            this.fastPlayerIds.add(null);
            this.fastPlayerTimes.add(null);
        }
    }
}


