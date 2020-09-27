/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.game.GHandlers;
/*     */ import com.wanniu.core.game.GServerBootstrap;
/*     */ import com.wanniu.core.game.LogicDispatcher;
/*     */ import com.wanniu.core.game.PoolFactory;
/*     */ import com.wanniu.core.game.message.BroadcastMessage;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.PacketDispatcher;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import io.netty.channel.Channel;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.log4j.xml.DOMConfigurator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GServer
/*     */ {
/*     */   public enum XLang
/*     */   {
/*  35 */     CN, TW, EN, OTHER;
/*     */   }
/*     */ 
/*     */   
/*  39 */   public static int __APP_ID = GConfig.getInstance().getInt("server.appid", 80);
/*     */   
/*  41 */   public static int __SERVER_ID = GConfig.getInstance().getServerID();
/*     */   
/*  43 */   public static XLang __SERVER_LANG = XLang.CN;
/*     */ 
/*     */   
/*  46 */   public static boolean DEBUG = GConfig.getInstance().getBoolean("game.debug");
/*     */ 
/*     */   
/*  49 */   private PacketDispatcher[] dispatchers = new PacketDispatcher[GConfig.getInstance().getInt("dispatcher.count", 3)];
/*  50 */   private Thread[] threads = new Thread[this.dispatchers.length];
/*     */   
/*     */   protected ConcurrentHashMap<String, Channel> loginChannels;
/*     */   protected Executor ansycExec;
/*     */   protected static GServer instance;
/*     */   private final Map<String, PacketDispatcher> Handlers;
/*     */   
/*     */   public void ansycExec(Runnable command) {
/*  58 */     this.ansycExec.execute(command);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GServer getInstance() {
/*  66 */     if (instance == null) {
/*  67 */       synchronized (GServer.class) {
/*  68 */         if (instance == null) {
/*  69 */           instance = new GServer();
/*     */         }
/*     */       } 
/*     */     }
/*  73 */     return instance;
/*     */   }
/*     */   
/*  76 */   protected GServer() { String lang = GConfig.getInstance().getServerLang();
/*  77 */     if ("tw".equalsIgnoreCase(lang)) {
/*  78 */       Locale.setDefault(Locale.TAIWAN);
/*  79 */       __SERVER_LANG = XLang.TW;
/*  80 */     } else if ("en".equalsIgnoreCase(lang)) {
/*  81 */       Locale.setDefault(Locale.ENGLISH);
/*  82 */       __SERVER_LANG = XLang.EN;
/*     */     } else {
/*  84 */       Locale.setDefault(Locale.CHINA);
/*  85 */       __SERVER_LANG = XLang.CN;
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
/* 175 */     this.Handlers = new HashMap<>(); this.loginChannels = new ConcurrentHashMap<>(); this.ansycExec = new ThreadPoolExecutor(GConfig.getInstance().getInt("async.thread.min", 1), GConfig.getInstance().getInt("async.thread.max", 5), GConfig.getInstance().getInt("async.thread.idle", 30), TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (ThreadFactory)new PoolFactory("异步服务")); File log4j = new File(String.valueOf(GGlobal.DIR_CONF_SERVER) + "log4j.xml"); if (log4j.exists()) DOMConfigurator.configure(log4j.getAbsolutePath());  }
/*     */   private void initDispatcher() { for (int module = 0; module < this.dispatchers.length; module++) { this.dispatchers[module] = (PacketDispatcher)new LogicDispatcher(); this.threads[module] = new Thread((Runnable)this.dispatchers[module], "dispatcher-module.0x" + Integer.toHexString(module)); this.threads[module].start(); }  this.threads[0].setName("默认逻辑处理器"); externalDispatcher(); GHandlers.init(handlerPath()); }
/* 177 */   protected void externalDispatcher() {} protected String handlerPath() { return instance.getClass().getPackage().getName(); } public void addGlobalRoute(String route, PacketDispatcher dispatcher) { this.Handlers.put(route, dispatcher); }
/*     */   public void start() { initDispatcher(); GServerBootstrap.getInstance().start(); Out.info(new Object[] { "ENV -> ", __SERVER_LANG, "    DEBUG -> ", Boolean.valueOf(DEBUG) }); Out.info(new Object[] { "游戏已成功启动运行喽，O(∩_∩)O~" }); closeProcess(); GSystem.free(); } public BroadcastMessage stopMessage() { return null; } private void closeProcess() { Runtime.getRuntime().addShutdownHook(new Thread("程序维护") {
/*     */           public void run() { Out.info(new Object[] { "正在进行安全停服中..." }); byte b; int i; PacketDispatcher[] arrayOfPacketDispatcher; for (i = (arrayOfPacketDispatcher = GServer.this.dispatchers).length, b = 0; b < i; ) { PacketDispatcher dispatcher = arrayOfPacketDispatcher[b]; dispatcher.stop(); b++; }  BroadcastMessage stopMsg = GServer.this.stopMessage(); GServer.getInstance().sync(); Out.info(new Object[] { "服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~" }); }
/* 180 */         }); } public void addPacket(Packet packet) { short type = packet.getHeader().getType(); int module = type >> 8; if (module < this.dispatchers.length) { this.dispatchers[module].add(packet); } else { this.dispatchers[0].add(packet); }  } public void putGlobalRoute(String route, Packet packet) { PacketDispatcher dispatcher = this.Handlers.get(route);
/* 181 */     if (dispatcher != null) {
/* 182 */       dispatcher.add(packet);
/*     */     } else {
/* 184 */       Out.error(new Object[] { "未实现的协议::::::::::::::::::::::::::::::::::::::::::::::::::::::" + route });
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandler(NetHandler handler) {
/* 191 */     short type = handler.getType();
/* 192 */     int module = type >> 8;
/* 193 */     if (module < this.dispatchers.length) {
/* 194 */       this.dispatchers[module].registerHandler(handler);
/*     */     } else {
/* 196 */       this.dispatchers[0].registerHandler(handler);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<String, Channel> getLoginSessions() {
/* 201 */     return this.loginChannels;
/*     */   }
/*     */   
/*     */   public Channel getLoginSession(String uid) {
/* 205 */     return this.loginChannels.get(uid);
/*     */   }
/*     */   
/*     */   public void addLoginSession(Channel channel) {
/* 209 */     this.loginChannels.put((String)channel.attr(GGlobal._KEY_USER_ID).get(), channel);
/*     */   }
/*     */   
/*     */   public void onSessionClose(Channel session) {
/* 213 */     String uid = (String)session.attr(GGlobal._KEY_USER_ID).get();
/* 214 */     if (uid != null && this.loginChannels.get(uid) == session) {
/* 215 */       this.loginChannels.remove(uid);
/*     */     }
/* 217 */     Out.debug(new Object[] { uid, "连接被关闭:" + session.remoteAddress().toString() });
/*     */   }
/*     */   
/*     */   public void sync() {}
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\GServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */