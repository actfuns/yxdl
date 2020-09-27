/*     */ package com.wanniu.db.dao;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONArray;
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.wanniu.core.db.ModifyOperateType;
/*     */ import com.wanniu.core.db.pool.DBFactory;
/*     */ import com.wanniu.core.db.pool.DBSource;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MysqlDao
/*     */ {
/*     */   public static int insert(String dsName, String dbName, String tableName, JSONObject entityJson) {
/*     */     try {
/*  39 */       DBSource ds = DBFactory.lookup(dsName);
/*  40 */       String sql = (String)ds.sqls.get("insert:" + tableName);
/*  41 */       List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
/*  42 */       if (sql == null) {
/*  43 */         sql = organizingInsertSql(tableName, fieldInfos);
/*  44 */         ds.sqls.put("insert:" + tableName, sql);
/*     */       } 
/*  46 */       return executeModify(dsName, dbName, sql, tableName, ModifyOperateType.INSERT, fieldInfos, entityJson, null);
/*  47 */     } catch (Exception e) {
/*  48 */       Out.error(new Object[] { e });
/*  49 */       Out.error(new Object[] { "通用插入、更新失败:表:【", tableName, "】", "; JSON【", entityJson.toJSONString(), "】" });
/*     */       
/*  51 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int update(String dsName, String dbName, String tableName, JSONObject entityJson) {
/*     */     try {
/*  59 */       DBSource ds = DBFactory.lookup(dsName);
/*  60 */       String sql = (String)ds.sqls.get("update:" + tableName);
/*  61 */       List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
/*  62 */       if (sql == null) {
/*  63 */         sql = organizingUpdateSql(tableName, fieldInfos);
/*  64 */         ds.sqls.put("update:" + tableName, sql);
/*     */       } 
/*  66 */       return executeModify(dsName, dbName, sql, tableName, ModifyOperateType.UPDATE, fieldInfos, entityJson, null);
/*  67 */     } catch (Exception e) {
/*  68 */       Out.error(new Object[] { e });
/*  69 */       Out.error(new Object[] { "通用更新失败:表:【", tableName, "】", "; JSON【", entityJson.toJSONString(), "】" });
/*     */       
/*  71 */       return -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void delete(String dsName, String dbName, String tableName, String modifyPKey) {
/*     */     try {
/*  79 */       DBSource ds = DBFactory.lookup(dsName);
/*  80 */       String sql = (String)ds.sqls.get("delete:" + tableName);
/*  81 */       List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
/*  82 */       if (sql == null) {
/*  83 */         sql = organizingDeleteSql(tableName, fieldInfos);
/*  84 */         ds.sqls.put("delete:" + tableName, sql);
/*     */       } 
/*  86 */       executeModify(dsName, dbName, sql, tableName, ModifyOperateType.DELETE, fieldInfos, null, modifyPKey);
/*  87 */     } catch (Exception e) {
/*  88 */       Out.error(new Object[] { e });
/*  89 */       Out.error(new Object[] { "通用删除失败:表:【", tableName, "】", "; priKey【", modifyPKey, "】" });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String select(String dsName, String dbName, String tableName, JSONObject json) {
/*  97 */     if (!isTable(dsName, tableName)) {
/*  98 */       return null;
/*     */     }
/* 100 */     String sql = organizingQuerySql(tableName, json);
/* 101 */     return executeQuery(dsName, String.format(sql, new Object[] { dbName }), json);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String executeQuery(String dsName, String sql, JSONObject queryPKey) {
/* 108 */     JSONArray result = new JSONArray();
/* 109 */     Connection conn = null;
/* 110 */     PreparedStatement ps = null;
/* 111 */     ResultSet rs = null;
/*     */     try {
/* 113 */       DBSource dBSource = DBFactory.lookup(dsName);
/* 114 */       conn = dBSource.getConnection();
/* 115 */       ps = conn.prepareStatement(sql);
/* 116 */       if (queryPKey != null) {
/* 117 */         int i = 1;
/* 118 */         for (Object v : queryPKey.values()) {
/* 119 */           ps.setObject(i++, v);
/*     */         }
/*     */       } 
/* 122 */       rs = ps.executeQuery();
/* 123 */       ResultSetMetaData metaData = rs.getMetaData();
/* 124 */       int columnCount = metaData.getColumnCount();
/* 125 */       while (rs.next()) {
/* 126 */         JSONObject json = new JSONObject();
/* 127 */         for (int i = 1; i <= columnCount; i++) {
/* 128 */           String fieldName = metaData.getColumnLabel(i);
/* 129 */           Object value = rs.getObject(fieldName);
/* 130 */           if (value instanceof byte[]) {
/* 131 */             String valueStr = new String((byte[])value, "UTF-8");
/* 132 */             value = JSONObject.parse(valueStr);
/*     */           } 
/* 134 */           json.put(fieldName, value);
/*     */         } 
/* 136 */         result.add(json);
/*     */       } 
/* 138 */     } catch (Exception e) {
/* 139 */       Out.error(new Object[] { e });
/* 140 */       Out.error(new Object[] { "【查询SQL】-->", sql, "; Query Key【", queryPKey, "】" });
/*     */     } finally {
/* 142 */       if (rs != null) {
/*     */         try {
/* 144 */           rs.close();
/* 145 */         } catch (SQLException e) {
/* 146 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/* 149 */       if (ps != null) {
/*     */         try {
/* 151 */           ps.close();
/* 152 */         } catch (SQLException e) {
/* 153 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/* 156 */       if (conn != null) {
/*     */         try {
/* 158 */           conn.close();
/* 159 */         } catch (SQLException e) {
/* 160 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */     } 
/* 164 */     return result.toJSONString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int executeModify(String dsName, String dbName, String sql, String tableName, ModifyOperateType modifyOperate, List<FieldInfo> fieldInfos, JSONObject json, String modifyPKey) {
/* 172 */     Connection conn = null;
/* 173 */     PreparedStatement ps = null;
/*     */     try {
/* 175 */       DBSource dBSource = DBFactory.lookup(dsName);
/* 176 */       conn = dBSource.getConnection();
/* 177 */       ps = conn.prepareStatement(String.format(sql, new Object[] { dbName }));
/* 178 */       for (int i = 0; i < fieldInfos.size(); i++) {
/* 179 */         FieldInfo fieldInfo = fieldInfos.get(i);
/* 180 */         String colType = fieldInfo.filedType;
/* 181 */         Object colValue = null;
/* 182 */         if (modifyOperate == ModifyOperateType.DELETE) {
/* 183 */           colType = getPkeyType(dsName, tableName);
/* 184 */           colValue = modifyPKey;
/*     */         } else {
/* 186 */           colValue = json.get(fieldInfo.filedName);
/*     */         } 
/*     */         
/* 189 */         int index = i + 1;
/* 190 */         if (colType.startsWith("tinyint")) {
/* 191 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 192 */           ps.setByte(index, ((Number)colValue).byteValue());
/* 193 */         } else if (colType.startsWith("smallint")) {
/* 194 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 195 */           ps.setShort(index, ((Number)colValue).shortValue());
/* 196 */         } else if (colType.startsWith("int") || colType.startsWith("Integer")) {
/* 197 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 198 */           ps.setInt(index, ((Number)colValue).intValue());
/* 199 */         } else if (colType.startsWith("float")) {
/* 200 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 201 */           ps.setFloat(index, ((Number)colValue).floatValue());
/* 202 */         } else if (colType.startsWith("varchar")) {
/* 203 */           colValue = (colValue == null) ? "" : colValue;
/* 204 */           ps.setString(index, (String)colValue);
/* 205 */         } else if (colType.startsWith("bigint")) {
/* 206 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 207 */           ps.setLong(index, ((Number)colValue).longValue());
/* 208 */         } else if (colType.startsWith("double")) {
/* 209 */           colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
/* 210 */           ps.setDouble(index, ((Number)colValue).doubleValue());
/* 211 */         } else if (colType.startsWith("datetime")) {
/* 212 */           colValue = (colValue == null) ? null : colValue;
/* 213 */           if (colValue != null) {
/* 214 */             Date newColValue = DateUtil.format((String)colValue, "yyyy-MM-dd HH:mm:ss");
/* 215 */             ps.setTimestamp(index, new Timestamp(newColValue.getTime()));
/*     */           } else {
/* 217 */             ps.setTimestamp(index, (Timestamp)null);
/*     */           } 
/* 219 */         } else if (colType.startsWith("blob")) {
/* 220 */           String val = null;
/* 221 */           if (colValue != null && !"".equals(colValue)) {
/* 222 */             val = JSONObject.toJSONString(colValue);
/*     */           }
/* 224 */           ps.setString(index, val);
/*     */         } else {
/* 226 */           ps.setObject(index, colValue);
/*     */         } 
/* 228 */         if (modifyOperate == ModifyOperateType.DELETE) {
/*     */           break;
/*     */         }
/*     */       } 
/* 232 */       return ps.executeUpdate();
/* 233 */     } catch (Exception e) {
/* 234 */       Out.error(new Object[] { e });
/* 235 */       if (modifyOperate == ModifyOperateType.DELETE) {
/* 236 */         Out.error(new Object[] { "【删除】-->", sql, "; priKey【", modifyPKey, "】" });
/*     */       } else {
/* 238 */         Out.error(new Object[] { "【更新】-->", sql, "; JSON【", json.toJSONString(), "】" });
/*     */       } 
/*     */     } finally {
/* 241 */       if (ps != null) {
/*     */         try {
/* 243 */           ps.close();
/* 244 */         } catch (SQLException e) {
/* 245 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/* 248 */       if (conn != null) {
/*     */         try {
/* 250 */           conn.close();
/* 251 */         } catch (SQLException e) {
/* 252 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */     } 
/* 256 */     return -1;
/*     */   }
/*     */   
/* 259 */   private static Map<String, List<FieldInfo>> tableFieldInfos = new ConcurrentHashMap<>();
/*     */   
/*     */   public static boolean isTable(String dsName, String tableName) {
/* 262 */     DBSource dbSource = DBFactory.lookup(dsName);
/* 263 */     return dbSource.tables.contains(tableName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<FieldInfo> getFieldInfos(String dsName, String tableName) {
/* 270 */     List<FieldInfo> fieldInfos = tableFieldInfos.get(String.valueOf(dsName) + tableName);
/* 271 */     if (fieldInfos != null) {
/* 272 */       return fieldInfos;
/*     */     }
/* 274 */     fieldInfos = new ArrayList<>();
/* 275 */     Connection conn = null;
/* 276 */     PreparedStatement ps = null;
/* 277 */     ResultSet rs = null;
/*     */     try {
/* 279 */       DBSource dbSource = DBFactory.lookup(dsName);
/* 280 */       conn = dbSource.getConnection();
/* 281 */       ps = conn.prepareStatement("desc " + tableName);
/* 282 */       rs = ps.executeQuery();
/* 283 */       FieldInfo priInfo = null;
/* 284 */       while (rs.next()) {
/* 285 */         FieldInfo fieldInfo = new FieldInfo();
/* 286 */         fieldInfo.filedName = rs.getString("Field");
/* 287 */         fieldInfo.filedType = rs.getString("Type");
/* 288 */         fieldInfo.isPkey = "PRI".equalsIgnoreCase(rs.getString("Key"));
/* 289 */         if (fieldInfo.isPkey) {
/* 290 */           priInfo = fieldInfo; continue;
/*     */         } 
/* 292 */         fieldInfos.add(fieldInfo);
/*     */       } 
/*     */       
/* 295 */       if (priInfo != null) {
/* 296 */         fieldInfos.add(priInfo);
/*     */       }
/* 298 */     } catch (Exception e) {
/* 299 */       Out.error(new Object[] { e });
/* 300 */       throw new RuntimeException(e);
/*     */     } finally {
/* 302 */       if (ps != null) {
/*     */         try {
/* 304 */           ps.close();
/* 305 */         } catch (SQLException e) {
/* 306 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/* 309 */       if (conn != null) {
/*     */         try {
/* 311 */           conn.close();
/* 312 */         } catch (SQLException e) {
/* 313 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */     } 
/* 317 */     tableFieldInfos.put(String.valueOf(dsName) + tableName, fieldInfos);
/* 318 */     return fieldInfos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String organizingInsertSql(String tableName, List<FieldInfo> fieldInfos) {
/* 325 */     StringBuilder sql = new StringBuilder();
/* 326 */     StringBuilder keys = new StringBuilder();
/* 327 */     StringBuilder values = new StringBuilder();
/* 328 */     for (int i = 0; i < fieldInfos.size(); i++) {
/* 329 */       FieldInfo fieldInfo = fieldInfos.get(i);
/* 330 */       String fieldName = fieldInfo.filedName;
/* 331 */       keys.append(fieldName);
/* 332 */       values.append("?");
/* 333 */       if (i < fieldInfos.size() - 1) {
/* 334 */         keys.append(",");
/* 335 */         values.append(",");
/*     */       } 
/*     */     } 
/* 338 */     sql.append("INSERT INTO %s." + tableName);
/* 339 */     sql.append(" (" + keys.toString() + ") ");
/* 340 */     sql.append("VALUES (" + values.toString() + ")");
/* 341 */     return sql.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String organizingUpdateSql(String tableName, List<FieldInfo> fieldInfos) {
/* 348 */     StringBuilder sql = new StringBuilder();
/* 349 */     StringBuilder cols = new StringBuilder();
/* 350 */     String pKey = "";
/* 351 */     for (int i = 0; i < fieldInfos.size(); i++) {
/* 352 */       FieldInfo fieldInfo = fieldInfos.get(i);
/* 353 */       String fieldName = fieldInfo.filedName;
/* 354 */       if (fieldInfo.isPkey) {
/* 355 */         pKey = fieldName;
/*     */       } else {
/* 357 */         cols.append(String.valueOf(fieldName) + "=?,");
/*     */       } 
/*     */     } 
/* 360 */     sql.append("UPDATE %s." + tableName + " SET ");
/* 361 */     sql.append(cols.substring(0, cols.length() - 1));
/* 362 */     sql.append(" WHERE ");
/* 363 */     sql.append(String.valueOf(pKey) + "=?");
/* 364 */     return sql.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String organizingDeleteSql(String tableName, List<FieldInfo> fieldInfos) {
/* 371 */     StringBuilder sql = new StringBuilder();
/* 372 */     String pKey = "";
/* 373 */     for (int i = fieldInfos.size() - 1; i >= 0; i--) {
/* 374 */       FieldInfo fieldInfo = fieldInfos.get(i);
/* 375 */       if (fieldInfo.isPkey) {
/* 376 */         pKey = fieldInfo.filedName;
/*     */         break;
/*     */       } 
/*     */     } 
/* 380 */     sql.append("DELETE FROM %s." + tableName);
/* 381 */     sql.append(" WHERE ");
/* 382 */     sql.append(String.valueOf(pKey) + "=?");
/* 383 */     return sql.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String organizingQuerySql(String tableName, JSONObject condition) {
/* 390 */     StringBuilder sql = new StringBuilder();
/* 391 */     sql.append("SELECT * FROM %s.").append(tableName);
/* 392 */     if (condition == null) {
/* 393 */       return sql.toString();
/*     */     }
/* 395 */     sql.append(" WHERE ");
/* 396 */     boolean flag = false;
/* 397 */     for (String con : condition.keySet()) {
/* 398 */       if (flag) {
/* 399 */         sql.append(" AND ");
/*     */       }
/* 401 */       sql.append(con).append("=?");
/* 402 */       flag = true;
/*     */     } 
/* 404 */     return sql.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPkeyType(String dsName, String tableName) {
/* 411 */     FieldInfo fieldInfo = getPkeyField(dsName, tableName);
/* 412 */     if (fieldInfo != null) {
/* 413 */       return fieldInfo.filedType;
/*     */     }
/* 415 */     return "";
/*     */   }
/*     */   
/*     */   public static FieldInfo getPkeyField(String dsName, String tableName) {
/* 419 */     List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
/* 420 */     for (int i = fieldInfos.size() - 1; i >= 0; i--) {
/* 421 */       FieldInfo fieldInfo = fieldInfos.get(i);
/* 422 */       if (fieldInfo.isPkey) {
/* 423 */         return fieldInfo;
/*     */       }
/*     */     } 
/* 426 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-db\xmds-db.jar!\com\wanniu\db\dao\MysqlDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */