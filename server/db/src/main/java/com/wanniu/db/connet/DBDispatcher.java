/*    */ package com.wanniu.db.connet;
/*    */ 
/*    */ import com.wanniu.core.db.DBType;
/*    */ import com.wanniu.core.logfs.Out;
/*    */ import com.wanniu.core.tcp.protocol.NetHandler;
/*    */ import com.wanniu.core.tcp.protocol.Packet;
/*    */ import com.wanniu.db.handler.NotifyHandler;
/*    */ import com.wanniu.db.handler.UpdateHandler;
/*    */ import java.util.concurrent.BlockingQueue;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBDispatcher
/*    */   implements Runnable
/*    */ {
/*    */   private static final int HIGH_WATER = 10000;
/* 21 */   private static final UpdateHandler Update = new UpdateHandler();
/* 22 */   private static final NotifyHandler Notify = new NotifyHandler();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   private static BlockingQueue<Packet> __QUEUE__ = new LinkedBlockingQueue<>();
/*    */   
/*    */   public void run() {
/*    */     while (true) {
/*    */       try {
/*    */         while (true)
/* 35 */         { Packet msg = __QUEUE__.take();
/* 36 */           execute(msg); }  break;
/* 37 */       } catch (Exception e) {
/* 38 */         Out.error(new Object[] { e });
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void add(Packet pak) {
/* 44 */     __QUEUE__.add(pak);
/* 45 */     if (__QUEUE__.size() > 10000) {
/* 46 */       int size = __QUEUE__.size();
/*    */       
/* 48 */       if (size % 500 == 0)
/* 49 */         Out.info(new Object[] { "DB服务处理队列太长: ", Integer.valueOf(size) }); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void execute(Packet pak) {
/*    */     NotifyHandler notifyHandler;
/* 55 */     NetHandler handler = null;
/* 56 */     short type = pak.getPacketType();
/* 57 */     if (type == DBType.UPDATE) {
/* 58 */       UpdateHandler updateHandler = Update;
/* 59 */     } else if (type == DBType.NOTIFY) {
/* 60 */       notifyHandler = Notify;
/*    */     } else {
/* 62 */       Out.error(new Object[] { "undefine db handler : ", pak.getHeader().getTypeHexString() });
/*    */       return;
/*    */     } 
/* 65 */     notifyHandler.bindSession(pak.getSession());
/*    */     try {
/* 67 */       notifyHandler.execute(pak);
/* 68 */     } catch (Exception e) {
/* 69 */       Out.error(new Object[] { e });
/*    */     } 
/*    */   }
/*    */   
/*    */   public int getQueueSize() {
/* 74 */     return __QUEUE__.size();
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\connet\DBDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */