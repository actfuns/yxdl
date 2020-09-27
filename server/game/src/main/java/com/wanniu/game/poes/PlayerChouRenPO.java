package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.friend.ChouRenData;

import java.util.HashMap;
import java.util.Map;


@DBTable("player_chouren")
public class PlayerChouRenPO
        extends GEntity {
    public Map<String, ChouRenData> chouRens = new HashMap<>();
}


