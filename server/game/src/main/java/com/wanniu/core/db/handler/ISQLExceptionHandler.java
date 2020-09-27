package com.wanniu.core.db.handler;

import java.sql.SQLException;

public interface ISQLExceptionHandler {
    void exceptionSQL(SQLException paramSQLException);

    void exceptionSQL(String paramString, Exception paramException);
}


