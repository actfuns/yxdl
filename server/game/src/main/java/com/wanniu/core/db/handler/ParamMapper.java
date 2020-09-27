package com.wanniu.core.db.handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamMapper {
  void setParams(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\ParamMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */