/*    */ package com.wanniu.core.gm;
/*    */ 
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.BlockingQueue;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GMDispatcher
/*    */   implements Runnable
/*    */ {
/*    */   private static final int HIGH_WATER = 500;
/* 21 */   private static BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>();
/*    */ 
/*    */   
/* 24 */   Map<Short, NetHandler> handlers = new ConcurrentHashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerHandler(NetHandler handler) {
/* 35 */     if (this.handlers.containsKey(Short.valueOf(handler.getType()))) {
/* 36 */       Out.warn(new Object[] { "register more gm handler : 0x", Integer.toHexString(handler.getType()) });
/*    */     }
/* 38 */     this.handlers.put(Short.valueOf(handler.getType()), handler);
/*    */   }
/*    */   
/*    */   public void add(Packet mo) {
/* 42 */     __QUEUE__.add(mo);
/* 43 */     if (__QUEUE__.size() > 500)
/*    */     {
/* 45 */       Out.info(new Object[] { "GM服务处理队列太长: ", Integer.valueOf(__QUEUE__.size()) }); } 
/*    */   }
/*    */   
/*    */   public final void run() {
/*    */     while (true) {
/*    */       try {
/*    */         while (true)
/* 52 */         { Packet msg = __QUEUE__.take();
/* 53 */           execute(msg); }  break;
/* 54 */       } catch (Exception e) {
/* 55 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void execute(Packet action) {
/* 61 */     NetHandler handler = this.handlers.get(Short.valueOf(action.getPacketType()));
/* 62 */     if (handler != null) {
/* 63 */       handler.execute(action);
/*    */     } else {
/* 65 */       Out.warn(new Object[] { "GM系统未找到对应的消息处理句柄：", action.getHeader().getTypeHexString() });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\gm\GMDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */