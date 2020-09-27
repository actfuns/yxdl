/*     */ package com.wanniu.core;
/*     */ 
/*     */ import com.wanniu.core.game.LangService;
/*     */ import com.wanniu.core.game.PoolFactory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GSystem
/*     */ {
/*  30 */   private static ScheduledExecutorService __EXECUTOR__ = Executors.newSingleThreadScheduledExecutor((ThreadFactory)new PoolFactory("系统维护", true));
/*     */ 
/*     */   
/*     */   public static ScheduledFuture<?> addFixedRateJob(Runnable runnable, long initialDelay, long period) {
/*     */     try {
/*  35 */       return __EXECUTOR__.scheduleAtFixedRate(runnable, Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
/*  36 */     } catch (Exception e) {
/*  37 */       Out.error(new Object[] { e });
/*     */       
/*  39 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addScheduleJob(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
/*     */     try {
/*  44 */       return __EXECUTOR__.scheduleWithFixedDelay(runnable, Math.max(1L, initialDelay), delay, unit);
/*  45 */     } catch (Exception e) {
/*  46 */       Out.error(new Object[] { e });
/*     */       
/*  48 */       return null;
/*     */     } 
/*     */   }
/*     */   public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay, TimeUnit unit) {
/*  52 */     return __EXECUTOR__.schedule(runnable, delay, unit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum OsType
/*     */   {
/*  59 */     OS_UNKNOWN, OS_NT, OS_9X, OS_LINUX, OS_UNIX;
/*     */   }
/*     */ 
/*     */   
/*  63 */   public static final String CRLF = System.getProperty("line.separator");
/*     */ 
/*     */   
/*  66 */   public static final String OS_NAME = System.getProperty("os.name").toUpperCase();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String execCmd(String[] execCmds) {
/*  76 */     int ret = 0;
/*  77 */     Process porc = null;
/*  78 */     InputStream perr = null, pin = null;
/*  79 */     StringBuilder sb = new StringBuilder();
/*  80 */     String line = null;
/*  81 */     BufferedReader br = null;
/*     */     
/*     */     try {
/*  84 */       porc = Runtime.getRuntime().exec(execCmds, (String[])null, (File)null);
/*  85 */       perr = porc.getErrorStream();
/*  86 */       pin = porc.getInputStream();
/*     */       
/*  88 */       br = new BufferedReader(new InputStreamReader(pin));
/*  89 */       while ((line = br.readLine()) != null)
/*     */       {
/*  91 */         sb.append(line).append(CRLF);
/*     */       }
/*     */       
/*  94 */       br = new BufferedReader(new InputStreamReader(perr));
/*  95 */       while ((line = br.readLine()) != null) {
/*  96 */         System.err.println("exec()E: " + line);
/*     */       }
/*  98 */       porc.waitFor();
/*  99 */       ret = porc.exitValue();
/* 100 */       if (ret != 0) {
/* 101 */         System.err.println("porc.exitValue() = " + ret);
/*     */       }
/*     */       
/* 104 */       return sb.toString();
/* 105 */     } catch (Exception e) {
/* 106 */       e.printStackTrace();
/*     */     } finally {
/* 108 */       porc.destroy();
/*     */     } 
/* 110 */     return "";
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
/* 121 */     String[] cmds = null;
/* 122 */     long freeSize = -1L;
/* 123 */     OsType osType = getOSType();
/* 124 */     switch (osType) {
/*     */       case OS_NT:
/* 126 */         cmds = new String[] { "cmd.exe", "/c", "dir", dir };
/* 127 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case null:
/* 130 */         cmds = new String[] { "command.exe", "/c", "dir", dir };
/* 131 */         freeSize = parseWindowsFreeSize(execCmd(cmds));
/*     */         break;
/*     */       case OS_LINUX:
/*     */       case OS_UNIX:
/* 135 */         cmds = new String[] { "df", dir };
/* 136 */         freeSize = parseUnixFreeSize(execCmd(cmds));
/*     */         break;
/*     */     } 
/*     */     
/* 140 */     return freeSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getLastLine(String txt) {
/* 150 */     StringBuilder builder = new StringBuilder(txt);
/* 151 */     if (builder.length() > CRLF.length() * 2) {
/*     */       
/* 153 */       builder.delete(builder.lastIndexOf(CRLF), builder.length());
/* 154 */       return builder.substring(builder.lastIndexOf(CRLF) + CRLF.length(), builder.length());
/*     */     } 
/* 156 */     return "";
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
/* 167 */     String[] splited = msg.split(" ");
/* 168 */     List<String> list = new ArrayList<>();
/* 169 */     for (int i = 0; i < splited.length; i++) {
/* 170 */       if (splited[i] != null) {
/* 171 */         splited[i] = splited[i].trim();
/* 172 */         if (splited[i].length() > 0) {
/* 173 */           list.add(splited[i]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     return list;
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
/* 190 */     String lastLine = getLastLine(cmdReturnContent);
/* 191 */     List<String> elements = split(lastLine);
/* 192 */     if (elements.size() < 6) {
/* 193 */       return -1L;
/*     */     }
/* 195 */     System.out.println("os_freesize_unix() 目录:\t" + (String)elements.get(0));
/* 196 */     System.out.println("os_freesize_unix() 总共:\t" + (String)elements.get(1));
/* 197 */     System.out.println("os_freesize_unix() 已用:\t" + (String)elements.get(2));
/* 198 */     System.out.println("os_freesize_unix() 可用:\t" + (String)elements.get(3));
/* 199 */     System.out.println("os_freesize_unix() 可用%:\t" + (String)elements.get(4));
/* 200 */     System.out.println("os_freesize_unix() 挂接:\t" + (String)elements.get(5));
/*     */     
/* 202 */     return Long.parseLong(elements.get(3)) * 1024L;
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
/* 214 */     String lastLine = getLastLine(cmdReturnContent);
/* 215 */     List<String> elements = split(lastLine);
/* 216 */     if (elements.size() < 4) {
/* 217 */       return -1L;
/*     */     }
/*     */     
/* 220 */     String freeSize = ((String)elements.get(2)).replaceAll(",", "");
/*     */     
/* 222 */     return Long.parseLong(freeSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static OsType getOSType() {
/* 231 */     if (OS_NAME.startsWith("WINDOWS")) {
/* 232 */       if (OS_NAME.endsWith("7") || OS_NAME.endsWith("XP") || OS_NAME.endsWith("8") || OS_NAME.endsWith("2000") || OS_NAME.endsWith("NT")) {
/* 233 */         return OsType.OS_NT;
/*     */       }
/* 235 */       return OsType.OS_9X;
/*     */     } 
/* 237 */     if (OS_NAME.indexOf("LINUX") > 0)
/* 238 */       return OsType.OS_LINUX; 
/* 239 */     if (OS_NAME.indexOf("UX") > 0) {
/* 240 */       return OsType.OS_UNIX;
/*     */     }
/* 242 */     return OsType.OS_UNKNOWN;
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
/* 254 */     Thread[] threads = new Thread[Thread.activeCount()];
/*     */     
/* 256 */     int n = Thread.enumerate(threads);
/* 257 */     for (int i = 0; i < n; i++) {
/* 258 */       String tName = threads[i].getName();
/* 259 */       if (tName.startsWith(threadNamePrefix) && 
/* 260 */         !threads[i].isInterrupted()) {
/* 261 */         threads[i].interrupt();
/* 262 */         System.out.println(String.valueOf(tName) + ">>>>>>>>>>>>已销毁...");
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
/* 277 */       Runtime.getRuntime().exec(fileName);
/* 278 */     } catch (Exception e) {
/* 279 */       return false;
/*     */     } 
/* 281 */     return true;
/*     */   }
/*     */   
/*     */   public static void waitMills(int mills) {
/*     */     try {
/* 286 */       Thread.sleep(mills);
/* 287 */     } catch (InterruptedException e) {
/* 288 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void waitSeconds(int second) {
/* 293 */     waitMills(second * 1000);
/*     */   }
/*     */   
/*     */   public static void open() {
/* 297 */     OsType os = getOSType();
/* 298 */     if (os != OsType.OS_NT && os != OsType.OS_9X) {
/* 299 */       RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
/* 300 */       String name = runtime.getName();
/* 301 */       int pid = Integer.parseInt(name.substring(0, name.indexOf('@')));
/* 302 */       File PID = new File(String.valueOf(System.getProperty("user.dir")) + File.separatorChar + "game.pid");
/* 303 */       if (PID.exists()) {
/* 304 */         System.err.println("This Game is Running? Please stop game or remove game.pid!");
/* 305 */         System.exit(1);
/*     */       } else {
/*     */         try {
/* 308 */           PrintWriter output = new PrintWriter(new FileWriter(PID));
/* 309 */           output.write(String.valueOf(pid));
/* 310 */           output.close();
/* 311 */         } catch (IOException e) {
/* 312 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 315 */       PID.deleteOnExit();
/*     */     } 
/*     */ 
/*     */     
/* 319 */     Out.setting();
/* 320 */     LangService.init();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getUsedMemoryMB() {
/* 326 */     return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L;
/*     */   }
/*     */   
/*     */   public static long getFreeMemoryMB() {
/* 330 */     return (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + 
/* 331 */       Runtime.getRuntime().freeMemory()) / 1048576L;
/*     */   }
/*     */   
/*     */   public static long getMaxMemoryMB() {
/* 335 */     return Runtime.getRuntime().maxMemory() / 1048576L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free() {
/* 341 */     long freeMem = getFreeMemoryMB();
/*     */     
/* 343 */     long totalMem = getMaxMemoryMB();
/* 344 */     Out.red(new Object[] { "\n回收前空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M" });
/*     */ 
/*     */ 
/*     */     
/* 348 */     System.gc();
/*     */ 
/*     */ 
/*     */     
/* 352 */     freeMem = getFreeMemoryMB();
/*     */     
/* 354 */     totalMem = getMaxMemoryMB();
/* 355 */     Out.red(new Object[] { "回收后空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M\n" });
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-login\xmds-login.jar!\com\wanniu\core\GSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */