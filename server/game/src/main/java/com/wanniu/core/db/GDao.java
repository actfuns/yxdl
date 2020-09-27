package com.wanniu.core.db;

import com.wanniu.core.GConfig;
import com.wanniu.core.db.handler.DBHandler;
import com.wanniu.core.db.pool.DBFactory;
import com.wanniu.core.logfs.Out;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public final class GDao
        implements Runnable {
    private static final int __QUEUE_SIZE__ = GConfig.getInstance().getInt("db.queue.size", 10000);
    private static final int __WARN_COUNT__ = __QUEUE_SIZE__ * 2 / 3;


    private static final BlockingQueue<DBHandler> __QUEUE__ = new LinkedBlockingQueue<>(__QUEUE_SIZE__);

    private static final boolean __MONITOR_ENABLE__ = GConfig.getInstance().getBoolean("db.monitor.enable", true);
    private static final int __MONITOR_OPTIME__ = GConfig.getInstance().getInt("db.monitor.optime", 111);


    private static final String __DS_NAME__ = GConfig.getInstance().get("db.dsname", "master");

    private static final String __DS_MASTER__ = GConfig.getInstance().get("db.ds.master", __DS_NAME__);

    private static final String __DS_SLAVE__ = GConfig.getInstance().get("db.ds.slave", __DS_NAME__);


    private static boolean __STARTED__;


    public static synchronized void start() {
        if (!__STARTED__) {
            __STARTED__ = true;
            int dbThreadCount = GConfig.getInstance().getInt("db.thread.count", 0);
            if (dbThreadCount > 0) {
                DBFactory.init();
                for (int i = 0; i < dbThreadCount; i++) {
                    (new Thread(new GDao(), "DB处理器" + dbThreadCount)).start();
                    dbThreadCount--;
                }
                Out.info(new Object[]{"数据库服务已启动 !"});
            } else {
                Out.info(new Object[]{"未集成数据库服务!!!"});
            }
        }
    }


    public static void put(DBHandler handler) {
        if (__QUEUE__.offer(handler)) {
            if (__QUEUE__.size() > __WARN_COUNT__) {
                Out.warn(new Object[]{"待处理数据库操作队列太长(1)：", Integer.valueOf(__QUEUE__.size())});
            }
        } else {
            Out.warn(new Object[]{"待处理数据库操作队列太长(2)", Integer.valueOf(__QUEUE__.size())});
        }
    }


    public static void add(DBHandler handler) {
        if (__QUEUE__.offer(handler)) {
            if (__QUEUE__.size() > __WARN_COUNT__) {
                Out.warn(new Object[]{"待处理数据库操作队列太长(1)：", Integer.valueOf(__QUEUE__.size())});
            }
        } else {
            __CARE__(handler);
        }
    }

    private static Thread __thread__ = null;
    private static LinkedList<DBHandler> __waits__ = new LinkedList<>();

    private static synchronized void __CARE__(DBHandler handler) {
        __waits__.add(handler);
        if (__thread__ == null) {
            __thread__ = new Thread(new Runnable() {
                public void run() {
                    DBHandler db = null;
                    while (true) {
                        db = GDao.__waits__.poll();
                        if (db == null) {
                            break;
                        }
                        db.run();
                    }
                    GDao.__thread__ = null;
                }
            });
            __thread__.start();
            Out.warn(new Object[]{String.format("启动数据保护线程：%d - %d", new Object[]{Integer.valueOf(__QUEUE__.size()), Integer.valueOf(__waits__.size())})});
        }
    }

    public void run() {
        DBHandler handler = null;
        long starTime = 0L;
        while (true) {
            try {
                handler = __QUEUE__.take();
                if (__MONITOR_ENABLE__) {
                    starTime = System.currentTimeMillis();
                    handler.run();
                    if (System.currentTimeMillis() - starTime > __MONITOR_OPTIME__)
                        Out.error(new Object[]{String.format("数据库操作耗时过长(ms)：%s -- %s", new Object[]{Long.valueOf(System.currentTimeMillis() - starTime), handler.getClass().getName()})});
                    continue;
                }
                handler.run();
            } catch (Exception e) {
                Out.error(new Object[]{e});
            }
        }
    }


    public static Connection getConn() {
        return getConnection(__DS_NAME__);
    }


    public static Connection getMaster() {
        return getConnection(__DS_MASTER__);
    }


    public static Connection getSlave() {
        return getConnection(__DS_SLAVE__);
    }


    public static Connection getConnection(String dsName) {
        Connection con = null;
        try {
            con = DBFactory.lookup(dsName).getConnection();
        } catch (SQLException e) {
            Out.error(new Object[]{"GDao getConnection", e});
        }
        return con;
    }

    public static int size() {
        return __QUEUE__.size() + __waits__.size();
    }
}


