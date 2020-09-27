package com.wanniu.core.db.handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RowMapper<T> {
  public void setParams(PreparedStatement pstmt) {}
  
  public abstract T mapRow(ResultSet paramResultSet) throws SQLException;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\RowMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */