/*     */ package com.wanniu.core.tcp.client;
/*     */ 
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Message;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ClientWorker
/*     */   implements Runnable, ClientCallback
/*     */ {
/*     */   private static final int __WARN_COUNT__ = 3000;
/*     */   protected volatile boolean disConnect = true;
/*     */   protected String serverHost;
/*     */   protected int serverPort;
/*  26 */   private BlockingQueue<Message> __QUEUE__ = new LinkedBlockingQueue<>();
/*     */   
/*     */   protected ClientBootstrap bootstrap;
/*     */   
/*     */   private Channel session;
/*     */   
/*     */   protected String name;
/*     */   
/*     */   public ClientWorker(String name) {
/*  35 */     this.name = name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Message message) {
/*  42 */     this.__QUEUE__.add(message);
/*  43 */     if (this.__QUEUE__.size() > 3000)
/*     */     {
/*  45 */       Out.warn(new Object[] { String.valueOf(this.name) + "发送队列太长: " + this.__QUEUE__.size() });
/*     */     }
/*     */   }
/*     */   
/*     */   public void start() {
/*  50 */     if (this.bootstrap.connect(this.serverHost, this.serverPort) == null) {
/*  51 */       Out.error(new Object[] { String.format("无法连接%s -> %s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }) });
/*     */     }
/*  53 */     (new Thread(this, String.format("%s->%s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }))).start();
/*     */   }
/*     */   
/*     */   public void restart() {
/*  57 */     this.bootstrap.quit(this.session);
/*  58 */     while (this.bootstrap.connect(this.serverHost, this.serverPort) == null) {
/*  59 */       Out.warn(new Object[] { String.format("无法重连%s -> %s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }) });
/*  60 */       GSystem.waitSeconds(5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*  65 */     GSystem.waitSeconds(5);
/*     */     while (true) {
/*     */       try {
/*  68 */         Message msg = this.__QUEUE__.poll(10L, TimeUnit.SECONDS);
/*  69 */         if (msg == null) {
/*     */           
/*  71 */           ping(); continue;
/*     */         } 
/*  73 */         send(msg);
/*     */       }
/*  75 */       catch (Exception e) {
/*  76 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void send(Message msg) {
/*  82 */     if (this.session != null) {
/*  83 */       this.session.writeAndFlush(msg.getContent());
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract void doStart();
/*     */   
/*     */   public void bind(Channel session) {
/*  90 */     Out.info(
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  95 */         new Object[] { String.valueOf(this.name) + "注册成功,开始发送信息" }); this.session = session;
/*     */     this.__QUEUE__.clear();
/*     */     this.disConnect = false;
/*  98 */     doStart(); } public void close() { Out.warn(
/*     */ 
/*     */ 
/*     */         
/* 102 */         new Object[] { String.format("%s关闭了 - %s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }) });
/*     */     Out.info(new Object[] { String.format("开始重连%s -> %s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }) });
/*     */     restart();
/*     */     Out.info(new Object[] { String.format("成功重连%s -> %s:%d", new Object[] { this.name, this.serverHost, Integer.valueOf(this.serverPort) }) }); }
/*     */ 
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\client\ClientWorker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */