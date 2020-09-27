package com.wanniu.core.db.pool;

import com.wanniu.core.GSystem;
import com.wanniu.core.logfs.Out;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Logger;
import javax.sql.DataSource;


public final class DBSource
        implements DataSource {
    private final DBAttribute dbAttribute;
    private List<DBConn> pool = new ArrayList<>();

    public final Map<String, String> sqls = new HashMap<>();

    public final Set<String> tables = new HashSet<>();


    private ScheduledFuture<?> timer;


    public DBSource(DBAttribute dbAttribute) throws SQLException {
        this.dbAttribute = dbAttribute;
        initPool();
        if (dbAttribute.isCheckAble()) {
            this.timer = GSystem.addFixedRateJob(new Runnable() {
                public void run() {
                    DBSource.this.check();
                }
            }, dbAttribute.getCheckInterval(), dbAttribute.getCheckInterval());
        }
        Connection conn = null;
        PreparedStatement pstms = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstms = conn.prepareStatement("SHOW tables");
            rs = pstms.executeQuery();
            while (rs.next()) {
                this.tables.add(rs.getString(1));
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstms != null) {
                pstms.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }


    private void check() {
        synchronized (this.pool) {
            Iterator<DBConn> it = this.pool.iterator();
            while (it.hasNext()) {
                DBConn con = it.next();

                if (System.currentTimeMillis() - con.lastAccessTime > this.dbAttribute.getTimeout()) {
                    if (this.pool.size() <= this.dbAttribute.getMinConnection())
                        break;
                    if (con.isUse && this.pool.size() <= this.dbAttribute.getMaxConnection() / 2)
                        continue;
                    try {
                        con.internalClose();
                        if (con.isUse) {
                            Out.warn(new Object[]{"强制关闭未正常关闭数据库连接：" + con.getSQL()});
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    it.remove();
                }
            }
            ping();
        }
    }

    private void ping() {
        for (DBConn _conn : this.pool) {
            if (!_conn.isUse && System.currentTimeMillis() - _conn.lastAccessTime >= this.dbAttribute.getCheckInterval()) {
                PreparedStatement stmt = null;
                ResultSet rs = null;
                _conn.isUse = true;
                try {
                    stmt = _conn.prepareStatement("SELECT CURRENT_DATE");
                    rs = stmt.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                    continue;
                } finally {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    _conn.isUse = false;
                }
            }
        }
    }


    public synchronized Connection getConnection(String user, String password) throws SQLException {
        Connection conn = getFreeConnection(0L);
        if (conn == null) {

            if (getConnectionCount() >= this.dbAttribute.getMaxConnection()) {
                conn = getFreeConnection(this.dbAttribute.getWaitTime());
            } else {

                conn = createConnection(this.dbAttribute, true);
            }
        }
        return conn;
    }


    private int getConnectionCount() {
        return this.pool.size();
    }


    protected void initPool() throws SQLException {
        try {
            Class.forName(this.dbAttribute.getDriver());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i < this.dbAttribute.getMinConnection(); i++) {
            createConnection(this.dbAttribute, false);
        }
    }


    protected Connection createConnection(DBAttribute connParam, boolean inUse) throws SQLException {
        Connection conn = DriverManager.getConnection(connParam.getUrl(), connParam.getUserName(), connParam.getPassword());

        DBConn _conn = new DBConn(conn, inUse);
        synchronized (this.pool) {
            this.pool.add(_conn);
        }
        return _conn;
    }


    public void shutdown() {
        if (this.timer != null) {
            this.timer.cancel(true);
        }

        for (DBConn _conn : this.pool) {
            try {
                _conn.internalClose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.pool.clear();
    }


    protected Connection getFreeConnection(long waitTime) throws SQLException {
        Connection conn = null;
        for (DBConn _conn : this.pool) {
            if (!_conn.isUse) {
                _conn.isUse = true;
                _conn.lastAccessTime = System.currentTimeMillis();
                return _conn;
            }
        }

        if (conn == null && waitTime > 0L) {

            if (waitTime > 1L) {
                check();
                Out.warn(new Object[]{"尝试进行一次可用连接检测..."});
                return getFreeConnection(1L);
            }
            try {
                Out.error(new Object[]{"等待" + this.dbAttribute.getWaitTime() + "毫秒后尝试再获取可用连接..."});
                Thread.sleep(this.dbAttribute.getWaitTime());
            } catch (Exception exception) {
            }

            conn = getFreeConnection(0L);
            if (conn == null) {
                throw new SQLException("没有可用的数据库连接");
            }
        }
        return conn;
    }

    public Connection getConnection() throws SQLException {
        return getConnection(this.dbAttribute.getUserName(), this.dbAttribute.getPassword());
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }


    public void setLogWriter(PrintWriter out) throws SQLException {
    }


    public void setLoginTimeout(int seconds) throws SQLException {
        this.dbAttribute.setWaitTime(seconds);
    }

    public int getLoginTimeout() throws SQLException {
        return this.dbAttribute.getWaitTime();
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}


