package com.wanniu.game;

import com.wanniu.core.util.DataUtil;
import com.wanniu.core.util.DateUtil;
import com.wanniu.core.util.StringUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB2JMain {
    private static String pakName = "com.wanniu.game.vo";

    private static String author = "agui";

    private static String db = "xmds_game";

    static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.102.84:3306/" + db, "root", "root");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void generate(String table) {
        Connection conn = null;
        String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA=? AND TABLE_NAME=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, db);
            pstmt.setString(2, table);
            rs = pstmt.executeQuery();

            boolean useDate = false;
            StringBuilder psb = new StringBuilder();
            StringBuilder msb = new StringBuilder();
            while (rs.next()) {
                String name = rs.getString(1);
                String type = rs.getString(2);
                if (!useDate && "datetime".equals(type)) {
                    useDate = true;
                }
                String comment = rs.getString(3);
                String key = rs.getString(4);
                psb.append(property(name, type, comment, key));
            }


            StringBuilder content = new StringBuilder();

            content.append("package " + pakName + ";\r\n");
            content.append("\r\n");

            if (useDate) {
                content.append("import java.util.Date;\r\n");
            }


            content.append("\r\n/**\r\n");
            content.append(" * 数据库表[" + table + "]对应的实体类\r\n");
            content.append(" * 作者：" + author + "\r\n");
            content.append(" * 自动创建时间：" + DateUtil.getDateTime() + "\r\n");
            content.append(" */");

            content.append("\r\npublic class " + DataUtil.getClassName(table) + "PO{\r\n");

            content.append(psb.toString());

            content.append(msb.toString());

            content.append("}");

            try {
                File directory = new File("");
                String outputPath = directory.getAbsolutePath() + "/src/demo/" + pakName.replace(".", "/") + "/" + DataUtil.getClassName(table) + "PO.java";
                System.out.println(outputPath);
                FileWriter fw = new FileWriter(outputPath);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content.toString());
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    static String property(String name, String type, String comment, String key) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtil.isEmpty(comment)) {
            sb.append("\t/** ").append(comment).append(" */\r\n");
        } else {
            sb.append("\n");
        }
        sb.append("\tpublic ").append(mapType(type)).append(" ").append(name).append(";\r\n");
        return sb.toString();
    }


    static String method(String name, String type, String comment, String key) {
        StringBuilder sb = new StringBuilder();
        sb.append("\tpublic void set" + DataUtil.getClassName(name) + "(" + mapType(type) + " " + name + ") {\r\n");
        sb.append("\t\tthis." + name + " = " + name + ";\r\n");
        sb.append("\t}\r\n");
        sb.append("\tpublic " + mapType(type) + " get" + DataUtil.getClassName(name) + "() {\r\n");
        sb.append("\t\treturn " + name + ";\r\n");
        sb.append("\t}\r\n\r\n");
        return sb.toString();
    }


    private static String mapType(String sqlType) {
        if (sqlType.equals("bit"))
            return "boolean";
        if (sqlType.equals("tinyint"))
            return "byte";
        if (sqlType.equals("smallint"))
            return "short";
        if (sqlType.equals("int"))
            return "int";
        if (sqlType.equals("bigint"))
            return "long";
        if (sqlType.equals("float"))
            return "float";
        if (sqlType.equals("decimal") || sqlType.equals("numeric") || sqlType.equals("real") || sqlType
                .equals("money") || sqlType.equals("smallmoney"))
            return "double";
        if (sqlType.equals("varchar") || sqlType.equals("char") || sqlType.equals("nvarchar") || sqlType
                .equals("nchar") || sqlType.equals("text"))
            return "String";
        if (sqlType.equals("datetime")) {
            return "Date";
        }
        return "Object";
    }

    static void generate() {
        Connection conn = null;
        String sql = "SHOW TABLES";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String table = rs.getString(1);
                generate(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        generate();
    }
}


