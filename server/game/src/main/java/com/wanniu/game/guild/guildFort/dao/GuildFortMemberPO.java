/*     */ package com.wanniu.game.guild.guildFort.dao;
/*     */ 
/*     */ import com.alibaba.fastjson.annotation.JSONField;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildFortMemberPO
/*     */ {
/*  12 */   public Map<Integer, Integer> pickedItems = new HashMap<>();
/*  13 */   public int defBuffScore = 0;
/*     */   
/*  15 */   public Map<Integer, Integer> killedMonsters = new HashMap<>();
/*  16 */   public int attBuffScore = 0;
/*     */   
/*  18 */   public int killedPlayer = 0;
/*  19 */   public int killedFlag = 0;
/*  20 */   public int score = 0;
/*     */ 
/*     */   
/*  23 */   public Map<Integer, Long> fightHurts = new HashMap<>();
/*     */   
/*  25 */   public Map<Integer, Long> fightCures = new HashMap<>();
/*     */   
/*     */   public String playerName;
/*     */   
/*     */   public String playerId;
/*     */   
/*     */   public int playerLevel;
/*     */   public int guildJob;
/*     */   public String guildJobName;
/*     */   
/*     */   public GuildFortMemberPO() {}
/*     */   
/*     */   public GuildFortMemberPO(String playerId, String playerName, int playerLevel, int guildJob, String guildJobName) {
/*  38 */     this.playerId = playerId;
/*  39 */     this.playerName = playerName;
/*  40 */     this.playerLevel = playerLevel;
/*  41 */     this.guildJob = guildJob;
/*  42 */     this.guildJobName = guildJobName;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getPickItemNum() {
/*  47 */     int pickItemNum = 0;
/*  48 */     for (Integer num : this.pickedItems.values()) {
/*  49 */       pickItemNum += num.intValue();
/*     */     }
/*     */     
/*  52 */     return pickItemNum;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getKilledMonsterNum() {
/*  57 */     int killedMonsterNum = 0;
/*  58 */     for (Integer num : this.killedMonsters.values()) {
/*  59 */       killedMonsterNum += num.intValue();
/*     */     }
/*     */     
/*  62 */     return killedMonsterNum;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getKilledPlayerNum() {
/*  67 */     return this.killedPlayer;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getKilledFlagNum() {
/*  72 */     return this.killedFlag;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public long getFightHurt() {
/*  77 */     long sumHurt = 0L;
/*  78 */     for (Long hurt : this.fightHurts.values()) {
/*  79 */       sumHurt += hurt.longValue();
/*     */     }
/*     */     
/*  82 */     return sumHurt;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getDefBuffScore() {
/*  87 */     return this.defBuffScore;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getAttBuffScore() {
/*  92 */     return this.attBuffScore;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public int getScore() {
/*  97 */     return this.score;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public long getFightCure() {
/* 102 */     long sumHurt = 0L;
/* 103 */     for (Long hurt : this.fightCures.values()) {
/* 104 */       sumHurt += hurt.longValue();
/*     */     }
/*     */     
/* 107 */     return sumHurt;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onPickedItem(int itemId, int score) {
/* 112 */     addBeforePut(this.pickedItems, itemId, 1);
/* 113 */     this.defBuffScore += score;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onKilledMonster(int monsterId, int score) {
/* 118 */     addBeforePut(this.killedMonsters, monsterId, 1);
/* 119 */     this.attBuffScore += score;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onKilledPlayer(int score) {
/* 124 */     this.killedPlayer++;
/* 125 */     this.score += score;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onKilledFlag(int score) {
/* 130 */     this.killedFlag++;
/* 131 */     this.score += score;
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onFightHurt(long newHurt, int count) {
/* 136 */     this.fightHurts.put(Integer.valueOf(count), Long.valueOf(newHurt));
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void onFightCure(long newHurt, int count) {
/* 141 */     this.fightCures.put(Integer.valueOf(count), Long.valueOf(newHurt));
/*     */   }
/*     */   
/*     */   @JSONField(deserialize = false, serialize = false)
/*     */   public void addBeforePut(Map<Integer, Integer> data, int key, int value) {
/* 146 */     if (data.containsKey(Integer.valueOf(key))) {
/* 147 */       data.put(Integer.valueOf(key), Integer.valueOf(((Integer)data.get(Integer.valueOf(key))).intValue() + value));
/*     */     } else {
/* 149 */       data.put(Integer.valueOf(key), Integer.valueOf(value));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildFort\dao\GuildFortMemberPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */