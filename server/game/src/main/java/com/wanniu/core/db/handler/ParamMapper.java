package com.wanniu.core.db.handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamMapper {
    void setParams(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException;
}


