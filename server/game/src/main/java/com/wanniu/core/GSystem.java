/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.db.GDao;
/*     */ import com.wanniu.core.game.PoolFactory;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.NameUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GSystem
/*     */ {
/*  32 */   private static ScheduledExecutorService __EXECUTOR__ = Executors.newSingleThreadScheduledExecutor((ThreadFactory)new PoolFactory("系统维护", true));
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addFixedRateJob(Runnable runnable, long initialDelay, long period) {
/*     */     try {
/*  37 */       return __EXECUTOR__.scheduleAtFixedRate(runnable, Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
/*  38 */     } catch (Exception e) {
/*  39 */       Out.error(new Object[] { e });
/*     */       
/*  41 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addScheduleJob(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
/*     */     try {
/*  46 */       return __EXECUTOR__.scheduleWithFixedDelay(runnable, Math.max(1L, initialDelay), delay, unit);
/*  47 */     } catch (Exception e) {
/*  48 */       Out.error(new Object[] { e });
/*     */       
/*  50 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay, TimeUnit unit) {
/*  54 */     return __EXECUTOR__.schedule(runnable, delay, unit);
/*     */   }
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay) {
/*  57 */     return __EXECUTOR__.schedule(runnable, delay, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OsType
/*     */   {
/*  64 */     OS_UNKNOWN, OS_NT, OS_9X, OS_LINUX, OS_UNIX;
/*     */   }
/*     */ 
/*     */   
/*  68 */   public static final String CRLF = System.getProperty("line.separator");
/*     */ 
/*     */   
/*  71 */   public static final String OS_NAME = System.getProperty("os.name").toUpperCase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String execCmd(String[] execCmds) {
/*  81 */     int ret = 0;
/*  82 */     Process porc = null;
/*  83 */     InputStream perr = null, pin = null;
/*  84 */     StringBuilder sb = new StringBuilder();
/*  85 */     String line = null;
/*  86 */     BufferedReader br = null;
/*     */     
/*     */     try {
/*  89 */       porc = Runtime.getRuntime().exec(execCmds, (String[])null, (File)null);
/*  90 */       perr = porc.getErrorStream();
/*  91 */       pin = porc.getInputStream();
/*     */       
/*  93 */       br = new BufferedReader(new InputStreamReader(pin));
/*  94 */       while ((line = br.readLine()) != null)
/*     */       {
/*  96 */         sb.append(line).append(CRLF);
/*     */       }
/*     */       
/*  99 */       br = new BufferedReader(new InputStreamReader(perr));
/* 100 */       while ((line = br.readLine()) != null) {
/* 101 */         System.err.println("exec()E: " + line);
/*     */       }
/* 103 */       porc.waitFor();
/* 104 */       ret = porc.exitValue();
/* 105 */       if (ret != 0) {
/* 106 */         System.err.println("porc.exitValue() = " + ret);
/*     */       }
/*     */       
/* 109 */       return sb.toString();
/* 110 */     } catch (Exception e) {
/* 111 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 113 */       porc.destroy();
/*     */     } 
/* 115 */     return "";
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
/* 126 */     String[] cmds = null;
/* 127 */     long freeSize = -1L;
/* 128 */     OsType osType = getOSType();
/* 129 */     switch (osType) {
/*     */       case OS_NT:
/* 131 */         cmds = new String[] { "cmd.exe", "/c", "dir", dir };
/* 132 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case OS_9X:
/* 135 */         cmds = new String[] { "command.exe", "/c", "dir", dir };
/* 136 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case OS_LINUX:
/*     */       case OS_UNIX:
/* 140 */         cmds = new String[] { "df", dir };
/* 141 */         freeSize = parseUnixFreeSize(execCmd(cmds));
/*     */         break;
/*     */     } 
/*     */     
/* 145 */     return freeSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLastLine(String txt) {
/* 155 */     StringBuilder builder = new StringBuilder(txt);
/* 156 */     if (builder.length() > CRLF.length() * 2) {
/*     */       
/* 158 */       builder.delete(builder.lastIndexOf(CRLF), builder.length());
/* 159 */       return builder.substring(builder.lastIndexOf(CRLF) + CRLF.length(), builder.length());
/*     */     } 
/* 161 */     return "";
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
/* 172 */     String[] splited = msg.split(" ");
/* 173 */     List<String> list = new ArrayList<>();
/* 174 */     for (int i = 0; i < splited.length; i++) {
/* 175 */       if (splited[i] != null) {
/* 176 */         splited[i] = splited[i].trim();
/* 177 */         if (splited[i].length() > 0) {
/* 178 */           list.add(splited[i]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     return list;
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
/* 195 */     String lastLine = getLastLine(cmdReturnContent);
/* 196 */     List<String> elements = split(lastLine);
/* 197 */     if (elements.size() < 6) {
/* 198 */       return -1L;
/*     */     }
/* 200 */     System.out.println("os_freesize_unix() 目录:\t" + (String)elements.get(0));
/* 201 */     System.out.println("os_freesize_unix() 总共:\t" + (String)elements.get(1));
/* 202 */     System.out.println("os_freesize_unix() 已用:\t" + (String)elements.get(2));
/* 203 */     System.out.println("os_freesize_unix() 可用:\t" + (String)elements.get(3));
/* 204 */     System.out.println("os_freesize_unix() 可用%:\t" + (String)elements.get(4));
/* 205 */     System.out.println("os_freesize_unix() 挂接:\t" + (String)elements.get(5));
/*     */     
/* 207 */     return Long.parseLong(elements.get(3)) * 1024L;
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
/* 219 */     String lastLine = getLastLine(cmdReturnContent);
/* 220 */     List<String> elements = split(lastLine);
/* 221 */     if (elements.size() < 4) {
/* 222 */       return -1L;
/*     */     }
/*     */     
/* 225 */     String freeSize = ((String)elements.get(2)).replaceAll(",", "");
/*     */     
/* 227 */     return Long.parseLong(freeSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OsType getOSType() {
/* 236 */     if (OS_NAME.startsWith("WINDOWS")) {
/* 237 */       if (OS_NAME.endsWith("7") || OS_NAME.endsWith("XP") || OS_NAME.endsWith("8") || OS_NAME.endsWith("2000") || OS_NAME.endsWith("NT")) {
/* 238 */         return OsType.OS_NT;
/*     */       }
/* 240 */       return OsType.OS_9X;
/*     */     } 
/* 242 */     if (OS_NAME.indexOf("LINUX") > 0)
/* 243 */       return OsType.OS_LINUX; 
/* 244 */     if (OS_NAME.indexOf("UX") > 0) {
/* 245 */       return OsType.OS_UNIX;
/*     */     }
/* 247 */     return OsType.OS_UNKNOWN;
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
/* 259 */     Thread[] threads = new Thread[Thread.activeCount()];
/*     */     
/* 261 */     int n = Thread.enumerate(threads);
/* 262 */     for (int i = 0; i < n; i++) {
/* 263 */       String tName = threads[i].getName();
/* 264 */       if (tName.startsWith(threadNamePrefix) && 
/* 265 */         !threads[i].isInterrupted()) {
/* 266 */         threads[i].interrupt();
/* 267 */         System.out.println(tName + ">>>>>>>>>>>>已销毁...");
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
/* 282 */       Runtime.getRuntime().exec(fileName);
/* 283 */     } catch (Exception e) {
/* 284 */       return false;
/*     */     } 
/* 286 */     return true;
/*     */   }
/*     */   
/*     */   public static void waitMills(int mills) {
/*     */     try {
/* 291 */       Thread.sleep(mills);
/* 292 */     } catch (InterruptedException e) {
/* 293 */       Out.error(new Object[] { e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void waitSeconds(int second) {
/* 298 */     waitMills(second * 1000);
/*     */   }
/*     */   
/*     */   public static void open(boolean isOnlyConfigLog4j) {
/* 302 */     OsType os = getOSType();
/* 303 */     if (os != OsType.OS_NT && os != OsType.OS_9X) {
/* 304 */       RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
/* 305 */       String name = runtime.getName();
/* 306 */       int pid = Integer.parseInt(name.substring(0, name.indexOf('@')));
/* 307 */       File PID = new File(System.getProperty("user.dir") + File.separatorChar + "game.pid");
/* 308 */       if (PID.exists()) {
/* 309 */         System.out.println("This Game is Running? Please stop game or remove game.pid!");
/* 310 */         System.exit(1);
/*     */       } else {
/*     */         try {
/* 313 */           PrintWriter output = new PrintWriter(new FileWriter(PID));
/* 314 */           output.write(String.valueOf(pid));
/* 315 */           output.close();
/* 316 */         } catch (IOException e) {
/* 317 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       } 
/* 320 */       PID.deleteOnExit();
/*     */     } 
/*     */ 
/*     */     
/* 324 */     Out.setting();
/* 325 */     if (!isOnlyConfigLog4j) {
/* 326 */       GDao.start();
/* 327 */       NameUtil.init();
/*     */     } 
/*     */   }
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
/* 351 */     Out.info(new Object[] { "\n回收前空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M" });
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
/* 362 */     Out.info(new Object[] { "回收后空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M\n" });
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\GSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */