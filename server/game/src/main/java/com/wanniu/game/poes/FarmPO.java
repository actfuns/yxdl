package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.DBTable;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GetLandCO;
import com.wanniu.game.farm.FarmMgr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


@DBTable("player_farm")
public final class FarmPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String playerId;
    public int exp;
    public int lv;
    public Map<Integer, FarmMgr.Block> blockMap = new HashMap<>();
    public LinkedList<FarmMgr.RecordInfo> recordLs;

    public FarmPO() {
        for (GetLandCO getLandCO : GameData.GetLands.values()) {
            FarmMgr.Block block = new FarmMgr.Block(getLandCO.landNum);
            this.blockMap.put(Integer.valueOf(getLandCO.landNum), block);
        }

        this.recordLs = new LinkedList<>();


        this.shopToday = new HashMap<>();
    }

    public int stealCountToday;
    public Map<Integer, Integer> shopToday;

    public FarmPO(String playerId) {
        this();
        this.playerId = playerId;
    }
}


