package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.List;
import java.util.Map;

@DBTable("player_func_open")
public class FunctionOpenPO extends GEntity {
    public Map<String, Integer> openMap;

    public Map<String, Integer> playMap;

    public List<Integer> functionAwards;
}


