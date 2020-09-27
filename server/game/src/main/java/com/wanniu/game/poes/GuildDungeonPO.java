package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.guild.guildDungeon.GuildDungeonRecord;
import com.wanniu.game.guild.guildDungeon.GuildDungeonThrowInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pomelo.guild.GuildManagerHandler;


public class GuildDungeonPO
        extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String id = "";
    public int openTimesToday;
    public int openState;
    public Date dungeonPassedTime = new Date(0L);
    public int bReward;
    public int currPassedCount;
    public int totalPassedCount;
    public Date openTime = new Date(0L);
    public Map<Integer, GuildDungeonRecord> dungeonRecord = new HashMap<>();
    public String instanceId = "";
    public String serverId = "";
    public ArrayList<GuildDungeonThrowInfo> throwInfo = new ArrayList<>();
    public Map<Integer, ArrayList<String>> damagePlayer = new HashMap<>();
    public ArrayList<GuildManagerHandler.RankInfo> damageRankInfo = new ArrayList<>();
    public ArrayList<GuildManagerHandler.RankInfo> healRankInfo = new ArrayList<>();
    public int enterState;
}


