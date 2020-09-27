package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.item.po.PlayerItemPO;

public class ConsignmentItemsPO extends GEntity {
  @DBField(isPKey = true, fieldType = "varchar", size = 50)
  public String id;
  
  public int itemType;
  
  public int pro;
  
  public int itemSecondType;
  
  public int level;
  
  public int consignmentPrice;
  
  public long consignmentTime;
  
  public int lateMinutes;
  
  public String consignmentPlayerName;
  
  public int consignmentPlayerPro;
  
  public String consignmentPlayerId;
  
  public int groupCount;
  
  public int publishTimes;
  
  public PlayerItemPO db;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\ConsignmentItemsPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */