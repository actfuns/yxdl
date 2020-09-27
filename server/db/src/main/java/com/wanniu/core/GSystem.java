package com.wanniu.core;

import com.wanniu.core.db.PoolFactory;
import com.wanniu.core.logfs.Out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;


public final class GSystem {
    private static ScheduledExecutorService __EXECUTOR__ = Executors.newSingleThreadScheduledExecutor((ThreadFactory) new PoolFactory("系统维护", true));


    public static ScheduledFuture<?> addFixedRateJob(Runnable runnable, long initialDelay, long period) {
        try {
            return __EXECUTOR__.scheduleAtFixedRate(runnable, Math.max(1L, initialDelay), period, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Out.error(new Object[]{e});

            return null;
        }
    }

    public static ScheduledFuture<?> addScheduleJob(Runnable runnable, long initialDelay, long delay, TimeUnit unit) {
        try {
            return __EXECUTOR__.scheduleWithFixedDelay(runnable, Math.max(1L, initialDelay), delay, unit);
        } catch (Exception e) {
            Out.error(new Object[]{e});

            return null;
        }
    }

    public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay, TimeUnit unit) {
        return __EXECUTOR__.schedule(runnable, delay, unit);
    }

    public static ScheduledFuture<?> addDelayJob(Runnable runnable, long delay) {
        return __EXECUTOR__.schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }


    public enum OsType {
        OS_UNKNOWN, OS_NT, OS_9X, OS_LINUX, OS_UNIX;
    }


    public static final String CRLF = System.getProperty("line.separator");


    public static final String OS_NAME = System.getProperty("os.name").toUpperCase();


    public static String execCmd(String[] execCmds) {
        int ret = 0;
        Process porc = null;
        InputStream perr = null, pin = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        BufferedReader br = null;

        try {
            porc = Runtime.getRuntime().exec(execCmds, (String[]) null, (File) null);
            perr = porc.getErrorStream();
            pin = porc.getInputStream();

            br = new BufferedReader(new InputStreamReader(pin));
            while ((line = br.readLine()) != null) {
                sb.append(line).append(CRLF);
            }

            br = new BufferedReader(new InputStreamReader(perr));
            while ((line = br.readLine()) != null) {
                System.err.println("exec()E: " + line);
            }
            porc.waitFor();
            ret = porc.exitValue();
            if (ret != 0) {
                System.err.println("porc.exitValue() = " + ret);
            }

            return sb.toString();
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            porc.destroy();
        }
        return "";
    }


    public static long getFreeDiskSize(String dir) {
        String[] cmds = null;
        long freeSize = -1L;
        OsType osType = getOSType();
        switch (osType) {
            case OS_NT:
                cmds = new String[]{"cmd.exe", "/c", "dir", dir};
                freeSize = parseWindowsFreeSize(execCmd(cmds));
                break;
            case null:
                cmds = new String[]{"command.exe", "/c", "dir", dir};
                freeSize = parseWindowsFreeSize(execCmd(cmds));
                break;
            case OS_LINUX:
            case OS_UNIX:
                cmds = new String[]{"df", dir};
                freeSize = parseUnixFreeSize(execCmd(cmds));
                break;
        }

        return freeSize;
    }


    public static String getLastLine(String txt) {
        StringBuilder builder = new StringBuilder(txt);
        if (builder.length() > CRLF.length() * 2) {

            builder.delete(builder.lastIndexOf(CRLF), builder.length());
            return builder.substring(builder.lastIndexOf(CRLF) + CRLF.length(), builder.length());
        }
        return "";
    }


    private static List<String> split(String msg) {
        String[] splited = msg.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < splited.length; i++) {
            if (splited[i] != null) {
                splited[i] = splited[i].trim();
                if (splited[i].length() > 0) {
                    list.add(splited[i]);
                }
            }
        }

