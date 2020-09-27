/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.db.PoolFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.RuntimeMXBean;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.log4j.xml.DOMConfigurator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GSystem
/*     */ {
/*  31 */   private static ScheduledExecutorService __EXECUTOR__ = Executors.newSingleThreadScheduledExecutor((ThreadFactory)new PoolFactory("系统维护", true));
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addFixedRateJob(Runnable runnable, long initialDelay, long period) {
/*     */     try {
/*  36 */       return __EXECUTOR__.scheduleAtFixedRate(runnable, Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
/*  37 */     } catch (Exception e) {
/*  38 */       Out.error(new Object[] { e });
/*     */       
/*  40 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addScheduleJob(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
/*     */     try {
/*  45 */       return __EXECUTOR__.scheduleWithFixedDelay(runnable, Math.max(1L, initialDelay), delay, unit);
/*  46 */     } catch (Exception e) {
/*  47 */       Out.error(new Object[] { e });
/*     */       
/*  49 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay, TimeUnit unit) {
/*  53 */     return __EXECUTOR__.schedule(runnable, delay, unit);
/*     */   }
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay) {
/*  56 */     return __EXECUTOR__.schedule(runnable, delay, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OsType
/*     */   {
/*  63 */     OS_UNKNOWN, OS_NT, OS_9X, OS_LINUX, OS_UNIX;
/*     */   }
/*     */ 
/*     */   
/*  67 */   public static final String CRLF = System.getProperty("line.separator");
/*     */ 
/*     */   
/*  70 */   public static final String OS_NAME = System.getProperty("os.name").toUpperCase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String execCmd(String[] execCmds) {
/*  80 */     int ret = 0;
/*  81 */     Process porc = null;
/*  82 */     InputStream perr = null, pin = null;
/*  83 */     StringBuilder sb = new StringBuilder();
/*  84 */     String line = null;
/*  85 */     BufferedReader br = null;
/*     */     
/*     */     try {
/*  88 */       porc = Runtime.getRuntime().exec(execCmds, (String[])null, (File)null);
/*  89 */       perr = porc.getErrorStream();
/*  90 */       pin = porc.getInputStream();
/*     */       
/*  92 */       br = new BufferedReader(new InputStreamReader(pin));
/*  93 */       while ((line = br.readLine()) != null)
/*     */       {
/*  95 */         sb.append(line).append(CRLF);
/*     */       }
/*     */       
/*  98 */       br = new BufferedReader(new InputStreamReader(perr));
/*  99 */       while ((line = br.readLine()) != null) {
/* 100 */         System.err.println("exec()E: " + line);
/*     */       }
/* 102 */       porc.waitFor();
/* 103 */       ret = porc.exitValue();
/* 104 */       if (ret != 0) {
/* 105 */         System.err.println("porc.exitValue() = " + ret);
/*     */       }
/*     */       
/* 108 */       return sb.toString();
/* 109 */     } catch (Exception e) {
/* 110 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 112 */       porc.destroy();
/*     */     } 
/* 114 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getFreeDiskSize(String dir) {
/* 125 */     String[] cmds = null;
/* 126 */     long freeSize = -1L;
/* 127 */     OsType osType = getOSType();
/* 128 */     switch (osType) {
/*     */       case OS_NT:
/* 130 */         cmds = new String[] { "cmd.exe", "/c", "dir", dir };
/* 131 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case null:
/* 134 */         cmds = new String[] { "command.exe", "/c", "dir", dir };
/* 135 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case OS_LINUX:
/*     */       case OS_UNIX:
/* 139 */         cmds = new String[] { "df", dir };
/* 140 */         freeSize = parseUnixFreeSize(execCmd(cmds));
/*     */         break;
/*     */     } 
/*     */     
/* 144 */     return freeSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLastLine(String txt) {
/* 154 */     StringBuilder builder = new StringBuilder(txt);
/* 155 */     if (builder.length() > CRLF.length() * 2) {
/*     */       
/* 157 */       builder.delete(builder.lastIndexOf(CRLF), builder.length());
/* 158 */       return builder.substring(builder.lastIndexOf(CRLF) + CRLF.length(), builder.length());
/*     */     } 
/* 160 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<String> split(String msg) {
/* 171 */     String[] splited = msg.split(" ");
/* 172 */     List<String> list = new ArrayList<>();
/* 173 */     for (int i = 0; i < splited.length; i++) {
/* 174 */       if (splited[i] != null) {
/* 175 */         splited[i] = splited[i].trim();
/* 176 */         if (splited[i].length() > 0) {
/* 177 */           list.add(splited[i]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return list;
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
/*     */   private static long parseUnixFreeSize(String cmdReturnContent) {
/* 194 */     String lastLine = getLastLine(cmdReturnContent);
/* 195 */     List<String> elements = split(lastLine);
/* 196 */     if (elements.size() < 6) {
/* 197 */       return -1L;
/*     */     }
/* 199 */     System.out.println("os_freesize_unix() 目录:\t" + (String)elements.get(0));
/* 200 */     System.out.println("os_freesize_unix() 总共:\t" + (String)elements.get(1));
/* 201 */     System.out.println("os_freesize_unix() 已用:\t" + (String)elements.get(2));
/* 202 */     System.out.println("os_freesize_unix() 可用:\t" + (String)elements.get(3));
/* 203 */     System.out.println("os_freesize_unix() 可用%:\t" + (String)elements.get(4));
/* 204 */     System.out.println("os_freesize_unix() 挂接:\t" + (String)elements.get(5));
/*     */     
/* 206 */     return Long.parseLong(elements.get(3)) * 1024L;
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
/*     */   private static long parseWindowsFreeSize(String cmdReturnContent) {
/* 218 */     String lastLine = getLastLine(cmdReturnContent);
/* 219 */     List<String> elements = split(lastLine);
/* 220 */     if (elements.size() < 4) {
/* 221 */       return -1L;
/*     */     }
/*     */     
/* 224 */     String freeSize = ((String)elements.get(2)).replaceAll(",", "");
/*     */     
/* 226 */     return Long.parseLong(freeSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OsType getOSType() {
/* 235 */     if (OS_NAME.startsWith("WINDOWS")) {
/* 236 */       if (OS_NAME.endsWith("7") || OS_NAME.endsWith("XP") || OS_NAME.endsWith("8") || OS_NAME.endsWith("2000") || OS_NAME.endsWith("NT")) {
/* 237 */         return OsType.OS_NT;
/*     */       }
/* 239 */       return OsType.OS_9X;
/*     */     } 
/* 241 */     if (OS_NAME.indexOf("LINUX") > 0)
/* 242 */       return OsType.OS_LINUX; 
/* 243 */     if (OS_NAME.indexOf("UX") > 0) {
/* 244 */       return OsType.OS_UNIX;
/*     */     }
/* 246 */     return OsType.OS_UNKNOWN;
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
/*     */   public static void destoryThread(String threadNamePrefix) {
/* 258 */     Thread[] threads = new Thread[Thread.activeCount()];
/*     */     
/* 260 */     int n = Thread.enumerate(threads);
/* 261 */     for (int i = 0; i < n; i++) {
/* 262 */       String tName = threads[i].getName();
/* 263 */       if (tName.startsWith(threadNamePrefix) && 
/* 264 */         !threads[i].isInterrupted()) {
/* 265 */         threads[i].interrupt();
/* 266 */         System.out.println(String.valueOf(tName) + ">>>>>>>>>>>>已销毁...");
/*     */       } 
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
/*     */   
/*     */   public static boolean execScriptFile(String fileName) {
/*     */     try {
/* 281 */       Runtime.getRuntime().exec(fileName);
/* 282 */     } catch (Exception e) {
/* 283 */       return false;
/*     */     } 
/* 285 */     return true;
/*     */   }
/*     */   
/*     */   public static void waitMills(int mills) {
/*     */     try {
/* 290 */       Thread.sleep(mills);
/* 291 */     } catch (InterruptedException e) {
/* 292 */       Out.error(new Object[] { e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void waitSeconds(int second) {
/* 297 */     waitMills(second * 1000);
/*     */   }
/*     */   
/*     */   public static void open(boolean isOnlyConfigLog4j) {
/* 301 */     OsType os = getOSType();
/* 302 */     if (os != OsType.OS_NT && os != OsType.OS_9X) {
/* 303 */       RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
/* 304 */       String name = runtime.getName();
/* 305 */       int pid = Integer.parseInt(name.substring(0, name.indexOf('@')));
/* 306 */       File PID = new File(String.valueOf(System.getProperty("user.dir")) + File.separatorChar + "game.pid");
/* 307 */       if (PID.exists()) {
/* 308 */         System.err.println("This Game is Running? Please stop game or remove game.pid!");
/* 309 */         System.exit(1);
/*     */       } else {
/*     */         try {
/* 312 */           PrintWriter output = new PrintWriter(new FileWriter(PID));
/* 313 */           output.write(String.valueOf(pid));
/* 314 */           output.close();
/* 315 */         } catch (IOException e) {
/* 316 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       } 
/* 319 */       PID.deleteOnExit();
/*     */     } 
/*     */ 
/*     */     
/* 323 */     Out.setting();
/* 324 */     File log4j = new File(String.valueOf(GGlobal.DIR_CONF_SERVER) + "log4j.xml");
/* 325 */     if (log4j.exists()) {
/* 326 */       DOMConfigurator.configure(log4j.getAbsolutePath());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getUsedMemoryMB() {
/* 333 */     return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L;
/*     */   }
/*     */   
/*     */   public static long getFreeMemoryMB() {
/* 337 */     return (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + 
/* 338 */       Runtime.getRuntime().freeMemory()) / 1048576L;
/*     */   }
/*     */   
/*     */   public static long getMaxMemoryMB() {
/* 342 */     return Runtime.getRuntime().maxMemory() / 1048576L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free() {
/* 348 */     long freeMem = getFreeMemoryMB();
/*     */     
/* 350 */     long totalMem = getMaxMemoryMB();
/* 351 */     Out.red(new Object[] { "\n回收前空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M" });
/*     */ 
/*     */ 
/*     */     
/* 355 */     System.gc();
/*     */ 
/*     */ 
/*     */     
/* 359 */     freeMem = getFreeMemoryMB();
/*     */     
/* 361 */     totalMem = getMaxMemoryMB();
/* 362 */     Out.red(new Object[] { "回收后空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M\n" });
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\GSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */