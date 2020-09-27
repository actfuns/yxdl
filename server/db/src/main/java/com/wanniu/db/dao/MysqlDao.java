package com.wanniu.db.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanniu.core.db.ModifyOperateType;
import com.wanniu.core.db.pool.DBFactory;
import com.wanniu.core.db.pool.DBSource;
import com.wanniu.core.logfs.Out;
import com.wanniu.core.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MysqlDao {
    public static int insert(String dsName, String dbName, String tableName, JSONObject entityJson) {
        try {
            DBSource ds = DBFactory.lookup(dsName);
            String sql = (String) ds.sqls.get("insert:" + tableName);
            List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
            if (sql == null) {
                sql = organizingInsertSql(tableName, fieldInfos);
                ds.sqls.put("insert:" + tableName, sql);
            }
            return executeModify(dsName, dbName, sql, tableName, ModifyOperateType.INSERT, fieldInfos, entityJson, null);
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{"通用插入、更新失败:表:【", tableName, "】", "; JSON【", entityJson.toJSONString(), "】"});

            return -1;
        }
    }


    public static int update(String dsName, String dbName, String tableName, JSONObject entityJson) {
        try {
            DBSource ds = DBFactory.lookup(dsName);
            String sql = (String) ds.sqls.get("update:" + tableName);
            List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
            if (sql == null) {
                sql = organizingUpdateSql(tableName, fieldInfos);
                ds.sqls.put("update:" + tableName, sql);
            }
            return executeModify(dsName, dbName, sql, tableName, ModifyOperateType.UPDATE, fieldInfos, entityJson, null);
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{"通用更新失败:表:【", tableName, "】", "; JSON【", entityJson.toJSONString(), "】"});

            return -1;
        }
    }


    public static void delete(String dsName, String dbName, String tableName, String modifyPKey) {
        try {
            DBSource ds = DBFactory.lookup(dsName);
            String sql = (String) ds.sqls.get("delete:" + tableName);
            List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
            if (sql == null) {
                sql = organizingDeleteSql(tableName, fieldInfos);
                ds.sqls.put("delete:" + tableName, sql);
            }
            executeModify(dsName, dbName, sql, tableName, ModifyOperateType.DELETE, fieldInfos, null, modifyPKey);
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{"通用删除失败:表:【", tableName, "】", "; priKey【", modifyPKey, "】"});
        }
    }


    public static String select(String dsName, String dbName, String tableName, JSONObject json) {
        if (!isTable(dsName, tableName)) {
            return null;
        }
        String sql = organizingQuerySql(tableName, json);
        return executeQuery(dsName, String.format(sql, new Object[]{dbName}), json);
    }


    public static String executeQuery(String dsName, String sql, JSONObject queryPKey) {
        JSONArray result = new JSONArray();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBSource dBSource = DBFactory.lookup(dsName);
            conn = dBSource.getConnection();
            ps = conn.prepareStatement(sql);
            if (queryPKey != null) {
                int i = 1;
                for (Object v : queryPKey.values()) {
                    ps.setObject(i++, v);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                JSONObject json = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    String fieldName = metaData.getColumnLabel(i);
                    Object value = rs.getObject(fieldName);
                    if (value instanceof byte[]) {
                        String valueStr = new String((byte[]) value, "UTF-8");
                        value = JSONObject.parse(valueStr);
                    }
                    json.put(fieldName, value);
                }
                result.add(json);
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
            Out.error(new Object[]{"【查询SQL】-->", sql, "; Query Key【", queryPKey, "】"});
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
        }
        return result.toJSONString();
    }


    private static int executeModify(String dsName, String dbName, String sql, String tableName, ModifyOperateType modifyOperate, List<FieldInfo> fieldInfos, JSONObject json, String modifyPKey) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            DBSource dBSource = DBFactory.lookup(dsName);
            conn = dBSource.getConnection();
            ps = conn.prepareStatement(String.format(sql, new Object[]{dbName}));
            for (int i = 0; i < fieldInfos.size(); i++) {
                FieldInfo fieldInfo = fieldInfos.get(i);
                String colType = fieldInfo.filedType;
                Object colValue = null;
                if (modifyOperate == ModifyOperateType.DELETE) {
                    colType = getPkeyType(dsName, tableName);
                    colValue = modifyPKey;
                } else {
                    colValue = json.get(fieldInfo.filedName);
                }

                int index = i + 1;
                if (colType.startsWith("tinyint")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setByte(index, ((Number) colValue).byteValue());
                } else if (colType.startsWith("smallint")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setShort(index, ((Number) colValue).shortValue());
                } else if (colType.startsWith("int") || colType.startsWith("Integer")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setInt(index, ((Number) colValue).intValue());
                } else if (colType.startsWith("float")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setFloat(index, ((Number) colValue).floatValue());
                } else if (colType.startsWith("varchar")) {
                    colValue = (colValue == null) ? "" : colValue;
                    ps.setString(index, (String) colValue);
                } else if (colType.startsWith("bigint")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setLong(index, ((Number) colValue).longValue());
                } else if (colType.startsWith("double")) {
                    colValue = (colValue == null) ? Integer.valueOf(0) : colValue;
                    ps.setDouble(index, ((Number) colValue).doubleValue());
                } else if (colType.startsWith("datetime")) {
                    colValue = (colValue == null) ? null : colValue;
                    if (colValue != null) {
                        Date newColValue = DateUtil.format((String) colValue, "yyyy-MM-dd HH:mm:ss");
                        ps.setTimestamp(index, new Timestamp(newColValue.getTime()));
                    } else {
                        ps.setTimestamp(index, (Timestamp) null);
                    }
                } else if (colType.startsWith("blob")) {
                    String val = null;
                    if (colValue != null && !"".equals(colValue)) {
                        val = JSONObject.toJSONString(colValue);
                    }
                    ps.setString(index, val);
                } else {
                    ps.setObject(index, colValue);
                }
                if (modifyOperate == ModifyOperateType.DELETE) {
                    break;
                }
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            Out.error(new Object[]{e});
            if (modifyOperate == ModifyOperateType.DELETE) {
                Out.error(new Object[]{"【删除】-->", sql, "; priKey【", modifyPKey, "】"});
            } else {
                Out.error(new Object[]{"【更新】-->", sql, "; JSON【", json.toJSONString(), "】"});
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
        }
        return -1;
    }

    private static Map<String, List<FieldInfo>> tableFieldInfos = new ConcurrentHashMap<>();

    public static boolean isTable(String dsName, String tableName) {
        DBSource dbSource = DBFactory.lookup(dsName);
        return dbSource.tables.contains(tableName);
    }


    private static List<FieldInfo> getFieldInfos(String dsName, String tableName) {
        List<FieldInfo> fieldInfos = tableFieldInfos.get(String.valueOf(dsName) + tableName);
        if (fieldInfos != null) {
            return fieldInfos;
        }
        fieldInfos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            DBSource dbSource = DBFactory.lookup(dsName);
            conn = dbSource.getConnection();
            ps = conn.prepareStatement("desc " + tableName);
            rs = ps.executeQuery();
            FieldInfo priInfo = null;
            while (rs.next()) {
                FieldInfo fieldInfo = new FieldInfo();
                fieldInfo.filedName = rs.getString("Field");
                fieldInfo.filedType = rs.getString("Type");
                fieldInfo.isPkey = "PRI".equalsIgnoreCase(rs.getString("Key"));
                if (fieldInfo.isPkey) {
                    priInfo = fieldInfo;
                    continue;
                }
                fieldInfos.add(fieldInfo);
            }

            if (priInfo != null) {
                fieldInfos.add(priInfo);
            }
        } catch (Exception e) {
            Out.error(new Object[]{e});
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Out.error(new Object[]{e});
                }
            }
        }
        tableFieldInfos.put(String.valueOf(dsName) + tableName, fieldInfos);
        return fieldInfos;
    }


    private static String organizingInsertSql(String tableName, List<FieldInfo> fieldInfos) {
        StringBuilder sql = new StringBuilder();
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (int i = 0; i < fieldInfos.size(); i++) {
            FieldInfo fieldInfo = fieldInfos.get(i);
            String fieldName = fieldInfo.filedName;
            keys.append(fieldName);
            values.append("?");
            if (i < fieldInfos.size() - 1) {
                keys.append(",");
                values.append(",");
            }
        }
        sql.append("INSERT INTO %s." + tableName);
        sql.append(" (" + keys.toString() + ") ");
        sql.append("VALUES (" + values.toString() + ")");
        return sql.toString();
    }


    private static String organizingUpdateSql(String tableName, List<FieldInfo> fieldInfos) {
        StringBuilder sql = new StringBuilder();
        StringBuilder cols = new StringBuilder();
        String pKey = "";
        for (int i = 0; i < fieldInfos.size(); i++) {
            FieldInfo fieldInfo = fieldInfos.get(i);
            String fieldName = fieldInfo.filedName;
            if (fieldInfo.isPkey) {
                pKey = fieldName;
            } else {
                cols.append(String.valueOf(fieldName) + "=?,");
            }
        }
        sql.append("UPDATE %s." + tableName + " SET ");
        sql.append(cols.substring(0, cols.length() - 1));
        sql.append(" WHERE ");
        sql.append(String.valueOf(pKey) + "=?");
        return sql.toString();
    }


    private static String organizingDeleteSql(String tableName, List<FieldInfo> fieldInfos) {
        StringBuilder sql = new StringBuilder();
        String pKey = "";
        for (int i = fieldInfos.size() - 1; i >= 0; i--) {
            FieldInfo fieldInfo = fieldInfos.get(i);
            if (fieldInfo.isPkey) {
                pKey = fieldInfo.filedName;
                break;
            }
        }
        sql.append("DELETE FROM %s." + tableName);
        sql.append(" WHERE ");
        sql.append(String.valueOf(pKey) + "=?");
        return sql.toString();
    }


    private static String organizingQuerySql(String tableName, JSONObject condition) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM %s.").append(tableName);
        if (condition == null) {
            return sql.toString();
        }
        sql.append(" WHERE ");
        boolean flag = false;
        for (String con : condition.keySet()) {
            if (flag) {
                sql.append(" AND ");
            }
            sql.append(con).append("=?");
            flag = true;
        }
        return sql.toString();
    }


    public static String getPkeyType(String dsName, String tableName) {
        FieldInfo fieldInfo = getPkeyField(dsName, tableName);
        if (fieldInfo != null) {
            return fieldInfo.filedType;
        }
        return "";
    }

    public static FieldInfo getPkeyField(String dsName, String tableName) {
        List<FieldInfo> fieldInfos = getFieldInfos(dsName, tableName);
        for (int i = fieldInfos.size() - 1; i >= 0; i--) {
            FieldInfo fieldInfo = fieldInfos.get(i);
            if (fieldInfo.isPkey) {
                return fieldInfo;
            }
        }
        return null;
    }
}


