package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import java.util.Date;

@DBTable("player_leaderboard")
public class LeaderBoardPlayerPO extends GEntity {
  public int worShipTimes;
  
  public Date worShipTime;
  
  public int worShipDiamondTimes;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\LeaderBoardPlayerPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */