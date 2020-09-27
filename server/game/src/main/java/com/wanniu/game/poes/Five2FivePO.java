package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import java.util.Date;

@DBTable("player_five2five")
public class Five2FivePO extends GEntity {
  public int score;
  
  public int winCount;
  
  public int tieCount;
  
  public int failCount;
  
  public int mvpCount;
  
  public int canReciveRewardCount;
  
  public Date lastChallengeTime;
  
  public int hasReciveRewardCount;
  
  public Date lastReciveRewardTime;
  
  public Date createTime;
  
  public Date updateTime;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\Five2FivePO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */