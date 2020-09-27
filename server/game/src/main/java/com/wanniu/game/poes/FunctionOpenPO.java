package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import java.util.List;
import java.util.Map;

@DBTable("player_func_open")
public class FunctionOpenPO extends GEntity {
  public Map<String, Integer> openMap;
  
  public Map<String, Integer> playMap;
  
  public List<Integer> functionAwards;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\FunctionOpenPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */