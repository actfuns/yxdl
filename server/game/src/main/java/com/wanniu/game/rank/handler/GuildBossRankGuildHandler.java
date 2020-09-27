/*     */ package com.wanniu.game.rank.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossService;
/*     */ import com.wanniu.game.guild.guildBoss.GuildRankBean;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardProto;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import com.wanniu.game.rank.AbstractGuildRankHandler;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.area.LeaderBoardHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildBossRankGuildHandler
/*     */   extends AbstractGuildRankHandler
/*     */ {
/*  45 */   public static GuildBossRankGuildHandler instance = new GuildBossRankGuildHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putStaticData(List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks) {
/*  53 */     String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
/*  54 */     String key = getRedisKey(GWorld.__SERVER_ID);
/*  55 */     GCache.put(key, strVL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank, int seconds) {
/*  64 */     LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();
/*  65 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
/*  66 */     if (null == guild) {
/*  67 */       return null;
/*     */     }
/*  69 */     List<String> contents = new ArrayList<>(7);
/*  70 */     contents.add(String.valueOf(rank));
/*  71 */     contents.add(memberId);
/*  72 */     contents.add(guild.icon);
/*  73 */     contents.add(guild.name);
/*  74 */     contents.add(String.valueOf(guild.level));
/*  75 */     contents.add(String.valueOf(score));
/*  76 */     contents.add(String.valueOf(seconds));
/*  77 */     builder.addAllContents(contents);
/*  78 */     return builder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
/*  83 */     LeaderBoardProto result = new LeaderBoardProto();
/*  84 */     if (GuildBossCenter.getInstance().isOpen()) {
/*  85 */       List<GuildRankBean> worldRanks = GuildBossService.getInstance().getGuildRankSort();
/*  86 */       if (worldRanks != null && !worldRanks.isEmpty()) {
/*  87 */         int rank = 1;
/*  88 */         for (GuildRankBean bean : worldRanks) {
/*  89 */           int sec = 0;
/*  90 */           if (bean.hasKilled()) {
/*  91 */             sec = (int)((bean.getBossKillTime() - GuildBossCenter.getInstance().getBeginTime()) / 1000L);
/*     */           }
/*  93 */           LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, sec);
/*  94 */           if (build == null) {
/*     */             continue;
/*     */           }
/*  97 */           rank++;
/*  98 */           result.s2c_lists.add(build);
/*  99 */           if (selfId.equals(bean.getGuildId())) {
/* 100 */             result.s2c_myData = build;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 105 */       String key = getRedisKey(GWorld.__SERVER_ID);
/* 106 */       String vl = GCache.get(key);
/* 107 */       int rank = 1;
/* 108 */       if (vl != null) {
/* 109 */         List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
/* 110 */         for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
/* 111 */           LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, bean.getSeconds());
/* 112 */           if (build == null) {
/*     */             continue;
/*     */           }
/* 115 */           rank++;
/* 116 */           result.s2c_lists.add(build);
/* 117 */           if (selfId.equals(bean.getGuildId())) {
/* 118 */             result.s2c_myData = build;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 123 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void delRankMember(int serverId, String memberId) {
/* 128 */     boolean hasChanged = false;
/* 129 */     List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = getDataList();
/* 130 */     if (worldRanks != null && !worldRanks.isEmpty()) {
/* 131 */       for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
/* 132 */         if (bean.getGuildId().equals(memberId)) {
/* 133 */           worldRanks.remove(bean);
/* 134 */           hasChanged = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 138 */       if (hasChanged) {
/* 139 */         putStaticData(worldRanks);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> getDataList() {
/* 145 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 146 */     String vl = GCache.get(key);
/* 147 */     if (!StringUtil.isEmpty(vl)) {
/* 148 */       return JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(WNPlayer player, Object... value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getRedisKey(int logicServerId, int season) {
/* 160 */     return RankType.GUILD_BOSS_GUILD.getRedisKey(logicServerId, season) + "/today";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossRankGuildHandler getInstance() {
/* 166 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\GuildBossRankGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */