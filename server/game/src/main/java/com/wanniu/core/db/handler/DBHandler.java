package com.wanniu.core.db.handler;

import com.wanniu.core.db.GDao;
import com.wanniu.core.logfs.Out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class DBHandler
        implements Runnable {
    private static Map<String, Boolean> TABLE_STATUS = new HashMap<>();

    private static ISQLExceptionHandler __exception__;


    public static void free(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        close(rs);
        close(pstmt);
        close(conn);
    }

    public static void free(ResultSet rs, CallableStatement cs, Connection conn) {
        close(rs);
        close(cs);
        close(conn);
    }

    protected static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static void close(CallableStatement cs) {
        if (cs != null) {
            try {
                cs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkTable(String tableName) {
        Boolean exist = TABLE_STATUS.get(tableName);
        if (exist != null && exist.booleanValue()) {
            return true;
        }
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            DatabaseMetaData metaData = conn.getMetaData();
            if (tableName.indexOf(".") > -1) {
                rs = metaData.getTables(tableName.substring(0, tableName.indexOf('.')), null, tableName
                        .substring(tableName.indexOf('.')), null);
            } else {
                rs = metaData.getTables(null, null, tableName, null);
            }
            if (rs.next()) {
                TABLE_STATUS.put(tableName, Boolean.valueOf(true));
                return true;
            }
        } catch (SQLException e) {
            Out.info(new Object[]{e});
        } finally {
            free(rs, (CallableStatement) null, conn);
        }
        return false;
    }

    public static void putTable(String tableName, boolean exist) {
        TABLE_STATUS.put(tableName, Boolean.valueOf(exist));
    }

    public static void createTable(String sql) {
        execute(sql);
    }


    public static void setExceptionHandler(ISQLExceptionHandler exceptionHandler) {
        __exception__ = exceptionHandler;
    }

    public static void exceptionSQL(String logName, Exception e) {
        if (__exception__ != null) {
            __exception__.exceptionSQL(logName, e);
        } else {
            Out.error(new Object[]{logName, e});
        }
    }

    public static void exceptionSQL(SQLException e) {
        if (__exception__ != null) {
            __exception__.exceptionSQL(e);
        } else {
            e.printStackTrace();
        }
    }

    public static int execute(String sql) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
        return -1;
    }


    public static int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            setParams(pstmt, args);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
        return -1;
    }


    public static int update(String sql, ParamMapper param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            param.setParams(pstmt, 0);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
        return -1;
    }


    public static int generated(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql, 1);
            setParams(pstmt, args);
            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return -1;
    }


    public static int generated(String sql, ParamMapper param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql, 1);
            param.setParams(pstmt, 0);
            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return -1;
    }


    public static int saveOrUpdate(ISaveOrUpdate iSaveOrUpdate) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(iSaveOrUpdate.getUpdateSQL());
            setParams(pstmt, iSaveOrUpdate.getUpdateParams());
            if (pstmt.executeUpdate() == 0) {
                close(pstmt);
                pstmt = conn.prepareStatement(iSaveOrUpdate.getSaveSQL());
                setParams(pstmt, iSaveOrUpdate.getSaveParams());
                return pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
        return 0;
    }


    public static void batchUpdate(String sql, List<Object[]> batch) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            for (Object[] par : batch) {
                setParams(pstmt, par);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
    }


    public static void batchUpdate(String sql, ParamMapper mapper, int size) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            for (int row = 0; row < size; row++) {
                mapper.setParams(pstmt, row);
                pstmt.addBatch();
                if (row % 500 == 0) {
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                }
            }
            if (size % 500 != 0) {
                pstmt.executeBatch();
                pstmt.clearBatch();
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free((ResultSet) null, pstmt, conn);
        }
    }


    public static <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args) {
        List<T> values = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getMaster();
            pstmt = conn.prepareStatement(sql);
            setParams(pstmt, args);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                values.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return values;
    }


    public static <T> List<T> query(String sql, RowMapper<T> rowMapper) {
        List<T> values = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            pstmt = conn.prepareStatement(sql);
            rowMapper.setParams(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                values.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return values;
    }


    public static void query(String sql, RowReader rowReader, Object... args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            pstmt = conn.prepareStatement(sql);
            setParams(pstmt, args);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rowReader.mapRow(rs);
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
    }


    public static void query(String sql, RowReader rowReader) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            pstmt = conn.prepareStatement(sql);
            rowReader.setParams(pstmt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rowReader.mapRow(rs);
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
    }

    public static int queryForInt(String sql, RowMapper<Integer> rowMapper) {
        Integer value = queryForObject(sql, rowMapper);
        return (value == null) ? 0 : value.intValue();
    }

    public static int queryForInt(String sql, RowMapper<Integer> rowMapper, Object... args) {
        Integer value = queryForObject(sql, rowMapper, args);
        return (value == null) ? 0 : value.intValue();
    }


    public static <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            pstmt = conn.prepareStatement(sql);
            setParams(pstmt, args);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rowMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return null;
    }


    public static <T> T queryForObject(String sql, RowMapper<T> rowMapper) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = GDao.getSlave();
            pstmt = conn.prepareStatement(sql);
            rowMapper.setParams(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rowMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            exceptionSQL(e);
        } finally {
            free(rs, pstmt, conn);
        }
        return null;
    }

    private static void setParams(PreparedStatement pstmt, Object[] args) throws SQLException {
        if (args == null)
            return;
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                pstmt.setInt(i + 1, ((Integer) args[i]).intValue());
            } else if (args[i] instanceof String) {
                pstmt.setString(i + 1, (String) args[i]);
            } else if (args[i] instanceof Byte) {
                pstmt.setByte(i + 1, ((Byte) args[i]).byteValue());
            } else if (args[i] instanceof Boolean) {
                pstmt.setByte(i + 1, (byte) (((Boolean) args[i]).booleanValue() ? 1 : 0));
            } else if (args[i] instanceof Short) {
                pstmt.setShort(i + 1, ((Short) args[i]).shortValue());
            } else if (args[i] instanceof Timestamp) {
                pstmt.setTimestamp(i + 1, (Timestamp) args[i]);
            } else if (args[i] instanceof Date) {
                pstmt.setDate(i + 1, new Date(((Date) args[i]).getTime()));
            } else if (args[i] instanceof Date) {
                pstmt.setDate(i + 1, new Date(((Date) args[i]).getTime()));
            } else if (args[i] instanceof Double) {
                pstmt.setDouble(i + 1, ((Double) args[i]).doubleValue());
            } else if (args[i] instanceof byte[]) {
                pstmt.setBytes(i + 1, (byte[]) args[i]);
            } else if (args[i] instanceof Long) {
                pstmt.setLong(i + 1, ((Long) args[i]).longValue());
            } else {
                if (args[i] != null) {
                    Out.warn(new Object[]{"暂未支持的持久化数据类型，请确认：", args[i].getClass()});
                }
                pstmt.setObject(i + 1, args[i]);
            }
        }
    }

    public static boolean supportsBatchUpdates(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        if (dbmd != null &&
                dbmd.supportsBatchUpdates()) {
            return true;
        }

        return false;
    }
}


