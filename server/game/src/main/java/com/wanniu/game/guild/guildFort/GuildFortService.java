package com.wanniu.game.guild.guildFort;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.player.GlobalConfig;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;


public class GuildFortService {
    public static final int PREPARE_AREA_ID = 54001;
    public static final int PVE_AREA_ID = 54002;
    public static final int PVP_AREA_ID = 54003;
    private static final int DAYS_PER_ROUND = GlobalConfig.GuildFort_RoundDays;
    private long MILLISECONDS_PER_ROUND = (DAYS_PER_ROUND * 24 * 3600 * 1000);
    private long BID_END_PRE_NOTICE_TIME = 1800000L;
    private long BATTLE_BEGIN_PRE_NOTICE_TIME = 600000L;
    private long BATTLE_END_PRE_NOTICE_TIME5 = 300000L;
    private long BATTLE_END_PRE_NOTICE_TIME1 = 60000L;
    private static final String[] WEEKDAY = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    public static List<String> state = new ArrayList<>();

    private long bidBeginTime;
    private long bidEndTime;
    private long battlePrepareTime;
    private long battleBeginTime;
    private long battleEndTime;
    private int firstEntry;
    private ScheduledFuture<?> bidBeginNoticeFuture = null;
    private ScheduledFuture<?> bidPreEndNoticeFuture = null;
    private ScheduledFuture<?> battlePreNoticeFuture = null;

    private ScheduledFuture<?> f1;

    private ScheduledFuture<?> f2;
    private ScheduledFuture<?> f3;
    private ScheduledFuture<?> f4;
    private ScheduledFuture<?> f5;

