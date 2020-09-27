package com.wanniu.game.solo.vo;

import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.WNPlayer;

public class MatcherVO {
    private WNPlayer player;
    private int score;
    private boolean isOnline;
    private long beginTime;
    private int scoreRange;
    private long offlineTime;
    private boolean markedDel;

    public boolean isMarkedDel() {
        return this.markedDel;
    }

    public void setMarkedDel(boolean markedDel) {
        this.markedDel = markedDel;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long beginTimeMills) {
        this.beginTime = beginTimeMills;
    }

    public MatcherVO(int score, WNPlayer player) {
        this.player = player;
        this.score = score;
        this.isOnline = true;
        this.beginTime = System.currentTimeMillis();
        this.scoreRange = GlobalConfig.Solo_MatchRangeIncrease;
        this.offlineTime = 0L;
    }

    public WNPlayer getPlayer() {
        return this.player;
    }


    public void increaseScoreRange() {
        this.scoreRange += GlobalConfig.Solo_MatchRangeIncrease;
    }


    public int getMinScore() {
        return (this.score - this.scoreRange < 0) ? 0 : (this.score - this.scoreRange);
    }


    public int getMaxScore() {
        return this.score + this.scoreRange;
    }

    public int getScoreRange() {
        return this.scoreRange;
    }

    public String getPlayerId() {
        return this.player.getId();
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public boolean isOnline() {
        return this.isOnline;
    }


    public void setOnline() {
        this.isOnline = true;
        this.offlineTime = 0L;
    }


    public void setOffline() {
        this.isOnline = false;
        this.offlineTime = System.currentTimeMillis();
    }


    public int getOfflinedTime() {
        if (this.offlineTime == 0L) {
            return 0;
        }
        return (int) (System.currentTimeMillis() - this.offlineTime) / 1000;
    }

    public int getWaitTime() {
        return (int) (System.currentTimeMillis() - this.beginTime) / 1000;
    }
}


