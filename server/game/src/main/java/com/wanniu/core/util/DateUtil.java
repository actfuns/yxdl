/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DateUtil
/*     */ {
/*     */   public static final String F_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
/*     */   public static final String F_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
/*     */   public static final String F_yyyyMMdd = "yyyy-MM-dd";
/*     */   public static final String F_HHmmss = "HH:mm:ss";
/*     */   public static final String F_yyyyMM = "yyyyMM";
/*     */   public static final String F_yyyyMMdd_new = "yyyy/MM/dd";
/*     */   public static final long ONE_SECOND_MILLS = 1000L;
/*     */   public static final long ONE_MINUTE_MILLS = 60000L;
/*     */   public static final long ONE_HOUR_MILLS = 3600000L;
/*     */   public static final long ONE_DAY_MILLS = 86400000L;
/*     */   public static final int ONE_MINUTE_SEC = 60;
/*     */   public static final int ONE_HOUR_SEC = 3600;
/*     */   public static final int ONE_DAY_SEC = 86400;
/*     */   
/*     */   public static long getTime() {
/*  43 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTimeSec() {
/*  48 */     return (int)(System.currentTimeMillis() / 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date format(String timeUTF) {
/*  53 */     if (null == timeUTF || "".equals(timeUTF.trim())) {
/*  54 */       return new Date();
/*     */     }
/*  56 */     StringBuilder builder = new StringBuilder();
/*  57 */     timeUTF = timeUTF.replaceAll("/|,|\\.|_", "-").trim();
/*     */     
/*  59 */     String time = null;
/*  60 */     int index1 = timeUTF.indexOf('-');
/*  61 */     if (index1 < 0)
/*  62 */       index1 = timeUTF.indexOf(' '); 
/*  63 */     int index2 = timeUTF.indexOf(':');
/*  64 */     if (index1 < 0 || (index1 > index2 && index2 > 0)) {
/*  65 */       builder.append(getDate());
/*  66 */       time = timeUTF;
/*     */     } else {
/*  68 */       String[] dateTmps = { "00", "00", "00" };
/*  69 */       String dateUTF = null;
/*  70 */       if (timeUTF.indexOf(" ") != -1) {
/*  71 */         dateUTF = timeUTF.substring(0, timeUTF.indexOf(" "));
/*  72 */         time = timeUTF.substring(timeUTF.indexOf(" ") + 1);
/*     */       } else {
/*  74 */         dateUTF = timeUTF;
/*  75 */         time = "";
/*     */       } 
/*  77 */       String[] dates = dateUTF.split("-");
/*  78 */       String date = null;
/*  79 */       for (int k = dates.length - 1, m = 2; k >= 0; k--, m--) {
/*  80 */         date = dates[k].trim();
/*  81 */         dateTmps[m] = (date.length() > 1) ? date : (Character.MIN_VALUE + date);
/*     */       } 
/*  83 */       if (dates.length < 3) {
/*  84 */         Calendar calender = Calendar.getInstance();
/*  85 */         if (dates.length < 2) {
/*  86 */           dateTmps[1] = String.valueOf(calender.get(2) + 1);
/*     */         }
/*  88 */         dateTmps[0] = String.valueOf(calender.get(1));
/*     */       } 
/*  90 */       builder.append(dateTmps[0]).append('-').append(dateTmps[1]).append('-').append(dateTmps[2]);
/*     */     } 
/*     */     
/*  93 */     String[] timeTmps = { "00", "00", "00", "000" };
/*  94 */     String[] ms = time.split("-");
/*  95 */     if (ms.length > 1) {
/*  96 */       String millS = ms[1].trim();
/*  97 */       if (millS.length() > 3) {
/*  98 */         millS = millS.substring(0, 3);
/*     */       } else {
/* 100 */         while (millS.length() < 3) {
/* 101 */           millS = Character.MIN_VALUE + millS;
/*     */         }
/*     */       } 
/* 104 */       timeTmps[3] = millS;
/*     */     } 
/* 106 */     String[] times = ms[0].split(":");
/* 107 */     String tmp = null;
/* 108 */     for (int i = times.length - 1, j = 2; i >= 0; i--, j--) {
/* 109 */       tmp = times[i].trim();
/* 110 */       timeTmps[j] = (tmp.length() > 1) ? tmp : (Character.MIN_VALUE + tmp);
/*     */     } 
/*     */     
/* 113 */     builder.append(' ').append(timeTmps[0]).append(':').append(timeTmps[1]).append(':').append(timeTmps[2]).append('.').append(timeTmps[3]);
/*     */     
/* 115 */     return format(builder.toString(), "yyyy-MM-dd HH:mm:ss.SSS");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date format(String timeUTF, String style) {
/* 120 */     Date date = null;
/*     */     try {
/* 122 */       SimpleDateFormat format = new SimpleDateFormat(style);
/* 123 */       Date xdate = format.parse(timeUTF);
/* 124 */       date = new Date(xdate.getTime());
/* 125 */     } catch (ParseException pe) {
/* 126 */       Out.error(new Object[] { pe });
/*     */     } 
/* 128 */     return date;
/*     */   }
/*     */   
/*     */   public static String formatUTF(String timeUTF) {
/* 132 */     return format(format(timeUTF), "yyyy-MM-dd HH:mm:ss.SSS");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String format(Date date) {
/* 137 */     return format(date, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String format(Date date, String style) {
/* 142 */     return (new SimpleDateFormat(style)).format(date);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDate() {
/* 147 */     return getTime("yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDateTime() {
/* 152 */     return getTime("yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTime(String style) {
/* 157 */     return format(new Date(), style);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateBefore(Date date, int day) {
/* 162 */     Calendar now = Calendar.getInstance();
/* 163 */     now.setTime(date);
/* 164 */     now.add(5, -day);
/* 165 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateAfter(Date date, int day) {
/* 170 */     Calendar now = Calendar.getInstance();
/* 171 */     now.setTime(date);
/* 172 */     now.add(5, day);
/* 173 */     return now;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getDateBeforeDay(int day) {
/* 179 */     return new Date(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getDateBeforeHour(int hour) {
/* 184 */     return new Date(System.currentTimeMillis() - (hour * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateBeforeIn0(int day) {
/* 189 */     Calendar now = Calendar.getInstance();
/* 190 */     now.setTimeInMillis(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
/* 191 */     now.set(11, 0);
/* 192 */     now.set(12, 0);
/* 193 */     now.set(13, 0);
/* 194 */     now.set(14, 0);
/* 195 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateAfterIn0(int day) {
/* 200 */     Calendar now = Calendar.getInstance();
/* 201 */     now.setTimeInMillis(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
/* 202 */     now.set(11, 0);
/* 203 */     now.set(12, 0);
/* 204 */     now.set(13, 0);
/* 205 */     now.set(14, 0);
/* 206 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getDateAfter(int day) {
/* 211 */     return new Date(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getAfterHour(int hour) {
/* 216 */     return new Date(System.currentTimeMillis() + (hour * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getNextHour() {
/* 221 */     Calendar now = Calendar.getInstance();
/* 222 */     now.add(11, 1);
/* 223 */     now.set(12, 0);
/* 224 */     now.set(13, 0);
/* 225 */     now.set(14, 0);
/* 226 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getDelay(String time) {
/* 231 */     if (time == null)
/* 232 */       return -1L; 
/* 233 */     long runTime = format(time).getTime();
/* 234 */     return runTime - System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getNextHourMillisecond() {
/* 239 */     Calendar c = Calendar.getInstance();
/* 240 */     c.set(13, 0);
/* 241 */     c.set(12, 0);
/* 242 */     c.set(14, 0);
/* 243 */     c.add(11, 1);
/* 244 */     return c.getTimeInMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getNextDayMillisecond() {
/* 249 */     Calendar c = Calendar.getInstance();
/* 250 */     c.set(13, 0);
/* 251 */     c.set(12, 0);
/* 252 */     c.set(14, 0);
/* 253 */     c.set(11, 0);
/* 254 */     c.add(5, 1);
/* 255 */     return c.getTimeInMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getFirstTimeOfDay(Date time) {
/* 260 */     Calendar calendar = Calendar.getInstance();
/* 261 */     calendar.setTime(time);
/* 262 */     calendar.set(11, 0);
/* 263 */     calendar.set(12, 0);
/* 264 */     calendar.set(13, 0);
/* 265 */     calendar.set(14, 0);
/* 266 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getLastTimeOfDay(Date time) {
/* 271 */     Calendar calendar = Calendar.getInstance();
/* 272 */     calendar.setTime(time);
/* 273 */     calendar.set(11, 23);
/* 274 */     calendar.set(12, 59);
/* 275 */     calendar.set(13, 59);
/* 276 */     calendar.set(14, 999);
/* 277 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getFiveTimeOfDay(Date time) {
/* 282 */     Calendar calendar = Calendar.getInstance();
/* 283 */     calendar.setTime(time);
/* 284 */     calendar.set(11, 5);
/* 285 */     calendar.set(12, 0);
/* 286 */     calendar.set(13, 0);
/* 287 */     calendar.set(14, 0);
/* 288 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getFirstDayOfMonth(Date date) {
/* 293 */     Calendar calendar = Calendar.getInstance();
/* 294 */     calendar.setTime(date);
/* 295 */     calendar.set(5, 1);
/* 296 */     calendar.set(11, 0);
/* 297 */     calendar.set(12, 0);
/* 298 */     calendar.set(13, 0);
/* 299 */     calendar.set(14, 0);
/* 300 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isNeedFiveRefresh(Date day) {
/* 305 */     long refreshTime = getFiveToday().getTime();
/* 306 */     if (day.getTime() < refreshTime && System.currentTimeMillis() > refreshTime) {
/* 307 */       return true;
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSameDay(Date day1, Date day2) {
/* 314 */     Calendar cal1 = Calendar.getInstance();
/* 315 */     cal1.setTime(day1);
/* 316 */     Calendar cal2 = Calendar.getInstance();
/* 317 */     cal2.setTime(day2);
/* 318 */     return (cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isToday(Date time) {
/* 328 */     return isSameDay(Calendar.getInstance().getTime(), time);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getYesterday() {
/* 333 */     return getDateBefore(new Date(), 1).getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getTomorrow() {
/* 338 */     return getNextDay(new Date());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getNextDay(Date date) {
/* 343 */     return getDateAfter(date, 1).getTime();
/*     */   }
/*     */   
/*     */   public static Date getZeroDate() {
/* 347 */     Calendar c = Calendar.getInstance();
/* 348 */     c.set(1, 0);
/* 349 */     c.set(2, 0);
/* 350 */     c.set(5, 0);
/* 351 */     c.set(11, 0);
/* 352 */     c.set(12, 0);
/* 353 */     c.set(13, 0);
/* 354 */     c.set(14, 0);
/* 355 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getZeroToday() {
/* 362 */     Calendar c = Calendar.getInstance();
/* 363 */     c.set(11, 0);
/* 364 */     c.set(12, 0);
/* 365 */     c.set(13, 0);
/* 366 */     c.set(14, 0);
/* 367 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getZeroTomorrow() {
/* 374 */     Calendar c = Calendar.getInstance();
/* 375 */     c.set(5, c.get(5) + 1);
/* 376 */     c.set(11, 0);
/* 377 */     c.set(12, 0);
/* 378 */     c.set(13, 0);
/* 379 */     c.set(14, 0);
/*     */     
/* 381 */     c.add(13, 10);
/* 382 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getFiveToday() {
/* 389 */     Calendar c = Calendar.getInstance();
/* 390 */     c.set(11, 5);
/* 391 */     c.set(12, 0);
/* 392 */     c.set(13, 0);
/* 393 */     c.set(14, 0);
/* 394 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getFiveTomorrow() {
/* 401 */     Calendar c = Calendar.getInstance();
/* 402 */     c.set(5, c.get(5) + 1);
/* 403 */     c.set(11, 5);
/* 404 */     c.set(12, 0);
/* 405 */     c.set(13, 0);
/* 406 */     c.set(14, 0);
/*     */     
/* 408 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getFiveDelay() {
/* 417 */     long now = System.currentTimeMillis();
/* 418 */     long fiveToday = getFiveToday().getTime();
/* 419 */     long fiveTomorrow = getFiveTomorrow().getTime();
/*     */     
/* 421 */     long initialDelay = 0L;
/* 422 */     if (now <= fiveToday) {
/* 423 */       initialDelay = fiveToday - now;
/*     */     } else {
/* 425 */       initialDelay = fiveTomorrow - now;
/*     */     } 
/* 427 */     return initialDelay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getSomeDateDelay(long someDate) {
/* 436 */     long now = System.currentTimeMillis();
/* 437 */     long someDateTomorrow = someDate + 86400000L;
/*     */     
/* 439 */     long initialDelay = 0L;
/* 440 */     if (now <= someDate) {
/* 441 */       initialDelay = someDate - now;
/*     */     } else {
/* 443 */       initialDelay = someDateTomorrow - now;
/*     */     } 
/* 445 */     return initialDelay;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(String dateTime) {
/* 455 */     long now = (new Date()).getTime();
/* 456 */     long time = format(dateTime).getTime();
/* 457 */     if (now == time)
/* 458 */       return 1; 
/* 459 */     if (now > time) {
/* 460 */       return 2;
/*     */     }
/*     */     
/* 463 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(String startStr, String endStr) {
/* 472 */     long start = format(startStr).getTime();
/* 473 */     long end = format(endStr).getTime();
/*     */     
/* 475 */     return isOutDate(start, end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate2(String startStr, String endStr) {
/* 484 */     long start = format(startStr).getTime();
/* 485 */     long end = format(endStr).getTime();
/*     */     
/* 487 */     if (isOutDate(start - 600000L, start) == 1) {
/* 488 */       return 1;
/*     */     }
/* 490 */     if (isOutDate(start, end) == 1) {
/* 491 */       return 2;
/*     */     }
/*     */     
/* 494 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(long start, long end) {
/* 503 */     long now = System.currentTimeMillis();
/* 504 */     if (now > start && now < end)
/* 505 */       return 1; 
/* 506 */     if (now > end) {
/* 507 */       return 2;
/*     */     }
/* 509 */     return 0;
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
/*     */   public static int isOutDate(String time, String startStr, String endStr) {
/* 521 */     long now = format(time).getTime();
/* 522 */     long start = format(startStr).getTime();
/* 523 */     long end = format(endStr).getTime();
/* 524 */     if (now > start && now < end)
/* 525 */       return 1; 
/* 526 */     if (now > end) {
/* 527 */       return 2;
/*     */     }
/* 529 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isInTime(String startHour, String endHour) {
/* 538 */     if (startHour.indexOf(":") == startHour.lastIndexOf(":")) {
/* 539 */       startHour = startHour + ":00";
/*     */     }
/* 541 */     if (endHour.indexOf(":") == endHour.lastIndexOf(":")) {
/* 542 */       endHour = endHour + ":00";
/*     */     }
/* 544 */     return isOutDate(startHour, endHour);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isInTime2(String startHour, String endHour) {
/* 553 */     if (startHour.indexOf(":") == startHour.lastIndexOf(":")) {
/* 554 */       startHour = startHour + ":00";
/*     */     }
/* 556 */     if (endHour.indexOf(":") == endHour.lastIndexOf(":")) {
/* 557 */       endHour = endHour + ":00";
/*     */     }
/* 559 */     return isOutDate2(startHour, endHour);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canRefreshData(int refreshHour, Date lastRefreshDate) {
/* 570 */     if (lastRefreshDate == null) {
/* 571 */       return true;
/*     */     }
/*     */     
/* 574 */     Calendar lastRefresh = Calendar.getInstance();
/* 575 */     lastRefresh.setTime(lastRefreshDate);
/*     */     
/* 577 */     Calendar now = Calendar.getInstance();
/*     */     
/* 579 */     long totalInterval = now.getTimeInMillis() - lastRefresh.getTimeInMillis();
/*     */     
/* 581 */     if (totalInterval >= TimeUnit.DAYS.toMillis(1L)) {
/* 582 */       return true;
/*     */     }
/*     */     
/* 585 */     if (isSameDay(lastRefresh.getTime(), now.getTime())) {
/*     */       
/* 587 */       if (now.get(11) >= refreshHour && lastRefresh.get(11) < refreshHour) {
/* 588 */         return true;
/*     */       
/*     */       }
/*     */     }
/* 592 */     else if (now.get(11) >= refreshHour || lastRefresh.get(11) < refreshHour) {
/* 593 */       return true;
/*     */     } 
/*     */     
/* 596 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getDayOfWork() {
/* 605 */     Calendar now = Calendar.getInstance();
/* 606 */     return now.get(7) - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getTaskDelay(Date runDate) {
/* 616 */     Calendar now = Calendar.getInstance();
/* 617 */     if (runDate.after(now.getTime())) {
/* 618 */       return runDate.getTime() - now.getTimeInMillis();
/*     */     }
/* 620 */     return runDate.getTime() + TimeUnit.DAYS.toMillis(1L) - now.getTimeInMillis();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 624 */     System.out.println(formatUTF("31 "));
/* 625 */     System.out.println(formatUTF("1:31"));
/* 626 */     System.out.println(formatUTF("12:31.31"));
/* 627 */     System.out.println(formatUTF("2010.8.30 "));
/* 628 */     System.out.println(formatUTF("2010.08.3 11"));
/* 629 */     System.out.println(formatUTF("13 13:00:00"));
/* 630 */     System.out.println(formatUTF("11"));
/* 631 */     System.out.println(formatUTF("11:11"));
/* 632 */     System.out.println(formatUTF("11:11:11"));
/* 633 */     System.out.println(formatUTF("11:11:11.111"));
/* 634 */     System.out.println(isInTime("8:00", "12:00"));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\cor\\util\DateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */