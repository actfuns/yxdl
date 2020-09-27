/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.db.GDao;
/*     */ import com.wanniu.core.db.connet.DBClient;
/*     */ import com.wanniu.core.game.BattleDispatcher;
/*     */ import com.wanniu.core.game.GHandlers;
/*     */ import com.wanniu.core.game.LogicDispatcher;
/*     */ import com.wanniu.core.game.PoolFactory;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.game.message.BroadcastMessage;
/*     */ import com.wanniu.core.game.protocol.PomeloHeader;
/*     */ import com.wanniu.core.game.protocol.PomeloResponse;
/*     */ import com.wanniu.core.gm.GMClient;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.pay.PayClient;
/*     */ import com.wanniu.core.proxy.ProxyClient;
/*     */ import com.wanniu.core.tcp.PacketDispatcher;
/*     */ import com.wanniu.core.tcp.client.ClientWorker;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import com.wanniu.csharp.CSharpClient;
/*     */ import com.wanniu.csharp.CSharpNode;
/*     */ import io.netty.channel.Channel;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArraySet;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GGame
/*     */ {
/*  49 */   public static volatile long APP_TIME = System.currentTimeMillis();
/*     */ 
/*     */   
/*  52 */   public static int __APP_ID = GConfig.getInstance().getAppID();
/*     */   
/*  54 */   public static int __SERVER_ID = GConfig.getInstance().getGameID();
/*     */ 
/*     */   
/*  57 */   public static CSharpNode __CS_NODE = new CSharpNode("game-" + __SERVER_ID, GConfig.getInstance().get("battle.ice.host"), GConfig.getInstance().getInt("battle.fastStream.port"), GConfig.getInstance().getInt("battle.ice.port"));
/*     */ 
/*     */   
/*  60 */   public static XLang __SERVER_LANG = XLang.CN;
/*     */ 
/*     */   
/*     */   public static boolean GATE_ENABLE = false;
/*     */ 
/*     */   
/*  66 */   public static boolean DEBUG = GConfig.getInstance().getBoolean("game.debug");
/*     */ 
/*     */   
/*  69 */   public static boolean MONITOR = GConfig.getInstance().getBoolean("game.monitor");
/*     */ 
/*     */   
/*  72 */   public static int PLAYER_LIMIT = GConfig.getInstance().getPlayerLimit();
/*     */ 
/*     */   
/*     */   private BattleDispatcher battleDispatcher;
/*     */ 
/*     */   
/*     */   private Thread battleHandleThread;
/*     */   
/*     */   private PacketDispatcher defaultDispatcher;
/*     */   
/*  82 */   private PacketDispatcher[] dispatchers = new PacketDispatcher[GConfig.getInstance().getInt("game.dispatcher.count", 3)];
/*  83 */   private Thread[] threads = new Thread[this.dispatchers.length];
/*     */ 
/*     */   
/*     */   protected ConcurrentHashMap<String, GPlayer> onlinePlayers;
/*     */ 
/*     */   
/*     */   protected ConcurrentHashMap<String, GPlayer> waitPlayers;
/*     */   
/*     */   protected ConcurrentHashMap<Integer, Channel> loginPlayers;
/*     */   
/*  93 */   protected long startServerTime = System.currentTimeMillis();
/*     */   
/*  95 */   protected final Map<String, PacketDispatcher> handlers = new HashMap<>();
/*     */   protected Executor ansycExec;
/*     */   protected static GGame instance;
/*     */   private final Set<ClientWorker> workers;
/*     */   
/*     */   public void ansycExec(final Runnable command) {
/* 101 */     this.ansycExec.execute(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/* 105 */               command.run();
/* 106 */             } catch (Exception e) {
/* 107 */               Out.error(new Object[] { e });
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GGame getInstance() {
/* 118 */     if (instance == null) {
/* 119 */       synchronized (GGame.class) {
/* 120 */         if (instance == null) {
/* 121 */           instance = new GGame();
/*     */         }
/*     */       } 
/*     */     }
/* 125 */     return instance;
/*     */   }
/*     */   
/*     */   protected GGame() {
/* 129 */     String lang = GConfig.getInstance().getGameLang();
/* 130 */     if ("vn".equalsIgnoreCase(lang)) {
/* 131 */       Locale.setDefault(Locale.ENGLISH);
/* 132 */       __SERVER_LANG = XLang.VN;
/*     */     } else {
/* 134 */       Locale.setDefault(Locale.CHINA);
/* 135 */       __SERVER_LANG = XLang.CN;
/*     */     } 
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
/* 231 */     this.workers = new CopyOnWriteArraySet<>(); this.onlinePlayers = new ConcurrentHashMap<>(512); this.waitPlayers = new ConcurrentHashMap<>(); this.loginPlayers = new ConcurrentHashMap<>(); this.ansycExec = new ThreadPoolExecutor(GConfig.getInstance().getInt("async.thread.min", 1), GConfig.getInstance().getInt("async.thread.max", 5), GConfig.getInstance().getInt("async.thread.idle", 30), TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (ThreadFactory)new PoolFactory("异步服务")); long initialDelay = GConfig.getInstance().getAutoSaveDelay(); GSystem.addScheduleJob(new Runnable() { public void run() { int count = 0; Out.debug(new Object[] { "定时持久化用户数据......." }, ); Collection<GPlayer> players = GGame.this.onlinePlayers.values(); for (GPlayer player : players) { if (player.getUid() != null) try { player.sync(); if (++count % 200 == 0) GSystem.waitSeconds(1);  } catch (Exception e) { Out.error(new Object[] { e }, ); }   }  }
/*     */         },  initialDelay, GConfig.getInstance().getAutoSaveInterval(), TimeUnit.SECONDS);
/*     */   } private void initDispatcher() { for (int module = 0; module < this.dispatchers.length; module++) { this.dispatchers[module] = (PacketDispatcher)new LogicDispatcher(); this.threads[module] = new Thread((Runnable)this.dispatchers[module], "logic-line" + Integer.toHexString(module)); this.threads[module].start(); }  this.defaultDispatcher = this.dispatchers[0]; this.threads[0].setName("logic-default"); externalDispatcher(); String searchPath = searchPath(); if (searchPath != null) { String[] paths = searchPath.split(";"); for (String path : paths) GHandlers.init(path);  }  int totalHandler = 0; for (int i = 0; i < this.dispatchers.length; i++) { int handlerCount = this.dispatchers[i].getHandlerCount(); System.out.println(this.threads[i].getName() + " handler count : " + handlerCount); if (DEBUG || Out.isEnableDebug())
/* 234 */         this.dispatchers[i].echo();  totalHandler += handlerCount; }  System.out.println("total handler count : " + totalHandler + ", glabal count : " + this.handlers.size()); } protected void externalDispatcher() {} public void onWorkerBefore(ClientWorker worker) { Out.info(new Object[] { "on worker before : ", worker.getName() });
/* 235 */     this.workers.add(worker); }
/*     */   protected String searchPath() { return instance.getClass().getPackage().getName(); }
/*     */   public void start() { initDispatcher(); onBeginStart(); DBClient.getInstance().start(); PayClient.getInstance().start(); ProxyClient.getInstance().start(); CSharpClient.getInstance().start(); GMClient.getInstance().start(); onWorkerWatch();
/*     */     addCloseProcess();
/* 239 */     onAfterStart(); } protected void onWorkerWatch() { while (this.workers.size() > 0) {
/* 240 */       for (ClientWorker worker : this.workers) {
/* 241 */         Out.info(new Object[] { worker.getName(), " is waiting..." });
/*     */       } 
/* 243 */       GSystem.waitMills(3000);
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void onWorkerReady(ClientWorker worker) {
/* 248 */     Out.info(new Object[] { "on worker ready : ", worker.getName() });
/* 249 */     this.workers.remove(worker);
/*     */   }
/*     */   
/*     */   protected void onBeginStart() {
/* 253 */     Out.info(new Object[] { "begin start..." });
/*     */   }
/*     */   
/*     */   protected void onAfterStart() {
/* 257 */     Out.info(new Object[] { "after start..." });
/* 258 */     final int maintain_player_time = GConfig.getInstance().getInt("game.player.maintain", 60000);
/* 259 */     GSystem.addFixedRateJob(new Runnable()
/*     */         {
/*     */           public void run() {
/* 262 */             if (GGame.this.waitPlayers.size() > 0) {
/* 263 */               long maintain_time = System.currentTimeMillis() - maintain_player_time;
/* 264 */               Collection<GPlayer> wPlayers = GGame.this.waitPlayers.values();
/* 265 */               for (GPlayer player : wPlayers) {
/* 266 */                 if (player.getLogoutTime() == null || player.getLogoutTime().getTime() < maintain_time) {
/*     */                   try {
/* 268 */                     GGame.this.onRemoveWaitPlayer(player);
/* 269 */                   } catch (Exception e) {
/* 270 */                     Out.error(new Object[] { e }, );
/* 271 */                     GGame.this.removeWaitPlayer(player);
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */         },  maintain_player_time, maintain_player_time);
/*     */     
/* 279 */     if (MONITOR) {
/* 280 */       GSystem.addFixedRateJob(new Runnable()
/*     */           {
/*     */             public void run() {
/* 283 */               GGame.this.echoMonitor();
/*     */             }
/*     */           },  1000L, 1000L);
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeWaitPlayer(GPlayer player) {
/*     */     try {
/* 291 */       this.waitPlayers.remove(player.getId());
/*     */     }
/* 293 */     catch (Exception ex) {
/* 294 */       Out.error(new Object[] { ex });
/*     */     } finally {
/* 296 */       player.free();
/* 297 */       player.endWatch();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void onRemoveWaitPlayer(GPlayer player) {
/* 302 */     Out.debug(new Object[] { "maintain remove wait : ", player.getName() });
/* 303 */     removeWaitPlayer(player);
/*     */   }
/*     */   
/*     */   public void onSessionClose(Channel channel) {}
/*     */   
/*     */   protected void onCloseGame() {
/* 309 */     Out.info(new Object[] { "close game..." });
/*     */   }
/*     */   
/*     */   protected BroadcastMessage stopMessage() {
/* 313 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void addCloseProcess() {
/* 318 */     Runtime.getRuntime().addShutdownHook(new Thread("程序维护") {
/*     */           public void run() {
/* 320 */             Out.info(new Object[] { "正在进行安全停服中..." });
/*     */             try {
/* 322 */               if (GGame.this.battleDispatcher != null) {
/* 323 */                 GGame.this.battleDispatcher.stop();
/*     */               }
/* 325 */               for (PacketDispatcher dispatcher : GGame.this.dispatchers) {
/* 326 */                 dispatcher.stop();
/*     */               }
/*     */               
/* 329 */               BroadcastMessage stopMsg = GGame.this.stopMessage();
/* 330 */               if (stopMsg != null) {
/* 331 */                 for (GPlayer player : GGame.this.onlinePlayers.values()) {
/* 332 */                   player.receive((Message)stopMsg);
/*     */                 }
/*     */               }
/* 335 */               GGame.this.onCloseGame();
/*     */             } finally {
/*     */               try {
/* 338 */                 GGame.this.sync();
/*     */               } finally {
/* 340 */                 while (GDao.size() > 0) {
/* 341 */                   Out.info(new Object[] { String.format("等待数据保存到数据库，还有【%d】条记录！", new Object[] { Integer.valueOf(GDao.size()) }) });
/* 342 */                   GSystem.waitMills(500);
/*     */                 } 
/*     */               } 
/*     */             } 
/* 346 */             Out.info(new Object[] { "服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~" });
/* 347 */             Out.shutdown();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPacket(Packet packet) {
/* 354 */     short type = packet.getHeader().getType();
/* 355 */     int module = type >> 8;
/* 356 */     if (module < this.dispatchers.length) {
/* 357 */       this.dispatchers[module].add(packet);
/*     */     } else {
/* 359 */       this.defaultDispatcher.add(packet);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addBattlePacket(Packet packet) {
/* 364 */     this.battleDispatcher.add(packet);
/*     */   }
/*     */   
/*     */   public void registerBattleHandler(NetHandler handler) {
/* 368 */     if (this.battleDispatcher == null) {
/* 369 */       this.battleDispatcher = new BattleDispatcher();
/* 370 */       this.battleHandleThread = new Thread((Runnable)this.battleDispatcher, "战斗逻辑处理器");
/* 371 */       this.battleHandleThread.start();
/*     */     } 
/* 373 */     this.battleDispatcher.registerHandler(handler);
/*     */   }
/*     */   
/*     */   public void addDefaultPacket(Packet packet) {
/* 377 */     this.defaultDispatcher.add(packet);
/*     */   }
/*     */   
/*     */   public void registerDefaultHandler(NetHandler handler) {
/* 381 */     this.defaultDispatcher.registerHandler(handler);
/*     */   }
/*     */   
/*     */   public void addGlobalRoute(String route, PacketDispatcher dispatcher) {
/* 385 */     if (this.handlers.containsKey(route)) {
/* 386 */       Out.error(new Object[] { "more register handler : ", route });
/*     */     }
/* 388 */     this.handlers.put(route, dispatcher);
/*     */   }
/*     */   
/*     */   public void putGlobalRoute(String route, Packet packet) {
/* 392 */     PacketDispatcher dispatcher = this.handlers.get(route);
/* 393 */     if (dispatcher != null) {
/* 394 */       dispatcher.add(packet);
/*     */     } else {
/* 396 */       Out.error(new Object[] { "未实现的协议::::::::::::::::::::::::::::::::::::::::::::::::::::::" + route });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addClassBySearchPath(String className) {
/*     */     try {
/* 402 */       Class<?> clz = Class.forName(className);
/* 403 */       if (clz.isAnnotationPresent((Class)GClientEvent.class)) {
/* 404 */         registerHandler((NetHandler)clz.newInstance());
/*     */       }
/* 406 */       addClassByAnnotation(clz);
/* 407 */     } catch (Exception e) {
/* 408 */       Out.error(new Object[] { e });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addClassByAnnotation(Class<?> clz) throws Exception {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandler(NetHandler handler) {
/* 420 */     short type = handler.getType();
/* 421 */     int module = type >> 8;
/* 422 */     if (module < this.dispatchers.length) {
/* 423 */       this.dispatchers[module].registerHandler(handler);
/*     */     } else {
/* 425 */       this.defaultDispatcher.registerHandler(handler);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addPlayer(GPlayer player) {
/* 430 */     this.onlinePlayers.put(player.getId(), player);
/* 431 */     this.waitPlayers.remove(player.getId());
/*     */   }
/*     */   
/*     */   public GPlayer getPlayer(String rid) {
/* 435 */     return this.onlinePlayers.containsKey(rid) ? this.onlinePlayers.get(rid) : this.waitPlayers.get(rid);
/*     */   }
/*     */   
/*     */   public GPlayer getPlayerByName(String name) {
/* 439 */     if (StringUtil.isEmpty(name))
/* 440 */       return null; 
/* 441 */     for (Map.Entry<String, GPlayer> node : this.onlinePlayers.entrySet()) {
/* 442 */       GPlayer player = node.getValue();
/* 443 */       if (player.getName().equals(name)) {
/* 444 */         return player;
/*     */       }
/*     */     } 
/* 447 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public GPlayer getPlayerByUid(String uid) {
/* 452 */     if (StringUtil.isEmpty(uid)) {
/* 453 */       return null;
/*     */     }
/* 455 */     for (GPlayer p : this.onlinePlayers.values()) {
/* 456 */       if (p.getUid().equals(uid)) {
/* 457 */         return p;
/*     */       }
/*     */     } 
/*     */     
/* 461 */     for (GPlayer p : this.waitPlayers.values()) {
/* 462 */       if (p.getUid().equals(uid)) {
/* 463 */         return p;
/*     */       }
/*     */     } 
/*     */     
/* 467 */     return null;
/*     */   }
/*     */   
/*     */   public void removePlayer(GPlayer player) {
/* 471 */     this.onlinePlayers.remove(player.getId());
/*     */   }
/*     */   
/*     */   public Map<String, GPlayer> getOnlinePlayers() {
/* 475 */     return this.onlinePlayers;
/*     */   }
/*     */   
/*     */   public Map<Integer, Channel> getLoginPlayers() {
/* 479 */     return this.loginPlayers;
/*     */   }
/*     */   
/*     */   public Channel getLoginSession(int id) {
/* 483 */     return this.loginPlayers.get(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public Map<String, GPlayer> getWaitPlayers() {
/* 487 */     return this.waitPlayers;
/*     */   }
/*     */   
/*     */   public void addWaitPlayer(GPlayer player) {
/* 491 */     this.waitPlayers.put(player.getId(), player);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOnlineCount() {
/* 498 */     return this.onlinePlayers.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 505 */     return (this.onlinePlayers.size() >= PLAYER_LIMIT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getStartServerTime() {
/* 512 */     return this.startServerTime;
/*     */   }
/*     */   
/*     */   public PomeloResponse getErrResponse(Exception e) {
/* 516 */     Out.error(new Object[] { "GGame getErrResponse().", e });
/* 517 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void sync() {
/* 522 */     for (GPlayer player : this.onlinePlayers.values()) {
/* 523 */       player.free();
/*     */     }
/* 525 */     for (GPlayer player : this.waitPlayers.values()) {
/* 526 */       player.free();
/*     */     }
/*     */   }
/*     */   
/*     */   public void broadcast(Message msg) {
/* 531 */     for (GPlayer player : this.onlinePlayers.values()) {
/* 532 */       player.receive(msg);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeArea(String instanceId) {}
/*     */ 
/*     */   
/*     */   public void onAcrossReceive(Packet packet) {
/* 541 */     Out.info(new Object[] { "across handle packet...", packet.getHeader().getTypeHexString() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDie(String instanceId, String diePlayerId, String hitPlayerId) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void battleServerClose(String serverId) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void battleServerStart(String serverId) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void battleServerEvent(String eventType, String msg) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void echoMonitor() {
/* 578 */     if (CSharpClient.UP.count > 0 && CSharpClient.DOWN.count > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 584 */       Long t = Long.valueOf(System.currentTimeMillis() / 1000L - 3L);
/*     */       
/* 586 */       CSharpClient.WatcherSecond w = (CSharpClient.WatcherSecond)CSharpClient.DOWN.ws.remove(t);
/* 587 */       if (w != null)
/* 588 */         Out.error(new Object[] { "CSharp stat down:", Long.valueOf(w.buf), " / ", w.count + " = ", Long.valueOf(w.buf / w.count) }); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void handleCopyPacket(GPlayer player, Integer count, PomeloHeader header) {}
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */