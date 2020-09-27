package com.wanniu.game.fightLevel.po;


public class OutputStatistics {
    private String id;
    private String name;
    private long hurt;
    private long cure;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHurt() {
        return this.hurt;
    }

    public void setHurt(long hurt) {
        this.hurt = hurt;
    }

    public long getCure() {
        return this.cure;
    }

    public void setCure(long cure) {
        this.cure = cure;
    }
}


