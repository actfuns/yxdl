package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.rank.TitleManager;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_title")
public final class TitlePO
        extends GEntity {
    public int selectedRankId;
    public Map<Integer, TitleManager.AwardRankData> awardRanks = new HashMap<>();
}


