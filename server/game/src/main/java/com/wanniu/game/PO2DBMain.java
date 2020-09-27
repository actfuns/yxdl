/*     */ package com.wanniu.game;
/*     */ 
/*     */ import com.wanniu.core.db.handler.DBHandler;
/*     */ import com.wanniu.core.game.entity.GEntity;
/*     */ import com.wanniu.core.logfs.Out;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.net.URL;
/*     */ import java.net.URLDecoder;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PO2DBMain
/*     */ {
/*     */   private static final String MODEL_PACKAGE = "com.wanniu.game.poes";
/*     */   private static final String HOST = "192.168.102.84";
/*     */   private static final int PORT = 3306;
/*     */   private static final String DB_NAME = "xmds_game";
/*     */   private static final String USERNAME = "root";
/*     */   private static final String PASSWORD = "root";
/*     */   private static final String URL = "jdbc:mysql://192.168.102.84:3306/xmds_game?useSSL=true";
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  45 */     Out.setting();
/*  46 */     Set<String> tables = existsTables();
/*     */     
/*  48 */     doDropTables(tables);
/*     */     
/*  50 */     Set<Class<?>> classes = getClasses("com.wanniu.game.poes");
/*  51 */     doCreateTable(tables, classes);
/*  52 */     System.exit(1);
/*     */   }
/*     */   
/*     */   static void doDropTables(Set<String> tables) throws InterruptedException {
/*  56 */     CountDownLatch down = new CountDownLatch(tables.size());
/*  57 */     for (String table : tables) {
/*  58 */       (new Thread(() -> {
/*     */             execute("DROP TABLE " + table);
/*     */             down.countDown();
/*  61 */           })).start();
/*     */     } 
/*  63 */     down.await();
/*  64 */     tables.clear();
/*     */   }
/*     */   
/*     */   private static boolean isEntity(Class<?> clz) {
/*  68 */     if (clz.getSuperclass() == GEntity.class) {
/*  69 */       return true;
/*     */     }
/*  71 */     Class<?>[] clzs = clz.getInterfaces();
/*  72 */     for (Class<?> c : clzs) {
/*  73 */       if (c == GEntity.class) {
/*  74 */         return true;
/*     */       }
/*     */     } 
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   private static void doCreateTable(Set<String> tables, Set<Class<?>> classes) {
/*  81 */     for (Class<?> clz : classes) {
/*  82 */       if (!isEntity(clz)) {
/*  83 */         Out.error(new Object[] { clz.getName(), " is not Entity PO" });
/*     */         continue;
/*     */       } 
/*  86 */       boolean isPlayerTable = clz.isAnnotationPresent((Class)DBTable.class);
/*  87 */       String tableName = classNameToDBName(clz.getSimpleName());
/*  88 */       if (isPlayerTable) {
/*  89 */         tableName = ((DBTable)clz.<DBTable>getAnnotation(DBTable.class)).value();
/*  90 */         if (tableName.startsWith("tb")) {
/*  91 */           Out.warn(new Object[] { tableName, " must be remove tb prefix!!!" });
/*     */         } else {
/*  93 */           tableName = "tb_" + tableName;
/*     */         } 
/*     */       } 
/*  96 */       Field[] fields = clz.getFields();
/*  97 */       StringBuilder builder = new StringBuilder();
/*  98 */       Map<String, DBField> map = getFieldAnnotion(clz);
/*     */       
/* 100 */       if (!tables.contains(tableName)) {
/* 101 */         String primaryKey = null;
/*     */         try {
/* 103 */           primaryKey = getPrimaryKey(clz, isPlayerTable);
/* 104 */         } catch (Exception e) {
/* 105 */           Out.error(new Object[] { e });
/*     */           continue;
/*     */         } 
/* 108 */         builder.append("CREATE TABLE IF NOT EXISTS `" + tableName + "` (");
/* 109 */         if (isPlayerTable && primaryKey == null) {
/* 110 */           primaryKey = "playerId";
/* 111 */           builder.append("`" + primaryKey + "` char(36) NOT NULL, ");
/*     */         } 
/* 113 */         for (int i = 0; i < fields.length; i++) {
/* 114 */           Field field = fields[i];
/* 115 */           String fieldName = field.getName();
/* 116 */           String comment = "";
/* 117 */           DBField df = map.get(fieldName);
/* 118 */           if (df != null) {
/* 119 */             if (!df.include()) {
/*     */               continue;
/*     */             }
/* 122 */             if (!"".equals(df.comment())) {
/* 123 */               comment = " COMMENT '" + df.comment() + "'";
/*     */             }
/*     */           } 
/* 126 */           String fieldType = getFieldType(field);
/* 127 */           builder.append("`" + classFieldToDBField(fieldName) + "` " + fieldType + comment + ","); continue;
/*     */         } 
/* 129 */         builder.append(" PRIMARY KEY (`" + classFieldToDBField(primaryKey) + "`)");
/* 130 */         builder.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;");
/*     */       } else {
/* 132 */         List<Field> addFields = getAddFields(tableName, fields);
/* 133 */         if (addFields.size() > 0) {
/* 134 */           builder.append("ALTER TABLE " + tableName + " ADD COLUMN ");
/* 135 */           boolean alter = false;
/* 136 */           for (int i = 0; i < addFields.size(); i++) {
/* 137 */             Field field = addFields.get(i);
/* 138 */             String fieldName = field.getName();
/* 139 */             String fieldType = getFieldType(field);
/* 140 */             String comment = "";
/* 141 */             DBField df = map.get(fieldName);
/* 142 */             if (df != null) {
/* 143 */               if (!df.include()) {
/*     */                 continue;
/*     */               }
/* 146 */               if (!"".equals(df.comment())) {
/* 147 */                 comment = " COMMENT '" + df.comment() + "'";
/*     */               }
/*     */             } 
/* 150 */             if (i == addFields.size() - 1) {
/* 151 */               builder.append("`" + classFieldToDBField(fieldName) + "` " + fieldType + comment);
/*     */             } else {
/* 153 */               builder.append("`" + classFieldToDBField(fieldName) + "` " + fieldType + comment + ",");
/*     */             } 
/* 155 */             alter = true; continue;
/*     */           } 
/* 157 */           if (!alter) {
/* 158 */             builder.setLength(0);
/*     */           }
/*     */         } 
/*     */       } 
/* 162 */       if (builder.length() > 0) {
/* 163 */         execute(builder.toString());
/*     */       }
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
/*     */   private static List<Field> getAddFields(String tableName, Field[] fields) {
/* 176 */     List<Field> addFields = new ArrayList<>();
/* 177 */     List<String> tableCols = getTableFields(tableName);
/* 178 */     for (int i = 0; i < fields.length; i++) {
/* 179 */       Field field = fields[i];
/* 180 */       String fieldName = field.getName();
/* 181 */       fieldName = classFieldToDBField(fieldName);
/* 182 */       if (!tableCols.contains(fieldName)) {
/* 183 */         addFields.add(field);
/*     */       }
/*     */     } 
/* 186 */     return addFields;
/*     */   }
/*     */   
/*     */   private static void execute(String sql) {
/* 190 */     Connection conn = null;
/* 191 */     PreparedStatement ps = null;
/*     */     try {
/* 193 */       Class.forName("com.mysql.jdbc.Driver");
/* 194 */       conn = DriverManager.getConnection("jdbc:mysql://192.168.102.84:3306/xmds_game?useSSL=true", "root", "root");
/* 195 */       ps = conn.prepareStatement(sql);
/* 196 */       ps.executeUpdate(sql);
/* 197 */     } catch (Exception e) {
/* 198 */       Out.error(new Object[] { e, sql });
/*     */     } finally {
/* 200 */       if (ps != null) {
/*     */         try {
/* 202 */           ps.close();
/* 203 */         } catch (SQLException e) {
/* 204 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/* 207 */       if (conn != null) {
/*     */         try {
/* 209 */           conn.close();
/* 210 */         } catch (SQLException e) {
/* 211 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       }
/*     */     } 
/* 215 */     System.out.println(sql);
/*     */   }
/*     */   
/*     */   private static Set<Class<?>> getClasses(String pkage) {
/* 219 */     Set<Class<?>> classes = new LinkedHashSet<>();
/* 220 */     boolean recursive = true;
/* 221 */     String packageName = pkage;
/* 222 */     String packageDirName = packageName.replace('.', '/');
/*     */ 
/*     */     
/*     */     try {
/* 226 */       Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
/* 227 */       boolean isHas = false;
/* 228 */       while (dirs.hasMoreElements()) {
/* 229 */         isHas = true;
/* 230 */         URL url = dirs.nextElement();
/* 231 */         String protocol = url.getProtocol();
/* 232 */         if ("file".equals(protocol)) {
/* 233 */           String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
/*     */           
/* 235 */           findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
/*     */         } 
/*     */       } 
/* 238 */       if (!isHas) {
/* 239 */         Out.error(new Object[] { "包:", pkage, " 下找不到类文件,请检查是否存在" });
/*     */       }
/* 241 */     } catch (IOException e) {
/* 242 */       Out.error(new Object[] { e });
/*     */     } 
/* 244 */     return classes;
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
/*     */   private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
/* 256 */     File dir = new File(packagePath);
/* 257 */     if (!dir.exists() || !dir.isDirectory()) {
/* 258 */       Out.error(new Object[] { "用户定义包名 ", packageName, " 找不到或者不是一个目录" });
/*     */       return;
/*     */     } 
/* 261 */     FileFilter filter = new FileFilter()
/*     */       {
/*     */         public boolean accept(File file) {
/* 264 */           return (((recursive && file.isDirectory()) || file.getName().endsWith(".class")) && file.getName().indexOf("$") == -1);
/*     */         }
/*     */       };
/* 267 */     File[] dirfiles = dir.listFiles(filter);
/*     */ 
/*     */     
/* 270 */     for (File file : dirfiles) {
/* 271 */       if (file.isDirectory()) {
/* 272 */         findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
/*     */       } else {
/* 274 */         String className = file.getName().substring(0, file.getName().length() - 6);
/*     */         try {
/* 276 */           classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
/* 277 */         } catch (ClassNotFoundException e) {
/* 278 */           Out.error(new Object[] { "添加用户自定义视图类错误 找不到此类的.class文件" });
/* 279 */           Out.error(new Object[] { e });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String classNameToDBName(String className) {
/* 286 */     if (className.endsWith("PO")) {
/* 287 */       int lastIndex = className.lastIndexOf("PO");
/* 288 */       className = className.substring(0, lastIndex);
/*     */     } 
/* 290 */     return "tb" + tableName(className);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String tableName(String str) {
/* 300 */     StringBuilder sb = new StringBuilder();
/* 301 */     if (str != null) {
/* 302 */       for (int i = 0; i < str.length(); i++) {
/* 303 */         char c = str.charAt(i);
/* 304 */         if (Character.isUpperCase(c)) {
/* 305 */           sb.append("_");
/* 306 */           sb.append(Character.toLowerCase(c));
/*     */         } else {
/* 308 */           sb.append(c);
/*     */         } 
/*     */       } 
/*     */     }
/* 312 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private static String classFieldToDBField(String str) {
/* 316 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, DBField> getFieldAnnotion(Class<?> cl) {
/* 326 */     Map<String, DBField> map = new HashMap<>();
/* 327 */     Field[] fields = cl.getFields();
/* 328 */     for (Field field : fields) {
/* 329 */       DBField dbf = field.<DBField>getAnnotation(DBField.class);
/* 330 */       if (dbf != null) {
/* 331 */         map.put(field.getName(), dbf);
/*     */       }
/*     */     } 
/* 334 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getPrimaryKey(Class<?> cl, boolean playerTable) throws Exception {
/* 345 */     Field[] fields = cl.getFields();
/* 346 */     for (Field field : fields) {
/* 347 */       boolean isKey = false;
/* 348 */       if (field.getAnnotation(DBField.class) != null) {
/* 349 */         isKey = ((DBField)field.<DBField>getAnnotation(DBField.class)).isPKey();
/*     */       }
/*     */       
/* 352 */       if (isKey) {
/* 353 */         return field.getName();
/*     */       }
/*     */     } 
/* 356 */     if (!playerTable) {
/* 357 */       throw new Exception("类: " + cl.getName() + " non-existent primaryKey");
/*     */     }
/* 359 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getFieldType(Field field) {
/* 369 */     DBField df = field.<DBField>getAnnotation(DBField.class);
/* 370 */     if (df == null || "".equals(df.fieldType())) {
/* 371 */       return getSelfFieldType(field);
/*     */     }
/* 373 */     return (df.fieldType().indexOf("blob") >= 0) ? df.fieldType() : (df.fieldType() + "(" + df.size() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getSelfFieldType(Field field) {
/* 383 */     String fieldType = field.getType().getSimpleName();
/* 384 */     String type = null;
/* 385 */     if (fieldType.equalsIgnoreCase("Byte") || fieldType.equalsIgnoreCase("Short") || fieldType.equalsIgnoreCase("int") || fieldType
/* 386 */       .equalsIgnoreCase("Integer")) {
/* 387 */       type = "int(11) NOT NULL default 0";
/* 388 */     } else if (fieldType.equalsIgnoreCase("Float")) {
/* 389 */       type = "float(3) NOT NULL default 0";
/* 390 */     } else if (fieldType.equals("String")) {
/* 391 */       DBField df = field.<DBField>getAnnotation(DBField.class);
/* 392 */       int size = 500;
/* 393 */       if (df != null) {
/* 394 */         if (df.size() > 0) {
/* 395 */           size = df.size();
/* 396 */         } else if (df.isPKey()) {
/* 397 */           size = 64;
/*     */         } 
/*     */       }
/* 400 */       type = "varchar(" + size + ")";
/* 401 */     } else if (fieldType.equals("Date")) {
/* 402 */       type = "datetime";
/* 403 */     } else if (fieldType.equalsIgnoreCase("Long")) {
/* 404 */       type = "bigint NOT NULL default 0";
/* 405 */     } else if (fieldType.equals("Double")) {
/* 406 */       type = "double(6) NOT NULL default 0";
/*     */     } else {
/* 408 */       type = "blob";
/*     */     } 
/* 410 */     return type;
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
/*     */   private static List<String> getTableFields(String tableName) {
/* 423 */     List<String> fieldNames = new ArrayList<>();
/* 424 */     String queryAllTableFieldsSql = "show full fields FROM " + tableName;
/* 425 */     Connection conn = null;
/* 426 */     PreparedStatement pstmt = null;
/* 427 */     ResultSet rs = null;
/*     */     try {
/* 429 */       conn = DriverManager.getConnection("jdbc:mysql://192.168.102.84:3306/xmds_game?useSSL=true", "root", "root");
/* 430 */       pstmt = conn.prepareStatement(queryAllTableFieldsSql);
/* 431 */       rs = pstmt.executeQuery();
/*     */       
/* 433 */       while (rs.next()) {
/* 434 */         fieldNames.add(rs.getString(1));
/*     */       }
/* 436 */     } catch (Exception e) {
/* 437 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 439 */       DBHandler.free(rs, pstmt, conn);
/*     */     } 
/* 441 */     return fieldNames;
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
/*     */   private static Set<String> existsTables() {
/* 453 */     Set<String> tableNames = new HashSet<>();
/* 454 */     Connection conn = null;
/* 455 */     PreparedStatement pstms = null;
/* 456 */     ResultSet rs = null;
/*     */     try {
/* 458 */       conn = DriverManager.getConnection("jdbc:mysql://192.168.102.84:3306/xmds_game?useSSL=true", "root", "root");
/* 459 */       pstms = conn.prepareStatement("SHOW tables");
/* 460 */       rs = pstms.executeQuery();
/* 461 */       while (rs.next()) {
/* 462 */         tableNames.add(rs.getString(1));
/*     */       }
/* 464 */     } catch (Exception e) {
/* 465 */       Out.error(new Object[] { e });
/*     */     } finally {
/* 467 */       DBHandler.free(rs, pstms, conn);
/*     */     } 
/* 469 */     return tableNames;
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\PO2DBMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */