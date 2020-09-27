package com.wanniu.core.db.handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RowMapper<T> {
    public void setParams(PreparedStatement pstmt) {
    }

    public abstract T mapRow(ResultSet paramResultSet) throws SQLException;
}


