/*     */ package com.wanniu.core.logfs;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Out
/*     */ {
/*     */   private static class OutPrintStream
/*     */     extends PrintStream
/*     */   {
/*  25 */     private static final boolean CONSOLE = GConfig.getInstance().getBoolean("log.console", true);
/*  26 */     private static final SimpleDateFormat FORMAT_DAY = new SimpleDateFormat("yyyy-MM-dd");
/*     */     
/*     */     private PrintStream fps;
/*     */     private String fileName;
/*     */     private String filePath;
/*     */     private boolean newLog = true;
/*     */     
/*     */     private OutPrintStream(PrintStream print, String fs) {
/*  34 */       super(print);
/*  35 */       this.fileName = fs;
/*  36 */       Calendar calendar = Calendar.getInstance();
/*  37 */       calendar.set(11, 23);
/*  38 */       calendar.set(12, 59);
/*  39 */       calendar.set(13, 59);
/*  40 */       GSystem.addFixedRateJob(new Runnable()
/*     */           {
/*     */             public void run() {
/*  43 */               Out.OutPrintStream.this.newLog = true;
/*     */             }
/*  45 */           },  calendar.getTimeInMillis() - System.currentTimeMillis(), 86400000L);
/*     */     }
/*     */     
/*     */     public void write(byte[] buf, int off, int len) {
/*  49 */       newLog();
/*  50 */       if (CONSOLE) {
/*  51 */         super.write(buf, off, len);
/*     */       }
/*  53 */       this.fps.write(buf, off, len);
/*     */     }
/*     */     
/*     */     public void flush() {
/*  57 */       if (CONSOLE) {
/*  58 */         super.flush();
/*     */       }
/*  60 */       this.fps.flush();
/*     */     }
/*     */     
/*     */     private String getFilePath() {
/*  64 */       String day = FORMAT_DAY.format(new Date());
/*  65 */       return GGlobal.DIR_LOG + File.separator + 
/*  66 */         day.substring(0, 7) + File.separator + day + File.separator + 
/*  67 */         this.fileName;
/*     */     }
/*     */     
/*     */     public void newLog() {
/*  71 */       if (this.newLog && !getFilePath().equals(this.filePath)) {
/*     */         try {
/*  73 */           if (this.fps != null) {
/*  74 */             this.fps.close();
/*     */           }
/*  76 */           this.newLog = false;
/*  77 */           this.filePath = getFilePath();
/*  78 */           File log = new File(this.filePath);
/*  79 */           log.getParentFile().mkdirs();
/*  80 */           this.fps = new PrintStream(new FileOutputStream(log, true));
/*  81 */         } catch (Exception e) {
/*  82 */           e.printStackTrace();
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*  88 */   private static Level LEVEL = Level.INFO;
/*     */   private static boolean setting;
/*     */   
/*     */   public static synchronized void setting() {
/*  92 */     if (setting)
/*  93 */       return;  setting = true;
/*  94 */     LEVEL = Level.valueOf(GConfig.getInstance().get("log.level", "INFO").toUpperCase());
/*  95 */     File dir = new File(GGlobal.DIR_LOG);
/*  96 */     if (!dir.exists() || !dir.isDirectory()) {
/*  97 */       dir.mkdir();
/*     */     }
/*  99 */     System.setOut(new OutPrintStream(System.out, "system.out.log"));
/* 100 */     System.setErr(new OutPrintStream(System.err, "system.err.log"));
/* 101 */     Thread thread = new Thread(new Runnable() {
/*     */           public void run() {
/*     */             while (true) {
/*     */               try {
/*     */                 label13: while (true) {
/* 106 */                   Out.Log log = Out.__QUEUE__.take();
/* 107 */                   switch (log.type) {
/*     */                     case DEBUG:
/* 109 */                       System.out.println(Out.log("DEBUG", log.threadName, log.args));
/*     */                       continue label13;
/*     */                     
/*     */                     case INFO:
/* 113 */                       System.out.println(Out.log("INFO", log.threadName, log.args));
/*     */                       continue label13;
/*     */                     
/*     */                     case WARN:
/* 117 */                       System.err.println(Out.log("WARN", log.threadName, log.args));
/*     */                       continue label13;
/*     */                     
/*     */                     case ERROR:
/* 121 */                       System.err.println(Out.log("ERROR", log.threadName, log.args));
break;
/*     */                   } 
/*     */                 }
/* 125 */               } catch (Exception e) {
/* 126 */                 e.printStackTrace();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/* 131 */     thread.setName("fs-log");
/* 132 */     thread.start();
/*     */   }
/*     */   
/*     */   private static class Log {
/*     */     Level type;
/*     */     Object[] args;
/*     */     String threadName;
/*     */     
/*     */     Log(Level type, Object... args) {
/* 141 */       this.args = args;
/* 142 */       this.type = type;
/* 143 */       this.threadName = Thread.currentThread().getName();
/*     */     }
/*     */   }
/*     */   
/* 147 */   private static final int LOG_QUEUE_SIZE = GConfig.getInstance().getInt("log.queue.size", 100000);
/* 148 */   private static final BlockingQueue<Log> __QUEUE__ = new LinkedBlockingQueue<>();
/*     */   
/*     */   private static void put(Level type, Object... args) {
/* 151 */     if (__QUEUE__.size() < LOG_QUEUE_SIZE) {
/* 152 */       __QUEUE__.add(new Log(type, args));
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean isEnable(Level level) {
/* 157 */     return (LEVEL.compareTo(level) <= 0);
/*     */   }
/*     */   
/*     */   public static boolean isEnableDebug() {
/* 161 */     return isEnable(Level.DEBUG);
/*     */   }
/*     */   
/*     */   public static boolean isEnableInfo() {
/* 165 */     return isEnable(Level.INFO);
/*     */   }
/*     */   
/*     */   private static String log(String type, String threadName, Object... args) {
/* 169 */     StringBuilder builder = new StringBuilder();
/* 170 */     builder.append(DateUtil.getTime("yyyy-MM-dd HH:mm:ss.SSS")).append(" [").append(type)
/* 171 */       .append("][").append(threadName)
/* 172 */       .append("] : "); byte b; int i; Object[] arrayOfObject;
/* 173 */     for (i = (arrayOfObject = args).length, b = 0; b < i; ) { Object object = arrayOfObject[b];
/* 174 */       if (object instanceof Throwable) {
/* 175 */         ((Throwable)object).printStackTrace();
/* 176 */         builder.append(((Throwable)object).getMessage());
/*     */       } else {
/* 178 */         builder.append(object);
/*     */       }  b++; }
/*     */     
/* 181 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public static void debug(Object... args) {
/* 185 */     if (isEnableDebug()) {
/* 186 */       put(Level.DEBUG, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void info(Object... args) {
/* 191 */     if (isEnableInfo()) {
/* 192 */       put(Level.INFO, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void warn(Object... args) {
/* 197 */     put(Level.WARN, args);
/*     */   }
/*     */   
/*     */   public static void error(Object... args) {
/* 201 */     put(Level.ERROR, args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void red(Object... args) {
/* 208 */     System.err.println(log("RED", Thread.currentThread().getName(), args));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\logfs\Out.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */