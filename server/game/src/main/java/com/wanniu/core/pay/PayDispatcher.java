/*    */ package com.wanniu.core.pay;
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
/*    */ 
/*    */ class PayDispatcher
/*    */   implements Runnable
/*    */ {
/*    */   private static final int HIGH_WATER = 500;
/* 22 */   private static BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>();
/*    */ 
/*    */   
/* 25 */   Map<Short, NetHandler> handlers = new ConcurrentHashMap<>();
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
/* 36 */     this.handlers.put(Short.valueOf(handler.getType()), handler);
/*    */   }
/*    */   
/*    */   public void add(Packet mo) {
/* 40 */     __QUEUE__.add(mo);
/* 41 */     if (__QUEUE__.size() > 500)
/*    */     {
/* 43 */       Out.info(new Object[] { "充值服务处理队列太长: ", Integer.valueOf(__QUEUE__.size()) }); } 
/*    */   }
/*    */   
/*    */   public final void run() {
/*    */     while (true) {
/*    */       try {
/*    */         while (true)
/* 50 */         { Packet msg = __QUEUE__.take();
/* 51 */           execute(msg); }  break;
/* 52 */       } catch (Exception e) {
/* 53 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void execute(Packet action) {
/* 59 */     NetHandler handler = this.handlers.get(Short.valueOf(action.getPacketType()));
/* 60 */     System.out.println(handler);
/* 61 */     if (handler != null) {
/* 62 */       handler.execute(action);
/*    */     } else {
/* 64 */       Out.warn(new Object[] { "充值系统未找到对应的消息处理句柄：", action.getHeader().getTypeHexString() });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\pay\PayDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */