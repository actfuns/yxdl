/*     */ package com.wanniu.game.guild.guildBoss;
/*     */ 
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.db.GCache;
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.area.Area;
/*     */ import com.wanniu.game.area.AreaUtil;
/*     */ import com.wanniu.game.auction.AuctionService;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.ConstsTR;
/*     */ import com.wanniu.game.data.GameData;
/*     */ import com.wanniu.game.data.GuildBossRatioCO;
/*     */ import com.wanniu.game.data.base.MapBase;
/*     */ import com.wanniu.game.data.base.MonsterBase;
/*     */ import com.wanniu.game.data.ext.GuildSettingExt;
/*     */ import com.wanniu.game.data.ext.RankRewardExt;
/*     */ import com.wanniu.game.guild.GuildService;
/*     */ import com.wanniu.game.guild.GuildUtil;
/*     */ import com.wanniu.game.item.NormalItem;
/*     */ import com.wanniu.game.mail.MailUtil;
/*     */ import com.wanniu.game.mail.data.MailData;
/*     */ import com.wanniu.game.mail.data.MailSysData;
/*     */ import com.wanniu.game.monster.GuildBossRatioConfig;
/*     */ import com.wanniu.game.monster.MonsterConfig;
/*     */ import com.wanniu.game.player.GlobalConfig;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import com.wanniu.game.rank.handler.GuildBossPreRankGuildHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossPreRankSingleHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossRankGuildHandler;
/*     */ import com.wanniu.game.rank.handler.GuildBossRankSingleHandler;
/*     */ import com.wanniu.game.task.TaskEvent;
/*     */ import com.wanniu.game.task.TaskQueue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.time.DateUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuildBossService
/*     */ {
/*     */   public static final int GUILDBOSS_MAP_ID = 52001;
/*     */   public static final int GUILDBOSS_BOSS_ID = 552001;
/*     */   private MapBase arenaMap;
/*  62 */   private Calendar cal = Calendar.getInstance();
/*     */   private ScheduledFuture<?> overSchedule;
/*  64 */   private int guildBossLevel = 0;
/*     */   private Date guildBossUpgradeDate;
/*  66 */   private static final GuildBossService instance = new GuildBossService();
/*     */   
/*     */   public void init() {
/*  69 */     boolean isOpenTime = isInOpenTime();
/*  70 */     if (isOpenTime) {
/*  71 */       GuildBossCenter.getInstance().onBegin();
/*     */     }
/*  73 */     GuildSettingExt settingProp = GuildUtil.getGuildSettingExtProp();
/*     */     
/*  75 */     Date begin = DateUtil.format(settingProp.gBossOpenTime);
/*  76 */     Date preEnd = DateUtil.format(settingProp.gBossCloseTime);
/*  77 */     addBeginSchedule(begin);
/*  78 */     addPreEndSchedule(preEnd);
/*     */ 
/*     */     
/*  81 */     initGuildBossLevel();
/*     */   }
/*     */   
/*     */   private void initGuildBossLevel() {
/*  85 */     String data = GCache.hget(Integer.toString(GWorld.__SERVER_ID), ConstsTR.GuildBossTR.value);
/*  86 */     if (StringUtil.isEmpty(data)) {
/*  87 */       MonsterBase base = MonsterConfig.getInstance().get(552001);
/*  88 */       this.guildBossLevel = base.level;
/*     */     } else {
/*  90 */       this.guildBossLevel = Integer.parseInt(data);
/*     */     } 
/*  92 */     Out.info(new Object[] { "初始化仙盟Boss升级. level=", Integer.valueOf(this.guildBossLevel) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGuildBossLevel() {
/*  99 */     if (this.guildBossLevel == 0) {
/* 100 */       return (MonsterConfig.getInstance().get(552001)).level;
/*     */     }
/* 102 */     return this.guildBossLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void upgradeGuildBoss() {
/* 110 */     int newLv = this.guildBossLevel + GlobalConfig.GuildBoss_GrowLevel;
/* 111 */     GuildBossRatioCO co = GuildBossRatioConfig.getGuildBossRatioCO(newLv);
/* 112 */     if (co != null) {
/* 113 */       Date now = new Date();
/* 114 */       if (this.guildBossUpgradeDate == null || !DateUtils.isSameDay(this.guildBossUpgradeDate, now)) {
/* 115 */         this.guildBossUpgradeDate = now;
/* 116 */         this.guildBossLevel++;
/* 117 */         GCache.hset(Integer.toString(GWorld.__SERVER_ID), ConstsTR.GuildBossTR.value, String.valueOf(this.guildBossLevel));
/* 118 */         Out.info(new Object[] { "仙盟Boss升级. level=", Integer.valueOf(this.guildBossLevel) });
/*     */       } 
/*     */     } else {
/* 121 */       Out.info(new Object[] { "仙盟Boss已满级. level=", Integer.valueOf(this.guildBossLevel) });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void gmBegin() {
/* 126 */     onGuildBossOpen();
/* 127 */     if (this.overSchedule != null) {
/* 128 */       this.overSchedule.cancel(false);
/* 129 */       this.overSchedule = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void gmEnd() {
/* 134 */     if (!GuildBossCenter.getInstance().isOpen() || this.overSchedule != null) {
/*     */       return;
/*     */     }
/* 137 */     processGuildBossPreOver();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processGuildBossPreOver() {
/* 144 */     if (!GuildBossCenter.getInstance().isOpen()) {
/*     */       return;
/*     */     }
/* 147 */     GuildBossCenter.getInstance().onOver();
/* 148 */     pushAllScenesClose();
/* 149 */     staticsAllRank();
/* 150 */     this.overSchedule = JobFactory.addDelayJob(() -> onGuildBossClosed(), ((GlobalConfig.GuildBoss_LeaveTime + 2) * 1000));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBeginSchedule(Date date) {
/* 156 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 159 */             GuildBossService.this.onGuildBossOpen();
/*     */           }
/* 161 */         },  DateUtil.getTaskDelay(date), TimeUnit.DAYS.toMillis(1L));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPreEndSchedule(Date date) {
/* 170 */     JobFactory.addScheduleJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 173 */             GuildBossService.this.onGuildPreClosed();
/*     */           }
/* 175 */         },  DateUtil.getTaskDelay(date), TimeUnit.DAYS.toMillis(1L));
/*     */   }
/*     */   
/*     */   public void onGuildBossOpen() {
/* 179 */     Out.info(new Object[] { "工会BOSS活动开始了。。。。" });
/* 180 */     GWorld.getInstance().ansycExec(() -> processGuildBossOpen());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processGuildBossOpen() {
/* 189 */     if (GuildBossCenter.getInstance().isOpen()) {
/*     */       return;
/*     */     }
/* 192 */     processPreStaticDataToToday();
/* 193 */     checkBeforeBegin();
/* 194 */     GuildBossCenter.getInstance().onBegin();
/* 195 */     pointAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processPreStaticDataToToday() {
/* 202 */     processPreStaticSingleDataToToday();
/* 203 */     processPreStaticGuildDataToToday();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processPreStaticSingleDataToToday() {
/* 210 */     List<RankBean> todayList = GuildBossRankSingleHandler.getInstance().getDataList();
/* 211 */     GuildBossPreRankSingleHandler.getInstance().putStaticData(todayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processPreStaticGuildDataToToday() {
/* 218 */     List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> todayList = GuildBossRankGuildHandler.getInstance().getDataList();
/* 219 */     GuildBossPreRankGuildHandler.getInstance().putStaticData(todayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pointAll() {
/* 226 */     Map<String, GPlayer> map = GGame.getInstance().getOnlinePlayers();
/* 227 */     if (map != null && !map.isEmpty()) {
/* 228 */       Collection<GPlayer> playerIds = map.values();
/* 229 */       for (GPlayer player : playerIds) {
/* 230 */         ((WNPlayer)player).guildBossManager.pushScripts();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkBeforeBegin() {
/* 236 */     Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
/* 237 */     if (maps != null && !maps.isEmpty()) {
/* 238 */       StringBuffer sb = new StringBuffer();
/* 239 */       Set<Map.Entry<String, String>> sets = maps.entrySet();
/* 240 */       for (Map.Entry<String, String> e : sets) {
/* 241 */         String guildId = e.getKey();
/* 242 */         String instanceId = e.getValue();
/* 243 */         sb.append(guildId).append(",").append(instanceId);
/* 244 */         Area area = AreaUtil.getArea(instanceId);
/* 245 */         if (area != null) {
/* 246 */           area.dispose(false);
/* 247 */           sb.append(",scene not null");
/*     */         } 
/*     */       } 
/* 250 */       Out.warn(new Object[] { "在仙盟BOSS活动开始的时候发现有遗留场景留下来！！！！开始处理...赶紧查问题！！！[", sb.toString(), "]" });
/*     */     } 
/*     */     
/* 253 */     GuildBossCenter.getInstance().clear();
/* 254 */     GuildBossAreaHurtRankCenter.getInstance().clearOldData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processGuildBossOver() {
/* 261 */     if (this.overSchedule != null) {
/* 262 */       this.overSchedule.cancel(false);
/* 263 */       this.overSchedule = null;
/*     */     } 
/* 265 */     processAllSceneOver();
/* 266 */     GuildBossCenter.getInstance().clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void staticsAllRank() {
/* 273 */     TaskQueue.put(new TaskEvent(Const.EventType.statics_ranks, new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processStaticsAllRanks() {
/* 280 */     List<RankBean> worldRanks = new ArrayList<>();
/* 281 */     List<GuildRankBean> guildList = new ArrayList<>();
/* 282 */     Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
/* 283 */     if (map != null && !map.isEmpty()) {
/* 284 */       Set<String> sets = map.keySet();
/* 285 */       for (String guildId : sets) {
/* 286 */         GuildBossAreaHurtRankCenter.getInstance().processOver(guildId);
/* 287 */         GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
/* 288 */         if (bean == null) {
/*     */           continue;
/*     */         }
/* 291 */         guildList.add(bean);
/* 292 */         if (bean.getHurtList() != null && !bean.getHurtList().isEmpty()) {
/* 293 */           worldRanks.addAll(bean.getHurtList());
/*     */         }
/*     */       } 
/*     */     } 
/* 297 */     Collections.sort(worldRanks, GuildBossAreaHurtRankCenter.SORT_HURT);
/* 298 */     Collections.sort(guildList, GuildBossAreaHurtRankCenter.SORT_GUILD);
/* 299 */     Collections.sort(guildList, GuildBossAreaHurtRankCenter.SORT_GUILD_HURT);
/* 300 */     sendSingleRankReward(worldRanks);
/* 301 */     sendFirstKillReward(guildList);
/* 302 */     sendGuildRank(guildList);
/* 303 */     sendGuildKilledReward(guildList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<RankBean> getWorldSingleRank() {
/* 312 */     List<RankBean> worldRanks = new ArrayList<>();
/* 313 */     Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
/* 314 */     if (map != null && !map.isEmpty()) {
/* 315 */       Set<String> sets = map.keySet();
/* 316 */       for (String guildId : sets) {
/* 317 */         GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
/* 318 */         if (bean == null) {
/*     */           continue;
/*     */         }
/* 321 */         if (bean.getHurtList() != null && !bean.getHurtList().isEmpty()) {
/* 322 */           worldRanks.addAll(bean.getHurtList());
/*     */         }
/*     */       } 
/*     */     } 
/* 326 */     if (worldRanks != null && !worldRanks.isEmpty()) {
/* 327 */       Collections.sort(worldRanks, GuildBossAreaHurtRankCenter.SORT_HURT);
/*     */     }
/* 329 */     return worldRanks;
/*     */   }
/*     */   
/*     */   public List<GuildRankBean> getGuildRankSort() {
/* 333 */     List<GuildRankBean> guildRanks = new ArrayList<>();
/* 334 */     Map<String, GuildRankBean> map = GuildBossAreaHurtRankCenter.getInstance().getDataMap();
/* 335 */     if (map != null && !map.isEmpty()) {
/* 336 */       Set<String> sets = map.keySet();
/* 337 */       for (String guildId : sets) {
/* 338 */         GuildRankBean bean = GuildBossAreaHurtRankCenter.getInstance().onlyGetGuildRankBean(guildId);
/* 339 */         if (bean == null) {
/*     */           continue;
/*     */         }
/* 342 */         guildRanks.add(bean);
/*     */       } 
/*     */     } 
/* 345 */     if (guildRanks != null && !guildRanks.isEmpty()) {
/* 346 */       Collections.sort(guildRanks, GuildBossAreaHurtRankCenter.SORT_GUILD_ONLY_HURT);
/*     */     }
/* 348 */     return guildRanks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendFirstKillReward(List<GuildRankBean> list) {
/* 357 */     if (list == null || list.isEmpty()) {
/*     */       return;
/*     */     }
/* 360 */     GuildRankBean bean = list.get(0);
/* 361 */     RankRewardExt co = getRankRewardExt(3, 1, 1);
/* 362 */     if (co == null) {
/* 363 */       Out.warn(new Object[] { "在发送仙盟BOSS工会首杀奖励的时候发现拿不到配表！guildId=", bean.getGuildId() });
/*     */       return;
/*     */     } 
/* 366 */     if (!bean.hasKilled()) {
/* 367 */       Out.info(new Object[] { "本次仙盟BOSS没有工会击杀BOSS" });
/*     */       return;
/*     */     } 
/* 370 */     Out.info(new Object[] { "在仙盟活动中,有个工会获取了首杀奖励,奖励准备上拍卖。。guildId=", bean.getGuildId() });
/* 371 */     AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
/* 372 */     AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendGuildRank(List<GuildRankBean> list) {
/* 381 */     if (list != null && !list.isEmpty()) {
/* 382 */       for (int i = 0; i < list.size(); i++) {
/* 383 */         GuildRankBean bean = list.get(i);
/* 384 */         int rank = i + 1;
/* 385 */         RankRewardExt co = getRankRewardExt(2, rank, 1);
/* 386 */         if (co == null) {
/* 387 */           Out.warn(new Object[] { "在发送仙盟BOSS世界个人排名奖励的时候发现根据某个名次拿不到配表！rank=", Integer.valueOf(rank) });
/*     */         
/*     */         }
/* 390 */         else if (bean.getTotalHurt() > 0L) {
/*     */ 
/*     */           
/* 393 */           Out.info(new Object[] { "在仙盟活动中,有个工会获取了排名奖励,奖励准备上拍卖。。guildId=", bean.getGuildId(), "排名=", Integer.valueOf(rank) });
/* 394 */           AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
/* 395 */           List<NormalItem> randoms = co.getRandomReward();
/* 396 */           if (randoms != null && !randoms.isEmpty()) {
/* 397 */             Out.info(new Object[] { "在仙盟活动中,有个工会获取了随机排名奖励,奖励准备上拍卖。。guildId=", bean.getGuildId(), "排名=", Integer.valueOf(rank) });
/* 398 */             AuctionService.getInstance().addAuctionItem(randoms, bean.getGuildId(), co.rewardSource);
/*     */           } 
/*     */ 
/*     */           
/* 402 */           GuildService.addGuildMoneyByGuildBoss(bean.getGuildId(), co, rank);
/*     */           
/* 404 */           AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
/*     */         } 
/* 406 */       }  GuildBossRankGuildHandler.getInstance().putStaticData(copyList(list));
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> copyList(List<GuildRankBean> list) {
/* 411 */     List<GuildBossAreaHurtRankCenter.GuildStaticRankBean> newList = new ArrayList<>();
/* 412 */     if (list != null && !list.isEmpty()) {
/* 413 */       for (GuildRankBean rb : list) {
/* 414 */         newList.add(GuildBossAreaHurtRankCenter.GuildStaticRankBean.getGuildStaticRankBean(rb));
/*     */       }
/*     */     }
/* 417 */     return newList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendGuildKilledReward(List<GuildRankBean> list) {
/* 426 */     RankRewardExt co = getRankRewardExt(4, 1, 1);
/* 427 */     if (co == null) {
/* 428 */       Out.warn(new Object[] { "在发送仙盟BOSS击杀奖励拿不到配表！" });
/*     */       return;
/*     */     } 
/* 431 */     for (GuildRankBean bean : list) {
/* 432 */       if (bean.hasKilled()) {
/* 433 */         Out.info(new Object[] { "在仙盟活动中,有个工会击杀了BOSS,奖励准备上拍卖。。guildId=", bean.getGuildId() });
/* 434 */         AuctionService.getInstance().addAuctionItem(co.getList(), bean.getGuildId(), co.rewardSource);
/* 435 */         AuctionService.getInstance().processGuildAuctionsPoint(bean.getGuildId());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendSingleRankReward(List<RankBean> worldRanks) {
/* 447 */     if (worldRanks != null && !worldRanks.isEmpty()) {
/* 448 */       for (int i = 0; i < worldRanks.size(); i++) {
/* 449 */         RankBean bean = worldRanks.get(i);
/* 450 */         int rank = i + 1;
/* 451 */         RankRewardExt co = getRankRewardExt(1, rank, 0);
/* 452 */         if (co == null) {
/* 453 */           Out.warn(new Object[] { "在发送仙盟BOSS世界个人排名奖励的时候发现根据某个名次拿不到配表！rank=", Integer.valueOf(rank) });
/*     */         } else {
/*     */           
/* 456 */           sendMail(bean.getId(), rank, co.getList());
/*     */         } 
/* 458 */       }  GuildBossRankSingleHandler.getInstance().putStaticData(worldRanks);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void sendMail(String playerId, int rank, List<NormalItem> list) {
/* 463 */     MailSysData mailData = new MailSysData("GuildBossSoloReward");
/* 464 */     Map<String, String> replace = new HashMap<>();
/* 465 */     replace.put("rank", String.valueOf(rank));
/* 466 */     mailData.replace = replace;
/* 467 */     mailData.attachments = new ArrayList();
/* 468 */     if (list != null && !list.isEmpty()) {
/* 469 */       for (NormalItem attach : list) {
/* 470 */         MailData.Attachment item = new MailData.Attachment();
/* 471 */         item.itemCode = attach.itemCode();
/* 472 */         item.itemNum = attach.getNum();
/* 473 */         mailData.attachments.add(item);
/*     */       } 
/*     */     }
/* 476 */     MailUtil.getInstance().sendMailToOnePlayer(playerId, (MailData)mailData, Const.GOODS_CHANGE_TYPE.GUILD_BOSS);
/*     */   }
/*     */   
/*     */   private RankRewardExt getRankRewardExt(int rankType, int rank, int auction) {
/* 480 */     List<RankRewardExt> props = GameData.findRankRewards(t -> 
/* 481 */         (t.rankType == rankType && rank >= t.startRank && rank <= t.stopRank && t.isAuction == auction));
/*     */     
/* 483 */     if (props != null && !props.isEmpty()) {
/* 484 */       return props.get(0);
/*     */     }
/* 486 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushAllScenesClose() {
/* 493 */     Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
/* 494 */     if (maps != null && !maps.isEmpty()) {
/* 495 */       Set<Map.Entry<String, String>> sets = maps.entrySet();
/* 496 */       for (Map.Entry<String, String> e : sets) {
/* 497 */         String instanceId = e.getValue();
/* 498 */         Area area = AreaUtil.getArea(instanceId);
/* 499 */         if (area != null) {
/* 500 */           ((GuildBossArea)area).preOverProcess();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void processAllSceneOver() {
/* 507 */     Map<String, String> maps = GuildBossCenter.getInstance().getHasEnterGuildIds();
/* 508 */     if (maps != null && !maps.isEmpty()) {
/* 509 */       Set<Map.Entry<String, String>> sets = maps.entrySet();
/* 510 */       for (Map.Entry<String, String> e : sets) {
/* 511 */         String instanceId = e.getValue();
/* 512 */         Area area = AreaUtil.getArea(instanceId);
/* 513 */         if (area != null) {
/* 514 */           ((GuildBossArea)area).onGameOver();
/* 515 */           AreaUtil.closeArea(instanceId);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onGuildPreClosed() {
/* 522 */     Out.info(new Object[] { "工会BOSS活动快结束了。。。。" });
/* 523 */     GWorld.getInstance().ansycExec(() -> processGuildBossPreOver());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuildBossClosed() {
/* 529 */     Out.info(new Object[] { "工会BOSS活动结束了。。。。" });
/* 530 */     GWorld.getInstance().ansycExec(() -> processGuildBossOver());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Area enterGuildBossSence(WNPlayer player, int bossLevel) {
/* 536 */     Map<String, Object> userData = new HashMap<>();
/* 537 */     userData.put("lv", Integer.valueOf(bossLevel));
/* 538 */     return AreaUtil.dispatchByAreaId(player, 52001, userData);
/*     */   }
/*     */   
/*     */   public MapBase getGuildBossMap() {
/* 542 */     if (this.arenaMap == null) {
/* 543 */       this.arenaMap = AreaUtil.getAreaProp(52001);
/*     */     }
/* 545 */     return this.arenaMap;
/*     */   }
/*     */   
/*     */   public boolean isInOpenTime() {
/* 549 */     long now = System.currentTimeMillis();
/* 550 */     this.cal.setTimeInMillis(now);
/*     */     
/* 552 */     int hours = this.cal.get(11);
/* 553 */     int minutes = this.cal.get(12);
/*     */     
/* 555 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/* 556 */     if (hours < prop.guildBossBeginHours || hours > prop.guildBossEndHours) {
/* 557 */       return false;
/*     */     }
/* 559 */     if (prop.guildBossBeginHours == prop.guildBossEndHours) {
/* 560 */       if (hours == prop.guildBossBeginHours && 
/* 561 */         minutes >= prop.guildBossBeginMinutes && minutes < prop.guildBossEndMinutes) {
/* 562 */         return true;
/*     */       }
/*     */     }
/* 565 */     else if (prop.guildBossBeginHours < prop.guildBossEndHours) {
/* 566 */       if (hours == prop.guildBossBeginHours) {
/* 567 */         if (minutes >= prop.guildBossBeginMinutes)
/* 568 */           return true; 
/*     */       } else {
/* 570 */         if (hours > prop.guildBossBeginHours && hours < prop.guildBossEndHours)
/* 571 */           return true; 
/* 572 */         if (hours == prop.guildBossEndHours && 
/* 573 */           minutes < prop.guildBossEndMinutes) {
/* 574 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 578 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEndSeconds() {
/* 587 */     Calendar cal = Calendar.getInstance();
/* 588 */     int hours = cal.get(11);
/* 589 */     int minutes = cal.get(12);
/* 590 */     int seconds = cal.get(13);
/* 591 */     GuildSettingExt prop = GuildUtil.getGuildSettingExtProp();
/* 592 */     if (hours > prop.guildBossEndHours) {
/* 593 */       return 0;
/*     */     }
/* 595 */     int total = 0;
/* 596 */     total += (prop.guildBossEndHours - hours) * 3600;
/* 597 */     if (minutes >= prop.guildBossEndMinutes && total == 0) {
/* 598 */       return 0;
/*     */     }
/* 600 */     total += (prop.guildBossEndMinutes - minutes) * 60;
/* 601 */     total -= seconds;
/* 602 */     return total;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GuildBossService getInstance() {
/* 608 */     return instance;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\guild\guildBoss\GuildBossService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */