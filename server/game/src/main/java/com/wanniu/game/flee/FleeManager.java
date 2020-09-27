/*     */ package com.wanniu.game.flee;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.BattleRoyaleRankExt;
/*     */ import com.wanniu.game.item.ItemUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.poes.FleePO;
/*     */ import com.wanniu.game.rank.RankType;
/*     */ import com.wanniu.redis.PlayerPOManager;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import pomelo.area.FleeHandler;
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
/*     */ public class FleeManager
/*     */ {
/*     */   private WNPlayer player;
/*     */   private FleePO fleePo;
/*     */   private long joinTime;
/*     */   
/*     */   public FleeManager(WNPlayer player) {
/*  45 */     this.player = player;
/*  46 */     this.fleePo = loadFleePO(player.getId());
/*     */   }
/*     */   
/*     */   private FleePO loadFleePO(String playerId) {
/*  50 */     FleePO fleePO = (FleePO)PlayerPOManager.findPO(ConstsTR.player_fleeTR, playerId, FleePO.class);
/*  51 */     if (fleePO == null) {
/*  52 */       fleePO = new FleePO();
/*  53 */       PlayerPOManager.put(ConstsTR.player_fleeTR, playerId, (GEntity)fleePO);
/*     */     } 
/*  55 */     return fleePO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FleeHandler.FleeInfoResponse getFleeInfoResponse() {
/*  64 */     refreshFlee();
/*     */     
/*  66 */     FleeHandler.FleeInfoResponse.Builder res = FleeHandler.FleeInfoResponse.newBuilder();
/*  67 */     res.setS2CCode(200);
/*  68 */     res.setCurrentRank(FleeService.getInstance().getPlayerRank(this.player.getId()));
/*  69 */     res.setMaxRank(this.fleePo.maxRank);
/*  70 */     res.setGrade(this.fleePo.grade);
/*  71 */     res.setMaxGrade(this.fleePo.maxGrade);
/*  72 */     res.setScore(this.fleePo.score);
/*  73 */     res.setSeasonEndTime(this.fleePo.seasonEndTime.getTime());
/*  74 */     res.setJoinTime(0);
/*  75 */     if (FleeService.getInstance().getMatchPlayer().contains(this.player.getId())) {
/*  76 */       res.setJoinTime((int)Math.floor((this.joinTime / 1000L)));
/*  77 */       res.setAvgMatchTime(FleeService.getInstance().getAvgMatchingTime());
/*     */     } 
/*  79 */     for (BattleRoyaleRankExt r : GameData.BattleRoyaleRanks.values()) {
/*  80 */       FleeHandler.GradeReward.Builder re = FleeHandler.GradeReward.newBuilder();
/*  81 */       re.setGradeId(r.iD);
/*  82 */       if (this.fleePo.receiveGrades.contains(Integer.valueOf(r.iD))) {
/*  83 */         re.setStatus(2);
/*     */       } else {
/*  85 */         re.setStatus((this.fleePo.grade >= r.iD && this.fleePo.isPlayed) ? 1 : 0);
/*     */       } 
/*  87 */       res.addGradeRewards(re);
/*     */     } 
/*     */     
/*  90 */     return res.build();
/*     */   }
/*     */   
/*     */   private void refreshFlee() {
/*  94 */     Date seasonEndDate = FleeService.getInstance().getSeasonEndDate();
/*  95 */     if (!DateUtil.isSameDay(this.fleePo.seasonEndTime, seasonEndDate)) {
/*  96 */       this.fleePo.seasonEndTime = seasonEndDate;
/*  97 */       this.fleePo.receiveGrades.clear();
/*  98 */       resetGrade();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FleeHandler.FleeLookBtlReportResponse getFleeLookBtlReportResponse() {
/* 108 */     FleeHandler.FleeLookBtlReportResponse.Builder res = FleeHandler.FleeLookBtlReportResponse.newBuilder();
/* 109 */     res.setS2CCode(200);
/*     */     
/* 111 */     for (int i = this.fleePo.reports.size() - 1; i >= 0; i--) {
/* 112 */       FleeReportCO co = this.fleePo.reports.get(i);
/* 113 */       FleeHandler.FleeBtlReport.Builder rep = FleeHandler.FleeBtlReport.newBuilder();
/* 114 */       rep.setCreateTime(co.datetime);
/* 115 */       rep.setRank(co.rank);
/* 116 */       rep.setScoreChange(co.scoreChange);
/* 117 */       res.addBr(rep);
/*     */     } 
/*     */     
/* 120 */     return res.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FleeHandler.GetRewardResponse getRewardResponse(int gradeId) {
/* 130 */     FleeHandler.GetRewardResponse.Builder res = FleeHandler.GetRewardResponse.newBuilder();
/* 131 */     res.setS2CCode(200);
/* 132 */     if (this.fleePo.receiveGrades.contains(Integer.valueOf(gradeId))) {
/* 133 */       res.setS2CCode(500);
/* 134 */       res.setS2CMsg(LangService.getValue("FLEE_GOT"));
/* 135 */       return res.build();
/*     */     } 
/* 137 */     if (this.fleePo.grade < gradeId) {
/* 138 */       res.setS2CCode(500);
/* 139 */       res.setS2CMsg(LangService.getValue("FLEE_CANNOT_GOT_THIS_RANK"));
/* 140 */       return res.build();
/*     */     } 
/* 142 */     BattleRoyaleRankExt re = (BattleRoyaleRankExt)GameData.BattleRoyaleRanks.get(Integer.valueOf(gradeId));
/*     */     
/* 144 */     List<NormalItem> gradeReward = ItemUtil.createItemsByItemCode(re.gradeRewards);
/* 145 */     if (!this.player.bag.testAddEntityItems(gradeReward, true)) {
/* 146 */       res.setS2CCode(500);
/* 147 */       res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
/* 148 */       return res.build();
/*     */     } 
/* 150 */     this.fleePo.receiveGrades.add(Integer.valueOf(gradeId));
/* 151 */     this.player.bag.addEntityItems(gradeReward, Const.GOODS_CHANGE_TYPE.flee);
/* 152 */     return res.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetGrade() {
/* 159 */     int newGrade = ((BattleRoyaleRankExt)GameData.BattleRoyaleRanks.get(Integer.valueOf(this.fleePo.grade))).rankInherit;
/* 160 */     if (newGrade == 0) {
/* 161 */       newGrade = 1;
/*     */     }
/* 163 */     int newScore = ((BattleRoyaleRankExt)GameData.BattleRoyaleRanks.get(Integer.valueOf(newGrade))).rankScore;
/* 164 */     this.fleePo.grade = newGrade;
/* 165 */     this.fleePo.score = newScore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FleeHandler.EnterFleeResponse enterFlee() {
/* 174 */     FleeHandler.EnterFleeResponse.Builder res = FleeHandler.EnterFleeResponse.newBuilder();
/* 175 */     res.setS2CCode(200);
/* 176 */     if (!FleeService.getInstance().isInOpenTime()) {
/* 177 */       res.setS2CCode(500);
/* 178 */       res.setS2CMsg(LangService.getValue("FLEE_NOT_OPEN"));
/* 179 */       return res.build();
/*     */     } 
/*     */     
/* 182 */     List<String> matchPlayer = FleeService.getInstance().getMatchPlayer();
/* 183 */     if (!matchPlayer.contains(this.player.getId())) {
/* 184 */       synchronized (matchPlayer) {
/* 185 */         matchPlayer.add(this.player.getId());
/* 186 */         this.joinTime = System.currentTimeMillis();
/* 187 */         if (matchPlayer.size() == 10) {
/* 188 */           for (String id : matchPlayer) {
/* 189 */             WNPlayer wp = PlayerUtil.getOnlinePlayer(id);
/* 190 */             FleeService.getInstance().updateMatchingTime(wp.fleeManager.getMatchedTime());
/* 191 */             AreaUtil.dispatchByAreaId(wp, GlobalConfig.Flee_MapID, null);
/*     */           } 
/* 193 */           matchPlayer.clear();
/*     */         } 
/*     */       } 
/*     */     }
/* 197 */     res.setJoinTime((int)Math.floor((this.joinTime / 1000L)));
/* 198 */     res.setAvgMatchTime(FleeService.getInstance().getAvgMatchingTime());
/* 199 */     return res.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerOffline() {
/* 206 */     cancelMatchFlee();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FleeHandler.CancelMatchResponse cancelMatchFlee() {
/* 215 */     FleeHandler.CancelMatchResponse.Builder res = FleeHandler.CancelMatchResponse.newBuilder();
/* 216 */     res.setS2CCode(200);
/*     */     
/* 218 */     List<String> matchPlayer = FleeService.getInstance().getMatchPlayer();
/* 219 */     if (matchPlayer.contains(this.player.getId())) {
/* 220 */       synchronized (matchPlayer) {
/* 221 */         matchPlayer.remove(this.player.getId());
/*     */       } 
/*     */     }
/* 224 */     return res.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int addScore(int score) {
/* 233 */     int oldScore = this.fleePo.score;
/*     */     
/* 235 */     this.fleePo.score += score;
/* 236 */     if (this.fleePo.score < 0) {
/* 237 */       this.fleePo.score = 0;
/*     */     }
/* 239 */     this.fleePo.grade = FleeService.getInstance().getGradeIdByScore(this.fleePo.score);
/* 240 */     if (this.fleePo.maxGrade < this.fleePo.grade) {
/* 241 */       this.fleePo.maxGrade = this.fleePo.grade;
/*     */     }
/*     */ 
/*     */     
/* 245 */     RankType.FLEE.getHandler().asyncUpdateRank(GWorld.__SERVER_ID, this.player.getId(), this.fleePo.score);
/*     */     
/* 247 */     int currentRank = FleeService.getInstance().getPlayerRank(this.player.getId());
/* 248 */     if (this.fleePo.maxRank > currentRank) {
/* 249 */       this.fleePo.maxRank = currentRank;
/*     */     }
/*     */     
/* 252 */     return this.fleePo.score - oldScore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int onGameOver(int rank) {
/* 262 */     this.fleePo.isPlayed = true;
/* 263 */     int addScore = 0;
/* 264 */     if (rank <= 5) {
/* 265 */       addScore = GlobalConfig.Flee_OneToFive_GetPoint + (5 - rank) * 100;
/*     */     }
/* 267 */     else if (this.fleePo.score < GlobalConfig.Flee_RankBase_GetPoint) {
/* 268 */       addScore = GlobalConfig.Flee_RankBase_BaseGetPoint + (10 - rank) * GlobalConfig.Flee_RankBase_BaseGetPoint;
/*     */     } else {
/* 270 */       addScore = GlobalConfig.Flee_SixToTen_GetPoint + (rank - 6) * 100;
/* 271 */       addScore = -addScore;
/*     */     } 
/*     */     
/* 274 */     int scoreChange = addScore(addScore);
/* 275 */     this.fleePo.reports.add(new FleeReportCO(DateUtil.getDateTime(), rank, scoreChange));
/* 276 */     if (this.fleePo.reports.size() > GlobalConfig.Flee_ReportCount) {
/* 277 */       this.fleePo.reports.remove(0);
/*     */     }
/* 279 */     return scoreChange;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMatchedTime() {
/* 286 */     return System.currentTimeMillis() - this.joinTime;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\flee\FleeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */