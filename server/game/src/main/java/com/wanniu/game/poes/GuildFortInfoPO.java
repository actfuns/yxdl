package com.wanniu.game.poes;

public class GuildFortInfoPO {
    public int attendTimes;
    public int winTimes;

    public float getWinRate() {
        if (this.attendTimes <= 0) {
            return 0.0F;
        }

        return (this.winTimes / this.attendTimes * 100);
    }

    public void onStat(boolean isWin) {
        this.attendTimes++;
        if (isWin)
            this.winTimes++;
    }
}


