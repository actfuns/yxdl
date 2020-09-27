/*     */ package com.wanniu.core.tcp.client;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.tcp.protocol.RequestMessage;
/*     */ import io.netty.channel.Channel;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ClientWorker
/*     */   implements Runnable, ClientCallback
/*     */ {
/*  23 */   private static final int __WARN_COUNT__ = GConfig.getInstance().getInt("game.worker.threshold", 10000);
/*     */   
/*  25 */   protected final BlockingQueue<Message> __QUEUE__ = new LinkedBlockingQueue<>();
/*     */   
/*     */   protected String serverHost;
/*     */   
/*     */   protected int serverPort;
/*     */   
/*     */   protected ClientBootstrap bootstrap;
/*     */   
/*     */   protected Channel session;
/*     */   protected volatile boolean disconnect = true;
/*     */   protected String name;
/*     */   
/*     */   public String getName() {
/*  38 */     return this.name;
/*     */   }
/*     */   
/*     */   public ClientWorker() {
/*  42 */     this.name = getClass().getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Message message) {
/*  49 */     this.__QUEUE__.add(message);
/*  50 */     if (size() > __WARN_COUNT__)
/*     */     {
/*  52 */       Out.warn(new Object[] { this.name, "发送队列太长: ", Integer.valueOf(this.__QUEUE__.size()) });
/*     */     }
/*     */   }
/*     */   
/*     */   public int size() {
/*  57 */     return this.__QUEUE__.size();
/*     */   }
/*     */   
/*     */   public void start() {
/*  61 */     GGame.getInstance().onWorkerBefore(this);
/*  62 */     bind(this.bootstrap.connect(this.serverHost, this.serverPort));
/*  63 */     (new Thread(this, String.format("%s->%s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }))).start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     while (true) {
/*     */       try {
/*  70 */         if (this.disconnect) {
/*  71 */           String connName = Thread.currentThread().getName();
/*  72 */           Out.info(new Object[] { "开始重连", connName });
/*  73 */           while ((this.session = this.bootstrap.connect(this.serverHost, this.serverPort)) == null) {
/*  74 */             Out.warn(new Object[] { "无法重连", connName });
/*  75 */             GSystem.waitSeconds(5);
/*     */           } 
/*  77 */           Out.info(new Object[] { "成功重连", connName });
/*  78 */           bind(this.session);
/*     */         } 
/*  80 */         Message msg = this.__QUEUE__.poll(10L, TimeUnit.SECONDS);
/*  81 */         if (msg == null) {
/*     */           
/*  83 */           ping(); continue;
/*     */         } 
/*  85 */         send(msg);
/*     */       }
/*  87 */       catch (Exception e) {
/*  88 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void send(Message msg) {
/*  94 */     if (this.session != null) {
/*  95 */       this.session.writeAndFlush(msg.getContent());
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract void doStart();
/*     */   
/*     */   public void bind(Channel session) {
/* 102 */     if (session != null) {
/* 103 */       this.session = session;
/* 104 */       this.__QUEUE__.clear();
/* 105 */       doStart();
/* 106 */       this.disconnect = false;
/* 107 */       GGame.getInstance().onWorkerReady(this);
/* 108 */       Out.info(new Object[] { this.name, "注册成功,开始发送信息..." });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close(Channel session) {
/* 113 */     if (this.session == session) {
/* 114 */       this.disconnect = true;
/* 115 */       Out.error(new Object[] { this.name, " close!!!" });
/*     */     } 
/*     */   }
/*     */   
/*     */   public Packet request(RequestMessage req) {
/* 120 */     return this.bootstrap.request(req);
/*     */   }
/*     */   
/*     */   public void response(long reqId, Packet pak) {
/* 124 */     this.bootstrap.response(reqId, pak);
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\client\ClientWorker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */