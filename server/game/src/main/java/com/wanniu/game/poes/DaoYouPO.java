package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.daoyou.DaoYouMessageVo;
import java.util.Date;
import java.util.List;

public class DaoYouPO extends GEntity {
  @DBField(isPKey = true, fieldType = "varchar", size = 50)
  public String id;
  
  public String adminPlayerId;
  
  public String name;
  
  public int fightPower;
  
  public String notice;
  
  public int isEditedDyName;
  
  public Date lastEditNameTime;
  
  public List<DaoYouMessageVo> messages;
  
  public Date createTime;
  
  public Date updateTime;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\DaoYouPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */