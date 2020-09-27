/*     */ package com.wanniu.game.rank;
/*     */ 
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardDetail;
/*     */ import com.wanniu.game.leaderBoard.LeaderBoardProto;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.GuildPO;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import pomelo.area.LeaderBoardHandler;
/*     */ import pomelo.revelry.ActivityRevelryHandler;
/*     */ import redis.clients.jedis.Tuple;
/*     */ 
/*     */ 
/*     */ public abstract class AbstractRankHandler
/*     */ {
/*     */   protected static final long target;
/*     */   
/*     */   static {
/*  30 */     Calendar calendar = Calendar.getInstance();
/*     */     try {
/*  32 */       calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse("2025-01-01"));
/*  33 */     } catch (ParseException parseException) {}
/*  34 */     target = calendar.getTimeInMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentSeason() {
/*  41 */     return getLastSeason() + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastSeason() {
/*  48 */     return 0;
/*     */   }
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
/*     */ 
/*     */   
/*     */   protected String getRedisKey(int logicServerId) {
/*  75 */     return getRedisKey(logicServerId, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LeaderBoardProto getRankData(WNPlayer player, int season) {
/*  83 */     return getRankData(GWorld.__SERVER_ID, season, getSelfId(player));
/*     */   }
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
/*     */   protected void updateRank(String key, long score, String memberId) {
/*  96 */     GCache.zadd(key, Double.parseDouble(score + "." + ((target - System.currentTimeMillis()) / 1000L)), memberId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handle(GuildPO guild) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<LeaderBoardDetail> getRankDetail(int serverId, int start, int end) {
/* 112 */     return getRankDetail(serverId, 0, start, end);
/*     */   }
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
/*     */   public List<LeaderBoardDetail> getRankDetail(int serverId, int season, int start, int end) {
/* 125 */     String key = getRedisKey(serverId, season);
/* 126 */     Set<Tuple> tuples = GCache.zrevrangeWithScores(key, start, end);
/* 127 */     List<LeaderBoardDetail> result = new ArrayList<>(tuples.size());
/* 128 */     int rank = 1;
/* 129 */     for (Tuple tuple : tuples) {
/* 130 */       LeaderBoardDetail detail = new LeaderBoardDetail();
/* 131 */       detail.rank = rank++;
/* 132 */       detail.score = tuple.getScore();
/* 133 */       detail.memberId = tuple.getElement();
/* 134 */       result.add(detail);
/*     */     } 
/* 136 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSeasonRank(int serverId, int season, String playerId) {
/* 148 */     String key = getRedisKey(serverId, season);
/* 149 */     Long rank = GCache.zrevrank(key, playerId);
/* 150 */     return (rank == null) ? 0L : (rank.longValue() + 1L);
/*     */   }
/*     */   
/*     */   public long getRank(int logicServerId, String playerId) {
/* 154 */     return getSeasonRank(logicServerId, 0, playerId);
/*     */   }
/*     */   
/*     */   public void delRank(int serverId) {
/* 158 */     GCache.del(getRedisKey(serverId));
/*     */   }
/*     */   
/*     */   public String getFirstRankMemberId(int serverId) {
/* 162 */     Set<String> members = GCache.zrevrange(getRedisKey(serverId), 0L, 1L);
/* 163 */     return members.isEmpty() ? "" : members.iterator().next();
/*     */   }
/*     */   
/*     */   public void asyncUpdateRank(int serverId, String playerId, int score) {
/* 167 */     String key = getRedisKey(serverId);
/* 168 */     updateRank(key, score, playerId);
/*     */   }
/*     */   
/*     */   public void delRankMember(int serverId, String memberId) {
/* 172 */     GCache.zrem(getRedisKey(serverId), memberId);
/*     */   }
/*     */   
/*     */   public LeaderBoardProto getRankData(int serverId, int seasonType, String selfId) {
/* 176 */     int season = 0;
/* 177 */     if (Const.RankSeasonType.LAST_SEASON.value == seasonType) {
/* 178 */       season = getLastSeason();
/*     */     } else {
/* 180 */       season = getCurrentSeason();
/*     */     } 
/* 182 */     String key = getRedisKey(serverId, season);
/*     */     
/* 184 */     LeaderBoardProto result = new LeaderBoardProto();
/* 185 */     int rank = 1;
/* 186 */     for (Tuple tuple : GCache.zrevrangeWithScores(key, 0L, (GlobalConfig.RankList_Limit - 1))) {
/* 187 */       String memberId = tuple.getElement();
/* 188 */       int score = (int)tuple.getScore();
/*     */       try {
/* 190 */         LeaderBoardHandler.LeaderBoardData build = genBuilderInfo(memberId, score, rank);
/* 191 */         if (build == null) {
/*     */           continue;
/*     */         }
/* 194 */         rank++;
/*     */         
/* 196 */         result.s2c_lists.add(build);
/*     */         
/* 198 */         if (selfId.equals(memberId)) {
/* 199 */           result.s2c_myData = build;
/*     */         }
/* 201 */       } catch (Exception e) {
/* 202 */         Out.warn(new Object[] { "排行榜中的展示信息构建失败，忽略此人 playerId=", memberId });
/*     */       } 
/*     */     } 
/* 205 */     return result;
/*     */   }
/*     */   
/*     */   public double getSeasonScore(int logicServerId, int season, String selfId) {
/* 209 */     Double score = GCache.zscore(getRedisKey(logicServerId, season), selfId);
/* 210 */     return (score == null) ? 0.0D : score.doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public SimpleRankData getSelfRankInfo(boolean isGameOver, String tabID, WNPlayer player) {
/* 215 */     String memberId = getSelfId(player);
/* 216 */     int season = getCurrentSeason();
/* 217 */     String key = getRedisKey(GWorld.__SERVER_ID, season);
/*     */ 
/*     */     
/* 220 */     if (isGameOver) {
/* 221 */       key = (new StringBuilder(key.length() + 1 + tabID.length())).append(key).append("-").append(tabID).toString();
/*     */     }
/*     */     
/* 224 */     Long rank = GCache.zrevrank(key, memberId);
/* 225 */     rank = Long.valueOf((rank == null) ? 0L : (rank.longValue() + 1L));
/*     */     
/* 227 */     int score = 0;
/* 228 */     if (rank.longValue() > 0L) {
/* 229 */       Double scorex = GCache.zscore(key, memberId);
/* 230 */       score = (int)((scorex == null) ? 0.0D : scorex.doubleValue());
/*     */     } 
/* 232 */     SimpleRankData detail = new SimpleRankData();
/* 233 */     detail.setId(memberId);
/* 234 */     detail.setRank(rank.intValue());
/* 235 */     detail.setScore(score);
/* 236 */     return detail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, SimpleRankData> getSimpleRankData(boolean isGameOver, String tabID, int minRank, int maxRank) {
/* 243 */     int season = getCurrentSeason();
/* 244 */     String key = getRedisKey(GWorld.__SERVER_ID, season);
/*     */     
/* 246 */     if (isGameOver) {
/* 247 */       key = (new StringBuilder(key.length() + 1 + tabID.length())).append(key).append("-").append(tabID).toString();
/*     */     }
/*     */     
/* 250 */     Set<Tuple> tuples = GCache.zrevrangeWithScores(key, minRank, maxRank);
/* 251 */     Map<Integer, SimpleRankData> result = new HashMap<>();
/* 252 */     int rank = 1;
/* 253 */     for (Tuple tuple : tuples) {
/* 254 */       SimpleRankData detail = new SimpleRankData();
/* 255 */       detail.setId(tuple.getElement());
/* 256 */       detail.setRank(rank++);
/* 257 */       detail.setScore((int)tuple.getScore());
/* 258 */       result.put(Integer.valueOf(detail.getRank()), detail);
/*     */     } 
/* 260 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Integer, SimpleRankData> copyRankToKey(String tabID) {
/* 267 */     int season = getCurrentSeason();
/* 268 */     String key = getRedisKey(GWorld.__SERVER_ID, season);
/* 269 */     Set<Tuple> tuples = GCache.zrevrangeWithScores(key, 0L, 9999L);
/*     */     
/* 271 */     Map<Integer, SimpleRankData> result = new HashMap<>();
/* 272 */     Map<String, Double> scoreMembers = new HashMap<>();
/* 273 */     int rank = 1;
/* 274 */     for (Tuple tuple : tuples) {
/* 275 */       scoreMembers.put(tuple.getElement(), Double.valueOf(tuple.getScore()));
/*     */       
/* 277 */       SimpleRankData detail = new SimpleRankData();
/* 278 */       detail.setId(tuple.getElement());
/* 279 */       detail.setRank(rank++);
/* 280 */       detail.setScore((int)tuple.getScore());
/*     */       
/* 282 */       result.put(Integer.valueOf(detail.getRank()), detail);
/*     */     } 
/*     */     
/* 285 */     String newKey = key + "-" + tabID;
/* 286 */     GCache.zadd(newKey, scoreMembers);
/*     */     
/* 288 */     GCache.expire(newKey, 2592000);
/* 289 */     return result;
/*     */   }
/*     */   
/*     */   public abstract void handle(WNPlayer paramWNPlayer, Object... paramVarArgs);
/*     */   
/*     */   protected abstract String getRedisKey(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract String getSelfId(WNPlayer paramWNPlayer);
/*     */   
/*     */   public abstract String getSelfName(WNPlayer paramWNPlayer);
/*     */   
/*     */   public abstract LeaderBoardHandler.LeaderBoardData genBuilderInfo(String paramString, long paramLong, int paramInt);
/*     */   
/*     */   public abstract void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder paramBuilder, SimpleRankData paramSimpleRankData);
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\AbstractRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */