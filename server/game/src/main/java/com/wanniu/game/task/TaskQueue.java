package com.wanniu.game.task;

import com.wanniu.core.game.PoolFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class TaskQueue {
    private static Executor TaskExecutor = Executors.newSingleThreadExecutor((ThreadFactory) new PoolFactory("任务处理器"));


    public static void put(TaskEvent event) {
        TaskExecutor.execute(event);
    }
}


