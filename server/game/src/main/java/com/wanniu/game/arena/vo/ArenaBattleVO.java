package com.wanniu.game.arena.vo;

import pomelo.area.ArenaHandler;

public class ArenaBattleVO {
    private String name;
    private int score;
    private int pro;
    private String id;
    private int killCount;
    private long updateTime = System.currentTimeMillis();
    private int force;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPro() {
        return this.pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKillCount() {
        return this.killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public ArenaHandler.ArenaBattleScore toBuilder(boolean isScore) {
        ArenaHandler.ArenaBattleScore.Builder builder = ArenaHandler.ArenaBattleScore.newBuilder();
        builder.setId(this.id);
        builder.setName(this.name);
        builder.setPro(this.pro);
        if (isScore) {
            builder.setScore(this.score);
        } else {
            builder.setScore(this.killCount);
        }

        return builder.build();
    }
}


