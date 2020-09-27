/*     */ package com.wanniu.core.logfs;
/*     */ 
/*     */ import com.wanniu.core.GConfig;
/*     */ import com.wanniu.core.GGame;
/*     */ import com.wanniu.core.GGlobal;
/*     */ import com.wanniu.core.game.PoolFactory;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Out
/*     */ {
/*  29 */   private static final ExecutorService ANSYC_LOG_EXEC = Executors.newSingleThreadExecutor((ThreadFactory)new PoolFactory("ansyc-log"));
/*     */   
/*  31 */   private static final boolean CONSOLE = GConfig.getInstance().getBoolean("log.console", true);
/*     */ 
/*     */ 
/*     */   
/*  35 */   private static final DateTimeFormatter DEFAULT_DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
/*     */   
/*  37 */   private static final DateTimeFormatter FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
/*     */ 
/*     */   
/*  40 */   private static final StringBuilder DEFUALT_LOG_BUILDER = new StringBuilder(512);
/*  41 */   private static Level LEVEL = Level.INFO;
/*     */   
/*     */   private static boolean setting;
/*     */   
/*     */   public static synchronized void setting() {
/*  46 */     if (setting) {
/*     */       return;
/*     */     }
/*  49 */     setting = true;
/*  50 */     LEVEL = Level.valueOf(GConfig.getInstance().get("log.level", "INFO").toUpperCase());
/*  51 */     File dir = new File(GGlobal.DIR_LOG);
/*  52 */     if (!dir.exists() || !dir.isDirectory()) {
/*  53 */       dir.mkdir();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setLevel(Level level) {
/*  58 */     LEVEL = level;
/*     */   }
/*     */   
/*     */   private static class Log implements Runnable {
/*     */     private final Level type;
/*     */     private final Object[] args;
/*     */     private final LocalDateTime date;
/*     */     private final String threadName;
/*     */     private String fileName;
/*     */     private int lineNumber;
/*     */     
/*     */     Log(Level type, Object... args) {
/*  70 */       this.args = args;
/*  71 */       this.type = type;
/*  72 */       this.date = LocalDateTime.now();
/*     */       
/*  74 */       Thread thread = Thread.currentThread();
/*  75 */       this.threadName = thread.getName();
/*     */       
/*  77 */       if (Out.LEVEL == Level.DEBUG) {
/*  78 */         StackTraceElement stackTraceElement = thread.getStackTrace()[4];
/*  79 */         this.fileName = stackTraceElement.getFileName();
/*  80 */         this.lineNumber = stackTraceElement.getLineNumber();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/*  87 */         String text = build(this.type, this.args);
/*  88 */         if (Out.CONSOLE) {
/*  89 */           switch (this.type) {
/*     */             case DEBUG:
/*     */             case INFO:
/*  92 */               System.out.print(text);
/*     */               break;
/*     */             default:
/*  95 */               System.err.print(text);
/*     */               break;
/*     */           } 
/*     */         }
/*  99 */         Out.writer(this.date, text);
/* 100 */       } catch (Exception e) {
/* 101 */         Out.error(new Object[] { "Out run", e });
/*     */       } 
/*     */     }
/*     */     
/*     */     private String build(Level type, Object... args) {
/* 106 */       Out.DEFUALT_LOG_BUILDER.setLength(0);
/*     */       
/* 108 */       Out.DEFUALT_LOG_BUILDER.append(Out.DEFAULT_DATE_FORMATER.format(this.date));
/*     */       
/* 110 */       Out.DEFUALT_LOG_BUILDER.append(" [").append(this.threadName).append("] ").append(type);
/*     */       
/* 112 */       if (Out.LEVEL == Level.DEBUG) {
/* 113 */         Out.DEFUALT_LOG_BUILDER.append(" ").append(this.fileName).append(":").append(this.lineNumber);
/*     */       }
/* 115 */       Out.DEFUALT_LOG_BUILDER.append(" - ");
/*     */       
/* 117 */       for (Object object : args) {
/* 118 */         if (object instanceof Throwable) {
/* 119 */           try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
/* 120 */             ((Throwable)object).printStackTrace(pw);
/* 121 */             Out.DEFUALT_LOG_BUILDER.append("\n").append(sw.toString());
/* 122 */           } catch (Exception e) {
/* 123 */             Out.DEFUALT_LOG_BUILDER.append(object);
/*     */           } 
/*     */         } else {
/* 126 */           Out.DEFUALT_LOG_BUILDER.append(object);
/*     */         } 
/*     */       } 
/* 129 */       Out.DEFUALT_LOG_BUILDER.append("\n");
/* 130 */       return Out.DEFUALT_LOG_BUILDER.toString();
/*     */     }
/*     */   }
/*     */   
/* 134 */   private static int lastWriterHour = -1;
/* 135 */   private static BufferedWriter fileWriter = null;
/*     */ 
/*     */   
/*     */   private static void writer(LocalDateTime date, String x) throws IOException {
/* 139 */     if (fileWriter == null || date.getHour() != lastWriterHour) {
/*     */ 
/*     */       
/* 142 */       if (fileWriter != null) {
/* 143 */         fileWriter.flush();
/* 144 */         fileWriter.close();
/*     */       } 
/*     */       
/* 147 */       StringBuilder filename = new StringBuilder(128);
/* 148 */       filename.append(GGlobal.DIR_LOG).append(File.separator);
/* 149 */       filename.append(GGame.__SERVER_ID).append(File.separator);
/* 150 */       filename.append("game-").append(date.format(FILE_FORMATTER)).append(".log");
/* 151 */       File file = new File(filename.toString());
/* 152 */       if (!file.exists()) {
/* 153 */         File fileParent = file.getParentFile();
/* 154 */         if (!fileParent.exists()) {
/* 155 */           fileParent.mkdirs();
/*     */         }
/* 157 */         file.createNewFile();
/*     */       } 
/*     */       
/* 160 */       fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
/*     */     } 
/*     */     
/* 163 */     fileWriter.write(x);
/* 164 */     fileWriter.flush();
/*     */   }
/*     */   
/*     */   private static void put(Level type, Object... args) {
/* 168 */     ANSYC_LOG_EXEC.execute(new Log(type, args));
/*     */   }
/*     */   
/*     */   public static boolean isEnable(Level level) {
/* 172 */     return (LEVEL.compareTo(level) <= 0);
/*     */   }
/*     */   
/*     */   public static boolean isEnableDebug() {
/* 176 */     return (LEVEL == Level.DEBUG);
/*     */   }
/*     */   
/*     */   public static boolean isEnableInfo() {
/* 180 */     return isEnable(Level.INFO);
/*     */   }
/*     */   
/*     */   public static void debug(Object... args) {
/* 184 */     if (isEnableDebug()) {
/* 185 */       put(Level.DEBUG, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void info(Object... args) {
/* 190 */     if (isEnableInfo()) {
/* 191 */       put(Level.INFO, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void warn(Object... args) {
/* 196 */     put(Level.WARN, args);
/*     */   }
/*     */   
/*     */   public static void error(Object... args) {
/* 200 */     put(Level.ERROR, args);
/*     */   }
/*     */   
/*     */   public static void shutdown() {
/* 204 */     ANSYC_LOG_EXEC.shutdown();
/* 205 */     if (fileWriter != null)
/*     */       try {
/* 207 */         fileWriter.close();
/* 208 */       } catch (IOException iOException) {} 
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\logfs\Out.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */