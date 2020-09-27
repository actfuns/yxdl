/*      */ package com.wanniu.game.solo;
/*      */ 
/*      */ import com.google.protobuf.GeneratedMessage;
/*      */ import com.wanniu.core.game.JobFactory;
/*      */ import com.wanniu.core.game.LangService;
/*      */ import com.wanniu.core.game.entity.GEntity;
/*      */ import com.wanniu.core.logfs.Out;
/*      */ import com.wanniu.core.util.DateUtil;
/*      */ import com.wanniu.game.GWorld;
/*      */ import com.wanniu.game.area.Area;
/*      */ import com.wanniu.game.area.AreaUtil;
/*      */ import com.wanniu.game.common.Const;
/*      */ import com.wanniu.game.common.ConstsTR;
/*      */ import com.wanniu.game.common.HackerException;
/*      */ import com.wanniu.game.common.Utils;
/*      */ import com.wanniu.game.common.msg.WNNotifyManager;
/*      */ import com.wanniu.game.data.GameData;
/*      */ import com.wanniu.game.data.GameMapCO;
/*      */ import com.wanniu.game.data.SoloMonsterCO;
/*      */ import com.wanniu.game.data.SoloRankCO;
/*      */ import com.wanniu.game.data.base.MapBase;
/*      */ import com.wanniu.game.data.ext.SoloRankExt;
/*      */ import com.wanniu.game.five2Five.Five2FiveService;
/*      */ import com.wanniu.game.item.ItemUtil;
/*      */ import com.wanniu.game.item.NormalItem;
/*      */ import com.wanniu.game.item.VirtualItemType;
/*      */ import com.wanniu.game.mail.MailUtil;
/*      */ import com.wanniu.game.mail.data.MailData;
/*      */ import com.wanniu.game.mail.data.MailSysData;
/*      */ import com.wanniu.game.player.GlobalConfig;
/*      */ import com.wanniu.game.player.PlayerUtil;
/*      */ import com.wanniu.game.player.WNPlayer;
/*      */ import com.wanniu.game.player.bi.LogReportService;
/*      */ import com.wanniu.game.poes.SoloDataPO;
/*      */ import com.wanniu.game.solo.po.BattleRecordPO;
/*      */ import com.wanniu.game.solo.vo.ResultVO;
/*      */ import com.wanniu.game.team.TeamData;
/*      */ import com.wanniu.game.team.TeamService;
/*      */ import com.wanniu.redis.PlayerPOManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import pomelo.Common;
/*      */ import pomelo.area.PlayerHandler;
/*      */ import pomelo.area.SoloHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SoloManager
/*      */ {
/*      */   private long startJoinTime;
/*      */   private WNPlayer player;
/*      */   private SoloMonsterCO robot;
/*      */   private SoloNewsHandler newsHandler;
/*      */   public SoloDataPO soloData;
/*      */   private boolean busy;
/*      */   private AtomicBoolean inFight;
/*      */   
/*      */   private enum REWARD_TYPE
/*      */   {
/*   77 */     DAILY_REWARD(1), WEEKLY_REWARD(2), RANK_REWARD(3);
/*      */     
/*      */     private int value;
/*      */     
/*      */     REWARD_TYPE(int value) {
/*   82 */       this.value = value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBusy(boolean busy) {
/*   95 */     this.busy = busy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBusy() {
/*  102 */     return this.busy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SoloManager(WNPlayer player) {
/*  498 */     this.inFight = new AtomicBoolean(false); this.player = player; this.soloData = loadSoloData(player.getId()); this.startJoinTime = 0L; this.newsHandler = new SoloNewsHandler(this.player);
/*      */   }
/*      */   private SoloDataPO loadSoloData(String playerId) { SoloDataPO soloDataDb = (SoloDataPO)PlayerPOManager.findPO(ConstsTR.player_solo_dataTR, playerId, SoloDataPO.class); if (soloDataDb == null) { soloDataDb = new SoloDataPO(playerId); PlayerPOManager.put(ConstsTR.player_solo_dataTR, playerId, (GEntity)soloDataDb); }  return soloDataDb; }
/*      */   public int getScore() { return this.soloData.score; }
/*      */   public void addScore(int score) { int oldScore = this.soloData.score; this.soloData.score += score; if (this.soloData.score < 0) this.soloData.score = 0;  int oldRankId = this.soloData.rankId; this.soloData.rankId = SoloService.getInstance().calcRankId(this.soloData.score); if (this.soloData.rankId != oldRankId) { this.soloData.rankGotTime = new Date(); if (this.soloData.rankId > oldRankId) this.newsHandler.onRankIdChanged(this.soloData.rankId);  }  calcRankReward(oldRankId); if (oldScore != this.soloData.score) SoloService.getInstance().refreshSoloScoreToLeaderBoard(this.player, this.soloData.score);  }
/*      */   public void addSolopoint(int num, Const.GOODS_CHANGE_TYPE origin) { if (num == 0) return;  if (num < 0) throw new HackerException("增加宗师币时参数小于0.");  int before = this.soloData.soloPoint; if (0L + this.soloData.soloPoint + num > 2147483647L) { this.soloData.soloPoint = Integer.MAX_VALUE; } else { this.soloData.soloPoint += num; }  int after = this.soloData.soloPoint; Out.info(new Object[] { "add solopoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value) }); LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.SOLOPOINT, before, 1, num, after, origin.value); this.player.pushDynamicData(Utils.ofMap(new Object[] { "solopoint", Integer.valueOf(this.soloData.soloPoint) })); }
/*      */   public boolean costSolopoint(int num, Const.GOODS_CHANGE_TYPE origin) { if (num == 0) return true;  if (!enoughSolopoint(num)) return false;  int before = this.soloData.soloPoint; this.soloData.soloPoint -= num; int after = this.soloData.soloPoint; Out.info(new Object[] { "cost solopoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), 
/*      */           ",origin=", Integer.valueOf(origin.value) }); LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.SOLOPOINT, before, 2, num, after, origin.value); this.player.pushDynamicData(Utils.ofMap(new Object[] { "solopoint", Integer.valueOf(this.soloData.soloPoint) })); return true; }
/*      */   public boolean enoughSolopoint(int num) { if (num < 0) throw new HackerException("判定玩家身上的宗师币是否足够时参数小于0.");  return (getSolopoint() >= num); }
/*  507 */   public int getSolopoint() { return this.soloData.soloPoint; } public void handleSoloInfo(SoloHandler.SoloInfoResponse.Builder res) { MapBase sceneProp = AreaUtil.getAreaProp(GlobalConfig.Solo_MapID); if (sceneProp == null) { Out.error(new Object[] { "there is no data of MapID: ", Integer.valueOf(GlobalConfig.Solo_MapID), " in sceneProps" }); res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOMETHING_ERR")); return; }  checkTerm(); calcDailyChest(); SoloHandler.MyInfo.Builder myInfo = SoloHandler.MyInfo.newBuilder(); myInfo.setRank(getCurRank()); myInfo.setScore(this.soloData.score); myInfo.setMaxContWinTimes(this.soloData.maxContWinTimes); myInfo.setMaxContLoseTimes(this.soloData.maxContLoseTimes); myInfo.setBattleTimes(this.soloData.battleTimes); myInfo.setWinTotalTimes(this.soloData.winTotalTimes); myInfo.setLoseTotalTimes(this.soloData.loseTotalTimes); myInfo.setSeasonEndTime(String.valueOf(SoloService.getInstance().getSeasonEndTime())); myInfo.setMyToken(getSolopoint()); myInfo.setTodayToken(this.soloData.soloPointToday); myInfo.setMaxToken(GlobalConfig.Solo_MasterCoinGainLimit); myInfo.setAvgMatchTime(SoloMatcher.getInstance().getAvgMatchingTime()); myInfo.setStartJoinTime(0); if (isInMatching()) myInfo.setStartJoinTime((int)Math.floor((this.startJoinTime / 1000L)));  res.setS2CCode(200); res.setS2CMyInfo(myInfo.build()); updateRedPoint(); } private ResultVO firstJoinSolo(GameMapCO sceneProp) { ResultVO result = new ResultVO(true);
/*  508 */     this.player.dailyActivityMgr.onEvent(Const.DailyType.SOLO, "0", 1);
/*  509 */     setBusy(true);
/*      */     
/*  511 */     this.robot = SoloUtil.getSoloMonsterPropByPro(this.player.getPro());
/*  512 */     SoloHandler.OnSoloMatchedPush.Builder msg = SoloHandler.OnSoloMatchedPush.newBuilder();
/*  513 */     msg.setS2CCode(200);
/*  514 */     msg.setS2CVsPlayerName(this.robot.monName);
/*  515 */     msg.setS2CVsPlayerPro(this.robot.proID);
/*  516 */     msg.setS2CVsPlayerLevel(this.robot.monLevel);
/*  517 */     msg.addAllS2CVsPlayerAvatars(PlayerUtil.getBattleServerAvatar(this.robot.proID));
/*  518 */     msg.setS2CWaitResponseTimeSec(GlobalConfig.Solo_EnterTime);
/*  519 */     msg.setS2CIsRobot(1);
/*  520 */     this.player.receive("area.soloPush.onSoloMatchedPush", (GeneratedMessage)msg.build());
/*  521 */     JobFactory.addDelayJob(new Runnable()
/*      */         {
/*      */           public void run() {
/*  524 */             if (SoloManager.this.inFight.compareAndSet(false, true)) {
/*  525 */               SoloManager.this.enterSoloRobotArea();
/*      */             }
/*      */           }
/*      */         }GlobalConfig.Solo_EnterTime, TimeUnit.SECONDS);
/*      */     
/*  530 */     result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(-1));
/*  531 */     result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int)Math.floor((this.startJoinTime / 1000L))));
/*      */     
/*  533 */     return result; }
/*      */   public void handleNewsInfo(SoloHandler.NewsInfoResponse.Builder res) { List<SoloHandler.NewsInfo> msgs = new ArrayList<>(); Map<String, List<String>> allNews = SoloNewsHandler.getAllSoloNews(GWorld.__SERVER_ID); for (String dateStrKey : allNews.keySet()) { SoloHandler.NewsInfo.Builder newsInfo = SoloHandler.NewsInfo.newBuilder(); newsInfo.setDate(dateStrKey); newsInfo.addAllMessage(allNews.get(dateStrKey)); msgs.add(newsInfo.build()); }  res.setS2CCode(200); res.addAllS2CSoloMessages(msgs); }
/*      */   public void handleBattleRecord(SoloHandler.BattleRecordResponse.Builder res) { res.setS2CCode(200); res.setS2CCanglang(this.soloData.getWinRate(Const.Profession.canglang)); res.setS2CYujian(this.soloData.getWinRate(Const.Profession.yujian)); res.setS2CYixian(this.soloData.getWinRate(Const.Profession.yixian)); res.setS2CShenjian(this.soloData.getWinRate(Const.Profession.shenjian)); res.setS2CLinghu(this.soloData.getWinRate(Const.Profession.linghu)); List<SoloHandler.BattleRecord> records = new ArrayList<>(); for (int i = this.soloData.battleRecords.size() - 1; i >= 0; i--) { BattleRecordPO br = this.soloData.battleRecords.get(i); SoloHandler.BattleRecord.Builder brBuilder = SoloHandler.BattleRecord.newBuilder(); brBuilder.setResult(br.result); brBuilder.setBattleTime(String.valueOf(br.battleTime.getTime())); brBuilder.setScore(br.score); brBuilder.setScoreChange(br.scoreChange); brBuilder.setVsName(br.vsName); brBuilder.setVsGuildName(br.vsGuildName); brBuilder.setVsPro(br.vsPro); brBuilder.setVsScore(br.vsScore); records.add(brBuilder.build()); }  res.addAllS2CBatttleList(records); }
/*      */   private int getCurRank() { return (int)SoloService.getInstance().getRank(this.player.getId()); }
/*  537 */   public void handleRewardInfo(SoloHandler.RewardInfoResponse.Builder res) { List<SoloHandler.RankReward> rankRewards = new ArrayList<>(); for (SoloDataPO.RankStatus s : this.soloData.rankRewards.values()) { SoloHandler.RankReward.Builder rb = SoloHandler.RankReward.newBuilder(); rb.setRankId(s.getRankId()); rb.setStatus(s.getStatus()); rankRewards.add(rb.build()); }  res.setS2CCode(200); res.addAllS2CRankRewards(rankRewards); res.setS2CCurrRank(getCurRank()); List<SoloHandler.SoloDailyReward> dailyRewards = new ArrayList<>(); for (SoloDataPO.RankStatus s : this.soloData.dailyRewards) { SoloHandler.SoloDailyReward.Builder drb = SoloHandler.SoloDailyReward.newBuilder(); SoloRankCO prop = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId)); if (prop != null) { List<NormalItem> dailyReward = ItemUtil.createItemsByTcCode(prop.chestReward); for (NormalItem item : dailyReward) { SoloHandler.DailyRewardItem.Builder drib = SoloHandler.DailyRewardItem.newBuilder(); drib.setItemCode(item.itemCode()); drib.setItemNum(item.getNum()); drb.addItems(drib.build()); }  }  drb.setRankId(s.getRankId()); drb.setStatus(s.getStatus()); dailyRewards.add(drb.build()); }  res.addAllS2CDailyRewards(dailyRewards); res.setS2CDailyBattleTimes(this.soloData.dailyBattleTimes); } private String getGiftTypeName(REWARD_TYPE type) { return LangService.getValue("SOLO_GIFTTYPE" + type.value); } public void handleDrawRankReward(int rankId, SoloHandler.DrawRankRewardResponse.Builder res) { SoloRankExt prop = (SoloRankExt)GameData.SoloRanks.get(Integer.valueOf(rankId)); SoloDataPO.RankStatus myRankReward = (SoloDataPO.RankStatus)this.soloData.rankRewards.get(Integer.valueOf(rankId)); if (prop == null || myRankReward == null) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST")); return; }  int status = myRankReward.getStatus(); if (status == 2) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOLO_REWARD_HAS_DRAWED")); return; }  if (status != 1) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOLO_REWARD_CANNOT_DRAW")); return; }  List<NormalItem> rankReward = ItemUtil.createItemsByItemCode(prop.rankRewards); if (!this.player.getWnBag().testAddEntityItems(rankReward, true)) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS")); return; }  this.player.getWnBag().addEntityItems(rankReward, Const.GOODS_CHANGE_TYPE.solo); myRankReward.setStatus(2); this.newsHandler.onGetGift(getGiftTypeName(REWARD_TYPE.RANK_REWARD), rankReward); this.player.taskManager.dealTaskEvent(Const.TaskType.SINCOM, "1", 1); updateRedPoint(); res.setS2CCode(200); } public void handleDrawDailyReward(int index, SoloHandler.DrawDailyRewardResponse.Builder res) { if (index > this.soloData.dailyRewards.size()) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST")); return; }  index--; SoloDataPO.RankStatus rankStatus = this.soloData.dailyRewards.get(index); SoloRankCO prop = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId)); if (prop == null || rankStatus.getStatus() != 1) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST")); return; }  List<NormalItem> dailyReward = ItemUtil.createItemsByTcCode(prop.chestReward); if (!this.player.getWnBag().testAddEntityItems(dailyReward, true)) { res.setS2CCode(500); res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS")); return; }  List<SoloHandler.DailyRewardItem> items = new ArrayList<>(); for (NormalItem item : dailyReward) { SoloHandler.DailyRewardItem.Builder drib = SoloHandler.DailyRewardItem.newBuilder(); drib.setItemCode(item.itemCode()); drib.setItemNum(item.getNum()); items.add(drib.build()); }  res.addAllS2CDailyRewardItems(items); this.player.getWnBag().addEntityItems(dailyReward, Const.GOODS_CHANGE_TYPE.solo); this.soloData.dailyRewards.remove(index); this.soloData.dailyReceived++; this.newsHandler.onGetGift(getGiftTypeName(REWARD_TYPE.DAILY_REWARD), dailyReward); this.player.taskManager.dealTaskEvent(Const.TaskType.SINCOM, "1", 1); updateRedPoint(); res.setS2CCode(200); } public ResultVO handleJoinSolo() { ResultVO result = new ResultVO(true); GameMapCO sceneProp = (GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Solo_MapID)); if (sceneProp == null) { Out.error(new Object[] { "there is no data of MapID: ", Integer.valueOf(GlobalConfig.Solo_MapID), " in sceneProps", null }); result.result = false; result.info = "问道大会地图不存在"; return result; }  if (isBusy() || isInMatching()) { result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(SoloMatcher.getInstance().getAvgMatchingTime())); result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int)Math.floor((this.startJoinTime / 1000L)))); return result; }  if (Five2FiveService.getInstance().applyMatchTime(this.player.getId()) != null) { result.result = false; result.info = LangService.getValue("FIVE_2_FIVE_BUSY"); return result; }  if (!this.soloData.havePlayed) return firstJoinSolo(sceneProp);  checkTerm(); if (!SoloService.getInstance().isInOpenTime()) { result.result = false; result.info = LangService.getValue("SOLO_NOT_IN_OPEN_TIME"); return result; }  WNPlayer matchedPlayer = SoloMatcher.getInstance().findMatchedPlayer(this.soloData.score, this.player.getId()); if (matchedPlayer != null) { SoloMatcher.addWaiter(this.player, matchedPlayer); result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(-1)); result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int)Math.floor((this.startJoinTime / 1000L)))); } else { SoloMatcher.getInstance().addToMatchingList(this.soloData.score, this.player); this.startJoinTime = System.currentTimeMillis(); result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(SoloMatcher.getInstance().getAvgMatchingTime())); result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int)Math.floor((this.startJoinTime / 1000L)))); }  return result; } private boolean enterSoloRobotArea() { onEnterSoloArea();
/*  538 */     Map<String, Object> userData = Utils.ofMap(new Object[] { "isAddRobot", Boolean.valueOf(true), "pro", Integer.valueOf(this.player.getPro()) });
/*  539 */     Area area = AreaUtil.createAreaAndDispatch(this.player, Arrays.asList(new String[] { this.player.getId() }, ), this.player.getLogicServerId(), GlobalConfig.Solo_MapID, userData);
/*  540 */     if (area == null || this.robot == null) {
/*  541 */       return false;
/*      */     }
/*      */     
/*  544 */     SoloArea soloArea = (SoloArea)area;
/*  545 */     soloArea.addRobot(this.robot);
/*  546 */     if (!PlayerUtil.isOnline(this.player.getId())) {
/*  547 */       this.player.getXmdsManager().playerReady(this.player.getId());
/*  548 */       area.onPlayerAutoBattle(this.player, true);
/*      */     } 
/*      */     
/*  551 */     return true; }
/*      */ 
/*      */   
/*      */   private ResultVO firstJoinSoloBattle() {
/*  555 */     ResultVO result = new ResultVO(true);
/*  556 */     if (this.inFight.compareAndSet(false, true)) {
/*  557 */       if (enterSoloRobotArea()) {
/*  558 */         result.result = true;
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  563 */         result.result = false;
/*  564 */         result.info = "进入问道大会场景异常";
/*      */       } 
/*  566 */       Out.debug(new Object[] { "firstJoinSolo result:", result });
/*      */     } 
/*      */     
/*  569 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResultVO handleJoinSoloBattle() {
/*  578 */     ResultVO result = new ResultVO(true);
/*      */     
/*  580 */     if (!this.soloData.havePlayed) {
/*  581 */       return firstJoinSoloBattle();
/*      */     }
/*      */     
/*  584 */     if (!SoloService.getInstance().isInOpenTime()) {
/*  585 */       result.result = false;
/*  586 */       result.info = LangService.getValue("SOLO_NOT_IN_OPEN_TIME");
/*  587 */       return result;
/*      */     } 
/*      */     
/*  590 */     if (!SoloMatcher.getInstance().joinBattle(this.player)) {
/*  591 */       result.result = false;
/*  592 */       result.info = LangService.getValue("SOLO_NO_ENEMY");
/*  593 */       return result;
/*      */     } 
/*      */     
/*  596 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void handleQuitSolo() {
/*  603 */     quitMatching(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public ResultVO handleQueryReward() {
/*  608 */     ResultVO result = new ResultVO(true);
/*  609 */     result.set(ResultVO.KEY.HAS_REWARD, Integer.valueOf(hasReward()));
/*      */     
/*  611 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public ResultVO handleLeaveSoloArea() {
/*  616 */     setBusy(false);
/*  617 */     ResultVO data = new ResultVO(true, "");
/*      */     
/*  619 */     int historyAreaId = (this.player.getPlayerTempData()).historyAreaId;
/*  620 */     if (historyAreaId <= 0) {
/*  621 */       data.result = false;
/*  622 */       data.info = LangService.getValue("AREA_ID_NULL");
/*  623 */       return data;
/*      */     } 
/*      */     
/*  626 */     Area area = AreaUtil.dispatchByAreaId(this.player, historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);
/*  627 */     if (area != null) {
/*  628 */       return data;
/*      */     }
/*  630 */     data.result = false;
/*  631 */     data.info = LangService.getValue("SOMETHING_ERR");
/*  632 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void refreshNewDay() {
/*  643 */     resetData();
/*      */     
/*  645 */     Out.debug(new Object[] { "==========>> SoloManager.refreshNewDay() on ", new Date() });
/*      */   }
/*      */   
/*      */   public void resetData() {
/*  649 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SOLO.getValue())) {
/*      */       return;
/*      */     }
/*      */     
/*  653 */     this.soloData.dailyReceived = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  658 */     if (this.soloData.dailyRewards.size() < 2) {
/*  659 */       SoloDataPO.RankStatus s = new SoloDataPO.RankStatus();
/*  660 */       s.setRankId(getRankId());
/*  661 */       s.setStatus(0);
/*  662 */       this.soloData.dailyRewards.add(s);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  669 */     this.soloData.dailyBattleTimes = 0;
/*      */     
/*  671 */     this.soloData.soloPointToday = 0;
/*  672 */     checkTerm();
/*  673 */     this.soloData.dailyResetTime = new Date();
/*      */ 
/*      */ 
/*      */     
/*  677 */     Out.debug(new Object[] { "==========>> SoloManager.resetData() on ", new Date() });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTerm() {
/*  684 */     if (this.soloData.term < SoloService.getInstance().getTerm()) {
/*      */ 
/*      */       
/*  687 */       this.soloData.dailyRewardRound = 0;
/*      */       
/*  689 */       resetRankId();
/*  690 */       calcRankReward(1);
/*  691 */       this.soloData.term = SoloService.getInstance().getTerm();
/*      */       
/*  693 */       this.soloData.contWinTimes = 0;
/*  694 */       this.soloData.extrWinTimes = 0;
/*  695 */       this.soloData.maxContWinTimes = 0;
/*  696 */       this.soloData.contLoseTimes = 0;
/*  697 */       this.soloData.maxContLoseTimes = 0;
/*      */       
/*  699 */       this.soloData.battleTimes = 0;
/*  700 */       this.soloData.winTotalTimes = 0;
/*  701 */       this.soloData.loseTotalTimes = 0;
/*  702 */       this.soloData.winTimes_canglang = 0;
/*  703 */       this.soloData.winTimes_yujian = 0;
/*  704 */       this.soloData.winTimes_yixian = 0;
/*  705 */       this.soloData.winTimes_shenjian = 0;
/*  706 */       this.soloData.winTimes_linghu = 0;
/*  707 */       this.soloData.battleTimes_canglang = 0;
/*  708 */       this.soloData.battleTimes_yujian = 0;
/*  709 */       this.soloData.battleTimes_yixian = 0;
/*  710 */       this.soloData.battleTimes_shenjian = 0;
/*  711 */       this.soloData.battleTimes_linghu = 0;
/*  712 */       this.soloData.battleRecords = new ArrayList();
/*      */       
/*  714 */       SoloService.getInstance().refreshSoloScoreToLeaderBoard(this.player, this.soloData.score);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getRankName() {
/*  722 */     SoloRankCO rank = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(getRankId()));
/*  723 */     if (rank != null) {
/*  724 */       return rank.rankName;
/*      */     }
/*      */     
/*  727 */     return String.valueOf(getRankId());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getRankId() {
/*  734 */     return this.soloData.rankId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void resetRankReward() {
/*  741 */     ArrayList<MailData.Attachment> list = new ArrayList<>();
/*  742 */     MailSysData mailData = new MailSysData("Solo_reward_last");
/*  743 */     mailData.replace = new HashMap<>();
/*  744 */     mailData.replace.put("rank", getRankName());
/*  745 */     for (SoloDataPO.RankStatus rew : this.soloData.rankRewards.values()) {
/*  746 */       if (rew.getStatus() == 1) {
/*  747 */         SoloRankExt prop = (SoloRankExt)GameData.SoloRanks.get(Integer.valueOf(rew.getRankId()));
/*  748 */         if (prop == null) {
/*      */           continue;
/*      */         }
/*  751 */         for (String itemCode : prop.rankRewards.keySet()) {
/*  752 */           MailData.Attachment attach = new MailData.Attachment();
/*  753 */           attach.itemCode = itemCode;
/*  754 */           attach.itemNum = ((Integer)prop.rankRewards.get(itemCode)).intValue();
/*  755 */           list.add(attach);
/*      */         } 
/*      */       } 
/*      */     } 
/*  759 */     if (list.size() > 0) {
/*  760 */       mailData.attachments = list;
/*  761 */       MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData)mailData, Const.GOODS_CHANGE_TYPE.solo);
/*      */     } 
/*  763 */     this.soloData.rankRewards = new HashMap<>();
/*      */   }
/*      */   
/*      */   private void resetRankId() {
/*  767 */     int newRankId = this.soloData.rankId / 2;
/*  768 */     if (newRankId == 0) {
/*  769 */       newRankId = 1;
/*      */     }
/*  771 */     if (newRankId > 10) {
/*  772 */       Out.error(new Object[] { "resetRankId failed. something error occurred in :", getClass() });
/*      */     }
/*  774 */     int newScore = ((SoloRankExt)GameData.SoloRanks.get(Integer.valueOf(newRankId))).rankScore;
/*  775 */     this.soloData.rankId = newRankId;
/*  776 */     this.soloData.score = newScore;
/*  777 */     resetRankReward();
/*      */   }
/*      */   
/*      */   public boolean isInMatching() {
/*  781 */     return SoloMatcher.getInstance().isInMatchingList(this.player.getId());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void quitMatching(boolean isSilent) {
/*  790 */     if (isInMatching()) {
/*  791 */       SoloMatcher.getInstance().delToMatchingList(this.player.getId());
/*  792 */       if (!isSilent) {
/*  793 */         PlayerUtil.sendSysMessageToPlayer(LangService.getValue("SOLO_MATCHING_HAVE_QUIT"), this.player.getId(), Const.TipsType.NORMAL);
/*  794 */         SoloHandler.CancelMatchPush.Builder matchPush = SoloHandler.CancelMatchPush.newBuilder();
/*  795 */         matchPush.setS2CCode(200);
/*  796 */         this.player.receive("area.soloPush.cancelMatchPush", (GeneratedMessage)matchPush.build());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean calcDailyChestOnBattled() {
/*  806 */     int times = 0;
/*  807 */     for (SoloDataPO.RankStatus s : this.soloData.dailyRewards) {
/*  808 */       if (s.getStatus() == 0) {
/*  809 */         times += GlobalConfig.Solo_PKForChest;
/*      */       }
/*      */     } 
/*  812 */     if (times != 0) {
/*  813 */       this.soloData.dailyBattleTimes++;
/*  814 */       if (this.soloData.dailyBattleTimes >= GlobalConfig.Solo_PKForChest) {
/*  815 */         for (int i = 0; i < this.soloData.dailyRewards.size(); i++) {
/*  816 */           SoloDataPO.RankStatus s = this.soloData.dailyRewards.get(i);
/*  817 */           if (s.getStatus() == 0) {
/*  818 */             s.setRankId(getRankId());
/*  819 */             s.setStatus(1);
/*      */             break;
/*      */           } 
/*      */         } 
/*  823 */         WNNotifyManager.getInstance().pushNewReward(this.player);
/*  824 */         this.soloData.dailyBattleTimes = 0;
/*  825 */         return true;
/*      */       } 
/*      */     } 
/*  828 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void calcDailyChest() {
/*  859 */     if (!this.soloData.havePlayed && this.soloData.dailyRewards.isEmpty()) {
/*  860 */       SoloDataPO.RankStatus s = new SoloDataPO.RankStatus();
/*  861 */       s.setRankId(getRankId());
/*  862 */       s.setStatus(0);
/*  863 */       this.soloData.dailyRewards.add(s);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void calcRankReward(int oldRankId) {
/*  873 */     SoloDataPO.RankStatus rankReward = (SoloDataPO.RankStatus)this.soloData.rankRewards.get(Integer.valueOf(getRankId()));
/*  874 */     if (rankReward == null) {
/*  875 */       if (this.soloData.rankRewards.size() == 0) {
/*  876 */         for (int i = 1; i <= getRankId(); i++) {
/*  877 */           SoloDataPO.RankStatus rb = new SoloDataPO.RankStatus();
/*  878 */           rb.setRankId(i);
/*  879 */           rb.setStatus(1);
/*  880 */           this.soloData.rankRewards.put(Integer.valueOf(rb.rankId), rb);
/*      */         } 
/*      */       } else {
/*  883 */         SoloDataPO.RankStatus rb = new SoloDataPO.RankStatus();
/*  884 */         rb.setRankId(getRankId());
/*  885 */         rb.setStatus(1);
/*  886 */         this.soloData.rankRewards.put(Integer.valueOf(rb.rankId), rb);
/*      */       } 
/*      */       
/*  889 */       updateRedPoint();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  900 */     else if (rankReward.getStatus() != 2) {
/*  901 */       rankReward.setStatus(1);
/*      */       
/*  903 */       updateRedPoint();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int winSoloPoint(int result) {
/*  914 */     int point = 0;
/*  915 */     if (this.soloData.soloPointToday < GlobalConfig.Solo_MasterCoinGainLimit) {
/*  916 */       point = GlobalConfig.Solo_MasterCoinGainLimit - this.soloData.soloPointToday;
/*      */     }
/*  918 */     if (result == 1) {
/*  919 */       if (point < GlobalConfig.Solo_WinGainMasterCoin) {
/*  920 */         return point;
/*      */       }
/*  922 */       return GlobalConfig.Solo_WinGainMasterCoin;
/*      */     } 
/*  924 */     if (point < GlobalConfig.Solo_LoseGainMasterCoin) {
/*  925 */       return point;
/*      */     }
/*  927 */     return GlobalConfig.Solo_LoseGainMasterCoin;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onGameEnd(int result, WNPlayer vsPlayer, int addScore, int subScore) {
/*  939 */     setBusy(false);
/*      */     
/*  941 */     Out.debug(new Object[] { "onGameEnd playerId:", this.player.getId(), ", result:", Integer.valueOf(result), ", vsPlayerId:", vsPlayer });
/*  942 */     this.soloData.havePlayed = true;
/*      */ 
/*      */     
/*  945 */     int vsScore = 0;
/*  946 */     String vsName = "";
/*  947 */     String vsGuildName = "";
/*  948 */     int vsPro = 0;
/*  949 */     if (vsPlayer != null) {
/*  950 */       vsScore = vsPlayer.soloManager.getScore();
/*  951 */       vsName = vsPlayer.getName();
/*  952 */       vsGuildName = vsPlayer.guildManager.getGuildName();
/*  953 */       vsPro = vsPlayer.getPro();
/*      */     } else {
/*  955 */       SoloMonsterCO monsterProp = (SoloMonsterCO)GameData.SoloMonsters.get(Integer.valueOf(this.player.getPro()));
/*  956 */       vsName = monsterProp.monName;
/*  957 */       vsPro = monsterProp.proID;
/*      */     } 
/*      */ 
/*      */     
/*  961 */     int oldRank = getCurRank();
/*  962 */     int oldWinTimes = this.soloData.contWinTimes;
/*  963 */     int oldScore = this.soloData.score;
/*      */     
/*  965 */     if (result == 1) {
/*  966 */       addScore(addScore);
/*      */       
/*  968 */       this.soloData.contWinTimes++;
/*  969 */       this.soloData.extrWinTimes++;
/*  970 */       this.soloData.contLoseTimes = 0;
/*      */       
/*  972 */       this.player.achievementManager.onWinSolo(this.soloData.rankId);
/*  973 */     } else if (result == 2) {
/*  974 */       addScore(subScore);
/*  975 */       this.soloData.contLoseTimes++;
/*  976 */       if (this.soloData.contLoseTimes > this.soloData.maxContLoseTimes) {
/*  977 */         this.soloData.maxContLoseTimes = this.soloData.contLoseTimes;
/*      */       }
/*  979 */       this.soloData.contWinTimes = 0;
/*  980 */       this.soloData.extrWinTimes = 0;
/*      */     } 
/*      */     
/*  983 */     int scoreChange = this.soloData.score - oldScore;
/*      */     
/*  985 */     int addPoint = winSoloPoint(result);
/*  986 */     addSolopoint(addPoint, Const.GOODS_CHANGE_TYPE.solo);
/*  987 */     this.soloData.soloPointToday += addPoint;
/*      */ 
/*      */     
/*  990 */     if (this.soloData.contWinTimes > oldWinTimes) {
/*  991 */       this.newsHandler.onStraightWin(this.soloData.contWinTimes);
/*  992 */       if (this.soloData.contWinTimes > this.soloData.maxContWinTimes) {
/*  993 */         this.soloData.maxContWinTimes = this.soloData.contWinTimes;
/*      */       }
/*  995 */     } else if (this.soloData.contWinTimes > oldWinTimes) {
/*  996 */       this.newsHandler.onStraightWinStopped(oldWinTimes, (vsPlayer != null) ? vsPlayer.getName() : "");
/*      */     } 
/*  998 */     SoloRankCO prop = (SoloRankCO)GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId));
/*  999 */     if (prop != null && 
/* 1000 */       this.soloData.extrWinTimes >= prop.extraRequire) {
/* 1001 */       this.soloData.extrWinTimes = 0;
/* 1002 */       this.player.achievementManager.onWinSolo(this.soloData.rankId);
/*      */     } 
/*      */ 
/*      */     
/* 1006 */     boolean isAddBox = calcDailyChestOnBattled();
/*      */ 
/*      */     
/* 1009 */     BattleRecordPO battleRec = new BattleRecordPO();
/* 1010 */     battleRec.result = result;
/* 1011 */     battleRec.battleTime = new Date();
/* 1012 */     battleRec.score = this.soloData.score;
/* 1013 */     battleRec.scoreChange = scoreChange;
/* 1014 */     battleRec.vsName = vsName;
/* 1015 */     battleRec.vsGuildName = vsGuildName;
/* 1016 */     battleRec.vsPro = vsPro;
/* 1017 */     battleRec.vsScore = vsScore;
/* 1018 */     this.soloData.recordBattle(battleRec);
/*      */ 
/*      */     
/* 1021 */     SoloHandler.GameResult.Builder gb = SoloHandler.GameResult.newBuilder();
/* 1022 */     gb.setResult(result);
/* 1023 */     gb.setNewScore(scoreChange);
/* 1024 */     gb.setCurrScore(this.soloData.score);
/* 1025 */     gb.setTokenChange(addPoint);
/*      */     
/* 1027 */     int currRank = getCurRank();
/* 1028 */     if (oldRank == 0) {
/* 1029 */       gb.setRankChange(currRank);
/*      */     } else {
/* 1031 */       gb.setRankChange(oldRank - currRank);
/*      */     } 
/* 1033 */     gb.setCurrentRank(currRank);
/* 1034 */     int gameOverTime = ((GameMapCO)GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Solo_MapID))).timeCount;
/* 1035 */     WNNotifyManager.getInstance().pushGameEnd(this.player, gb.build(), gameOverTime, isAddBox);
/*      */   }
/*      */ 
/*      */   
/*      */   private void cancelFollow() {
/* 1040 */     Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
/* 1041 */     if (members != null) {
/* 1042 */       if (this.player.getTeamManager().isTeamLeader()) {
/* 1043 */         for (TeamData.TeamMemberData member : members.values()) {
/* 1044 */           if (member.isFollow()) {
/* 1045 */             TeamService.followLeader(member.getPlayer(), false);
/*      */           }
/*      */         } 
/*      */       } else {
/* 1049 */         TeamService.followLeader(this.player, false);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void onEnterSoloArea() {
/* 1055 */     cancelFollow();
/* 1056 */     this.soloData.lastJoinedTime = new Date();
/*      */     
/* 1058 */     this.startJoinTime = 0L;
/*      */     
/* 1060 */     this.player.taskManager.dealTaskEvent(Const.TaskType.JOIN_SOLO, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getMatchedTime() {
/* 1069 */     return System.currentTimeMillis() - this.startJoinTime;
/*      */   }
/*      */   
/*      */   private int hasReward() {
/* 1073 */     if (this.soloData.dailyRewards.size() > 0) {
/* 1074 */       return 1;
/*      */     }
/*      */     
/* 1077 */     for (SoloDataPO.RankStatus r : this.soloData.rankRewards.values()) {
/* 1078 */       if (r.getStatus() == 1) {
/* 1079 */         return 1;
/*      */       }
/*      */     } 
/*      */     
/* 1083 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void updateRedPoint() {
/* 1090 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 1091 */     list.addAll(getSuperScript());
/* 1092 */     this.player.updateSuperScriptList(list);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PlayerHandler.SuperScriptType> getSuperScript() {
/* 1101 */     List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
/* 1102 */     if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SOLO.getValue())) {
/* 1103 */       return list;
/*      */     }
/* 1105 */     PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
/* 1106 */     data.setType(Const.SUPERSCRIPT_TYPE.SOLO.getValue());
/* 1107 */     data.setNumber(SoloService.getInstance().isInOpenTime() ? 1 : 0);
/*      */     
/* 1109 */     PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
/* 1110 */     data2.setType(Const.SUPERSCRIPT_TYPE.SOLO_REWARD.getValue());
/* 1111 */     data2.setNumber(getRewardCount());
/*      */     
/* 1113 */     list.add(data.build());
/* 1114 */     list.add(data2.build());
/* 1115 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPlayerOffline() {
/* 1123 */     SoloMatcher.getInstance().playerOffline(this.player.getId());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getRewardCount() {
/* 1130 */     int number = 0;
/* 1131 */     if (this.soloData.dailyRewards.size() > 0) {
/* 1132 */       for (SoloDataPO.RankStatus rank : this.soloData.dailyRewards) {
/* 1133 */         if (rank.getStatus() == 1) {
/* 1134 */           number++;
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/* 1139 */     if (this.soloData.rankRewards != null) {
/* 1140 */       Collection<SoloDataPO.RankStatus> ranks = this.soloData.rankRewards.values();
/* 1141 */       for (SoloDataPO.RankStatus rank : ranks) {
/* 1142 */         if (rank.getStatus() == 1) {
/* 1143 */           number++;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1148 */     return number;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getTimeSec(Date date) {
/* 1156 */     long zeroTime = DateUtil.getZeroToday().getTime();
/* 1157 */     return (int)Math.floor((date.getTime() - zeroTime)) / 1000;
/*      */   }
/*      */   
/*      */   public void pushLeftSoloTimeToClient() {
/* 1161 */     SoloHandler.LeftSoloTimePush.Builder data = SoloHandler.LeftSoloTimePush.newBuilder();
/* 1162 */     data.setS2CCode(200);
/*      */     
/* 1164 */     List<SoloService.OpenInfo> openList = SoloService.getInstance().getOpenInfoList();
/* 1165 */     List<Common.OpenTimeInfo> openTimeInfos = new ArrayList<>();
/* 1166 */     for (SoloService.OpenInfo oi : openList) {
/* 1167 */       int openSec = getTimeSec(oi.openTime);
/* 1168 */       int closeSec = getTimeSec(oi.closeTime);
/* 1169 */       Common.OpenTimeInfo.Builder bs = Common.OpenTimeInfo.newBuilder();
/* 1170 */       bs.setOpenTime(openSec);
/* 1171 */       bs.setCloseTime(closeSec);
/*      */       
/* 1173 */       openTimeInfos.add(bs.build());
/*      */     } 
/*      */     
/* 1176 */     data.addAllOpenList(openTimeInfos);
/* 1177 */     this.player.receive("area.soloPush.leftSoloTimePush", (GeneratedMessage)data.build());
/*      */   }
/*      */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\solo\SoloManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */