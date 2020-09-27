/*     */ package com.wanniu.game.common;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public final class DateUtils
/*     */ {
/*     */   public static final int YMDHMS = 1;
/*     */   public static final int YMDHM = 2;
/*     */   public static final int YMDH = 3;
/*     */   public static final int YMD = 4;
/*     */   public static final int YM = 5;
/*     */   public static final int Y = 6;
/*     */   
/*     */   public static Date now() {
/*  19 */     return new Date();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date newDate(int year, int month, int day) {
/*  31 */     Calendar c = Calendar.getInstance();
/*  32 */     c.clear();
/*  33 */     c.set(year, month - 1, day);
/*  34 */     return c.getTime();
/*     */   }
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
/*     */   public static Date newDate(int year, int month, int day, int hour, int minute, int second) {
/*  49 */     Calendar c = Calendar.getInstance();
/*  50 */     c.clear();
/*  51 */     c.set(year, month - 1, day, hour, minute, second);
/*  52 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date hourBegin(Date date) {
/*  62 */     Calendar c = Calendar.getInstance();
/*  63 */     c.setTime(date);
/*  64 */     c.set(12, 0);
/*  65 */     c.set(13, 0);
/*  66 */     c.set(14, 0);
/*  67 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date hourEnd(Date date) {
/*  77 */     Calendar c = Calendar.getInstance();
/*  78 */     c.setTime(date);
/*  79 */     c.set(12, 59);
/*  80 */     c.set(13, 59);
/*  81 */     c.set(14, 999);
/*  82 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date dayBegin(Date date) {
/*  92 */     Calendar c = Calendar.getInstance();
/*  93 */     c.setTime(date);
/*  94 */     c.set(11, 0);
/*  95 */     c.set(12, 0);
/*  96 */     c.set(13, 0);
/*  97 */     c.set(14, 0);
/*  98 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date dayBegin() {
/* 108 */     return dayBegin(now());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date dayEnd(Date date) {
/* 118 */     Calendar c = Calendar.getInstance();
/* 119 */     c.setTime(date);
/* 120 */     c.set(11, 23);
/* 121 */     c.set(12, 59);
/* 122 */     c.set(13, 59);
/* 123 */     c.set(14, 999);
/* 124 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date dayEnd() {
/* 134 */     return dayEnd(now());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date monthBegin(Date date) {
/* 144 */     Calendar c = Calendar.getInstance();
/* 145 */     c.setTime(date);
/* 146 */     c.set(5, 1);
/* 147 */     c.set(11, 0);
/* 148 */     c.set(12, 0);
/* 149 */     c.set(13, 0);
/* 150 */     c.set(14, 0);
/* 151 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date monthEnd(Date date) {
/* 161 */     Calendar c = Calendar.getInstance();
/* 162 */     c.setTime(date);
/* 163 */     c.set(5, c.getActualMaximum(5));
/* 164 */     c.set(11, 23);
/* 165 */     c.set(12, 59);
/* 166 */     c.set(13, 59);
/* 167 */     c.set(14, 999);
/* 168 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date yearBegin(Date date) {
/* 178 */     Calendar c = Calendar.getInstance();
/* 179 */     c.setTime(date);
/* 180 */     c.set(6, 1);
/* 181 */     c.set(11, 0);
/* 182 */     c.set(12, 0);
/* 183 */     c.set(13, 0);
/* 184 */     c.set(14, 0);
/* 185 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date yearEnd(Date date) {
/* 195 */     Calendar c = Calendar.getInstance();
/* 196 */     c.setTime(date);
/* 197 */     c.set(6, c.getActualMaximum(6));
/* 198 */     c.set(11, 23);
/* 199 */     c.set(12, 59);
/* 200 */     c.set(13, 59);
/* 201 */     c.set(14, 999);
/* 202 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isTheDay(Date date, Date day) {
/* 213 */     return (date.getTime() >= dayBegin(day).getTime() && date.getTime() <= dayEnd(day).getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isToday(Date date) {
/* 223 */     return isTheDay(date, now());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date addHour(Date date, int hour) {
/* 234 */     Calendar c = Calendar.getInstance();
/* 235 */     c.setTime(date);
/* 236 */     c.add(11, hour);
/* 237 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date addDay(Date date, int day) {
/* 248 */     Calendar c = Calendar.getInstance();
/* 249 */     c.setTime(date);
/* 250 */     c.add(5, day);
/* 251 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date addMonth(Date date, int month) {
/* 262 */     Calendar c = Calendar.getInstance();
/* 263 */     c.setTime(date);
/* 264 */     c.add(2, month);
/* 265 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date addYear(Date date, int year) {
/* 276 */     Calendar c = Calendar.getInstance();
/* 277 */     c.setTime(date);
/* 278 */     c.add(1, year);
/* 279 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int amountDays(Date startDate, Date endDate) {
/* 290 */     long ms = endDate.getTime() - startDate.getTime();
/* 291 */     int ret = (int)(ms / 86400000L);
/* 292 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int amountMonths(Date startDate, Date endDate) {
/*     */     int ret;
/* 303 */     Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
/* 304 */     boolean rev = false;
/* 305 */     Date d1 = startDate, d2 = endDate;
/* 306 */     if (startDate.getTime() > endDate.getTime()) {
/* 307 */       rev = true;
/* 308 */       d1 = endDate;
/* 309 */       d2 = startDate;
/*     */     } 
/* 311 */     c1.setTime(d1);
/* 312 */     c2.setTime(d2);
/* 313 */     int year1 = c1.get(1), year2 = c2.get(1), cy = year2 - year1;
/* 314 */     int month1 = c1.get(2), month2 = c2.get(2);
/*     */     
/* 316 */     if (cy > 0) {
/* 317 */       ret = (cy - 1) * 12;
/* 318 */       ret += month2;
/* 319 */       ret += 12 - month1;
/*     */     } else {
/* 321 */       ret = month2 - month1;
/*     */     } 
/* 323 */     return rev ? (-1 * ret) : ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int amountYears(Date startDate, Date endDate) {
/* 334 */     Calendar c = Calendar.getInstance();
/* 335 */     boolean rev = false;
/* 336 */     Date d1 = startDate, d2 = endDate;
/* 337 */     if (startDate.getTime() > endDate.getTime()) {
/* 338 */       rev = true;
/* 339 */       d1 = endDate;
/* 340 */       d2 = startDate;
/*     */     } 
/* 342 */     c.setTime(d1);
/* 343 */     int y1 = c.get(1);
/* 344 */     c.setTime(d2);
/* 345 */     int y2 = c.get(1);
/* 346 */     int ret = y2 - y1;
/* 347 */     return rev ? (-1 * ret) : ret;
/*     */   }
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
/* 363 */   private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 364 */   private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
/* 365 */   private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH");
/* 366 */   private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
/* 367 */   private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM");
/* 368 */   private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Date date) {
/* 377 */     if (date == null)
/*     */     {
/* 379 */       return ""; } 
/* 380 */     return sdf1.format(date);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Date date, int type) {
/* 392 */     if (date == null)
/* 393 */       return "null"; 
/* 394 */     switch (type) {
/*     */       case 1:
/* 396 */         return sdf1.format(date);
/*     */       case 2:
/* 398 */         return sdf2.format(date);
/*     */       case 3:
/* 400 */         return sdf3.format(date);
/*     */       case 4:
/* 402 */         return sdf4.format(date);
/*     */       case 5:
/* 404 */         return sdf5.format(date);
/*     */       case 6:
/* 406 */         return sdf6.format(date);
/*     */     } 
/* 408 */     return "unknow";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toString(Date date, String fmt) {
/* 419 */     SimpleDateFormat sdf = new SimpleDateFormat(fmt);
/* 420 */     return sdf.format(date);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date parse(String s, String fmt) {
/* 431 */     SimpleDateFormat sdf = new SimpleDateFormat(fmt);
/*     */     try {
/* 433 */       return sdf.parse(s);
/* 434 */     } catch (ParseException parseException) {
/* 435 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date parse(String s) {
/*     */     try {
/* 446 */       return sdf1.parse(s);
/* 447 */     } catch (ParseException parseException) {
/* 448 */       return null;
/*     */     } 
/*     */   }
/*     */   public static long parseLong(String s, String fmt) {
/* 452 */     SimpleDateFormat sdf = new SimpleDateFormat(fmt);
/*     */     try {
/* 454 */       Date t = sdf.parse(s);
/* 455 */       return (t == null) ? 0L : t.getTime();
/* 456 */     } catch (ParseException parseException) {
/* 457 */       return 0L;
/*     */     } 
/*     */   }
/*     */   public static long parseLong(String s) {
/*     */     try {
/* 462 */       Date t = sdf1.parse(s);
/* 463 */       return (t == null) ? 0L : t.getTime();
/* 464 */     } catch (ParseException parseException) {
/* 465 */       return 0L;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\common\DateUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */