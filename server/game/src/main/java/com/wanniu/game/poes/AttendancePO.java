package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import java.util.Date;
import java.util.Map;

@DBTable("player_sign")
public final class AttendancePO extends GEntity {
  public int stage;
  
  public Date lastSignTime;
  
  public Date lastLuxuryTime;
  
  public int luxuryState;
  
  public Map<Integer, Integer> signMap;
  
  public Map<Integer, Integer> cumulativeMap;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\AttendancePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */