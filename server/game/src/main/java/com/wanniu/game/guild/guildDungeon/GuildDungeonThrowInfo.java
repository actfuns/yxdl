package com.wanniu.game.guild.guildDungeon;

import com.wanniu.game.item.po.PlayerItemPO;

import java.util.Map;

import pomelo.guild.GuildManagerHandler;

public class GuildDungeonThrowInfo {
    public PlayerItemPO dropItem;

    public int dungeonCount;

    public Map<String, GuildManagerHandler.DiceInfo> diceInfo;

    public String mostPointPlayerId;

    public String mostPointPlayerName;

    public int mostPointPlayerPro;

    public int mostPoint;
}


