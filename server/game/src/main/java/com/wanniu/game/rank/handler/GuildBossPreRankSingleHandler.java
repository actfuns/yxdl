/*     */ package com.wanniu.game.rank.handler;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
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
/*     */ public class GuildBossPreRankSingleHandler
/*     */   extends AbstractPlayerRankHandler
/*     */ {
/*  39 */   public static GuildBossPreRankSingleHandler instance = new GuildBossPreRankSingleHandler();
/*     */ 
/*     */   
/*     */   public String getRedisKey(int logicServerId, int season) {
/*  43 */     return RankType.GUILD_BOSS_SINGLE.getRedisKey(logicServerId, season) + "/preday";
/*     */   }
/*     */ 
/*     */   
/*     */   public void buildRankInfo(List<String> contents, PlayerRankInfoPO player, long score) {
/*  48 */     contents.add(String.valueOf(player.getLevel()));
/*  49 */     contents.add(String.valueOf(player.getFightPower()));
/*  50 */     contents.add(player.getGuildName());
/*  51 */     contents.add(String.valueOf(score));
/*     */   }
/*     */ 
/*     */   
/*     */   public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
/*  56 */     String key = getRedisKey(GWorld.__SERVER_ID);
/*  57 */     String vl = GCache.get(key);
/*  58 */     int rank = 1;
/*  59 */     LeaderBoardProto result = new LeaderBoardProto();
/*  60 */     if (vl != null) {
/*  61 */       List<RankBean> worldRanks = JSONObject.parseArray(vl, RankBean.class);
/*  62 */       for (RankBean bean : worldRanks) {
/*  63 */         LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(bean.getId(), bean.getHurt(), rank);
/*  64 */         if (build == null) {
/*     */           continue;
/*     */         }
/*  67 */         rank++;
/*  68 */         result.s2c_lists.add(build);
/*     */         
/*  70 */         if (selfId.equals(bean.getId())) {
/*  71 */           result.s2c_myData = build;
/*     */         }
/*     */       } 
/*     */     } 
/*  75 */     return result;
/*     */   }
/*     */   
/*     */   public void delRankMember(int serverId, String memberId) {
/*  79 */     boolean hasChanged = false;
/*  80 */     List<RankBean> worldRanks = getDataList(serverId);
/*  81 */     if (worldRanks != null) {
/*  82 */       for (RankBean bean : worldRanks) {
/*  83 */         if (bean.getId().equals(memberId)) {
/*  84 */           worldRanks.remove(bean);
/*  85 */           hasChanged = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  89 */       if (hasChanged) {
/*  90 */         putStaticData(worldRanks);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<RankBean> getDataList(int serverId) {
/*  96 */     String key = getRedisKey(serverId);
/*  97 */     String vl = GCache.get(key);
/*  98 */     if (!StringUtil.isEmpty(vl)) {
/*  99 */       return JSONObject.parseArray(vl, RankBean.class);
/*     */     }
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putStaticData(List<RankBean> worldRanks) {
/* 110 */     String key = getRedisKey(GWorld.__SERVER_ID);
/* 111 */     String strVL = (worldRanks == null || worldRanks.isEmpty()) ? "[]" : JSONObject.toJSONString(worldRanks);
/* 112 */     GCache.put(key, strVL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(WNPlayer player, Object... value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossPreRankSingleHandler getInstance() {
/* 123 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\handler\GuildBossPreRankSingleHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */