package com.wanniu.core.db.handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RowReader {
  public void setParams(PreparedStatement pstmt) {}
  
  public abstract void mapRow(ResultSet paramResultSet) throws SQLException;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\RowReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */