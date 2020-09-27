package com.wanniu.game.poes;

import com.wanniu.core.game.entity.GEntity;
import com.wanniu.game.DBTable;
import com.wanniu.game.equip.RedPointBean;
import java.util.List;

@DBTable("player_redpoint")
public class RedPointPO extends GEntity {
  public List<RedPointBean> list;
}


/* Location:              D:\Yxdl\xmds-server\mmoarpg-game.jar!\com\wanniu\game\poes\RedPointPO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */