/*     */ package com.wanniu.game.rank.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossCenter;
/*     */ import com.wanniu.game.guild.guildBoss.GuildBossService;
/*     */ import com.wanniu.game.guild.guildBoss.RankBean;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardProto;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*     */ import com.wanniu.game.rank.AbstractPlayerRankHandler;
/*     */ import com.wanniu.game.rank.RankType;
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
/*     */ public class GuildBossRankSingleHandler
/*     */   extends AbstractPlayerRankHandler
/*     */ {
/*  41 */   public static GuildBossRankSingleHandler instance = new GuildBossRankSingleHandler();
/*     */ 
/*     */   
/*     */   public String getRedisKey(int logicServerId, int season) {
/*  45 */     return RankType.GUILD_BOSS_SINGLE.getRedisKey(logicServerId, season) + "/today";
/*     */   }
/*     */ 
/*     */   
/*     */   public void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/*  50 */     contents.add(String.valueOf(player.getLevel()));
/*  51 */     contents.add(String.valueOf(player.getFightPower()));
/*  52 */     contents.add(player.getGuildName());
/*  53 */     contents.add(String.valueOf(score));
/*     */   }
/*     */ 
/*     */   
/*     */   public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
/*  58 */     LeaderBoardProto result = new LeaderBoardProto();
/*  59 */     List<RankBean> worldRanks = null;
/*  60 */     if (GuildBossCenter.getInstance().isOpen()) {
/*  61 */       worldRanks = GuildBossService.getInstance().getWorldSingleRank();
/*     */     } else {
/*  63 */       String key = getRedisKey(GWorld.__SERVER_ID);
/*  64 */       String vl = GCache.get(key);
/*  65 */       if (vl != null) {
/*  66 */         worldRanks = JSONObject.parseArray(vl, RankBean.class);
/*     */       }
/*     */     } 
/*  69 */     if (worldRanks != null && !worldRanks.isEmpty()) {
/*  70 */       int rank = 1;
/*  71 */       for (RankBean bean : worldRanks) {
/*  72 */         LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getId(), bean.getHurt(), rank);
/*  73 */         if (build == null) {
/*     */           continue;
/*     */         }
/*  76 */         rank++;
/*  77 */         result.s2c_lists.add(build);
/*     */         
/*  79 */         if (selfId.equals(bean.getId())) {
/*  80 */           result.s2c_myData = build;
/*     */         }
/*     */       } 
/*     */     } 
/*  84 */     return result;
/*     */   }
/*     */   
/*     */   public void delRankMember(int serverId, String memberId) {
/*  88 */     boolean hasChanged = false;
/*  89 */     List<RankBean> worldRanks = getDataList();
/*  90 */     if (worldRanks != null) {
/*  91 */       for (RankBean bean : worldRanks) {
/*  92 */         if (bean.getId().equals(memberId)) {
/*  93 */           worldRanks.remove(bean);
/*  94 */           hasChanged = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  98 */       if (hasChanged) {
/*  99 */         putStaticData(worldRanks);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<RankBean> getDataList() {
/* 105 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 106 */     String vl = GCache.get(key);
/* 107 */     if (!StringUtil.isEmpty(vl)) {
/* 108 */       return JSONObject.parseArray(vl, RankBean.class);
/*     */     }
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putStaticData(List<RankBean> worldRanks) {
/* 119 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 120 */     String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
/* 121 */     GCache.put(key, strVL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(WNPlayer player, Object... value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossRankSingleHandler getInstance() {
/* 132 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\GuildBossRankSingleHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */