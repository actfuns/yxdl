package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;

import java.util.Date;

public class GuildMemberPO extends GEntity {
    @DBField(isPKey = true, fieldType = "char", size = 36)
    public String playerId;

    public String guildId;

    public String name;

    public int pro;

    public int job;

    public long lastContributeValue;

    public Date createTime;

    public Date lastContributeTime;
}


