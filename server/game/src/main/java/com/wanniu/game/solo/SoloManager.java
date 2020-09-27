package com.wanniu.game.solo;

import com.google.protobuf.GeneratedMessage;
import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GEntity;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.area.Area;
import com.wanniu.game.area.AreaUtil;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.common.HackerException;
import com.wanniu.game.common.Utils;
import com.wanniu.game.common.msg.WNNotifyManager;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.GameMapCO;
import com.wanniu.game.data.SoloMonsterCO;
import com.wanniu.game.data.SoloRankCO;
import com.wanniu.game.data.base.MapBase;
import com.wanniu.game.data.ext.SoloRankExt;
import com.wanniu.game.five2Five.Five2FiveService;
import com.wanniu.game.item.ItemUtil;
import com.wanniu.game.item.NormalItem;
import com.wanniu.game.item.VirtualItemType;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.player.bi.LogReportService;
import com.wanniu.game.poes.SoloDataPO;
import com.wanniu.game.solo.po.BattleRecordPO;
import com.wanniu.game.solo.vo.ResultVO;
import com.wanniu.game.team.TeamData;
import com.wanniu.game.team.TeamService;
import com.wanniu.redis.PlayerPOManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import pomelo.Common;
import pomelo.area.PlayerHandler;
import pomelo.area.SoloHandler;


public class SoloManager {
    private long startJoinTime;
    private WNPlayer player;
    private SoloMonsterCO robot;
    private SoloNewsHandler newsHandler;
    public SoloDataPO soloData;
    private boolean busy;
    private AtomicBoolean inFight;

    private enum REWARD_TYPE {
        DAILY_REWARD(1), WEEKLY_REWARD(2), RANK_REWARD(3);

        private int value;

        REWARD_TYPE(int value) {
            this.value = value;
        }
    }


    public void setBusy(boolean busy) {
        this.busy = busy;
    }


    public boolean isBusy() {
        return this.busy;
    }


    public SoloManager(WNPlayer player) {
        this.inFight = new AtomicBoolean(false);
        this.player = player;
        this.soloData = loadSoloData(player.getId());
        this.startJoinTime = 0L;
        this.newsHandler = new SoloNewsHandler(this.player);
    }

    private SoloDataPO loadSoloData(String playerId) {
        SoloDataPO soloDataDb = (SoloDataPO) PlayerPOManager.findPO(ConstsTR.player_solo_dataTR, playerId, SoloDataPO.class);
        if (soloDataDb == null) {
            soloDataDb = new SoloDataPO(playerId);
            PlayerPOManager.put(ConstsTR.player_solo_dataTR, playerId, (GEntity) soloDataDb);
        }
        return soloDataDb;
    }

    public int getScore() {
        return this.soloData.score;
    }

    public void addScore(int score) {
        int oldScore = this.soloData.score;
        this.soloData.score += score;
        if (this.soloData.score < 0) this.soloData.score = 0;
        int oldRankId = this.soloData.rankId;
        this.soloData.rankId = SoloService.getInstance().calcRankId(this.soloData.score);
        if (this.soloData.rankId != oldRankId) {
            this.soloData.rankGotTime = new Date();
            if (this.soloData.rankId > oldRankId) this.newsHandler.onRankIdChanged(this.soloData.rankId);
        }
        calcRankReward(oldRankId);
        if (oldScore != this.soloData.score)
            SoloService.getInstance().refreshSoloScoreToLeaderBoard(this.player, this.soloData.score);
    }

    public void addSolopoint(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) return;
        if (num < 0) throw new HackerException("增加宗师币时参数小于0.");
        int before = this.soloData.soloPoint;
        if (0L + this.soloData.soloPoint + num > 2147483647L) {
            this.soloData.soloPoint = Integer.MAX_VALUE;
        } else {
            this.soloData.soloPoint += num;
        }
        int after = this.soloData.soloPoint;
        Out.info(new Object[]{"add solopoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after), ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.SOLOPOINT, before, 1, num, after, origin.value);
        this.player.pushDynamicData(Utils.ofMap(new Object[]{"solopoint", Integer.valueOf(this.soloData.soloPoint)}));
    }

    public boolean costSolopoint(int num, Const.GOODS_CHANGE_TYPE origin) {
        if (num == 0) return true;
        if (!enoughSolopoint(num)) return false;
        int before = this.soloData.soloPoint;
        this.soloData.soloPoint -= num;
        int after = this.soloData.soloPoint;
        Out.info(new Object[]{"cost solopoint. id=", this.player.getId(), ",name=", this.player.getName(), ",before=", Integer.valueOf(before), ",value=", Integer.valueOf(num), ",after=", Integer.valueOf(after),
                ",origin=", Integer.valueOf(origin.value)});
        LogReportService.getInstance().ansycReportMoneyFlow(this.player.getPlayer(), VirtualItemType.SOLOPOINT, before, 2, num, after, origin.value);
        this.player.pushDynamicData(Utils.ofMap(new Object[]{"solopoint", Integer.valueOf(this.soloData.soloPoint)}));
        return true;
    }

    public boolean enoughSolopoint(int num) {
        if (num < 0) throw new HackerException("判定玩家身上的宗师币是否足够时参数小于0.");
        return (getSolopoint() >= num);
    }

    public int getSolopoint() {
        return this.soloData.soloPoint;
    }

    public void handleSoloInfo(SoloHandler.SoloInfoResponse.Builder res) {
        MapBase sceneProp = AreaUtil.getAreaProp(GlobalConfig.Solo_MapID);
        if (sceneProp == null) {
            Out.error(new Object[]{"there is no data of MapID: ", Integer.valueOf(GlobalConfig.Solo_MapID), " in sceneProps"});
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOMETHING_ERR"));
            return;
        }
        checkTerm();
        calcDailyChest();
        SoloHandler.MyInfo.Builder myInfo = SoloHandler.MyInfo.newBuilder();
        myInfo.setRank(getCurRank());
        myInfo.setScore(this.soloData.score);
        myInfo.setMaxContWinTimes(this.soloData.maxContWinTimes);
        myInfo.setMaxContLoseTimes(this.soloData.maxContLoseTimes);
        myInfo.setBattleTimes(this.soloData.battleTimes);
        myInfo.setWinTotalTimes(this.soloData.winTotalTimes);
        myInfo.setLoseTotalTimes(this.soloData.loseTotalTimes);
        myInfo.setSeasonEndTime(String.valueOf(SoloService.getInstance().getSeasonEndTime()));
        myInfo.setMyToken(getSolopoint());
        myInfo.setTodayToken(this.soloData.soloPointToday);
        myInfo.setMaxToken(GlobalConfig.Solo_MasterCoinGainLimit);
        myInfo.setAvgMatchTime(SoloMatcher.getInstance().getAvgMatchingTime());
        myInfo.setStartJoinTime(0);
        if (isInMatching()) myInfo.setStartJoinTime((int) Math.floor((this.startJoinTime / 1000L)));
        res.setS2CCode(200);
        res.setS2CMyInfo(myInfo.build());
        updateRedPoint();
    }

    private ResultVO firstJoinSolo(GameMapCO sceneProp) {
        ResultVO result = new ResultVO(true);
        this.player.dailyActivityMgr.onEvent(Const.DailyType.SOLO, "0", 1);
        setBusy(true);

        this.robot = SoloUtil.getSoloMonsterPropByPro(this.player.getPro());
        SoloHandler.OnSoloMatchedPush.Builder msg = SoloHandler.OnSoloMatchedPush.newBuilder();
        msg.setS2CCode(200);
        msg.setS2CVsPlayerName(this.robot.monName);
        msg.setS2CVsPlayerPro(this.robot.proID);
        msg.setS2CVsPlayerLevel(this.robot.monLevel);
        msg.addAllS2CVsPlayerAvatars(PlayerUtil.getBattleServerAvatar(this.robot.proID));
        msg.setS2CWaitResponseTimeSec(GlobalConfig.Solo_EnterTime);
        msg.setS2CIsRobot(1);
        this.player.receive("area.soloPush.onSoloMatchedPush", (GeneratedMessage) msg.build());
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                if (SoloManager.this.inFight.compareAndSet(false, true)) {
                    SoloManager.this.enterSoloRobotArea();
                }
            }
        }GlobalConfig.Solo_EnterTime, TimeUnit.SECONDS);

        result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(-1));
        result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int) Math.floor((this.startJoinTime / 1000L))));

        return result;
    }

    public void handleNewsInfo(SoloHandler.NewsInfoResponse.Builder res) {
        List<SoloHandler.NewsInfo> msgs = new ArrayList<>();
        Map<String, List<String>> allNews = SoloNewsHandler.getAllSoloNews(GWorld.__SERVER_ID);
        for (String dateStrKey : allNews.keySet()) {
            SoloHandler.NewsInfo.Builder newsInfo = SoloHandler.NewsInfo.newBuilder();
            newsInfo.setDate(dateStrKey);
            newsInfo.addAllMessage(allNews.get(dateStrKey));
            msgs.add(newsInfo.build());
        }
        res.setS2CCode(200);
        res.addAllS2CSoloMessages(msgs);
    }

    public void handleBattleRecord(SoloHandler.BattleRecordResponse.Builder res) {
        res.setS2CCode(200);
        res.setS2CCanglang(this.soloData.getWinRate(Const.Profession.canglang));
        res.setS2CYujian(this.soloData.getWinRate(Const.Profession.yujian));
        res.setS2CYixian(this.soloData.getWinRate(Const.Profession.yixian));
        res.setS2CShenjian(this.soloData.getWinRate(Const.Profession.shenjian));
        res.setS2CLinghu(this.soloData.getWinRate(Const.Profession.linghu));
        List<SoloHandler.BattleRecord> records = new ArrayList<>();
        for (int i = this.soloData.battleRecords.size() - 1; i >= 0; i--) {
            BattleRecordPO br = this.soloData.battleRecords.get(i);
            SoloHandler.BattleRecord.Builder brBuilder = SoloHandler.BattleRecord.newBuilder();
            brBuilder.setResult(br.result);
            brBuilder.setBattleTime(String.valueOf(br.battleTime.getTime()));
            brBuilder.setScore(br.score);
            brBuilder.setScoreChange(br.scoreChange);
            brBuilder.setVsName(br.vsName);
            brBuilder.setVsGuildName(br.vsGuildName);
            brBuilder.setVsPro(br.vsPro);
            brBuilder.setVsScore(br.vsScore);
            records.add(brBuilder.build());
        }
        res.addAllS2CBatttleList(records);
    }

    private int getCurRank() {
        return (int) SoloService.getInstance().getRank(this.player.getId());
    }

    public void handleRewardInfo(SoloHandler.RewardInfoResponse.Builder res) {
        List<SoloHandler.RankReward> rankRewards = new ArrayList<>();
        for (SoloDataPO.RankStatus s : this.soloData.rankRewards.values()) {
            SoloHandler.RankReward.Builder rb = SoloHandler.RankReward.newBuilder();
            rb.setRankId(s.getRankId());
            rb.setStatus(s.getStatus());
            rankRewards.add(rb.build());
        }
        res.setS2CCode(200);
        res.addAllS2CRankRewards(rankRewards);
        res.setS2CCurrRank(getCurRank());
        List<SoloHandler.SoloDailyReward> dailyRewards = new ArrayList<>();
        for (SoloDataPO.RankStatus s : this.soloData.dailyRewards) {
            SoloHandler.SoloDailyReward.Builder drb = SoloHandler.SoloDailyReward.newBuilder();
            SoloRankCO prop = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId));
            if (prop != null) {
                List<NormalItem> dailyReward = ItemUtil.createItemsByTcCode(prop.chestReward);
                for (NormalItem item : dailyReward) {
                    SoloHandler.DailyRewardItem.Builder drib = SoloHandler.DailyRewardItem.newBuilder();
                    drib.setItemCode(item.itemCode());
                    drib.setItemNum(item.getNum());
                    drb.addItems(drib.build());
                }
            }
            drb.setRankId(s.getRankId());
            drb.setStatus(s.getStatus());
            dailyRewards.add(drb.build());
        }
        res.addAllS2CDailyRewards(dailyRewards);
        res.setS2CDailyBattleTimes(this.soloData.dailyBattleTimes);
    }

    private String getGiftTypeName(REWARD_TYPE type) {
        return LangService.getValue("SOLO_GIFTTYPE" + type.value);
    }

    public void handleDrawRankReward(int rankId, SoloHandler.DrawRankRewardResponse.Builder res) {
        SoloRankExt prop = (SoloRankExt) GameData.SoloRanks.get(Integer.valueOf(rankId));
        SoloDataPO.RankStatus myRankReward = (SoloDataPO.RankStatus) this.soloData.rankRewards.get(Integer.valueOf(rankId));
        if (prop == null || myRankReward == null) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
            return;
        }
        int status = myRankReward.getStatus();
        if (status == 2) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOLO_REWARD_HAS_DRAWED"));
            return;
        }
        if (status != 1) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOLO_REWARD_CANNOT_DRAW"));
            return;
        }
        List<NormalItem> rankReward = ItemUtil.createItemsByItemCode(prop.rankRewards);
        if (!this.player.getWnBag().testAddEntityItems(rankReward, true)) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
            return;
        }
        this.player.getWnBag().addEntityItems(rankReward, Const.GOODS_CHANGE_TYPE.solo);
        myRankReward.setStatus(2);
        this.newsHandler.onGetGift(getGiftTypeName(REWARD_TYPE.RANK_REWARD), rankReward);
        this.player.taskManager.dealTaskEvent(Const.TaskType.SINCOM, "1", 1);
        updateRedPoint();
        res.setS2CCode(200);
    }

    public void handleDrawDailyReward(int index, SoloHandler.DrawDailyRewardResponse.Builder res) {
        if (index > this.soloData.dailyRewards.size()) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
            return;
        }
        index--;
        SoloDataPO.RankStatus rankStatus = this.soloData.dailyRewards.get(index);
        SoloRankCO prop = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId));
        if (prop == null || rankStatus.getStatus() != 1) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("SOLO_REWARD_NOT_EXIST"));
            return;
        }
        List<NormalItem> dailyReward = ItemUtil.createItemsByTcCode(prop.chestReward);
        if (!this.player.getWnBag().testAddEntityItems(dailyReward, true)) {
            res.setS2CCode(500);
            res.setS2CMsg(LangService.getValue("BAG_NOT_ENOUGH_POS"));
            return;
        }
        List<SoloHandler.DailyRewardItem> items = new ArrayList<>();
        for (NormalItem item : dailyReward) {
            SoloHandler.DailyRewardItem.Builder drib = SoloHandler.DailyRewardItem.newBuilder();
            drib.setItemCode(item.itemCode());
            drib.setItemNum(item.getNum());
            items.add(drib.build());
        }
        res.addAllS2CDailyRewardItems(items);
        this.player.getWnBag().addEntityItems(dailyReward, Const.GOODS_CHANGE_TYPE.solo);
        this.soloData.dailyRewards.remove(index);
        this.soloData.dailyReceived++;
        this.newsHandler.onGetGift(getGiftTypeName(REWARD_TYPE.DAILY_REWARD), dailyReward);
        this.player.taskManager.dealTaskEvent(Const.TaskType.SINCOM, "1", 1);
        updateRedPoint();
        res.setS2CCode(200);
    }

    public ResultVO handleJoinSolo() {
        ResultVO result = new ResultVO(true);
        GameMapCO sceneProp = (GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Solo_MapID));
        if (sceneProp == null) {
            Out.error(new Object[]{"there is no data of MapID: ", Integer.valueOf(GlobalConfig.Solo_MapID), " in sceneProps", null});
            result.result = false;
            result.info = "问道大会地图不存在";
            return result;
        }
        if (isBusy() || isInMatching()) {
            result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(SoloMatcher.getInstance().getAvgMatchingTime()));
            result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int) Math.floor((this.startJoinTime / 1000L))));
            return result;
        }
        if (Five2FiveService.getInstance().applyMatchTime(this.player.getId()) != null) {
            result.result = false;
            result.info = LangService.getValue("FIVE_2_FIVE_BUSY");
            return result;
        }
        if (!this.soloData.havePlayed) return firstJoinSolo(sceneProp);
        checkTerm();
        if (!SoloService.getInstance().isInOpenTime()) {
            result.result = false;
            result.info = LangService.getValue("SOLO_NOT_IN_OPEN_TIME");
            return result;
        }
        WNPlayer matchedPlayer = SoloMatcher.getInstance().findMatchedPlayer(this.soloData.score, this.player.getId());
        if (matchedPlayer != null) {
            SoloMatcher.addWaiter(this.player, matchedPlayer);
            result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(-1));
            result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int) Math.floor((this.startJoinTime / 1000L))));
        } else {
            SoloMatcher.getInstance().addToMatchingList(this.soloData.score, this.player);
            this.startJoinTime = System.currentTimeMillis();
            result.set(ResultVO.KEY.AVG_MATCHTIME, Integer.valueOf(SoloMatcher.getInstance().getAvgMatchingTime()));
            result.set(ResultVO.KEY.START_JOINTIME, Integer.valueOf((int) Math.floor((this.startJoinTime / 1000L))));
        }
        return result;
    }

    private boolean enterSoloRobotArea() {
        onEnterSoloArea();
        Map<String, Object> userData = Utils.ofMap(new Object[]{"isAddRobot", Boolean.valueOf(true), "pro", Integer.valueOf(this.player.getPro())});
        Area area = AreaUtil.createAreaAndDispatch(this.player, Arrays.asList(new String[]{this.player.getId()}, ), this.player.getLogicServerId(), GlobalConfig.Solo_MapID, userData);
        if (area == null || this.robot == null) {
            return false;
        }

        SoloArea soloArea = (SoloArea) area;
        soloArea.addRobot(this.robot);
        if (!PlayerUtil.isOnline(this.player.getId())) {
            this.player.getXmdsManager().playerReady(this.player.getId());
            area.onPlayerAutoBattle(this.player, true);
        }

        return true;
    }


    private ResultVO firstJoinSoloBattle() {
        ResultVO result = new ResultVO(true);
        if (this.inFight.compareAndSet(false, true)) {
            if (enterSoloRobotArea()) {
                result.result = true;

            } else {

                result.result = false;
                result.info = "进入问道大会场景异常";
            }
            Out.debug(new Object[]{"firstJoinSolo result:", result});
        }

        return result;
    }


    public ResultVO handleJoinSoloBattle() {
        ResultVO result = new ResultVO(true);

        if (!this.soloData.havePlayed) {
            return firstJoinSoloBattle();
        }

        if (!SoloService.getInstance().isInOpenTime()) {
            result.result = false;
            result.info = LangService.getValue("SOLO_NOT_IN_OPEN_TIME");
            return result;
        }

        if (!SoloMatcher.getInstance().joinBattle(this.player)) {
            result.result = false;
            result.info = LangService.getValue("SOLO_NO_ENEMY");
            return result;
        }

        return result;
    }


    public void handleQuitSolo() {
        quitMatching(true);
    }


    public ResultVO handleQueryReward() {
        ResultVO result = new ResultVO(true);
        result.set(ResultVO.KEY.HAS_REWARD, Integer.valueOf(hasReward()));

        return result;
    }


    public ResultVO handleLeaveSoloArea() {
        setBusy(false);
        ResultVO data = new ResultVO(true, "");

        int historyAreaId = (this.player.getPlayerTempData()).historyAreaId;
        if (historyAreaId <= 0) {
            data.result = false;
            data.info = LangService.getValue("AREA_ID_NULL");
            return data;
        }

        Area area = AreaUtil.dispatchByAreaId(this.player, historyAreaId, (this.player.getPlayerTempData()).historyX, (this.player.getPlayerTempData()).historyY);
        if (area != null) {
            return data;
        }
        data.result = false;
        data.info = LangService.getValue("SOMETHING_ERR");
        return data;
    }


    public void refreshNewDay() {
        resetData();

        Out.debug(new Object[]{"==========>> SoloManager.refreshNewDay() on ", new Date()});
    }

    public void resetData() {
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SOLO.getValue())) {
            return;
        }

        this.soloData.dailyReceived = 0;


        if (this.soloData.dailyRewards.size() < 2) {
            SoloDataPO.RankStatus s = new SoloDataPO.RankStatus();
            s.setRankId(getRankId());
            s.setStatus(0);
            this.soloData.dailyRewards.add(s);
        }


        this.soloData.dailyBattleTimes = 0;

        this.soloData.soloPointToday = 0;
        checkTerm();
        this.soloData.dailyResetTime = new Date();


        Out.debug(new Object[]{"==========>> SoloManager.resetData() on ", new Date()});
    }


    private void checkTerm() {
        if (this.soloData.term < SoloService.getInstance().getTerm()) {


            this.soloData.dailyRewardRound = 0;

            resetRankId();
            calcRankReward(1);
            this.soloData.term = SoloService.getInstance().getTerm();

            this.soloData.contWinTimes = 0;
            this.soloData.extrWinTimes = 0;
            this.soloData.maxContWinTimes = 0;
            this.soloData.contLoseTimes = 0;
            this.soloData.maxContLoseTimes = 0;

            this.soloData.battleTimes = 0;
            this.soloData.winTotalTimes = 0;
            this.soloData.loseTotalTimes = 0;
            this.soloData.winTimes_canglang = 0;
            this.soloData.winTimes_yujian = 0;
            this.soloData.winTimes_yixian = 0;
            this.soloData.winTimes_shenjian = 0;
            this.soloData.winTimes_linghu = 0;
            this.soloData.battleTimes_canglang = 0;
            this.soloData.battleTimes_yujian = 0;
            this.soloData.battleTimes_yixian = 0;
            this.soloData.battleTimes_shenjian = 0;
            this.soloData.battleTimes_linghu = 0;
            this.soloData.battleRecords = new ArrayList();

            SoloService.getInstance().refreshSoloScoreToLeaderBoard(this.player, this.soloData.score);
        }
    }


    private String getRankName() {
        SoloRankCO rank = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(getRankId()));
        if (rank != null) {
            return rank.rankName;
        }

        return String.valueOf(getRankId());
    }


    private int getRankId() {
        return this.soloData.rankId;
    }


    private void resetRankReward() {
        ArrayList<MailData.Attachment> list = new ArrayList<>();
        MailSysData mailData = new MailSysData("Solo_reward_last");
        mailData.replace = new HashMap<>();
        mailData.replace.put("rank", getRankName());
        for (SoloDataPO.RankStatus rew : this.soloData.rankRewards.values()) {
            if (rew.getStatus() == 1) {
                SoloRankExt prop = (SoloRankExt) GameData.SoloRanks.get(Integer.valueOf(rew.getRankId()));
                if (prop == null) {
                    continue;
                }
                for (String itemCode : prop.rankRewards.keySet()) {
                    MailData.Attachment attach = new MailData.Attachment();
                    attach.itemCode = itemCode;
                    attach.itemNum = ((Integer) prop.rankRewards.get(itemCode)).intValue();
                    list.add(attach);
                }
            }
        }
        if (list.size() > 0) {
            mailData.attachments = list;
            MailUtil.getInstance().sendMailToOnePlayer(this.player.getId(), (MailData) mailData, Const.GOODS_CHANGE_TYPE.solo);
        }
        this.soloData.rankRewards = new HashMap<>();
    }

    private void resetRankId() {
        int newRankId = this.soloData.rankId / 2;
        if (newRankId == 0) {
            newRankId = 1;
        }
        if (newRankId > 10) {
            Out.error(new Object[]{"resetRankId failed. something error occurred in :", getClass()});
        }
        int newScore = ((SoloRankExt) GameData.SoloRanks.get(Integer.valueOf(newRankId))).rankScore;
        this.soloData.rankId = newRankId;
        this.soloData.score = newScore;
        resetRankReward();
    }

    public boolean isInMatching() {
        return SoloMatcher.getInstance().isInMatchingList(this.player.getId());
    }


    public void quitMatching(boolean isSilent) {
        if (isInMatching()) {
            SoloMatcher.getInstance().delToMatchingList(this.player.getId());
            if (!isSilent) {
                PlayerUtil.sendSysMessageToPlayer(LangService.getValue("SOLO_MATCHING_HAVE_QUIT"), this.player.getId(), Const.TipsType.NORMAL);
                SoloHandler.CancelMatchPush.Builder matchPush = SoloHandler.CancelMatchPush.newBuilder();
                matchPush.setS2CCode(200);
                this.player.receive("area.soloPush.cancelMatchPush", (GeneratedMessage) matchPush.build());
            }
        }
    }


    private boolean calcDailyChestOnBattled() {
        int times = 0;
        for (SoloDataPO.RankStatus s : this.soloData.dailyRewards) {
            if (s.getStatus() == 0) {
                times += GlobalConfig.Solo_PKForChest;
            }
        }
        if (times != 0) {
            this.soloData.dailyBattleTimes++;
            if (this.soloData.dailyBattleTimes >= GlobalConfig.Solo_PKForChest) {
                for (int i = 0; i < this.soloData.dailyRewards.size(); i++) {
                    SoloDataPO.RankStatus s = this.soloData.dailyRewards.get(i);
                    if (s.getStatus() == 0) {
                        s.setRankId(getRankId());
                        s.setStatus(1);
                        break;
                    }
                }
                WNNotifyManager.getInstance().pushNewReward(this.player);
                this.soloData.dailyBattleTimes = 0;
                return true;
            }
        }
        return false;
    }


    private void calcDailyChest() {
        if (!this.soloData.havePlayed && this.soloData.dailyRewards.isEmpty()) {
            SoloDataPO.RankStatus s = new SoloDataPO.RankStatus();
            s.setRankId(getRankId());
            s.setStatus(0);
            this.soloData.dailyRewards.add(s);
        }
    }


    private void calcRankReward(int oldRankId) {
        SoloDataPO.RankStatus rankReward = (SoloDataPO.RankStatus) this.soloData.rankRewards.get(Integer.valueOf(getRankId()));
        if (rankReward == null) {
            if (this.soloData.rankRewards.size() == 0) {
                for (int i = 1; i <= getRankId(); i++) {
                    SoloDataPO.RankStatus rb = new SoloDataPO.RankStatus();
                    rb.setRankId(i);
                    rb.setStatus(1);
                    this.soloData.rankRewards.put(Integer.valueOf(rb.rankId), rb);
                }
            } else {
                SoloDataPO.RankStatus rb = new SoloDataPO.RankStatus();
                rb.setRankId(getRankId());
                rb.setStatus(1);
                this.soloData.rankRewards.put(Integer.valueOf(rb.rankId), rb);
            }

            updateRedPoint();


        } else if (rankReward.getStatus() != 2) {
            rankReward.setStatus(1);

            updateRedPoint();
        }
    }


    private int winSoloPoint(int result) {
        int point = 0;
        if (this.soloData.soloPointToday < GlobalConfig.Solo_MasterCoinGainLimit) {
            point = GlobalConfig.Solo_MasterCoinGainLimit - this.soloData.soloPointToday;
        }
        if (result == 1) {
            if (point < GlobalConfig.Solo_WinGainMasterCoin) {
                return point;
            }
            return GlobalConfig.Solo_WinGainMasterCoin;
        }
        if (point < GlobalConfig.Solo_LoseGainMasterCoin) {
            return point;
        }
        return GlobalConfig.Solo_LoseGainMasterCoin;
    }


    public void onGameEnd(int result, WNPlayer vsPlayer, int addScore, int subScore) {
        setBusy(false);

        Out.debug(new Object[]{"onGameEnd playerId:", this.player.getId(), ", result:", Integer.valueOf(result), ", vsPlayerId:", vsPlayer});
        this.soloData.havePlayed = true;


        int vsScore = 0;
        String vsName = "";
        String vsGuildName = "";
        int vsPro = 0;
        if (vsPlayer != null) {
            vsScore = vsPlayer.soloManager.getScore();
            vsName = vsPlayer.getName();
            vsGuildName = vsPlayer.guildManager.getGuildName();
            vsPro = vsPlayer.getPro();
        } else {
            SoloMonsterCO monsterProp = (SoloMonsterCO) GameData.SoloMonsters.get(Integer.valueOf(this.player.getPro()));
            vsName = monsterProp.monName;
            vsPro = monsterProp.proID;
        }


        int oldRank = getCurRank();
        int oldWinTimes = this.soloData.contWinTimes;
        int oldScore = this.soloData.score;

        if (result == 1) {
            addScore(addScore);

            this.soloData.contWinTimes++;
            this.soloData.extrWinTimes++;
            this.soloData.contLoseTimes = 0;

            this.player.achievementManager.onWinSolo(this.soloData.rankId);
        } else if (result == 2) {
            addScore(subScore);
            this.soloData.contLoseTimes++;
            if (this.soloData.contLoseTimes > this.soloData.maxContLoseTimes) {
                this.soloData.maxContLoseTimes = this.soloData.contLoseTimes;
            }
            this.soloData.contWinTimes = 0;
            this.soloData.extrWinTimes = 0;
        }

        int scoreChange = this.soloData.score - oldScore;

        int addPoint = winSoloPoint(result);
        addSolopoint(addPoint, Const.GOODS_CHANGE_TYPE.solo);
        this.soloData.soloPointToday += addPoint;


        if (this.soloData.contWinTimes > oldWinTimes) {
            this.newsHandler.onStraightWin(this.soloData.contWinTimes);
            if (this.soloData.contWinTimes > this.soloData.maxContWinTimes) {
                this.soloData.maxContWinTimes = this.soloData.contWinTimes;
            }
        } else if (this.soloData.contWinTimes > oldWinTimes) {
            this.newsHandler.onStraightWinStopped(oldWinTimes, (vsPlayer != null) ? vsPlayer.getName() : "");
        }
        SoloRankCO prop = (SoloRankCO) GameData.SoloRanks.get(Integer.valueOf(this.soloData.rankId));
        if (prop != null &&
                this.soloData.extrWinTimes >= prop.extraRequire) {
            this.soloData.extrWinTimes = 0;
            this.player.achievementManager.onWinSolo(this.soloData.rankId);
        }


        boolean isAddBox = calcDailyChestOnBattled();


        BattleRecordPO battleRec = new BattleRecordPO();
        battleRec.result = result;
        battleRec.battleTime = new Date();
        battleRec.score = this.soloData.score;
        battleRec.scoreChange = scoreChange;
        battleRec.vsName = vsName;
        battleRec.vsGuildName = vsGuildName;
        battleRec.vsPro = vsPro;
        battleRec.vsScore = vsScore;
        this.soloData.recordBattle(battleRec);


        SoloHandler.GameResult.Builder gb = SoloHandler.GameResult.newBuilder();
        gb.setResult(result);
        gb.setNewScore(scoreChange);
        gb.setCurrScore(this.soloData.score);
        gb.setTokenChange(addPoint);

        int currRank = getCurRank();
        if (oldRank == 0) {
            gb.setRankChange(currRank);
        } else {
            gb.setRankChange(oldRank - currRank);
        }
        gb.setCurrentRank(currRank);
        int gameOverTime = ((GameMapCO) GameData.GameMaps.get(Integer.valueOf(GlobalConfig.Solo_MapID))).timeCount;
        WNNotifyManager.getInstance().pushGameEnd(this.player, gb.build(), gameOverTime, isAddBox);
    }


    private void cancelFollow() {
        Map<String, TeamData.TeamMemberData> members = this.player.getTeamManager().getTeamMembers();
        if (members != null) {
            if (this.player.getTeamManager().isTeamLeader()) {
                for (TeamData.TeamMemberData member : members.values()) {
                    if (member.isFollow()) {
                        TeamService.followLeader(member.getPlayer(), false);
                    }
                }
            } else {
                TeamService.followLeader(this.player, false);
            }
        }
    }

    public void onEnterSoloArea() {
        cancelFollow();
        this.soloData.lastJoinedTime = new Date();

        this.startJoinTime = 0L;

        this.player.taskManager.dealTaskEvent(Const.TaskType.JOIN_SOLO, 1);
    }


    public long getMatchedTime() {
        return System.currentTimeMillis() - this.startJoinTime;
    }

    private int hasReward() {
        if (this.soloData.dailyRewards.size() > 0) {
            return 1;
        }

        for (SoloDataPO.RankStatus r : this.soloData.rankRewards.values()) {
            if (r.getStatus() == 1) {
                return 1;
            }
        }

        return 0;
    }


    private void updateRedPoint() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        list.addAll(getSuperScript());
        this.player.updateSuperScriptList(list);
    }


    public List<PlayerHandler.SuperScriptType> getSuperScript() {
        List<PlayerHandler.SuperScriptType> list = new ArrayList<>();
        if (!this.player.functionOpenManager.isOpen(Const.FunctionType.SOLO.getValue())) {
            return list;
        }
        PlayerHandler.SuperScriptType.Builder data = PlayerHandler.SuperScriptType.newBuilder();
        data.setType(Const.SUPERSCRIPT_TYPE.SOLO.getValue());
        data.setNumber(SoloService.getInstance().isInOpenTime() ? 1 : 0);

        PlayerHandler.SuperScriptType.Builder data2 = PlayerHandler.SuperScriptType.newBuilder();
        data2.setType(Const.SUPERSCRIPT_TYPE.SOLO_REWARD.getValue());
        data2.setNumber(getRewardCount());

        list.add(data.build());
        list.add(data2.build());
        return list;
    }


    public void onPlayerOffline() {
        SoloMatcher.getInstance().playerOffline(this.player.getId());
    }


    private int getRewardCount() {
        int number = 0;
        if (this.soloData.dailyRewards.size() > 0) {
            for (SoloDataPO.RankStatus rank : this.soloData.dailyRewards) {
                if (rank.getStatus() == 1) {
                    number++;
                }
            }
        }

        if (this.soloData.rankRewards != null) {
            Collection<SoloDataPO.RankStatus> ranks = this.soloData.rankRewards.values();
            for (SoloDataPO.RankStatus rank : ranks) {
                if (rank.getStatus() == 1) {
                    number++;
                }
            }
        }

        return number;
    }


    private int getTimeSec(Date date) {
        long zeroTime = DateUtil.getZeroToday().getTime();
        return (int) Math.floor((date.getTime() - zeroTime)) / 1000;
    }

    public void pushLeftSoloTimeToClient() {
        SoloHandler.LeftSoloTimePush.Builder data = SoloHandler.LeftSoloTimePush.newBuilder();
        data.setS2CCode(200);

        List<SoloService.OpenInfo> openList = SoloService.getInstance().getOpenInfoList();
        List<Common.OpenTimeInfo> openTimeInfos = new ArrayList<>();
        for (SoloService.OpenInfo oi : openList) {
            int openSec = getTimeSec(oi.openTime);
            int closeSec = getTimeSec(oi.closeTime);
            Common.OpenTimeInfo.Builder bs = Common.OpenTimeInfo.newBuilder();
            bs.setOpenTime(openSec);
            bs.setCloseTime(closeSec);

            openTimeInfos.add(bs.build());
        }

        data.addAllOpenList(openTimeInfos);
        this.player.receive("area.soloPush.leftSoloTimePush", (GeneratedMessage) data.build());
    }
}


