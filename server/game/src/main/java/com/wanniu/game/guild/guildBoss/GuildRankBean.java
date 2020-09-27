package com.wanniu.game.guild.guildBoss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GuildRankBean {
    private String guildId;
    private long bossKillTime;
    private Map<String, RankBean> hurtMap = new HashMap<>();
    private List<RankBean> hurtList = new ArrayList<>();
    private boolean hasKilled = false;

    public boolean hasKilled() {
        return this.hasKilled;
    }

    public void setHasKilled(boolean hasKilled) {
        this.hasKilled = hasKilled;
    }

    public long getTotalHurt() {
        long total = 0L;
        if (this.hurtList != null && !this.hurtList.isEmpty()) {
            for (RankBean bean : this.hurtList) {
                total += bean.getHurt();
            }
        }
        return total;
    }

    public long getBossKillTime() {
        return this.bossKillTime;
    }

    public void setBossKillTime(long bossKillTime) {
        this.bossKillTime = bossKillTime;
    }

    public GuildRankBean(String guildId) {
        this.guildId = guildId;
        this.bossKillTime = -1L;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public void setRankBeanIfNull(RankBean bean) {
        RankBean tmBean = this.hurtMap.get(bean.getId());
        if (tmBean == null) {
            this.hurtMap.put(bean.getId(), bean);
            synchronized (this.hurtList) {
                this.hurtList.add(bean);
            }
        }
    }

    public List<RankBean> getHurtListWithLock() {
        synchronized (this.hurtList) {
            return new ArrayList<>(this.hurtList);
        }
    }

    public RankBean onlyGetRankBean(String playerId) {
        return this.hurtMap.get(playerId);
    }

    public List<RankBean> getHurtList() {
        return this.hurtList;
    }

    public void sort() {
        Collections.sort(this.hurtList, GuildBossAreaHurtRankCenter.SORT_HURT);
        for (int i = 0; i < this.hurtList.size(); i++) {
            RankBean bean = this.hurtList.get(i);
            bean.setGuildRank(i + 1);
        }
    }
}


