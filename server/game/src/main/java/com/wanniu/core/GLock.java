package com.wanniu.core;

import java.util.concurrent.CountDownLatch;


public class GLock {
    private CountDownLatch counter;
    private String json;

    public GLock(CountDownLatch counter) {
        this.counter = counter;
    }

    public CountDownLatch getCounter() {
        return this.counter;
    }

    public void countDown() {
        this.counter.countDown();
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}


