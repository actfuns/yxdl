/*     */ package com.wanniu.core.db;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.db.handler.DBHandler;
/*     */ import com.wanniu.core.db.pool.DBFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GDao
/*     */   implements Runnable
/*     */ {
/*  20 */   private static final int __QUEUE_SIZE__ = GConfig.getInstance().getInt("db.queue.size", 10000);
/*  21 */   private static final int __WARN_COUNT__ = __QUEUE_SIZE__ * 2 / 3;
/*     */ 
/*     */   
/*  24 */   private static final BlockingQueue<DBHandler> __QUEUE__ = new LinkedBlockingQueue<>(__QUEUE_SIZE__);
/*     */   
/*  26 */   private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("db.monitor.enable", true);
/*  27 */   private static final int __MONITOR_OPTIME__ = GConfig.getInstance().getInt("db.monitor.optime", 111);
/*     */ 
/*     */   
/*  30 */   private static final String __DS_NAME__ = GConfig.getInstance().get("db.dsname", "master");
/*     */   
/*  32 */   private static final String __DS_MASTER__ = GConfig.getInstance().get("db.ds.master", __DS_NAME__);
/*     */   
/*  34 */   private static final String __DS_SLAVE__ = GConfig.getInstance().get("db.ds.slave", __DS_NAME__);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean __STARTED__;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void start() {
/*  48 */     if (!__STARTED__) {
/*  49 */       __STARTED__ = true;
/*  50 */       int dbThreadCount = GConfig.getInstance().getInt("db.thread.count", 0);
/*  51 */       if (dbThreadCount > 0) {
/*  52 */         DBFactory.init();
/*  53 */         for (int i = 0; i < dbThreadCount; i++) {
/*  54 */           (new Thread(new GDao(), "DB处理器" + dbThreadCount)).start();
/*  55 */           dbThreadCount--;
/*     */         } 
/*  57 */         Out.info(new Object[] { "数据库服务已启动 !" });
/*     */       } else {
/*  59 */         Out.info(new Object[] { "未集成数据库服务!!!" });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(DBHandler handler) {
/*  70 */     if (__QUEUE__.offer(handler)) {
/*  71 */       if (__QUEUE__.size() > __WARN_COUNT__) {
/*  72 */         Out.warn(new Object[] { "待处理数据库操作队列太长(1)：", Integer.valueOf(__QUEUE__.size()) });
/*     */       }
/*     */     } else {
/*  75 */       Out.warn(new Object[] { "待处理数据库操作队列太长(2)", Integer.valueOf(__QUEUE__.size()) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(DBHandler handler) {
/*  84 */     if (__QUEUE__.offer(handler)) {
/*  85 */       if (__QUEUE__.size() > __WARN_COUNT__) {
/*  86 */         Out.warn(new Object[] { "待处理数据库操作队列太长(1)：", Integer.valueOf(__QUEUE__.size()) });
/*     */       }
/*     */     } else {
/*  89 */       __CARE__(handler);
/*     */     } 
/*     */   }
/*     */   
/*  93 */   private static Thread __thread__ = null;
/*  94 */   private static LinkedList<DBHandler> __waits__ = new LinkedList<>();
/*     */   private static synchronized void __CARE__(DBHandler handler) {
/*  96 */     __waits__.add(handler);
/*  97 */     if (__thread__ == null) {
/*  98 */       __thread__ = new Thread(new Runnable()
/*     */           {
/*     */             public void run() {
/* 101 */               DBHandler db = null;
/*     */               while (true) {
/* 103 */                 db = GDao.__waits__.poll();
/* 104 */                 if (db == null) {
/*     */                   break;
/*     */                 }
/* 107 */                 db.run();
/*     */               } 
/* 109 */               GDao.__thread__ = null;
/*     */             }
/*     */           });
/* 112 */       __thread__.start();
/* 113 */       Out.warn(new Object[] { String.format("启动数据保护线程：%d - %d", new Object[] { Integer.valueOf(__QUEUE__.size()), Integer.valueOf(__waits__.size()) }) });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 118 */     DBHandler handler = null;
/* 119 */     long starTime = 0L;
/*     */     while (true) {
/*     */       try {
/* 122 */         handler = __QUEUE__.take();
/* 123 */         if (__MONITOR_ENABLE__) {
/* 124 */           starTime = System.currentTimeMillis();
/* 125 */           handler.run();
/* 126 */           if (System.currentTimeMillis() - starTime > __MONITOR_OPTIME__)
/* 127 */             Out.error(new Object[] { String.format("数据库操作耗时过长(ms)：%s -- %s", new Object[] { Long.valueOf(System.currentTimeMillis() - starTime), handler.getClass().getName() }) }); 
/*     */           continue;
/*     */         } 
/* 130 */         handler.run();
/*     */       }
/* 132 */       catch (Exception e) {
/* 133 */         Out.error(new Object[] { e });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Connection getConn() {
/* 140 */     return getConnection(__DS_NAME__);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Connection getMaster() {
/* 145 */     return getConnection(__DS_MASTER__);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Connection getSlave() {
/* 150 */     return getConnection(__DS_SLAVE__);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Connection getConnection(String dsName) {
/* 155 */     Connection con = null;
/*     */     try {
/* 157 */       con = DBFactory.lookup(dsName).getConnection();
/* 158 */     } catch (SQLException e) {
/* 159 */       Out.error(new Object[] { "GDao getConnection", e });
/*     */     } 
/* 161 */     return con;
/*     */   }
/*     */   
/*     */   public static int size() {
/* 165 */     return __QUEUE__.size() + __waits__.size();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\GDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */