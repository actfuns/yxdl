/*     */ package com.wanniu.game.rank.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.guild.GuildServiceCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossAreaHurtRankCenter;
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
/*     */ public class GuildBossPreRankGuildHandler
/*     */   extends AbstractGuildRankHandler
/*     */ {
/*  41 */   public static GuildBossPreRankGuildHandler instance = new GuildBossPreRankGuildHandler();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putStaticData(List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks) {
/*  49 */     String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
/*  50 */     String key = getRedisKey(GWorld.__SERVER_ID);
/*  51 */     GCache.put(key, strVL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank, GuildBossAreaHurtRankCenter.GuildStaticRankBean bean) {
/*  59 */     LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();
/*     */     
/*  61 */     GuildPO guild = GuildServiceCenter.getInstance().getGuild(memberId);
/*  62 */     if (null == guild) {
/*  63 */       return null;
/*     */     }
/*     */     
/*  66 */     List<String> contents = new ArrayList<>(7);
/*  67 */     contents.add(String.valueOf(rank));
/*  68 */     contents.add(memberId);
/*  69 */     contents.add(guild.icon);
/*  70 */     contents.add(guild.name);
/*  71 */     contents.add(String.valueOf(guild.level));
/*  72 */     contents.add(String.valueOf(bean.getTotalHurt()));
/*  73 */     contents.add(String.valueOf(bean.getSeconds()));
/*  74 */     builder.addAllContents(contents);
/*  75 */     return builder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
/*  80 */     String key = getRedisKey(GWorld.__SERVER_ID);
/*  81 */     String vl = GCache.get(key);
/*  82 */     int rank = 1;
/*  83 */     LeaderBoardProto result = new LeaderBoardProto();
/*  84 */     if (vl != null) {
/*  85 */       List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
/*  86 */       for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
/*  87 */         LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getGuildId(), bean.getTotalHurt(), rank, bean);
/*  88 */         if (build == null) {
/*     */           continue;
/*     */         }
/*  91 */         rank++;
/*  92 */         result.s2c_lists.add(build);
/*     */         
/*  94 */         if (selfId.equals(bean.getGuildId())) {
/*  95 */           result.s2c_myData = build;
/*     */         }
/*     */       } 
/*     */     } 
/*  99 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void delRankMember(int serverId, String memberId) {
/* 104 */     String key = getRedisKey(serverId);
/* 105 */     String vl = GCache.get(key);
/* 106 */     boolean hasChanged = false;
/* 107 */     if (!StringUtil.isEmpty(vl)) {
/* 108 */       List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> worldRanks = JSONObject.parseArray(vl, GuildBossAreaHurtRankCenter.GuildStaticRankBean.class);
/* 109 */       for (GuildBossAreaHurtRankCenter.GuildStaticRankBean bean : worldRanks) {
/* 110 */         if (bean.getGuildId().equals(memberId)) {
/* 111 */           worldRanks.remove(bean);
/* 112 */           hasChanged = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 116 */       if (hasChanged) {
/* 117 */         putStaticData(worldRanks);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(WNPlayer player, Object... value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getRedisKey(int logicServerId, int season) {
/* 129 */     return RankType.GUILD_BOSS_GUILD.getRedisKey(logicServerId, season) + "/preday";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossPreRankGuildHandler getInstance() {
/* 135 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\GuildBossPreRankGuildHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */