/*     */ package com.wanniu.game;
/*     */ 
/*     */ import com.wanniu.core.util.DataUtil;
/*     */ import com.wanniu.core.util.DateUtil;
/*     */ import com.wanniu.core.util.StringUtil;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DB2JMain
/*     */ {
/*  23 */   private static String pakName = "com.wanniu.game.vo";
/*     */   
/*  25 */   private static String author = "agui";
/*     */   
/*  27 */   private static String db = "xmds_game";
/*     */   
/*     */   static Connection getConnection() {
/*     */     try {
/*  31 */       Class.forName("com.mysql.jdbc.Driver");
/*  32 */       Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.102.84:3306/" + db, "root", "root");
/*  33 */       return conn;
/*  34 */     } catch (Exception e) {
/*  35 */       e.printStackTrace();
/*     */       
/*  37 */       return null;
/*     */     } 
/*     */   }
/*     */   public static void generate(String table) {
/*  41 */     Connection conn = null;
/*  42 */     String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA=? AND TABLE_NAME=?";
/*  43 */     PreparedStatement pstmt = null;
/*  44 */     ResultSet rs = null;
/*     */     try {
/*  46 */       conn = getConnection();
/*  47 */       pstmt = conn.prepareStatement(sql);
/*  48 */       pstmt.setString(1, db);
/*  49 */       pstmt.setString(2, table);
/*  50 */       rs = pstmt.executeQuery();
/*     */       
/*  52 */       boolean useDate = false;
/*  53 */       StringBuilder psb = new StringBuilder();
/*  54 */       StringBuilder msb = new StringBuilder();
/*  55 */       while (rs.next()) {
/*  56 */         String name = rs.getString(1);
/*  57 */         String type = rs.getString(2);
/*  58 */         if (!useDate && "datetime".equals(type)) {
/*  59 */           useDate = true;
/*     */         }
/*  61 */         String comment = rs.getString(3);
/*  62 */         String key = rs.getString(4);
/*  63 */         psb.append(property(name, type, comment, key));
/*     */       } 
/*     */ 
/*     */       
/*  67 */       StringBuilder content = new StringBuilder();
/*     */       
/*  69 */       content.append("package " + pakName + ";\r\n");
/*  70 */       content.append("\r\n");
/*     */       
/*  72 */       if (useDate) {
/*  73 */         content.append("import java.util.Date;\r\n");
/*     */       }
/*     */ 
/*     */       
/*  77 */       content.append("\r\n/**\r\n");
/*  78 */       content.append(" * 数据库表[" + table + "]对应的实体类\r\n");
/*  79 */       content.append(" * 作者：" + author + "\r\n");
/*  80 */       content.append(" * 自动创建时间：" + DateUtil.getDateTime() + "\r\n");
/*  81 */       content.append(" */");
/*     */       
/*  83 */       content.append("\r\npublic class " + DataUtil.getClassName(table) + "PO{\r\n");
/*     */       
/*  85 */       content.append(psb.toString());
/*     */       
/*  87 */       content.append(msb.toString());
/*     */       
/*  89 */       content.append("}");
/*     */       
/*     */       try {
/*  92 */         File directory = new File("");
/*  93 */         String outputPath = directory.getAbsolutePath() + "/src/demo/" + pakName.replace(".", "/") + "/" + DataUtil.getClassName(table) + "PO.java";
/*  94 */         System.out.println(outputPath);
/*  95 */         FileWriter fw = new FileWriter(outputPath);
/*  96 */         PrintWriter pw = new PrintWriter(fw);
/*  97 */         pw.println(content.toString());
/*  98 */         pw.flush();
/*  99 */         pw.close();
/* 100 */       } catch (IOException e) {
/* 101 */         e.printStackTrace();
/*     */       }
/*     */     
/* 104 */     } catch (Exception e) {
/* 105 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 108 */         rs.close();
/* 109 */         pstmt.close();
/* 110 */         conn.close();
/* 111 */       } catch (SQLException e) {
/* 112 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String property(String name, String type, String comment, String key) {
/* 121 */     StringBuilder sb = new StringBuilder();
/* 122 */     if (!StringUtil.isEmpty(comment)) {
/* 123 */       sb.append("\t/** ").append(comment).append(" */\r\n");
/*     */     } else {
/* 125 */       sb.append("\n");
/*     */     } 
/* 127 */     sb.append("\tpublic ").append(mapType(type)).append(" ").append(name).append(";\r\n");
/* 128 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String method(String name, String type, String comment, String key) {
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     sb.append("\tpublic void set" + DataUtil.getClassName(name) + "(" + mapType(type) + " " + name + ") {\r\n");
/* 137 */     sb.append("\t\tthis." + name + " = " + name + ";\r\n");
/* 138 */     sb.append("\t}\r\n");
/* 139 */     sb.append("\tpublic " + mapType(type) + " get" + DataUtil.getClassName(name) + "() {\r\n");
/* 140 */     sb.append("\t\treturn " + name + ";\r\n");
/* 141 */     sb.append("\t}\r\n\r\n");
/* 142 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String mapType(String sqlType) {
/* 149 */     if (sqlType.equals("bit"))
/* 150 */       return "boolean"; 
/* 151 */     if (sqlType.equals("tinyint"))
/* 152 */       return "byte"; 
/* 153 */     if (sqlType.equals("smallint"))
/* 154 */       return "short"; 
/* 155 */     if (sqlType.equals("int"))
/* 156 */       return "int"; 
/* 157 */     if (sqlType.equals("bigint"))
/* 158 */       return "long"; 
/* 159 */     if (sqlType.equals("float"))
/* 160 */       return "float"; 
/* 161 */     if (sqlType.equals("decimal") || sqlType.equals("numeric") || sqlType.equals("real") || sqlType
/* 162 */       .equals("money") || sqlType.equals("smallmoney"))
/* 163 */       return "double"; 
/* 164 */     if (sqlType.equals("varchar") || sqlType.equals("char") || sqlType.equals("nvarchar") || sqlType
/* 165 */       .equals("nchar") || sqlType.equals("text"))
/* 166 */       return "String"; 
/* 167 */     if (sqlType.equals("datetime")) {
/* 168 */       return "Date";
/*     */     }
/* 170 */     return "Object";
/*     */   }
/*     */   
/*     */   static void generate() {
/* 174 */     Connection conn = null;
/* 175 */     String sql = "SHOW TABLES";
/* 176 */     PreparedStatement pstmt = null;
/* 177 */     ResultSet rs = null;
/*     */     try {
/* 179 */       conn = getConnection();
/* 180 */       pstmt = conn.prepareStatement(sql);
/* 181 */       rs = pstmt.executeQuery();
/* 182 */       while (rs.next()) {
/* 183 */         String table = rs.getString(1);
/* 184 */         generate(table);
/*     */       } 
/* 186 */     } catch (Exception e) {
/* 187 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 190 */         rs.close();
/* 191 */         pstmt.close();
/* 192 */         conn.close();
/* 193 */       } catch (SQLException e) {
/* 194 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 200 */     generate();
/*     */   }
/*     */ }


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\DB2JMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */