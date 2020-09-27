/*     */ package com.wanniu.core.db.pool;
/*     */ 
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.NClob;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLClientInfoException;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.SQLXML;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Struct;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.concurrent.Executor;
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
/*     */ 
/*     */ final class DBConn
/*     */   implements Connection
/*     */ {
/*     */   private String currSql;
/*  37 */   private Connection conn = null;
/*     */ 
/*     */   
/*     */   public boolean isUse = false;
/*     */ 
/*     */   
/*     */   public long lastAccessTime;
/*     */ 
/*     */ 
/*     */   
/*     */   DBConn(Connection conn, boolean isUse) {
/*  48 */     this.conn = conn;
/*  49 */     this.isUse = isUse;
/*  50 */     this.lastAccessTime = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public String getSQL() {
/*  54 */     return this.currSql;
/*     */   }
/*     */   
/*     */   public void setSQL(String sql) {
/*  58 */     this.currSql = sql;
/*  59 */     this.lastAccessTime = System.currentTimeMillis();
/*  60 */     Out.debug(new Object[] { sql });
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> iface) throws SQLException {
/*  65 */     return this.conn.unwrap(iface);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> iface) throws SQLException {
/*  70 */     return this.conn.isWrapperFor(iface);
/*     */   }
/*     */ 
/*     */   
/*     */   public Statement createStatement() throws SQLException {
/*  75 */     return this.conn.createStatement();
/*     */   }
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql) throws SQLException {
/*  80 */     setSQL(sql);
/*  81 */     return this.conn.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql) throws SQLException {
/*  86 */     setSQL(sql);
/*  87 */     return this.conn.prepareCall(sql);
/*     */   }
/*     */ 
/*     */   
/*     */   public String nativeSQL(String sql) throws SQLException {
/*  92 */     setSQL(sql);
/*  93 */     return this.conn.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean autoCommit) throws SQLException {
/*  98 */     this.conn.setAutoCommit(autoCommit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAutoCommit() throws SQLException {
/* 104 */     return this.conn.getAutoCommit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() throws SQLException {
/* 110 */     this.conn.commit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback() throws SQLException {
/* 116 */     this.conn.rollback();
/*     */   }
/*     */   
/*     */   void internalClose() throws SQLException {
/* 120 */     this.conn.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/* 126 */     this.isUse = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() throws SQLException {
/* 132 */     return this.conn.isClosed();
/*     */   }
/*     */ 
/*     */   
/*     */   public DatabaseMetaData getMetaData() throws SQLException {
/* 137 */     return this.conn.getMetaData();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean readOnly) throws SQLException {
/* 142 */     this.conn.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() throws SQLException {
/* 147 */     return this.conn.isReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCatalog(String catalog) throws SQLException {
/* 152 */     this.conn.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCatalog() throws SQLException {
/* 157 */     return this.conn.getCatalog();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransactionIsolation(int level) throws SQLException {
/* 162 */     this.conn.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTransactionIsolation() throws SQLException {
/* 167 */     return this.conn.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 172 */     return this.conn.getWarnings();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearWarnings() throws SQLException {
/* 177 */     this.conn.clearWarnings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
/* 183 */     return this.conn.createStatement(resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 189 */     setSQL(sql);
/* 190 */     return this.conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 196 */     setSQL(sql);
/* 197 */     return this.conn.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Class<?>> getTypeMap() throws SQLException {
/* 202 */     return this.conn.getTypeMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
/* 207 */     this.conn.setTypeMap(map);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHoldability(int holdability) throws SQLException {
/* 212 */     this.conn.setHoldability(holdability);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHoldability() throws SQLException {
/* 217 */     return this.conn.getHoldability();
/*     */   }
/*     */ 
/*     */   
/*     */   public Savepoint setSavepoint() throws SQLException {
/* 222 */     return this.conn.setSavepoint();
/*     */   }
/*     */ 
/*     */   
/*     */   public Savepoint setSavepoint(String name) throws SQLException {
/* 227 */     return this.conn.setSavepoint(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollback(Savepoint savepoint) throws SQLException {
/* 232 */     this.conn.rollback(savepoint);
/*     */   }
/*     */ 
/*     */   
/*     */   public void releaseSavepoint(Savepoint savepoint) throws SQLException {
/* 237 */     this.conn.releaseSavepoint(savepoint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 244 */     return this.conn.createStatement(resultSetType, resultSetConcurrency, 
/* 245 */         resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 252 */     setSQL(sql);
/* 253 */     return this.conn.prepareStatement(sql, resultSetType, resultSetConcurrency, 
/* 254 */         resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 261 */     setSQL(sql);
/* 262 */     return this.conn.prepareCall(sql, resultSetType, resultSetConcurrency, 
/* 263 */         resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
/* 269 */     setSQL(sql);
/* 270 */     return this.conn.prepareStatement(sql, autoGeneratedKeys);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
/* 276 */     setSQL(sql);
/* 277 */     return this.conn.prepareStatement(sql, columnIndexes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
/* 283 */     setSQL(sql);
/* 284 */     return this.conn.prepareStatement(sql, columnNames);
/*     */   }
/*     */ 
/*     */   
/*     */   public Clob createClob() throws SQLException {
/* 289 */     return this.conn.createClob();
/*     */   }
/*     */ 
/*     */   
/*     */   public Blob createBlob() throws SQLException {
/* 294 */     return this.conn.createBlob();
/*     */   }
/*     */ 
/*     */   
/*     */   public NClob createNClob() throws SQLException {
/* 299 */     return this.conn.createNClob();
/*     */   }
/*     */ 
/*     */   
/*     */   public SQLXML createSQLXML() throws SQLException {
/* 304 */     return this.conn.createSQLXML();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid(int timeout) throws SQLException {
/* 309 */     return this.conn.isValid(timeout);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClientInfo(String name, String value) throws SQLClientInfoException {
/* 315 */     this.conn.setClientInfo(name, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClientInfo(Properties properties) throws SQLClientInfoException {
/* 321 */     this.conn.setClientInfo(properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getClientInfo(String name) throws SQLException {
/* 326 */     return this.conn.getClientInfo(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public Properties getClientInfo() throws SQLException {
/* 331 */     return this.conn.getClientInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
/* 337 */     return createArrayOf(typeName, elements);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
/* 343 */     return this.conn.createStruct(typeName, attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchema(String schema) throws SQLException {}
/*     */ 
/*     */   
/*     */   public String getSchema() throws SQLException {
/* 352 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void abort(Executor executor) throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {}
/*     */ 
/*     */   
/*     */   public int getNetworkTimeout() throws SQLException {
/* 365 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\core\db\pool\DBConn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */