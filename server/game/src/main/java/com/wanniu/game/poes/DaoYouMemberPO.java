package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import java.util.Date;
import java.util.Map;

public class DaoYouMemberPO extends GEntity {
  @DBField(isPKey = true, fieldType = "varchar", size = 50)
  public String playerId;
  
  public String daoYouId;
  
  public int totalSendRebate;
  
  public Map<String, Integer> todaySendRebate;
  
  public int totalReciveRebate;
  
  public int todayReciveRebate;
  
  public Date joinTime;
  
  public Date createTime;
  
  public Date updateTime;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\DaoYouMemberPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */