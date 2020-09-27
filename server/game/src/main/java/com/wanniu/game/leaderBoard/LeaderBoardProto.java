package com.wanniu.game.leaderBoard;

import java.util.ArrayList;
import java.util.List;

import pomelo.area.LeaderBoardHandler;


public class LeaderBoardProto {
    public List<LeaderBoardHandler.LeaderBoardData> s2c_lists = new ArrayList<>();
    public LeaderBoardHandler.LeaderBoardData s2c_myData = LeaderBoardHandler.LeaderBoardData.newBuilder().build();
}


