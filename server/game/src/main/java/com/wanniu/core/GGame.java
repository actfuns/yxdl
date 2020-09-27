package com.wanniu.core;

import com.wanniu.core.db.GDao;
import com.wanniu.core.db.connet.DBClient;
import com.wanniu.core.game.BattleDispatcher;
import com.wanniu.core.game.GHandlers;
import com.wanniu.core.game.LogicDispatcher;
import com.wanniu.core.game.PoolFactory;
import com.wanniu.core.game.entity.GClientEvent;
import com.wanniu.core.game.entity.GPlayer;
import com.wanniu.core.game.message.BroadcastMessage;
import com.wanniu.core.game.protocol.PomeloHeader;
import com.wanniu.core.game.protocol.PomeloResponse;
import com.wanniu.core.gm.GMClient;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.pay.PayClient;
import com.wanniu.core.proxy.ProxyClient;
import com.wanniu.core.tcp.PacketDispatcher;
import com.wanniu.core.tcp.client.ClientWorker;
import com.wanniu.core.tcp.protocol.Message;
import com.wanniu.core.tcp.protocol.NetHandler;
import com.wanniu.core.tcp.protocol.Packet;
import com.wanniu.core.util.StringUtil;
import com.wanniu.csharp.CSharpClient;
import com.wanniu.csharp.CSharpNode;
import io.netty.channel.Channel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class GGame {
    public static volatile long APP_TIME = System.currentTimeMillis();


    public static int __APP_ID = GConfig.getInstance().getAppID();

    public static int __SERVER_ID = GConfig.getInstance().getGameID();


    public static CSharpNode __CS_NODE = new CSharpNode("game-" + __SERVER_ID, GConfig.getInstance().get("battle.ice.host"), GConfig.getInstance().getInt("battle.fastStream.port"), GConfig.getInstance().getInt("battle.ice.port"));


    public static XLang __SERVER_LANG = XLang.CN;


    public static boolean GATE_ENABLE = false;


    public static boolean DEBUG = GConfig.getInstance().getBoolean("game.debug");


    public static boolean MONITOR = GConfig.getInstance().getBoolean("game.monitor");


    public static int PLAYER_LIMIT = GConfig.getInstance().getPlayerLimit();


    private BattleDispatcher battleDispatcher;


    private Thread battleHandleThread;

    private PacketDispatcher defaultDispatcher;

    private PacketDispatcher[] dispatchers = new PacketDispatcher[GConfig.getInstance().getInt("game.dispatcher.count", 3)];
    private Thread[] threads = new Thread[this.dispatchers.length];


    protected ConcurrentHashMap<String, GPlayer> onlinePlayers;


    protected ConcurrentHashMap<String, GPlayer> waitPlayers;

    protected ConcurrentHashMap<Integer, Channel> loginPlayers;

    protected long startServerTime = System.currentTimeMillis();

    protected final Map<String, PacketDispatcher> handlers = new HashMap<>();
    protected Executor ansycExec;
    protected static GGame instance;
    private final Set<ClientWorker> workers;

    public void ansycExec(final Runnable command) {
        this.ansycExec.execute(new Runnable() {
            public void run() {
                try {
                    command.run();
                } catch (Exception e) {
                    Out.error(new Object[]{e});
                }
            }
        });
    }


    public static GGame getInstance() {
        if (instance == null) {
            synchronized (GGame.class) {
                if (instance == null) {
                    instance = new GGame();
                }
            }
        }
        return instance;
    }

    protected GGame() {
        String lang = GConfig.getInstance().getGameLang();
        if ("vn".equalsIgnoreCase(lang)) {
            Locale.setDefault(Locale.ENGLISH);
            __SERVER_LANG = XLang.VN;
        } else {
            Locale.setDefault(Locale.CHINA);
            __SERVER_LANG = XLang.CN;
        }


        this.workers = new CopyOnWriteArraySet<>();
        this.onlinePlayers = new ConcurrentHashMap<>(512);
        this.waitPlayers = new ConcurrentHashMap<>();
        this.loginPlayers = new ConcurrentHashMap<>();
        this.ansycExec = new ThreadPoolExecutor(GConfig.getInstance().getInt("async.thread.min", 1), GConfig.getInstance().getInt("async.thread.max", 5), GConfig.getInstance().getInt("async.thread.idle", 30), TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (ThreadFactory) new PoolFactory("异步服务"));
        long initialDelay = GConfig.getInstance().getAutoSaveDelay();
        GSystem.addScheduleJob(new Runnable() {
            public void run() {
                int count = 0;
                Out.debug(new Object[]{"定时持久化用户数据......."}, );
                Collection<GPlayer> players = GGame.this.onlinePlayers.values();
                for (GPlayer player : players) {
                    if (player.getUid() != null) try {
                        player.sync();
                        if (++count % 200 == 0) GSystem.waitSeconds(1);
                    } catch (Exception e) {
                        Out.error(new Object[]{e}, );
                    }
                }
            }
        }, initialDelay, GConfig.getInstance().getAutoSaveInterval(), TimeUnit.SECONDS);
    }

    private void initDispatcher() {
        for (int module = 0; module < this.dispatchers.length; module++) {
            this.dispatchers[module] = (PacketDispatcher) new LogicDispatcher();
            this.threads[module] = new Thread((Runnable) this.dispatchers[module], "logic-line" + Integer.toHexString(module));
            this.threads[module].start();
        }
        this.defaultDispatcher = this.dispatchers[0];
        this.threads[0].setName("logic-default");
        externalDispatcher();
        String searchPath = searchPath();
        if (searchPath != null) {
            String[] paths = searchPath.split(";");
            for (String path : paths) GHandlers.init(path);
        }
        int totalHandler = 0;
        for (int i = 0; i < this.dispatchers.length; i++) {
            int handlerCount = this.dispatchers[i].getHandlerCount();
            System.out.println(this.threads[i].getName() + " handler count : " + handlerCount);
            if (DEBUG || Out.isEnableDebug())
                this.dispatchers[i].echo();
            totalHandler += handlerCount;
        }
        System.out.println("total handler count : " + totalHandler + ", glabal count : " + this.handlers.size());
    }

    protected void externalDispatcher() {
    }

    public void onWorkerBefore(ClientWorker worker) {
        Out.info(new Object[]{"on worker before : ", worker.getName()});
        this.workers.add(worker);
    }

    protected String searchPath() {
        return instance.getClass().getPackage().getName();
    }

    public void start() {
        initDispatcher();
        onBeginStart();
        DBClient.getInstance().start();
        PayClient.getInstance().start();
        ProxyClient.getInstance().start();
        CSharpClient.getInstance().start();
        GMClient.getInstance().start();
        onWorkerWatch();
        addCloseProcess();
        onAfterStart();
    }

    protected void onWorkerWatch() {
        while (this.workers.size() > 0) {
            for (ClientWorker worker : this.workers) {
                Out.info(new Object[]{worker.getName(), " is waiting..."});
            }
            GSystem.waitMills(3000);
        }
    }


    public void onWorkerReady(ClientWorker worker) {
        Out.info(new Object[]{"on worker ready : ", worker.getName()});
        this.workers.remove(worker);
    }

    protected void onBeginStart() {
        Out.info(new Object[]{"begin start..."});
    }

    protected void onAfterStart() {
        Out.info(new Object[]{"after start..."});
        final int maintain_player_time = GConfig.getInstance().getInt("game.player.maintain", 60000);
        GSystem.addFixedRateJob(new Runnable() {
            public void run() {
                if (GGame.this.waitPlayers.size() > 0) {
                    long maintain_time = System.currentTimeMillis() - maintain_player_time;
                    Collection<GPlayer> wPlayers = GGame.this.waitPlayers.values();
                    for (GPlayer player : wPlayers) {
                        if (player.getLogoutTime() == null || player.getLogoutTime().getTime() < maintain_time) {
                            try {
                                GGame.this.onRemoveWaitPlayer(player);
                            } catch (Exception e) {
                                Out.error(new Object[]{e}, );
                                GGame.this.removeWaitPlayer(player);
                            }
                        }
                    }
                }
            }
        }, maintain_player_time, maintain_player_time);

        if (MONITOR) {
            GSystem.addFixedRateJob(new Runnable() {
                public void run() {
                    GGame.this.echoMonitor();
                }
            }, 1000L, 1000L);
        }
    }

    private void removeWaitPlayer(GPlayer player) {
        try {
            this.waitPlayers.remove(player.getId());
        } catch (Exception ex) {
            Out.error(new Object[]{ex});
        } finally {
            player.free();
            player.endWatch();
        }
    }

    protected void onRemoveWaitPlayer(GPlayer player) {
        Out.debug(new Object[]{"maintain remove wait : ", player.getName()});
        removeWaitPlayer(player);
    }

    public void onSessionClose(Channel channel) {
    }

    protected void onCloseGame() {
        Out.info(new Object[]{"close game..."});
    }

    protected BroadcastMessage stopMessage() {
        return null;
    }


    private void addCloseProcess() {
        Runtime.getRuntime().addShutdownHook(new Thread("程序维护") {
            public void run() {
                Out.info(new Object[]{"正在进行安全停服中..."});
                try {
                    if (GGame.this.battleDispatcher != null) {
                        GGame.this.battleDispatcher.stop();
                    }
                    for (PacketDispatcher dispatcher : GGame.this.dispatchers) {
                        dispatcher.stop();
                    }

                    BroadcastMessage stopMsg = GGame.this.stopMessage();
                    if (stopMsg != null) {
                        for (GPlayer player : GGame.this.onlinePlayers.values()) {
                            player.receive((Message) stopMsg);
                        }
                    }
                    GGame.this.onCloseGame();
                } finally {
                    try {
                        GGame.this.sync();
                    } finally {
                        while (GDao.size() > 0) {
                            Out.info(new Object[]{String.format("等待数据保存到数据库，还有【%d】条记录！", new Object[]{Integer.valueOf(GDao.size())})});
                            GSystem.waitMills(500);
                        }
                    }
                }
                Out.info(new Object[]{"服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~"});
                Out.shutdown();
            }
        });
    }


    public void addPacket(Packet packet) {
        short type = packet.getHeader().getType();
        int module = type >> 8;
        if (module < this.dispatchers.length) {
            this.dispatchers[module].add(packet);
        } else {
            this.defaultDispatcher.add(packet);
        }
    }

    public void addBattlePacket(Packet packet) {
        this.battleDispatcher.add(packet);
    }

    public void registerBattleHandler(NetHandler handler) {
        if (this.battleDispatcher == null) {
            this.battleDispatcher = new BattleDispatcher();
            this.battleHandleThread = new Thread((Runnable) this.battleDispatcher, "战斗逻辑处理器");
            this.battleHandleThread.start();
        }
        this.battleDispatcher.registerHandler(handler);
    }

    public void addDefaultPacket(Packet packet) {
        this.defaultDispatcher.add(packet);
    }

    public void registerDefaultHandler(NetHandler handler) {
        this.defaultDispatcher.registerHandler(handler);
    }

    public void addGlobalRoute(String route, PacketDispatcher dispatcher) {
        if (this.handlers.containsKey(route)) {
            Out.error(new Object[]{"more register handler : ", route});
        }
        this.handlers.put(route, dispatcher);
    }

    public void putGlobalRoute(String route, Packet packet) {
        PacketDispatcher dispatcher = this.handlers.get(route);
        if (dispatcher != null) {
            dispatcher.add(packet);
        } else {
            Out.error(new Object[]{"未实现的协议::::::::::::::::::::::::::::::::::::::::::::::::::::::" + route});
        }
    }

    public void addClassBySearchPath(String className) {
        try {
            Class<?> clz = Class.forName(className);
            if (clz.isAnnotationPresent((Class) GClientEvent.class)) {
                registerHandler((NetHandler) clz.newInstance());
            }
            addClassByAnnotation(clz);
        } catch (Exception e) {
            Out.error(new Object[]{e});
        }
    }


    protected void addClassByAnnotation(Class<?> clz) throws Exception {
    }


    public void registerHandler(NetHandler handler) {
        short type = handler.getType();
        int module = type >> 8;
        if (module < this.dispatchers.length) {
            this.dispatchers[module].registerHandler(handler);
        } else {
            this.defaultDispatcher.registerHandler(handler);
        }
    }

    public void addPlayer(GPlayer player) {
        this.onlinePlayers.put(player.getId(), player);
        this.waitPlayers.remove(player.getId());
    }

    public GPlayer getPlayer(String rid) {
        return this.onlinePlayers.containsKey(rid) ? this.onlinePlayers.get(rid) : this.waitPlayers.get(rid);
    }

    public GPlayer getPlayerByName(String name) {
        if (StringUtil.isEmpty(name))
            return null;
        for (Map.Entry<String, GPlayer> node : this.onlinePlayers.entrySet()) {
            GPlayer player = node.getValue();
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }


    public GPlayer getPlayerByUid(String uid) {
        if (StringUtil.isEmpty(uid)) {
            return null;
        }
        for (GPlayer p : this.onlinePlayers.values()) {
            if (p.getUid().equals(uid)) {
                return p;
            }
        }

        for (GPlayer p : this.waitPlayers.values()) {
            if (p.getUid().equals(uid)) {
                return p;
            }
        }

        return null;
    }

    public void removePlayer(GPlayer player) {
        this.onlinePlayers.remove(player.getId());
    }

    public Map<String, GPlayer> getOnlinePlayers() {
        return this.onlinePlayers;
    }

    public Map<Integer, Channel> getLoginPlayers() {
        return this.loginPlayers;
    }

    public Channel getLoginSession(int id) {
        return this.loginPlayers.get(Integer.valueOf(id));
    }

    public Map<String, GPlayer> getWaitPlayers() {
        return this.waitPlayers;
    }

    public void addWaitPlayer(GPlayer player) {
        this.waitPlayers.put(player.getId(), player);
    }


    public int getOnlineCount() {
        return this.onlinePlayers.size();
    }


    public boolean isFull() {
        return (this.onlinePlayers.size() >= PLAYER_LIMIT);
    }


    public long getStartServerTime() {
        return this.startServerTime;
    }

    public PomeloResponse getErrResponse(Exception e) {
        Out.error(new Object[]{"GGame getErrResponse().", e});
        return null;
    }


    protected void sync() {
        for (GPlayer player : this.onlinePlayers.values()) {
            player.free();
        }
        for (GPlayer player : this.waitPlayers.values()) {
            player.free();
        }
    }

    public void broadcast(Message msg) {
        for (GPlayer player : this.onlinePlayers.values()) {
            player.receive(msg);
        }
    }


    public void closeArea(String instanceId) {
    }


    public void onAcrossReceive(Packet packet) {
        Out.info(new Object[]{"across handle packet...", packet.getHeader().getTypeHexString()});
    }


    public void onPlayerDie(String instanceId, String diePlayerId, String hitPlayerId) {
    }


    public void battleServerClose(String serverId) {
    }


    public void battleServerStart(String serverId) {
    }


    public void battleServerEvent(String eventType, String msg) {
    }


    public void echoMonitor() {
        if (CSharpClient.UP.count > 0 && CSharpClient.DOWN.count > 0) {


            Long t = Long.valueOf(System.currentTimeMillis() / 1000L - 3L);

            CSharpClient.WatcherSecond w = (CSharpClient.WatcherSecond) CSharpClient.DOWN.ws.remove(t);
            if (w != null)
                Out.error(new Object[]{"CSharp stat down:", Long.valueOf(w.buf), " / ", w.count + " = ", Long.valueOf(w.buf / w.count)});
        }
    }

    public void handleCopyPacket(GPlayer player, Integer count, PomeloHeader header) {
    }
}


