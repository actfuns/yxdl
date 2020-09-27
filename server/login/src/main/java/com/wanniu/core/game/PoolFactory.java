package com.wanniu.core.game;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


public final class PoolFactory
        implements ThreadFactory {
    static final AtomicInteger poolNumber = new AtomicInteger(1);
    final AtomicInteger threadNumber = new AtomicInteger(1);
    final String namePrefix;
    private boolean daemon = false;
    private int priority = 5;

    public void setDaemon(boolean daemon) {
        this.daemon = daemon;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PoolFactory(String name) {
        this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + name;
    }

    public PoolFactory(String name, boolean deamon) {
        this(name);
        this.daemon = deamon;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, String.valueOf(this.namePrefix) + this.threadNumber.getAndIncrement());
        t.setDaemon(this.daemon);
        t.setPriority(this.priority);
        return t;
    }
}


