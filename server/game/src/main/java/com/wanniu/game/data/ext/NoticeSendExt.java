/*     */ package com.wanniu.game.data.ext;
/*     */ 
/*     */ import com.wanniu.core.game.JobFactory;
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.game.GWorld;
/*     */ import com.wanniu.game.common.Const;
/*     */ import com.wanniu.game.common.msg.MessageUtil;
/*     */ import com.wanniu.game.data.NoticeSendCO;
/*     */ import com.wanniu.game.player.PlayerUtil;
/*     */ import com.wanniu.game.player.WNPlayer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
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
/*     */ public class NoticeSendExt
/*     */   extends NoticeSendCO
/*     */ {
/*     */   public int[] weeks;
/*     */   private List<TimeRectangle> times;
/*     */   
/*     */   public void initProperty() {
/*  35 */     String[] weeks = this.startDay.split(",");
/*  36 */     this.weeks = new int[weeks.length];
/*  37 */     for (int i = 0; i < weeks.length; i++) {
/*  38 */       this.weeks[i] = Integer.parseInt(weeks[i]);
/*  39 */       if (this.weeks[i] == 7) {
/*  40 */         this.weeks[i] = 1;
/*     */       } else {
/*  42 */         this.weeks[i] = this.weeks[i] + 1;
/*     */       } 
/*     */     } 
/*  45 */     String[] sTimes = this.startTime.split(",");
/*  46 */     String[] eTimes = this.endTime.split(",");
/*  47 */     if (sTimes.length != eTimes.length) {
/*  48 */       Out.error(new Object[] { getClass(), " 时间格式不匹配..." });
/*     */     }
/*  50 */     this.times = new ArrayList<>(sTimes.length);
/*  51 */     for (int j = 0; j < sTimes.length; j++) {
/*  52 */       String[] sTime = sTimes[j].split(":");
/*  53 */       String[] eTime = eTimes[j].split(":");
/*  54 */       TimeRectangle timeRect = new TimeRectangle();
/*  55 */       timeRect.sHour = Integer.parseInt(sTime[0]);
/*  56 */       timeRect.sMinute = Integer.parseInt(sTime[1]);
/*  57 */       timeRect.eHour = Integer.parseInt(eTime[0]);
/*  58 */       timeRect.eMinute = Integer.parseInt(eTime[1]);
/*  59 */       this.times.add(timeRect);
/*     */     } 
/*  61 */     schedeule();
/*     */   }
/*     */   
/*     */   public boolean isWeek(int week) {
/*  65 */     for (int i = 0; i < this.weeks.length; i++) {
/*  66 */       if (this.weeks[i] == week) {
/*  67 */         return true;
/*     */       }
/*     */     } 
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   class TimeRectangle {
/*     */     int sHour;
/*     */     int sMinute;
/*     */     int eHour;
/*     */     int eMinute;
/*     */     
/*     */     boolean isDuration(Calendar cal) {
/*  80 */       int hour = cal.get(11);
/*  81 */       int minute = cal.get(12);
/*  82 */       return ((hour > this.sHour || (hour == this.sHour && minute >= this.sMinute)) && (hour < this.eHour || (hour == this.eHour && minute < this.eMinute)));
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isDuration(Calendar cal) {
/*  87 */     for (TimeRectangle rect : this.times) {
/*  88 */       if (rect.isDuration(cal)) {
/*  89 */         return true;
/*     */       }
/*     */     } 
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   void noticeOnlinePlayers(String msg) {
/*  96 */     Out.debug(new Object[] { "notice msg : ", msg });
/*  97 */     for (GPlayer p : PlayerUtil.getAllOnlinePlayer()) {
/*  98 */       WNPlayer wp = (WNPlayer)p;
/*  99 */       wp.sendSysTip(msg, Const.TipsType.ROLL);
/*     */     } 
/*     */     
/* 102 */     MessageUtil.sendRollChat(GWorld.__SERVER_ID, msg, Const.CHAT_SCOPE.SYSTEM);
/*     */   }
/*     */   
/*     */   void addNoticeJob(Calendar cal, int time, String msg) {
/* 106 */     cal.add(12, time);
/* 107 */     long delay = cal.getTimeInMillis() - System.currentTimeMillis();
/* 108 */     if (delay > 0L) {
/* 109 */       Out.info(new Object[] { DateUtil.format(cal.getTime()), " add notice job : ", msg });
/* 110 */       JobFactory.addDelayJob(() -> noticeOnlinePlayers(msg), delay);
/*     */     } 
/*     */ 
/*     */     
/* 114 */     cal.add(12, -time);
/*     */   }
/*     */ 
/*     */   
/*     */   public void schedeule() {
/* 119 */     Calendar cal = Calendar.getInstance();
/* 120 */     if (isWeek(cal.get(7))) {
/* 121 */       long currTime = cal.getTimeInMillis();
/* 122 */       Out.info(new Object[] { this.schName, " schedeule notice send job..." });
/* 123 */       cal.set(14, 0);
/* 124 */       cal.set(13, 0);
/* 125 */       for (TimeRectangle tr : this.times) {
/*     */ 
/*     */ 
/*     */         
/* 129 */         cal.set(11, tr.sHour);
/* 130 */         cal.set(12, tr.sMinute);
/* 131 */         addNoticeJob(cal, -this.firstTime, String.format(this.showNotice, new Object[] { Integer.valueOf(this.firstTime) }));
/* 132 */         addNoticeJob(cal, -this.secondTime, String.format(this.showNotice, new Object[] { Integer.valueOf(this.secondTime) }));
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         Runnable durationRun = new Runnable()
/*     */           {
/*     */             public void run() {
/* 140 */               Calendar newCal = Calendar.getInstance();
/* 141 */               if (tr.isDuration(newCal)) {
/* 142 */                 NoticeSendExt.this.noticeOnlinePlayers(NoticeSendExt.this.showNotice2);
/*     */               }
/* 144 */               newCal.set(13, 0);
/* 145 */               newCal.add(12, NoticeSendExt.this.spaceTime2);
/* 146 */               if (tr.isDuration(newCal)) {
/* 147 */                 JobFactory.addDelayJob(this, newCal.getTimeInMillis() - System.currentTimeMillis());
/*     */               }
/*     */             }
/*     */           };
/* 151 */         long actTime = cal.getTimeInMillis();
/* 152 */         if (currTime > actTime) {
/* 153 */           int spaceMinute = this.spaceTime2 * 60000;
/* 154 */           actTime += ((currTime - actTime) / spaceMinute + 1L) * spaceMinute;
/*     */         } 
/* 156 */         JobFactory.addDelayJob(durationRun, actTime - currTime);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 161 */         cal.set(11, tr.eHour);
/* 162 */         cal.set(12, tr.eMinute);
/* 163 */         addNoticeJob(cal, -this.firstTime2, String.format(this.showNotice3, new Object[] { Integer.valueOf(this.firstTime2) }));
/* 164 */         addNoticeJob(cal, -this.secondTime2, String.format(this.showNotice3, new Object[] { Integer.valueOf(this.secondTime2) }));
/*     */ 
/*     */ 
/*     */         
/* 168 */         addNoticeJob(cal, 0, LangService.format("ACTIVITY_OVER_SEND", new Object[] { this.schName }));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\data\ext\NoticeSendExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */