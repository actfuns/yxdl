package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.common.Const;
import com.wanniu.game.guild.guildTech.GuildTechSkill;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@DBTable("player_guild")
public class PlayerGuildPO
        extends GEntity {
    public Map<String, Integer> totalContributionMap = new HashMap<>();
    public Map<Integer, Integer> contributeTimesMap = new HashMap<>();
    public Date lastSelfExitTime = new Date(0L);
    public Date joinDungeonTime = new Date(0L);
    public Date refreshTime = new Date(0L);
    public List<Integer> buffIds = new ArrayList<>();
    public int[] blessRecState = new int[3];

    public PlayerGuildPO() {
        for (int i = 0; i < this.blessRecState.length; i++) {
            this.blessRecState[i] = Const.EVENT_GIFT_STATE.NOT_RECEIVE.getValue();
        }
        this.skills = new HashMap<>();
        this.boughtList = new ArrayList<>();
    }

    public int contribution;
    public int depositCount;
    public int blessCount;
    public String joinDungeonGuildId;
    public int buffTime;
    public Map<Integer, GuildTechSkill> skills;
    public List<Integer> boughtList;
}