    public static void main(String[] args) throws InterruptedException {
        ScheduledFuture<?> f = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                System.err.println("test future");
            }
        }, 1000L, 5000L);

        Thread.sleep(2000L);
        while (!f.cancel(true)) {
            System.err.println("f cancelled:" + f.isCancelled() + " isDone:" + f.isDone());
            Thread.sleep(1000L);
        }

        System.out.println("f cancelled:" + f.isCancelled() + " isDone:" + f.isDone());
    }

    private GuildFortService() {
        initDebugConfig();
        initTimes();

        startTimers();
    }


    private void initDebugConfig() {
    }


    public void reload() {
        if (!GWorld.DEBUG) {
            return;
        }


        this.f1.cancel(true);
        this.f2.cancel(true);
        this.f3.cancel(true);
        this.f4.cancel(true);
        this.f5.cancel(true);
        cancelBidNotice();

        initTimes();
        startTimers();

        System.err.println("init guild service reloaded......");
    }


    private void initTimes() {
        long lastTime = getTimeFromString(GlobalConfig.GuildFort_BattleEndTime);
        long nowTime = System.currentTimeMillis();

        this.battleEndTime = getRealTime(GlobalConfig.GuildFort_BattleEndTime, lastTime, nowTime, "battleEndTime");

        this.bidBeginTime = getRealTime(GlobalConfig.GuildFort_BidStartTime, this.battleEndTime, nowTime, "bidBeginTime");
        this.bidEndTime = getRealTime(GlobalConfig.GuildFort_BidEndTime, this.battleEndTime, nowTime, "bidEndTime");
        this.battleBeginTime = getRealTime(GlobalConfig.GuildFort_BattleStartTime, this.battleEndTime, nowTime, "battleBeginTime");
        this.battlePrepareTime = this.battleBeginTime - (GlobalConfig.GuildFort_PreStart * 60 * 1000);
        logTimeInfo();
    }

    private long getRealTime(String timeString, long lastTime, long nowTime, String flag) {
        long configTime = getTimeFromString(timeString);

        if (nowTime > lastTime) {
            System.out.println(getRecentNextRound(configTime, nowTime));
            return getRecentNextRound(configTime, nowTime);
        }

        if (flag.equals("battleEndTime")) {
            return getCurrentRound(configTime, lastTime, flag);
        }
        return getCurrentRound(configTime, lastTime, flag);
    }


    private long getTimeFromString(String strTime) {
        if (strTime == null) {
            strTime = "5,8:25:00";
        }
        String[] strs = strTime.trim().split(",");
        int dayOfWeek = Integer.parseInt(strs[0]) + 1;
        Date date = DateUtil.format(strs[1]);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(7, dayOfWeek);
        if (dayOfWeek == 1) {
            c.add(7, 7);
        }
        return c.getTimeInMillis();
    }

    private long getNextRoundTime(long currentRoundTime) {
        Date date = new Date(currentRoundTime);
        if (GWorld.DEBUG) {
            return DateUtil.getDateAfter(date, DAYS_PER_ROUND).getTimeInMillis();
        }


        return DateUtil.getDateAfter(date, DAYS_PER_ROUND).getTimeInMillis();
    }

    private static Calendar getDateAfterMinute(Date date, int minute) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);

        now.add(12, minute);
        return now;
    }

    public void print(long timeLong) {
        System.err.println((new Date(timeLong)).toString());
    }

    private long getCurrentRound(long configTime, long lastTime, String flag) {
        while (configTime < lastTime && lastTime - configTime > this.MILLISECONDS_PER_ROUND) {
            configTime = getNextRoundTime(configTime);
        }

        return configTime;
    }

    private long getRecentNextRound(long configTime, long nowTime) {
        while (true) {
            configTime = getNextRoundTime(configTime);
            if (configTime > nowTime)
                return configTime;
        }
    }

    private long getDelayTime(long configTime) {
        long now = System.currentTimeMillis();
        if (configTime <= now) {
            configTime = getNextRoundTime(configTime);
        }
        long mills = configTime - now;
        return mills;
    }

    private String getLogString(String title, long time) {
        Date date = new Date(time);
        return title + "\t" + date.toString();
    }

    private void logTimeInfo() {
        StringBuilder sb = new StringBuilder("Guild Fort Times:\r\n");
        sb.append(getLogString("bidBeginTime\t", this.bidBeginTime)).append("\r\n");
        sb.append(getLogString("bidEndTime\t", this.bidEndTime)).append("\r\n");
        sb.append(getLogString("battlePrepareTime", this.battlePrepareTime)).append("\r\n");
        sb.append(getLogString("battleBeginTime\t", this.battleBeginTime)).append("\r\n");
        sb.append(getLogString("battleEndTime\t", this.battleEndTime)).append("\r\n");
        sb.append("-------------------------------------------------------------------");
        Out.error(new Object[]{sb.toString()});
    }

    private String getBidBeginNoticeMsg() {
        String msgStr = LangService.getValue("GUILDFORT_INBIDDING_NOTICE");
        msgStr = msgStr.replace("{beginTime}", getTimeString(this.bidBeginTime));
        msgStr = msgStr.replace("{endTime}", getTimeString(this.bidEndTime));

        return msgStr;
    }


    private static String getTimeString(long time) {
        Date d = new Date(time);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        String timeStr = DateUtil.format(d, "HH:mm:ss");
        int index = c.get(7) - 1;
        return WEEKDAY[index] + " " + timeStr;
    }

    public String getBattleBeginTimeString() {
        return getTimeString(this.battleBeginTime);
    }

    public String getBattleEndTimeString() {
        return getTimeString(this.battleEndTime);
    }


    private void startBidBeginNotice(long delay) {
        if (this.bidBeginNoticeFuture != null) {
            return;
        }
        final String msgStr = getBidBeginNoticeMsg();
        this.bidBeginNoticeFuture = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
            }
        }, delay, 86400000L);
    }

    private long getBidBeginNoticeDelay() {
        long delay = 0L;
        long now = System.currentTimeMillis();
        long begin = getTimeFromString(GlobalConfig.GuildFort_BidStartTime);

        if (begin > now) {
            delay = begin - now;
        } else {
            Date date = new Date(begin);
            delay = DateUtil.getDateAfter(date, 1).getTimeInMillis() - now;
        }
        return delay;
    }

    private void startBidPreEndNotice() {
        if (this.bidPreEndNoticeFuture != null) {
            return;
        }
        final String msgStr = LangService.getValue("GUILDFORT_PREBIDEND_NOTICE");
        this.bidPreEndNoticeFuture = JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
            }
        }, getBidEndRemainMills() - this.BID_END_PRE_NOTICE_TIME);
    }

    private void startBattlePreNoticeFuture() {
        if (this.battlePreNoticeFuture != null) {
            return;
        }
        final String msgStr = LangService.getValue("GUILDFORT_PREBATTLE_NOTICE");
        this.battlePreNoticeFuture = JobFactory.addDelayJob(new Runnable() {
            public void run() {
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
            }
        }, this.battlePrepareTime - System.currentTimeMillis() - this.BATTLE_BEGIN_PRE_NOTICE_TIME);
    }

    private void startBattleEndPreFiveMinute() {
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                String msgStr = LangService.getValue("GUILDFORT_ENDBATTLE_FIVEMINUTE_NOTICE");
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
                GuildFortService.this.startBattleEndPreOneMinute();
            }
        }, this.battleEndTime - System.currentTimeMillis() - this.BATTLE_END_PRE_NOTICE_TIME5);
    }

    private void startBattleEndPreOneMinute() {
        JobFactory.addDelayJob(new Runnable() {
            public void run() {
                String msgStr = LangService.getValue("GUILDFORT_ENDBATTLE_ONEMINUTE_NOTICE");
                GuildFortUtil.sendRollTipsToAllAnsy(msgStr);
            }
        }, this.battleEndTime - System.currentTimeMillis() - this.BATTLE_END_PRE_NOTICE_TIME1);
    }

    private void cancelBidNotice() {
        if (this.bidBeginNoticeFuture != null) {
            this.bidBeginNoticeFuture.cancel(true);
            this.bidBeginNoticeFuture = null;
        }

        if (this.bidPreEndNoticeFuture != null) {
            this.bidPreEndNoticeFuture.cancel(true);
            this.bidPreEndNoticeFuture = null;
        }
    }

    private void cancelBattleNotice() {
        if (this.battlePreNoticeFuture != null) {
            this.battlePreNoticeFuture.cancel(true);
            this.battlePreNoticeFuture = null;
        }
    }


    private void startTimers() {
        long delay = getDelayTime(this.bidBeginTime);

        this.f1 = JobFactory.addScheduleJob(new Runnable() {

            public void run() {
                GuildFortCenter.getInstance().onBidTimeBegin();
            }
        }, delay, this.MILLISECONDS_PER_ROUND);


        delay = getDelayTime(this.bidEndTime);
        this.f2 = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildFortCenter.getInstance().onBidTimeEnd();
            }
        }, delay, this.MILLISECONDS_PER_ROUND);


        delay = getDelayTime(this.battlePrepareTime);
        this.f3 = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildFortCenter.getInstance().onPrepareBattle();
            }
        }, delay, this.MILLISECONDS_PER_ROUND);

        delay = getDelayTime(this.battleBeginTime);
        this.f4 = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildFortCenter.getInstance().onBattleTimeBegin();
            }
        }, delay, this.MILLISECONDS_PER_ROUND);


        delay = getDelayTime(this.battleEndTime);
        this.f5 = JobFactory.addScheduleJob(new Runnable() {
            public void run() {
                GuildFortCenter.getInstance().onBattleTimeEnd();
                GuildFortService.this.initTimes();
                System.out.println("+++++++++++++++++++++++++战斗结束");
            }
        }, delay, this.MILLISECONDS_PER_ROUND);
    }


    private boolean isIn(long begin, long end) {
        long now = System.currentTimeMillis();
        return (now > begin && now < end);
    }

    private static class GuildFortServiceHolder {
        public static final GuildFortService INSTANCE = new GuildFortService();
    }

    public static GuildFortService getInstance() {
        return GuildFortServiceHolder.INSTANCE;
    }

    public boolean isInBidTime() {
        return isIn(this.bidBeginTime, this.bidEndTime);
    }

    public boolean isInBidEndedTime() {
        return isIn(this.bidEndTime, this.battlePrepareTime);
    }

    public boolean isInEnterFortTime() {
        return isIn(this.battlePrepareTime, this.battleEndTime);
    }

    public boolean isInPrepareBattleTime() {
        return isIn(this.battlePrepareTime, this.battleBeginTime);
    }

    public boolean isInBattleTime() {
        return isIn(this.battleBeginTime, this.battleEndTime);
    }


    public boolean isInOpen() {
        return isIn(this.bidBeginTime, this.battleEndTime);
    }

    private long getBidEndRemainMills() {
        return this.bidEndTime - System.currentTimeMillis();
    }

    public int getBidEndRemainSecond() {
        if (isInBidTime()) {
            return (int) (getBidEndRemainMills() / 1000L);
        }
        return 0;
    }

    public int getBidBeginRemainSecond() {
        if (!isInOpen()) {
            return (int) (this.bidBeginTime - System.currentTimeMillis()) / 1000;
        }
        return 0;
    }

    public int getBattleBeginRemainSecond() {
        if (isInBidEndedTime()) {
            return (int) ((this.battlePrepareTime - System.currentTimeMillis()) / 1000L);
        }
        return 0;
    }
}


