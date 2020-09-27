/*     */ package com.wanniu.core.util;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
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
/*     */   
/*     */   public static long getTime() {
/*  32 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTimeSec() {
/*  37 */     return (int)(System.currentTimeMillis() / 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date format(String timeUTF) {
/*  42 */     if (timeUTF == null || "".equals(timeUTF.trim())) {
/*  43 */       return new Date();
/*     */     }
/*  45 */     StringBuilder builder = new StringBuilder();
/*  46 */     timeUTF = timeUTF.replaceAll("/|,|\\.|_", "-").trim();
/*     */     
/*  48 */     String time = null;
/*  49 */     int index1 = timeUTF.indexOf('-');
/*  50 */     if (index1 < 0) index1 = timeUTF.indexOf(' '); 
/*  51 */     int index2 = timeUTF.indexOf(':');
/*  52 */     if (index1 < 0 || (index1 > index2 && index2 > 0)) {
/*  53 */       builder.append(getDate());
/*  54 */       time = timeUTF;
/*     */     } else {
/*  56 */       String[] dateTmps = { "00", "00", "00" };
/*  57 */       String dateUTF = null;
/*  58 */       if (timeUTF.indexOf(" ") != -1) {
/*  59 */         dateUTF = timeUTF.substring(0, timeUTF.indexOf(" "));
/*  60 */         time = timeUTF.substring(timeUTF.indexOf(" ") + 1);
/*     */       } else {
/*  62 */         dateUTF = timeUTF;
/*  63 */         time = "";
/*     */       } 
/*  65 */       String[] dates = dateUTF.split("-");
/*  66 */       String date = null;
/*  67 */       for (int k = dates.length - 1, m = 2; k >= 0; k--, m--) {
/*  68 */         date = dates[k].trim();
/*  69 */         dateTmps[m] = (date.length() > 1) ? date : (String.valueOf(0) + date);
/*     */       } 
/*  71 */       if (dates.length < 3) {
/*  72 */         Calendar calender = Calendar.getInstance();
/*  73 */         if (dates.length < 2) {
/*  74 */           dateTmps[1] = String.valueOf(calender.get(2) + 1);
/*     */         }
/*  76 */         dateTmps[0] = String.valueOf(calender.get(1));
/*     */       } 
/*  78 */       builder.append(dateTmps[0]).append('-').append(dateTmps[1]).append('-').append(dateTmps[2]);
/*     */     } 
/*     */     
/*  81 */     String[] timeTmps = { "00", "00", "00", "000" };
/*  82 */     String[] ms = time.split("-");
/*  83 */     if (ms.length > 1) {
/*  84 */       String millS = ms[1].trim();
/*  85 */       if (millS.length() > 3) {
/*  86 */         millS = millS.substring(0, 3);
/*     */       } else {
/*  88 */         while (millS.length() < 3) {
/*  89 */           millS = String.valueOf(0) + millS;
/*     */         }
/*     */       } 
/*  92 */       timeTmps[3] = millS;
/*     */     } 
/*  94 */     String[] times = ms[0].split(":");
/*  95 */     String tmp = null;
/*  96 */     for (int i = times.length - 1, j = 2; i >= 0; i--, j--) {
/*  97 */       tmp = times[i].trim();
/*  98 */       timeTmps[j] = (tmp.length() > 1) ? tmp : (String.valueOf(0) + tmp);
/*     */     } 
/*     */     
/* 101 */     builder.append(' ').append(timeTmps[0]).append(':').append(timeTmps[1]).append(':').append(timeTmps[2])
/* 102 */       .append('.').append(timeTmps[3]);
/*     */     
/* 104 */     return format(builder.toString(), "yyyy-MM-dd HH:mm:ss.SSS");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date format(String timeUTF, String style) {
/* 109 */     Date date = null;
/*     */     try {
/* 111 */       SimpleDateFormat format = new SimpleDateFormat(style);
/* 112 */       Date xdate = format.parse(timeUTF);
/* 113 */       date = new Date(xdate.getTime());
/* 114 */     } catch (ParseException pe) {
/* 115 */       Out.error(new Object[] { pe });
/*     */     } 
/* 117 */     return date;
/*     */   }
/*     */   
/*     */   public static String formatUTF(String timeUTF) {
/* 121 */     return format(format(timeUTF), "yyyy-MM-dd HH:mm:ss.SSS");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String format(Date date) {
/* 126 */     return format(date, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String format(Date date, String style) {
/* 131 */     return (new SimpleDateFormat(style)).format(date);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDate() {
/* 136 */     return getTime("yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDateTime() {
/* 141 */     return getTime("yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getTime(String style) {
/* 146 */     return format(new Date(), style);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateBefore(Date date, int day) {
/* 151 */     Calendar now = Calendar.getInstance();
/* 152 */     now.setTime(date);
/* 153 */     now.add(5, -day);
/* 154 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateAfter(Date date, int day) {
/* 159 */     Calendar now = Calendar.getInstance();
/* 160 */     now.setTime(date);
/* 161 */     now.add(5, day);
/* 162 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getDateBeforeDay(int day) {
/* 167 */     return new Date(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getDateBeforeHour(int hour) {
/* 172 */     return new Date(System.currentTimeMillis() - (hour * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateBeforeIn0(int day) {
/* 177 */     Calendar now = Calendar.getInstance();
/* 178 */     now.setTimeInMillis(System.currentTimeMillis() - (day * 24 * 60 * 60 * 1000));
/* 179 */     now.set(11, 0);
/* 180 */     now.set(12, 0);
/* 181 */     now.set(13, 0);
/* 182 */     now.set(14, 0);
/* 183 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getDateAfterIn0(int day) {
/* 188 */     Calendar now = Calendar.getInstance();
/* 189 */     now.setTimeInMillis(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
/* 190 */     now.set(11, 0);
/* 191 */     now.set(12, 0);
/* 192 */     now.set(13, 0);
/* 193 */     now.set(14, 0);
/* 194 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getDateAfter(int day) {
/* 199 */     return new Date(System.currentTimeMillis() + (day * 24 * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getAfterHour(int hour) {
/* 204 */     return new Date(System.currentTimeMillis() + (hour * 60 * 60 * 1000));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Calendar getNextHour() {
/* 209 */     Calendar now = Calendar.getInstance();
/* 210 */     now.add(11, 1);
/* 211 */     now.set(12, 0);
/* 212 */     now.set(13, 0);
/* 213 */     now.set(14, 0);
/* 214 */     return now;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getDelay(String time) {
/* 219 */     if (time == null)
/* 220 */       return -1L; 
/* 221 */     long runTime = format(time).getTime();
/* 222 */     return runTime - System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getNextHourMillisecond() {
/* 227 */     Calendar c = Calendar.getInstance();
/* 228 */     c.set(13, 0);
/* 229 */     c.set(12, 0);
/* 230 */     c.set(14, 0);
/* 231 */     c.add(11, 1);
/* 232 */     return c.getTimeInMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getNextDayMillisecond() {
/* 237 */     Calendar c = Calendar.getInstance();
/* 238 */     c.set(13, 0);
/* 239 */     c.set(12, 0);
/* 240 */     c.set(14, 0);
/* 241 */     c.set(11, 0);
/* 242 */     c.add(5, 1);
/* 243 */     return c.getTimeInMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getFirstTimeOfDay(Date time) {
/* 248 */     Calendar calendar = Calendar.getInstance();
/* 249 */     calendar.setTime(time);
/* 250 */     calendar.set(11, 0);
/* 251 */     calendar.set(12, 0);
/* 252 */     calendar.set(13, 0);
/* 253 */     calendar.set(14, 0);
/* 254 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getLastTimeOfDay(Date time) {
/* 259 */     Calendar calendar = Calendar.getInstance();
/* 260 */     calendar.setTime(time);
/* 261 */     calendar.set(11, 23);
/* 262 */     calendar.set(12, 59);
/* 263 */     calendar.set(13, 59);
/* 264 */     calendar.set(14, 999);
/* 265 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getFirstDayOfMonth(Date date) {
/* 270 */     Calendar calendar = Calendar.getInstance();
/* 271 */     calendar.setTime(date);
/* 272 */     calendar.set(5, 1);
/* 273 */     calendar.set(11, 0);
/* 274 */     calendar.set(12, 0);
/* 275 */     calendar.set(13, 0);
/* 276 */     calendar.set(14, 0);
/* 277 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isSameDay(Date day1, Date day2) {
/* 282 */     Calendar cal1 = Calendar.getInstance();
/* 283 */     cal1.setTime(day1);
/* 284 */     Calendar cal2 = Calendar.getInstance();
/* 285 */     cal2.setTime(day2);
/* 286 */     return (cal1.get(1) == cal2.get(1) && 
/* 287 */       cal1.get(6) == cal2.get(6));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isToday(Date time) {
/* 297 */     return isSameDay(Calendar.getInstance().getTime(), time);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getYesterday() {
/* 302 */     return getDateBefore(new Date(), 1).getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getTomorrow() {
/* 307 */     return getNextDay(new Date());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Date getNextDay(Date date) {
/* 312 */     return getDateAfter(date, 1).getTime();
/*     */   }
/*     */   
/*     */   public static Date getZeroDate() {
/* 316 */     Calendar c = Calendar.getInstance();
/* 317 */     c.set(1, 0);
/* 318 */     c.set(2, 0);
/* 319 */     c.set(5, 0);
/* 320 */     c.set(11, 0);
/* 321 */     c.set(12, 0);
/* 322 */     c.set(13, 0);
/* 323 */     c.set(14, 0);
/* 324 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getZeroToday() {
/* 332 */     Calendar c = Calendar.getInstance();
/* 333 */     c.set(11, 0);
/* 334 */     c.set(12, 0);
/* 335 */     c.set(13, 0);
/* 336 */     c.set(14, 0);
/* 337 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getZeroTomorrow() {
/* 344 */     Calendar c = Calendar.getInstance();
/* 345 */     c.set(5, c.get(5) + 1);
/* 346 */     c.set(11, 0);
/* 347 */     c.set(12, 0);
/* 348 */     c.set(13, 0);
/* 349 */     c.set(14, 0);
/*     */     
/* 351 */     c.add(13, 10);
/* 352 */     return c.getTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(String dateTime) {
/* 361 */     long now = (new Date()).getTime();
/* 362 */     long time = format(dateTime).getTime();
/* 363 */     if (now == time)
/* 364 */       return 1; 
/* 365 */     if (now > time) {
/* 366 */       return 2;
/*     */     }
/*     */     
/* 369 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(String startStr, String endStr) {
/* 377 */     long start = format(startStr).getTime();
/* 378 */     long end = format(endStr).getTime();
/*     */     
/* 380 */     return isOutDate(start, end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(long start, long end) {
/* 388 */     long now = System.currentTimeMillis();
/* 389 */     if (now > start && now < end)
/* 390 */       return 1; 
/* 391 */     if (now > end) {
/* 392 */       return 2;
/*     */     }
/* 394 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isOutDate(String time, String startStr, String endStr) {
/* 405 */     long now = format(time).getTime();
/* 406 */     long start = format(startStr).getTime();
/* 407 */     long end = format(endStr).getTime();
/* 408 */     if (now > start && now < end)
/* 409 */       return 1; 
/* 410 */     if (now > end) {
/* 411 */       return 2;
/*     */     }
/* 413 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int isInTime(String startHour, String endHour) {
/* 421 */     if (startHour.indexOf(":") == startHour.lastIndexOf(":")) {
/* 422 */       startHour = String.valueOf(startHour) + ":00";
/*     */     }
/* 424 */     if (endHour.indexOf(":") == endHour.lastIndexOf(":")) {
/* 425 */       endHour = String.valueOf(endHour) + ":00";
/*     */     }
/* 427 */     return isOutDate(startHour, endHour);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 431 */     System.out.println(formatUTF("31 "));
/* 432 */     System.out.println(formatUTF("1:31"));
/* 433 */     System.out.println(formatUTF("12:31.31"));
/* 434 */     System.out.println(formatUTF("2010.8.30 "));
/* 435 */     System.out.println(formatUTF("2010.08.3 11"));
/* 436 */     System.out.println(formatUTF("13 13:00:00"));
/* 437 */     System.out.println(formatUTF("11"));
/* 438 */     System.out.println(formatUTF("11:11"));
/* 439 */     System.out.println(formatUTF("11:11:11"));
/* 440 */     System.out.println(formatUTF("11:11:11.111"));
/* 441 */     System.out.println(isInTime("8:00", "12:00"));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\cor\\util\DateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */