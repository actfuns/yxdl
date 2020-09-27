package com.wanniu.game.guild.guildFort.dao;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;


public class GuildFortMemberPO {
    public Map<Integer, Integer> pickedItems = new HashMap<>();
    public int defBuffScore = 0;

    public Map<Integer, Integer> killedMonsters = new HashMap<>();
    public int attBuffScore = 0;

    public int killedPlayer = 0;
    public int killedFlag = 0;
    public int score = 0;


    public Map<Integer, Long> fightHurts = new HashMap<>();

    public Map<Integer, Long> fightCures = new HashMap<>();

    public String playerName;

    public String playerId;

    public int playerLevel;
    public int guildJob;
    public String guildJobName;

    public GuildFortMemberPO() {
    }

    public GuildFortMemberPO(String playerId, String playerName, int playerLevel, int guildJob, String guildJobName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerLevel = playerLevel;
        this.guildJob = guildJob;
        this.guildJobName = guildJobName;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getPickItemNum() {
        int pickItemNum = 0;
        for (Integer num : this.pickedItems.values()) {
            pickItemNum += num.intValue();
        }

        return pickItemNum;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getKilledMonsterNum() {
        int killedMonsterNum = 0;
        for (Integer num : this.killedMonsters.values()) {
            killedMonsterNum += num.intValue();
        }

        return killedMonsterNum;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getKilledPlayerNum() {
        return this.killedPlayer;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getKilledFlagNum() {
        return this.killedFlag;
    }

    @JSONField(deserialize = false, serialize = false)
    public long getFightHurt() {
        long sumHurt = 0L;
        for (Long hurt : this.fightHurts.values()) {
            sumHurt += hurt.longValue();
        }

        return sumHurt;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getDefBuffScore() {
        return this.defBuffScore;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getAttBuffScore() {
        return this.attBuffScore;
    }

    @JSONField(deserialize = false, serialize = false)
    public int getScore() {
        return this.score;
    }

    @JSONField(deserialize = false, serialize = false)
    public long getFightCure() {
        long sumHurt = 0L;
        for (Long hurt : this.fightCures.values()) {
            sumHurt += hurt.longValue();
        }

        return sumHurt;
    }

    @JSONField(deserialize = false, serialize = false)
    public void onPickedItem(int itemId, int score) {
        addBeforePut(this.pickedItems, itemId, 1);
        this.defBuffScore += score;
    }

    @JSONField(deserialize = false, serialize = false)
    public void onKilledMonster(int monsterId, int score) {
        addBeforePut(this.killedMonsters, monsterId, 1);
        this.attBuffScore += score;
    }

    @JSONField(deserialize = false, serialize = false)
    public void onKilledPlayer(int score) {
        this.killedPlayer++;
        this.score += score;
    }

    @JSONField(deserialize = false, serialize = false)
    public void onKilledFlag(int score) {
        this.killedFlag++;
        this.score += score;
    }

    @JSONField(deserialize = false, serialize = false)
    public void onFightHurt(long newHurt, int count) {
        this.fightHurts.put(Integer.valueOf(count), Long.valueOf(newHurt));
    }

    @JSONField(deserialize = false, serialize = false)
    public void onFightCure(long newHurt, int count) {
        this.fightCures.put(Integer.valueOf(count), Long.valueOf(newHurt));
    }

    @JSONField(deserialize = false, serialize = false)
    public void addBeforePut(Map<Integer, Integer> data, int key, int value) {
        if (data.containsKey(Integer.valueOf(key))) {
            data.put(Integer.valueOf(key), Integer.valueOf(((Integer) data.get(Integer.valueOf(key))).intValue() + value));
        } else {
            data.put(Integer.valueOf(key), Integer.valueOf(value));
        }
    }
}


