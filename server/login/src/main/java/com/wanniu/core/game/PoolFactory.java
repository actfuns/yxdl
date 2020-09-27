/*    */ package com.wanniu.core.game;
/*    */ 
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PoolFactory
/*    */   implements ThreadFactory
/*    */ {
/* 13 */   static final AtomicInteger poolNumber = new AtomicInteger(1);
/* 14 */   final AtomicInteger threadNumber = new AtomicInteger(1);
/*    */   final String namePrefix;
/*    */   private boolean daemon = false;
/* 17 */   private int priority = 5;
/*    */   
/*    */   public void setDaemon(boolean daemon) {
/* 20 */     this.daemon = daemon;
/*    */   }
/*    */   
/*    */   public void setPriority(int priority) {
/* 24 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public PoolFactory(String name) {
/* 28 */     this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + name;
/*    */   }
/*    */   
/*    */   public PoolFactory(String name, boolean deamon) {
/* 32 */     this(name);
/* 33 */     this.daemon = deamon;
/*    */   }
/*    */   
/*    */   public Thread newThread(Runnable r) {
/* 37 */     Thread t = new Thread(r, String.valueOf(this.namePrefix) + this.threadNumber.getAndIncrement());
/* 38 */     t.setDaemon(this.daemon);
/* 39 */     t.setPriority(this.priority);
/* 40 */     return t;
/*    */   }
/*    */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\game\PoolFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */