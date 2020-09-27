package com.wanniu.core.util;

import com.wanniu.core.logfs.Out;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public final class DateUtil {
    public static final String F_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String F_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String F_yyyyMMdd = "yyyy-MM-dd";
    public static final String F_HHmmss = "HH:mm:ss";
    public static final String F_yyyyMM = "yyyyMM";
    public static final String F_yyyyMMdd_new = "yyyy/MM/dd";
    public static final long ONE_SECOND_MILLS = 1000L;
    public static final long ONE_MINUTE_MILLS = 60000L;
    public static final long ONE_HOUR_MILLS = 3600000L;
    public static final long ONE_DAY_MILLS = 86400000L;
    public static final int ONE_MINUTE_SEC = 60;
    public static final int ONE_HOUR_SEC = 3600;
    public static final int ONE_DAY_SEC = 86400;

    public static long getTime() {
        return System.currentTimeMillis();
    }


    public static int getTimeSec() {
        return (int) (System.currentTimeMillis() / 1000L);
    }


    public static Date format(String timeUTF) {
        if (null == timeUTF || "".equals(timeUTF.trim())) {
            return new Date();
        }
        StringBuilder builder = new StringBuilder();
        timeUTF = timeUTF.replaceAll("/|,|\\.|_", "-").trim();

        String time = null;
        int index1 = timeUTF.indexOf('-');
        if (index1 < 0)
            index1 = timeUTF.indexOf(' ');
        int index2 = timeUTF.indexOf(':');
        if (index1 < 0 || (index1 > index2 && index2 > 0)) {
            builder.append(getDate());
            time = timeUTF;
        } else {
            String[] dateTmps = {"00", "00", "00"};
            String dateUTF = null;
            if (timeUTF.indexOf(" ") != -1) {
                dateUTF = timeUTF.substring(0, timeUTF.indexOf(" "));
                time = timeUTF.substring(timeUTF.indexOf(" ") + 1);
            } else {
                dateUTF = timeUTF;
                time = "";
            }
            String[] dates = dateUTF.split("-");
            String date = null;
            for (int k = dates.length - 1, m = 2; k >= 0; k--, m--) {
                date = dates[k].trim();
                dateTmps[m] = (date.length() > 1) ? date : (Character.MIN_VALUE + date);
            }
            if (dates.length < 3) {
                Calendar calender = Calendar.getInstance();
                if (dates.length < 2) {
                    dateTmps[1] = String.valueOf(calender.get(2) + 1);
                }
                dateTmps[0] = String.valueOf(calender.get(1));
            }
            builder.append(dateTmps[0]).append('-').append(dateTmps[1]).append('-').append(dateTmps[2]);
        }

        String[] timeTmps = {"00", "00", "00", "000"};
        String[] ms = time.split("-");
        if (ms.length > 1) {
            String millS = ms[1].trim();
            if (millS.length() > 3) {
                millS = millS.substring(0, 3);
            } else {
                while (millS.length() < 3) {
                    millS = Character.MIN_VALUE + millS;
                }
            }
            timeTmps[3] = millS;
        }
        String[] times = ms[0].split(":");
        String tmp = null;
        for (int i = times.length - 1, j = 2; i >= 0; i--, j--) {
            tmp = times[i].trim();
            timeTmps[j] = (tmp.length() > 1) ? tmp : (Character.MIN_VALUE + tmp);
        }

        builder.append(' ').append(timeTmps[0]).append(':').append(timeTmps[1]).append(':').append(timeTmps[2]).append('.').append(timeTmps[3]);

        return format(builder.toString(), "yyyy-MM-dd HH:mm:ss.SSS");
    }


    public static Date format(String timeUTF, String style) {
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(style);
            Date xdate = format.parse(timeUTF);
            date = new Date(xdate.getTime());
        } catch (ParseException pe) {
            Out.error(new Object[]{pe});
        }
        return date;
    }

    public static String formatUTF(String timeUTF) {
        return format(format(timeUTF), "yyyy-MM-dd HH:mm:ss.SSS");
    }


    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }


    public static String format(Date date, String style) {
        return (new SimpleDateFormat(style)).format(date);
    }


    public static String getDate() {
        return getTime("yyyy-MM-dd");
    }


    public static String getDateTime() {
        return getTime("yyyy-MM-dd HH:mm:ss");
    }


    public static String getTime(String style) {
        return format(new Date(), style);
    }


    public static Calendar getDateBefore(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(5, -day);
        return now;
    }


    public static Calendar getDateAfter(Date date, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(5, day);
        return now;
    }


    public static Date getDateBeforeDay(int day) {
        return new Date(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
    }


    public static Date getDateBeforeHour(int hour) {
        return new Date(System.currentTimeMillis() - (hour * 60 * 60 * 1000));
    }


    public static Calendar getDateBeforeIn0(int day) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        return now;
    }


    public static Calendar getDateAfterIn0(int day) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        return now;
    }


    public static Date getDateAfter(int day) {
        return new Date(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
    }


    public static Date getAfterHour(int hour) {
        return new Date(System.currentTimeMillis() + (hour * 60 * 60 * 1000));
    }


    public static Calendar getNextHour() {
        Calendar now = Calendar.getInstance();
        now.add(11, 1);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        return now;
    }


    public static long getDelay(String time) {
        if (time == null)
            return -1L;
        long runTime = format(time).getTime();
        return runTime - System.currentTimeMillis();
    }


    public static long getNextHourMillisecond() {
        Calendar c = Calendar.getInstance();
        c.set(13, 0);
        c.set(12, 0);
        c.set(14, 0);
        c.add(11, 1);
        return c.getTimeInMillis();
    }


    public static long getNextDayMillisecond() {
        Calendar c = Calendar.getInstance();
        c.set(13, 0);
        c.set(12, 0);
        c.set(14, 0);
        c.set(11, 0);
        c.add(5, 1);
        return c.getTimeInMillis();
    }


    public static Date getFirstTimeOfDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }


    public static Date getLastTimeOfDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }


    public static Date getFiveTimeOfDay(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(11, 5);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }


    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }


    public static boolean isNeedFiveRefresh(Date day) {
        long refreshTime = getFiveToday().getTime();
        if (day.getTime() < refreshTime && System.currentTimeMillis() > refreshTime) {
            return true;
        }
        return false;
    }


    public static boolean isSameDay(Date day1, Date day2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(day1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(day2);
        return (cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6));
    }


    public static boolean isToday(Date time) {
        return isSameDay(Calendar.getInstance().getTime(), time);
    }


    public static Date getYesterday() {
        return getDateBefore(new Date(), 1).getTime();
    }


    public static Date getTomorrow() {
        return getNextDay(new Date());
    }


    public static Date getNextDay(Date date) {
        return getDateAfter(date, 1).getTime();
    }

    public static Date getZeroDate() {
        Calendar c = Calendar.getInstance();
        c.set(1, 0);
        c.set(2, 0);
        c.set(5, 0);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date getZeroToday() {
        Calendar c = Calendar.getInstance();
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date getZeroTomorrow() {
        Calendar c = Calendar.getInstance();
        c.set(5, c.get(5) + 1);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);

        c.add(13, 10);
        return c.getTime();
    }


    public static Date getFiveToday() {
        Calendar c = Calendar.getInstance();
        c.set(11, 5);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date getFiveTomorrow() {
        Calendar c = Calendar.getInstance();
        c.set(5, c.get(5) + 1);
        c.set(11, 5);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);

        return c.getTime();
    }


    public static long getFiveDelay() {
        long now = System.currentTimeMillis();
        long fiveToday = getFiveToday().getTime();
        long fiveTomorrow = getFiveTomorrow().getTime();

        long initialDelay = 0L;
        if (now <= fiveToday) {
            initialDelay = fiveToday - now;
        } else {
            initialDelay = fiveTomorrow - now;
        }
        return initialDelay;
    }


    public static long getSomeDateDelay(long someDate) {
        long now = System.currentTimeMillis();
        long someDateTomorrow = someDate + 86400000L;

        long initialDelay = 0L;
        if (now <= someDate) {
            initialDelay = someDate - now;
        } else {
            initialDelay = someDateTomorrow - now;
        }
        return initialDelay;
    }


    public static int isOutDate(String dateTime) {
        long now = (new Date()).getTime();
        long time = format(dateTime).getTime();
        if (now == time)
            return 1;
        if (now > time) {
            return 2;
        }

        return 0;
    }


    public static int isOutDate(String startStr, String endStr) {
        long start = format(startStr).getTime();
        long end = format(endStr).getTime();

        return isOutDate(start, end);
    }


    public static int isOutDate2(String startStr, String endStr) {
        long start = format(startStr).getTime();
        long end = format(endStr).getTime();

        if (isOutDate(start - 600000L, start) == 1) {
            return 1;
        }
        if (isOutDate(start, end) == 1) {
            return 2;
        }

        return 0;
    }


    public static int isOutDate(long start, long end) {
        long now = System.currentTimeMillis();
        if (now > start && now < end)
            return 1;
        if (now > end) {
            return 2;
        }
        return 0;
    }


    public static int isOutDate(String time, String startStr, String endStr) {
        long now = format(time).getTime();
        long start = format(startStr).getTime();
        long end = format(endStr).getTime();
        if (now > start && now < end)
            return 1;
        if (now > end) {
            return 2;
        }
        return 0;
    }


    public static int isInTime(String startHour, String endHour) {
        if (startHour.indexOf(":") == startHour.lastIndexOf(":")) {
            startHour = startHour + ":00";
        }
        if (endHour.indexOf(":") == endHour.lastIndexOf(":")) {
            endHour = endHour + ":00";
        }
        return isOutDate(startHour, endHour);
    }


    public static int isInTime2(String startHour, String endHour) {
        if (startHour.indexOf(":") == startHour.lastIndexOf(":")) {
            startHour = startHour + ":00";
        }
        if (endHour.indexOf(":") == endHour.lastIndexOf(":")) {
            endHour = endHour + ":00";
        }
        return isOutDate2(startHour, endHour);
    }


    public static boolean canRefreshData(int refreshHour, Date lastRefreshDate) {
        if (lastRefreshDate == null) {
            return true;
        }

        Calendar lastRefresh = Calendar.getInstance();
        lastRefresh.setTime(lastRefreshDate);

        Calendar now = Calendar.getInstance();

        long totalInterval = now.getTimeInMillis() - lastRefresh.getTimeInMillis();

        if (totalInterval >= TimeUnit.DAYS.toMillis(1L)) {
            return true;
        }

        if (isSameDay(lastRefresh.getTime(), now.getTime())) {

            if (now.get(11) >= refreshHour && lastRefresh.get(11) < refreshHour) {
                return true;

            }
        } else if (now.get(11) >= refreshHour || lastRefresh.get(11) < refreshHour) {
            return true;
        }

        return false;
    }


    public static int getDayOfWork() {
        Calendar now = Calendar.getInstance();
        return now.get(7) - 1;
    }


    public static long getTaskDelay(Date runDate) {
        Calendar now = Calendar.getInstance();
        if (runDate.after(now.getTime())) {
            return runDate.getTime() - now.getTimeInMillis();
        }
        return runDate.getTime() + TimeUnit.DAYS.toMillis(1L) - now.getTimeInMillis();
    }

    public static void main(String[] args) {
        System.out.println(formatUTF("31 "));
        System.out.println(formatUTF("1:31"));
        System.out.println(formatUTF("12:31.31"));
        System.out.println(formatUTF("2010.8.30 "));
        System.out.println(formatUTF("2010.08.3 11"));
        System.out.println(formatUTF("13 13:00:00"));
        System.out.println(formatUTF("11"));
        System.out.println(formatUTF("11:11"));
        System.out.println(formatUTF("11:11:11"));
        System.out.println(formatUTF("11:11:11.111"));
        System.out.println(isInTime("8:00", "12:00"));
    }
}


