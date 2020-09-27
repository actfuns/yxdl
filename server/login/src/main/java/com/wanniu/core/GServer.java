package com.wanniu.core;

import com.wanniu.core.game.GHandlers;
import com.wanniu.core.game.GServerBootstrap;
import com.wanniu.core.game.LogicDispatcher;
import com.wanniu.core.game.PoolFactory;
import com.wanniu.core.game.message.BroadcastMessage;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.tcp.PacketDispatcher;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import io.netty.channel.Channel;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;


public class GServer {
    public enum XLang {
        CN, TW, EN, OTHER;
    }


    public static int __APP_ID = GConfig.getInstance().getInt("server.appid", 80);

    public static int __SERVER_ID = GConfig.getInstance().getServerID();

    public static XLang __SERVER_LANG = XLang.CN;


    public static boolean DEBUG = GConfig.getInstance().getBoolean("game.debug");


    private PacketDispatcher[] dispatchers = new PacketDispatcher[GConfig.getInstance().getInt("dispatcher.count", 3)];
    private Thread[] threads = new Thread[this.dispatchers.length];

    protected ConcurrentHashMap<String, Channel> loginChannels;
    protected Executor ansycExec;
    protected static GServer instance;
    private final Map<String, PacketDispatcher> Handlers;

    public void ansycExec(Runnable command) {
        this.ansycExec.execute(command);
    }


    public static GServer getInstance() {
        if (instance == null) {
            synchronized (GServer.class) {
                if (instance == null) {
                    instance = new GServer();
                }
            }
        }
        return instance;
    }

    protected GServer() {
        String lang = GConfig.getInstance().getServerLang();
        if ("tw".equalsIgnoreCase(lang)) {
            Locale.setDefault(Locale.TAIWAN);
            __SERVER_LANG = XLang.TW;
        } else if ("en".equalsIgnoreCase(lang)) {
            Locale.setDefault(Locale.ENGLISH);
            __SERVER_LANG = XLang.EN;
        } else {
            Locale.setDefault(Locale.CHINA);
            __SERVER_LANG = XLang.CN;
        }


        this.Handlers = new HashMap<>();
        this.loginChannels = new ConcurrentHashMap<>();
        this.ansycExec = new ThreadPoolExecutor(GConfig.getInstance().getInt("async.thread.min", 1), GConfig.getInstance().getInt("async.thread.max", 5), GConfig.getInstance().getInt("async.thread.idle", 30), TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (ThreadFactory) new PoolFactory("异步服务"));
        File log4j = new File(String.valueOf(GGlobal.DIR_CONF_SERVER) + "log4j.xml");
        if (log4j.exists()) DOMConfigurator.configure(log4j.getAbsolutePath());
    }

    private void initDispatcher() {
        for (int module = 0; module < this.dispatchers.length; module++) {
            this.dispatchers[module] = (PacketDispatcher) new LogicDispatcher();
            this.threads[module] = new Thread((Runnable) this.dispatchers[module], "dispatcher-module.0x" + Integer.toHexString(module));
            this.threads[module].start();
        }
        this.threads[0].setName("默认逻辑处理器");
        externalDispatcher();
        GHandlers.init(handlerPath());
    }

    protected void externalDispatcher() {
    }

    protected String handlerPath() {
        return instance.getClass().getPackage().getName();
    }

    public void addGlobalRoute(String route, PacketDispatcher dispatcher) {
        this.Handlers.put(route, dispatcher);
    }

    public void start() {
        initDispatcher();
        GServerBootstrap.getInstance().start();
        Out.info(new Object[]{"ENV -> ", __SERVER_LANG, "    DEBUG -> ", Boolean.valueOf(DEBUG)});
        Out.info(new Object[]{"游戏已成功启动运行喽，O(∩_∩)O~"});
        closeProcess();
        GSystem.free();
    }

    public BroadcastMessage stopMessage() {
        return null;
    }

    private void closeProcess() {
        Runtime.getRuntime().addShutdownHook(new Thread("程序维护") {
            public void run() {
                Out.info(new Object[]{"正在进行安全停服中..."});
                byte b;
                int i;
                PacketDispatcher[] arrayOfPacketDispatcher;
                for (i = (arrayOfPacketDispatcher = GServer.this.dispatchers).length, b = 0; b < i; ) {
                    PacketDispatcher dispatcher = arrayOfPacketDispatcher[b];
                    dispatcher.stop();
                    b++;
                }
                BroadcastMessage stopMsg = GServer.this.stopMessage();
                GServer.getInstance().sync();
                Out.info(new Object[]{"服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~"});
            }
        });
    }

    public void addPacket(Packet packet) {
        short type = packet.getHeader().getType();
        int module = type >> 8;
        if (module < this.dispatchers.length) {
            this.dispatchers[module].add(packet);
        } else {
            this.dispatchers[0].add(packet);
        }
    }

    public void putGlobalRoute(String route, Packet packet) {
        PacketDispatcher dispatcher = this.Handlers.get(route);
        if (dispatcher != null) {
            dispatcher.add(packet);
        } else {
            Out.error(new Object[]{"未实现的协议::::::::::::::::::::::::::::::::::::::::::::::::::::::" + route});
        }
    }


    public void registerHandler(NetHandler handler) {
        short type = handler.getType();
        int module = type >> 8;
        if (module < this.dispatchers.length) {
            this.dispatchers[module].registerHandler(handler);
        } else {
            this.dispatchers[0].registerHandler(handler);
        }
    }

    public Map<String, Channel> getLoginSessions() {
        return this.loginChannels;
    }

    public Channel getLoginSession(String uid) {
        return this.loginChannels.get(uid);
    }

    public void addLoginSession(Channel channel) {
        this.loginChannels.put((String) channel.attr(GGlobal._KEY_USER_ID).get(), channel);
    }

    public void onSessionClose(Channel session) {
        String uid = (String) session.attr(GGlobal._KEY_USER_ID).get();
        if (uid != null && this.loginChannels.get(uid) == session) {
            this.loginChannels.remove(uid);
        }
        Out.debug(new Object[]{uid, "连接被关闭:" + session.remoteAddress().toString()});
    }

    public void sync() {
    }
}


