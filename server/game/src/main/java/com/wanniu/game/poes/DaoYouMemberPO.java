package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;

import java.util.Date;
import java.util.Map;

public class DaoYouMemberPO extends GEntity {
    @DBField(isPKey = true, fieldType = "varchar", size = 50)
    public String playerId;

    public String daoYouId;

    public int totalSendRebate;

    public Map<String, Integer> todaySendRebate;

    public int totalReciveRebate;

    public int todayReciveRebate;

    public Date joinTime;

    public Date createTime;

    public Date updateTime;
}


