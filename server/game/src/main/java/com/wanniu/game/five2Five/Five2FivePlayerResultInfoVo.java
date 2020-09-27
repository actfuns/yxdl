package com.wanniu.game.five2Five;


public class Five2FivePlayerResultInfoVo {
    public String playerId;
    public String playerName;
    public int playerLevel;
    public int playerPro;
    public int killCount;
    public int hurt;
    public int treatMent;
    public int isMvp;
    public int deadCount;
    public int resultA;

    public Five2FivePlayerResultInfoVo() {
    }

    public Five2FivePlayerResultInfoVo(String playerId, String playerName, int playerLevel, int playerPro, int killCount, int hurt, int treatMent, int isMvp, int deadCount) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerLevel = playerLevel;
        this.playerPro = playerPro;
        this.killCount = killCount;
        this.hurt = hurt;
        this.treatMent = treatMent;
        this.isMvp = isMvp;
        this.deadCount = deadCount;
    }
}


