/*     */ package com.wanniu.game.guild.dao;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.db.ModifyDataType;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.common.Utils;
/*     */ import com.wanniu.game.guild.GuildCommonUtil;
/*     */ import com.wanniu.game.guild.guidDepot.GuildAuctionLog;
/*     */ import com.wanniu.game.guild.guidDepot.GuildRecordData;
/*     */ import com.wanniu.game.poes.GuildDungeonPO;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.redis.GameDao;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import redis.clients.jedis.Jedis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildDao
/*     */ {
/*  36 */   public static final Map<String, GuildPO> GuildMap = new ConcurrentHashMap<>();
/*  37 */   public static final Map<String, String> GuildNameMap = new ConcurrentHashMap<>();
/*  38 */   public static final Map<String, List<GuildRecordData>> GuildNewsMap = new ConcurrentHashMap<>();
/*  39 */   public static final Map<String, List<GuildAuctionLog>> GuildAuctionLogMap = new ConcurrentHashMap<>();
/*     */   
/*  41 */   public static ScheduledFuture<?> future = null;
/*     */   
/*     */   public static void init() {
/*  44 */     List<GuildPO> guilds = GuildCommonUtil.hgetAll(ConstsTR.guildTR, GuildPO.class);
/*  45 */     for (GuildPO guild : guilds) {
/*  46 */       if (!GWorld.sids.contains(Integer.valueOf(guild.logicServerId))) {
/*     */         continue;
/*     */       }
/*  49 */       GuildMap.put(guild.id, guild);
/*  50 */       GuildNameMap.put(guild.name, guild.id);
/*     */     } 
/*  52 */     future = GSystem.addFixedRateJob(() -> checkModifyGuild(), 30000L, 30000L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onCloseGame() {
/*  58 */     if (future != null) {
/*  59 */       future.cancel(true);
/*     */     }
/*  61 */     checkModifyGuild();
/*     */   }
/*     */   
/*     */   public static void checkModifyGuild() {
/*  65 */     for (GuildPO guild : GuildMap.values()) {
/*  66 */       if (guild.modify) {
/*     */         try {
/*  68 */           guild.modify = false;
/*  69 */           GCache.hset(ConstsTR.guildTR.value, guild.id, Utils.serialize(guild));
/*  70 */           GameDao.updateToDB(ConstsTR.guildTR, guild.id, ModifyDataType.MAP);
/*  71 */         } catch (Exception e) {
/*  72 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static GuildPO getGuild(String id) {
/*  79 */     return GuildMap.get(id);
/*     */   }
/*     */   
/*     */   public static List<GuildPO> getGuildList(int logicServerId, String name) {
/*  83 */     List<GuildPO> list = new ArrayList<>();
/*  84 */     for (GuildPO guild : GuildMap.values()) {
/*  85 */       if (!GWorld.sids.contains(Integer.valueOf(guild.logicServerId))) {
/*     */         continue;
/*     */       }
/*  88 */       if (StringUtil.isNotEmpty(name) && guild.name.indexOf(name) == -1) {
/*     */         continue;
/*     */       }
/*  91 */       list.add(guild);
/*     */     } 
/*  93 */     return list;
/*     */   }
/*     */   
/*     */   public static Collection<GuildPO> getAllGuild() {
/*  97 */     return GuildMap.values();
/*     */   }
/*     */   
/*     */   public static void updateGuild(GuildPO data) {
/* 101 */     GuildMap.put(data.id, data);
/* 102 */     GuildNameMap.put(data.name, data.id);
/* 103 */     data.modify = true;
/*     */   }
/*     */   
/*     */   public static void removeGuild(GuildPO data) {
/* 107 */     GuildMap.remove(data.id);
/* 108 */     GuildNameMap.remove(data.name);
/* 109 */     GuildNewsMap.remove(data.id);
/* 110 */     GuildAuctionLogMap.remove(data.id);
/*     */     
/* 112 */     GCache.hremove(ConstsTR.guildTR.value, data.id);
/* 113 */     GCache.hremove(ConstsTR.guildNewsTR.value, data.id);
/* 114 */     GCache.hremove(ConstsTR.guildAuctionLogTR.value, data.id);
/* 115 */     GCache.hremove(ConstsTR.guildDepotTR.value, data.id);
/* 116 */     GCache.hremove(ConstsTR.guildBlessTR.value, data.id);
/* 117 */     GameDao.delToDB(ConstsTR.guildDepotTR, data.id);
/* 118 */     GameDao.delToDB(ConstsTR.guildBlessTR, data.id);
/* 119 */     GameDao.delToDB(ConstsTR.guildTR, data.id);
/*     */ 
/*     */     
/* 122 */     RankType.GUILD_LEVEL.getHandler().delRankMember(GWorld.__SERVER_ID, data.id);
/* 123 */     RankType.GUILD_BOSS_GUILD.getHandler().delRankMember(GWorld.__SERVER_ID, data.id);
/*     */   }
/*     */   
/*     */   public static List<GuildRecordData> getGuildNews(String guildId) {
/* 127 */     List<GuildRecordData> news = GuildNewsMap.get(guildId);
/* 128 */     if (news == null) {
/* 129 */       String data = GCache.hget(ConstsTR.guildNewsTR.value, guildId);
/* 130 */       news = StringUtil.isNotEmpty(data) ? JSON.parseArray(data, GuildRecordData.class) : new ArrayList<>();
/* 131 */       GuildNewsMap.put(guildId, news);
/*     */     } 
/* 133 */     return news;
/*     */   }
/*     */   
/*     */   public static void saveGuildNews(String guildId) {
/* 137 */     List<GuildRecordData> news = GuildNewsMap.get(guildId);
/* 138 */     if (news != null) {
/* 139 */       GCache.hset(ConstsTR.guildNewsTR.value, guildId, JSON.toJSONString(news));
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getGuildIdByName(String name) {
/* 144 */     return GuildNameMap.get(name);
/*     */   }
/*     */   
/*     */   public static void removeGuildNameIndex(String name) {
/* 148 */     GuildNameMap.remove(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GuildDungeonPO getGuildDungeon(String id) {
/* 153 */     GuildDungeonPO data = (GuildDungeonPO)GuildCommonUtil.hget(ConstsTR.guildDungeonTR, id, GuildDungeonPO.class);
/* 154 */     if (null != data) {
/* 155 */       return data;
/*     */     }
/*     */     
/* 158 */     GuildDungeonPO dungeonInfo = new GuildDungeonPO();
/* 159 */     dungeonInfo.id = id;
/* 160 */     dungeonInfo.openTimesToday = 0;
/* 161 */     dungeonInfo.openState = 0;
/* 162 */     dungeonInfo.currPassedCount = 0;
/* 163 */     dungeonInfo.totalPassedCount = 0;
/* 164 */     dungeonInfo.dungeonPassedTime = new Date();
/* 165 */     dungeonInfo.openTime = new Date();
/* 166 */     dungeonInfo.dungeonRecord = new HashMap<>();
/* 167 */     dungeonInfo.instanceId = "";
/* 168 */     dungeonInfo.serverId = "";
/* 169 */     dungeonInfo.throwInfo = new ArrayList();
/* 170 */     dungeonInfo.damagePlayer = new HashMap<>();
/* 171 */     dungeonInfo.damageRankInfo = new ArrayList();
/* 172 */     dungeonInfo.healRankInfo = new ArrayList();
/*     */     
/* 174 */     return dungeonInfo;
/*     */   }
/*     */   
/*     */   public static void updateGuildDungeon(GuildDungeonPO data) {
/* 178 */     GCache.hset(ConstsTR.guildDungeonTR.value, data.id, Utils.serialize(data));
/*     */   }
/*     */   
/*     */   public static void updateGuildDungeonToRedis(Jedis redis, GuildDungeonPO data) {
/* 182 */     redis.hset(ConstsTR.guildDungeonTR.value, data.id, Utils.serialize(data));
/*     */   }
/*     */   
/*     */   public ArrayList<GuildDungeonPO> getAllGuildDungeon() {
/*     */     try {
/* 187 */       return GuildCommonUtil.hgetAll(ConstsTR.guildDungeonTR, GuildDungeonPO.class);
/* 188 */     } catch (Exception e) {
/* 189 */       Out.error(new Object[] { e });
/* 190 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<GuildAuctionLog> getGuildAuctionLog(String guildId) {
/* 199 */     List<GuildAuctionLog> logs = GuildAuctionLogMap.get(guildId);
/* 200 */     if (logs == null) {
/* 201 */       String data = GCache.hget(ConstsTR.guildAuctionLogTR.value, guildId);
/* 202 */       logs = StringUtil.isNotEmpty(data) ? JSON.parseArray(data, GuildAuctionLog.class) : new ArrayList<>();
/* 203 */       GuildAuctionLogMap.put(guildId, logs);
/*     */     } 
/* 205 */     return logs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveGuildAuctionLog(String guildId) {
/* 212 */     List<GuildAuctionLog> logs = GuildAuctionLogMap.get(guildId);
/* 213 */     if (logs != null)
/* 214 */       GCache.hset(ConstsTR.guildAuctionLogTR.value, guildId, JSON.toJSONString(logs)); 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\dao\GuildDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */