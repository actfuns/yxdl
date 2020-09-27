package com.wanniu.game.guild.guidDepot;

import com.wanniu.game.item.po.PlayerItemPO;

import java.util.HashMap;
import java.util.Map;


public class GuildBagItem {
    public int bagGridCount;
    public Map<Integer, PlayerItemPO> bagGrids = new HashMap<>();
    public int bagTotalCount;
}


