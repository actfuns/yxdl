package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.flee.FleeReportCO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@DBTable("player_flee")
public class FleePO
        extends GEntity {
    public int score;
    public Date seasonEndTime = new Date();


    public int grade = 1;


    public int maxGrade = 1;


    public int maxRank;


    public List<Integer> receiveGrades = new ArrayList<>();


    public List<FleeReportCO> reports = new ArrayList<>();
    public boolean isPlayed;
}