        return list;
    }


    private static long parseUnixFreeSize(String cmdReturnContent) {
        String lastLine = getLastLine(cmdReturnContent);
        List<String> elements = split(lastLine);
        if (elements.size() < 6) {
            return -1L;
        }
        System.out.println("os_freesize_unix() 目录:\t" + (String) elements.get(0));
        System.out.println("os_freesize_unix() 总共:\t" + (String) elements.get(1));
        System.out.println("os_freesize_unix() 已用:\t" + (String) elements.get(2));
        System.out.println("os_freesize_unix() 可用:\t" + (String) elements.get(3));
        System.out.println("os_freesize_unix() 可用%:\t" + (String) elements.get(4));
        System.out.println("os_freesize_unix() 挂接:\t" + (String) elements.get(5));

        return Long.parseLong(elements.get(3)) * 1024L;
    }


    private static long parseWindowsFreeSize(String cmdReturnContent) {
        String lastLine = getLastLine(cmdReturnContent);
        List<String> elements = split(lastLine);
        if (elements.size() < 4) {
            return -1L;
        }

        String freeSize = ((String) elements.get(2)).replaceAll(",", "");

        return Long.parseLong(freeSize);
    }


    public static OsType getOSType() {
        if (OS_NAME.startsWith("WINDOWS")) {
            if (OS_NAME.endsWith("7") || OS_NAME.endsWith("XP") || OS_NAME.endsWith("8") || OS_NAME.endsWith("2000") || OS_NAME.endsWith("NT")) {
                return OsType.OS_NT;
            }
            return OsType.OS_9X;
        }
        if (OS_NAME.indexOf("LINUX") > 0)
            return OsType.OS_LINUX;
        if (OS_NAME.indexOf("UX") > 0) {
            return OsType.OS_UNIX;
        }
        return OsType.OS_UNKNOWN;
    }


    public static void destoryThread(String threadNamePrefix) {
        Thread[] threads = new Thread[Thread.activeCount()];

        int n = Thread.enumerate(threads);
        for (int i = 0; i < n; i++) {
            String tName = threads[i].getName();
            if (tName.startsWith(threadNamePrefix) &&
                    !threads[i].isInterrupted()) {
                threads[i].interrupt();
                System.out.println(String.valueOf(tName) + ">>>>>>>>>>>>已销毁...");
            }
        }
    }


    public static boolean execScriptFile(String fileName) {
        try {
            Runtime.getRuntime().exec(fileName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void waitMills(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            Out.error(new Object[]{e});
        }
    }

    public static void waitSeconds(int second) {
        waitMills(second * 1000);
    }

    public static void open(boolean isOnlyConfigLog4j) {
        OsType os = getOSType();
        if (os != OsType.OS_NT && os != OsType.OS_9X) {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            String name = runtime.getName();
            int pid = Integer.parseInt(name.substring(0, name.indexOf('@')));
            File PID = new File(String.valueOf(System.getProperty("user.dir")) + File.separatorChar + "game.pid");
            if (PID.exists()) {
                System.err.println("This Game is Running? Please stop game or remove game.pid!");
                System.exit(1);
            } else {
                try {
                    PrintWriter output = new PrintWriter(new FileWriter(PID));
                    output.write(String.valueOf(pid));
                    output.close();
                } catch (IOException e) {
                    Out.error(new Object[]{e});
                }
            }
            PID.deleteOnExit();
        }


        Out.setting();
        File log4j = new File(String.valueOf(GGlobal.DIR_CONF_SERVER) + "log4j.xml");
        if (log4j.exists()) {
            DOMConfigurator.configure(log4j.getAbsolutePath());
        }
    }


    public static long getUsedMemoryMB() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L;
    }

    public static long getFreeMemoryMB() {
        return (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() +
                Runtime.getRuntime().freeMemory()) / 1048576L;
    }

    public static long getMaxMemoryMB() {
        return Runtime.getRuntime().maxMemory() / 1048576L;
    }


    public static void free() {
        long freeMem = getFreeMemoryMB();

        long totalMem = getMaxMemoryMB();
        Out.red(new Object[]{"\n回收前空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M"});


        System.gc();


        freeMem = getFreeMemoryMB();

        totalMem = getMaxMemoryMB();
        Out.red(new Object[]{"回收后空闲内存 ", Long.valueOf(freeMem), " M / ", Long.valueOf(totalMem), " M\n"});
    }
}


