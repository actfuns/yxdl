package com.wanniu.game.five2Five;

import com.wanniu.core.game.JobFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.game.common.Const;

import java.util.concurrent.TimeUnit;


public class Five2FiveMatchTeamThread
        implements Runnable {
    public void run() {
        try {
            Five2FiveMatchPool.doMatchJob();
            JobFactory.addDelayJob(this, Const.Five2Five.five2five_thread_delay_time.value, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }
}


