package com.wanniu.game.five2Five;

import java.util.concurrent.atomic.AtomicInteger;


public class Five2FiveTempTeamMember {
    public String playerId;
    public int playerPro;
    public int playerLvl;
    public String playerName;
    public int force;
    public int index;
    public AtomicInteger isReadyOrCancel = new AtomicInteger(0);
}


