package com.wanniu.game.data.ext;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.game.LangService;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;
import com.wanniu.game.GWorld;
import com.wanniu.game.common.Const;
import com.wanniu.game.common.msg.MessageUtil;
import com.wanniu.game.data.NoticeSendCO;
import com.wanniu.game.player.PlayerUtil;
import com.wanniu.game.player.WNPlayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class NoticeSendExt
        extends NoticeSendCO {
    public int[] weeks;
    private List<TimeRectangle> times;

    public void initProperty() {
        String[] weeks = this.startDay.split(",");
        this.weeks = new int[weeks.length];
        for (int i = 0; i < weeks.length; i++) {
            this.weeks[i] = Integer.parseInt(weeks[i]);
            if (this.weeks[i] == 7) {
                this.weeks[i] = 1;
            } else {
                this.weeks[i] = this.weeks[i] + 1;
            }
        }
        String[] sTimes = this.startTime.split(",");
        String[] eTimes = this.endTime.split(",");
        if (sTimes.length != eTimes.length) {
            Out.error(new Object[]{getClass(), " 时间格式不匹配..."});
        }
        this.times = new ArrayList<>(sTimes.length);
        for (int j = 0; j < sTimes.length; j++) {
            String[] sTime = sTimes[j].split(":");
            String[] eTime = eTimes[j].split(":");
            TimeRectangle timeRect = new TimeRectangle();
            timeRect.sHour = Integer.parseInt(sTime[0]);
            timeRect.sMinute = Integer.parseInt(sTime[1]);
            timeRect.eHour = Integer.parseInt(eTime[0]);
            timeRect.eMinute = Integer.parseInt(eTime[1]);
            this.times.add(timeRect);
        }
        schedeule();
    }

    public boolean isWeek(int week) {
        for (int i = 0; i < this.weeks.length; i++) {
            if (this.weeks[i] == week) {
                return true;
            }
        }
        return false;
    }

    class TimeRectangle {
        int sHour;
        int sMinute;
        int eHour;
        int eMinute;

        boolean isDuration(Calendar cal) {
            int hour = cal.get(11);
            int minute = cal.get(12);
            return ((hour > this.sHour || (hour == this.sHour && minute >= this.sMinute)) && (hour < this.eHour || (hour == this.eHour && minute < this.eMinute)));
        }
    }

    boolean isDuration(Calendar cal) {
        for (TimeRectangle rect : this.times) {
            if (rect.isDuration(cal)) {
                return true;
            }
        }
        return false;
    }

    void noticeOnlinePlayers(String msg) {
        Out.debug(new Object[]{"notice msg : ", msg});
        for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
            WNPlayer wp = (WNPlayer) p;
            wp.sendSysTip(msg, Const.TipsType.ROLL);
        }

        MessageUtil.sendRollChat(GWorld.__SERVER_ID, msg, Const.CHAT_SCOPE.SYSTEM);
    }

    void addNoticeJob(Calendar cal, int time, String msg) {
        cal.add(12, time);
        long delay = cal.getTimeInMillis() - System.currentTimeMillis();
        if (delay > 0L) {
            Out.info(new Object[]{DateUtil.format(cal.getTime()), " add notice job : ", msg});
            JobFactory.addDelayJob(() -> noticeOnlinePlayers(msg), delay);
        }


        cal.add(12, -time);
    }


    public void schedeule() {
        Calendar cal = Calendar.getInstance();
        if (isWeek(cal.get(7))) {
            long currTime = cal.getTimeInMillis();
            Out.info(new Object[]{this.schName, " schedeule notice send job..."});
            cal.set(14, 0);
            cal.set(13, 0);
            for (TimeRectangle tr : this.times) {


                cal.set(11, tr.sHour);
                cal.set(12, tr.sMinute);
                addNoticeJob(cal, -this.firstTime, String.format(this.showNotice, new Object[]{Integer.valueOf(this.firstTime)}));
                addNoticeJob(cal, -this.secondTime, String.format(this.showNotice, new Object[]{Integer.valueOf(this.secondTime)}));


                Runnable durationRun = new Runnable() {
                    public void run() {
                        Calendar newCal = Calendar.getInstance();
                        if (tr.isDuration(newCal)) {
                            NoticeSendExt.this.noticeOnlinePlayers(NoticeSendExt.this.showNotice2);
                        }
                        newCal.set(13, 0);
                        newCal.add(12, NoticeSendExt.this.spaceTime2);
                        if (tr.isDuration(newCal)) {
                            JobFactory.addDelayJob(this, newCal.getTimeInMillis() - System.currentTimeMillis());
                        }
                    }
                };
                long actTime = cal.getTimeInMillis();
                if (currTime > actTime) {
                    int spaceMinute = this.spaceTime2 * 60000;
                    actTime += ((currTime - actTime) / spaceMinute + 1L) * spaceMinute;
                }
                JobFactory.addDelayJob(durationRun, actTime - currTime);


                cal.set(11, tr.eHour);
                cal.set(12, tr.eMinute);
                addNoticeJob(cal, -this.firstTime2, String.format(this.showNotice3, new Object[]{Integer.valueOf(this.firstTime2)}));
                addNoticeJob(cal, -this.secondTime2, String.format(this.showNotice3, new Object[]{Integer.valueOf(this.secondTime2)}));


                addNoticeJob(cal, 0, LangService.format("ACTIVITY_OVER_SEND", new Object[]{this.schName}));
            }
        }
    }
}


