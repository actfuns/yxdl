/*     */ package com.wanniu.core.tcp;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.game.entity.GClientEvent;
/*     */ import com.wanniu.core.game.entity.GPlayer;
/*     */ import com.wanniu.core.game.request.GameHandler;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.tcp.protocol.Header;
/*     */ import com.wanniu.core.tcp.protocol.NetHandler;
/*     */ import com.wanniu.core.tcp.protocol.Packet;
/*     */ import com.wanniu.core.tcp.server.IPBlacks;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PacketDispatcher
/*     */   implements Runnable
/*     */ {
/*     */   private static final String GET_SYSTIME_REQUEST = "getSysTimeRequest";
/*  27 */   private static final int __CAPACITY__ = GConfig.getInstance().getInt("client.dispatcher.capacity", 100000);
/*     */   
/*  29 */   private static final int __WARN_COUNT__ = __CAPACITY__ * 2 / 3;
/*     */   
/*  31 */   private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("client.monitor.enable", true);
/*     */ 
/*     */   
/*  34 */   private final BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>(__CAPACITY__);
/*     */ 
/*     */   
/*  37 */   protected final Map<Short, NetHandler> handlers = new HashMap<>();
/*  38 */   protected final Map<String, NetHandler> s_handlers = new HashMap<>();
/*     */   
/*     */   public int getHandlerCount() {
/*  41 */     return this.handlers.size() + this.s_handlers.size();
/*     */   }
/*     */   
/*     */   public void echo() {
/*  45 */     for (Short key : this.handlers.keySet()) {
/*  46 */       System.out.println("\t" + Integer.toHexString(key.intValue()));
/*     */     }
/*  48 */     for (Map.Entry<String, NetHandler> key : this.s_handlers.entrySet()) {
/*  49 */       System.out.println("\t" + ((((NetHandler)key.getValue()).getType() != 0) ? ("0x" + Integer.toHexString(((NetHandler)key.getValue()).getType()) + " : ") : "") + (String)key.getKey());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean __running__ = true;
/*     */   
/*     */   public NetHandler getHandler(String route) {
/*  57 */     return this.s_handlers.get(route);
/*     */   }
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
/*     */   public void registerHandler(NetHandler handler) {
/*  74 */     if (handler.getClass().isAnnotationPresent((Class)GClientEvent.class)) {
/*  75 */       GClientEvent handle = handler.getClass().<GClientEvent>getAnnotation(GClientEvent.class);
/*  76 */       GGame.getInstance().addGlobalRoute(handle.value(), this);
/*  77 */       this.s_handlers.put(handle.value(), handler);
/*  78 */       ((GameHandler)handler).watcher.handlerName = handle.value();
/*     */     } else {
/*  80 */       this.handlers.put(Short.valueOf(handler.getType()), handler);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Packet packet) {
/*  91 */     if (this.__running__) {
/*  92 */       if (this.__QUEUE__.size() > __WARN_COUNT__) {
/*  93 */         Out.info(new Object[] { "队列偏大 -> ", Integer.valueOf(this.__QUEUE__.size()) });
/*     */       }
/*  95 */       if (this.__QUEUE__.offer(packet)) {
/*  96 */         return true;
/*     */       }
/*  98 */       Out.error(new Object[] { "队列过大，丢弃了请求：", packet.getHeader().getTypeHexString() });
/*  99 */       return false;
/*     */     } 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 109 */     this.__running__ = false;
/*     */   }
/*     */   
/*     */   public final void run() {
/* 113 */     Packet packet = null;
/*     */     while (true) {
/*     */       try {
/* 116 */         packet = this.__QUEUE__.take();
/* 117 */         if (__MONITOR_ENABLE__) {
/*     */           
/* 119 */           long startExecuteTime = System.nanoTime();
/*     */           
/* 121 */           Header header = packet.getHeader();
/* 122 */           execute(packet);
/*     */ 
/*     */           
/* 125 */           long endExecuteTime = System.nanoTime();
/*     */           
/* 127 */           float delay = (float)(startExecuteTime - header.getReceiveTime()) / 1000000.0F;
/* 128 */           float exec = (float)(endExecuteTime - startExecuteTime) / 1000000.0F;
/*     */           
/* 130 */           String protocal = header.getTypeHexString();
/* 131 */           if (Out.isEnableDebug() || !protocal.endsWith("getSysTimeRequest")) {
/* 132 */             GPlayer player = packet.getPlayer();
/* 133 */             Out.info(new Object[] { "handle ", protocal, ", delay=", Float.valueOf(delay), " ms, exec=", Float.valueOf(exec), " ms, playerId=", (player == null) ? Integer.valueOf(0) : player.getId() });
/*     */           }  continue;
/*     */         } 
/* 136 */         execute(packet);
/*     */       }
/* 138 */       catch (Exception e) {
/* 139 */         Out.error(new Object[] { String.format("处理句柄【%s】出错 -> %s", new Object[] { packet.getHeader().getTypeHexString(), e.toString() }), e });
/* 140 */         IPBlacks.getInstance().exceptionIp(packet.getSession());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void execute(Packet paramPacket);
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\tcp\PacketDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */