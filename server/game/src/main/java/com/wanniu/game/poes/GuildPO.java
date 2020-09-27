package com.wanniu.game.poes;

import com.alibaba.fastjson.annotation.JSONField;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.guild.GuildAllBlob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GuildPO
        extends GEntity {
    public Map<Integer, String> officeNames = new HashMap<>();
    public GuildAllBlob allBlobData = new GuildAllBlob();
    public Date changeNameTime = new Date(0L);
    public Date kickTime = new Date(0L);


    public GuildFortInfoPO getFortInfo() {
        synchronized (this) {
            if (this.fortInfo == null) {
                this.fortInfo = new GuildFortInfoPO();
            }
        }

        return this.fortInfo;
    }

    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String id;
    public int logicServerId;
    public String icon;
    public String name;
    public int level;
    public String presidentId;
    public int presidentPro;
    public String presidentName;
    public String qqGroup;
    public long fund;
    public long sumFund;
    public long exp;
    public int entryLevel;
    public int entryUpLevel;
    public int guildMode;
    public String notice;
    public String logicName;
    public String jobName;
    public int job;
    public Date createTime;
    public int kickCount;
    public InspirePO inspire;
    public InspirePO defInspire;
    public GuildFortInfoPO fortInfo;
    @JSONField(serialize = false)
    @DBField(include = false)
    public boolean modify;
    public int auctionBonus;
}


