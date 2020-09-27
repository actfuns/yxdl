package com.wanniu.core.tcp.client;

import com.wanniu.core.GSystem;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import io.netty.channel.Channel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public abstract class ClientWorker
        implements Runnable, ClientCallback {
    private static final int __WARN_COUNT__ = 3000;
    protected volatile boolean disConnect = true;
    protected String serverHost;
    protected int serverPort;
    private BlockingQueue<Message> __QUEUE__ = new LinkedBlockingQueue<>();

    protected ClientBootstrap bootstrap;

    private Channel session;

    protected String name;

    public ClientWorker(String name) {
        this.name = name;
    }


    public void add(Message message) {
        this.__QUEUE__.add(message);
        if (this.__QUEUE__.size() > 3000) {
            Out.warn(new Object[]{String.valueOf(this.name) + "发送队列太长: " + this.__QUEUE__.size()});
        }
    }

    public void start() {
        if (this.bootstrap.connect(this.serverHost, this.serverPort) == null) {
            Out.error(new Object[]{String.format("无法连接%s -> %s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)})});
        }
        (new Thread(this, String.format("%s->%s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)}))).start();
    }

    public void restart() {
        this.bootstrap.quit(this.session);
        while (this.bootstrap.connect(this.serverHost, this.serverPort) == null) {
            Out.warn(new Object[]{String.format("无法重连%s -> %s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)})});
            GSystem.waitSeconds(5);
        }
    }

    public void run() {
        GSystem.waitSeconds(5);
        while (true) {
            try {
                Message msg = this.__QUEUE__.poll(10L, TimeUnit.SECONDS);
                if (msg == null) {

                    ping();
                    continue;
                }
                send(msg);
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }

    protected void send(Message msg) {
        if (this.session != null) {
            this.session.writeAndFlush(msg.getContent());
        }
    }

    public abstract void doStart();

    public void bind(Channel session) {
        Out.info(


                new Object[]{String.valueOf(this.name) + "注册成功,开始发送信息"});
        this.session = session;
        this.__QUEUE__.clear();
        this.disConnect = false;
        doStart();
    }

    public void close() {
        Out.warn(


                new Object[]{String.format("%s关闭了 - %s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)})});
        Out.info(new Object[]{String.format("开始重连%s -> %s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)})});
        restart();
        Out.info(new Object[]{String.format("成功重连%s -> %s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)})});
    }

}


