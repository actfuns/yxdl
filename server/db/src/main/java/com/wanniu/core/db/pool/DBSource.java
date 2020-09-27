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
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*  34 */   private List<DBConn> pool = new ArrayList<>();
/*     */   
/*  36 */   public final Map<String, String> sqls = new HashMap<>();
/*     */   
/*  38 */   public final Set<String> tables = new HashSet<>();
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
/*  49 */     this.dbAttribute = dbAttribute;
/*  50 */     initPool();
/*  51 */     if (dbAttribute.isCheckAble()) {
/*  52 */       this.timer = GSystem.addFixedRateJob(new Runnable()
/*     */           {
/*     */             public void run() {
/*  55 */               DBSource.this.check();
/*     */             }
/*  57 */           },  dbAttribute.getCheckInterval(), dbAttribute.getCheckInterval());
/*     */     }
/*  59 */     Connection conn = null;
/*  60 */     PreparedStatement pstms = null;
/*  61 */     ResultSet rs = null;
/*     */     try {
/*  63 */       conn = getConnection();
/*  64 */       pstms = conn.prepareStatement("SHOW tables");
/*  65 */       rs = pstms.executeQuery();
/*  66 */       while (rs.next()) {
/*  67 */         this.tables.add(rs.getString(1));
/*     */       }
/*  69 */     } catch (Exception e) {
/*  70 */       Out.error(new Object[] { e });
/*     */     } finally {
/*  72 */       if (rs != null) {
/*  73 */         rs.close();
/*     */       }
/*  75 */       if (pstms != null) {
/*  76 */         pstms.close();
/*     */       }
/*  78 */       if (conn != null) {
/*  79 */         conn.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void check() {
/*  89 */     synchronized (this.pool) {
/*  90 */       Iterator<DBConn> it = this.pool.iterator();
/*  91 */       while (it.hasNext()) {
/*  92 */         DBConn con = it.next();
/*     */         
/*  94 */         if (System.currentTimeMillis() - con.lastAccessTime > this.dbAttribute.getTimeout()) {
/*  95 */           if (this.pool.size() <= this.dbAttribute.getMinConnection())
/*     */             break; 
/*  97 */           if (con.isUse && this.pool.size() <= this.dbAttribute.getMaxConnection() / 2)
/*     */             continue; 
/*     */           try {
/* 100 */             con.internalClose();
/* 101 */             if (con.isUse) {
/* 102 */               Out.warn(new Object[] { "强制关闭未正常关闭数据库连接：" + con.getSQL() });
/*     */             }
/* 104 */           } catch (SQLException e) {
/* 105 */             e.printStackTrace();
/*     */           } 
/* 107 */           it.remove();
/*     */         } 
/*     */       } 
/* 110 */       ping();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ping() {
/* 115 */     for (DBConn _conn : this.pool) {
/* 116 */       if (!_conn.isUse && System.currentTimeMillis() - _conn.lastAccessTime >= this.dbAttribute.getCheckInterval()) {
/* 117 */         PreparedStatement stmt = null;
/* 118 */         ResultSet rs = null;
/* 119 */         _conn.isUse = true;
/*     */         try {
/* 121 */           stmt = _conn.prepareStatement("SELECT CURRENT_DATE");
/* 122 */           rs = stmt.executeQuery();
/* 123 */         } catch (SQLException e) {
/* 124 */           e.printStackTrace(); continue;
/*     */         } finally {
/* 126 */           if (rs != null) {
/*     */             try {
/* 128 */               rs.close();
/* 129 */             } catch (SQLException e) {
/* 130 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 133 */           if (stmt != null) {
/*     */             try {
/* 135 */               stmt.close();
/* 136 */             } catch (SQLException e) {
/* 137 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 140 */           _conn.isUse = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized Connection getConnection(String user, String password) throws SQLException {
/* 148 */     Connection conn = getFreeConnection(0L);
/* 149 */     if (conn == null)
/*     */     {
/*     */       
/* 152 */       if (getConnectionCount() >= this.dbAttribute.getMaxConnection()) {
/* 153 */         conn = getFreeConnection(this.dbAttribute.getWaitTime());
/*     */       } else {
/*     */         
/* 156 */         conn = createConnection(this.dbAttribute, true);
/*     */       } 
/*     */     }
/* 159 */     return conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getConnectionCount() {
/* 168 */     return this.pool.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initPool() throws SQLException {
/*     */     try {
/* 178 */       Class.forName(this.dbAttribute.getDriver());
/* 179 */     } catch (ClassNotFoundException e1) {
/* 180 */       e1.printStackTrace();
/*     */     } 
/* 182 */     for (int i = 0; i < this.dbAttribute.getMinConnection(); i++) {
/* 183 */       createConnection(this.dbAttribute, false);
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
/* 197 */     Connection conn = DriverManager.getConnection(connParam.getUrl(), connParam.getUserName(), connParam.getPassword());
/*     */     
/* 199 */     DBConn _conn = new DBConn(conn, inUse);
/* 200 */     synchronized (this.pool) {
/* 201 */       this.pool.add(_conn);
/*     */     } 
/* 203 */     return _conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 212 */     if (this.timer != null) {
/* 213 */       this.timer.cancel(true);
/*     */     }
/*     */     
/* 216 */     for (DBConn _conn : this.pool) {
/*     */       try {
/* 218 */         _conn.internalClose();
/* 219 */       } catch (Exception e) {
/* 220 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     this.pool.clear();
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
/* 236 */     Connection conn = null;
/* 237 */     for (DBConn _conn : this.pool) {
/* 238 */       if (!_conn.isUse) {
/* 239 */         _conn.isUse = true;
/* 240 */         _conn.lastAccessTime = System.currentTimeMillis();
/* 241 */         return _conn;
/*     */       } 
/*     */     } 
/*     */     
/* 245 */     if (conn == null && waitTime > 0L) {
/*     */       
/* 247 */       if (waitTime > 1L) {
/* 248 */         check();
/* 249 */         Out.warn(new Object[] { "尝试进行一次可用连接检测..." });
/* 250 */         return getFreeConnection(1L);
/*     */       } 
/*     */       try {
/* 253 */         Out.error(new Object[] { "等待" + this.dbAttribute.getWaitTime() + "毫秒后尝试再获取可用连接..." });
/* 254 */         Thread.sleep(this.dbAttribute.getWaitTime());
/* 255 */       } catch (Exception exception) {}
/*     */       
/* 257 */       conn = getFreeConnection(0L);
/* 258 */       if (conn == null) {
/* 259 */         throw new SQLException("没有可用的数据库连接");
/*     */       }
/*     */     } 
/* 262 */     return conn;
/*     */   }
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 266 */     return getConnection(this.dbAttribute.getUserName(), this.dbAttribute.getPassword());
/*     */   }
/*     */   
/*     */   public PrintWriter getLogWriter() throws SQLException {
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter out) throws SQLException {}
/*     */ 
/*     */   
/*     */   public void setLoginTimeout(int seconds) throws SQLException {
/* 278 */     this.dbAttribute.setWaitTime(seconds);
/*     */   }
/*     */   
/*     */   public int getLoginTimeout() throws SQLException {
/* 282 */     return this.dbAttribute.getWaitTime();
/*     */   }
/*     */   
/*     */   public <T> T unwrap(Class<T> iface) throws SQLException {
/* 286 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isWrapperFor(Class<?> iface) throws SQLException {
/* 290 */     return false;
/*     */   }
/*     */   
/*     */   public Logger getParentLogger() throws SQLFeatureNotSupportedException {
/* 294 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\db\pool\DBSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */