package com.wanniu.db;

import com.wanniu.core.GConfig;
import com.wanniu.core.db.pool.DBFactory;
import com.wanniu.core.logfs.Out;
import com.wanniu.db.connet.DBServerBootstrap;


public class DBMain {
    public static void main(String[] args) {
        GConfig.getInstance().init(true);
        DBFactory.init();
        DBServerBootstrap.getInstance().start();
        (new Thread((Runnable) DBServer.Dispatcher, "业务分发")).start();
        Runtime.getRuntime().addShutdownHook(new Thread("关服程序") {
            public void run() {
                Out.info(


                        new Object[]{"正在进行安全停服中..."});
                DBServer.onProcessExit();
                Out.info(new Object[]{"服务器已安全停止，可以继续执行后续的工作了，O(∩_∩)O~"});
            }
        });
    }
}


