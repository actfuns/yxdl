package com.wanniu.core.logfs;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGlobal;
import com.wanniu.core.GSystem;
import com.wanniu.core.util.DateUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public final class Out {
    private static class OutPrintStream
            extends PrintStream {
        private static final boolean CONSOLE = GConfig.getInstance().getBoolean("log.console", true);
        private static final SimpleDateFormat FORMAT_DAY = new SimpleDateFormat("yyyy-MM-dd");

        private PrintStream fps;
        private String fileName;
        private String filePath;
        private boolean newLog = true;

        private OutPrintStream(PrintStream print, String fs) {
            super(print);
            this.fileName = fs;
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            GSystem.addFixedRateJob(new Runnable() {
                public void run() {
                    Out.OutPrintStream.this.newLog = true;
                }
            }, calendar.getTimeInMillis() - System.currentTimeMillis(), 86400000L);
        }

        public void write(byte[] buf, int off, int len) {
            newLog();
            if (CONSOLE) {
                super.write(buf, off, len);
            }
            this.fps.write(buf, off, len);
        }

        public void flush() {
            if (CONSOLE) {
                super.flush();
            }
            this.fps.flush();
        }

        private String getFilePath() {
            String day = FORMAT_DAY.format(new Date());
            return GGlobal.DIR_LOG + File.separator +
                    day.substring(0, 7) + File.separator + day + File.separator +
                    this.fileName;
        }

        public void newLog() {
            if (this.newLog && !getFilePath().equals(this.filePath)) {
                try {
                    if (this.fps != null) {
                        this.fps.close();
                    }
                    this.newLog = false;
                    this.filePath = getFilePath();
                    File log = new File(this.filePath);
                    log.getParentFile().mkdirs();
                    this.fps = new PrintStream(new FileOutputStream(log, true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Level LEVEL = Level.INFO;
    private static boolean setting;

    public static void setting() {
        if (setting)
            return;
        setting = true;
        LEVEL = Level.valueOf(GConfig.getInstance().get("log.level", "INFO").toUpperCase());
        File dir = new File(GGlobal.DIR_LOG);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
        System.setOut(new OutPrintStream(System.out, "system.out.log", null));
        System.setErr(new OutPrintStream(System.err, "system.err.log", null));
    }

    public static boolean isEnable(Level level) {
        return (LEVEL.compareTo(level) <= 0);
    }

    public static boolean isEnableDebug() {
        return isEnable(Level.DEBUG);
    }

    public static boolean isEnableInfo() {
        return isEnable(Level.INFO);
    }

    private static String log(String type, Object... args) {
        StringBuilder builder = new StringBuilder();
        builder.append(DateUtil.getTime("yyyy-MM-dd HH:mm:ss.SSS")).append(" [").append(type)
                .append("] : ");
        byte b;
        int i;
        Object[] arrayOfObject;
        for (i = (arrayOfObject = args).length, b = 0; b < i; ) {
            Object object = arrayOfObject[b];
            if (object instanceof Throwable) {
                ((Throwable) object).printStackTrace();
                builder.append(((Throwable) object).getMessage());
            } else {
                builder.append(object);
            }
            b++;
        }

        return builder.toString();
    }

    public static void debug(Object... args) {
        if (isEnableDebug()) {
            System.out.println(log("DEBUG", args));
        }
    }

    public static void info(Object... args) {
        if (isEnableInfo()) {
            System.out.println(log("INFO", args));
        }
    }

    public static void warn(Object... args) {
        System.err.println(log("WARN", args));
    }

    public static void error(Object... args) {
        System.err.println(log("ERROR", args));
    }


    public static void red(Object... args) {
        System.err.println(log("RED", args));
    }
}


