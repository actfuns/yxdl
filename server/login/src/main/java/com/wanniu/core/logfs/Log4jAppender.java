package com.wanniu.core.logfs;

import com.wanniu.core.util.DateUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.DailyRollingFileAppender;


public class Log4jAppender
        extends DailyRollingFileAppender {
    private String formatFileName;

    public synchronized void setFile(String fileName, boolean arg1, boolean arg2, int arg3) throws IOException {
        String dir = DateUtil.format(new Date(System.currentTimeMillis() + 3601000L), "yyyy-MM-dd");
        dir = String.valueOf(dir.substring(0, 7)) + File.separator + dir;
        fileName = String.format(this.formatFileName, new Object[]{dir});
        File log = new File(fileName);
        if (!log.exists()) {
            log.getParentFile().mkdirs();
        }
        super.setFile(fileName);
        super.setFile(fileName, arg1, arg2, arg3);
    }


    public void setFile(String fileName) {
        this.formatFileName = fileName;
        super.setFile(fileName);
    }
}


