package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;

@DBTable("player_pk_data")
public class PlayerPKDataPO extends GEntity {
  public int pkModel;
  
  public int historyPkModel;
  
  public int pkValue;
  
  public int pkLevel;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\PlayerPKDataPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */