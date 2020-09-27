package com.wanniu.game.guild.guildBoss;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class RankBean {
    private String id;
    private long hurt;
    private transient Map<Integer, Long> newHurtMap = new HashMap<>();
    private transient int rank;
    private transient int guildRank;

    public int getGuildRank() {
        return this.guildRank;
    }

    public void setGuildRank(int guildRank) {
        this.guildRank = guildRank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setNewData(int enterCount, long hurt) {
        this.newHurtMap.put(Integer.valueOf(enterCount), Long.valueOf(hurt));
    }

    public void reset() {
        long tp = 0L;
        Collection<Long> cols = this.newHurtMap.values();
        for (Iterator<Long> iterator = cols.iterator(); iterator.hasNext(); ) {
            long hp = ((Long) iterator.next()).longValue();
            tp += hp;
        }

        this.hurt = tp;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getHurt() {
        return this.hurt;
    }

    public void setHurt(long hurt) {
        this.hurt = hurt;
    }
}


