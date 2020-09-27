package com.wanniu.core.logfs;

import com.wanniu.core.GConfig;
import com.wanniu.core.GGame;
import com.wanniu.core.GGlobal;
import com.wanniu.core.game.PoolFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public final class Out {
    private static final ExecutorService ANSYC_LOG_EXEC = Executors.newSingleThreadExecutor((ThreadFactory) new PoolFactory("ansyc-log"));

    private static final boolean CONSOLE = GConfig.getInstance().getBoolean("log.console", true);


    private static final DateTimeFormatter DEFAULT_DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static final DateTimeFormatter FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");


    private static final StringBuilder DEFUALT_LOG_BUILDER = new StringBuilder(512);
    private static Level LEVEL = Level.INFO;

    private static boolean setting;

    public static synchronized void setting() {
        if (setting) {
            return;
        }
        setting = true;
        LEVEL = Level.valueOf(GConfig.getInstance().get("log.level", "INFO").toUpperCase());
        File dir = new File(GGlobal.DIR_LOG);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
    }

    public static void setLevel(Level level) {
        LEVEL = level;
    }

    private static class Log implements Runnable {
        private final Level type;
        private final Object[] args;
        private final LocalDateTime date;
        private final String threadName;
        private String fileName;
        private int lineNumber;

        Log(Level type, Object... args) {
            this.args = args;
            this.type = type;
            this.date = LocalDateTime.now();

            Thread thread = Thread.currentThread();
            this.threadName = thread.getName();

            if (Out.LEVEL == Level.DEBUG) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[4];
                this.fileName = stackTraceElement.getFileName();
                this.lineNumber = stackTraceElement.getLineNumber();
            }
        }


        public void run() {
            try {
                String text = build(this.type, this.args);
                if (Out.CONSOLE) {
                    switch (this.type) {
                        case DEBUG:
                        case INFO:
                            System.out.print(text);
                            break;
                        default:
                            System.err.print(text);
                            break;
                    }
                }
                Out.writer(this.date, text);
            } catch (Exception e) {
                Out.error(new Object[]{"Out run", e});
            }
        }

        private String build(Level type, Object... args) {
            Out.DEFUALT_LOG_BUILDER.setLength(0);

            Out.DEFUALT_LOG_BUILDER.append(Out.DEFAULT_DATE_FORMATER.format(this.date));

            Out.DEFUALT_LOG_BUILDER.append(" [").append(this.threadName).append("] ").append(type);

            if (Out.LEVEL == Level.DEBUG) {
                Out.DEFUALT_LOG_BUILDER.append(" ").append(this.fileName).append(":").append(this.lineNumber);
            }
            Out.DEFUALT_LOG_BUILDER.append(" - ");

            for (Object object : args) {
                if (object instanceof Throwable) {
                    try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                        ((Throwable) object).printStackTrace(pw);
                        Out.DEFUALT_LOG_BUILDER.append("\n").append(sw.toString());
                    } catch (Exception e) {
                        Out.DEFUALT_LOG_BUILDER.append(object);
                    }
                } else {
                    Out.DEFUALT_LOG_BUILDER.append(object);
                }
            }
            Out.DEFUALT_LOG_BUILDER.append("\n");
            return Out.DEFUALT_LOG_BUILDER.toString();
        }
    }

    private static int lastWriterHour = -1;
    private static BufferedWriter fileWriter = null;


    private static void writer(LocalDateTime date, String x) throws IOException {
        if (fileWriter == null || date.getHour() != lastWriterHour) {


            if (fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }

            StringBuilder filename = new StringBuilder(128);
            filename.append(GGlobal.DIR_LOG).append(File.separator);
            filename.append(GGame.__SERVER_ID).append(File.separator);
            filename.append("game-").append(date.format(FILE_FORMATTER)).append(".log");
            File file = new File(filename.toString());
            if (!file.exists()) {
                File fileParent = file.getParentFile();
                if (!fileParent.exists()) {
                    fileParent.mkdirs();
                }
                file.createNewFile();
            }

            fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
        }

        fileWriter.write(x);
        fileWriter.flush();
    }

    private static void put(Level type, Object... args) {
        ANSYC_LOG_EXEC.execute(new Log(type, args));
    }

    public static boolean isEnable(Level level) {
        return (LEVEL.compareTo(level) <= 0);
    }

    public static boolean isEnableDebug() {
        return (LEVEL == Level.DEBUG);
    }

    public static boolean isEnableInfo() {
        return isEnable(Level.INFO);
    }

    public static void debug(Object... args) {
        if (isEnableDebug()) {
            put(Level.DEBUG, args);
        }
    }

    public static void info(Object... args) {
        if (isEnableInfo()) {
            put(Level.INFO, args);
        }
    }

    public static void warn(Object... args) {
        put(Level.WARN, args);
    }

    public static void error(Object... args) {
        put(Level.ERROR, args);
    }

    public static void shutdown() {
        ANSYC_LOG_EXEC.shutdown();
        if (fileWriter != null)
            try {
                fileWriter.close();
            } catch (IOException iOException) {
            }
    }
}


