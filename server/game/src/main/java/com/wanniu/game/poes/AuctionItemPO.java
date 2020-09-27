package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.item.po.PlayerItemPO;
import java.time.LocalDateTime;
import java.util.Set;

public class AuctionItemPO extends GEntity {
  @DBField(isPKey = true, fieldType = "varchar", size = 50)
  public String id;
  
  public PlayerItemPO db;
  
  public int state;
  
  public LocalDateTime stateOverTime;
  
  public int curPrice;
  
  public int nextPrice;
  
  public int maxPrice;
  
  public String guildId;
  
  public String playerId;
  
  public int diamond;
  
  public int ticket;
  
  public Set<String> participant;
  
  public String source;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\AuctionItemPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */