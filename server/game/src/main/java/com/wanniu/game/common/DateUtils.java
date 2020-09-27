package com.wanniu.game.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public final class DateUtils {
    public static final int YMDHMS = 1;
    public static final int YMDHM = 2;
    public static final int YMDH = 3;
    public static final int YMD = 4;
    public static final int YM = 5;
    public static final int Y = 6;

    public static Date now() {
        return new Date();
    }


    public static Date newDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, month - 1, day);
        return c.getTime();
    }


    public static Date newDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, month - 1, day, hour, minute, second);
        return c.getTime();
    }


    public static Date hourBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date hourEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(12, 59);
        c.set(13, 59);
        c.set(14, 999);
        return c.getTime();
    }


    public static Date dayBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date dayBegin() {
        return dayBegin(now());
    }


    public static Date dayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(11, 23);
        c.set(12, 59);
        c.set(13, 59);
        c.set(14, 999);
        return c.getTime();
    }


    public static Date dayEnd() {
        return dayEnd(now());
    }


    public static Date monthBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(5, 1);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date monthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(5, c.getActualMaximum(5));
        c.set(11, 23);
        c.set(12, 59);
        c.set(13, 59);
        c.set(14, 999);
        return c.getTime();
    }


    public static Date yearBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(6, 1);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return c.getTime();
    }


    public static Date yearEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(6, c.getActualMaximum(6));
        c.set(11, 23);
        c.set(12, 59);
        c.set(13, 59);
        c.set(14, 999);
        return c.getTime();
    }


    public static boolean isTheDay(Date date, Date day) {
        return (date.getTime() >= dayBegin(day).getTime() && date.getTime() <= dayEnd(day).getTime());
    }


    public static boolean isToday(Date date) {
        return isTheDay(date, now());
    }


    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(11, hour);
        return c.getTime();
    }


    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(5, day);
        return c.getTime();
    }


    public static Date addMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(2, month);
        return c.getTime();
    }


    public static Date addYear(Date date, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(1, year);
        return c.getTime();
    }


    public static int amountDays(Date startDate, Date endDate) {
        long ms = endDate.getTime() - startDate.getTime();
        int ret = (int) (ms / 86400000L);
        return ret;
    }


    public static int amountMonths(Date startDate, Date endDate) {
        int ret;
        Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
        boolean rev = false;
        Date d1 = startDate, d2 = endDate;
        if (startDate.getTime() > endDate.getTime()) {
            rev = true;
            d1 = endDate;
            d2 = startDate;
        }
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(1), year2 = c2.get(1), cy = year2 - year1;
        int month1 = c1.get(2), month2 = c2.get(2);

        if (cy > 0) {
            ret = (cy - 1) * 12;
            ret += month2;
            ret += 12 - month1;
        } else {
            ret = month2 - month1;
        }
        return rev ? (-1 * ret) : ret;
    }


    public static int amountYears(Date startDate, Date endDate) {
        Calendar c = Calendar.getInstance();
        boolean rev = false;
        Date d1 = startDate, d2 = endDate;
        if (startDate.getTime() > endDate.getTime()) {
            rev = true;
            d1 = endDate;
            d2 = startDate;
        }
        c.setTime(d1);
        int y1 = c.get(1);
        c.setTime(d2);
        int y2 = c.get(1);
        int ret = y2 - y1;
        return rev ? (-1 * ret) : ret;
    }


    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH");
    private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM");
    private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy");


    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        return sdf1.format(date);
    }


    public static String toString(Date date, int type) {
        if (date == null)
            return "null";
        switch (type) {
            case 1:
                return sdf1.format(date);
            case 2:
                return sdf2.format(date);
            case 3:
                return sdf3.format(date);
            case 4:
                return sdf4.format(date);
            case 5:
                return sdf5.format(date);
            case 6:
                return sdf6.format(date);
        }
        return "unknow";
    }


    public static String toString(Date date, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(date);
    }


    public static Date parse(String s, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(s);
        } catch (ParseException parseException) {
            return null;
        }
    }


    public static Date parse(String s) {
        try {
            return sdf1.parse(s);
        } catch (ParseException parseException) {
            return null;
        }
    }

    public static long parseLong(String s, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            Date t = sdf.parse(s);
            return (t == null) ? 0L : t.getTime();
        } catch (ParseException parseException) {
            return 0L;
        }
    }

    public static long parseLong(String s) {
        try {
            Date t = sdf1.parse(s);
            return (t == null) ? 0L : t.getTime();
        } catch (ParseException parseException) {
            return 0L;
        }
    }
}


