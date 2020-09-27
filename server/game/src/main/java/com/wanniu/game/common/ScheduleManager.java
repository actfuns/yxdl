/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.daily.DailyActivityMgr;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.ext.NoticeSendExt;
/*     */ import com.wanniu.game.data.ext.ScheduleExt;
/*     */ import com.wanniu.game.guild.guildBless.GuildBlessCenter;
/*     */ import com.wanniu.game.intergalmall.IntergalMallGlobalService;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScheduleManager
/*     */ {
/*     */   private static class Holder
/*     */   {
/*  29 */     private static ScheduleManager instance = new ScheduleManager();
/*     */   }
/*     */   
/*     */   public static ScheduleManager getInstance() {
/*  33 */     return Holder.instance;
/*     */   }
/*     */ 
/*     */   
/*     */   private ScheduleManager() {
/*  38 */     long initialDelay = DateUtil.getFiveDelay();
/*     */     
/*  40 */     Out.info(new Object[] { "refreshNewDay will start after ", Long.valueOf(initialDelay) });
/*     */     
/*  42 */     JobFactory.addFixedRateJob(() -> { GameData.NoticeSends.values().forEach(()); GCache.remove(ConstsTR.DAILY_RELIVE.value); GCache.remove(ConstsTR.intergalMallTR.value); Out.info(new Object[] { "begin refreshNewDay..." }, ); Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers(); WNPlayer player = null; for (GPlayer gplayer : players.values()) { player = (WNPlayer)gplayer; player.refreshNewDay(); }  IntergalMallGlobalService.getInstance().refreshNewDay(); GuildBlessCenter.getInstance().refreshNewDay(); Out.info(new Object[] { "end refreshNewDay..." }, ); }initialDelay, Const.Time.Day
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
/*     */ 
/*     */         
/*  69 */         .getValue());
/*     */     
/*  71 */     List<ScheduleExt> scheduleExts = GameData.findSchedules(t -> 
/*  72 */         (t.schID == DailyActivityMgr.ScheduleType.SOLO.getValue() || t.schID == DailyActivityMgr.ScheduleType.FIVE_MOUNTAIN.getValue() || t.schID == DailyActivityMgr.ScheduleType.TRIAL.getValue() || t.schID == DailyActivityMgr.ScheduleType.DEMON_INVADE.getValue() || t.schID == DailyActivityMgr.ScheduleType.ILLUSION2.getValue() || t.schID == DailyActivityMgr.ScheduleType.GUILD_BOSS.getValue()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     for (ScheduleExt scheduleExt : scheduleExts) {
/*  79 */       List<ScheduleExt.TimeCond> timeConds = scheduleExt.periodInCalendarArray;
/*  80 */       for (int j = 0; j < timeConds.size(); j++) {
/*  81 */         ScheduleExt.TimeCond timeCond = timeConds.get(j);
/*  82 */         String startTime = new String(timeCond.beginTime);
/*  83 */         String endTime = new String(timeCond.endTime);
/*  84 */         if (startTime.indexOf(":") == startTime.lastIndexOf(":")) {
/*  85 */           startTime = startTime + ":00";
/*     */         }
/*  87 */         if (endTime.indexOf(":") == endTime.lastIndexOf(":")) {
/*  88 */           endTime = endTime + ":00";
/*     */         }
/*  90 */         long start = DateUtil.format(startTime).getTime();
/*  91 */         long end = DateUtil.format(endTime).getTime();
/*  92 */         JobFactory.addFixedRateJob(() -> dailyActivityUpdate(), 
/*     */             
/*  94 */             DateUtil.getSomeDateDelay(start - 600000L), Const.Time.Day.getValue());
/*  95 */         JobFactory.addFixedRateJob(() -> dailyActivityUpdate(), 
/*     */             
/*  97 */             DateUtil.getSomeDateDelay(start), Const.Time.Day.getValue());
/*  98 */         JobFactory.addFixedRateJob(() -> dailyActivityUpdate(), 
/*     */             
/* 100 */             DateUtil.getSomeDateDelay(end), Const.Time.Day.getValue());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void dailyActivityUpdate() {
/* 108 */     Map<String, GPlayer> players = GGame.getInstance().getOnlinePlayers();
/* 109 */     WNPlayer player = null;
/* 110 */     for (GPlayer gplayer : players.values()) {
/* 111 */       player = (WNPlayer)gplayer;
/* 112 */       DailyActivityMgr dailyActivityMgr = player.dailyActivityMgr;
/* 113 */       dailyActivityMgr.updateSuperScript();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\ScheduleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */