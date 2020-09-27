package com.wanniu.game.solo;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.ConstsTR;
import com.wanniu.game.data.GameData;
import com.wanniu.game.data.SoloRankCO;
import com.wanniu.game.data.ext.SoloRankSeasonRewardExt;
import com.wanniu.game.leaderBoard.LeaderBoardDetail;
import com.wanniu.game.mail.MailUtil;
import com.wanniu.game.mail.data.MailData;
import com.wanniu.game.mail.data.MailSysData;
import com.wanniu.game.player.GlobalConfig;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;
import com.wanniu.game.rank.RankType;
import com.wanniu.game.solo.po.SoloSystemPO;
import com.wanniu.redis.GameDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SoloService {
    public static class OpenInfo {
        public String openTimeStr;
        public String closeTimeStr;
        public Date openTime;
        public Date closeTime;
    }

    private static final long MIN_SEASON_MILLISEC = TimeUnit.DAYS.toMillis(3L);
    private SoloRankCO[] soloRanks;
    private List<OpenInfo> soloOpenInfoList;
    private SoloSystemPO soloSystem;
    private static SoloService soloService;
    private static final int RANK_LIST_LIMIT = 500;
    private static final int MAX_REWARD_RANK = 10000;

    public static SoloService getInstance() {
        if (soloService == null) {
            soloService = new SoloService();
        }
        return soloService;
    }

    private SoloService() {
        init();
    }


    private void init() {
        initSoloSystem();
        initSoloRanks();
        initOpenTimeList();

        long delay = DateUtil.getFiveDelay();
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                Out.info(new Object[]{"soloService scheduleJob..."}, );
                SoloService.this.resetOpenTime();
            }
        }, delay, 86400000L);

        long seasonDelay = getSeasonEndTime() - System.currentTimeMillis();
        JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                Out.info(new Object[]{"SoloService reset soloSeason ..."}, );
                SoloService.this.resetSeason();
            }
        }, seasonDelay, (GlobalConfig.Solo_SeasonDay * 24 * 3600 * 1000));


        for (OpenInfo info : this.soloOpenInfoList) {
            JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                        WNPlayer wp = (WNPlayer) p;
                        wp.updateSuperScriptList(wp.soloManager.getSuperScript());
                    }
                }
            }, DateUtil.getTaskDelay(info.openTime), TimeUnit.DAYS.toMillis(1L));

            JobFactory.addScheduleJob(new Runnable() {
                public void run() {
                    for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
                        WNPlayer wp = (WNPlayer) p;
                        wp.updateSuperScriptList(wp.soloManager.getSuperScript());
                        wp.soloManager.quitMatching(false);
                    }
                    SoloMatcher.getInstance().resetMatchingList();
                }
            }, DateUtil.getTaskDelay(info.closeTime), TimeUnit.DAYS.toMillis(1L));
        }
    }


    private void resetOpenTime() {
        for (OpenInfo info : this.soloOpenInfoList) {
            info.openTime = DateUtil.format(info.openTimeStr);
            info.closeTime = DateUtil.format(info.closeTimeStr);
        }
        this.soloSystem.rounds++;

        updateSoloSystemToRedis();
    }


    private void resetSeason() {
        if (System.currentTimeMillis() < this.soloSystem.seasonEndTime.getTime()) {
            Out.error(new Object[]{"SoloService resetSeason error......."});
            return;
        }
        sendSeasonReward();
        this.soloSystem.seasonEndTime = calcSoloSeasonTime();
        this.soloSystem.term++;
        this.soloSystem.rounds = 1;

        updateSoloSystemToRedis();
    }


    public long getSeasonEndTime() {
        return this.soloSystem.seasonEndTime.getTime();
    }


    private void initOpenTimeList() {
        this.soloOpenInfoList = new ArrayList<>();
        String[] rangeList = GlobalConfig.Solo_Daily_OpenTime.split(";");
        for (int i = 0; i < rangeList.length; i++) {

            String[] timeList = rangeList[i].split(",");
            if (timeList.length >= 2) {
                OpenInfo oi = new OpenInfo();
                oi.openTimeStr = timeList[0];
                oi.openTime = DateUtil.format(timeList[0]);
                oi.closeTimeStr = timeList[1];
                oi.closeTime = DateUtil.format(timeList[1]);
                this.soloOpenInfoList.add(oi);
            } else {
                Out.error(new Object[]{"Error in SoloManager.getOpenTimeList() ", Integer.valueOf(timeList.length)});
            }
        }
    }


    public boolean isInOpenTime() {
        Calendar c = Calendar.getInstance();
        int weekDay = c.get(7) - 1;
        if (!GlobalConfig.Solo_Weekly_OpenTime.contains(String.valueOf(weekDay))) {
            return false;
        }
        Date nowTime = new Date();
        for (OpenInfo oi : this.soloOpenInfoList) {
            if (nowTime.after(oi.openTime) && nowTime.before(oi.closeTime)) {
                return true;
            }
        }

        return false;
    }


    public List<OpenInfo> getOpenInfoList() {
        return this.soloOpenInfoList;
    }


    private void initSoloRanks() {
        if (this.soloRanks == null || this.soloRanks.length < 1) {
            this.soloRanks = new SoloRankCO[GameData.SoloRanks.size()];
            int i = 0;
            for (SoloRankCO prop : GameData.SoloRanks.values()) {
                this.soloRanks[i] = prop;
                i++;
            }

            Arrays.sort(this.soloRanks, new Comparator<SoloRankCO>() {
                public int compare(SoloRankCO o1, SoloRankCO o2) {
                    return (o1.iD > o2.iD) ? 1 : -1;
                }
            });

            for (SoloRankCO prop : this.soloRanks) {
                Out.debug(new Object[]{"==============solorankid after sort:", Integer.valueOf(prop.iD)});
            }
        }
    }

    private void initSoloSystem() {
        SoloSystemPO syspo = (SoloSystemPO) GameDao.get(String.valueOf(GWorld.__SERVER_ID), ConstsTR.soloSystemTR, SoloSystemPO.class);
        if (syspo != null) {
            this.soloSystem = syspo;
        } else {
            this.soloSystem = new SoloSystemPO(String.valueOf(GWorld.__SERVER_ID));
            this.soloSystem.seasonEndTime = calcSoloSeasonTime();
            updateSoloSystemToRedis();
        }
    }

    private Date calcSoloSeasonTime() {
        Date endDate = _calcSeasonEndTime(GlobalConfig.Solo_SeasonDay, GlobalConfig.Solo_SeasonWeekday);
        if (endDate.getTime() - System.currentTimeMillis() < MIN_SEASON_MILLISEC) {
            endDate = _calcSeasonEndTime(GlobalConfig.Solo_SeasonDay + 7, GlobalConfig.Solo_SeasonWeekday);
        }
        return endDate;
    }


    private static Date _calcSeasonEndTime(int term, int endWeekDay) {
        if (endWeekDay >= 7) {
            endWeekDay = 0;
        }
        Date endDate = DateUtil.getFiveTimeOfDay(DateUtil.getDateAfter(term));
        Calendar endC = Calendar.getInstance();
        endC.setTime(endDate);
        endC.set(7, endWeekDay + 1);

        return endC.getTime();
    }


    public int calcRankId(int score) {
        int rankId = 0;
        for (SoloRankCO rank : this.soloRanks) {
            if (score >= rank.rankScore) {
                rankId = rank.iD;
            }
        }
        return rankId;
    }

    public int getTerm() {
        return this.soloSystem.term;
    }

    public int getRounds() {
        return this.soloSystem.rounds;
    }


    public void addSoloNews(String news) {
        List<String> msgs = this.soloSystem.soloNewses;
        if (msgs.size() >= GlobalConfig.Solo_SoloNews_Number) {
            msgs.remove(0);
        }
        msgs.add(news);
        updateSoloSystemToRedis();
    }


    public List<String> getAllSoloNews() {
        return this.soloSystem.soloNewses;
    }

    private void updateSoloSystemToRedis() {
        GameDao.update(String.valueOf(GWorld.__SERVER_ID), ConstsTR.soloSystemTR, this.soloSystem);
    }


    private void sendSeasonReward() {
        int start = 0;
        int end = start + 500;
        int season = getTerm();

        List<LeaderBoardDetail> rankList = RankType.SOLO_SCORE.getHandler().getRankDetail(GWorld.__SERVER_ID, season, start, end);
        while (rankList.size() > 0) {
            Out.debug(new Object[]{"rank list end limit :", Integer.valueOf(end)});
            for (LeaderBoardDetail board : rankList) {
                MailUtil.getInstance().sendMailToOnePlayer(board.memberId, (MailData) generateRewardMail(board.rank), Const.GOODS_CHANGE_TYPE.solo);
            }
            start += 500;
            end += 500;
            if (end > 10000) {
                break;
            }
            rankList = RankType.SOLO_SCORE.getHandler().getRankDetail(GWorld.__SERVER_ID, season, start, end);
        }
    }


    private MailSysData generateRewardMail(long rank) {
        Collection<SoloRankSeasonRewardExt> props = GameData.SoloRankSeasonRewards.values();
        for (SoloRankSeasonRewardExt prop : props) {
            if (rank >= prop.startRank && rank <= prop.stopRank) {
                ArrayList<MailData.Attachment> list = new ArrayList<>();
                MailSysData mailData = new MailSysData("Solo_reward");
                mailData.replace = new HashMap<>();
                mailData.replace.put("rank", String.valueOf(rank));

                for (String itemCode : prop.rankRewards.keySet()) {
                    MailData.Attachment attach = new MailData.Attachment();
                    attach.itemCode = itemCode;
                    attach.itemNum = ((Integer) prop.rankRewards.get(itemCode)).intValue();
                    list.add(attach);
                }
                mailData.attachments = list;
                return mailData;
            }
        }
        return null;
    }


    public void refreshSoloScoreToLeaderBoard(WNPlayer player, int score) {
        player.rankManager.onEvent(RankType.SOLO_SCORE, new Object[]{Integer.valueOf(getTerm()), Integer.valueOf(score)});
    }

    public long getRank(String playerId) {
        return RankType.SOLO_SCORE.getHandler().getSeasonRank(GWorld.__SERVER_ID, getTerm(), playerId);
    }
}


