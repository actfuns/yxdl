/*     */ package com.wanniu.core.db.pool;
/*     */ 
/*     */ import com.wanniu.core.GSystem;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLFeatureNotSupportedException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DBSource
/*     */   implements DataSource
/*     */ {
/*     */   private final DBAttribute dbAttribute;
/*  32 */   private List<DBConn> pool = new ArrayList<>();
/*     */   
/*  34 */   public final Map<String, String> sqls = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ScheduledFuture<?> timer;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DBSource(DBAttribute dbAttribute) throws SQLException {
/*  45 */     this.dbAttribute = dbAttribute;
/*  46 */     initPool();
/*  47 */     if (dbAttribute.isCheckAble()) {
/*  48 */       this.timer = GSystem.addFixedRateJob(new Runnable()
/*     */           {
/*     */             public void run() {
/*  51 */               DBSource.this.check();
/*     */             }
/*  53 */           },  dbAttribute.getCheckInterval(), dbAttribute.getCheckInterval());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void check() {
/*  62 */     synchronized (this.pool) {
/*  63 */       Iterator<DBConn> it = this.pool.iterator();
/*  64 */       while (it.hasNext()) {
/*  65 */         DBConn con = it.next();
/*     */         
/*  67 */         if (System.currentTimeMillis() - con.lastAccessTime > this.dbAttribute.getTimeout()) {
/*  68 */           if (this.pool.size() <= this.dbAttribute.getMinConnection())
/*     */             break; 
/*  70 */           if (con.isUse && this.pool.size() <= this.dbAttribute.getMaxConnection() / 2)
/*     */             continue; 
/*     */           try {
/*  73 */             con.internalClose();
/*  74 */             if (con.isUse) {
/*  75 */               Out.warn(new Object[] { "强制关闭未正常关闭数据库连接：", con.getSQL() });
/*     */             }
/*  77 */           } catch (SQLException e) {
/*  78 */             e.printStackTrace();
/*     */           } 
/*  80 */           it.remove();
/*     */         } 
/*     */       } 
/*  83 */       ping();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ping() {
/*  88 */     for (DBConn _conn : this.pool) {
/*  89 */       if (!_conn.isUse && System.currentTimeMillis() - _conn.lastAccessTime >= this.dbAttribute.getCheckInterval()) {
/*  90 */         PreparedStatement stmt = null;
/*  91 */         ResultSet rs = null;
/*  92 */         _conn.isUse = true;
/*     */         try {
/*  94 */           stmt = _conn.prepareStatement("SELECT CURRENT_DATE");
/*  95 */           rs = stmt.executeQuery();
/*  96 */         } catch (SQLException e) {
/*  97 */           e.printStackTrace();
/*     */         } finally {
/*  99 */           if (rs != null) {
/*     */             try {
/* 101 */               rs.close();
/* 102 */             } catch (SQLException e) {
/* 103 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 106 */           if (stmt != null) {
/*     */             try {
/* 108 */               stmt.close();
/* 109 */             } catch (SQLException e) {
/* 110 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 113 */           _conn.isUse = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Connection getConnection(String user, String password) throws SQLException {
/* 121 */     Connection conn = getFreeConnection(0L);
/* 122 */     if (conn == null)
/*     */     {
/*     */       
/* 125 */       if (getConnectionCount() >= this.dbAttribute.getMaxConnection()) {
/* 126 */         conn = getFreeConnection(this.dbAttribute.getWaitTime());
/*     */       } else {
/*     */         
/* 129 */         conn = createConnection(this.dbAttribute, true);
/*     */       } 
/*     */     }
/* 132 */     return conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getConnectionCount() {
/* 141 */     return this.pool.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initPool() throws SQLException {
/*     */     try {
/* 151 */       Class.forName(this.dbAttribute.getDriver());
/* 152 */     } catch (ClassNotFoundException e1) {
/* 153 */       e1.printStackTrace();
/*     */     } 
/* 155 */     for (int i = 0; i < this.dbAttribute.getMinConnection(); i++) {
/* 156 */       createConnection(this.dbAttribute, false);
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
/*     */   
/*     */   protected Connection createConnection(DBAttribute connParam, boolean inUse) throws SQLException {
/* 170 */     Connection conn = DriverManager.getConnection(connParam.getUrl(), connParam.getUserName(), connParam.getPassword());
/*     */     
/* 172 */     DBConn _conn = new DBConn(conn, inUse);
/* 173 */     synchronized (this.pool) {
/* 174 */       this.pool.add(_conn);
/*     */     } 
/* 176 */     return _conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 185 */     if (this.timer != null) {
/* 186 */       this.timer.cancel(true);
/*     */     }
/*     */     
/* 189 */     for (DBConn _conn : this.pool) {
/*     */       try {
/* 191 */         _conn.internalClose();
/* 192 */       } catch (Exception e) {
/* 193 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 197 */     this.pool.clear();
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
/*     */   protected Connection getFreeConnection(long waitTime) throws SQLException {
/* 209 */     Connection conn = null;
/* 210 */     for (DBConn _conn : this.pool) {
/* 211 */       if (!_conn.isUse) {
/* 212 */         _conn.isUse = true;
/* 213 */         _conn.lastAccessTime = System.currentTimeMillis();
/* 214 */         return _conn;
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     if (conn == null && waitTime > 0L) {
/*     */       
/* 220 */       if (waitTime > 1L) {
/* 221 */         check();
/* 222 */         Out.warn(new Object[] { "尝试进行一次可用连接检测..." });
/* 223 */         return getFreeConnection(1L);
/*     */       } 
/*     */       try {
/* 226 */         Out.error(new Object[] { "等待", Integer.valueOf(this.dbAttribute.getWaitTime()), "毫秒后尝试再获取可用连接..." });
/* 227 */         Thread.sleep(this.dbAttribute.getWaitTime());
/* 228 */       } catch (Exception exception) {}
/*     */       
/* 230 */       conn = getFreeConnection(0L);
/* 231 */       if (conn == null) {
/* 232 */         throw new SQLException("没有可用的数据库连接");
/*     */       }
/*     */     } 
/* 235 */     return conn;
/*     */   }
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 239 */     return getConnection(this.dbAttribute.getUserName(), this.dbAttribute.getPassword());
/*     */   }
/*     */   
/*     */   public PrintWriter getLogWriter() throws SQLException {
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter out) throws SQLException {}
/*     */ 
/*     */   
/*     */   public void setLoginTimeout(int seconds) throws SQLException {
/* 251 */     this.dbAttribute.setWaitTime(seconds);
/*     */   }
/*     */   
/*     */   public int getLoginTimeout() throws SQLException {
/* 255 */     return this.dbAttribute.getWaitTime();
/*     */   }
/*     */   
/*     */   public <T> T unwrap(Class<T> iface) throws SQLException {
/* 259 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isWrapperFor(Class<?> iface) throws SQLException {
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public Logger getParentLogger() throws SQLFeatureNotSupportedException {
/* 267 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\pool\DBSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */