/*     */ package com.wanniu.game.rank;
/*     */ 
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.PlayerRankInfoPO;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import pomelo.Common;
/*     */ import pomelo.area.LeaderBoardHandler;
/*     */ import pomelo.revelry.ActivityRevelryHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractPlayerRankHandler
/*     */   extends AbstractRankHandler
/*     */ {
/*     */   public String getSelfId(WNPlayer player) {
/*  20 */     return player.getId();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSelfName(WNPlayer player) {
/*  25 */     return player.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LeaderBoardHandler.LeaderBoardData genBuilderInfo(String memberId, long score, int rank) {
/*  35 */     LeaderBoardHandler.LeaderBoardData.Builder builder = LeaderBoardHandler.LeaderBoardData.newBuilder();
/*     */     
/*  37 */     PlayerRankInfoPO player = RankCenter.getInstance().findRankPO(memberId);
/*  38 */     if (player == null) {
/*  39 */       return null;
/*     */     }
/*     */     
/*  42 */     List<String> contents = new ArrayList<>();
/*     */     
/*  44 */     contents.add(String.valueOf(rank));
/*  45 */     contents.add(player.getId());
/*  46 */     contents.add(String.valueOf(player.getPro()));
/*  47 */     contents.add(player.getName());
/*     */ 
/*     */     
/*  50 */     buildRankInfo(contents, player, score);
/*     */     
/*  52 */     builder.addAllContents(contents);
/*     */ 
/*     */     
/*  55 */     List<Common.Avatar> avatars = buildAvatarsInfo(player);
/*  56 */     if (!avatars.isEmpty()) {
/*  57 */       builder.addAllAvatars(avatars);
/*     */     }
/*  59 */     return builder.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void buildRankInfo(List<String> paramList, PlayerRankInfoPO paramPlayerRankInfoPO, long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<Common.Avatar> buildAvatarsInfo(PlayerRankInfoPO player) {
/*  71 */     return PlayerUtil.getBattlerServerAvatar(player.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void buildRevelryRankInfo(ActivityRevelryHandler.RevelryRankInfo.Builder info, SimpleRankData rankData) {
/*  77 */     info.addContents(String.valueOf(rankData.getRank()));
/*     */     
/*  79 */     info.addContents(String.valueOf(rankData.getScore()));
/*     */     
/*  81 */     String playerId = rankData.getId();
/*  82 */     PlayerRankInfoPO rankinfo = (PlayerRankInfoPO)PlayerPOManager.findPO(ConstsTR.playerRankTR, playerId, PlayerRankInfoPO.class);
/*  83 */     if (rankinfo == null) {
/*     */       
/*  85 */       info.addContents("-");
/*     */       
/*  87 */       info.addContents("1");
/*     */     } else {
/*     */       
/*  90 */       info.addContents(rankinfo.getName());
/*     */       
/*  92 */       info.addContents(String.valueOf(rankinfo.getPro()));
/*     */       
/*  94 */       info.addContents(String.valueOf(rankinfo.getLevel()));
/*     */     } 
/*     */ 
/*     */     
/*  98 */     if (rankData.getRank() == 1) {
/*  99 */       List<Common.Avatar> avatars = PlayerUtil.getBattlerServerAvatar(playerId);
/* 100 */       if (!avatars.isEmpty())
/* 101 */         info.addAllAvatars(avatars); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\rank\AbstractPlayerRankHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */