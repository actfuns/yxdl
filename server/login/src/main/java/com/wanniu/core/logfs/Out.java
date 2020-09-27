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
/*  23 */     private static final boolean CONSOLE = GConfig.getInstance().getBoolean("log.console", true);
/*  24 */     private static final SimpleDateFormat FORMAT_DAY = new SimpleDateFormat("yyyy-MM-dd");
/*     */     
/*     */     private PrintStream fps;
/*     */     private String fileName;
/*     */     private String filePath;
/*     */     private boolean newLog = true;
/*     */     
/*     */     private OutPrintStream(PrintStream print, String fs) {
/*  32 */       super(print);
/*  33 */       this.fileName = fs;
/*  34 */       Calendar calendar = Calendar.getInstance();
/*  35 */       calendar.set(11, 23);
/*  36 */       calendar.set(12, 59);
/*  37 */       calendar.set(13, 59);
/*  38 */       GSystem.addFixedRateJob(new Runnable()
/*     */           {
/*     */             public void run() {
/*  41 */               Out.OutPrintStream.this.newLog = true;
/*     */             }
/*  43 */           },  calendar.getTimeInMillis() - System.currentTimeMillis(), 86400000L);
/*     */     }
/*     */     
/*     */     public void write(byte[] buf, int off, int len) {
/*  47 */       newLog();
/*  48 */       if (CONSOLE) {
/*  49 */         super.write(buf, off, len);
/*     */       }
/*  51 */       this.fps.write(buf, off, len);
/*     */     }
/*     */     
/*     */     public void flush() {
/*  55 */       if (CONSOLE) {
/*  56 */         super.flush();
/*     */       }
/*  58 */       this.fps.flush();
/*     */     }
/*     */     
/*     */     private String getFilePath() {
/*  62 */       String day = FORMAT_DAY.format(new Date());
/*  63 */       return GGlobal.DIR_LOG + File.separator + 
/*  64 */         day.substring(0, 7) + File.separator + day + File.separator + 
/*  65 */         this.fileName;
/*     */     }
/*     */     
/*     */     public void newLog() {
/*  69 */       if (this.newLog && !getFilePath().equals(this.filePath)) {
/*     */         try {
/*  71 */           if (this.fps != null) {
/*  72 */             this.fps.close();
/*     */           }
/*  74 */           this.newLog = false;
/*  75 */           this.filePath = getFilePath();
/*  76 */           File log = new File(this.filePath);
/*  77 */           log.getParentFile().mkdirs();
/*  78 */           this.fps = new PrintStream(new FileOutputStream(log, true));
/*  79 */         } catch (Exception e) {
/*  80 */           e.printStackTrace();
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*  86 */   private static Level LEVEL = Level.INFO;
/*     */   private static boolean setting;
/*     */   
/*     */   public static void setting() {
/*  90 */     if (setting)
/*  91 */       return;  setting = true;
/*  92 */     LEVEL = Level.valueOf(GConfig.getInstance().get("log.level", "INFO").toUpperCase());
/*  93 */     File dir = new File(GGlobal.DIR_LOG);
/*  94 */     if (!dir.exists() || !dir.isDirectory()) {
/*  95 */       dir.mkdir();
/*     */     }
/*  97 */     System.setOut(new OutPrintStream(System.out, "system.out.log", null));
/*  98 */     System.setErr(new OutPrintStream(System.err, "system.err.log", null));
/*     */   }
/*     */   
/*     */   public static boolean isEnable(Level level) {
/* 102 */     return (LEVEL.compareTo(level) <= 0);
/*     */   }
/*     */   
/*     */   public static boolean isEnableDebug() {
/* 106 */     return isEnable(Level.DEBUG);
/*     */   }
/*     */   
/*     */   public static boolean isEnableInfo() {
/* 110 */     return isEnable(Level.INFO);
/*     */   }
/*     */   
/*     */   private static String log(String type, Object... args) {
/* 114 */     StringBuilder builder = new StringBuilder();
/* 115 */     builder.append(DateUtil.getTime("yyyy-MM-dd HH:mm:ss.SSS")).append(" [").append(type)
/* 116 */       .append("] : "); byte b; int i; Object[] arrayOfObject;
/* 117 */     for (i = (arrayOfObject = args).length, b = 0; b < i; ) { Object object = arrayOfObject[b];
/* 118 */       if (object instanceof Throwable) {
/* 119 */         ((Throwable)object).printStackTrace();
/* 120 */         builder.append(((Throwable)object).getMessage());
/*     */       } else {
/* 122 */         builder.append(object);
/*     */       }  b++; }
/*     */     
/* 125 */     return builder.toString();
/*     */   }
/*     */   
/*     */   public static void debug(Object... args) {
/* 129 */     if (isEnableDebug()) {
/* 130 */       System.out.println(log("DEBUG", args));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void info(Object... args) {
/* 135 */     if (isEnableInfo()) {
/* 136 */       System.out.println(log("INFO", args));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void warn(Object... args) {
/* 141 */     System.err.println(log("WARN", args));
/*     */   }
/*     */   
/*     */   public static void error(Object... args) {
/* 145 */     System.err.println(log("ERROR", args));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void red(Object... args) {
/* 152 */     System.err.println(log("RED", args));
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\logfs\Out.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */