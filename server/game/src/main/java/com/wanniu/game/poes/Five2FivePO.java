package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;

@DBTable("player_five2five")
public class Five2FivePO extends GEntity {
    public int score;

    public int winCount;

    public int tieCount;

    public int failCount;

    public int mvpCount;

    public int canReciveRewardCount;

    public Date lastChallengeTime;

    public int hasReciveRewardCount;

    public Date lastReciveRewardTime;

    public Date createTime;

    public Date updateTime;
}


