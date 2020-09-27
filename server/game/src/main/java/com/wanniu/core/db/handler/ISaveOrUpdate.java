package com.wanniu.core.db.handler;

public interface ISaveOrUpdate {
  String getSaveSQL();
  
  Object[] getSaveParams();
  
  String getUpdateSQL();
  
  Object[] getUpdateParams();
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\core\db\handler\ISaveOrUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */