/*     */ package com.wanniu.game.poes;
/*     */ 
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.game.DBTable;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.solo.SoloService;
/*     */ import com.wanniu.game.solo.po.BattleRecordPO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ @DBTable("player_solo_data")
/*     */ public class SoloDataPO
/*     */   extends GEntity
/*     */ {
/*     */   public boolean havePlayed;
/*     */   public int score;
/*     */   public int curRank;
/*     */   public int soloPoint;
/*     */   public int soloPointToday;
/*     */   public int rankId;
/*     */   public Date rankGotTime;
/*     */   public Map<Integer, RankStatus> rankRewards;
/*     */   public List<RankStatus> dailyRewards;
/*     */   public int dailyReceived;
/*     */   public int dailyBattleTimes;
/*     */   public int dailyRewardRound;
/*     */   public Date dailyResetTime;
/*     */   public Date lastJoinedTime;
/*     */   public int contWinTimes;
/*     */   public int extrWinTimes;
/*     */   public int maxContWinTimes;
/*     */   public int contLoseTimes;
/*     */   public int maxContLoseTimes;
/*     */   public int term;
/*     */   public int battleTimes;
/*     */   public int winTotalTimes;
/*     */   public int loseTotalTimes;
/*     */   public int winTimes_canglang;
/*     */   public int winTimes_yujian;
/*     */   public int winTimes_yixian;
/*     */   public int winTimes_shenjian;
/*     */   public int winTimes_linghu;
/*     */   public int battleTimes_canglang;
/*     */   public int battleTimes_yujian;
/*     */   public int battleTimes_yixian;
/*     */   public int battleTimes_shenjian;
/*     */   public int battleTimes_linghu;
/*     */   public List<BattleRecordPO> battleRecords;
/*     */   
/*     */   public SoloDataPO() {}
/*     */   
/*     */   public SoloDataPO(String playerId) {
/*  82 */     this.havePlayed = false;
/*     */     
/*  84 */     this.score = 0;
/*  85 */     this.curRank = 0;
/*  86 */     this.soloPoint = 0;
/*  87 */     this.soloPointToday = 0;
/*     */     
/*  89 */     this.rankId = 1;
/*  90 */     this.rankGotTime = null;
/*  91 */     this.rankRewards = new HashMap<>();
/*     */ 
/*     */     
/*  94 */     this.dailyRewards = new ArrayList<>();
/*  95 */     this.dailyReceived = 0;
/*  96 */     this.dailyBattleTimes = 0;
/*  97 */     this.dailyRewardRound = 0;
/*     */     
/*  99 */     this.dailyResetTime = null;
/* 100 */     this.lastJoinedTime = null;
/*     */     
/* 102 */     this.contWinTimes = 0;
/* 103 */     this.extrWinTimes = 0;
/* 104 */     this.maxContWinTimes = 0;
/* 105 */     this.contLoseTimes = 0;
/* 106 */     this.maxContLoseTimes = 0;
/*     */ 
/*     */     
/* 109 */     this.term = SoloService.getInstance().getTerm();
/* 110 */     this.battleTimes = 0;
/* 111 */     this.winTotalTimes = 0;
/* 112 */     this.loseTotalTimes = 0;
/*     */     
/* 114 */     this.winTimes_canglang = 0;
/* 115 */     this.winTimes_yujian = 0;
/* 116 */     this.winTimes_yixian = 0;
/* 117 */     this.winTimes_shenjian = 0;
/* 118 */     this.winTimes_linghu = 0;
/*     */ 
/*     */     
/* 121 */     this.battleTimes_canglang = 0;
/* 122 */     this.battleTimes_yujian = 0;
/* 123 */     this.battleTimes_yixian = 0;
/* 124 */     this.battleTimes_shenjian = 0;
/* 125 */     this.battleTimes_linghu = 0;
/* 126 */     this.battleRecords = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int _getWinRate(int winTimes, int battleTimes) {
/* 132 */     if (battleTimes == 0) {
/* 133 */       battleTimes = 1;
/*     */     }
/* 135 */     float a = winTimes;
/* 136 */     float b = battleTimes;
/* 137 */     return Math.round(a / b * 10000.0F);
/*     */   }
/*     */   public static void main(String[] args) {
/* 140 */     float a = 2.0F;
/* 141 */     float b = 3.0F;
/* 142 */     int c = Math.round(a / b * 10000.0F);
/* 143 */     System.out.println(c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWinRate(Const.Profession pro) {
/* 152 */     switch (pro.getValue()) {
/*     */       case 0:
/* 154 */         return _getWinRate(this.winTotalTimes, this.battleTimes);
/*     */       case 1:
/* 156 */         return _getWinRate(this.winTimes_canglang, this.battleTimes_canglang);
/*     */       case 2:
/* 158 */         return _getWinRate(this.winTimes_yujian, this.battleTimes_yujian);
/*     */       case 3:
/* 160 */         return _getWinRate(this.winTimes_yixian, this.battleTimes_yixian);
/*     */       case 4:
/* 162 */         return _getWinRate(this.winTimes_shenjian, this.battleTimes_shenjian);
/*     */       case 5:
/* 164 */         return _getWinRate(this.winTimes_linghu, this.battleTimes_linghu);
/*     */     } 
/* 166 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recordBattle(BattleRecordPO battleRecord) {
/* 176 */     this.battleTimes++;
/* 177 */     switch (battleRecord.result) {
/*     */       case 1:
/* 179 */         this.winTotalTimes++;
/* 180 */         addBattleTimesByPro(battleRecord.vsPro, true);
/*     */         break;
/*     */       case 2:
/* 183 */         this.loseTotalTimes++;
/* 184 */         addBattleTimesByPro(battleRecord.vsPro, false);
/*     */         break;
/*     */       case 3:
/* 187 */         addBattleTimesByPro(battleRecord.vsPro, false);
/*     */         break;
/*     */       default:
/* 190 */         Out.error(new Object[] { "错误的战斗记录", getClass() }); break;
/*     */     } 
/* 192 */     addBattleRecord(battleRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addBattleTimesByPro(int pro, boolean isWin) {
/* 198 */     switch (pro) {
/*     */       case 1:
/* 200 */         this.battleTimes_canglang++;
/* 201 */         if (isWin) {
/* 202 */           this.winTimes_canglang++;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 206 */         this.battleTimes_yujian++;
/* 207 */         if (isWin) {
/* 208 */           this.winTimes_yujian++;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 212 */         this.battleTimes_yixian++;
/* 213 */         if (isWin) {
/* 214 */           this.winTimes_yixian++;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 218 */         this.battleTimes_shenjian++;
/* 219 */         if (isWin) {
/* 220 */           this.winTimes_shenjian++;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 224 */         this.battleTimes_linghu++;
/* 225 */         if (isWin) {
/* 226 */           this.winTimes_linghu++;
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isExpired(Date oldDate, Date newDate, long validMillis) {
/* 234 */     return (oldDate.getTime() + validMillis < newDate.getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addBattleRecord(BattleRecordPO battleRecord) {
/* 243 */     long validDay = (GlobalConfig.Solo_ReportTime * 3600 * 1000);
/* 244 */     Iterator<BattleRecordPO> iter = this.battleRecords.iterator();
/* 245 */     Date now = new Date();
/* 246 */     while (iter.hasNext()) {
/* 247 */       if (isExpired(((BattleRecordPO)iter.next()).battleTime, now, validDay)) {
/* 248 */         iter.remove();
/*     */       }
/*     */     } 
/*     */     
/* 252 */     if (this.battleRecords.size() < GlobalConfig.Solo_ReportCount) {
/* 253 */       this.battleRecords.add(battleRecord);
/*     */     } else {
/* 255 */       this.battleRecords.remove(0);
/* 256 */       this.battleRecords.add(battleRecord);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class RankStatus
/*     */   {
/*     */     public int rankId;
/*     */     public int status;
/*     */     
/*     */     public int getRankId() {
/* 266 */       return this.rankId;
/*     */     }
/*     */     
/*     */     public void setRankId(int rankId) {
/* 270 */       this.rankId = rankId;
/*     */     }
/*     */     
/*     */     public int getStatus() {
/* 274 */       return this.status;
/*     */     }
/*     */     
/*     */     public void setStatus(int status) {
/* 278 */       this.status = status;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\SoloDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */