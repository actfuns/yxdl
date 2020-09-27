package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBField;
import com.wanniu.game.five2Five.Five2FivePlayerResultInfoVo;
import java.util.Date;
import java.util.Map;

public class Five2FivePlayerBtlReportPO extends GEntity {
  @DBField(isPKey = true, fieldType = "varchar", size = 50)
  public String id;
  
  public String playerId;
  
  public int status;
  
  public int scoreChange;
  
  public Map<String, Five2FivePlayerResultInfoVo> resultInfoA;
  
  public Map<String, Five2FivePlayerResultInfoVo> resultInfoB;
  
  public Date createTime;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\Five2FivePlayerBtlReportPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */