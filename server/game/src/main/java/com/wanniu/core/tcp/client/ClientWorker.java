package com.wanniu.core.tcp.client;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.GSystem;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.tcp.protocol.RequestMessage;
import io.netty.channel.Channel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public abstract class ClientWorker
        implements Runnable, ClientCallback {
    private static final int __WARN_COUNT__ = GConfig.getInstance().getInt("game.worker.threshold", 10000);

    protected final BlockingQueue<Message> __QUEUE__ = new LinkedBlockingQueue<>();

    protected String serverHost;

    protected int serverPort;

    protected ClientBootstrap bootstrap;

    protected Channel session;
    protected volatile boolean disconnect = true;
    protected String name;

    public String getName() {
        return this.name;
    }

    public ClientWorker() {
        this.name = getClass().getSimpleName();
    }


    public void add(Message message) {
        this.__QUEUE__.add(message);
        if (size() > __WARN_COUNT__) {
            Out.warn(new Object[]{this.name, "发送队列太长: ", Integer.valueOf(this.__QUEUE__.size())});
        }
    }

    public int size() {
        return this.__QUEUE__.size();
    }

    public void start() {
        GGame.getInstance().onWorkerBefore(this);
        bind(this.bootstrap.connect(this.serverHost, this.serverPort));
        (new Thread(this, String.format("%s->%s:%d", new Object[]{this.name, this.serverHost, Integer.valueOf(this.serverPort)}))).start();
    }


    public void run() {
        while (true) {
            try {
                if (this.disconnect) {
                    String connName = Thread.currentThread().getName();
                    Out.info(new Object[]{"开始重连", connName});
                    while ((this.session = this.bootstrap.connect(this.serverHost, this.serverPort)) == null) {
                        Out.warn(new Object[]{"无法重连", connName});
                        GSystem.waitSeconds(5);
                    }
                    Out.info(new Object[]{"成功重连", connName});
                    bind(this.session);
                }
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
        if (session != null) {
            this.session = session;
            this.__QUEUE__.clear();
            doStart();
            this.disconnect = false;
            GGame.getInstance().onWorkerReady(this);
            Out.info(new Object[]{this.name, "注册成功,开始发送信息..."});
        }
    }

    public void close(Channel session) {
        if (this.session == session) {
            this.disconnect = true;
            Out.error(new Object[]{this.name, " close!!!"});
        }
    }

    public Packet request(RequestMessage req) {
        return this.bootstrap.request(req);
    }

    public void response(long reqId, Packet pak) {
        this.bootstrap.response(reqId, pak);
    }
}


