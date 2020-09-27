package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;


@DBTable("player_guild_boss")
public class GuildBossPo
        extends GEntity {
    public InspirePO inspire = new InspirePO();
    public int hasPoint = 0;
    public Date pointDate = new Date();
    public int aucpoint = 0;
    public Date aucpointDate = new Date();
}


