package com.wanniu.game.guild.guildBoss;

import com.wanniu.game.poes.GuildPO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GuildBossCenter {
    private Map<String, String> hasEnterGuildIds = new ConcurrentHashMap<>();
    private boolean isOpen = false;
    private long beginTime;

    public boolean isOpen() {
        return this.isOpen;
    }

    public void onBegin() {
        this.isOpen = true;
        this.beginTime = System.currentTimeMillis();
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public void onOver() {
        this.isOpen = false;
    }

    public void addOneGuildId(String guildId, String instanceId, GuildPO po) {
        synchronized (po) {
            this.hasEnterGuildIds.put(guildId, instanceId);
        }
    }

    public void removeOneGuildId(String guildId, GuildPO po) {
        synchronized (po) {
            this.hasEnterGuildIds.remove(guildId);
        }
    }

    public String getGuildBossScenceIdByGuildId(String guildId, GuildPO po) {
        synchronized (po) {
            return this.hasEnterGuildIds.get(guildId);
        }
    }

    public String getGuildBossScenceIdByGuildIdNoLock(String guildId) {
        return this.hasEnterGuildIds.get(guildId);
    }

    public Map<String, String> getHasEnterGuildIds() {
        return this.hasEnterGuildIds;
    }

    public void clear() {
        this.hasEnterGuildIds.clear();
    }


    private static class GuildBossCenterHolder {
        public static final GuildBossCenter INSTANCE = new GuildBossCenter();
    }

    public static GuildBossCenter getInstance() {
        return GuildBossCenterHolder.INSTANCE;
    }

    private GuildBossCenter() {
    }
}


