package com.wanniu.game.guild.guidDepot;

import com.wanniu.game.poes.GuildDepotPO;

import java.util.ArrayList;

import pomelo.guild.GuildManagerHandler;
import pomelo.item.ItemOuterClass;


public class PlayerGuildDepot {
    public GuildDepotPO depotInfo = new GuildDepotPO();
    public GuildManagerHandler.BagGridsInfo bagInfo = GuildManagerHandler.BagGridsInfo.newBuilder().build();
    public ArrayList<ItemOuterClass.ItemDetail> detailInfo = new ArrayList<>();
}


