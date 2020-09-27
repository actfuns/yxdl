package com.wanniu.core;

import java.nio.charset.Charset;


interface GConst {
    public static final int TIME_MINUTE_SECOND = 60;
    public static final long TIME_MINUTE = 60000L;
    public static final int TIME_HOUR_SECOND = 3600;
    public static final long TIME_HOUR = 3600000L;
    public static final int TIME_DAY_SECOND = 86400;
    public static final long TIME_DAY = 86400000L;
    public static final int TIME_WEEK_SECOND = 604800;
    public static final long TIME_WEEK = 604800000L;
    public static final int TIME_MONTH_SECOND = 2592000;
    public static final long TIME_MONTH = 2592000000L;
    public static final int TIME_YEAR_SECOND = 31536000;
    public static final long TIME_YEAR = 31536000000L;
    public static final Charset UTF_8 = Charset.forName("UTF-8");
}


