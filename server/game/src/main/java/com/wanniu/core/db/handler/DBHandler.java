/*     */ package com.wanniu.core.db.handler;
/*     */ 
/*     */ import com.wanniu.core.db.GDao;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.Date;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DBHandler
/*     */   implements Runnable
/*     */ {
/*  26 */   private static Map<String, Boolean> TABLE_STATUS = new HashMap<>();
/*     */   
/*     */   private static ISQLExceptionHandler __exception__;
/*     */ 
/*     */   
/*     */   public static void free(ResultSet rs, PreparedStatement pstmt, Connection conn) {
/*  32 */     close(rs);
/*  33 */     close(pstmt);
/*  34 */     close(conn);
/*     */   }
/*     */   
/*     */   public static void free(ResultSet rs, CallableStatement cs, Connection conn) {
/*  38 */     close(rs);
/*  39 */     close(cs);
/*  40 */     close(conn);
/*     */   }
/*     */   
/*     */   protected static void close(ResultSet rs) {
/*  44 */     if (rs != null) {
/*     */       try {
/*  46 */         rs.close();
/*  47 */       } catch (Exception e) {
/*  48 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void close(PreparedStatement pstmt) {
/*  54 */     if (pstmt != null) {
/*     */       try {
/*  56 */         pstmt.close();
/*  57 */       } catch (Exception e) {
/*  58 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void close(CallableStatement cs) {
/*  64 */     if (cs != null) {
/*     */       try {
/*  66 */         cs.close();
/*  67 */       } catch (Exception e) {
/*  68 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void close(Connection conn) {
/*  74 */     if (conn != null) {
/*     */       try {
/*  76 */         conn.close();
/*  77 */       } catch (Exception e) {
/*  78 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean checkTable(String tableName) {
/*  84 */     Boolean exist = TABLE_STATUS.get(tableName);
/*  85 */     if (exist != null && exist.booleanValue()) {
/*  86 */       return true;
/*     */     }
/*  88 */     Connection conn = null;
/*  89 */     ResultSet rs = null;
/*     */     try {
/*  91 */       conn = GDao.getSlave();
/*  92 */       DatabaseMetaData metaData = conn.getMetaData();
/*  93 */       if (tableName.indexOf(".") > -1) {
/*  94 */         rs = metaData.getTables(tableName.substring(0, tableName.indexOf('.')), null, tableName
/*  95 */             .substring(tableName.indexOf('.')), null);
/*     */       } else {
/*  97 */         rs = metaData.getTables(null, null, tableName, null);
/*     */       } 
/*  99 */       if (rs.next()) {
/* 100 */         TABLE_STATUS.put(tableName, Boolean.valueOf(true));
/* 101 */         return true;
/*     */       } 
/* 103 */     } catch (SQLException e) {
/* 104 */       Out.info(new Object[] { e });
/*     */     } finally {
/* 106 */       free(rs, (CallableStatement)null, conn);
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public static void putTable(String tableName, boolean exist) {
/* 112 */     TABLE_STATUS.put(tableName, Boolean.valueOf(exist));
/*     */   }
/*     */   
/*     */   public static void createTable(String sql) {
/* 116 */     execute(sql);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setExceptionHandler(ISQLExceptionHandler exceptionHandler) {
/* 121 */     __exception__ = exceptionHandler;
/*     */   }
/*     */   
/*     */   public static void exceptionSQL(String logName, Exception e) {
/* 125 */     if (__exception__ != null) {
/* 126 */       __exception__.exceptionSQL(logName, e);
/*     */     } else {
/* 128 */       Out.error(new Object[] { logName, e });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void exceptionSQL(SQLException e) {
/* 133 */     if (__exception__ != null) {
/* 134 */       __exception__.exceptionSQL(e);
/*     */     } else {
/* 136 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int execute(String sql) {
/* 141 */     Connection conn = null;
/* 142 */     PreparedStatement pstmt = null;
/*     */     try {
/* 144 */       conn = GDao.getMaster();
/* 145 */       pstmt = conn.prepareStatement(sql);
/* 146 */       return pstmt.executeUpdate();
/* 147 */     } catch (SQLException e) {
/* 148 */       exceptionSQL(e);
/*     */     } finally {
/* 150 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/* 152 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int update(String sql, Object... args) {
/* 159 */     Connection conn = null;
/* 160 */     PreparedStatement pstmt = null;
/*     */     try {
/* 162 */       conn = GDao.getMaster();
/* 163 */       pstmt = conn.prepareStatement(sql);
/* 164 */       setParams(pstmt, args);
/* 165 */       return pstmt.executeUpdate();
/* 166 */     } catch (SQLException e) {
/* 167 */       exceptionSQL(e);
/*     */     } finally {
/* 169 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/* 171 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int update(String sql, ParamMapper param) {
/* 178 */     Connection conn = null;
/* 179 */     PreparedStatement pstmt = null;
/*     */     try {
/* 181 */       conn = GDao.getMaster();
/* 182 */       pstmt = conn.prepareStatement(sql);
/* 183 */       param.setParams(pstmt, 0);
/* 184 */       return pstmt.executeUpdate();
/* 185 */     } catch (SQLException e) {
/* 186 */       exceptionSQL(e);
/*     */     } finally {
/* 188 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/* 190 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int generated(String sql, Object... args) {
/* 197 */     Connection conn = null;
/* 198 */     PreparedStatement pstmt = null;
/* 199 */     ResultSet rs = null;
/*     */     try {
/* 201 */       conn = GDao.getMaster();
/* 202 */       pstmt = conn.prepareStatement(sql, 1);
/* 203 */       setParams(pstmt, args);
/* 204 */       if (pstmt.executeUpdate() > 0) {
/* 205 */         rs = pstmt.getGeneratedKeys();
/* 206 */         if (rs.next()) {
/* 207 */           return rs.getInt(1);
/*     */         }
/*     */       } 
/* 210 */     } catch (SQLException e) {
/* 211 */       exceptionSQL(e);
/*     */     } finally {
/* 213 */       free(rs, pstmt, conn);
/*     */     } 
/* 215 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int generated(String sql, ParamMapper param) {
/* 222 */     Connection conn = null;
/* 223 */     PreparedStatement pstmt = null;
/* 224 */     ResultSet rs = null;
/*     */     try {
/* 226 */       conn = GDao.getMaster();
/* 227 */       pstmt = conn.prepareStatement(sql, 1);
/* 228 */       param.setParams(pstmt, 0);
/* 229 */       if (pstmt.executeUpdate() > 0) {
/* 230 */         rs = pstmt.getGeneratedKeys();
/* 231 */         if (rs.next()) {
/* 232 */           return rs.getInt(1);
/*     */         }
/*     */       } 
/* 235 */     } catch (SQLException e) {
/* 236 */       exceptionSQL(e);
/*     */     } finally {
/* 238 */       free(rs, pstmt, conn);
/*     */     } 
/* 240 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int saveOrUpdate(ISaveOrUpdate iSaveOrUpdate) {
/* 248 */     Connection conn = null;
/* 249 */     PreparedStatement pstmt = null;
/*     */     try {
/* 251 */       conn = GDao.getMaster();
/* 252 */       pstmt = conn.prepareStatement(iSaveOrUpdate.getUpdateSQL());
/* 253 */       setParams(pstmt, iSaveOrUpdate.getUpdateParams());
/* 254 */       if (pstmt.executeUpdate() == 0) {
/* 255 */         close(pstmt);
/* 256 */         pstmt = conn.prepareStatement(iSaveOrUpdate.getSaveSQL());
/* 257 */         setParams(pstmt, iSaveOrUpdate.getSaveParams());
/* 258 */         return pstmt.executeUpdate();
/*     */       } 
/* 260 */     } catch (SQLException e) {
/* 261 */       exceptionSQL(e);
/*     */     } finally {
/* 263 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/* 265 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void batchUpdate(String sql, List<Object[]> batch) {
/* 272 */     Connection conn = null;
/* 273 */     PreparedStatement pstmt = null;
/*     */     try {
/* 275 */       conn = GDao.getMaster();
/* 276 */       pstmt = conn.prepareStatement(sql);
/* 277 */       for (Object[] par : batch) {
/* 278 */         setParams(pstmt, par);
/* 279 */         pstmt.addBatch();
/*     */       } 
/* 281 */       pstmt.executeBatch();
/* 282 */     } catch (SQLException e) {
/* 283 */       exceptionSQL(e);
/*     */     } finally {
/* 285 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void batchUpdate(String sql, ParamMapper mapper, int size) {
/* 293 */     Connection conn = null;
/* 294 */     PreparedStatement pstmt = null;
/*     */     try {
/* 296 */       conn = GDao.getMaster();
/* 297 */       pstmt = conn.prepareStatement(sql);
/* 298 */       for (int row = 0; row < size; row++) {
/* 299 */         mapper.setParams(pstmt, row);
/* 300 */         pstmt.addBatch();
/* 301 */         if (row % 500 == 0) {
/* 302 */           pstmt.executeBatch();
/* 303 */           pstmt.clearBatch();
/*     */         } 
/*     */       } 
/* 306 */       if (size % 500 != 0) {
/* 307 */         pstmt.executeBatch();
/* 308 */         pstmt.clearBatch();
/*     */       } 
/* 310 */     } catch (SQLException e) {
/* 311 */       exceptionSQL(e);
/*     */     } finally {
/* 313 */       free((ResultSet)null, pstmt, conn);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
/* 321 */     List<T> values = new ArrayList<>();
/* 322 */     Connection conn = null;
/* 323 */     PreparedStatement pstmt = null;
/* 324 */     ResultSet rs = null;
/*     */     try {
/* 326 */       conn = GDao.getMaster();
/* 327 */       pstmt = conn.prepareStatement(sql);
/* 328 */       setParams(pstmt, args);
/* 329 */       rs = pstmt.executeQuery();
/* 330 */       while (rs.next()) {
/* 331 */         values.add(rowMapper.mapRow(rs));
/*     */       }
/* 333 */     } catch (SQLException e) {
/* 334 */       exceptionSQL(e);
/*     */     } finally {
/* 336 */       free(rs, pstmt, conn);
/*     */     } 
/* 338 */     return values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> List<T> query(String sql, RowMapper<T> rowMapper) {
/* 346 */     List<T> values = new ArrayList<>();
/* 347 */     Connection conn = null;
/* 348 */     PreparedStatement pstmt = null;
/* 349 */     ResultSet rs = null;
/*     */     try {
/* 351 */       conn = GDao.getSlave();
/* 352 */       pstmt = conn.prepareStatement(sql);
/* 353 */       rowMapper.setParams(pstmt);
/* 354 */       rs = pstmt.executeQuery();
/* 355 */       while (rs.next()) {
/* 356 */         values.add(rowMapper.mapRow(rs));
/*     */       }
/* 358 */     } catch (SQLException e) {
/* 359 */       exceptionSQL(e);
/*     */     } finally {
/* 361 */       free(rs, pstmt, conn);
/*     */     } 
/* 363 */     return values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void query(String sql, RowReader rowReader, Object... args) {
/* 370 */     Connection conn = null;
/* 371 */     PreparedStatement pstmt = null;
/* 372 */     ResultSet rs = null;
/*     */     try {
/* 374 */       conn = GDao.getSlave();
/* 375 */       pstmt = conn.prepareStatement(sql);
/* 376 */       setParams(pstmt, args);
/* 377 */       rs = pstmt.executeQuery();
/* 378 */       while (rs.next()) {
/* 379 */         rowReader.mapRow(rs);
/*     */       }
/* 381 */     } catch (SQLException e) {
/* 382 */       exceptionSQL(e);
/*     */     } finally {
/* 384 */       free(rs, pstmt, conn);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void query(String sql, RowReader rowReader) {
/* 393 */     Connection conn = null;
/* 394 */     PreparedStatement pstmt = null;
/* 395 */     ResultSet rs = null;
/*     */     try {
/* 397 */       conn = GDao.getSlave();
/* 398 */       pstmt = conn.prepareStatement(sql);
/* 399 */       rowReader.setParams(pstmt);
/* 400 */       rs = pstmt.executeQuery();
/* 401 */       while (rs.next()) {
/* 402 */         rowReader.mapRow(rs);
/*     */       }
/* 404 */     } catch (SQLException e) {
/* 405 */       exceptionSQL(e);
/*     */     } finally {
/* 407 */       free(rs, pstmt, conn);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int queryForInt(String sql, RowMapper<Integer> rowMapper) {
/* 412 */     Integer value = queryForObject(sql, rowMapper);
/* 413 */     return (value == null) ? 0 : value.intValue();
/*     */   }
/*     */   
/*     */   public static int queryForInt(String sql, RowMapper<Integer> rowMapper, Object... args) {
/* 417 */     Integer value = queryForObject(sql, rowMapper, args);
/* 418 */     return (value == null) ? 0 : value.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) {
/* 425 */     Connection conn = null;
/* 426 */     PreparedStatement pstmt = null;
/* 427 */     ResultSet rs = null;
/*     */     try {
/* 429 */       conn = GDao.getSlave();
/* 430 */       pstmt = conn.prepareStatement(sql);
/* 431 */       setParams(pstmt, args);
/* 432 */       rs = pstmt.executeQuery();
/* 433 */       if (rs.next()) {
/* 434 */         return rowMapper.mapRow(rs);
/*     */       }
/* 436 */     } catch (SQLException e) {
/* 437 */       exceptionSQL(e);
/*     */     } finally {
/* 439 */       free(rs, pstmt, conn);
/*     */     } 
/* 441 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T queryForObject(String sql, RowMapper<T> rowMapper) {
/* 449 */     Connection conn = null;
/* 450 */     PreparedStatement pstmt = null;
/* 451 */     ResultSet rs = null;
/*     */     try {
/* 453 */       conn = GDao.getSlave();
/* 454 */       pstmt = conn.prepareStatement(sql);
/* 455 */       rowMapper.setParams(pstmt);
/* 456 */       rs = pstmt.executeQuery();
/* 457 */       if (rs.next()) {
/* 458 */         return rowMapper.mapRow(rs);
/*     */       }
/* 460 */     } catch (SQLException e) {
/* 461 */       exceptionSQL(e);
/*     */     } finally {
/* 463 */       free(rs, pstmt, conn);
/*     */     } 
/* 465 */     return null;
/*     */   }
/*     */   
/*     */   private static void setParams(PreparedStatement pstmt, Object[] args) throws SQLException {
/* 469 */     if (args == null)
/* 470 */       return;  for (int i = 0; i < args.length; i++) {
/* 471 */       if (args[i] instanceof Integer) {
/* 472 */         pstmt.setInt(i + 1, ((Integer)args[i]).intValue());
/* 473 */       } else if (args[i] instanceof String) {
/* 474 */         pstmt.setString(i + 1, (String)args[i]);
/* 475 */       } else if (args[i] instanceof Byte) {
/* 476 */         pstmt.setByte(i + 1, ((Byte)args[i]).byteValue());
/* 477 */       } else if (args[i] instanceof Boolean) {
/* 478 */         pstmt.setByte(i + 1, (byte)(((Boolean)args[i]).booleanValue() ? 1 : 0));
/* 479 */       } else if (args[i] instanceof Short) {
/* 480 */         pstmt.setShort(i + 1, ((Short)args[i]).shortValue());
/* 481 */       } else if (args[i] instanceof Timestamp) {
/* 482 */         pstmt.setTimestamp(i + 1, (Timestamp)args[i]);
/* 483 */       } else if (args[i] instanceof Date) {
/* 484 */         pstmt.setDate(i + 1, new Date(((Date)args[i]).getTime()));
/* 485 */       } else if (args[i] instanceof Date) {
/* 486 */         pstmt.setDate(i + 1, new Date(((Date)args[i]).getTime()));
/* 487 */       } else if (args[i] instanceof Double) {
/* 488 */         pstmt.setDouble(i + 1, ((Double)args[i]).doubleValue());
/* 489 */       } else if (args[i] instanceof byte[]) {
/* 490 */         pstmt.setBytes(i + 1, (byte[])args[i]);
/* 491 */       } else if (args[i] instanceof Long) {
/* 492 */         pstmt.setLong(i + 1, ((Long)args[i]).longValue());
/*     */       } else {
/* 494 */         if (args[i] != null) {
/* 495 */           Out.warn(new Object[] { "暂未支持的持久化数据类型，请确认：", args[i].getClass() });
/*     */         }
/* 497 */         pstmt.setObject(i + 1, args[i]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean supportsBatchUpdates(Connection conn) throws SQLException {
/* 503 */     DatabaseMetaData dbmd = conn.getMetaData();
/* 504 */     if (dbmd != null && 
/* 505 */       dbmd.supportsBatchUpdates()) {
/* 506 */       return true;
/*     */     }
/*     */     
/* 509 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\DBHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */