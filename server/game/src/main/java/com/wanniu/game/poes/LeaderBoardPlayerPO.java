package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

import java.util.Date;

@DBTable("player_leaderboard")
public class LeaderBoardPlayerPO extends GEntity {
    public int worShipTimes;

    public Date worShipTime;

    public int worShipDiamondTimes;
}


