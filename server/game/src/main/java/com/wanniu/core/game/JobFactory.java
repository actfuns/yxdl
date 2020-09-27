package com.wanniu.core.game;

import com.wanniu.core.logfs.Out;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public final class JobFactory {
    private static ScheduledExecutorService jobExec = Executors.newSingleThreadScheduledExecutor(new PoolFactory("排程业务"));


    public static ScheduledFuture<?> addScheduleJob(final Runnable job, long initialDelay, long delay, TimeUnit unit) {
        return jobExec.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                try {
                    job.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e}, );
                }
            }
        }, Math.max(1L, initialDelay), delay, unit);
    }


    public static ScheduledFuture<?> addScheduleJob(Runnable job, long initialDelay, long delay) {
        return addScheduleJob(job, initialDelay, delay, TimeUnit.MILLISECONDS);
    }


    public static ScheduledFuture<?> addFixedRateJob(final Runnable job, long initialDelay, long period) {
        return jobExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    job.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e}, );
                }
            }
        }, Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
    }


    public static ScheduledFuture<?> addDelayJob(Runnable job, long delay) {
        return addDelayJob(job, delay, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> addDelayJob(final Runnable job, long delay, TimeUnit unit) {
        return jobExec.schedule(new Runnable() {
            public void run() {
                try {
                    job.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e}, );
                }
            }
        }, delay, unit);
    }


    public static ScheduledFuture<?> addFixJob(final Runnable job, long initialDelay, final long delay, final int count) {
        return jobExec.schedule(new Runnable() {
            int total = count;

            public void run() {
                try {
                    job.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e}, );
                } finally {
                    if (--this.total > 0)
                        JobFactory.addFixJob(job, delay, delay, this.total);
                }
            }
        }initialDelay, TimeUnit.MILLISECONDS);
    }
}


