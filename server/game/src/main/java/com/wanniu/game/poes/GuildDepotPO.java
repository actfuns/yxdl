package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.guild.guidDepot.GuildBagItem;
import com.wanniu.game.guild.guidDepot.GuildDepotCondition;
import com.wanniu.game.guild.guidDepot.GuildRecordData;

import java.util.ArrayList;
import java.util.Date;


public class GuildDepotPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String id;
    public int logicServerId;
    public int level;
    public Date createTime;
    public GuildDepotCondition condition = new GuildDepotCondition();
    public ArrayList<GuildRecordData> news = new ArrayList<>();
    public GuildBagItem bag = new GuildBagItem();
    public Date refreshTime = new Date(0L);
    public int deleteCount;
    public int deleteCountMax;
}


