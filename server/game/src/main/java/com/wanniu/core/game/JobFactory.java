/*     */ package com.wanniu.core.game;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
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
/*     */ public final class JobFactory
/*     */ {
/*  22 */   private static ScheduledExecutorService jobExec = Executors.newSingleThreadScheduledExecutor(new PoolFactory("排程业务"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addScheduleJob(final Runnable job, long initialDelay, long delay, TimeUnit unit) {
/*  32 */     return jobExec.scheduleWithFixedDelay(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/*  36 */               job.run();
/*  37 */             } catch (Exception e) {
/*  38 */               Out.error(new Object[] { e }, );
/*     */             } 
/*     */           }
/*  41 */         },  Math.max(1L, initialDelay), delay, unit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addScheduleJob(Runnable job, long initialDelay, long delay) {
/*  52 */     return addScheduleJob(job, initialDelay, delay, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addFixedRateJob(final Runnable job, long initialDelay, long period) {
/*  63 */     return jobExec.scheduleAtFixedRate(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/*  67 */               job.run();
/*  68 */             } catch (Exception e) {
/*  69 */               Out.error(new Object[] { e }, );
/*     */             } 
/*     */           }
/*  72 */         },  Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable job, long delay) {
/*  79 */     return addDelayJob(job, delay, TimeUnit.MILLISECONDS);
/*     */   }
/*     */   
/*     */   public static ScheduledFuture<?> addDelayJob(final Runnable job, long delay, TimeUnit unit) {
/*  83 */     return jobExec.schedule(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/*  87 */               job.run();
/*  88 */             } catch (Exception e) {
/*  89 */               Out.error(new Object[] { e }, );
/*     */             } 
/*     */           }
/*     */         },  delay, unit);
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
/*     */   public static ScheduledFuture<?> addFixJob(final Runnable job, long initialDelay, final long delay, final int count) {
/* 105 */     return jobExec.schedule(new Runnable() {
/* 106 */           int total = count;
/*     */           
/*     */           public void run() {
/*     */             try {
/* 110 */               job.run();
/* 111 */             } catch (Exception e) {
/* 112 */               Out.error(new Object[] { e }, );
/*     */             } finally {
/* 114 */               if (--this.total > 0)
/* 115 */                 JobFactory.addFixJob(job, delay, delay, this.total); 
/*     */             } 
/*     */           }
/*     */         }initialDelay, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\game\JobFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */