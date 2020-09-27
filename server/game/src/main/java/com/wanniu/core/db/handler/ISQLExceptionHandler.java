package com.wanniu.core.db.handler;

import java.sql.SQLException;

public interface ISQLExceptionHandler {
  void exceptionSQL(SQLException paramSQLException);
  
  void exceptionSQL(String paramString, Exception paramException);
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\ISQLExceptionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */