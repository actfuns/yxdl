/*     */ package com.wanniu.core.tcp;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GServer;
/*     */ import com.wanniu.core.game.request.GClientEvent;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PacketDispatcher
/*     */   implements Runnable
/*     */ {
/*  21 */   private static final int __CAPACITY__ = GConfig.getInstance().getInt("client.dispatcher.capacity", 5000);
/*     */   
/*  23 */   private static final int __WARN_COUNT__ = __CAPACITY__ * 2 / 3;
/*     */   
/*  25 */   private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("client.monitor.enable", true);
/*     */ 
/*     */   
/*  28 */   private final BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>(__CAPACITY__);
/*     */ 
/*     */   
/*  31 */   protected final Map<Short, NetHandler> handlers = new HashMap<>();
/*  32 */   protected final Map<String, NetHandler> s_handlers = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean __running__ = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerHandler(NetHandler handler) {
/*  51 */     if (handler.getClass().isAnnotationPresent((Class)GClientEvent.class)) {
/*  52 */       GClientEvent handle = handler.getClass().<GClientEvent>getAnnotation(GClientEvent.class);
/*  53 */       GServer.getInstance().addGlobalRoute(handle.value(), this);
/*  54 */       this.s_handlers.put(handle.value(), handler);
/*     */     } else {
/*  56 */       this.handlers.put(Short.valueOf(handler.getType()), handler);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Packet packet) {
/*  68 */     if (this.__running__) {
/*  69 */       if (this.__QUEUE__.size() > __WARN_COUNT__) {
/*  70 */         Out.info(new Object[] { "队列偏大 -> " + this.__QUEUE__.size() });
/*     */       }
/*  72 */       if (this.__QUEUE__.offer(packet)) {
/*  73 */         return true;
/*     */       }
/*  75 */       Out.error(new Object[] { "队列过大，丢弃了请求：" + packet.getHeader().getTypeHexString() });
/*  76 */       return false;
/*     */     } 
/*     */     
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/*  86 */     this.__running__ = false;
/*     */   }
/*     */   
/*     */   public final void run() {
/*  90 */     Packet packet = null;
/*  91 */     long sTime = 0L;
/*     */     while (true) {
/*     */       try {
/*  94 */         packet = this.__QUEUE__.take();
/*  95 */         if (__MONITOR_ENABLE__) {
/*  96 */           sTime = System.currentTimeMillis();
/*  97 */           execute(packet);
/*  98 */           if (System.currentTimeMillis() - sTime > 100L)
/*  99 */             Out.warn(new Object[] { String.format("处理句柄【%s】耗时 -> %s", new Object[] { packet.getHeader().getTypeHexString(), Long.valueOf(System.currentTimeMillis() - sTime) }) }); 
/*     */           continue;
/*     */         } 
/* 102 */         execute(packet);
/*     */       }
/* 104 */       catch (Exception e) {
/* 105 */         Out.error(new Object[] { String.format("处理句柄【%s】出错 -> %s", new Object[] { packet.getHeader().getTypeHexString(), e.toString() }), e });
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void execute(Packet paramPacket);
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\tcp\PacketDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */